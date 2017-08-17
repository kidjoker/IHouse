package cn.kidjoker.IHouse.alioss.client;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
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
	public void doImageUpload(MultipartFile image,String picName) {
		try {
			//设置文件类型
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentType("image/jpeg");
			metadata.setContentLength(image.getSize());
			
			client.putObject("ihouseuserpic", picName + ".jpg", image.getInputStream(), metadata);
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
	
	public void doImageDownload(){
		
	}
	
	//关闭oss
	public void doDestroy() {
		client.shutdown();
	}
}
