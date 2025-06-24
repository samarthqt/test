package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class CheckoutPage extends WebReusableComponents {

    protected final By btnProceedToCheckout = By.id("proceedToCheckout");
    protected final By txtFullName = By.id("fullName");
    protected final By txtAddress = By.id("address");
    protected final By txtCity = By.id("city");
    protected final By txtPostalCode = By.id("postalCode");
    protected final By txtPhone = By.id("phone");
    protected final By paymentMethodDropdown = By.id("paymentMethod");
    protected final By txtCardNumber = By.id("cardNumber");
    protected final By txtExpiryDate = By.id("expiryDate");
    protected final By txtCVV = By.id("cvv");
    protected final By btnPlaceOrder = By.id("placeOrder");
    protected final By orderConfirmationMessage = By.id("orderConfirmationMessage");

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Proceeds to the checkout page.
     */
    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
    }

    /**
     * Enters shipping details into the checkout form.
     * 
     * @param fullName   the full name of the recipient
     * @param address    the shipping address
     * @param city       the city of the shipping address
     * @param postalCode the postal code of the shipping address
     * @param phone      the phone number of the recipient
     */
    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName, 3);
        enterText(txtFullName, fullName);
        enterText(txtAddress, address);
        enterText(txtCity, city);
        enterText(txtPostalCode, postalCode);
        enterText(txtPhone, phone);
    }

    /**
     * Selects a payment method from the dropdown.
     * 
     * @param paymentMethod the payment method to select
     */
    public void selectPaymentMethod(String paymentMethod) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, paymentMethod);
    }

    /**
     * Enters credit card details into the checkout form.
     * 
     * @param cardNumber the credit card number
     * @param expiryDate the expiry date of the credit card
     * @param cvv        the CVV of the credit card
     */
    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        waitUntilElementVisible(txtCardNumber, 3);
        enterText(txtCardNumber, cardNumber);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
    }

    /**
     * Places the order.
     */
    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder, 3);
        clickElement(btnPlaceOrder);
    }

    /**
     * Verifies the order confirmation message.
     * 
     * @param expectedMessage the expected order confirmation message
     * @return true if the actual message matches the expected message, false otherwise
     */
    public boolean verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String actualMessage = getTextFromElement(orderConfirmationMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
        return actualMessage.equals(expectedMessage);
    }
}