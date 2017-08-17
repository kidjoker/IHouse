/** work for life!
 * 
 */
package cn.kidjoker.IHouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.kidjoker.IHouse.alioss.client.OssClient;
import cn.kidjoker.IHouse.base.service.impl.BaseServiceImpl;
import cn.kidjoker.IHouse.dao.UserDao;
import cn.kidjoker.IHouse.model.User;
import cn.kidjoker.IHouse.service.UserService;

/**
 * @author kidjoker
 *
 * @date 2017年8月14日 
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserDao> implements UserService {

	@Autowired
	private UserDao baseDao;
	
	@Autowired
	private OssClient ossClient;
	
	@Override
	public UserDao getDao() {
		return baseDao;
	}
	
	@Override
	public void saveUserBaseInfo(User user) {
		add(user);
	}

	@Override
	public void login(User user) {
		
	}

	@Override
	public void saveDataToOss(MultipartFile image,String picName) {
		ossClient.doImageUpload(image,picName);
	}

}
