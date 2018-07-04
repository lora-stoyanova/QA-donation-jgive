package com.jgive.tests.positive;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.gjive.core.ChromeBrowser;
import com.gjive.core.DonationTargetPage;
import com.jgive.elements.elementsConditions;
import com.jgive.pages.HomePage;
import com.jgive.pages.ItemDonationForm;

public class MainPage_Test {

	@Before
	public void setup() {
		ChromeBrowser.startBrowser();
		ChromeBrowser.goToHomePage();
	}

	@Test
	public void Donate() {
		
		
		HomePage.SelectActiveProject();
		DonationTargetPage.donateNowButton();

		if (elementsConditions.modal_PurposeDisplayed() & elementsConditions.modal_CustomDisplayed()) {
			ItemDonationForm.mixDonation();
		} else if (elementsConditions.modal_CustomDisplayed() & !elementsConditions.modal_PurposeDisplayed()) {
			ItemDonationForm.customDonation();
		} else if (elementsConditions.modal_PurposeDisplayed()) {
			ItemDonationForm.purposeDonation();
		} else if (elementsConditions.modal_SuggestedDisplayed()) {
			ItemDonationForm.suggestedDonation();
		}

		ItemDonationForm.clickDonateNowBtn();

		// CheckoutPage.gotoCart("edit");
		// CartPage.SelectCurrency();
		// CartPage.donateToJgiveSelect("1");
		// CartPage.donateToJgiveOther(1000);
	}

	@After
	public void tearDown() {
		ChromeBrowser.driver.quit();
	}
}
