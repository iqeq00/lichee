package org.lichee.simple.example.web.mvc;


import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

/**
 * @author lynch
 */
public class DateTypeEditor extends PropertyEditorSupport {
	
	public static final DateFormat DF_LONG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final DateFormat DF_SHORT = new SimpleDateFormat("yyyy-MM-dd");
	public static final int SHORT_DATE = 10;

	public void setAsText(String text) throws IllegalArgumentException {
		text = text.trim();
		if (!StringUtils.hasText(text)) {
			setValue(null);
			return;
		}
		try {
			if (text.length() <= SHORT_DATE) {
				setValue(new Date(DF_SHORT.parse(text).getTime()));
			} else {
				setValue(new Date(DF_LONG.parse(text).getTime()));
			}
		} catch (ParseException ex) {
			IllegalArgumentException iae = new IllegalArgumentException(
					"Could not parse date: " + ex.getMessage());
			iae.initCause(ex);
			throw iae;
		}
	}

	public String getAsText() {
		
		Date value = (Date) getValue();
		return (value != null ? DF_LONG.format(value) : "");
	}
}
