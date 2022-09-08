package org.rahulAppium.testCase;

import org.openqa.selenium.By;
import org.rahul.TestUtils.BaseTest;
import org.rahulAppium.android.pageFactory.FormFillPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public class TC02_Ecommerce extends BaseTest {
	
	FormFillPage pricePage;
	
	@BeforeMethod
	public void setHomepageScreen() {
		
		Activity activity=new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
		
	}
	
	
	@Test
	public void formPage_negativeTestcase() {
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul Pandey");
		//Unique
		
		 pricePage=new FormFillPage(driver) ;
		driver.hideKeyboard();
		
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		//driver.findElement(By.id("android:id/text1")).click();
		//scrollTillText("Argentina");
		pricePage.selectCountryDropDown("Argentina");
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		String actualToastmessage=driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		Assert.assertEquals(actualToastmessage, "Please enter your name");
		System.out.println("rahul 1");
		System.out.println("Rahul branch3");

}

	@Test
	public void formPage_positiveTestcase() {
		
		pricePage.setNameField("Rahul");
		pricePage.selectGender("male");
		pricePage.selectCountryDropDown("Argentina");
		pricePage.clickSubmit();
	}
	
	
	}
		
	

