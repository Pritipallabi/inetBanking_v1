package com.innetBanking_testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking_v1_pageObjects.LoginPage;

public class TC_loginTest_001 extends Base {
	
	

	public TC_loginTest_001() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void loginTest() throws IOException {
		
		log.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setusername(username);
		log.info("Enter username");
		lp.setpwd(password);
		log.info("Enter password");
		lp.Login_click();
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			log.info("Login test passed");
			
		}
		else 
			captureScreen( driver, "loginTest");
			Assert.assertTrue(false);
		log.info("Login test failed");
	}

	

	

}
