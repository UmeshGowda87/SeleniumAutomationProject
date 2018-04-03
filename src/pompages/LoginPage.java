package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
//Declaration
	@FindBy(id="username")
	WebElement unTB;
	
	@FindBy(name="pwd")
	WebElement pwdTB;	
	
	@FindBy(xpath="//div[text()='Login ']")
	WebElement loginBtn;
	
	//Initialization of elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization of Elements
	public void setUserName(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pwd)
	{
		pwdTB.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		loginBtn.click();
	}
}
