package com.visionit.orangehrm.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.visionit.orangehrm.utilities.helper;

public class adduserpage {

	public WebDriver driver;
	
	@FindBy(id = "btnAdd")
	@CacheLookup
	WebElement btnAdd;

	@FindBy(id = "systemUser_userType")
	@CacheLookup
	WebElement systemuser00;

	@FindBy(id = "systemUser_employeeName_empName")
	@CacheLookup
	WebElement employeename;

	@FindBy(id = "systemUser_userName")
	@CacheLookup
	WebElement username;

	@FindBy(id = "systemUser_status")
	@CacheLookup
	WebElement systemuser_status00;

	@FindBy(id = "systemUser_password")
	@CacheLookup
	WebElement userpasword;

	@FindBy(id = "systemUser_confirmPassword")
	@CacheLookup
	WebElement cnfrmpasword;

	@FindBy(id = "btnSave")
	@CacheLookup
	WebElement savebtn;
	
	public adduserpage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addnewuser(String selectrole,String empname,String userName,
			String statusdd,String pwd,String confirmpwd) {

		btnAdd.click();
		helper.selectdropdownvalue(driver, systemuser00, selectrole);
		employeename.sendKeys(empname);
		username.sendKeys(userName);
		helper.selectdropdownvalue(driver, systemuser_status00, statusdd);
		userpasword.sendKeys(pwd);
		cnfrmpasword.sendKeys(confirmpwd);
	}

}
