package com.bksoft.keyboard;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected WebDriver driver;
	
	@BeforeMethod
	protected void initBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//driver.get("file:///C:/Users/bikashs/Desktop/html/New%20Text%20Document.html");
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	}

}
