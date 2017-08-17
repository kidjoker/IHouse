/** work for life!
 * 
 */
package cn.kidjoker.IHouse.service;

import org.springframework.web.multipart.MultipartFile;

import cn.kidjoker.IHouse.model.User;

/**
 * @author kidjoker
 *
 * @date 2017年8月14日 
 */
public interface UserService {
	
	/**
	 * 用户注册
	 */
	public void register(User user);
	
	/**
	 * 用户登录
	 */
	public void login(User user);
	
	/**
	 * 保存数据到oss
	 */
	public void saveDataToOss(MultipartFile image);
}
