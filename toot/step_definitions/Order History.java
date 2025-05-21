import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class OrderHistorySteps {
    WebDriver driver;
    WebDriverWait wait;
    OrderHistoryPage orderHistoryPage;

    public OrderHistorySteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.orderHistoryPage = new OrderHistoryPage(driver);
    }

    public void givenUserIsLoggedIntoTheirAccount() {
        // Assume user is already logged in
    }

    public void givenUserNavigatesToOrderHistoryPage() {
        orderHistoryPage.navigateToOrderHistoryPage();
    }

    public void whenPageLoadsSuccessfully() {
        Assert.assertTrue("Order History page did not load successfully", orderHistoryPage.isPageLoaded());
    }

    public void thenUserShouldSeeListOfPastOrders() {
        Assert.assertTrue("Past orders not visible", orderHistoryPage.isOrderListVisible());
    }

    public void givenUserIsOnOrderHistoryPage() {
        orderHistoryPage.navigateToOrderHistoryPage();
    }

    public void whenUserSelectsOrderFromList() {
        orderHistoryPage.selectOrderFromList();
    }

    public void thenUserShouldSeeDetailsOfSelectedOrderIncludingInvoice() {
        Assert.assertTrue("Order details not visible", orderHistoryPage.isOrderDetailsVisible());
    }

    public void andUserHasNoPastOrders() {
        orderHistoryPage.clearOrderList();
    }

    public void thenUserShouldSeeMessageIndicatingNoPastOrdersAvailable() {
        Assert.assertTrue("No past orders message not visible", orderHistoryPage.isNoOrdersMessageVisible());
    }

    public void andUserHasMoreOrdersThanCanFitOnOnePage() {
        orderHistoryPage.populateOrdersForPagination();
    }

    public void whenUserNavigatesThroughPages() {
        orderHistoryPage.navigateThroughPages();
    }

    public void thenUserShouldBeAbleToViewAllPastOrdersAcrossMultiplePages() {
        Assert.assertTrue("Not all orders visible across pages", orderHistoryPage.areAllOrdersVisibleAcrossPages());
    }

    public void whenUserAppliesDateFilter() {
        orderHistoryPage.applyDateFilter();
    }

    public void thenUserShouldSeeOrdersThatFallWithinSpecifiedDateRange() {
        Assert.assertTrue("Filtered orders not visible", orderHistoryPage.areFilteredOrdersVisible());
    }

    public void whenUserSelectsOrder() {
        orderHistoryPage.selectOrderFromList();
    }

    public void andUserChoosesToDownloadInvoice() {
        orderHistoryPage.downloadInvoice();
    }

    public void thenInvoiceShouldBeDownloadedSuccessfully() {
        Assert.assertTrue("Invoice not downloaded", orderHistoryPage.isInvoiceDownloaded());
    }
}