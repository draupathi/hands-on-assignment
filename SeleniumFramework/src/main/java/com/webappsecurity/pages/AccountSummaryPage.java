package com.webappsecurity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSummaryPage extends BasePage{
	@FindBy(linkText="My Money Map") WebElement MyMoneyMapLink;

	public AccountSummaryPage(WebDriver driver) {
		super(driver);
		
	}
	public boolean isAccountSummaryPageDisplayed() {
		return driver.getTitle().equals("Zero - Account Summary") ;
	}
	public void clickMyMoneyMaP() {
		MyMoneyMapLink.click();
	}

}
