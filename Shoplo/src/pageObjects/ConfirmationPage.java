package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ConfirmationPage extends PageObject {
	
	public ConfirmationPage(WebDriver driver) {
        super(driver);
    }
	
	@FindBy(xpath = "//h2[starts-with(text(), 'Witaj')]")
	private WebElement header;

	@FindBy(css = "input[name='name']" )
	private WebElement name;
	
	@FindBy(css = "input[name='phone']")
	private WebElement phone;
	
	@FindBy(id = "sell_online")
	private WebElement sellingElement;
	private Select sellingDropdown;
	
	@FindBy(id = "why_testing")
	private WebElement reasonElement;
	private Select reasonDropdown;
	
	@FindBy(id = "hear_about")
	private WebElement aboutElement;
	private Select aboutDropdown;
	
	@FindBy(css = ".btn.btn-large.btn-purple.btn-block")
    private WebElement submitButton;
	
	public boolean pageReady () {
		return header.isDisplayed();
	}
	
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
		 sellingDropdown = new Select(sellingElement);
		 sellingDropdown.selectByValue(value);
	 }
	 
	 public void selectReason (String value) {
		 reasonDropdown = new Select(reasonElement);
		 reasonDropdown.selectByValue(value);
	 }
	 
	 public void selectAbout (String value) {
		 aboutDropdown = new Select(aboutElement);
		 aboutDropdown.selectByValue(value);
	 }
	 
	 public StartPage submit(){
	        submitButton.click();
	        return new StartPage(driver);
	    }
}
