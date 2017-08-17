/** work for life!
 * 
 */
package cn.kidjoker.IHouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.kidjoker.IHouse.alioss.client.OssClient;
import cn.kidjoker.IHouse.model.User;
import cn.kidjoker.IHouse.service.UserService;

/**
 * @author kidjoker
 *
 * @date 2017年8月14日 
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private OssClient ossClient;
	
	@Override
	public void register(User user) {
		
	}

	@Override
	public void login(User user) {
		
	}

	@Override
	public void saveDataToOss(MultipartFile image) {
		ossClient.doService(image);
	}

}
