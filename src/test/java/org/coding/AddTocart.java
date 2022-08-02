package org.coding;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddTocart {
	

public class FlipkartUnitCheck {
	
	public WebDriver driver; 

	
	@BeforeClass
	public void testcase1() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		System.out.println("Launch Browser - testcase1");	
		
	}
	@Before
	public void testcase2() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		WebElement closebtn = driver.findElement(By.xpath("//button[text()='✕']"));
			closebtn.click();
		System.out.println("@close - testcase2");
		Thread.sleep(5000);
		
	}
	
	@Test
	public void testcase3() 
	{
		WebElement Search = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		Search.sendKeys("Mouse");
		WebElement btn = driver.findElement(By.xpath("//button[@type='submit']"));
		btn.click();
		System.out.println("SendKeys - testcase3");
		
	}
	
	@Test
	public void testcase4() throws InterruptedException
	{
		testcase3();
		Thread.sleep(3000);
		WebElement itemSelect = driver.findElement(By.linkText("QUANTUM QHM224D Wired Optical Mouse"));
		System.out.println("item selected");
		if(itemSelect.isDisplayed())
		itemSelect.click();
		System.out.println("Item clicked");
	
	}
	
	@Test
	public void testcase5() throws InterruptedException
	{
		testcase4();
		Thread.sleep(4000);
		String pWin = driver.getWindowHandle();
		Set<String> allWin = driver.getWindowHandles();
		for (String x : allWin) {
			if(!x.equals(pWin));
			driver.switchTo().window(x);
		}	
		System.out.println("window switched");
	}
	
	@After
	public void testcase6() throws InterruptedException
	{
		driver.quit();
		Thread.sleep(2000);
		System.out.println("Test case completed");
	}
	
	@AfterClass
	public void testcase7() {
		System.out.println("closed browser");
	}
	
}
}