package cn.kidjoker.IHouse.alioss.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;

/**
 * <p>
 * OPay
 * </p>
 *
 * @author jinzhijie
 * @version 1.0.0
 * @since 1.0.0
 * @createTime 2017年8月16日 -下午6:00:15
 */
@Service
public class OssClient {
	
	private static final Log logger = LogFactory.getLog(OssClient.class);
	//oss 接入点
	private String endpoint = "oss-cn-hongkong.aliyuncs.com";
	
	//服务验证
	private String accessKeyId = "LTAINOYKhov9BWHg";
	private String accessKeySecret = "xDJeHmjazVdU9zZB1aIm4cAF2IrUGm";
	
	private OSSClient client = null;
	
	public OssClient() {
		doInit();
	}
	
	//初始化配置
	public void doInit(){
		//自定义配置oss
		client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}
	
	//使用oss
	public void doFileUpload(List<MultipartFile> files,String fileName) {
		try {
			//设置文件类型
			ObjectMetadata metadata = new ObjectMetadata();
			for(MultipartFile file : files) {
				metadata.setContentType(file.getContentType());
				metadata.setContentLength(file.getSize());
				
				String ss = file.getOriginalFilename();
				client.putObject("kidjoker", ss , file.getInputStream(), metadata);
			}
		} 
		catch (IOException e) {
			logger.error("上传图片异常,上传时间: " + new Date() + e.getMessage());
		}
		catch(OSSException e) {
			logger.error("oss服务端异常" + new Date() + e.getMessage());
		}
		catch (ClientException e) {
			logger.error("oss客户端异常" + new Date() + e.getMessage());
		}
		finally {
			this.doDestroy();
		}
	}
	
	public void doFileDownload(){
		try {
			
			//从oss获取输入流并封装成buffer字节流
			OSSObject object = client.getObject("kidjoker", "16 - 1.jpg");
			InputStream is = object.getObjectContent();
			ImageInputStream iis = ImageIO.createImageInputStream(is);
			
			byte[] buf = new byte[(int)object.getObjectMetadata().getContentLength()];
			iis.read(buf);
			
			//使用文件输出流进行拷贝
			FileOutputStream fos = new FileOutputStream(new File("d:\\aa.jpg"));
			
			ImageOutputStream ios = ImageIO.createImageOutputStream(fos);
			ios.write(buf);
			
		} 
		catch (IOException e) {
			logger.error("下载图片异常,下载时间: " + new Date() + e.getMessage());
		}
		catch(OSSException e) {
			logger.error("oss服务端异常" + new Date() + e.getMessage());
		}
		catch (ClientException e) {
			logger.error("oss客户端异常" + new Date() + e.getMessage());
		}
		finally {
			this.doDestroy();
		}
	}
	
	//关闭oss
	public void doDestroy() {
		client.shutdown();
	}
	
	public static void main(String[] args) {
		OssClient client = new OssClient();
		client.doFileDownload();
	}
}
