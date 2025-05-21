import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.junit.Assert;

public class ProductSortingSteps {
    WebDriver driver;
    WebDriverWait wait;
    ProductListingPage productListingPage;

    public ProductSortingSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.productListingPage = new ProductListingPage(driver);
    }

    public void givenIAmOnTheProductListingPage() {
        driver.get("http://example.com/products");
        Assert.assertTrue("Product listing page not loaded", productListingPage.isPageLoaded());
    }

    public void whenISelectSortOption(String option) {
        productListingPage.selectSortOption(option);
    }

    public void andIChooseOrder(String order) {
        productListingPage.selectOrder(order);
    }

    public void thenProductsShouldBeDisplayedSortedBy(String criteria, String order) {
        Assert.assertTrue("Products not sorted by " + criteria + " in " + order + " order", productListingPage.isSortedBy(criteria, order));
    }
}