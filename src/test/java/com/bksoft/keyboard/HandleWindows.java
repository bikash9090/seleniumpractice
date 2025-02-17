package com.bksoft.keyboard;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class HandleWindows extends BaseClass {
	String parentWindow;

	@Test
	public void createAndCloseTab() throws InterruptedException {
		parentWindow = driver.getWindowHandle();

		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	public void createMultipleTabsAndURL() {

		driver.navigate().to("https://www.javatpoint.com/interface-in-java");
		String parentWindow = driver.getWindowHandle();

		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.google.com/");
		driver.switchTo().window(parentWindow);
	}

	@Test(dependsOnMethods = "createMultipleTabsAndURL")
	public void switchMultipleWindow() {

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterate = windows.iterator();
		while (iterate.hasNext()) {
		}

	}

}