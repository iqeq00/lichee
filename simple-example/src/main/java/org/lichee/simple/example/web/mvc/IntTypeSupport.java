package org.lichee.simple.example.web.mvc;

import java.beans.PropertyEditorSupport;
import org.springframework.util.StringUtils;

/**
 * @author lynch
 */
public class IntTypeSupport extends PropertyEditorSupport {

	public void setAsText(String text) throws IllegalArgumentException {

		if (text == null || text.equals(""))
			text = "0";
		if (!StringUtils.hasText(text)) {
			setValue(null);
		} else {
			setValue(Integer.parseInt(text));
		}
	}

	public String getAsText() {
		
		return getValue().toString();
	}
}
