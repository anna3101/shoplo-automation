package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends PageObject {
	
	public ShopPage(WebDriver driver) {
        super(driver);
    }
	
	@FindBy(css = "a[href='/admin/layout/theme/settings/2']")
	private WebElement mainBanner;
	
	public boolean pageReady () {
		return mainBanner.isDisplayed();
	}
	
	public LoginPage clickBanner () {
		mainBanner.click();
		return new LoginPage(driver);
	}
}
