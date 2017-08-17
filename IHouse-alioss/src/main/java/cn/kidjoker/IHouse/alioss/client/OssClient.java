/*
 * ================================================================
 * Copyright 2008-2017 Everelegance.
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Everelegance Corp. Ltd, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Everelegance.
 * 
 * OPay项目组
 *
 * ================================================================
 *  创建人: jinzhijie
 *	创建时间: 2017年8月16日 - 下午6:00:15
 */
package cn.kidjoker.IHouse.alioss.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientConfiguration;
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
	
	private ClientConfiguration config = null;
	private OSSClient client = null;
	
	public OssClient() {
		doInit();
	}
	
	//初始化配置
	public void doInit(){
		//自定义配置oss
		config = new ClientConfiguration();
		client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}
	
	//使用oss
	public void doService(MultipartFile image) {
		try {
			client.putObject("kidjoker", "hello.jpg", new ByteArrayInputStream(image.getBytes()));
		} catch (OSSException | ClientException | IOException e) {
			logger.error("上传图片异常");
		}
		finally {
			this.doDestroy();
		}
	}
	
	//关闭oss
	public void doDestroy() {
		client.shutdown();
	}
}
