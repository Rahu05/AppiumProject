package org.rahulAppium.android.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import androidUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage extends AndroidActions {
	
	AndroidDriver driver;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private WebElement addToCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartButton;
	
	
	
	public ProductPage(AndroidDriver driver) {
		//super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	
	public void addProducts() {
		addToCart.click();	
	}

	public void clickCart() throws InterruptedException {
		cartButton.click();
		//Thread.sleep(5000);
	}

}
