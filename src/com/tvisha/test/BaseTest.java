package com.tvisha.test;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {


public Properties properties;
public FileInputStream fileInputStream;
public WebDriver driver;

public void read_properties(){
	try{
		properties=new Properties();
		
		fileInputStream=new FileInputStream(System.getProperty("user.dir")+"//src//application.properties");
		properties.load(fileInputStream);
		
	}catch(Exception e){
		e.printStackTrace();
	}
  }


public void open_browser(){
	
	try{
		
		switch (properties.getProperty("browser")) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver","D:\\Springworkspace\\seelniumInterview\\src\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver","D:\\sathish_softwares\\chromedriver.exe");
			driver=new ChromeDriver();
			break;
			
		default:
			break;
		}
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
  }
    
    public void get_Url(){
	 driver.get(properties.getProperty("URL"));
    }

    @BeforeTest
    public void SetUp_Browser(){
    	read_properties();
    	open_browser();
    	get_Url();
    }
    
    
    @AfterTest
    public void close_browser(){
    	driver.close();
    	driver.quit();
    }
    
 }


