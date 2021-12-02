package pom_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	WebDriver driver;
	Actions act;
	@FindBy (xpath="(//a[@class='dropdown-toggle'])[10]")
    private WebElement ClickON;
	
	@FindBy (xpath="//a[@onclick='SignOut()']")
	private WebElement logout;
	
	public LogOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnSetting() {
		
		act = new Actions(driver);
		act.moveToElement(ClickON).perform();
		logout.click();
	}
	
//	public void clickOnLogOut()
//	{
//		logout.click();
//	}

	
		
	}
	

