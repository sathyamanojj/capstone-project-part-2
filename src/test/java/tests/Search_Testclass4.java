package tests;

import java.time.Duration;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.Login;
import utils.keyword;

public class Search_Testclass4 extends BaseTest {

	keyword kw;

	@BeforeClass
	public void beforeClass() {
		kw = new keyword(driver);
	}

//	1. Use navigation, to search for mobile such as mi mobile
	@Test
	public void a_search_mimobile() {
		kw.amazonSearchbox();

	}

	/*
	 * // 2. Validate the results, for instance, 1-16 of 264 results for mi mobile
	 * 
	 * @Test(dependsOnMethods={"a_search_mimobile"}) public void b_search_results()
	 * { kw.search_result(); }
	 */
//3. Select Avg. Customer Review as 4 stars & up
	// @Test(dependsOnMethods={"b_search_results"})
	@Test(dependsOnMethods = { "a_search_mimobile" })
	public void c_customer_review() {
		kw.average4StarRating();
	}

//Select the first mobile, and in this case, Redmi Note 8 (Moonlight White, 6GB RAM, 128GB Storage)	
	@Test(dependsOnMethods = { "c_customer_review" })
	public void d_first_Mobile() {
		kw.pageWait();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kw.selectMobile();

	}

//Validate the change in the title, whether it is relevant to the selected mobile
	@Test(dependsOnMethods = { "d_first_Mobile" })
	public void e_validate_Mobile() {
		try {
			kw.switchTabs();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("switched to different iframe to validate the mobile title");
		String actual = kw.getCurrentPageTitle();
		Reporter.log("current page title is " + actual);

	}

//Get the mobile price and validate it
	@Test(dependsOnMethods = { "e_validate_Mobile" })
	public void f_validate_Mobile_Price() {
		kw.mobilePrice();
	}

//Validate the Delivery location 
	// a. Click on the Select delivery location

	@Test(dependsOnMethods = { "f_validate_Mobile_Price" })
	public void g_validate_Delivery_Location() {
		kw.deliveryLocation();
		Reporter.log("Delivery location selected successfully");

	}

//	Popup window and pincode validation
//	a. Wait for the pop up Choose your location to appear
	// b. Enter the pincode and click on the Apply button
	// c. Validate the change in the delivery location.
	// d. It should display Deliver to<citypincode>
	@Test(dependsOnMethods = { "g_validate_Delivery_Location" })
	public void validate_Pincode() {
		kw.enterPincode();
		Reporter.log("Pincode entered successfully");

	}

	/********
	 * Sponsored link does not have a Iframe and does not navigate to separate
	 * window
	 *************/
//	8. Click on the sponsored link as shown below :
//	a. Use IFrame to click on the link
//	b. Upon clicking the link, verify whether a new window is opened with the
//	mobile details
//	c. Navigate to the new window and close it
//	d. Navigate back to the previous window	
	@Test(dependsOnMethods = { "validate_Pincode" })
	public void sponsored_link() {
		kw.pageWait();
		kw.clickSponsored();
		Reporter.log("first item from sponsored item is chosen");
		driver.navigate().back();
	}

//9. Click on Add to Cart
//a. Wait for the window to be displayed
//	b. Validate the Added to Cart message
//	c. Close the Added to Cart window	
	@Test(dependsOnMethods = { "sponsored_link" })
	public void add_To_Cart() {

		kw.addCartItem();
		Reporter.log("added to cart successfully");
		kw.pageWait();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		kw.addedCartItem();
		kw.pageWait();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		kw.closeSheet();

	}

	// 10. Use JavaScriptExecutor to scroll the page downwards until the ‘Technical
	// Details’ are displayed
	@Test(dependsOnMethods = { "add_To_Cart" })
	public void tecnical_Details() {
		kw.pageWait();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		kw.tecDetails();

	}

}
