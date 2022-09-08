package androidUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	
	
	public void longPress(WebElement element,AndroidDriver driver) {
		((JavascriptExecutor)driver).executeScript("mobile:longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
						"duration",2000));
	}
	
	public void scrollTillEnd(AndroidDriver driver) {
		
		boolean canScrollMore;
		do{
			 canScrollMore=	(Boolean)((JavascriptExecutor)driver).executeScript("mobile:scrollGesture", 
				ImmutableMap.of("left",100,"top",100,"width",200,"height",200,
							"direction","down",
							"percent",3.0));
			 
		}while(canScrollMore);
	}
	
	public void scrollTillText(String text,AndroidDriver driver) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" +text +"\"));"));
	}
	
	public void swipeFunction(WebElement element,String direction,AndroidDriver driver) {
		
		((JavascriptExecutor)driver).executeScript("mobile:swipeGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
						"direction",direction,
						 "percent",0.75));
	}
	
	public void DragandDropFunction(WebElement element,int xcordinate,int ycordinate,AndroidDriver driver) {
		
		((JavascriptExecutor)driver).executeScript("mobile:dragGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
						"endX",xcordinate,
						 "endY",ycordinate));
	}
	
	public void landscapeMode(AndroidDriver driver) {
		
		DeviceRotation landscape=new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
	}
	
	public void explicitWait(int seconds,WebElement element,AndroidDriver driver) {
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(seconds));
	 wait.until(ExpectedConditions.visibilityOf(element));

}
	
	public List<HashMap<String, String>> getJsonData(String jsonPath) throws IOException {
		String jsonContent=FileUtils.readFileToString(new File(jsonPath),StandardCharsets.UTF_8);
	    ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data= mapper.readValue(jsonContent, 
		            new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		
	}
	
	public String getScreenshotPath(String testCaseName, AndroidDriver driver) throws IOException {
		
		File source=driver.getScreenshotAs(OutputType.FILE);
		String destinationPath=System.getProperty("user.dir")+"\\reports"+testCaseName+".png" ;
		FileUtils.copyFile(source,  new File(destinationPath));
		
		return destinationPath;
	}
}
