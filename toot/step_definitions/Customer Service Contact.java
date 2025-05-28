import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class CustomerServiceContactSteps {

    WebDriver driver;
    WebDriverWait wait;
    CustomerServiceContactPage contactPage;

    public CustomerServiceContactSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.contactPage = new CustomerServiceContactPage(driver);
    }

    public void givenCustomerServiceContactPageIsDisplayed() {
        driver.get("http://example.com/customer-service");
        Assert.assertTrue("Contact page not displayed", contactPage.isPageDisplayed());
    }

    public void whenContactChannelIsSelected(String channel) {
        contactPage.selectContactChannel(channel);
    }

    public void thenSelectedContactChannelShouldBeHighlighted(String channel) {
        Assert.assertTrue("Channel not highlighted", contactPage.isChannelHighlighted(channel));
    }

    public void givenCustomerContactInformationIsEnteredCorrectly(String name, String email) {
        contactPage.enterContactInformation(name, email);
    }

    public void whenConnectButtonIsClicked() {
        contactPage.clickConnectButton();
    }

    public void thenSystemShouldConnectCustomerWithRepresentative() {
        Assert.assertTrue("Not connected with representative", contactPage.isConnectedWithRepresentative());
    }

    public void givenCustomerConnectedWithRepresentative() {
        Assert.assertTrue("Not connected", contactPage.isConnectedWithRepresentative());
    }

    public void thenCustomerShouldInitiateConversation() {
        contactPage.initiateConversation();
    }

    public void givenRepresentativeIsResponsive() {
        Assert.assertTrue("Representative not responsive", contactPage.isRepresentativeResponsive());
    }

    public void whenCustomerMakesInquiries() {
        contactPage.makeInquiry("Sample inquiry");
    }

    public void thenRepresentativeShouldRespond() {
        Assert.assertTrue("No response from representative", contactPage.isResponseReceived());
    }

    public void givenCustomerInConversation() {
        Assert.assertTrue("Not in conversation", contactPage.isInConversation());
    }

    public void whenCustomerWantsToEndConversation() {
        contactPage.endConversation();
    }

    public void thenConversationShouldBeEnded() {
        Assert.assertFalse("Conversation not ended", contactPage.isInConversation());
    }

    public void givenCustomerWantsToConnectThroughDifferentChannels() {
        Assert.assertTrue("Contact page not displayed", contactPage.isPageDisplayed());
    }

    public void whenProcessRepeatedForEachChannel() {
        contactPage.repeatProcessForAllChannels();
    }

    public void thenCustomerShouldConnectThroughDifferentChannels() {
        Assert.assertTrue("Unable to connect through all channels", contactPage.isConnectedThroughAllChannels());
    }

    public void givenRepresentativeAvailableForEachChannel() {
        Assert.assertTrue("No representative available", contactPage.isRepresentativeAvailableForAllChannels());
    }

    public void thenRepresentativeShouldBeAvailableForEachChannel() {
        Assert.assertTrue("Representative not available", contactPage.isRepresentativeAvailableForAllChannels());
    }

    public void thenPageShouldDisplayRepresentativeAvailability() {
        Assert.assertTrue("Availability info not displayed", contactPage.isAvailabilityInfoDisplayed());
    }

    public void thenPageShouldProvideInstructionsToConnect() {
        Assert.assertTrue("Instructions not provided", contactPage.areInstructionsProvided());
    }

    public void thenPageShouldProvideAlternativeContactMethods() {
        Assert.assertTrue("Alternative methods not provided", contactPage.areAlternativeMethodsProvided());
    }

    public void thenPageShouldDisplayContactInformation() {
        Assert.assertTrue("Contact info not displayed", contactPage.isContactInfoDisplayed());
    }
}