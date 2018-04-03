package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	@FindBy(id="logoutLink")
	WebElement logoutButton;
	
	@FindBy(xpath="//div[contains(text(),'Help')]")
	WebElement helpButton;
	
	@FindBy(xpath="//a[text()='About your actiTIME']")
	WebElement actiTimeLink;
	
	@FindBy(xpath="(//span[contains(text(),'actiTIME')])[1]")
	WebElement GetVersion;
	
	@FindBy(id="aboutPopupCloseButtonId")
	WebElement ClosePopup;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogout()
	{
		logoutButton.click();
	}
	public void clickHelpIcon()
	{
		helpButton.click();
	}
	public void clikActiTimeLink()
	{
		actiTimeLink.click();
	}
	public String GetVersionDetails()
	{
		return GetVersion.getText();
	}
	public void ClosePopUpWindow()
	{
		ClosePopup.click();
	}
}
