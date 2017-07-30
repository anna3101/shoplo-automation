package automation;

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
    
    public void typeStoreEmail (String email){
        this.storeEmail.clear();
        this.storeEmail.sendKeys(email);
    }
    
    public void typeStorePassword (String password){
        this.storePassword.clear();
        this.storePassword.sendKeys(password);
    }
    
    public StartPage submit(){
        submitButton.click();
        return new StartPage(driver);
    }

}
