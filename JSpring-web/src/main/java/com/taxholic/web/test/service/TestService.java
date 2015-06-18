package com.taxholic.web.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taxholic.core.web.dao.CommonDao;


@Service
public class TestService{
	
	@Autowired
	private CommonDao dao;
	
	
	public String getId(){
		
		return dao.getString("auth.selectId");
	}
	
	@Transactional
	public void insertRole(){
		
		dao.insert("auth.insertRole");

//		String[] aa = null;
//		System.out.print(aa.length);
		
	}
	
	
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
