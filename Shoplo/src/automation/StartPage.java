package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends PageObject {
	
	public StartPage(WebDriver driver) {
        super(driver);
    }
	
	@FindBy(tagName = "h1")
	private WebElement header1;
	
	@FindBy(tagName = "h2")
	private WebElement header2;
	
	@FindBy(tagName = "h3")
	private WebElement header3;
	
	 public String pageHeader(){
	        return header1.getText();
	    }
	 
	 public String usernameHeader(){
	        return header2.getText();
	    }
	
	 public String storenameHeader(){
	        return header3.getText();
	    }
}
