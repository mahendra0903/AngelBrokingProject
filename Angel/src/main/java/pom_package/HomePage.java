package pom_package;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	WebDriver driver;
	@FindBy (xpath="//a[@id='mnMarkets']")
	private WebElement markets;
	
	@FindBy (xpath="//a[text()='Buy']")
	private WebElement buy;
	
	@FindBy (xpath="//a[@id='mnOrders']")
	private WebElement orders;
	
	@FindBy (xpath="//button[text()='SELL']")
	private WebElement sell;
	
	@FindBy (xpath="(//button[@aria-label='Close'])[3]")
	private WebElement close;
	
	@FindBy (xpath="(//button[@aria-label='Close'])[5]")
	private WebElement exit;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnMarkets()
	{
		markets.click();
	}
	
	public void clickOnBuy() throws IOException, InterruptedException
	{
		buy.click();
		Thread.sleep(3000);
		close.click();
	}
	
	public void clickOnOrders()
	{
		orders.click();
	}
	
	public void clickOnSell() throws IOException, InterruptedException
	{
		sell.click();
		Thread.sleep(3000);
		exit.click();
	}

}
