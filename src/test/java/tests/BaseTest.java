package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.common;
public class BaseTest {

	common common;

	static WebDriver driver;
	
	@Parameters({"browser", "url"})
	@BeforeTest
	public void beforeTest(String browser, String url) {
		common = new common();
		common.setupBrowser(browser, url);
		driver = common.getDriver();
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void afterTest() {
		common.quitBrowser();
	} 
	
	
}

