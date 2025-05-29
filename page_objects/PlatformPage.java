
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

public class PlatformPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By agileTestingSubMenu = By.linkText(Agile Testing);
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

    public PlatformPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickAgileTestingSubMenu() {
        WebElement subMenu = wait.until(ExpectedConditions.elementToBeClickable(agileTestingSubMenu));
        subMenu.click();
        Assert.assertTrue(subMenu.isDisplayed(), Agile Testing SubMenu not displayed);
    }

    public void selectProductAndAddToCart() {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(productItem));
        product.click();
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCart.click();
        WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        Assert.assertTrue(badge.isDisplayed(), Item not added to cart);
    }

    public void fillRegistrationForm(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        driver.findElement(registerButton).click();
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        Assert.assertTrue(message.isDisplayed(), Registration failed - Success message not found);
    }

    public void performSearch(String query) {
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        search.sendKeys(query);
        driver.findElement(searchButton).click();
        WebElement stats = wait.until(ExpectedConditions.visibilityOfElementLocated(resultStats));
        Assert.assertTrue(stats.isDisplayed(), Search results not found);
    }

    public void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}
