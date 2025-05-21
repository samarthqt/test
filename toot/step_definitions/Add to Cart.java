import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class AddToCartSteps {
    WebDriver driver;
    WebDriverWait wait;
    ProductPage productPage;

    public AddToCartSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.productPage = PageFactory.initElements(driver, ProductPage.class);
    }

    public void givenIAmOnTheProductPage() {
        driver.get("http://example.com/products");
    }

    public void whenIClickOnTheAddToCartButton() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(productPage.getAddToCartButton()));
        addToCartButton.click();
    }

    public void thenTheProductShouldBeAddedToTheShoppingCart() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOf(productPage.getConfirmationMessage()));
        Assert.assertTrue("Product not added to cart", confirmationMessage.isDisplayed());
    }

    public void givenIAmOnTheProductPageOf(String productName) {
        driver.get("http://example.com/products/" + productName);
    }

    public void andINavigateToTheProductPageOf(String productName) {
        driver.get("http://example.com/products/" + productName);
    }

    public void thenBothProductsShouldBePresentInTheShoppingCart() {
        WebElement cartContents = wait.until(ExpectedConditions.visibilityOf(productPage.getCartContents()));
        Assert.assertTrue("Both products not present in cart", cartContents.getText().contains("Product A") && cartContents.getText().contains("Product B"));
    }

    public void givenIAmNotLoggedIntoTheWebsite() {
        driver.get("http://example.com/logout");
    }

    public void thenIShouldBePromptedToLogInOrRegister() {
        WebElement loginPrompt = wait.until(ExpectedConditions.visibilityOf(productPage.getLoginPrompt()));
        Assert.assertTrue("Login prompt not displayed", loginPrompt.isDisplayed());
    }

    public void givenIAmOnTheProductPageOfAnOutOfStockProduct() {
        driver.get("http://example.com/products/out-of-stock");
    }

    public void thenIShouldSeeAMessageThisProductIsCurrentlyOutOfStock() {
        WebElement outOfStockMessage = wait.until(ExpectedConditions.visibilityOf(productPage.getOutOfStockMessage()));
        Assert.assertTrue("Out of stock message not displayed", outOfStockMessage.isDisplayed());
    }

    public void andTheProductShouldNotBeAddedToTheShoppingCart() {
        WebElement cartContents = wait.until(ExpectedConditions.visibilityOf(productPage.getCartContents()));
        Assert.assertFalse("Out of stock product added to cart", cartContents.getText().contains("Out of Stock Product"));
    }
}