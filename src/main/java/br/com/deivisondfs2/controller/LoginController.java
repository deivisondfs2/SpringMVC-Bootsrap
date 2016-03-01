package br.com.deivisondfs2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.deivisondfs2.service.UserService;

@Controller
@RequestMapping(value = "/login")
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	UserService userValidation;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String postLoginPage(ModelMap modelMap, @RequestParam String name, @RequestParam String password){
		
		String retorno = "login";
		
		if (userValidation.isValidUser(name, password)) {
			modelMap.put("name", name);
			modelMap.put("password", password);
			
			retorno = "welcome";
		}
		
		modelMap.put("errorMessage", "Login ou senha incorretos!!");
		
		return retorno;
	}
}
