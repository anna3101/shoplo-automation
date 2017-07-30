package tests;
import pageObjects.CreateAccountPage;
import pageObjects.ShoploPortalPage;
import pageObjects.StartPage;
import testBase.FunctionalTest;
import testBase.TestData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Shoplo2LoginViaShoploSite extends FunctionalTest {

@Test
public void loginViaShoploSite () {
	driver.get("https://www.shoplo.pl/");
	ShoploPortalPage shoploPage = new ShoploPortalPage(driver);
	assertTrue(shoploPage.pageReady());
	
	CreateAccountPage loginPage = shoploPage.clickSecondaryLoginButton();
	assertTrue(loginPage.pageReady());
	loginPage.typeStoreName(TestData.storeId);
	loginPage.typeStoreEmail(TestData.storeEmail);
	loginPage.typeStorePassword(TestData.storePassword);
	loginPage.submit();
	
	StartPage startPage = new StartPage(driver);
	assertTrue(startPage.pageReady());
	assertEquals("Start", startPage.pageHeader());
	assertEquals(TestData.userName, startPage.usernameHeader());
	assertEquals(TestData.storeName, startPage.storenameHeader());
	}
}

