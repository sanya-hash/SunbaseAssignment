package com.sunbasedata.records.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sunbasedata.records.entity.Jwt;
import com.sunbasedata.records.entity.User;
import com.sunbasedata.records.service.LoginService;



@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value="/welcome",method = RequestMethod.POST)
	public ModelAndView login(
			@RequestParam("login_id") String login_id,
			@RequestParam("password") String password,
			HttpServletRequest req,Model model) {
		String msg="";
		boolean success=false;
		User user = new User(login_id,password);
		
		HttpSession session=req.getSession();
		Jwt jwt = new Jwt();
	    jwt = this.loginService.loginUser(user);
	    String token = jwt.getAccess_token();
	    session.setAttribute("token", token);
	    return new ModelAndView("welcome");
	}
	@RequestMapping(value="/logout")
	public String logoutUser(HttpServletRequest req) {
		HttpSession session=req.getSession();
		session.invalidate();
		return "login";
	}
	
}
