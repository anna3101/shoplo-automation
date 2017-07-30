package tests;
import pageObjects.LoginPage;
import pageObjects.StartPage;
import testBase.FunctionalTest;
import testBase.TestData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Shoplo2LoginViaAdminPanel extends FunctionalTest {

@Test

public void loginViaAdminPanel () {
	driver.get("https://" + TestData.storeId + ".shoplo.com/admin");
	LoginPage storeLoginPage = new LoginPage(driver);
	assertTrue(storeLoginPage.pageReady());
	storeLoginPage.typeStoreEmail(TestData.storeEmail);
	storeLoginPage.typeStorePassword(TestData.storePassword);
	StartPage startPage = storeLoginPage.submit();
	
	assertTrue(startPage.pageReady());
	assertEquals("Start", startPage.pageHeader());
	assertEquals(TestData.userName, startPage.usernameHeader());
	assertEquals(TestData.storeName, startPage.storenameHeader());
	}
}

