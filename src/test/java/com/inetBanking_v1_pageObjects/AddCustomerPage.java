package com.inetBanking_v1_pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	public WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By addcustomer=By.xpath("/html/body/div[3]/div/ul/li[2]/a");
	By customer_name=By.name("name");
	By gender=By.name("rad1");
	By dob=By.name("dob");
	By addr=By.name("addr");
	By city=By.name("city");
	By state=By.name("state");
	By pin=By.name("pinno");
	By ph_no=By.name("telephoneno");
	By emailid=By.name("emailid");
	By password=By.name("password");
	By submit=By.name("sub");
	
	
	
	
	public void clickAddNewCustomer() {
		driver.findElement(addcustomer).click();
			
	}

	public void custName(String cname) {
		driver.findElement(customer_name).sendKeys(cname);
		
	}

	public void custgender(String cgender) {
		driver.findElement(gender).click();
	}

	public void custdob(String mm,String dd,String yy) {
		driver.findElement(dob).sendKeys(mm);
		driver.findElement(dob).sendKeys(dd);
		driver.findElement(dob).sendKeys(yy);
		
	}

	public void custaddress(String caddress) {
		driver.findElement(addr).sendKeys(caddress);
	}

	public void custcity(String ccity) {
		driver.findElement(city).sendKeys(ccity);
	}

	public void custstate(String cstate) {
		driver.findElement(state).sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		driver.findElement(pin).sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		driver.findElement(ph_no).sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		driver.findElement(emailid).sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		driver.findElement(password).sendKeys(cpassword);
	}

	public void custsubmit() {
		driver.findElement(submit).click();
	}
	


}
