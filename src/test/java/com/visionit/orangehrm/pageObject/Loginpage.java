package com.visionit.orangehrm.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
     public WebDriver driver;
     
     @FindBy(name="txtUsername")
     WebElement uname;
     
     @FindBy(name="txtPassword")
     WebElement upwd;
     
     @FindBy(id="btnLogin")
     WebElement lgnbtn;
     
     
	 public Loginpage(WebDriver driver){
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	public homepage loginorangehrm(String username,String upas){
		//uname.sendKeys("Admin");
		//upwd.sendKeys("admin123");
		
		uname.sendKeys(username);
		upwd.sendKeys(upas);
		lgnbtn.click();
		return new homepage(driver);
	}
}
