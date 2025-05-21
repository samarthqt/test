import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class ReturnPolicySteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I am on the homepage of the e-commerce site")
    public void i_am_on_the_homepage() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://example.com");
    }

    @When("I navigate to the footer section")
    public void i_navigate_to_footer() {
        WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("footer")));
        Assert.assertNotNull("Footer not found", footer);
    }

    @Then("I should see a link to \"Return Policy\"")
    public void i_should_see_return_policy_link() {
        WebElement returnPolicyLink = driver.findElement(By.linkText("Return Policy"));
        Assert.assertTrue("Return Policy link not visible", returnPolicyLink.isDisplayed());
    }

    @When("I click on the \"Return Policy\" link in the footer")
    public void i_click_return_policy_link() {
        WebElement returnPolicyLink = driver.findElement(By.linkText("Return Policy"));
        returnPolicyLink.click();
    }

    @Then("I should be redirected to the \"Return Policy\" page")
    public void i_should_be_redirected_to_return_policy_page() {
        wait.until(ExpectedConditions.urlContains("return-policy"));
        Assert.assertTrue("Not on Return Policy page", driver.getCurrentUrl().contains("return-policy"));
    }

    @Then("I should see the return policy details clearly displayed")
    public void i_should_see_return_policy_details() {
        WebElement policyDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("policy-details")));
        Assert.assertTrue("Policy details not displayed", policyDetails.isDisplayed());
    }

    @Given("I am on a product page")
    public void i_am_on_a_product_page() {
        driver.get("http://example.com/product");
    }

    @When("I scroll to the bottom of the page")
    public void i_scroll_to_bottom() {
        WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("footer")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
    }

    @Given("I am on the \"Return Policy\" page")
    public void i_am_on_return_policy_page() {
        driver.get("http://example.com/return-policy");
    }

    @Then("I should see information about:")
    public void i_should_see_information_about(List<String> topics) {
        for (String topic : topics) {
            WebElement topicElement = driver.findElement(By.xpath("//*[contains(text(), '" + topic + "')]");
            Assert.assertTrue("Topic not found: " + topic, topicElement.isDisplayed());
        }
    }

    @Given("I am using a mobile device")
    public void i_am_using_mobile_device() {
        // Code to simulate mobile device
    }

    @When("I navigate to the \"Return Policy\" page")
    public void i_navigate_to_return_policy_page() {
        driver.get("http://example.com/return-policy");
    }

    @Then("the return policy details should be clearly visible and readable")
    public void return_policy_details_visible() {
        WebElement policyDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("policy-details")));
        Assert.assertTrue("Policy details not visible", policyDetails.isDisplayed());
    }

    @Then("the page layout should be responsive")
    public void page_layout_responsive() {
        // Code to verify responsive layout
    }

    @When("I change the site language to Spanish")
    public void i_change_language_to_spanish() {
        WebElement languageDropdown = driver.findElement(By.id("language-selector"));
        languageDropdown.click();
        WebElement spanishOption = driver.findElement(By.xpath("//option[@value='es']"));
        spanishOption.click();
    }

    @Then("the return policy details should be displayed in Spanish")
    public void return_policy_in_spanish() {
        WebElement policyDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("policy-details")));
        Assert.assertTrue("Policy details not in Spanish", policyDetails.getText().contains("Devoluciones"));
    }
}