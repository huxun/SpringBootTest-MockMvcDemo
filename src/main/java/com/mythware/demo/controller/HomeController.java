package com.mythware.demo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mythware.demo.pojo.Login;

@RestController
@RequestMapping("")
public class HomeController {

	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody Login login) {
		if ("admin".equals(login.getAccount()) && "12345".equals(login.getPassword())) {
			return "login successful";
		} else {
			return "login fail";
		}
	}
}
