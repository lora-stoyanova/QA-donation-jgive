package com.jgive.pages;

import static org.junit.Assert.assertEquals;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gjive.core.ChromeBrowser;
/**
 * This is Data Driven Test. Input data is projects that are visible (their class name contains "slick-slide slick-active")in Home page under DonationTargets__carousel. 
 * In general test verifies that the labels of visible projects in home page are equals to label in Target page. 
 * @author LSD
 *
 */
@RunWith(Parameterized.class)
public class SelectProject {
	private String projectPick;
	private String projectPicked;
	public static WebDriver driver;
	
	/**
	 * This method is for input data. 
	 * @return - test data, passed as [][] Array
	 */
	@Parameters
	public static String[][] testData() {
		String[][] testData = { 
				{ "//div[contains(@class, 'slick-slide slick-active')][1]//div[@class='card-body Thumbnail__card-body__1wxZe']//a", "//h3[@class='DonationTargetShow__project-name__2Cdf5']"}, 
				{ "//div[contains(@class, 'slick-slide slick-active')][2]//div[@class='card-body Thumbnail__card-body__1wxZe']//a", "//h3[@class='DonationTargetShow__project-name__2Cdf5']"},
				{ "//div[contains(@class, 'slick-slide slick-active')][3]//div[@class='card-body Thumbnail__card-body__1wxZe']//a", "//h3[@class='DonationTargetShow__project-name__2Cdf5']"}, 
		};
		return testData;
	}

	/** 
	 * This is class constructor used to set fields
	 * @param projectPick - this is project on home page
	 * @param projectPicked - this is project on target page
	 */
	public SelectProject(String projectPick, String projectPicked) {
		this.projectPick = projectPick;
		this.projectPicked = projectPicked;
	} 
	
	/**
	 * Returns string of element HTML, that is passed as input data /Getter
	 * @return
	 */
	public String getProjectPick() {
		return this.projectPick;
	}
	/**
	 * Returns string of element HTML, that is passed as input data /Getter
	 * @return
	 */
	public String getProjectPicked() {
		return this.projectPicked;
	}
	
	/**
	 * Starts new session of the browser
	 */
	@Before
	public void startBrowser() {
//		//initialization of the webdriver instance
//		String driverPath = null;
//		driverPath = Paths.get("chromedriver.exe").toAbsolutePath().toString();
//		System.out.println("The taken driver path is: " + driverPath);
//		
//		System.setProperty("webdriver.chrome.driver", driverPath);
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		
//		//open the desired page
//		driver.get("https://jgive.herokuapp.com/new");
		ChromeBrowser.goToHomePage();
	}
	
	
	/**
	 * It asserts that selected project redirects to correct Target page information for this project.
	 */
	@Test	
	public void TestSelectProject() {
		System.out.println("driver=" + ChromeBrowser.driver);
		WebElement project = ChromeBrowser.driver.findElement(By.xpath(getProjectPick()));
		String projectRef = project.getText();
		project.click();
		
		WebElement projectTarget = ChromeBrowser.driver.findElement(By.xpath(getProjectPicked()));
		String projectTrg = projectTarget.getText();
		assertEquals("Project name on home page is not equal to project name at Donation Target Page", projectRef, projectTrg);
	}
	
	/**
	 * This method kills the browser
	 */
	
	@After
	public void quit() {
		ChromeBrowser.driver.quit();
	}

}
