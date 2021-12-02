package testClass_Package;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import Utilities.Utiliy;
import basePackage.Base;



public class VerifySignIN extends Base {
	WebDriver driver;
	pom_package.SignINPage signIN;
	pom_package.LogOutPage logout;
	pom_package.HomePage homepage;
	int testID;
	
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browser)
	{
		

		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = openChromeBrowser();
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver = openfirefoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	}
	
	@BeforeClass
	public void beforeClass()
	{
		signIN = new pom_package.SignINPage(driver); 
		logout = new pom_package.LogOutPage(driver);
		homepage = new pom_package.HomePage(driver);
	}
	

	@BeforeMethod
	public void logIn() throws InterruptedException, EncryptedDocumentException, IOException
	{
		driver.navigate().to("https://trade.angelbroking.com/Login");
		driver.manage().window().maximize();
		signIN.sendUserID();
		signIN.sendPassword();
		signIN.clickSignIN();
	}
	
	@Test()
	public void VerifySignInButton() throws InterruptedException, EncryptedDocumentException, IOException
	{
		testID=100;
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Thread.sleep(3000);
		Assert.assertEquals(url,"https://trade.angelbroking.com/portfolio/equity/index_v");
		
	}

	
	
	@AfterMethod
	public void LogOut(ITestResult result) throws InterruptedException, IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utiliy.takescreenshot((TakesScreenshot)driver, testID);
		}
		Thread.sleep(3000);
		logout.clickOnSetting();
	}
	
	@AfterClass
	public void clearObjects()	
	{
		 signIN=null;
		 logout=null;
	     homepage=null;
		
	}
	
	@AfterTest
	public void closedBrowser()
	{
		driver.quit();
		driver = null;
		System.gc();
	}

}
