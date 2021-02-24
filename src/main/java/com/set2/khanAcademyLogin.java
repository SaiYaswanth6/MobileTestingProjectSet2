package com.set2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class khanAcademyLogin {
	public AndroidDriver driver;
	  @Test
	  public void login() throws InterruptedException, IOException {

		  File file= new File("C:\\Users\\MCSaiYaswanth\\Desktop\\SDET\\Mobile Testing\\ProjectSet2\\MobileTestingProjectSet2.xlsx");
	        FileInputStream fis= new FileInputStream(file);
	        XSSFWorkbook wb= new XSSFWorkbook(fis);
	        XSSFSheet sheet=wb.getSheetAt(0);
	        int rc= sheet.getLastRowNum();
	        System.out.println(rc);
	        for (int i=1;i<=rc;i++) {
	            String username=sheet.getRow(i).getCell(0).getStringCellValue();
	            String password=sheet.getRow(i).getCell(1).getStringCellValue();
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	            System.out.println(username + " , " + password);
	            driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
	            Thread.sleep(5000);
	            driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
	            driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Enter an e-mail address or username\")")).sendKeys(username);
	            driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Password\")")).sendKeys(password);
	            driver.hideKeyboard();
	            Thread.sleep(5000);
	            driver.findElementByAccessibilityId("Sign in").click();
	            Thread.sleep(10000);
	            driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Settings']")).click();
	            Thread.sleep(3000);
	            driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign out\")")).click();
	            driver.findElement(By.id("android:id/button1")).click();
	            Thread.sleep(4000);
	            driver.findElementByAccessibilityId("Back").click();
	            Thread.sleep(3000);
	         
	            }
	  }
	  
	@BeforeClass
	  public void beforeClass() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability = new DesiredCapabilities();
      //capability.setCapability("deviceName", "Sai");
      capability.setCapability(MobileCapabilityType.DEVICE_NAME,"Sai");
      capability.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
      capability.setCapability(MobileCapabilityType.NO_RESET,true);
      capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"org.khanacademy.android");
      capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"org.khanacademy.android.ui.library.MainActivity");
      driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      //driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
      Thread.sleep(3000);
	  }
	
	  @AfterClass
	  public void afterClass() {
		  //driver.closeApp();
	  }	  

}

