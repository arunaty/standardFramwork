package Com.internetbaning.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.internetbanking.BaseClass.BaseClass;
import Com.internetbanking.Pageobject.Internetbanking_LoginPage;

public class LoginPageTest extends BaseClass {

	
	@Test
	public void LoginTest() throws IOException{
		//initialization();
		
	    logger.info("URL is open");
		Internetbanking_LoginPage LP = new Internetbanking_LoginPage();

		LP.Setusername(username);
		logger.info("Enter username");

		LP.SetPassword(password);
		logger.info("Enter Password");

		LP.Clickbtn();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePag")) {	
			logger.info("Get Title");
			System.out.println("Passed");
		}
		
		else {		
			getScreenshotAs("LoginPageTest");
			Assert.assertTrue(false);
		}
				
	}
}
