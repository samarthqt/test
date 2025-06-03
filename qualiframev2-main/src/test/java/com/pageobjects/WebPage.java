package com.pageobjects;

import org.openqa.selenium.By;
import com.framework.components.ApplitoolsOperations;
import com.framework.components.ScriptHelper;
import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.JavascriptExecutor;


public class WebPage extends WebReusableComponents {
	public WebPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	protected By txtFirstName = By.name("firstname");
	protected By txtLastName = By.name("lastname");
	protected By btnGender = By.id("sex-0");
	protected By txtDate = By.id("datepicker");
	protected By btnExp = By.id("exp-4");
	protected By btnProf = By.id("profession-0");
	protected By btnToolSelenium = By.id("tool-2");
	protected By btnToolUFT = By.id("tool-0");
	protected By btnToolProtractor = By.id("tool-1");
	protected By selectContinents = By.id("continents");
	protected By selectCommand = By.id("selenium_commands");
	protected By btnSubmit = By.id("submit");


	ApplitoolsOperations appliTools = new ApplitoolsOperations();

	public void launchApp(String url) {
		launchUrl(url);
		appliTools.openEyes(driver);
		appliTools.captureContent("");
	}

	public void enterFistName(String firstname) {
		enterText(txtFirstName, firstname);
	}

	public void enterLastName(String lastname) {
		enterText(txtLastName, lastname);
	}

	public void clickGender() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(btnGender));
		clickElement(btnGender);
	}

	public void enterDate(String date) {
		if (date != null && !date.isEmpty()) {
			enterText(txtDate, date);
		} else {
			System.out.println("Invalid date: " + date);
		}
	}


	public void clickExperience() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(btnExp));
		clickElement(btnExp);
	}

	public void clickProfession() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(btnProf));
		clickElement(btnProf);
	}

	public void clickToolSelenium() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(btnToolSelenium));
		clickElement(btnToolSelenium);
	}

	public void clickToolUFT() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(btnToolUFT));
		clickElement(btnToolUFT);
	}

	public void clickToolProtractor() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(btnToolProtractor));
		clickElement(btnToolProtractor);
	}

	public void ClickSelectCountry(String value) {
		selectByValue(selectContinents, value);
	}

	public void ClickSelectCommand(String value) {
		if (value != null) {
			selectByValue(selectCommand, value);
		} else {
			System.out.println("Error: The value passed is null.");

		}
	}


	public void clickSubmit() {
		clickElement(btnSubmit);
	}
}










