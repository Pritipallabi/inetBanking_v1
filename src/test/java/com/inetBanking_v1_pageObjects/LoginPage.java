package com.inetBanking_v1_pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.innetBanking_testCases.Base;

public  class LoginPage {
	public static WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	By username=By.name("uid");
	By password=By.name("password");
	By login=By.name("btnLogin");
	By logout=By.xpath("/html/body/div[3]/div/ul/li[15]/a");
	
	public void setusername(String uname) {
		driver.findElement(username).sendKeys(uname);
		
	}
	public void setpwd(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	
	}
	
	public void Login_click() {
		
		driver.findElement(login).click();
	}
	public void clickLogout()
	{
		driver.findElement(logout).click();
	}

}
