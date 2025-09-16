package selenium1.test_scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium1.page_objects.AgileTestingPage;
import static org.testng.Assert.assertTrue;

public class AgileTestingTest {

    private AgileTestingPage agileTestingPage;

    @BeforeMethod
    public void setUp() {
        agileTestingPage = new AgileTestingPage();
        agileTestingPage.openBrowser();
    }

    @Test
    public void testAgileTestingPage() {
        agileTestingPage.navigateToPlatformPage();
        agileTestingPage.clickAgileTestingSubMenu();
        agileTestingPage.clickGetFreeTrial();
        assertTrue(agileTestingPage.clickScaleAgileLearnMore(), "Scale Agile Learn More button did not work as expected.");
        assertTrue(agileTestingPage.clickExplorerTestingLearnMore(), "eXplorer Testing Learn More button did not work as expected.");
        assertTrue(agileTestingPage.clickDistributedTeamLearnMore(), "Distributed Team Learn More button did not work as expected.");
        assertTrue(agileTestingPage.clickIntegrationAPIsLearnMore(), "Integration & APIs Learn More button did not work as expected.");
    }

    @AfterMethod
    public void tearDown() {
        agileTestingPage.closeBrowser();
    }
}