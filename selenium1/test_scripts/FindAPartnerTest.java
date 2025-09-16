package selenium1.test_scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium1.page_objects.FindAPartnerPage;
import static org.testng.Assert.assertTrue;

public class FindAPartnerTest {

    private FindAPartnerPage findAPartnerPage;

    @BeforeMethod
    public void setUp() {
        findAPartnerPage = new FindAPartnerPage();
        findAPartnerPage.openBrowser();
    }

    @Test
    public void testFindAPartnerPage() {
        findAPartnerPage.navigateToURL("http://www.qasymphony.com/partners.html");
        findAPartnerPage.clickFindAPartnerButton();
        assertTrue(findAPartnerPage.isFindAPartnerPageDisplayed(), "Find a Partner page is not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        findAPartnerPage.closeBrowser();
    }
}