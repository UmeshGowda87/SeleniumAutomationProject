package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class InvalidTestLogin extends BaseTest 
{
	@Test
	public void testInvalidLogin() throws InterruptedException
	{
		int rowCount = Lib.getRowCount(EXCEL_PATH, "InvalidLogin");
		LoginPage l = new LoginPage(driver);
		for (int i=1;i<=rowCount;i++)
		{
			l.setUserName(Lib.getcellValue(EXCEL_PATH,"InvalidLogin", i, 0));
			l.setPassword(Lib.getcellValue(EXCEL_PATH,"InvalidLogin", i, 1));
			
			l.clickLogin();
			
			Thread.sleep(3000);
		}
	}
}
