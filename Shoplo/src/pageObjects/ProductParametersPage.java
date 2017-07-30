package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductParametersPage extends PageObject {

	public ProductParametersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "id('pageHeaderTabs')/descendant::span[text()='Parametry i warianty']/parent::*")
	private WebElement productParamsTabSelection;

	@FindBy(css = "section[class='product-header']")
	private WebElement productParamsHeader;
	
	public boolean pageReady () {
		return productParamsHeader.isDisplayed();
	}

	public String pageHeader(){
		return productParamsHeader.getText();
	}

	public boolean checkIfHeaderContains(String text) {
		if (pageHeader().contains(text)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isProductParamsSelected() {
		if (productParamsTabSelection.getAttribute("class").contains("selected")) {
			return true;
		} else {
			return false;
		}
	}	 
}
