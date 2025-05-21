import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class CurrencyStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    CurrencyPage currencyPage;

    public CurrencyStepDefinitions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.currencyPage = new CurrencyPage(driver);
    }

    public void givenUserIsOnProductPage() {
        driver.get("http://example.com/products");
    }

    public void whenUserSelectsCurrency(String currency) {
        currencyPage.selectCurrency(currency);
    }

    public void thenPricesShouldBeDisplayedInCurrency(String currency) {
        String displayedCurrency = currencyPage.getDisplayedCurrency();
        Assert.assertEquals("Prices are not displayed in the expected currency", currency, displayedCurrency);
    }

    public void whenPageIsLoaded() {
        // Assume page is loaded
    }

    public void thenPricesShouldBeDisplayedInDefaultCurrency() {
        String defaultCurrency = currencyPage.getDefaultCurrency();
        String displayedCurrency = currencyPage.getDisplayedCurrency();
        Assert.assertEquals("Prices are not displayed in the default currency", defaultCurrency, displayedCurrency);
    }

    public void givenUserSelectsEURFromCurrencyDropdown() {
        currencyPage.selectCurrency("EUR");
    }

    public void whenUserNavigatesToAnotherProductPage() {
        driver.get("http://example.com/another-product");
    }

    public void thenPricesShouldStillBeDisplayedInEUR() {
        String displayedCurrency = currencyPage.getDisplayedCurrency();
        Assert.assertEquals("Prices are not displayed in EUR", "EUR", displayedCurrency);
    }

    public void whenUserSelectsInvalidCurrency() {
        currencyPage.selectCurrency("INVALID");
    }

    public void thenErrorMessageShouldBeDisplayed() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currency_error")));
        Assert.assertTrue("Error message not displayed", errorMessage.isDisplayed());
    }

    public void givenUserSelectsJPYFromCurrencyDropdown() {
        currencyPage.selectCurrency("JPY");
    }

    public void whenPricesAreDisplayed() {
        // Assume prices are displayed
    }

    public void thenConversionRateShouldBeAccurate() {
        double expectedRate = currencyPage.getExpectedConversionRate("JPY");
        double actualRate = currencyPage.getActualConversionRate();
        Assert.assertEquals("Conversion rate is not accurate", expectedRate, actualRate, 0.01);
    }

    public void givenUserSelectsGBPFromCurrencyDropdown() {
        currencyPage.selectCurrency("GBP");
    }

    public void whenUserLogsOutAndLogsBackIn() {
        currencyPage.logout();
        currencyPage.login();
    }

    public void thenPricesShouldBeDisplayedInDefaultCurrencyAfterLogin() {
        String defaultCurrency = currencyPage.getDefaultCurrency();
        String displayedCurrency = currencyPage.getDisplayedCurrency();
        Assert.assertEquals("Prices are not displayed in the default currency after login", defaultCurrency, displayedCurrency);
    }
}