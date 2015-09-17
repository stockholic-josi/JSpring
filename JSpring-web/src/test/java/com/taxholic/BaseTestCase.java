package com.taxholic;

import javax.annotation.Resource;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.taxholic.configuration.beens.AnnotationConfiguration;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AnnotationConfiguration.class)
//@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
//@Transactional
public class BaseTestCase extends Assert {
	
	protected static Logger logger = LoggerFactory.getLogger(BaseTestCase.class);
	
	@Autowired
	protected ApplicationContext context;
	
	@Autowired
	private MessageSourceAccessor message;
	
	@AfterClass
	public static void testDown() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void dummy() {
		
	
//		System.out.println(">>>>" + message.getMessage("board.filePath"));
//		this.testServce.insert();
//		System.out.println(">>>>>" + this.testServce.select().size()); 
	
	}
}
