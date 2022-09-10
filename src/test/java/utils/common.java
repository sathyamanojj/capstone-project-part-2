package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class common {

private WebDriver driver;
	
	public void setupBrowser(String browser, String url) {

		String fs = System.getProperty("file.separator");
		String currDir = System.getProperty("user.dir");
		String path = currDir + fs + "drivers" + fs;

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", path + "geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", path + "msedgedriver.exe");
			driver = new EdgeDriver();
		}

		else if(browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}

		else {
			System.out.println("Valid input for browser was not provided, hence quitting the automation run");
			System.exit(0);
		}

		if(url!="")
			driver.get(url);
		else
			driver.get("about:blank");
	}


	public WebDriver getDriver() {
		return driver;
	}
	
	public void closeTab() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
}
