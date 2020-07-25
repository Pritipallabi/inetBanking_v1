package com.innetBanking_testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.ss.usermodel.ExcelStyleDateFormatter;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking_testUtilities.Excelutilities;
import com.inetBanking_v1_pageObjects.LoginPage;

public class TC_LoginDDT_002 extends Base{
	
 @Test(dataProvider = "LoginData")
 
 public void loginDDT(String uname,String pwd) throws InterruptedException {
	 
	 LoginPage lp = new LoginPage(driver);
	 lp.setusername(uname);
	 log.info("Username provide");
	 lp.setpwd(pwd);
	 log.info("password provide");
	 lp.Login_click();
	 if(isAlertPresent()==true) {
		 driver.switchTo().alert().accept();
		 driver.switchTo().defaultContent();
		 Assert.assertTrue(false);
		 log.info("Login failed");
		 
	 }
	 else {
		 Assert.assertTrue(true);
		 lp.clickLogout();
		 Thread.sleep(3000);
		 log.info("Login passed");
		 driver.switchTo().alert().accept();
		 driver.switchTo().defaultContent();
		 log.info("Login passed");
	 }
	 
 }
 
 public boolean isAlertPresent() {
	 try {
	 driver.switchTo().alert();
	return true;
	 }catch (NoAlertPresentException e) {
		
		 return false;
	}
 }
 @DataProvider(name="LoginData")
 
 public String[][] getda() throws IOException {
	// TODO Auto-generated method stub
	 
	 String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetBanking_testData\\LoginData.xlsx";
	 int rownum=Excelutilities.getRowcount(path, "Sheet1");
	 int colcount=Excelutilities.getcellcount(path, "Sheet1",1);
	 
	 String loginData[][]=new String[rownum][colcount];
	 
	 for(int i =1;i<=rownum;i++) {
		 
		 for(int j = 0;j<colcount;j++) {
			 
			 loginData[i-1][j]=Excelutilities.getCellData(path, "Sheet1", i, j);
			 
		 }
		 
	 }
	 
	 return loginData;
}

}
