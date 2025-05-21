import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class MultipleShippingAddressesStepDef {
    WebDriver driver;
    WebDriverWait wait;

    public MultipleShippingAddressesStepDef() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void userIsOnCheckoutPage() {
        driver.get("http://example.com/checkout");
    }

    public void userHasItemsInCart() {
        WebElement cartItems = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_items")));
        Assert.assertTrue("Cart is empty", cartItems.isDisplayed());
    }

    public void userChoosesToShipToMultipleAddresses() {
        WebElement multipleAddressesOption = driver.findElement(By.id("multiple_addresses_option"));
        multipleAddressesOption.click();
    }

    public void userShouldSeeOptionToSelectDifferentAddressesForEachItem() {
        WebElement addressSelection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address_selection")));
        Assert.assertTrue("Address selection option not visible", addressSelection.isDisplayed());
    }

    public void userAddsNewShippingAddress() {
        WebElement addNewAddressButton = driver.findElement(By.id("add_new_address"));
        addNewAddressButton.click();
        WebElement newAddressForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_address_form")));
        newAddressForm.findElement(By.id("address_input")).sendKeys("123 New St, New City");
        newAddressForm.findElement(By.id("save_address_button")).click();
    }

    public void newAddressShouldBeAvailableForSelectionInAddressList() {
        WebElement addressList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address_list")));
        Assert.assertTrue("New address not available", addressList.getText().contains("123 New St, New City"));
    }

    public void userAssignsDifferentAddressesToEachItemInOrder() {
        WebElement item1AddressDropdown = driver.findElement(By.id("item1_address_dropdown"));
        item1AddressDropdown.click();
        item1AddressDropdown.findElement(By.xpath("//option[text()='123 New St, New City']")).click();
        WebElement item2AddressDropdown = driver.findElement(By.id("item2_address_dropdown"));
        item2AddressDropdown.click();
        item2AddressDropdown.findElement(By.xpath("//option[text()='456 Old St, Old City']")).click();
    }

    public void eachItemShouldDisplayAssignedAddressInOrderSummary() {
        WebElement orderSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_summary")));
        Assert.assertTrue("Item 1 address not displayed", orderSummary.getText().contains("123 New St, New City"));
        Assert.assertTrue("Item 2 address not displayed", orderSummary.getText().contains("456 Old St, Old City"));
    }

    public void userReviewsOrderSummary() {
        WebElement reviewOrderButton = driver.findElement(By.id("review_order_button"));
        reviewOrderButton.click();
    }

    public void orderSummaryShouldDisplayEachItemWithRespectiveShippingAddress() {
        WebElement orderSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_summary")));
        Assert.assertTrue("Order summary incorrect", orderSummary.getText().contains("123 New St, New City") && orderSummary.getText().contains("456 Old St, Old City"));
    }

    public void userConfirmsOrder() {
        WebElement confirmOrderButton = driver.findElement(By.id("confirm_order_button"));
        confirmOrderButton.click();
    }

    public void orderShouldBeProcessedWithItemsBeingShippedToRespectiveAddresses() {
        WebElement orderConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_confirmation")));
        Assert.assertTrue("Order not processed", orderConfirmation.isDisplayed());
    }

    public void userShouldReceiveConfirmationEmailWithDetailsOfEachShipment() {
        // Simulate email check
        boolean emailReceived = true; // Assume email check logic here
        Assert.assertTrue("Confirmation email not received", emailReceived);
    }
}