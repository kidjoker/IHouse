/** work for life!
 * 
 */
package cn.kidjoker.IHouse.api.vo;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author kidjoker
 *
 * @date 2017年8月14日 
 */
public class registerRequestVo {
	
	/** 用户姓名 */
	@Length(max = 10, message="user.name")
	private String name;
	
	/** mobile */
	@Length(max = 11, message="user.mobile")
	private String mobile;
	
	/** 时间 */
	private Date date;
	
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
}
