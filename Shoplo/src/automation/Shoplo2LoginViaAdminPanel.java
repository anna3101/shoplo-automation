package automation;
import automation.TestData;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Shoplo2LoginViaAdminPanel extends FunctionalTest {

@Test

public void loginViaAdminPanel () {
	driver.get("https://" + TestData.storeId + ".shoplo.com/admin");
	LoginPage storeLoginPage = new LoginPage(driver);
	storeLoginPage.typeStoreEmail(TestData.storeEmail);
	storeLoginPage.typeStorePassword(TestData.storePassword);
	StartPage startPage = storeLoginPage.submit();
	
	assertEquals("Start", startPage.pageHeader());
	assertEquals(TestData.userName, startPage.usernameHeader());
	assertEquals(TestData.storeName, startPage.storenameHeader());
}

}

