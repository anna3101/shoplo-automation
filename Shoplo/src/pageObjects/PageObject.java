package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected WebDriver driver;
	protected Actions action;
    
    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.action = new Actions(driver);
    }
    
    public void typeIntoField (WebElement field, String text){
        field.clear();
        field.sendKeys(text);
    }
}
