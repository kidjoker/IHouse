/** work for life!
 * 
 */
package cn.kidjoker.IHouse.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @author kidjoker
 *
 * @date 2017年8月20日 
 */
public class StringToDateConverter implements Converter<String, Date> {
	
	private String datePattern;
	
	public StringToDateConverter(String datePattern) {
		this.datePattern = datePattern;
	}

	@Override
	public Date convert(String source) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
			sdf.setLenient(false);
			return sdf.parse(source);
		}
		catch (ParseException e) {
			throw new IllegalArgumentException("invalid date format.");
		}
	}
	
}
