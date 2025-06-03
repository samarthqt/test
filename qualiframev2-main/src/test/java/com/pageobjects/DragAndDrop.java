package com.pageobjects;

import com.framework.components.ApplitoolsOperations;
import com.framework.components.ScriptHelper;
import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DragAndDrop extends WebReusableComponents {


    public DragAndDrop(ScriptHelper scriptHelper) {
        super(scriptHelper);
    }
    protected ApplitoolsOperations appliTools = new ApplitoolsOperations();

    public void launchApp(String url) {
        launchUrl(url);
        appliTools.captureContent("");
    }

    public void performDragAndDrop() {
        WebElement bankElement = driver.findElement(By.id("credit2"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(bankElement));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bankElement);
        WebElement placeholder = driver.findElement(By.id("bank"));
        wait.until(ExpectedConditions.visibilityOf(placeholder));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(bankElement, placeholder).build().perform();
    }


    }





