package br.com.deivisondfs2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.deivisondfs2.validation.LoginServiceValidation;

@Controller
@RequestMapping(value = "/")
@SessionAttributes("name")
public class WelcomeController {
	
	@Autowired
	LoginServiceValidation userValidation;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showLoginPage(ModelMap map) {
		map.put("name", "deivisondfs2");
		return "welcome";
	}
	
	
	
}
