package testClass_Package;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class VerifyHeaderfunctionality {
	WebDriver driver;
	pom_package.SignINPage signIN;
	pom_package.HomePage homepage;
	pom_package.LogOutPage logout;
	
	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to("https://trade.angelbroking.com/Login");
		driver.manage().window().maximize();
		signIN = new pom_package.SignINPage(driver); 
		homepage = new pom_package.HomePage(driver);
		logout = new pom_package.LogOutPage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException, EncryptedDocumentException, IOException
	{
		signIN.sendUserID();
		Thread.sleep(3000);
		signIN.sendPassword();
		Thread.sleep(3000);
		signIN.clickSignIN();
		Thread.sleep(3000);
	}
	
	@Test
	public void VerifyMarkets() throws InterruptedException, IOException
	{
		homepage.clickOnMarkets();
		Thread.sleep(3000);
		homepage.clickOnBuy();
	}
	
	@Test
	public void VerifyOrders() throws InterruptedException, IOException
	{
		homepage.clickOnOrders();
		Thread.sleep(3000);
		homepage.clickOnSell();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		logout.clickOnSetting();
	}
	
	@AfterClass
	public void afterclass()
	{
		driver.close();
	}
	

}
