package com.jgive.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.gjive.core.ChromeBrowser;

public class html {
	
	public static List<WebElement> radioBtnsOff =  WaitTool.waitForListElementsPresent(ChromeBrowser.driver,By.xpath("//span[@class='ji ji-radio-off']"), 5);
	
	public static List<WebElement> radioBtnsON = WaitTool.waitForListElementsPresent(ChromeBrowser.driver,By.xpath("//span[@class='ji ji-radio-on']"), 10); 
	
	public static List<WebElement> inputPurposeAmount = WaitTool.waitForListElementsPresent(ChromeBrowser.driver,By.xpath("//input[contains(@id,'purposeAmount')]"), 5); 

	public static List<WebElement> plus = WaitTool.waitForListElementsPresent(ChromeBrowser.driver, By.xpath("//div[contains(@class, 'Purposes__plus')]"),5);
	
	public static WebElement totalAmount = WaitTool.waitForElementPresent(ChromeBrowser.driver, By.xpath("//p[contains(@class, 'DonationForm__total-donation__3STHW')]/span/span"),5);
	
	public static WebElement customAmount = WaitTool.waitForElementPresent(ChromeBrowser.driver, By.xpath("//input[contains(@id, \"customAmount\")]"),5);
	
	public static WebElement donateTargetBtn = WaitTool.waitForElementPresent(ChromeBrowser.driver, By.xpath("//button[contains(@class,'DonationForm__checkout-button')]"),5);
	
}
