package com.jgive.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.gjive.core.ChromeBrowser;
/**
 * utility class for wait of displayed elements
 * @author LSD
 *
 */

public class elementsConditions {
	
	public static Boolean modal_PurposeDisplayed() {
		List<WebElement> modal_purposeAmount =  WaitTool.waitForListElementsPresent(ChromeBrowser.driver,(By.xpath("//input[contains(@id,'purposeAmount')]")), 10);
		return !modal_purposeAmount.isEmpty();
	}

	public static Boolean modal_CustomDisplayed() {
		WebElement modal_customAmount =  WaitTool.waitForElementPresent(ChromeBrowser.driver,(By.xpath("//input[contains(@id,'customAmount')]")), 10);
		return modal_customAmount.isDisplayed();
	}  
	
	
	public static Boolean modal_SuggestedDisplayed() {
		WebElement modal_suggestedAmount =  WaitTool.waitForElementPresent(ChromeBrowser.driver,(By.xpath("//input[contains(@id,'suggestedAmount')]")), 10);
		return modal_suggestedAmount.isDisplayed();
	}  
	
	public static Boolean modal_customZeroDisplayed() {
		WebElement customAmountZero =  WaitTool.waitForElementPresent(ChromeBrowser.driver,(By.xpath("//input[contains(@id,'customAmount')]")), 10);
		return customAmountZero.getAttribute("value").isEmpty();
	}  
	
	public static Boolean modal_errorAlertDisplayed() {
		WebElement errorAlertDisplayed =  WaitTool.waitForElementPresent(ChromeBrowser.driver,(By.xpath("//div[contains(@class,'invalid-feedback')]")), 10);
		return errorAlertDisplayed.isDisplayed();
	}
	
	
//	public static Boolean modal_purposeAmount = ChromeBrowser.driver.findElement(By.xpath("//input[contains(@id,'purposeAmount')]")).isDisplayed();
//	public static Boolean modal_customAmount = ChromeBrowser.driver.findElement(By.xpath("//input[contains(@id,'customAmount')]")).isDisplayed();
//	public static Boolean modal_suggestedAmount = ChromeBrowser.driver.findElement(By.xpath("//input[contains(@id,'suggestedAmount')]")).isDisplayed();
//	public static Boolean customAmountZero = ChromeBrowser.driver.findElement(By.xpath("//input[contains(@id, 'customAmount')]")).getAttribute("value").contains("0");
	//	public static Boolean errorAlertDisplayed = ChromeBrowser.driver.findElement(By.xpath("//div[contains(@class,'invalid-feedback')]")).isDisplayed(); 
}
