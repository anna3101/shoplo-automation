package tests;

import pageObjects.ConfirmationPage;
import pageObjects.CreateAccountPage;
import pageObjects.StartPage;
import testBase.FunctionalTest;
import testBase.TestData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Shoplo1CreateAccount extends FunctionalTest {
	@Test
	public void createShoploAccount() {
		driver.get("https://store.shoplo.com/pl/register");
		CreateAccountPage registerPage = new CreateAccountPage(driver);
		assertTrue(registerPage.pageReady());
		
		registerPage.typeStoreName(TestData.storeRegisterName);
		registerPage.typeStoreEmail(TestData.storeRegisterEmail);
		registerPage.typeStorePassword(TestData.storePassword);
		ConfirmationPage welcomePage = registerPage.submit();
		assertTrue(welcomePage.pageReady());
		assertEquals("Witaj w Shoplo!", welcomePage.welcomeHeader());

		welcomePage.typeName(TestData.userName);
		welcomePage.typePhone(TestData.phone);
		welcomePage.selectSelling(TestData.sellingValue);
		welcomePage.selectReason(TestData.reasonValue);
		welcomePage.selectAbout(TestData.aboutValue);
		StartPage startPage = welcomePage.submit();
		assertTrue(startPage.pageReady());
		assertEquals("Start", startPage.pageHeader());
		assertEquals(TestData.userName, startPage.usernameHeader());
		assertEquals(TestData.storeName, startPage.storenameHeader());
	}
}
