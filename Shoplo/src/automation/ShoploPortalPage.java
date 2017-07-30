package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ShoploPortalPage extends PageObject {
	
	public ShoploPortalPage(WebDriver driver) {
        super(driver);
    }
	
	@FindBy(css = ".btn.btn-white.btn-with-icon")
	private WebElement mainLoginButton;
	
	@FindBy(css = ".sub-menu.sub-menu-buttons-icon")
	private WebElement subMenu;
	
	@FindBy(xpath = ".//span[starts-with(text(),'Zaloguj')]")
	private WebElement secondaryLoginButton;
    
    public void clickLoginButton () {
    	mainLoginButton.click();
    }  
    
	public CreateAccountPage clickSecondaryLoginButton () {
	//action.moveToElement(mainLoginButton).moveToElement(secondaryLoginButton).click().build().perform();
	action.clickAndHold(mainLoginButton).moveToElement(secondaryLoginButton).click(secondaryLoginButton)
	.build().perform();
	return new CreateAccountPage(driver);
	}
}
