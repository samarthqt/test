import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ProductBundlesStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    ProductBundlesPage productBundlesPage;

    @Given("I am a registered customer")
    public void i_am_a_registered_customer() {
        // Assume user is registered
    }

    @Given("I am logged into the e-commerce platform")
    public void i_am_logged_into_the_e_commerce_platform() {
        // Assume user is logged in
    }

    @Given("I navigate to the \"Product Bundles\" section")
    public void i_navigate_to_the_product_bundles_section() {
        productBundlesPage.navigateToProductBundles();
    }

    @When("I select multiple products to create a bundle")
    public void i_select_multiple_products_to_create_a_bundle() {
        productBundlesPage.selectMultipleProducts();
    }

    @When("I apply a discount to the bundle")
    public void i_apply_a_discount_to_the_bundle() {
        productBundlesPage.applyDiscount();
    }

    @Then("I should see the total price of the bundle reflecting the discount")
    public void i_should_see_the_total_price_of_the_bundle_reflecting_the_discount() {
        Assert.assertTrue(productBundlesPage.isDiscountAppliedCorrectly());
    }

    @Then("the bundle should be added to my cart")
    public void the_bundle_should_be_added_to_my_cart() {
        Assert.assertTrue(productBundlesPage.isBundleInCart());
    }

    @When("I browse through the available bundles")
    public void i_browse_through_the_available_bundles() {
        productBundlesPage.browseAvailableBundles();
    }

    @Then("I should see a list of product bundles with their respective discounts")
    public void i_should_see_a_list_of_product_bundles_with_their_respective_discounts() {
        Assert.assertTrue(productBundlesPage.areBundlesDisplayedWithDiscounts());
    }

    @Given("I have a product bundle in my cart")
    public void i_have_a_product_bundle_in_my_cart() {
        productBundlesPage.ensureBundleInCart();
    }

    @When("I choose to edit the bundle")
    public void i_choose_to_edit_the_bundle() {
        productBundlesPage.editBundle();
    }

    @When("I add or remove products from the bundle")
    public void i_add_or_remove_products_from_the_bundle() {
        productBundlesPage.modifyBundleProducts();
    }

    @When("I update the discount if necessary")
    public void i_update_the_discount_if_necessary() {
        productBundlesPage.updateDiscount();
    }

    @Then("the updated product bundle should reflect the changes")
    public void the_updated_product_bundle_should_reflect_the_changes() {
        Assert.assertTrue(productBundlesPage.isBundleUpdated());
    }

    @Then("the new total price should be displayed")
    public void the_new_total_price_should_be_displayed() {
        Assert.assertTrue(productBundlesPage.isNewPriceDisplayed());
    }

    @When("I choose to remove the bundle from my cart")
    public void i_choose_to_remove_the_bundle_from_my_cart() {
        productBundlesPage.removeBundleFromCart();
    }

    @Then("the product bundle should no longer appear in my cart")
    public void the_product_bundle_should_no_longer_appear_in_my_cart() {
        Assert.assertFalse(productBundlesPage.isBundleInCart());
    }

    @Given("I have a discounted product bundle in my cart")
    public void i_have_a_discounted_product_bundle_in_my_cart() {
        productBundlesPage.ensureDiscountedBundleInCart();
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        productBundlesPage.proceedToCheckout();
    }

    @When("I complete the payment process")
    public void i_complete_the_payment_process() {
        productBundlesPage.completePayment();
    }

    @Then("I should receive a confirmation of my purchase")
    public void i_should_receive_a_confirmation_of_my_purchase() {
        Assert.assertTrue(productBundlesPage.isPurchaseConfirmed());
    }

    @Then("the product bundle should be marked as purchased")
    public void the_product_bundle_should_be_marked_as_purchased() {
        Assert.assertTrue(productBundlesPage.isBundleMarkedAsPurchased());
    }
}