package scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.HomePage;
import pompages.LoginPage;

public class VerifyActiTimeVersion extends BaseTest 
{
	@Test
	public void ActitimeVersion() throws InterruptedException
	{
		//Login to ActiTime Application
		LoginPage l=new LoginPage(driver);
		
		String un=Lib.getcellValue(EXCEL_PATH, "ValidLogin", 1, 0);
		l.setUserName(un);
		
		
		String pwd=Lib.getcellValue(EXCEL_PATH, "ValidLogin", 1, 1);
		l.setPassword(pwd);
		
		l.clickLogin();
		
		Thread.sleep(8000);
		/*WebDriverWait wait = new WebDriverWait(driver,20);
		String eTitle=Lib.getcellValue(EXCEL_PATH, "ProductVersion", 1, 0);
		wait.until(ExpectedConditions.titleIs(eTitle));*/
		
		HomePage h= new HomePage(driver);
		
		h.clickHelpIcon();
		
		Thread.sleep(5000);
		
		h.clikActiTimeLink();
		
		Thread.sleep(3000);
		
		//
		String ActualVersion = h.GetVersionDetails();
		String ExpectedVersion=Lib.getcellValue(EXCEL_PATH, "ProductVersion", 1, 1);
		
		SoftAssert s =new SoftAssert();
		s.assertEquals(ActualVersion, ExpectedVersion);
		
		Thread.sleep(3000);
		
		h.ClosePopUpWindow();
		Thread.sleep(3000);
		
		h.clickLogout();
		
		Thread.sleep(5000);
		s.assertAll();
}
}