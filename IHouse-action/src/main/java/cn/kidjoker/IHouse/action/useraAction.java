/** work for life!
 * 
 */
package cn.kidjoker.IHouse.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class useraAction {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户注册
	 */
	@ResponseBody
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public void register(@RequestBody User user) {
		
	}
	
	/**
	 * 用户登录
	 */
	@ResponseBody
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public void login(@RequestBody User user) {
		
	}
}
