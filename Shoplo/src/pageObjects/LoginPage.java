package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
	
	public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="input[name='email']")
    private WebElement storeEmail;
    
    @FindBy(css="input[name='password']")
    private WebElement storePassword;
    
    @FindBy(css = ".btn.btn-red.btn-large.btn-cancel")
    private WebElement submitButton;
    
    public boolean pageReady () {
		return storeEmail.isDisplayed();
	}
    
    public void typeStoreEmail (String email){
       typeIntoField(storeEmail, email);
    }
    
    public void typeStorePassword (String password){
      typeIntoField(storePassword, password);
    }
    
    public StartPage submit(){
        submitButton.click();
        return new StartPage(driver);
    }
    
   public StartPage login (String email, String password) {
	 typeStoreEmail(email);
	 typeStorePassword(password);
	 return  submit();
    }
}
