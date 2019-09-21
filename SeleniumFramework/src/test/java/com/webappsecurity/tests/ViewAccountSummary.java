package com.webappsecurity.tests;

import org.testng.annotations.Test;

import com.webappsecurity.pages.HomePage;
import com.webappsecurity.pages.LoginPage;

import utils.ExcelDriven;

public class ViewAccountSummary extends TestBase {
	
	@Test(dataProvider = "zbLogin", dataProviderClass = ExcelDriven.class)
	public void viewSummary(String username, String password) {
	//Click sign in button in home page
	HomePage homepage = new HomePage(driver);
	homepage.clickSigninButton();
	logger.info("signin button clicked");
	
	//Enter credentials in login page
	LoginPage loginpage = new LoginPage(driver);
	if(loginpage.isPageDisplayed())
		loginpage.enterCredentials(username, password);
	//loginpage.enterCredentials("username", "password");
	logger.info("Credentials entered");
	
	//Verify AccountSummary page
	
	}
	
	

}
