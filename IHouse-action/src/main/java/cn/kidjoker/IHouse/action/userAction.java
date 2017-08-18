/** work for life!
 * 
 */
package cn.kidjoker.IHouse.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.kidjoker.IHouse.api.vo.registerRequestVo;
import cn.kidjoker.IHouse.model.UploadFile;
import cn.kidjoker.IHouse.model.User;
import cn.kidjoker.IHouse.service.UploadService;
import cn.kidjoker.IHouse.service.UserService;

/**
 * 用户相关服务 控制器
 * @author kidjoker
 *
 * @date 2017年8月14日 
 */
@Controller
@RequestMapping(value="/user")
public class userAction {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UploadService uploadService;
	/**
	 * 处理用户注册信息
	 */
	@RequestMapping(value="/saveRegisterInfo",method={RequestMethod.POST,RequestMethod.GET})
	public void showRegisterInfo(@Validated registerRequestVo requestVo) {
		
		//组织数据
		User user = new User();
		user.setMobile(requestVo.getMobile());
		user.setName(requestVo.getName());
		
		UploadFile file = new UploadFile();
		file.setFiles(requestVo.getFiles());
		
		userService.saveUserBaseInfo(user);
		
		userService.saveDataToOss(requestVo.getFiles(),requestVo.getMobile() + requestVo.getName());
		
		uploadService.upload(file);
	}
	
	/**
	 * 用户登录
	 */
	@RequestMapping(value="/login",method={RequestMethod.POST,RequestMethod.GET})
	public String login(@RequestBody User user) {
		return null;
	}
	
}
