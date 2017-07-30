package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ConfirmationPage extends PageObject {
	
	public ConfirmationPage(WebDriver driver) {
        super(driver);
    }
	
	@FindBy(tagName = "h2")
	private WebElement header;
	
	@FindBy(css = "input[name='name']" )
	private WebElement name;
	
	@FindBy(css = "input[name='phone']")
	private WebElement phone;
	
	@FindBy(css = "button[data-id='selling_online']")
	private Select sellingDropdown;
	
	@FindBy(css = "button[data-id='why_testing']")
	private Select reasonDropdown;
	
	@FindBy(css = "button[data-id='hear_about']")
	private Select aboutDropdown;
	
	@FindBy(css = ".btn.btn-large.btn-purple.btn-block")
    private WebElement submitButton;
	
	 public String welcomeHeader(){
	        return header.getText();
	    }
	 
	 public void typeName (String name){
	        this.name.clear();
	        this.name.sendKeys(name);
	    }
	 
	 public void typePhone (String phone){
	        this.phone.clear();
	        this.phone.sendKeys(phone);
	    }
	 
	 public void selectSelling (String value) {
		 sellingDropdown.selectByValue(value);
	 }
	 
	 public void selectReason (String value) {
		 reasonDropdown.selectByValue(value);
	 }
	 
	 public void selectAbout (String value) {
		 aboutDropdown.selectByValue(value);
	 }
	 
	 public StartPage submit(){
	        submitButton.click();
	        return new StartPage(driver);
	    }
}
