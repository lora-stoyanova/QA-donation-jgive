package com.gjive.core;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Class that starts web browser and go to Home page - "https://jgive.herokuapp.com/new"
 * @author LSD
 *
 */
public class ChromeBrowser {
	public static WebDriver driver;
	
	/**
	 *This method opens new session of Chrome web browser 
	 */
	
	public static void startBrowser() {
		String driverPath = null;
		driverPath = Paths.get("chromedriver.exe").toAbsolutePath().toString();
		System.out.println("The taken driver path is: " + driverPath);
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	/**
	 * Go to home page support method (https://jgive.herokuapp.com/new/en/usd)
	 */
	public static void goToHomePage() {
		driver.get("https://jgive.herokuapp.com/new");
	}
	
	/**
	 * This method kills the browser
	 */
	public static void quit() {
		driver.quit();
	}


}
