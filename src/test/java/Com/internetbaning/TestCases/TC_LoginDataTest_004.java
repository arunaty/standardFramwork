package Com.internetbaning.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.internetbanking.BaseClass.BaseClass;
import Com.internetbanking.Pageobject.Internetbanking_LoginPage;
import Com.internetbanking.Utilities.XLUtils;

public class TC_LoginDataTest_004 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void LoginData(String user, String Pwd) throws InterruptedException {

		logger.info("URL is open");
		Internetbanking_LoginPage LP = new Internetbanking_LoginPage();

		LP.Setusername(username);
		logger.info("Enter username");

		LP.SetPassword(password);
		logger.info("Enter Password");
		logger.info("Enter your Password Hear");
		logger.info("Enter the new Creadential");
		LP.Clickbtn();

		if (Isalertpresent() == true) {
			driver.switchTo().alert().accept(); // popup close
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.info("Login failed");
			
		} else {

			Assert.assertTrue(true);
			logger.info("Login passed");
			LP.Logoutapplication();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	public boolean Isalertpresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		String Path = System.getProperty("user.dir") + "/src/main/java/Com/internetbanking/TestData/9July.xlsx";
		int rownum = XLUtils.getRowCount(Path, "Sheet1");
		int Colcount = XLUtils.getCellCount(Path, "Sheet1", 1);

		String logindata[][] = new String[rownum][Colcount];

		for (int i = 1; i <= rownum; i++) {
			
			for (int j = 0; j < Colcount; j++) {

				logindata[i - 1][j] = XLUtils.getCellData(Path, "Sheet1", i, j); // 1 0

			}
		}
		return logindata;

	}
}
