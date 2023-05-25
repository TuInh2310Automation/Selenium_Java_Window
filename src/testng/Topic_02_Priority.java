package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Topic_02_Priority {
	
	@Test(priority = 1)
	public void EndUser_Register_new_Employee() {
		
	}

	@Test(priority = 2)
	public void EndUser_View_Employee() {
		
	}
	
	@Test(priority = 3)
	public void EndUser_Edit_Employee() {
		
	}
	
	@Test(priority = 4)
	public void EndUser_Move_Employee() {
		
	}

}
