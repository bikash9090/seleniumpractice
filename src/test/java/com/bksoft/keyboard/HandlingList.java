package com.bksoft.keyboard;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.functors.WhileClosure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingList {
	WebDriver driver;

	@BeforeMethod
	public void initBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void quitBrowser() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

	@Test
	public void staticListTest() {
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();

		WebElement cList = driver.findElement(By.tagName("select"));
		Select countryList = new Select(cList);

		countryList.selectByIndex(7);
		cList.click();
		countryList.selectByVisibleText("India");
		countryList.selectByValue("fjf");

	}

	@Test
	public void dynamicListTest() {
		driver.get("https://demo.opencart.com.gr/");
		driver.manage().window().maximize();

		List<WebElement> mp3Players = driver.findElements(By.xpath("//li[@class=\"dropdown open\"]/descendant::li"));
		
		for(WebElement element: mp3Players) {
			System.out.println(element.getText());
		}
	}

}
