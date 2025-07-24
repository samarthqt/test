package com.qt.pshop.pageobjs;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.framework.reusable.WebReusableComponents;

public class LoginPage extends WebReusableComponents {

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");
    private By dashboard = By.id("dashboard");

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        enterText(usernameField, username);
        enterText(passwordField, password);
        clickElement(loginButton);
    }

    public boolean isDashboardDisplayed() {
        return isElementVisible(dashboard, 5);
    }
}