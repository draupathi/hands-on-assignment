package com.webappsecurity.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webappsecurity.pages.AccountSummaryPage;
import com.webappsecurity.pages.HomePage;
import com.webappsecurity.pages.LoginPage;
import com.webappsecurity.pages.MyMoneyMapPage;

import utils.ExcelDriven;

@Listeners(utils.NGListeners.class)
public class MyMoneyMap extends TestBase{
	@Test(dataProvider = "zbLogin", dataProviderClass = ExcelDriven.class)
	public void viewMyMoneyMap(String username, String password) {
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

		//Verify Account Summary page
		AccountSummaryPage accountsummarypage = new AccountSummaryPage(driver);
		if(accountsummarypage.isAccountSummaryPageDisplayed())
			accountsummarypage.clickMyMoneyMaP();
		logger.info("My Money Map Link is clicked");

		//Verify My Money Map page, collapse expand and pop-up functions
		MyMoneyMapPage mymoneymappage = new MyMoneyMapPage(driver);
		if(mymoneymappage.isMyMoneyMapDisplayed()) {
			mymoneymappage.inflowCollapse();
		}
		logger.info("Inflow table is collapsed");
		mymoneymappage.inflowExpand();
		logger.info("Inflow table is expanded");
		mymoneymappage.depositCollapse();
		logger.info("Deposit table is collapsed");
		mymoneymappage.depositExpand();
		logger.info("Deposit table is expanded");
		mymoneymappage.directDepositsInfoPopup();
		logger.info("Direct Deposits pop-up is opened");
		mymoneymappage.otherDepositsInfoPopup();
		logger.info("Other Deposits pop-up is opened");
		mymoneymappage.transfersFromOtherZBAccountInfoPopup();
		logger.info("Transfer from other Zero Bank Account pop-up is opened");
		mymoneymappage.popupAutomaticClose();
		logger.info("Pop-up Automatic open and close is executed");
	}
}
