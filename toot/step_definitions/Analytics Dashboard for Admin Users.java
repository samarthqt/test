import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class AnalyticsDashboardSteps {
    WebDriver driver;
    WebDriverWait wait;
    AnalyticsDashboardPage dashboardPage;

    public AnalyticsDashboardSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.dashboardPage = new AnalyticsDashboardPage(driver);
    }

    public void givenAdminUserIsLoggedIntoSystem() {
        // Assume admin login is handled elsewhere
    }

    public void whenAdminUserNavigatesToAnalyticsDashboard() {
        dashboardPage.navigateToDashboard();
    }

    public void thenAnalyticsDashboardShouldBeDisplayed() {
        Assert.assertTrue("Dashboard not displayed", dashboardPage.isDashboardDisplayed());
    }

    public void givenAdminUserIsOnAnalyticsDashboard() {
        Assert.assertTrue("Not on dashboard", dashboardPage.isDashboardDisplayed());
    }

    public void whenAdminUserViewsSalesData() {
        dashboardPage.viewSalesData();
    }

    public void thenSalesDataShouldBePresentedInClearFormat() {
        Assert.assertTrue("Sales data not clear", dashboardPage.isSalesDataClear());
    }

    public void andSalesDataShouldBeUpToDate() {
        Assert.assertTrue("Sales data not up-to-date", dashboardPage.isSalesDataUpToDate());
    }

    public void whenAdminUserFiltersSalesDataByDateRange() {
        dashboardPage.filterSalesDataByDateRange("2023-01-01", "2023-12-31");
    }

    public void thenSalesDataShouldBeUpdatedForDateRange() {
        Assert.assertTrue("Sales data not updated", dashboardPage.isSalesDataUpdatedForDateRange());
    }

    public void whenAdminUserChoosesToExportSalesData() {
        dashboardPage.exportSalesData("CSV");
    }

    public void thenSalesDataShouldBeExportedInSelectedFormat() {
        Assert.assertTrue("Sales data not exported", dashboardPage.isSalesDataExported());
    }

    public void andConfirmationMessageShouldBeDisplayed() {
        Assert.assertTrue("Confirmation message not displayed", dashboardPage.isConfirmationMessageDisplayed());
    }

    public void whenAdminUserCustomizesDashboardWidgets() {
        dashboardPage.customizeDashboardWidgets();
    }

    public void thenChangesShouldBeSaved() {
        Assert.assertTrue("Changes not saved", dashboardPage.areChangesSaved());
    }

    public void andDashboardShouldReflectCustomizations() {
        Assert.assertTrue("Dashboard not customized", dashboardPage.isDashboardCustomized());
    }

    public void givenNonAdminUserIsLoggedIntoSystem() {
        // Assume non-admin login is handled elsewhere
    }

    public void whenNonAdminUserAttemptsToAccessAnalyticsDashboard() {
        dashboardPage.attemptAccessDashboard();
    }

    public void thenAccessShouldBeDenied() {
        Assert.assertTrue("Access not denied", dashboardPage.isAccessDenied());
    }

    public void andAppropriateErrorMessageShouldBeDisplayed() {
        Assert.assertTrue("Error message not displayed", dashboardPage.isErrorMessageDisplayed());
    }
}