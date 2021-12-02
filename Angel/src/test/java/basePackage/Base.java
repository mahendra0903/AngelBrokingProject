package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver openfirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Automation\\geckodriver.exe\\");
		WebDriver driver = new FirefoxDriver();	
		driver.manage().window().maximize();
		return driver;
	}
}
