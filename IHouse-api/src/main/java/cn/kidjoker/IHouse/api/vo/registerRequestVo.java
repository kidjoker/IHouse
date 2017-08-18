/** work for life!
 * 
 */
package cn.kidjoker.IHouse.api.vo;

import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author kidjoker
 *
 * @date 2017年8月14日 
 */
public class registerRequestVo {
	
	/** 用户姓名 */
	@Size(max = 10)
	private String name;
	
	/** mobile */
	private String mobile;
	
	/** 头像 */
	private List<MultipartFile> files;

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

	
	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
}
