package automation;
import automation.TestData;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.openqa.selenium.By;

public class Shoplo2LoginViaShopPage extends FunctionalTest {

@Test

public void loginViaShopPage () {
	driver.get("https://" + TestData.storeId + ".shoplo.com");
	ShopPage shopPage = new ShopPage(driver);
	LoginPage storeLoginPage = shopPage.clickBanner();
	
	storeLoginPage.typeStoreEmail(TestData.storeEmail);
	storeLoginPage.typeStorePassword(TestData.storePassword);
	storeLoginPage.submit();
	
	assertNotNull(driver.findElement(By.id("appSidebar")));

}

}

