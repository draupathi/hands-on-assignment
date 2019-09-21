package utils;

	import java.io.IOException;

import org.testng.annotations.Test;
	 
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.MediaEntityBuilder;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
	 
	//http://extentreports.com/docs/versions/3/java/#basic-example
	
	public class ExtentReportDemo 
	{
	 
		@Test
		public void loginTest() throws IOException
		{    
	            // Create Object of ExtentHtmlReporter and provide the path where you want to generate the report 
	            // I used (.) in path where represent the current working directory
		    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/assignment.html");
			
	            // Create object of ExtentReports class- This is main class which will create report
		    ExtentReports extent = new ExtentReports();
		    
	            // attach the reporter which we created in Step 1
		    extent.attachReporter(reporter);
		    
		    extent.setSystemInfo("Environment", "QA");
		    extent.setSystemInfo("user", "Draupathi");
		    
		    reporter.config().setDocumentTitle("Selenium automation");
		    reporter.config().setReportName("Functional Test Report");
		    reporter.config().setTheme(Theme.STANDARD);
	            // call createTest method and pass the name of TestCase- Based on your requirement
		    ExtentTest logger=extent.createTest("LoginTest");
	            // log method will add logs in report and provide the log steps which will come in report
		    logger.log(Status.INFO, "Login to amazon");
		   
		    logger.log(Status.PASS, "Title verified");
		   
	            // Flush method will write the test in report- This is mandatory step  
		    extent.flush();
			
	            // You can call createTest method multiple times depends on your requirement
	            // In our case we are calling twice which will add 2 testcases in our report
		    ExtentTest logger2=extent.createTest("Logoff Test");
		    
		    logger2.log(Status.FAIL, "Title verified");
		    
		    //logger2.fail("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("E:\\logo.jpg").build());
	        
		   // logger2.pass("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("E:\\logo.jpg").build());
	 
	        logger2.addScreenCaptureFromPath("E:\\Logo.jpg");
		    
		    // This will add another test in report
		    extent.flush();
		    	
		}
		
	}

