package com.innetBanking_testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking_v1_pageObjects.AddCustomerPage;
import com.inetBanking_v1_pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends Base{
	
@Test
public void addNewCustome() throws InterruptedException, IOException {
	LoginPage lp = new LoginPage(driver);
	lp.setusername(username);
	log.info("User name is provided");
	lp.setpwd(password);
	log.info("Passsword is provided");
	lp.Login_click();
	
	Thread.sleep(3000);
	
	AddCustomerPage customer = new AddCustomerPage(driver);
	customer.clickAddNewCustomer();
	log.info("Providing customer details");
	
	customer.custName("Pavan");
	customer.custgender("male");
	customer.custdob("10","15","1985");
	Thread.sleep(5000);
	customer.custaddress("INDIA");
	customer.custcity("HYD");
	customer.custstate("AP");
	customer.custpinno("5000074");
	customer.custtelephoneno("987890091");
	
	String email=randomestring()+"@gmail.com";
	customer.custemailid(email);
	customer.custpassword("abcdef");
	
	customer.custsubmit();
	boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	
	if(res==true)
	{
		Assert.assertTrue(true);
		log.info("test case passed....");
		
	}
	else
	{
		log.info("test case failed....");
		captureScreen(driver,"addNewCustomer");
		Assert.assertTrue(false);
	}
}
	
	
	
	
	
	
	
}
