package com.tvisha.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy(xpath="//*[@id='user_name']")
	public WebElement username;
	
	@FindBy(id="login_password")
	public WebElement password;
	
	@FindBy(id="loginBtn")
	public WebElement loginBtn;
	
	public LoginPage login_cred(String user,String pass) throws InterruptedException{
		
		Thread.sleep(500);
		username.clear();
		username.sendKeys(user);
		
		Thread.sleep(500);
		password.clear();
		password.sendKeys(pass);
		
		Thread.sleep(500);
		loginBtn.click();
		Thread.sleep(500);
		
		return PageFactory.initElements(driver, LoginPage.class);
		
    	} 
	
     }
