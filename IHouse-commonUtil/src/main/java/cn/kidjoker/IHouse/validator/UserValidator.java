/** work for life!
 * 
 */
package cn.kidjoker.IHouse.validator;

import java.util.jar.Attributes.Name;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cn.kidjoker.IHouse.api.vo.registerRequestVo;

/**
 * @author kidjoker
 *
 * @date 2017年8月20日 
 */
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return registerRequestVo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		registerRequestVo requestVo = (registerRequestVo) target;
		
		if(requestVo.getName().equals("123")) {
			errors.rejectValue("name", null, "user.name.invalid");
		}
	}

}
