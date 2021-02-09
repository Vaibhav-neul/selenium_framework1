package com.visionit.orangehrm.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.visionit.orangehrm.pageObject.Loginpage;
import com.visionit.orangehrm.pageObject.adduserpage;
import com.visionit.orangehrm.pageObject.homepage;
import com.visionit.orangehrm.testbase.TestBase;
import com.visionit.orangehrm.utilities.exceldataprovider;

public class Adduser_tc_002 extends TestBase {
    
	@Test(dataProvider="getexceldata")
	public void addnewusertest(String user_role,String empname,String username,String 
			status,String password,String confirmp){
		Loginpage login= new Loginpage(driver);
		homepage hp=login.loginorangehrm(exceldata.getstringcelldata("Sheet1", 0, 0), 
				exceldata.getstringcelldata("Sheet1", 0, 1));
      adduserpage adduser= hp.navigatetoadduserpage();
      adduser.addnewuser(user_role, empname, username, status, password, confirmp);
	}
	
	@DataProvider
	public Object[][] getexceldata(){
		Object[][] data=exceldata.exceltestdata("Sheet1");
		return data;
	}
}
