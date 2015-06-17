package com.taxholic.web.test.service;


import java.util.Date;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taxholic.core.web.dao.CommonDao;


@Service
public class TestService{
	
	@Autowired
	private CommonDao dao;
	
	
	public String getSelect(){
		
		String gg = dao.getString("board.selectBoardCount");
		
		return gg;
	}
	
//	public void schedule(){
//		System.out.println(".........................." + new Date());
//	}
//	
//	public int insert(EncryptTest et){
//		return this.dao.insert("front.board.roomInsert", et);
//	}
//	
//	public EncryptTest select(){
//		return (EncryptTest) this.dao.getObject("front.board.getRoomPassword");
//	}
//	
//	public String noCashe(){
//		return this.dao.getString("front.sqlite.getTime");
//		
//	}
//	
//	@Cacheable(value="getTime")
//	public String cashe(){
//		return this.dao.getString("front.sqlite.getTime");
//	}
	
}
