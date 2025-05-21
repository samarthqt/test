import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class LanguageStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    LanguagePage languagePage;

    public LanguageStepDefinitions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.languagePage = new LanguagePage(driver);
    }

    public void givenUserIsOnHomepage() {
        driver.get("http://example.com");
    }

    public void whenUserSelectsLanguage(String language) {
        languagePage.selectLanguage(language);
    }

    public void thenSiteShouldDisplayContentInLanguage(String language) {
        String displayedLanguage = languagePage.getDisplayedLanguage();
        Assert.assertEquals("Site content is not displayed in " + language, language, displayedLanguage);
    }

    public void thenSiteShouldDisplayContentInEnglishByDefault() {
        String displayedLanguage = languagePage.getDisplayedLanguage();
        Assert.assertEquals("Site content is not displayed in English by default", "English", displayedLanguage);
    }

    public void givenUserSelectsSpanishFromDropdown() {
        languagePage.selectLanguage("Spanish");
    }

    public void andUserNavigatesToAnotherPage() {
        driver.get("http://example.com/another-page");
    }

    public void thenSiteShouldContinueToDisplayContentInSpanish() {
        String displayedLanguage = languagePage.getDisplayedLanguage();
        Assert.assertEquals("Site content is not displayed in Spanish", "Spanish", displayedLanguage);
    }

    public void givenUserSelectsFrenchFromDropdown() {
        languagePage.selectLanguage("French");
    }

    public void whenUserNavigatesToContactUsPage() {
        driver.get("http://example.com/contact-us");
    }

    public void thenContactUsPageShouldDisplayContentInFrench() {
        String displayedLanguage = languagePage.getDisplayedLanguage();
        Assert.assertEquals("Contact Us page content is not displayed in French", "French", displayedLanguage);
    }

    public void thenLanguageDropdownShouldBeVisible() {
        Assert.assertTrue("Language dropdown is not visible", languagePage.isLanguageDropdownVisible());
    }

    public void givenUserSelectsGermanFromDropdown() {
        languagePage.selectLanguage("German");
    }

    public void whenUserRefreshesPage() {
        driver.navigate().refresh();
    }

    public void thenSiteShouldContinueToDisplayContentInGerman() {
        String displayedLanguage = languagePage.getDisplayedLanguage();
        Assert.assertEquals("Site content is not displayed in German", "German", displayedLanguage);
    }
}