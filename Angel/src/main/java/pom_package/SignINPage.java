package pom_package;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignINPage {
	
	private WebDriver driver;
	
	@FindBy (xpath="//input[@id='txtUserID']")
	private WebElement userID;
	
	@FindBy (xpath="//input[@id='txtTradingPassword']")
	private WebElement password;
	
	@FindBy (xpath="//a[@id='loginBtn']")
	private WebElement signIN;
	
	public SignINPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void sendUserID() throws EncryptedDocumentException, IOException
	{
		userID.sendKeys(Utilities.FetchExcelData.getExcelData(0,0));
	
	}
	public void sendPassword()
	{
		password.sendKeys("mk@09031997");
	}
	
	public void clickSignIN()
	{
		signIN.click();	
	}

}
