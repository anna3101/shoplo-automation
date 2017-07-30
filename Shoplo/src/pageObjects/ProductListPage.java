package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListPage extends PageObject {
	
	public ProductListPage(WebDriver driver) {
        super(driver);
    }
	
	@FindBy(css = "a[href$='product/add']")
	private WebElement addProductButton;
	
	@FindBy(xpath = "id('pageHeaderTabs')/descendant::a[text()='Lista produktów']")
	private WebElement productListTab;
	
	@FindBy(xpath = "id('pageHeaderTabs')/descendant::a[text()='Lista produktów']/parent::*")
	private WebElement productListTabSelection;
	
	public boolean pageReady () {
		return addProductButton.isDisplayed();
	}
	
	public boolean isProductListSelected() {
		if (productListTabSelection.getAttribute("class").contains("selected")) {
			return true;
		} else {
			return false;
		}
	}
	 
	 public AddProductDetailsPage addProduct () {
		 addProductButton.click();
		 return new AddProductDetailsPage(driver);
	 }
	 
}
