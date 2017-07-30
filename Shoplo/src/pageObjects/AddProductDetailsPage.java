package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductDetailsPage extends PageObject {

	public AddProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "id('pageHeaderTabs')/descendant::span[text()='Dodaj']/parent::*")
	private WebElement addProductTabSelection;

	@FindBy(css="input[name='name']")
	private WebElement productName;

	@FindBy(css="input[name='price']")
	private WebElement productPrice;

	@FindBy(css="input[name='sku']")
	private WebElement productCode;

	@FindBy(css="input[name='tax']")
	private WebElement productTaxValue;

	@FindBy(css=".btn.btn-small.btn-green-light")
	private WebElement saveButton;
	
	public boolean pageReady () {
		return addProductTabSelection.isDisplayed();
	}

	public boolean isProductDetailsSelected() {
		if (addProductTabSelection.getAttribute("class").contains("selected")) {
			return true;
		} else {
			return false;
		}
	}	 

	public void scrollToTaxValue() {
		action.moveToElement(productTaxValue).perform();
	}

	public void typeProductName (String name) {
		productName.clear();
		productName.sendKeys(name);
	}

	public void typeProductPrice (String price) {
		productPrice.clear();
		productPrice.sendKeys(price);
	}

	public void typeProductCode (String code) {
		productCode.clear();
		productCode.sendKeys(code);
	}

	public void typeProductTax (String taxValue) {
		scrollToTaxValue();
		productTaxValue.clear();
		productTaxValue.sendKeys(taxValue);
	}

	public ProductParametersPage saveProduct () {
		saveButton.click();
		return new ProductParametersPage(driver);
	}
}
