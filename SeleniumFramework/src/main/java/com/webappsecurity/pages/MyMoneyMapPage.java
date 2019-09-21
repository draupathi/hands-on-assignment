package com.webappsecurity.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyMoneyMapPage extends BasePage{
	@FindBy(xpath = "//*[@id='tool-1032-toolEl']") WebElement Inflow_Collapse;
	@FindBy(css = "div#report-1010_header") WebElement Collapse_Inflow_Class;
	@FindBy(xpath = "//img[@id='tool-1032-toolEl' and @class='x-tool-expand-bottom']") WebElement Inflow_Expand;
	@FindBy(xpath = "//*[text()='Subject: Deposits']") WebElement Subject_Deposit;
	@FindBy(css = "tr#gridview-1015-hd-Deposits") WebElement Collapse_Deposit_Class;
	@FindBy(xpath = "//*[@id='gridview-1015-bd-Deposits']/td/table/tbody/tr[2]/td[3]/div/img") WebElement DirectDeposit_Info;
	@FindBy(xpath = "//*[@id='gridview-1015-bd-Deposits']/td/table/tbody/tr[3]/td[3]/div/img") WebElement OtherDeposit_Info;
	@FindBy(xpath = "//*[@id='gridview-1015-bd-Deposits']/td/table/tbody/tr[4]/td[3]/div/img") WebElement TransferFromOtherAccount_Info;
	@FindBy(css = "img#tool-1046-toolEl") WebElement Third_Popup_Close;
	public MyMoneyMapPage(WebDriver driver) {
		super(driver);
	}

	public boolean isMyMoneyMapDisplayed() {
		return driver.getTitle().equals("Zero - My Money Map");
	}
	
	//Inflow Table Collapse
	public void inflowCollapse() {
		Inflow_Collapse.click();
		System.out.println(Collapse_Inflow_Class.getAttribute("class"));
		if(Collapse_Inflow_Class.getAttribute("class").contains("x-collapsed")) {
			System.out.println("=====Inflow Collapsed=====");
		}
	}

	//Inflow Table Expand
	public void inflowExpand() {
		Inflow_Expand.click();
		System.out.println(Collapse_Inflow_Class.getAttribute("class"));
		if(Collapse_Inflow_Class.getAttribute("class").contains("x-collapsed")) {
			System.out.println("=====Inflow Still In Collapsed State=====");
		} else {
			System.out.println("=====Inflow Expanded=====");
		}
	}

	//Deposit Table Collapse
	public void depositCollapse() {
		Subject_Deposit.click();
		System.out.println(Collapse_Deposit_Class.getAttribute("class"));
		if(Collapse_Deposit_Class.getAttribute("class").contains("hd-collapsed")) {
			System.out.println("=====Deposits Table Collapsed=====");
		}
		else {
			System.out.println("=====Deposit Table Collapse Button Not Working / Error Occured=====");
		}
	}

	//Deposit Table Expansion
	public void depositExpand() {
		Subject_Deposit.click();
		System.out.println(Collapse_Deposit_Class.getAttribute("class"));
		if(Collapse_Deposit_Class.getAttribute("class").contains("hd-collapsed")) {
			System.out.println("=====Deposits Table Collapsed=====");
		}
		else {
			System.out.println("=====Deposit Table Expanded=====");
		}
	}

	//Direct Deposits info button click, pop-up opening and retrieving table column names
	public void directDepositsInfoPopup() {
		//Mouse Hover to click the info icon
		Actions action = new Actions(driver);
		action.moveToElement(DirectDeposit_Info).click().build().perform();	

		//To get the column names
		List<WebElement> tableColumns = driver.findElements(By.xpath("//*[@id='headercontainer-1042-innerCt']"));
		System.out.println("The actual column names for Direct Deposits pop-up are: ");
		for(WebElement tc: tableColumns) {
			System.out.println(tc.getText());			
		}
	}

	//Other Deposits info button click, pop-up opening and retrieving table column names
	public void otherDepositsInfoPopup() {
		//Mouse Hover to click the info icon
		Actions action = new Actions(driver);
		action.moveToElement(OtherDeposit_Info).click().build().perform();
		
		//To get the column names
		List<WebElement> tableColumns = driver.findElements(By.xpath("//*[@id='headercontainer-1042-innerCt']"));
		System.out.println("The actual column names for Other Deposits pop-upare: ");
		for(WebElement tc: tableColumns) {
			System.out.println(tc.getText());
		}	
	}

	//Transfers from other Zero Bank Accounts info button click, pop-up opening and retrieving table column names
	public void transfersFromOtherZBAccountInfoPopup() {
		//Mouse Hover to click the info icon
		Actions action = new Actions(driver);
		action.moveToElement(TransferFromOtherAccount_Info).click().build().perform();	
		
		//To get the column names
		List<WebElement> tableColumns = driver.findElements(By.xpath("//*[@id='headercontainer-1042-innerCt']"));
		System.out.println("The actual column names for Transfers from other Zero Bank Accounts are: ");
		for(WebElement tc: tableColumns) {
			System.out.println(tc.getText());
		}	
	}

	public void popupAutomaticClose(){
		//First pop-up
		Actions action = new Actions(driver);
		action.moveToElement(DirectDeposit_Info).click().build().perform();	
		String dDepositsTitle = driver.findElement(By.xpath("//*[@id='detailedreportwindow-1040_header_hd-textEl']")).getText();
		System.out.println("First pop-up title: "+dDepositsTitle);
		//Second pop-up
		action.moveToElement(OtherDeposit_Info).click().build().perform();
		String oDepositsTitle = driver.findElement(By.xpath("//*[@id='detailedreportwindow-1040_header_hd-textEl']")).getText();
		System.out.println("Second pop-up title: "+oDepositsTitle);
		//Verifying if first pop-up is closed 
		if(oDepositsTitle.equals(dDepositsTitle)) {
			System.out.println("First pop-up is not closed");
		}
		else {
			System.out.println("First pop-up is automatically closed when second pop-up is opened");
		}
		//Third pop-up
		action.moveToElement(TransferFromOtherAccount_Info).click().build().perform();
		String tAccountTitle = driver.findElement(By.xpath("//*[@id='detailedreportwindow-1040_header_hd-textEl']")).getText();
		System.out.println("Third pop-up title: "+tAccountTitle);
		//Verifying if second pop-up is closed
		if(tAccountTitle.equals(oDepositsTitle)) {
			System.out.println("Second pop-up is not closed");
		}
		else {
			System.out.println("Second pop-up is automatically closed when third pop-up is opened");
		}
		//To close third pop-up
		Third_Popup_Close.click();
		System.out.println("Third pop-up is closed by clicking the Close button on the pop-up");
	}
}

