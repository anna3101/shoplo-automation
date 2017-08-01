package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoploPortalPage extends PageObject {

	public ShoploPortalPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".btn.btn-white.btn-with-icon")
	private WebElement mainLoginButton;

	public boolean pageReady () {
		return mainLoginButton.isDisplayed();
	}

	public CreateAccountPage clickSecondaryLoginButton () {
		action.moveToElement(mainLoginButton).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).build().perform();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.click().build().perform();
		return new CreateAccountPage(driver);
	}
}
