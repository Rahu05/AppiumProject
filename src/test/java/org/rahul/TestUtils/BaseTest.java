package org.rahul.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import androidUtils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest extends AndroidActions{
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass(alwaysRun=true)
	public void configureAppium() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\rahul\\resources\\data.properties");
		prop.load(fis);
		String IPAdress=prop.getProperty("ipAdress");
		String portno=prop.getProperty("port");
		String nodejsPath=prop.getProperty("nodejsPath");
		String deviceName=prop.getProperty("devicename");
		String URL=prop.getProperty("url");
		
		
		//Starting
		 service=new AppiumServiceBuilder().withAppiumJS(new File(nodejsPath))
				.withIPAddress(IPAdress).usingPort(Integer.parseInt(portno)).build();
				
		service.start();
				
				
	    UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName(deviceName);
		options.setApp(System.getProperty("user.dir")+"\\src\\main\\java\\org\\rahul\\resources\\General-Store.apk");
		//options.setApp("C:\\Users\\Rahul\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
				
		 driver=new AndroidDriver(new URL(URL), options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		//end
		//driver.quit();
		service.stop();
	}
	
	

}
