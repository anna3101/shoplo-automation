package tests;
import pageObjects.LoginPage;
import pageObjects.AddProductDetailsPage;
import pageObjects.ProductListPage;
import pageObjects.ProductParametersPage;
import pageObjects.StartPage;
import testBase.FunctionalTest;
import testBase.TestData;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Shoplo3AddToBasket extends FunctionalTest {

@Test

public void addToBasket () {
	driver.get("https://" + TestData.storeId + ".shoplo.com/admin");
	LoginPage storeLoginPage = new LoginPage(driver);
	assertTrue(storeLoginPage.pageReady());
	
	StartPage welcomePage = storeLoginPage.login(TestData.storeEmail,TestData.storePassword);
	assertTrue(welcomePage.pageReady());
	
	ProductListPage productsPage = welcomePage.clickProductsOption();
	assertTrue(productsPage.pageReady());
	assertTrue(productsPage.isProductListSelected());
	
	AddProductDetailsPage addProductPage = productsPage.addProduct();
	assertTrue(addProductPage.pageReady());
	assertTrue(addProductPage.isProductDetailsSelected());
	addProductPage.typeProductName(TestData.productName);
	addProductPage.typeProductPrice(TestData.productPrice);
	addProductPage.typeProductCode(TestData.productCode);
	addProductPage.typeProductTax(TestData.productTaxValue);
	
	ProductParametersPage paramsPage = addProductPage.saveProduct();
	assertTrue(paramsPage.pageReady());
	assertTrue(paramsPage.isProductParamsSelected());
	assertTrue(paramsPage.checkIfHeaderContains(TestData.productName));
	assertTrue(paramsPage.checkIfHeaderContains(TestData.productPrice));
	}
}

