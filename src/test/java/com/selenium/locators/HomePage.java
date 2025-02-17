package com.selenium.locators;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.bksoft.keyboard.BaseClass;

public class HomePage extends BaseClass {

	@Test
	public void listAllAnchorTags() {
		List<WebElement> anchor = driver.findElements(By.tagName("a"));

		for (WebElement element : anchor) {
			verifyLink(element.getAttribute("href"));
		}
		
	}

	public void verifyLink(String url) {

		URL link;
		try {
			link = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) link.openConnection();
			connection.setRequestMethod("HEAD");

			if (connection.getResponseCode() == 200) {
				System.out.println(url + " - " + connection.getResponseMessage());
			} else {
				System.out.println(url + " - " + connection.getResponseMessage() + " - " + "is a broken link");
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
