package com.jgive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.gjive.core.ChromeBrowser;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Assert;

/**
 * Support class to select active project from slider
 * 
 * @author LSD
 */

public class HomePage {
	public static WebDriver driver;

	/**
	 * Selects one of the project in slider
	 * 
	 * @param visibleProject
	 *            - "1" for first project from left to right; "2" for second
	 *            project; "3" for third project
	 */

	public static void SelectActiveProject() {
		Random rand = new Random();
		int n = rand.nextInt(3) + 1;

		String selectedProject = "//div[contains(@class, 'slick-slide slick-active')][" + n
				+ "]//div[@class='card-body Thumbnail__card-body__1wxZe']//a";
		System.out.println("Selected project is " + n);
		ChromeBrowser.driver.findElement(By.xpath(selectedProject)).click();
	}

}
