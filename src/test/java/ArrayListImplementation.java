import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ArrayListImplementation {
	WebDriver driver;
	
	
	@BeforeMethod
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com.gr/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void storeTheElements() throws InterruptedException {
		WebElement compList = driver.findElement(By.xpath("//a[@class=\"dropdown-toggle\" and contains(text(),'Components')]"));
		Actions action = new Actions(driver);
		
		action.moveToElement(compList).perform();
		compList.click();
		Thread.sleep(Duration.ofSeconds(2));
		
		List<WebElement> compListData = driver.findElements(By.xpath("//li[@class=\"dropdown open\"]//li"));
		ArrayList<String> categoryNames = new ArrayList<>();
		
		for(WebElement data:compListData) {
			categoryNames.add(data.getText());
		}
		
		for(String name:categoryNames) {
			System.out.println(name);
		}
		
		
		
		
	}
}
