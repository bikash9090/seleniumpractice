package com.bksoft.keyboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions {
	WebDriver driver;
	Actions action;
	WebDriverWait wait;

	@BeforeMethod
	public void initBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// driver.get("https://selectorshub.com/xpath-practice-page/");
		// driver.manage().window().maximize();
	}

	@Test
	public void moveToElementTest() throws InterruptedException {
		WebElement resoursces = driver.findElement(By.xpath("//a[contains(text(),'Resources')]"));
		WebElement filePicker = driver.findElement(By.id("myFile"));

		action.moveToElement(filePicker).build().perform();
		Thread.sleep(3000);
		action.moveToElement(resoursces).build().perform();
	}

	@Test
	public void rightClickTest() {
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");

		WebElement righClickBtn = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		action.contextClick(righClickBtn).build().perform();

	}

	@Test
	public void doubleClickTest() {
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement doubleClickBtn = driver.findElement(By.xpath("//button[@ondblclick=\"myFunction()\"]"));

		wait.until(ExpectedConditions.elementToBeClickable(doubleClickBtn));
		action.doubleClick(doubleClickBtn).build().perform();
	}

	@Test
	public void dragAndDrop() throws InterruptedException {
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		WebElement dragFrom = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
		WebElement dragTo = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));

		action.dragAndDrop(dragFrom, dragTo).build().perform();
	}

	@Test
	public void dragAndDropByoffset() {
		driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
		driver.manage().window().maximize();

		WebElement dragFrom = driver.findElement(By.id("draggable"));

		action.dragAndDropBy(dragFrom, 300, 30).perform();

	}
	
	@Test
	public void dragAndDropby() {
		driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
		driver.manage().window().maximize();
		
		WebElement dragFrom = driver.findElement(By.id("draggable"));
		action.dragAndDropBy(dragFrom, 400, 50).perform();
		action.scrollToElement(dragFrom);
		
	}

}
