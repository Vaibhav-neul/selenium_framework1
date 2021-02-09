package com.visionit.orangehrm.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class helper {

	public static void selectdropdownvalue(WebDriver driver,WebElement ele ,String visibletext){
		
		 new Select(ele).selectByVisibleText(visibletext);
		 
	}
}
