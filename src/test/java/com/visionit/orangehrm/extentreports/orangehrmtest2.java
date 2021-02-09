package com.visionit.orangehrm.extentreports;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.FileUtil;

public class orangehrmtest2 {
        
	public static WebDriver driver;
	public ExtentHtmlReporter htmleporter2;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	public void setupextent2(){
		File f= new File("./Reprts/googlereport.html");
		htmleporter2 =new ExtentHtmlReporter(f);
		
		htmleporter2.config().setDocumentTitle("automtion reort2");
		htmleporter2.config().setReportName("regression r[ort");
		htmleporter2.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(htmleporter2);
		
		report.setSystemInfo("tester", "vabhav neul");
		report.setSystemInfo("browser", "chrome");
		}
	@AfterTest
	public void endreport2(){
		report.flush();
	}
	
	@BeforeMethod
	public void setup2(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		}
	@Test
	public void verifytitletest(){
		test=report.createTest("verify title test");
		
		String actual=driver.getTitle();
		String expected="New Tab";
		Assert.assertEquals(actual, expected);
	}
	@AfterMethod
	public void teardown2(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL,"test case failed"+result.getName());
			
		 String scrnshot2= capturescreenshot2(result.getName());
		// test.addScreenCaptureFromPath(scrnshot2);
		 test.fail("Testcase failed", MediaEntityBuilder.createScreenCaptureFromPath(scrnshot2).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			test.log(Status.PASS,"test case pased" + result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP){
		 test.log(Status.SKIP,"test case skipped"+ result.getName());
		}
		driver.close();
	}
	
	public static String  capturescreenshot2(String sname) throws IOException{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		String imgpath="./Screenshots/" + sname + ".png";
		File destfilr=new File(imgpath);
		FileHandler.copy(srcfile, destfilr);
		
		return imgpath;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
