package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class ValidTestLogin extends BaseTest
{
	@Test
	public void testValidLogin()
	{
		LoginPage l = new LoginPage(driver);
		//Enter user name
		String username = Lib.getcellValue(EXCEL_PATH,"ValidLogin", 1, 0);
		l.setUserName(username);
				
		//Enter Password
		String password = Lib.getcellValue(EXCEL_PATH,"ValidLogin", 1, 1);
		l.setPassword(password);
		
		//Click on Login button
		l.clickLogin();
		//Assert.fail();
		
	}
}
