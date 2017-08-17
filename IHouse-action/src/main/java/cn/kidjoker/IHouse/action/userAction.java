/** work for life!
 * 
 */
package cn.kidjoker.IHouse.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;

import cn.kidjoker.IHouse.api.vo.registerRequestVo;
import cn.kidjoker.IHouse.model.User;
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
	
	
	/**
	 * 用户注册
	 */
	@RequestMapping(value="/showRegister",method={RequestMethod.POST,RequestMethod.GET})
	public String showRegister() {
		return "register";
	}
	
	/**
	 * 处理用户注册信息
	 */
	@RequestMapping(value="/saveRegisterInfo",method={RequestMethod.POST,RequestMethod.GET})
	public void showRegisterInfo(registerRequestVo requestVo) {
		
		//组织数据
		User user = new User();
		user.setMobile(requestVo.getMobile());
		user.setName(requestVo.getName());
		
		userService.saveUserBaseInfo(user);
		
		userService.saveDataToOss(requestVo.getImage(),requestVo.getMobile() + requestVo.getName());
	}
	
	/**
	 * 用户登录
	 */
	@RequestMapping(value="/login",method={RequestMethod.POST,RequestMethod.GET})
	public String login(@RequestBody User user) {
		return null;
	}
	
}
