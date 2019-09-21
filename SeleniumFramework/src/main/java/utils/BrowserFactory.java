package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
static WebDriver driver;

	public static WebDriver chooseBrowser(String BrowserName) {
		if(BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Softwares\\Drivers\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver","C:\\Softwares\\Drivers\\GeckoDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if (BrowserName.equals("edge")) {
			System.setProperty("webdriver.chrome.driver","C:\\Softwares\\Drivers\\MicrosoftEdge\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		return driver;
}
}
