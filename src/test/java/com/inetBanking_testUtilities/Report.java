package com.inetBanking_testUtilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.support.Colors;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ReportAggregates;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Author;
import com.aventstack.extentreports.model.Category;
import com.aventstack.extentreports.model.Device;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freemarker.template.SimpleDate;

public class Report extends TestListenerAdapter{
	public ExtentHtmlReporter htmlreport;
	public ExtentReports extent;
	public ExtentTest test ;
	
	public void onStart(ITestContext testcontest) {
		String timestamp=new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());
		String Repname="Test_Repot"+timestamp+".html";
		htmlreport=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test_output/"+Repname);
		htmlreport.loadXMLConfig(System.getProperty("user.dir")+"//extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		extent.setSystemInfo("HostName","Localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("user", "Priti");
		htmlreport.config().setDocumentTitle("Automation Test");
		htmlreport.config().setReportName("Functional test report");
		htmlreport.config().setTheme(Theme.DARK);
		
	}
	
	public void onTestSuccess(ITestResult result ) {
	test=extent.createTest(result.getName());//Create test
	test.log(Status.PASS, MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));// send the passed information to the report with GREEN color highlighted
	}
		
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
		String screenshotpath=System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png";
		File f = new File(screenshotpath);
		if(f.exists()) {
			try {
				test.fail("Find screenshot below:"+test.addScreenCaptureFromPath(screenshotpath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		
	test=extent.createTest(result.getName());
	test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
		
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
}

