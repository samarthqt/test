package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import .io.File;
import .io.IOException;
import .time.Duration;

public class FileUploadPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By uploadFieldLocator = By.id(file_upload);
    private final By uploadButtonLocator = By.id(upload_button);
    private final By uploadConfirmationLocator = By.id(upload_confirmation);

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToUploadPage() {
        driver.get(http://example.com/upload);
    }

    public void uploadFile(String filePath) {
        WebElement uploadField = wait.until(ExpectedConditions.visibilityOfElementLocated(uploadFieldLocator));
        uploadField.sendKeys(filePath);

        WebElement uploadButton = driver.findElement(uploadButtonLocator);
        uploadButton.click();
    }

    public boolean isUploadConfirmationDisplayed() {
        WebElement uploadConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(uploadConfirmationLocator));
        boolean isDisplayed = uploadConfirmation.isDisplayed();
        Assert.assertTrue(File upload failed, isDisplayed);
        return isDisplayed;
    }

    public void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}