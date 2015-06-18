package com.taxholic.web.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taxholic.core.authority.AuthUtil;
import com.taxholic.web.test.service.TestService;

@Controller
@RequestMapping("/")
public class MemberController{
	
	@Autowired
	private MessageSourceAccessor message;
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public String index() {
		return "index";
	} 
	
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	@ResponseBody
	public String login() {
		 return "";
	} 
	
	@RequestMapping(value = "/admin/info.do", method = RequestMethod.GET)
	public String info(Model model) {
		
		System.out.println(">>>>>> " + AuthUtil.getUser().getUserId());
		
		return "manager:admin/info";
		
	}	
}