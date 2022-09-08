package org.rahulAppium.testCase;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rahul.TestUtils.BaseTest;
import org.rahulAppium.android.pageFactory.CartPage;
import org.rahulAppium.android.pageFactory.FormFillPage;
import org.rahulAppium.android.pageFactory.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import androidUtils.AndroidActions;
import io.appium.java_client.android.Activity;

public class TC_01_Ecommerce extends BaseTest {
	

	@Test(dataProvider="getData",groups={"smoke"})
	public void formFill(HashMap<String, String> input) throws InterruptedException {

		// Form Page
		
		FormFillPage home = new FormFillPage(driver);
		home.goToHomePage();
		home.setNameField(input.get("name"));
		home.selectGender(input.get("gender"));
		home.selectCountryDropDown(input.get("country"));
		home.clickSubmit();
		
		
	}

	// Add to Cart
	@Test(enabled = true)
	public void productPage() throws InterruptedException {

		ProductPage prod = new ProductPage(driver);
		prod.addProducts();
		prod.addProducts();
		prod.clickCart();
		CartPage cart =new CartPage(driver); 
		  String cartTitle=cart.getCartTitle();
	  Assert.assertEquals(cartTitle, "Cart"); 
	  double totalSum=cart.totalSum();
	  System.out.println(totalSum); 
	  double displaySum=cart.displaySum();
	  System.out.println(displaySum); 
	  Assert.assertEquals(totalSum, displaySum);
		 	

	}
	
	@DataProvider
	
	public Object[][] getData() throws IOException {
		
	AndroidActions action=new AndroidActions();	
	List<HashMap<String,String>> data=action.getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\org\\rahul\\testData\\appium.json");
	return new Object[][] {{data.get(0)},{data.get(1)}};
		//return new Object[][] {{"Raushan","male","Argentina"},{"Rohit","female","Argentina"}};
	}
	
	
	
	

	// Cart Page
	
	 /* @Test 
	  
	  public void cartPage() throws InterruptedException { 
		  
		  CartPage cart =new CartPage(driver); 
		  String cartTitle=cart.getCartTitle();
	  Assert.assertEquals(cartTitle, "Cart"); 
	  double totalSum=cart.totalSum();
	  System.out.println(totalSum); 
	  double displaySum=cart.displaySum();
	  System.out.println(displaySum); 
	  Assert.assertEquals(totalSum, displaySum);*/
	  
	  
	  
		/*
		 * System.out.println("Rahul Pandey678"); Thread.sleep(10000); WebDriverWait
		 * wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
		 * "//android.widget.TextView[@text='Cart']"))));
		 * 
		 * String cartTitle=driver.findElement(By.xpath(
		 * "//android.widget.TextView[@text='Cart']")).getText();
		 * Assert.assertEquals(cartTitle,"Cart");
		 */
	  
	  //Thread.sleep(3000);
	  
	  
	  
	  }
	 

