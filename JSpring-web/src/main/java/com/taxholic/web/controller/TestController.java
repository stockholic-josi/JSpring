package com.taxholic.web.controller;


import javax.annotation.Resource;


import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test/*.do")
public class TestController{
	
	@Resource
	private MessageSourceAccessor message;
	
	
	@RequestMapping
	@ResponseBody
	public String logging() {
		
		System.out.println("----> " + message.getMessage("stockChart.filePath"));
		
		return "gggg";
		
	} 
		
		
}