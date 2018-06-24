package com.jgive.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gjive.core.ChromeBrowser;
import com.jgive.elements.WaitTool;
import com.jgive.elements.elementsConditions;
import com.jgive.elements.html;

/**
 * Class that implements assertions for modals forms
 * 
 * @author LSD
 *
 */
public class ItemDonationForm {

	/**
	 * Check of combined form. There are several asserts of modal form: 1. If Custom
	 * amount is 0 AND radio buttons are NOT selected -> clicks on Donate button and
	 * verifies that Error message appears; 2.Check if amount per row is added in
	 * total amount for one click; 3.Verifies that radio buttons work correctly i.e.
	 * only one selected; 4. If radio button is selected, assert that value
	 * attribute in total amount is empty; 5. Verifies input of 20 that is considered in total amount;
	 */

	public static void mixDonation() {
		// --------------------------------------------------------------
		if (elementsConditions.modal_customZeroDisplayed() && (html.radioBtnsOff.size() == 3)) {
			html.donateTargetBtn.click();
			assertTrue(elementsConditions.modal_errorAlertDisplayed(),
					"Error alert should be dispalyed when try to submit empty form!");
		}
		// --------------------------------------------------------------

		int i = 1;
		for (WebElement inputPurposeAmount : html.inputPurposeAmount) {
			WebElement plus = WaitTool.waitForElement(ChromeBrowser.driver,
					By.xpath("(//div[contains(@class, 'Purposes__plus')])[" + i + "]/span"), 5);
			System.out.println(plus);
			plus.click();

			WebElement purposeAmountPerRow = WaitTool.waitForElement(ChromeBrowser.driver,
					By.xpath("(//div[contains(@class, 'Purposes__amount')])[" + i + "]/span"), 5);
			int s_purposeAmountPerRow = Integer.parseInt(purposeAmountPerRow.getText().substring(1));
			int total = Integer.parseInt(html.totalAmount.getText().substring(1));
			
			assertEquals(total, s_purposeAmountPerRow, "Amount per row is not considered in Total amount");
			assertTrue((html.radioBtnsON.size() == 1), "Only one radio button should be selected at click!");
			
			i++;
		}

		// --------------------------------------------------------------
		assertTrue((html.radioBtnsOff.size() == 1 && html.totalAmount.getAttribute("Value").isEmpty()),
				"Cannot have selected radio bnt and value in total amount !Emplty.");
		
		// --------------------------------------------------------------
		html.customAmount.sendKeys("20");
		assertEquals(Integer.parseInt(html.totalAmount.getAttribute("value")), 20, "Total amount is not correct. Should be 20!");
		
	}

	public static void customDonation(int anountToDonate) {
	}

	public static void suggestedDonation() {
	}

	public static void purposeDonation() {
	}

}
