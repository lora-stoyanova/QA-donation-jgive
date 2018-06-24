package com.jgive.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.gjive.core.ChromeBrowser;

public class SelectProjectTestNG {
	public static WebDriver driver;

	@DataProvider
	public static String[][] testData() {
		return new String[][] {
			new String[] { "//div[contains(@class, 'slick-slide slick-active')][1]//div[@class='card-body Thumbnail__card-body__1wxZe']//a", "//h3[@class='DonationTargetShow__project-name__2Cdf5']"},
			new String[] { "//div[contains(@class, 'slick-slide slick-active')][2]//div[@class='card-body Thumbnail__card-body__1wxZe']//a", "//h3[@class='DonationTargetShow__project-name__2Cdf5']"},
			new String[] { "//div[contains(@class, 'slick-slide slick-active')][3]//div[@class='card-body Thumbnail__card-body__1wxZe']//a", "//h3[@class='DonationTargetShow__project-name__2Cdf5']"}, 
	    };
	}
	
	@BeforeMethod
	public void startBrowser() {
		ChromeBrowser.goToHomePage();
	}
	
	@Test(dataProvider = "testData")
	public static void TestSelectProject(String projectPick, String projectPicked) {
		System.out.println("driver=" + ChromeBrowser.driver);
		WebElement project = ChromeBrowser.driver.findElement(By.xpath(projectPick));
		String projectRef = project.getText();
		project.click();
		
		
		WebElement projectTarget = ChromeBrowser.driver.findElement(By.xpath(projectPicked));
		String projectTrg = projectTarget.getText();
		assertEquals("Project name on home page is not equal to project name at Donation Target Page", projectRef, projectTrg);

	}
	
	
	@AfterMethod
	public void quit() {
		ChromeBrowser.driver.quit();
	}
	
	
	
}
