import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class ChatSupportStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    public ChatSupportStepDefinitions() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void givenChatSupportSystemIsOperational() {
        driver.get("http://example.com/chat-support");
    }

    public void givenCustomerServiceRepresentativeIsLoggedIntoSystem() {
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button")));
        loginButton.click();
    }

    public void givenCustomerNavigatesToChatSupportPage() {
        driver.get("http://example.com/chat-support");
    }

    public void whenCustomerClicksStartChatButton() {
        WebElement startChatButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start_chat_button")));
        startChatButton.click();
    }

    public void thenNewChatSessionShouldBeInitiated() {
        WebElement chatSession = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chat_session")));
        Assert.assertTrue(chatSession.isDisplayed());
    }

    public void thenCustomerShouldSeeWelcomeMessage() {
        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome_message")));
        Assert.assertTrue(welcomeMessage.isDisplayed());
    }

    public void givenCustomerHasInitiatedChatSession() {
        WebElement chatSession = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chat_session")));
        Assert.assertTrue(chatSession.isDisplayed());
    }

    public void whenChatRequestIsSentToRepresentative() {
        WebElement sendRequestButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("send_request_button")));
        sendRequestButton.click();
    }

    public void thenRepresentativeShouldReceiveNotificationOfNewChatRequest() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notification")));
        Assert.assertTrue(notification.isDisplayed());
    }

    public void thenChatSessionShouldBeDisplayedInRepresentativesChatInterface() {
        WebElement chatInterface = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chat_interface")));
        Assert.assertTrue(chatInterface.isDisplayed());
    }

    public void givenChatSessionIsActive() {
        WebElement chatSession = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chat_session")));
        Assert.assertTrue(chatSession.isDisplayed());
    }

    public void whenCustomerTypesMessageAndClicksSend() {
        WebElement messageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message_field")));
        messageField.sendKeys("Hello!");
        WebElement sendButton = driver.findElement(By.id("send_button"));
        sendButton.click();
    }

    public void thenMessageShouldAppearInChatWindowForBothCustomerAndRepresentative() {
        WebElement chatWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chat_window")));
        Assert.assertTrue(chatWindow.getText().contains("Hello!"));
    }

    public void givenCustomerHasSentMessage() {
        WebElement chatWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chat_window")));
        Assert.assertTrue(chatWindow.getText().contains("Hello!"));
    }

    public void whenRepresentativeTypesResponseAndClicksSend() {
        WebElement responseField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("response_field")));
        responseField.sendKeys("Hi there!");
        WebElement sendButton = driver.findElement(By.id("send_button"));
        sendButton.click();
    }

    public void thenResponseShouldAppearInChatWindowForBothRepresentativeAndCustomer() {
        WebElement chatWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chat_window")));
        Assert.assertTrue(chatWindow.getText().contains("Hi there!"));
    }

    public void whenCustomerClicksEndChatButton() {
        WebElement endChatButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("end_chat_button")));
        endChatButton.click();
    }

    public void thenChatSessionShouldBeTerminated() {
        WebElement chatSession = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("chat_session")));
        Assert.assertFalse(chatSession.isDisplayed());
    }

    public void thenCustomerShouldSeeFeedbackForm() {
        WebElement feedbackForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("feedback_form")));
        Assert.assertTrue(feedbackForm.isDisplayed());
    }

    public void whenRepresentativeClicksEndChatButton() {
        WebElement endChatButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("end_chat_button")));
        endChatButton.click();
    }

    public void thenRepresentativeShouldSeeSummaryOfChatSession() {
        WebElement chatSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chat_summary")));
        Assert.assertTrue(chatSummary.isDisplayed());
    }

    public void whenNoActivityForPredefinedPeriod() {
        // Simulate inactivity
        try {
            Thread.sleep(60000); // 1 minute inactivity
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void thenChatSessionShouldAutomaticallyEnd() {
        WebElement chatSession = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("chat_session")));
        Assert.assertFalse(chatSession.isDisplayed());
    }

    public void thenBothPartiesShouldReceiveNotificationOfSessionTimeout() {
        WebElement timeoutNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timeout_notification")));
        Assert.assertTrue(timeoutNotification.isDisplayed());
    }
}