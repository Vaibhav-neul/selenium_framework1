package com.visionit.orangehrm.testbase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.visionit.orangehrm.utilities.configdataprovider;
import com.visionit.orangehrm.utilities.exceldataprovider;

public class TestBase {
	public  WebDriver driver = null;
	public  configdataprovider configdata;
	public  exceldataprovider  exceldata;

	@BeforeSuite
	public void setupsuite() throws Exception {
     	configdata = new configdataprovider();
		exceldata= new exceldataprovider();
	}

	@Parameters("browsername")
	@BeforeMethod
	public void setup(@Optional("Chrome")String bname) {

		if (bname.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			driver = new ChromeDriver();
		} else if (bname.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (bname.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver = new ChromeDriver();
		}
		driver.get(configdata.geturl());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
