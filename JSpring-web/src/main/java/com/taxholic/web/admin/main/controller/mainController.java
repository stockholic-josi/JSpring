package com.taxholic.web.admin.main.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taxholic.core.authority.AuthDto;

@Controller
@RequestMapping("/admin")
public class mainController{
	
	
	@RequestMapping(value = "main.do")
	public String main(AuthDto user) {
		
		System.out.println(">>>>>>>>>>>><<>>>>>>>>>" + user);
		
		return "manager:admin/main";
	} 
	
	
	
}