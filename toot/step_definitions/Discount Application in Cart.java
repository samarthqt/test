import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class DiscountStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    CartPage cartPage;

    @Given("a user has items in their cart")
    public void user_has_items_in_cart() {
        cartPage = new CartPage(driver);
        Assert.assertTrue("Cart is empty", cartPage.isCartNotEmpty());
    }

    @Given("the cart value qualifies for a percentage discount")
    public void cart_qualifies_for_percentage_discount() {
        Assert.assertTrue("Cart does not qualify for percentage discount", cartPage.qualifiesForPercentageDiscount());
    }

    @Given("the cart value qualifies for a fixed amount discount")
    public void cart_qualifies_for_fixed_discount() {
        Assert.assertTrue("Cart does not qualify for fixed discount", cartPage.qualifiesForFixedDiscount());
    }

    @Given("the cart value does not qualify for any discount")
    public void cart_does_not_qualify_for_any_discount() {
        Assert.assertFalse("Cart qualifies for a discount", cartPage.qualifiesForAnyDiscount());
    }

    @Given("the cart value qualifies for multiple discounts")
    public void cart_qualifies_for_multiple_discounts() {
        Assert.assertTrue("Cart does not qualify for multiple discounts", cartPage.qualifiesForMultipleDiscounts());
    }

    @Given("the user has a valid discount coupon code")
    public void user_has_valid_coupon_code() {
        Assert.assertTrue("Coupon code is not valid", cartPage.hasValidCouponCode());
    }

    @Given("the user has an expired discount coupon code")
    public void user_has_expired_coupon_code() {
        Assert.assertTrue("Coupon code is not expired", cartPage.hasExpiredCouponCode());
    }

    @When("the user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        cartPage.proceedToCheckout();
    }

    @When("the user enters the coupon code at checkout")
    public void user_enters_coupon_code() {
        cartPage.enterCouponCode();
    }

    @Then("a percentage discount should be automatically applied to the total cart value")
    public void percentage_discount_applied() {
        Assert.assertTrue("Percentage discount not applied", cartPage.isPercentageDiscountApplied());
    }

    @Then("a fixed amount discount should be automatically applied to the total cart value")
    public void fixed_discount_applied() {
        Assert.assertTrue("Fixed discount not applied", cartPage.isFixedDiscountApplied());
    }

    @Then("no discount should be applied to the total cart value")
    public void no_discount_applied() {
        Assert.assertFalse("Discount applied", cartPage.isAnyDiscountApplied());
    }

    @Then("only the highest discount should be automatically applied to the total cart value")
    public void highest_discount_applied() {
        Assert.assertTrue("Highest discount not applied", cartPage.isHighestDiscountApplied());
    }

    @Then("the discount associated with the coupon should be applied to the total cart value")
    public void coupon_discount_applied() {
        Assert.assertTrue("Coupon discount not applied", cartPage.isCouponDiscountApplied());
    }

    @Then("an error message should be displayed indicating the coupon is invalid")
    public void invalid_coupon_error_displayed() {
        Assert.assertTrue("Invalid coupon error not displayed", cartPage.isInvalidCouponErrorDisplayed());
    }

    @Then("the discount amount should be displayed in the cart summary")
    public void discount_displayed_in_cart_summary() {
        Assert.assertTrue("Discount not displayed in cart summary", cartPage.isDiscountDisplayedInSummary());
    }

    @Then("the cart summary should display the full price without any discount")
    public void full_price_displayed_in_cart_summary() {
        Assert.assertTrue("Full price not displayed in cart summary", cartPage.isFullPriceDisplayedInSummary());
    }
}