package pageObjects;

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
	
	@FindBy(id = "productListSidebar")
	private WebElement productsOption;
	
	public boolean pageReady () {
		return productsOption.isDisplayed();
	}
	
	 public String pageHeader(){
	        return header1.getText();
	    }
	 
	 public String usernameHeader(){
	        return header2.getText();
	    }
	
	 public String storenameHeader(){
	        return header3.getText();
	    }
	 
	 public ProductListPage clickProductsOption () {
		 productsOption.click();
		 return new ProductListPage(driver);
	 }
}
