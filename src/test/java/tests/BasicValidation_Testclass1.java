package tests;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.keyword;

public class BasicValidation_Testclass1 extends BaseTest{

	keyword kw;
	
	@BeforeClass
	public void beforeClass() {
		kw = new keyword(driver);
	}
	
	//Enter the URL as http://amzn.in and check whether the URL is
		//redirected to https://www.amazon.in/
	
	@Test
	public void urlValidation() {
		String expectedUrl = "https://www.amazon.in/";
		String actualUrl = kw.getCurrentPageUrl();
		String failureMessage = "URL validation failed";
		
		kw.compareText(expectedUrl, actualUrl, failureMessage);
		Reporter.log("Expected URL = " +expectedUrl);
		Reporter.log("Actual URL = " +actualUrl);
	}
	
	//Validate the page title —Online Shopping site in India: Shop Online for
	//Mobiles, Books, Watches, Shoes and More - Amazon.in
	
	@Test
	public void titleValidation() {
		
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle = kw.getCurrentPageTitle();
		String failureMessage = "Page title validation failed";
		
		kw.compareText(expectedTitle, actualTitle, failureMessage);
		Reporter.log("Expected title = "+expectedTitle);
		Reporter.log("Actual title = "+actualTitle);
	}
	
}

