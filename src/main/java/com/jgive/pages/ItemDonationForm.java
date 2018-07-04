package com.jgive.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	 * attribute in total amount is empty; 5. Verifies input of 20 that is
	 * considered in total amount;
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

			WebElement purpuseRow = WaitTool.waitForElement(ChromeBrowser.driver,
					By.xpath("(//div[contains(@class, 'Purposes__purpose-container__1l4Ao')])[" + i + "]"), 5);

			purpuseRow.click();

			WebElement purposeAmountPerRow = WaitTool.waitForElement(ChromeBrowser.driver,
					By.xpath("(//div[contains(@class, 'Purposes__amount')])[" + i + "]/span"), 10);
			int s_purposeAmountPerRow = Integer.parseInt(purposeAmountPerRow.getText().substring(1));
			int total = Integer.parseInt(html.totalAmount.getText().substring(1));

			assertEquals(total, s_purposeAmountPerRow, "Amount per row is not considered in Total amount");

			// /----------------------------------------------------------------------------CHECK
			// THIS
//			assertTrue((html.radioBtnsON.size() == 1 && html.radioBtnsOff.size() == 1),
//					"Only one radio button should be selected at click!");
			i++;
		}

		// --------------------------------------------------------------
		assertTrue((html.radioBtnsOff.size() == 1 && html.totalAmount.getAttribute("Value").isEmpty()),
				"Cannot have selected radio bnt and value in total amount !Emplty.");

		// --------------------------------------------------------------

		Random rand = new Random();
		String value = Integer.toString(rand.nextInt(300));
		html.customAmount.sendKeys(value);
		System.out.println(value);
		if (value.equals("0")) {
			assertTrue(elementsConditions.modal_errorAlertDisplayed(),
					"Error alert should be dispalyed when insert 0 to custom field!");
		} else {
			assertEquals(Integer.parseInt(html.totalAmount.getAttribute("value")), value,
					"Total amount is not correct. Should be " + value + "!");
		}
	}

	public static void customDonation() {
		Random rand = new Random();
		String value = Integer.toString(rand.nextInt(300));
		html.customAmount.sendKeys(value);
		
		System.out.println(value);
		
		if (value.equals("0")) {
			assertTrue(elementsConditions.modal_errorAlertDisplayed(),
					"Error alert should be dispalyed when insert 0 to custom field!");
		} else {
			assertEquals(Integer.parseInt(html.totalAmount.getText().substring(1, value.length()+1)), Integer.parseInt(value),
					"Total amount is not correct. Should be " + value + "!");
		}
		
		WebElement matching = WaitTool.waitForElement(ChromeBrowser.driver, By.xpath("//div[contains(@class, 'text-center Matching__matching-amount__cDGZN')]/span"), 2);
		
//		assertEquals(Integer.parseInt(matching.getText().substring(1, value.length()+1)),(Integer.parseInt(html.totalAmount.getText().substring(1, value.length()+1))*8) , "Custom matching amount should be *8! But is " + matching.getText());
		
	}
	public static void suggestedDonation() {
		int i = 1;
		for (WebElement inputSuggestedAmount : html.inputSuggested) {

			WebElement inputSuggestedBtn = WaitTool.waitForElement(ChromeBrowser.driver,
					By.xpath("(//input[contains(@id,'suggestedAmount')])[" + i + "]"), 5);

			inputSuggestedBtn.click();

			WebElement suggestedAmountPerRow = WaitTool.waitForElement(ChromeBrowser.driver,
					By.xpath("(//div[contains(@class, 'Purposes__amount')])[" + i + "]/span"), 10);
			int s_suggestedAmountPerRow = Integer.parseInt(suggestedAmountPerRow.getText().substring(1));
			int total = Integer.parseInt(html.totalAmount.getText().substring(1));

			assertEquals(total, s_suggestedAmountPerRow, "Amount per row is not considered in Total amount");
		}
	}

	public static void purposeDonation() {
		if (elementsConditions.modal_customZeroDisplayed() && (html.radioBtnsOff.size() == 3)) {
			html.donateTargetBtn.click();
			assertTrue(elementsConditions.modal_errorAlertDisplayed(),
					"Error alert should be dispalyed when try to submit empty form!");
		}
		// --------------------------------------------------------------

		int i = 1;
		for (WebElement inputPurposeAmount : html.inputPurposeAmount) {

			WebElement purpuseRow = WaitTool.waitForElement(ChromeBrowser.driver,
					By.xpath("(//div[contains(@class, 'Purposes__purpose-container__1l4Ao')])[" + i + "]"), 5);

			purpuseRow.click();

			WebElement purposeAmountPerRow = WaitTool.waitForElement(ChromeBrowser.driver,
					By.xpath("(//div[contains(@class, 'Purposes__amount')])[" + i + "]/span"), 10);
			int s_purposeAmountPerRow = Integer.parseInt(purposeAmountPerRow.getText().substring(1));
			int total = Integer.parseInt(html.totalAmount.getText().substring(1));

			assertEquals(total, s_purposeAmountPerRow, "Amount per row is not considered in Total amount");
			i++;
		}

		// --------------------------------------------------------------
		assertTrue((html.radioBtnsOff.size() == 1 && html.totalAmount.getAttribute("Value").isEmpty()),
				"Cannot have selected radio bnt and value in total amount !Emplty.");

	}

	public static void clickDonateNowBtn() {
		html.donateTargetBtn.click();
	}

}
