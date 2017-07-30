package automation;

import automation.TestData;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Shoplo1CreateAccount extends FunctionalTest {
	@Test
	public void createShoploAccount() {
		    driver.get("https://store.shoplo.com/pl/register");
	        CreateAccountPage registerPage = new CreateAccountPage(driver);
	       // assertTrue(registerPage.isInitialized());

	        registerPage.typeStoreName(TestData.storeName);
	        registerPage.typeStoreEmail(TestData.storeEmail);
	        registerPage.typeStorePassword(TestData.storePassword);

	        ConfirmationPage welcomePage = registerPage.submit();
	     //   assertTrue(afterRegPage.isInitialized());

	     assertEquals("Witaj w Shoplo!", welcomePage.welcomeHeader());
	     
	     welcomePage.typeName(TestData.userName);
	     welcomePage.typePhone(TestData.phone);
	     welcomePage.selectSelling(TestData.sellingValue);
	     welcomePage.selectReason(TestData.reasonValue);
	     welcomePage.selectAbout(TestData.aboutValue);
	     welcomePage.submit();
	     
	     StartPage startPage = welcomePage.submit();
	     
	    assertEquals("Start", startPage.pageHeader());
	 	assertEquals(TestData.userName, startPage.usernameHeader());
	 	assertEquals(TestData.storeName, startPage.storenameHeader());
	}
}
