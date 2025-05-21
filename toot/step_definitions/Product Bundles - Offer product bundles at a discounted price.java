public class ProductBundlesSteps {

    WebDriver driver;
    ProductBundlesPage productBundlesPage;

    @Given("the user is on the product bundles page")
    public void userOnProductBundlesPage() {
        driver = new ChromeDriver();
        driver.get("http://example.com/product-bundles");
        productBundlesPage = new ProductBundlesPage(driver);
    }

    @When("the user navigates to the product bundles section")
    public void navigateToProductBundlesSection() {
        productBundlesPage.navigateToBundlesSection();
    }

    @Then("the system should display a list of available product bundles")
    public void displayAvailableProductBundles() {
        Assert.assertTrue(productBundlesPage.isBundlesListDisplayed());
    }

    @Given("a list of available product bundles is displayed")
    public void listOfAvailableProductBundlesDisplayed() {
        Assert.assertTrue(productBundlesPage.isBundlesListDisplayed());
    }

    @When("the user selects a product bundle")
    public void selectProductBundle() {
        productBundlesPage.selectBundle();
    }

    @Then("the system should display the details of the selected product bundle")
    public void displaySelectedBundleDetails() {
        Assert.assertTrue(productBundlesPage.isBundleDetailsDisplayed());
    }

    @And("the details should include the original price, discounted price, and items included in the bundle")
    public void verifyBundleDetails() {
        Assert.assertTrue(productBundlesPage.verifyBundleDetails());
    }

    @When("the user selects a product bundle and adds it to the cart")
    public void addBundleToCart() {
        productBundlesPage.addBundleToCart();
    }

    @Then("the product bundle should be added to the cart")
    public void verifyBundleAddedToCart() {
        Assert.assertTrue(productBundlesPage.isBundleInCart());
    }

    @And("the cart should display the discounted price of the product bundle")
    public void verifyDiscountedPriceInCart() {
        Assert.assertTrue(productBundlesPage.verifyDiscountedPriceInCart());
    }

    @Given("a product bundle is added to the cart")
    public void bundleAddedToCart() {
        Assert.assertTrue(productBundlesPage.isBundleInCart());
    }

    @When("the user removes the product bundle from the cart")
    public void removeBundleFromCart() {
        productBundlesPage.removeBundleFromCart();
    }

    @Then("the product bundle should be removed from the cart")
    public void verifyBundleRemovedFromCart() {
        Assert.assertFalse(productBundlesPage.isBundleInCart());
    }

    @And("the cart should update to reflect the removal")
    public void verifyCartUpdateAfterRemoval() {
        Assert.assertTrue(productBundlesPage.isCartUpdatedAfterRemoval());
    }

    @When("the user proceeds to checkout")
    public void proceedToCheckout() {
        productBundlesPage.proceedToCheckout();
    }

    @Then("the checkout page should display the product bundle with the discounted price")
    public void verifyCheckoutPageDisplaysBundle() {
        Assert.assertTrue(productBundlesPage.isCheckoutPageDisplayingBundle());
    }

    @And("the total price should reflect the discount applied to the product bundle")
    public void verifyTotalPriceReflectsDiscount() {
        Assert.assertTrue(productBundlesPage.verifyTotalPriceReflectsDiscount());
    }

    @When("the user verifies the cart total")
    public void verifyCartTotal() {
        Assert.assertTrue(productBundlesPage.verifyCartTotal());
    }

    @Then("the total should correctly reflect the sum of the discounted prices of all product bundles in the cart")
    public void verifyCorrectDiscountedTotal() {
        Assert.assertTrue(productBundlesPage.verifyCorrectDiscountedTotal());
    }

    @Given("there are no product bundles available")
    public void noProductBundlesAvailable() {
        productBundlesPage.setNoBundlesAvailable();
    }

    @Then("the system should display a message indicating that no product bundles are currently available")
    public void displayNoBundlesMessage() {
        Assert.assertTrue(productBundlesPage.isNoBundlesMessageDisplayed());
    }
}