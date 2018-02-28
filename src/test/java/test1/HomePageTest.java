package test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest 
{
	
	String USER_CONFIG = "src/test/java/config/";
	WebDriver driver;
	
	@BeforeTest
	public void launchApplication()
	{
		System.setProperty("webdriver.chrome.driver",USER_CONFIG + "/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("--js-flags=--expose-gc");  
		options.addArguments("--enable-precise-memory-info"); 
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-default-apps");
		options.addArguments("test-type=browser");
		options.addArguments("disable-infobars");
		DesiredCapabilities capabilities = new DesiredCapabilities(DesiredCapabilities.chrome());
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		
	}
	
	@Test
	public void launchApplicationFromBrowser()
	{
		driver.get("https://www.google.co.in/");
		Assert.assertEquals(driver.getTitle(),"Google");
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}

}
