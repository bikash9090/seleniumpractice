package com.bksoft.keyboard;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions {
	WebDriver driver;
	String parentWindow;
	Actions action;

	@BeforeMethod
	public void initBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		action = new Actions(driver);

	}

	@Test
	public void keyPress() {
		driver.get("https://keyboardchecker.com/");

		action.keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).keyDown(Keys.F1).keyUp(Keys.F1).keyDown(Keys.F2).keyUp(Keys.F2)
				.keyDown(Keys.F3).keyUp(Keys.F3).keyDown(Keys.PAGE_UP).keyDown(Keys.PAGE_UP).build().perform();
	}

	@Test()
	public void copyUsingKeyboard() {
		driver.get("https://www.merriam-webster.com/dictionary/passage");
		action.keyDown(Keys.CONTROL)
		.sendKeys("a")
		.sendKeys("c")
		.keyUp(Keys.CONTROL).build().perform();
	}

	@Test
	public void switchToNewWindow() {

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.merriam-webster.com/dictionary/passage");
	}

	@Test()
	public void handleBrowserTabs() throws InterruptedException {
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		String parentWindow = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://google.com");
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://jqueryui.com/droppable/");
		
		driver.switchTo().window(parentWindow);

		Set<String> tabs = driver.getWindowHandles();
		
		Iterator<String> iterate = tabs.iterator();
		
		while(iterate.hasNext()) {
			Thread.sleep(3000);
			String childTab = iterate.next();
			driver.switchTo().window(childTab);
		}
	}
}
