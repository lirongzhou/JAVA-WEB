package com.mantoto.contorller.test.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

//@ContextConfiguration(locations = { "file:WebContent/WEB-INF/applicationContext.xml",
//		"file:WebContent/WEB-INF/rest-servlet.xml" })

//@ContextConfiguration(locations = { "file:WebContent/WEB-INF/applicationContext.xml",
//"file:WebContent/WEB-INF/rest-servlet.xml" })

@ContextConfiguration(locations = { "file:src/main/Webapp/WEB-INF/applicationContext.xml",
"file:src/main/Webapp/WEB-INF/rest-servlet.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

//@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class BaseControllerTest extends AbstractTransactionalJUnit4SpringContextTests {

}