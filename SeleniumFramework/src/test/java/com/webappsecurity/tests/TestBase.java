package com.webappsecurity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;


import utils.BrowserFactory;

@Listeners(utils.NGListeners.class)	


public class TestBase {
	WebDriver driver;
	public Properties properties;
	Logger logger=Logger.getLogger("TestBase");

	public void configReader() {
		//Declare a properties object
		properties = new Properties();

		//Read configuration.properties file
		try {
			properties.load(new FileInputStream(
					System.getProperty("user.dir") 
					+ "\\src\\test\\resources\\Configurations.properties"));
		} catch (IOException e) {
			System.out.println("Configuration properties file cannot be found");
		}	
	}


	@BeforeClass
	public void setUp() throws IOException {
		configReader();
		properties.load(getClass().getResourceAsStream("/log4j.properties"));
		PropertyConfigurator.configure(properties);
		//PropertyConfigurator.configure("log4j.properties");
		driver = BrowserFactory.chooseBrowser("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
	}
}
