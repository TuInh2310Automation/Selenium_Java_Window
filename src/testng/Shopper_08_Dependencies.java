package testng;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class Shopper_08_Dependencies {
	@Test
	public void Product_01_Create_Product() {
		assertTrue(false);
	}
	
	@Test(dependsOnMethods = "Product_01_Create_Product")
	public void Product_02_View_Product() {
		
	}
	
	@Test(dependsOnMethods = "Product_01_Create_Product")
	public void Product_03_Update_Product() {
		
	}
	
	@Test(dependsOnMethods = "Product_01_Create_Product")
	public void Product_04_Delete_Product() {
		
	}
}
