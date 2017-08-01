package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends PageObject {
	
	public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="storeName")
    private WebElement storeName;

    @FindBy(css="input[name='email']")
    private WebElement storeEmail;

    @FindBy(css="input[name='password']")
    private WebElement storePassword;

    @FindBy(css = ".btn.btn-large.btn-purple.btn-block")
    private WebElement submitButton;
    
    public boolean pageReady () {
		return storeName.isDisplayed();
	}

    public void typeStoreName (String name){
        typeIntoField(storeName, name);
    }
   

    public void typeStoreEmail (String email){
        typeIntoField(storeEmail, email);
    }
    
    public void typeStorePassword (String password){
        typeIntoField(storePassword, password);
    }

    public ConfirmationPage submit(){
        submitButton.click();
        return new ConfirmationPage(driver);
    }
}
