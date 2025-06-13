package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class ProductSteps extends ProductPage {

    @Given("the user is on the product listing page")
    public void theUserIsOnTheProductListingPage() {
        navigateToProductListingPage();
    }

    @When("the user selects {string} and clicks {string}")
    public void theUserSelectsProductAndClicksAddToCart(String productName, String buttonName) {
        selectProduct(productName);
        addProductToCart();
    }

    @Then("the cart should display {string} and {string}")
    public void theCartShouldDisplayProducts(String product1, String product2) {
        openCart();
        verifyProductInCart(product1);
        verifyProductInCart(product2);
    }

    @When("the user clicks on {string}")
    public void theUserClicksOnProduct(String productName) {
        selectProduct(productName);
    }

    @Then("the user should be directed to the {string} product page")
    public void theUserShouldBeDirectedToProductPage(String productName) {
        verifyOnProductPage(productName);
    }

    @Given("the user is on the {string} product page")
    public void theUserIsOnTheProductPage(String productName) {
        navigateToProductPage(productName);
    }

    @Then("the cart should display {string}")
    public void theCartShouldDisplayProduct(String productName) {
        openCart();
        verifyProductInCart(productName);
    }
}

