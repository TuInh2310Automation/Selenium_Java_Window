package tiki.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Shopper_01_Manage_Cart {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeTest(alwaysRun = true)
	public void init_Browser() {
		System.out.println("-------------Open browser and driver-----------");
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test(groups = { "admin", "cart" })
	public void Cart_01_Create_Visa() {

	}

	@Test(groups = { "admin", "cart" })
	public void Cart_02_View_Visa() {

	}

	@Test(groups = { "admin", "cart" })
	public void Cart_03_Update_Visa() {

	}

	@Test(groups = { "admin", "cart" })
	public void Cart_04_Delete_Visa() {

	}
	
	@AfterTest(alwaysRun = true)
	public void cleanBrowser() {
		System.out.println("-------------Close browser and driver-----------");
		driver.quit();
	}
}
