package com.visionit.orangehrm.testcases;

import org.testng.annotations.Test;

import com.visionit.orangehrm.pageObject.Loginpage;
import com.visionit.orangehrm.testbase.TestBase;
import com.visionit.orangehrm.utilities.exceldataprovider;

public class Login_tc_001 extends TestBase{
       
	
	@Test
	public void loginorangehrmtest(){
		Loginpage login= new Loginpage(driver);
		//login.loginorangehrm(configdata.getusername(),configdata.getpassword());
		login.loginorangehrm(exceldata.getstringcelldata("Sheet1", 0, 0), 
				exceldata.getstringcelldata("Sheet1", 0, 1));
	}
}
