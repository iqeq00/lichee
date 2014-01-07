package org.lichee.simple.example.web.mvc;

import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * @author lynch
 */
public class BindingInitializer implements WebBindingInitializer {

	public void initBinder(WebDataBinder binder, WebRequest request) {
		
		binder.registerCustomEditor(Date.class, new DateTypeEditor());
		binder.registerCustomEditor(int.class, new IntTypeSupport());
	}
}