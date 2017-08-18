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
 *	创建时间: 2017年8月18日 - 下午6:08:03
 */
package cn.kidjoker.IHouse.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.kidjoker.IHouse.model.UploadFile;
import cn.kidjoker.IHouse.service.UploadService;

/**
 * <p>
 * OPay
 * </p>
 *
 * @author jinzhijie
 * @version 1.0.0
 * @since 1.0.0
 * @createTime 2017年8月18日 -下午6:08:03
 */
@Service
public class UploadFileImpl implements UploadService {

	@Override
	public void upload(UploadFile file) {
		List<MultipartFile> multipartFiles = file.getFiles();
		
		for (MultipartFile multipartFile : multipartFiles) {
			String fileName = multipartFile.getOriginalFilename();
			
			try {
				File fileNew = new File("d:\\" + fileName);
				multipartFile.transferTo(fileNew);
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
