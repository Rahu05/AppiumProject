package org.rahulAppium.android.pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import androidUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions{
	AndroidDriver driver;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Cart']")
	private WebElement cartTitle;
	
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrices;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement displayPrice;
	

	public CartPage(AndroidDriver driver) {
		//super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	
	public String getCartTitle() throws InterruptedException {
		explicitWait(5,cartTitle,driver);
		return cartTitle.getText();
		 
	}
	
	public double totalSum() {
		double sum=0;
		  for(int i=0;i<productPrices.size();i++) {
			  
		 String amountString= productPrices.get(i).getText();
			  String withoutDollar= amountString.substring(1);
			  double amount=Double.parseDouble(withoutDollar);
		  sum=sum+amount; 

	}
		return sum;
	}
	
	public double displaySum() {
		
		String amountString= displayPrice.getText();   
		String withoutDollar= amountString.substring(1);
		  double displayAmount=Double.parseDouble(withoutDollar);
		  return displayAmount;
		
	}

}
