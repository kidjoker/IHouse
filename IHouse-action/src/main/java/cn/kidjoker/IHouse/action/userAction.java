/** work for life!
 * 
 */
package cn.kidjoker.IHouse.action;

import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.kidjoker.IHouse.api.vo.registerRequestVo;
import cn.kidjoker.IHouse.model.UploadFile;
import cn.kidjoker.IHouse.model.User;
import cn.kidjoker.IHouse.service.UploadService;
import cn.kidjoker.IHouse.service.UserService;
import cn.kidjoker.IHouse.validator.UserValidator;

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

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserValidator validator;
	
	/**
	 * 处理用户注册信息
	 * @throws Exception 
	 */
	@RequestMapping(value="/saveRegisterInfo",method={RequestMethod.POST,RequestMethod.GET})
	public String showRegisterInfo(@Valid registerRequestVo requestVo,BindingResult bindingResult) throws Exception {
		
		final Log logger = LogFactory.getLog(userAction.class);
		
		validator.validate(requestVo, bindingResult);
		
		if(bindingResult.hasErrors()) {
			logger.error(messageSource.getMessage(bindingResult.getFieldError().getDefaultMessage(), null, Locale.CHINA));
			return "register";
		}
		
		//组织数据
		User user = new User();
		user.setMobile(requestVo.getMobile());
		user.setName(requestVo.getName());
		
		UploadFile files = new UploadFile();
		files.setFiles(requestVo.getFiles());
		
		userService.saveUserBaseInfo(user);
		
		userService.saveDataToOss(requestVo.getFiles(),requestVo.getMobile() + requestVo.getName());
		
		uploadService.upload(files);
		
		return "home";
	}
	
	/**
	 * 用户登录
	 */
	@RequestMapping(value="/login",method={RequestMethod.POST,RequestMethod.GET})
	public String login(@RequestBody User user) {
		return null;
	}
	
}
