package org.rahulAppium.android.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import androidUtils.AndroidActions;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormFillPage extends AndroidActions {
	
	AndroidDriver driver;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleGender;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleGender;
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countryDropDown;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Argentina']")
	private WebElement countryNameOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	
	
	
	
	
	
	public FormFillPage(AndroidDriver driver) {
		//super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	public void goToHomePage() {
		
		Activity activity=new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
	
	public void setNameField(String name) {
		nameField.sendKeys(name);	
		driver.hideKeyboard();	
	}
	
	public void selectGender(String gender) {
		
		if(gender.contains("male")) {
			
			maleGender.click();
		}
		
		else {
			femaleGender.click();
		}
		
	}
	
	public void selectCountryDropDown(String countryName) {
		
		countryDropDown.click();
		scrollTillText(countryName,driver);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		//countryNameOption.click();	
	}
	
	public void clickSubmit() {
		shopButton.click();
	}
	
	

}
