package com.innetBanking_testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.utils.FileUtil;
import com.inetBanking_testUtilities.ReadConfig;
import com.inetBanking_v1_pageObjects.LoginPage;

import io.github.bonigarcia.wdm.Config;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	Logger log;
	ReadConfig config = new ReadConfig();
	public String url = config.getUrl();
	public String username = config.getUsername();
	public String password = config.getpassword();
	public static WebDriver driver;
    @Parameters("browser")
	@BeforeClass
	public void setUp(String brows) {
    	log = Logger.getLogger("Ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
    	if(brows.equalsIgnoreCase("chrome")) {
//    		System.setProperty("Webdriver.chrome.driver", config.getchropath());

		WebDriverManager.chromedriver().version("83").setup();

		driver = new ChromeDriver();
    	}
    	else if(brows.equalsIgnoreCase("firefox")) {
    		
//    		System.setProperty("Webdriver.gecko.driver", config.getfirefoxpath());
    		WebDriverManager.chromedriver().version("26").setup();
    		
    		driver = new FirefoxDriver();
    		
    	}
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get(url);
    	driver.manage().window().maximize();
		

	}
	@AfterClass
	public void close() {
		driver.quit();
	}
	
	public  void captureScreen(WebDriver driver,String tname) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") +"/Screenshots/" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
		
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}
