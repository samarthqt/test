package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import .io.File;
import .io.IOException;
import .time.Duration;

public class DashboardPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By dashboardElement = By.id(dashboard);
    private final By productItem = By.cssSelector(div.product-item);
    private final By addToCartButton = By.id(add_to_cart);
    private final By cartBadge = By.id(cart_badge);
    private final By emailField = By.id(email);
    private final By passwordField = By.id(password);
    private final By confirmPasswordField = By.id(confirm_password);
    private final By registerButton = By.id(register_button);
    private final By successMessage = By.id(success_message);
    private final By searchField = By.name(q);
    private final By searchButton = By.name(btnK);
    private final By resultStats = By.id(result-stats);

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isDashboardDisplayed() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardElement));
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, Dashboard is not displayed);
        return isDisplayed;
    }

    public void selectProduct() {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(productItem));
        product.click();
    }

    public void clickAddToCart() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        button.click();
    }

    public boolean isItemAddedToCart() {
        WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        boolean isDisplayed = badge.isDisplayed();
        Assert.assertTrue(isDisplayed, Item not added to cart);
        return isDisplayed;
    }

    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailField);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.sendKeys(password);
    }

    public void confirmPassword(String password) {
        WebElement confirmPasswordInput = driver.findElement(confirmPasswordField);
        confirmPasswordInput.sendKeys(password);
    }

    public void clickRegister() {
        WebElement button = driver.findElement(registerButton);
        button.click();
    }

    public boolean isRegistrationSuccessful() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        boolean isDisplayed = message.isDisplayed();
        Assert.assertTrue(isDisplayed, Registration failed - Success message not found);
        return isDisplayed;
    }

    public void enterSearchQuery(String query) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        searchInput.sendKeys(query);
    }

    public void clickSearch() {
        WebElement button = driver.findElement(searchButton);
        button.click();
    }

    public boolean areSearchResultsDisplayed() {
        WebElement stats = wait.until(ExpectedConditions.visibilityOfElementLocated(resultStats));
        boolean isDisplayed = stats.isDisplayed();
        Assert.assertTrue(isDisplayed, Search results not found);
        return isDisplayed;
    }

    public void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}