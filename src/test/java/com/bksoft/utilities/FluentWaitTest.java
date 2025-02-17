package com.bksoft.utilities;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitTest {
	WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Test
	@Parameters("appURL")
	void clickAndWait(String appURL) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	//	driver.get("http://the-internet.herokuapp.com/dynamic_controls");
		driver.get(appURL);
		driver.manage().window().maximize();

		WebElement button = driver.findElement(By.xpath("//button[@onclick=\"swapCheckbox()\"]"));
		button.click();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(3000))
				.ignoring(Exception.class);
		button.click();

	}

}
