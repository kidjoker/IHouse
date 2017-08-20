/** work for life!
 * 
 */
package cn.kidjoker.IHouse.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

/**
 * @author kidjoker
 *
 * @date 2017年8月20日 
 */
public class Dateformatter implements Formatter<Date> {
	
	private String datePattern;
	private SimpleDateFormat sdf = null;
	
	public Dateformatter(String datePattern) {
		this.datePattern = datePattern;
		sdf = new SimpleDateFormat(datePattern);
		sdf.setLenient(false);
	}
	
	@Override
	public String print(Date date, Locale locale) {
		return sdf.format(date);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		try {
			return sdf.parse(text);
		}
		catch (ParseException e) {
			throw new IllegalArgumentException("Invalid date format");
		}
	}

}
