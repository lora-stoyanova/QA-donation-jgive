package com.gjive.core;

import org.openqa.selenium.By;
/**
 * Support class for Target Page
 * @author LSD
 *
 */
public class DonationTargetPage extends ChromeBrowser{
/**
 * Click on Donate Now Button
 */
	public static void donateNowButton() {
		ChromeBrowser.driver.findElement(By.xpath("//button[contains(@class,\"DonationTargetShow__donate-button\")]")).click();
	}

}
