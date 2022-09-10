package tests;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.Login;
import utils.keyword;

public class Navigation_Testclass2 extends BaseTest
{
keyword kw;
	
	@BeforeClass
	public void beforeClass() {
		kw = new keyword(driver);
	}
	
	//Use the navigation to navigate to Accounts and Lists ➔ Create a Wish List, and
	//verify whether the navigation was successful
	
	@Test(priority = 0)
	public void wishlist()
	{
		Login obj = new Login(driver);
		obj.accountWishlist();
		String expectedtitle="Wish List";
		String actualTitle = kw.getCurrentPageTitle();
		String failureMessage = "Page title validation failed";
		
		kw.compareText(expectedtitle, actualTitle, failureMessage);
		Reporter.log("Expected title = "+expectedtitle);
		Reporter.log("Actual title = "+actualTitle);
		Reporter.log("wish list web page validated successfully");
		
	}
	
	//Use Navigation to navigate to Amazon Pay module and validate the web page
	
	@Test(priority = 1)
	public void AmazonPay()
	{
		Login obj=new Login (driver);
		obj.accountPayModule();
		Reporter.log("Account pay module web page navigated successfully");
		
	}
	
	//Use Navigation to navigate to New Releases module and validate the web page
	@Test(priority = 2)
	public void NewRelease()
	{
		Login obj=new Login (driver);
		obj.newReleaseModule();
		Reporter.log("New Release module web page navigated successfully");
		
	}
		
}
