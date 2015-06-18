package com.taxholic.web.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taxholic.web.test.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController{
	
	@Autowired
	private MessageSourceAccessor message;
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	@ResponseBody
	public String login() {
		 return "";
	} 
	
	@RequestMapping(value = "/getMsg.do", method = RequestMethod.GET)
	@ResponseBody
	public String getMsg() {
		return  message.getMessage("stockChart.filePath");
		
	} 
	
	@RequestMapping(value = "/getId.do", method = RequestMethod.GET)
	@ResponseBody
	public String getId() {
		return  testService.getId();
	} 
	
	@RequestMapping(value = "/insertRole.do", method = RequestMethod.GET)
	@ResponseBody
	public String insertRole() {
		 testService.insertRole();
		 return "";
	} 
		
		
}