import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class ContactInformationSteps {

    WebDriver driver;
    WebDriverWait wait;
    CustomerServicePage customerServicePage;

    public ContactInformationSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.customerServicePage = new CustomerServicePage(driver);
    }

    public void givenUserIsOnCustomerServiceSection() {
        driver.get("http://example.com/customer-service");
    }

    public void whenUserChecksContactInformation() {
        customerServicePage.checkContactInformation();
    }

    public void thenSystemShouldDisplayContactInformation() {
        Assert.assertTrue("Contact information not displayed", customerServicePage.isContactInformationDisplayed());
    }

    public void whenUserVerifiesPhoneNumbers() {
        customerServicePage.verifyPhoneNumbers();
    }

    public void thenPhoneNumbersShouldBeCorrect() {
        Assert.assertTrue("Phone numbers are incorrect", customerServicePage.arePhoneNumbersCorrect());
    }

    public void whenUserVerifiesEmailAddresses() {
        customerServicePage.verifyEmailAddresses();
    }

    public void thenEmailAddressesShouldBeCorrect() {
        Assert.assertTrue("Email addresses are incorrect", customerServicePage.areEmailAddressesCorrect());
    }

    public void whenUserVerifiesChatLinks() {
        customerServicePage.verifyChatLinks();
    }

    public void thenChatLinksShouldBeFunctional() {
        Assert.assertTrue("Chat links are not functional", customerServicePage.areChatLinksFunctional());
    }

    public void whenUserClicksOnPhoneNumber() {
        customerServicePage.clickOnPhoneNumber();
    }

    public void thenSystemShouldInitiateCall() {
        Assert.assertTrue("Call not initiated", customerServicePage.isCallInitiated());
    }

    public void whenUserClicksOnEmailAddress() {
        customerServicePage.clickOnEmailAddress();
    }

    public void thenSystemShouldOpenEmailClient() {
        Assert.assertTrue("Email client not opened", customerServicePage.isEmailClientOpened());
    }

    public void whenUserClicksOnChatLink() {
        customerServicePage.clickOnChatLink();
    }

    public void thenSystemShouldOpenChatWindow() {
        Assert.assertTrue("Chat window not opened", customerServicePage.isChatWindowOpened());
    }

    public void whenUserViewsContactInformation() {
        customerServicePage.viewContactInformation();
    }

    public void thenContactInformationShouldBeUserFriendly() {
        Assert.assertTrue("Contact information not user-friendly", customerServicePage.isContactInformationUserFriendly());
    }

    public void whenUserVerifiesContactInformation() {
        customerServicePage.verifyContactInformation();
    }

    public void thenContactInformationShouldBeCurrent() {
        Assert.assertTrue("Contact information not current", customerServicePage.isContactInformationCurrent());
    }

    public void givenUserIsOnAnyPage() {
        driver.get("http://example.com");
    }

    public void whenUserLooksForContactInformation() {
        customerServicePage.lookForContactInformation();
    }

    public void thenContactInformationShouldBeAccessible() {
        Assert.assertTrue("Contact information not accessible", customerServicePage.isContactInformationAccessible());
    }

    public void givenUserAccessesSystemFromDifferentPlatforms() {
        driver.get("http://example.com/customer-service");
    }

    public void whenUserViewsContactInformation() {
        customerServicePage.viewContactInformation();
    }

    public void thenContactInformationShouldBeConsistent() {
        Assert.assertTrue("Contact information not consistent", customerServicePage.isContactInformationConsistent());
    }

    public void thenContactInformationShouldBeSecure() {
        Assert.assertTrue("Contact information not secure", customerServicePage.isContactInformationSecure());
    }

    public void thenContactInformationShouldBeLocalized() {
        Assert.assertTrue("Contact information not localized", customerServicePage.isContactInformationLocalized());
    }

    public void givenUserIsSystemAdministrator() {
        driver.get("http://example.com/admin");
    }

    public void whenUserUpdatesContactInformation() {
        customerServicePage.updateContactInformation();
    }

    public void thenContactInformationShouldBeUpdatable() {
        Assert.assertTrue("Contact information not updatable", customerServicePage.isContactInformationUpdatable());
    }
}