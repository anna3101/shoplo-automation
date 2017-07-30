package automation;
import automation.TestData;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Shoplo2LoginViaShoploSite extends FunctionalTest {

@Test

public void loginViaShoploSite () {
	driver.get("https://www.shoplo.pl/");
	ShoploPortalPage shoploPage = new ShoploPortalPage(driver);
	//shoploPage.clickLoginButton();
	CreateAccountPage loginPage = shoploPage.clickSecondaryLoginButton();
	loginPage.typeStoreName(TestData.storeId);
	loginPage.typeStoreEmail(TestData.storeEmail);
	loginPage.typeStorePassword(TestData.storePassword);
	loginPage.submit();
	StartPage startPage = new StartPage(driver);
	assertEquals("Start", startPage.pageHeader());
	assertEquals(TestData.userName, startPage.usernameHeader());
	assertEquals(TestData.storeName, startPage.storenameHeader());
}

}

