package webdriver;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_28_Page_Ready {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	Actions actions;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}

		driver = new ChromeDriver();
		actions = new Actions(driver);
		explicitWait = new WebDriverWait(driver, 30);
	}
	
	

	//@Test
	public void TC_01_OrangrHM() {
		driver.get("https://api.orangehrm.com/");
		//Wait đến khi loading icon biến mất
		//Và khi biến mất thì cái trang n sẽ load hết dữ liệu về thành công
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loader>div.spinner")));
		assertEquals(driver.findElement(By.cssSelector("div#project h1")).getText(), "OrangeHRM REST API Documentation");
	}

	@Test
	public void TC_02_NopCpmmerce() {
		driver.get("https://admin-demo.nopcommerce.com/");
		
		driver.findElement(By.cssSelector("input#Email")).clear();
		driver.findElement(By.cssSelector("input#Email")).sendKeys("admin@yourstore.com");
		
		driver.findElement(By.cssSelector("input#Password")).clear();
		driver.findElement(By.cssSelector("input#Password")).sendKeys("admin");
		
		driver.findElement(By.cssSelector("button.login-button")).click();
		assertTrue(isPageLoadedSuccess());
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		assertTrue(waitForAjaxBusyLoadingInvisible());
		assertEquals(driver.getTitle(), "Your store. Login");
		
	}
	
	public boolean isPageLoadedSuccess() {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	
	public boolean waitForAjaxBusyLoadingInvisible()
	{
		return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy>span")));
	}

	//@Test
	public void TC_03_Blog_Test_Project() {
		driver.get("https://blog.testproject.io/");
		// Hover chuột vào 1 element bất kì tại page này để page ready
		actions.moveToElement(driver.findElement(By.cssSelector("h1.main-heading"))).perform();
		assertTrue(isPageLoadedSuccess());
		String keyword="Selenium";
		driver.findElement(By.cssSelector("")).sendKeys(keyword);
		driver.findElement(By.cssSelector("")).click();
		
		//Wait for page heading visible
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(null));
		assertTrue(isPageLoadedSuccess());
		
		
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}