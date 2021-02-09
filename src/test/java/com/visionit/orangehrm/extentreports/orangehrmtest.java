package com.visionit.orangehrm.extentreports;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class orangehrmtest {
	static WebDriver driver;
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports report;
	public ExtentTest loggers;

	@BeforeTest
	public void setupExtent() {
		File f2 = new File("./Reports/orange_hrm2.html");

		htmlreporter = new ExtentHtmlReporter(f2);

		htmlreporter.config().setDocumentTitle("automation report");
		htmlreporter.config().setReportName("functional report");
		htmlreporter.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(htmlreporter);

		report.setSystemInfo("Hostname", "LocalHost");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("QA enginner", "vaibhav");
		report.setSystemInfo("Browser", "Chrome");

	}

	@AfterTest
	public void endreport() {
		report.flush();
	}

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void verifytitletest() {
		loggers = report.createTest("verifytitletet");

		String actualtitle = driver.getTitle();
		String expectedtitle = "OrangeHRM";

		Assert.assertEquals(actualtitle, expectedtitle);
	}
	@Test
	public void verifylogotest(){
		loggers=report.createTest("verifylogotest");
		
		boolean status=driver.findElement(By.xpath("//div[@id='divLogo']")).isDisplayed();
		
		Assert.assertTrue(false);
	}

	@AfterMethod
	public void tesrdown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			loggers.log(Status.FAIL, "test case failed" + result.getName());
			loggers.log(Status.FAIL, "t33est case failed" + result.getThrowable());
			
			String scrnshotpath1=capturescrenshot(result.getName());
			loggers.addScreenCaptureFromPath(scrnshotpath1);
		}
		else if(result.getStatus() == ITestResult.SUCCESS){
			loggers.log(Status.PASS, "test case passed" + result.getName());
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			loggers.log(Status.SKIP, "test case skipped" + result.getName());
		}
		driver.quit();
	}

	public static String capturescrenshot(String screenshotname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		String scrnshotpath=System.getProperty("user.dir")+ "/test-output/" + screenshotname + ".png";
		File destfile = new File("scrnshotpath");
		FileHandler.copy(srcfile, destfile);
		return scrnshotpath;
	
	}

}
