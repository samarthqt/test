import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class ProductFiltersStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    ProductFiltersPage productFiltersPage;

    public ProductFiltersStepDefinitions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.productFiltersPage = new ProductFiltersPage(driver);
    }

    public void givenUserIsOnProductSearchPage() {
        driver.get("http://example.com/products");
    }

    public void whenUserSelectsPriceRangeFilter(String priceRange) {
        productFiltersPage.selectPriceRange(priceRange);
    }

    public void thenSearchResultsShouldDisplayProductsWithinSelectedPriceRange() {
        Assert.assertTrue("Products not within selected price range", productFiltersPage.verifyPriceRangeFilter());
    }

    public void whenUserSelectsRatingFilter(String rating) {
        productFiltersPage.selectRatingFilter(rating);
    }

    public void thenSearchResultsShouldDisplayProductsWithSelectedRatingOrHigher() {
        Assert.assertTrue("Products not with selected rating or higher", productFiltersPage.verifyRatingFilter());
    }

    public void whenUserSelectsBothPriceRangeAndRatingFilters(String priceRange, String rating) {
        productFiltersPage.selectPriceRange(priceRange);
        productFiltersPage.selectRatingFilter(rating);
    }

    public void thenSearchResultsShouldDisplayProductsThatMeetBothCriteria() {
        Assert.assertTrue("Products not meeting both criteria", productFiltersPage.verifyCombinedFilters());
    }

    public void givenUserHasAppliedMultipleFilters() {
        productFiltersPage.applyMultipleFilters();
    }

    public void whenUserClearsAllFilters() {
        productFiltersPage.clearAllFilters();
    }

    public void thenSearchResultsShouldDisplayAllProductsWithoutAnyFiltersApplied() {
        Assert.assertTrue("Filters not cleared", productFiltersPage.verifyNoFiltersApplied());
    }

    public void whenUserAppliesFiltersThatMatchNoProducts() {
        productFiltersPage.applyNoMatchingFilters();
    }

    public void thenSearchResultsShouldDisplayMessageIndicatingNoProductsFound() {
        Assert.assertTrue("No products found message not displayed", productFiltersPage.verifyNoProductsFoundMessage());
    }

    public void givenUserHasAppliedFilters() {
        productFiltersPage.applyFilters();
    }

    public void whenUserRefreshesPage() {
        driver.navigate().refresh();
    }

    public void thenPreviouslySelectedFiltersShouldRemainApplied() {
        Assert.assertTrue("Filters not persisted after refresh", productFiltersPage.verifyFiltersPersisted());
    }
}