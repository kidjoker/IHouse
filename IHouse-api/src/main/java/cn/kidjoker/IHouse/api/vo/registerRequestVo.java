/** work for life!
 * 
 */
package cn.kidjoker.IHouse.api.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author kidjoker
 *
 * @date 2017年8月14日 
 */
public class registerRequestVo {
	
	/** 用户姓名 */
	private String name;
	
	/** mobile */
	private String mobile;
	
	/** 头像 */
	private MultipartFile image;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
}
