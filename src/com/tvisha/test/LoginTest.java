package com.tvisha.test;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tvisha.pages.LoginPage;
import com.tvisha.xcel.Excel;

public class LoginTest extends BaseTest{

	@DataProvider(name="test")
	public Object[][] getData() throws IOException{
		
		Excel excel=new Excel("D:\\Springworkspace\\seelniumInterview\\src\\Interview.xlsx");
		return excel.hashtable_data("Sheet1", null, null);
		
	}
	
	@Test(dataProvider="test")
	public void test_login(Hashtable<String, String> hash) throws InterruptedException{
		
		LoginPage loginpage=PageFactory.initElements(driver,LoginPage.class);
		loginpage.login_cred(hash.get("Username"), hash.get("Password"));
		
	}
	
}
