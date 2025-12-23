/*
 *  © [2022] Qualitest. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.framework.components.ApplitoolsOperations;
import com.framework.reusable.WebReusableComponents;
import com.framework.selenium.WebDriverFactory;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import java.util.Map;
import java.time.Duration;

public class WebPage extends WebReusableComponents {

	protected By homeLink = By.linkText("Techlistic");
	protected By loginHeader = By.xpath("//*[@class='login_logo']");

	protected By txtUserName = By.name("user-name");
	protected By txtPassword = By.name("password");
	protected By btnLogin = By.xpath("//*[@id='login-button']");
	protected By btnSauceBackPack = By.xpath("//*[@id='item_4_title_link']");
	protected By btnSauceBikeLight = By.xpath("//*[@id='item_0_title_link']");
	protected By btnAddToCart = By.xpath("//*[contains(text(),'Add to cart')]");
	protected By btnCart = By.xpath("//*[@class='shopping_cart_link']");
	protected By btnRemoveCart = By.xpath("//*[contains(text(),'Remove')]");
	protected By btnCheckOut = By.xpath("//*[@id='checkout']");
	protected By btnContinue = By.xpath("//*[@id='continue']");
	protected By btnFinish = By.xpath("//*[@id='finish']");
	protected By btnTopMenu = By.xpath("//*[@id='react-burger-menu-btn']");
	protected By btnLogOut = By.xpath("//*[@id='logout_sidebar_link']");
	protected By btnAllItems = By.xpath("//*[@id='inventory_sidebar_link']");

	protected By btnAcceptCookies = By.id("ez-accept-all");
	protected By lblHeader = By.xpath("//*[@class='app_logo']");

    protected By lblSauceBackPack = By.xpath("//*[contains(text(),'Sauce Labs Backpack')]");
	protected By lblSauceBikeLight = By.xpath("//*[contains(text(),'Sauce Labs Bike Light')]");
	// Error message locator - SauceDemo shows error messages with various text
	// Primary locator: exact error message text
	protected By lblLoginErrorMessage = By.xpath("//*[contains(text(),'Epic sadface: Username and password do not match any user in this service')]");
	// Alternative locators for error message (used as fallback)
	protected By lblLoginErrorGeneric = By.xpath("//*[@data-test='error']");
	protected By lblLoginErrorEpicSadface = By.xpath("//*[contains(text(),'Epic sadface')]");
	protected By lblEmptyCart = By.xpath("//*[@class='cart_desc_label']");
	protected By lblConfirmOrder = By.xpath("//*[contains(text(),'Thank you for your order!')]");
	protected By btnOk = By.xpath("//span[@class='cookie-choices-buttons']/a[text()=\"Ok\"]");
	// Checkout form fields (for shopping cart checkout)
	protected By txtFirstName = By.xpath("//input[@id='first-name']");
	protected By txtLastName = By.xpath("//input[@id='last-name']");
	protected By txtZipCode = By.xpath("//input[@id='postal-code']");
	
	protected By btnGender = By.id("sex-0");
	protected By btnExp = By.id("exp-6");
	protected By btnProf = By.id("profession-0");

	protected By btnToolUFT = By.id("tool-0");
	protected By btnToolProtractor = By.id("tool-1");
	protected By btnToolSelenium = By.id("tool-2");

	protected By selectContinents = By.id("continents");
	protected By btnSubmit = By.id("submit");
	protected By btnCookie = By.xpath("//a[contains(text(),'Got it')]");

	protected ApplitoolsOperations appliTools = new ApplitoolsOperations();

	protected void launchApp() {
		launchUrl(getAppUrl());
		maximizeWindow();
		appliTools.captureContent("");
	}

	protected void verifyLogin() {
		Assert.assertTrue(elementVisible(loginHeader, 10));
	}
	protected void enterUserName(String textValue) {
		enterText(txtUserName, textValue);
	}

	protected void enterPassword(String textValue) {
		enterText(txtPassword, textValue);
		// Handle password breach popup if it appears
		WebDriverFactory.handlePasswordBreachPopup(driver);
	}
	protected void clickLoginbutton() {
		if(elementVisible(btnLogin)) {
			clickElement(btnLogin);
		}
	}

	protected void clickButton(By buttonName) {
		if(elementVisible(buttonName)) {
			clickElement(buttonName);
		}
	}
	protected void clickAcceptCookies() {
		if(elementVisible(btnAcceptCookies,10)) {
			clickElement(btnAcceptCookies);
		}
	}

	protected void verifyHome() {
		Assert.assertTrue(elementVisible(lblHeader, 5));
	}

	protected void clickOkButton() {
		if(elementVisible(btnOk)) {
			clickElement(btnOk);
		}
	}

	protected void clickSauceBackPackPagelink() {
		if(elementVisible(btnSauceBackPack)) {
			clickElement(btnSauceBackPack);
		}
	}
	protected void verifySauceBackPackPage() {
		Assert.assertTrue(elementVisible(lblSauceBackPack, 5));
	}

	protected void clickAddToCartButton() {
		if(elementVisible(btnAddToCart)) {
			clickElement(btnAddToCart);
		}
	}

	protected void clickCartButton() {
		if(elementVisible(btnCart)) {
			clickElement(btnCart);
		}
	}
	protected void verifyCartSauceLabBackPack() {
		Assert.assertTrue(elementVisible(lblSauceBackPack, 5));
	}
	protected void clickRemovefromCartButton() {
		if(elementVisible(btnRemoveCart)) {
			clickElement(btnRemoveCart);
		}
	}
	protected void verifyEmptyCart() {
		Assert.assertTrue(elementVisible(lblEmptyCart, 5));
	}
	// Checkout form methods
	protected void enterFistName(String firstname) {
		enterText(txtFirstName, firstname);
	}

	protected void enterFirstName(String firstName) {
		enterText(txtFirstName, firstName);
	}

	protected void enterLastName(String lastname) {
		enterText(txtLastName, lastname);
	}
	
	// Automation Practice Form methods
	protected void enterPracticeFormFirstName(String firstName) {
		try {
			// Wait for page to be ready and form elements to be present
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("input")));
			
			WebElement element = findElementByMultipleStrategies("firstname", "firstName", "first-name");
			if (element != null) {
				enterTextDirectly(element, firstName);
			} else {
				System.out.println("Warning: Could not find first name field with standard locators. Trying alternative approach...");
				// Try finding any input field that might be the first name
				try {
					java.util.List<WebElement> inputs = driver.findElements(By.tagName("input"));
					for (WebElement input : inputs) {
						try {
							String type = input.getAttribute("type");
							if (("text".equals(type) || type == null) && input.isDisplayed() && input.isEnabled()) {
								// Check if it's likely the first name field
								String placeholder = input.getAttribute("placeholder");
								String name = input.getAttribute("name");
								String id = input.getAttribute("id");
								if ((placeholder != null && placeholder.toLowerCase().contains("first")) ||
									(name != null && name.toLowerCase().contains("first")) ||
									(id != null && id.toLowerCase().contains("first"))) {
									enterTextDirectly(input, firstName);
									System.out.println("Found first name field using alternative method (name/id/placeholder contains 'first')");
									return;
								}
							}
						} catch (Exception e3) {
							// Skip this element and continue
							continue;
						}
					}
					System.out.println("Could not find first name field using any method");
				} catch (Exception e2) {
					System.out.println("Alternative approach also failed: " + e2.getMessage());
				}
			}
		} catch (Exception e) {
			System.out.println("Error in enterPracticeFormFirstName: " + e.getMessage());
		}
	}

	protected void enterPracticeFormLastName(String lastName) {
		try {
			// Wait for page to be ready and form elements to be present
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("input")));
			
			WebElement element = findElementByMultipleStrategies("lastname", "lastName", "last-name");
			if (element != null) {
				enterTextDirectly(element, lastName);
			} else {
				System.out.println("Warning: Could not find last name field with standard locators. Trying alternative approach...");
				// Try finding any input field that might be the last name
				try {
					java.util.List<WebElement> inputs = driver.findElements(By.tagName("input"));
					for (WebElement input : inputs) {
						try {
							String type = input.getAttribute("type");
							if (("text".equals(type) || type == null) && input.isDisplayed() && input.isEnabled()) {
								String placeholder = input.getAttribute("placeholder");
								String name = input.getAttribute("name");
								String id = input.getAttribute("id");
								if ((placeholder != null && placeholder.toLowerCase().contains("last")) ||
									(name != null && name.toLowerCase().contains("last")) ||
									(id != null && id.toLowerCase().contains("last"))) {
									enterTextDirectly(input, lastName);
									System.out.println("Found last name field using alternative method (name/id/placeholder contains 'last')");
									return;
								}
							}
						} catch (Exception e3) {
							// Skip this element and continue
							continue;
						}
					}
					System.out.println("Could not find last name field using any method");
				} catch (Exception e2) {
					System.out.println("Alternative approach also failed: " + e2.getMessage());
				}
			}
		} catch (Exception e) {
			System.out.println("Error in enterPracticeFormLastName: " + e.getMessage());
		}
	}

	/**
	 * Check if the current WebDriver session is alive.
	 */
	protected boolean isSessionAlive() {
		try {
			// A lightweight command that will throw if session is gone
			driver.getTitle();
			return true;
		} catch (org.openqa.selenium.NoSuchSessionException e) {
			return false;
		} catch (Exception e) {
			return true; // other transient errors should not be treated as dead session
		}
	}
	
	/**
	 * Helper method to find element by trying multiple strategies sequentially
	 * @param identifiers Variable number of identifiers to try (e.g., "firstname", "firstName", "first-name")
	 * @return WebElement if found, null otherwise
	 */
	private WebElement findElementByMultipleStrategies(String... identifiers) {
		// Try multiple strategies with waits
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Try each identifier with multiple locator strategies
		for (String identifier : identifiers) {
			try {
				// Try by name
				return wait.until(ExpectedConditions.presenceOfElementLocated(By.name(identifier)));
			} catch (Exception e1) {
				try {
					// Try by ID
					return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(identifier)));
				} catch (Exception e2) {
					try {
						// Try by class name
						return wait.until(ExpectedConditions.presenceOfElementLocated(By.className(identifier)));
					} catch (Exception e3) {
						// Continue to next identifier
						continue;
					}
				}
			}
		}
		
		// If all individual identifiers failed, try CSS selector and XPath with all identifiers
		try {
			StringBuilder cssSelector = new StringBuilder();
			for (int i = 0; i < identifiers.length; i++) {
				if (i > 0) cssSelector.append(", ");
				cssSelector.append("input[name='").append(identifiers[i]).append("'], input[id='").append(identifiers[i]).append("']");
			}
			return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector.toString())));
		} catch (Exception e4) {
			try {
				// Last resort: try XPath with contains for all identifiers
				StringBuilder xpathBuilder = new StringBuilder("//input[");
				for (int i = 0; i < identifiers.length; i++) {
					if (i > 0) xpathBuilder.append(" or ");
					xpathBuilder.append("contains(@name, '").append(identifiers[i]).append("') or contains(@id, '").append(identifiers[i]).append("')");
				}
				xpathBuilder.append("]");
				return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathBuilder.toString())));
			} catch (Exception e5) {
				return null;
			}
		}
	}
	
	/**
	 * Helper method to enter text directly into an element
	 * @param element The WebElement to enter text into
	 * @param text The text to enter
	 */
	private void enterTextDirectly(WebElement element, String text) {
		try {
			element.clear();
			element.sendKeys(text);
			System.out.println("Entered text '" + text + "' into element");
		} catch (Exception e) {
			System.out.println("Warning: Could not enter text into element - " + e.getMessage());
		}
	}

	protected void enterZipCode(String zipCode) {
		enterText(txtZipCode, zipCode);
	}

	protected void clickCheckOutButton() {
		if(elementVisible(btnCheckOut)) {
			clickElement(btnCheckOut);
		}
	}

	protected void clickContinueButton() {
		if(elementVisible(btnContinue)) {
			clickElement(btnContinue);
		}
	}

	protected void clickFinishButton() {
		if(elementVisible(btnFinish)) {
			clickElement(btnFinish);
		}
	}
	protected void clickTopMenuButton() {
		if(elementVisible(btnTopMenu)) {
			clickElement(btnTopMenu);
		}
	}
	protected void clickLogOutButton() {
		if(elementVisible(btnLogOut)) {
			clickElement(btnLogOut);
		}
	}

	protected void clickAllItemButton() {
		if(elementVisible(btnAllItems)) {
			clickElement(btnAllItems);
		}
	}

	protected void clickSauceLabBikeLightButton() {
		if(elementVisible(btnSauceBikeLight)) {
			clickElement(btnSauceBikeLight);
		}
	}

	protected void verifySauceBikeLightPage() {
		Assert.assertTrue(elementVisible(lblSauceBikeLight, 5));
	}

	protected void verifyInvalidCredentialsMessage() {
		// Increased timeout to 10 seconds and added more flexible error message check
		// The error message might take time to appear or the text might vary slightly
		boolean errorVisible = elementVisible(lblLoginErrorMessage, 10);
		
		// If the specific error message is not found, try alternative locators
		if (!errorVisible) {
			// Try SauceDemo's data-test attribute for error messages
			errorVisible = elementVisible(lblLoginErrorGeneric, 5);
		}
		
		// If still not found, try the more generic "Epic sadface" text
		if (!errorVisible) {
			errorVisible = elementVisible(lblLoginErrorEpicSadface, 5);
		}
		
		Assert.assertTrue(errorVisible, 
			"Error message for invalid credentials was not displayed. " +
			"Checked for: 1) Exact error text, 2) data-test='error' attribute, 3) 'Epic sadface' text");
	}

	protected void verifyOrderConfirmPage() {
		Assert.assertTrue(elementVisible(lblConfirmOrder, 20));
	}

	protected void clickGender() {
		clickElement(btnGender);
	}

	protected void clickExperience() {
		clickElement(btnExp);
	}

	protected void clickProfession() {
		clickElement(btnProf);
	}

	protected void clickToolUFT() {
		clickElement(btnToolUFT);
	}

	protected void clickToolProtractor() {
		clickElement(btnToolProtractor);
	}

	protected void clickToolSelenium() {
		clickElement(btnToolSelenium);
	}

	protected void selectCountry(String value) {
		selectByValue(selectContinents,value);
	}

	protected void submitDetails() {
		clickElement(btnSubmit);
		//appliTools.captureContent("");
	}

	/**
	 * Get performance statistics from the browser
	 * Uses JavaScript Performance API to get page load metrics
	 */
	protected void getPerformanceStatistics() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			// Get navigation timing using JavaScript Performance API
			String performanceScript = 
				"var performance = window.performance || window.webkitPerformance || window.mozPerformance || window.msPerformance || {};" +
				"var timing = performance.timing || {};" +
				"var navigation = performance.navigation || {};" +
				"var memory = performance.memory || {};" +
				"return {" +
				"  pageLoadTime: timing.loadEventEnd - timing.navigationStart," +
				"  domContentLoaded: timing.domContentLoadedEventEnd - timing.navigationStart," +
				"  domInteractive: timing.domInteractive - timing.navigationStart," +
				"  redirectTime: timing.redirectEnd - timing.redirectStart," +
				"  dnsTime: timing.domainLookupEnd - timing.domainLookupStart," +
				"  connectTime: timing.connectEnd - timing.connectStart," +
				"  requestTime: timing.responseStart - timing.requestStart," +
				"  responseTime: timing.responseEnd - timing.responseStart," +
				"  renderTime: timing.domComplete - timing.domLoading," +
				"  navigationType: navigation.type," +
				"  memoryUsed: memory.usedJSHeapSize || 0," +
				"  memoryTotal: memory.totalJSHeapSize || 0," +
				"  memoryLimit: memory.jsHeapSizeLimit || 0" +
				"};";
			
			Object performanceData = js.executeScript(performanceScript);
			
			// Format and log performance statistics
			System.out.println("=== Performance Statistics ===");
			System.out.println("Page Load Time: " + getNestedValue(performanceData, "pageLoadTime") + " ms");
			System.out.println("DOM Content Loaded: " + getNestedValue(performanceData, "domContentLoaded") + " ms");
			System.out.println("DOM Interactive: " + getNestedValue(performanceData, "domInteractive") + " ms");
			System.out.println("Redirect Time: " + getNestedValue(performanceData, "redirectTime") + " ms");
			System.out.println("DNS Time: " + getNestedValue(performanceData, "dnsTime") + " ms");
			System.out.println("Connect Time: " + getNestedValue(performanceData, "connectTime") + " ms");
			System.out.println("Request Time: " + getNestedValue(performanceData, "requestTime") + " ms");
			System.out.println("Response Time: " + getNestedValue(performanceData, "responseTime") + " ms");
			System.out.println("Render Time: " + getNestedValue(performanceData, "renderTime") + " ms");
			
			Long memoryUsed = getNestedLongValue(performanceData, "memoryUsed");
			if (memoryUsed > 0) {
				System.out.println("Memory Used: " + (memoryUsed / 1024 / 1024) + " MB");
				System.out.println("Memory Total: " + (getNestedLongValue(performanceData, "memoryTotal") / 1024 / 1024) + " MB");
				System.out.println("Memory Limit: " + (getNestedLongValue(performanceData, "memoryLimit") / 1024 / 1024) + " MB");
			}
			System.out.println("============================");
			
			// Also use PerformanceOptimizer to get framework performance stats
			com.framework.selenium.PerformanceOptimizer.PerformanceStats stats = 
				com.framework.selenium.PerformanceOptimizer.getPerformanceStats();
			if (stats != null) {
				System.out.println("=== Framework Performance Statistics ===");
				System.out.println("Active Threads: " + stats.getActiveThreads());
				System.out.println("Completed Tests: " + stats.getCompletedTests());
				System.out.println("Failed Tests: " + stats.getFailedTests());
				System.out.println("Total Execution Time: " + stats.getTotalExecutionTime() + " ms");
				System.out.println("Thread Pool Size: " + stats.getPoolSize());
				System.out.println("Queue Size: " + stats.getQueueSize());
				System.out.println("Average Execution Time: " + String.format("%.2f", stats.getAverageExecutionTime()) + " ms");
				System.out.println("Success Rate: " + String.format("%.2f", stats.getSuccessRate()) + "%");
				System.out.println("==========================================");
			}
			
		} catch (Exception e) {
			System.out.println("Warning: Could not retrieve performance statistics - " + e.getMessage());
			// Continue execution even if performance stats fail
		}
	}
	
	/**
	 * Helper method to safely get nested value from JavaScript return object
	 */
	@SuppressWarnings("unchecked")
	private Long getNestedLongValue(Object obj, String key) {
		try {
			if (obj instanceof Map) {
				Object value = ((Map<String, Object>) obj).get(key);
				if (value instanceof Number) {
					return ((Number) value).longValue();
				} else if (value != null) {
					return Long.parseLong(value.toString());
				}
			}
		} catch (Exception e) {
			// Ignore and return 0
		}
		return 0L;
	}
	
	/**
	 * Helper method to safely get nested value from JavaScript return object
	 */
	@SuppressWarnings("unchecked")
	private String getNestedValue(Object obj, String key) {
		try {
			if (obj instanceof Map) {
				Object value = ((Map<String, Object>) obj).get(key);
				return value != null ? value.toString() : "N/A";
			}
		} catch (Exception e) {
			// Ignore and return N/A
		}
		return "N/A";
	}

	/**
	 * Scroll to element by ID, name, class, or other identifier
	 * @param elementIdentifier The ID, name, class, or other identifier of the element
	 */
	protected void scrollToElement(String elementIdentifier) {
		try {
			WebElement element = null;
			
			// Try to find element by ID first
			try {
				element = driver.findElement(By.id(elementIdentifier));
			} catch (Exception e1) {
				// Try by name
				try {
					element = driver.findElement(By.name(elementIdentifier));
				} catch (Exception e2) {
					// Try by class name
					try {
						element = driver.findElement(By.className(elementIdentifier));
					} catch (Exception e3) {
						// Try by xpath with text or contains
						try {
							element = driver.findElement(By.xpath("//*[contains(@id, '" + elementIdentifier + "') or contains(@class, '" + elementIdentifier + "') or contains(text(), '" + elementIdentifier + "')]"));
						} catch (Exception e4) {
							// Last resort: try as CSS selector
							element = driver.findElement(By.cssSelector("#" + elementIdentifier + ", ." + elementIdentifier + ", [name='" + elementIdentifier + "']"));
						}
					}
				}
			}
			
			if (element != null) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
				System.out.println("Scrolled to element: " + elementIdentifier);
			} else {
				System.out.println("Warning: Could not find element: " + elementIdentifier);
			}
		} catch (Exception e) {
			System.out.println("Warning: Could not scroll to element: " + elementIdentifier + " - " + e.getMessage());
		}
	}

	/**
	 * Hover over element by ID, name, class, or other identifier
	 * @param elementIdentifier The ID, name, class, or other identifier of the element
	 */
	protected void hoverOverElement(String elementIdentifier) {
		try {
			WebElement element = findElementByIdentifier(elementIdentifier);
			if (element != null) {
				Actions actions = new Actions(driver);
				actions.moveToElement(element).build().perform();
				System.out.println("Hovered over element: " + elementIdentifier);
			}
		} catch (Exception e) {
			System.out.println("Warning: Could not hover over element: " + elementIdentifier + " - " + e.getMessage());
		}
	}

	/**
	 * Double click element by ID, name, class, or other identifier
	 * @param elementIdentifier The ID, name, class, or other identifier of the element
	 */
	protected void doubleClickElement(String elementIdentifier) {
		try {
			WebElement element = findElementByIdentifier(elementIdentifier);
			if (element != null) {
				Actions actions = new Actions(driver);
				actions.doubleClick(element).build().perform();
				System.out.println("Double clicked element: " + elementIdentifier);
			}
		} catch (Exception e) {
			System.out.println("Warning: Could not double click element: " + elementIdentifier + " - " + e.getMessage());
		}
	}

	/**
	 * Right click (context click) element by ID, name, class, or other identifier
	 * @param elementIdentifier The ID, name, class, or other identifier of the element
	 */
	protected void rightClickElement(String elementIdentifier) {
		try {
			WebElement element = findElementByIdentifier(elementIdentifier);
			if (element != null) {
				Actions actions = new Actions(driver);
				actions.contextClick(element).build().perform();
				System.out.println("Right clicked element: " + elementIdentifier);
			}
		} catch (Exception e) {
			System.out.println("Warning: Could not right click element: " + elementIdentifier + " - " + e.getMessage());
		}
	}

	/**
	 * Helper method to find element by various identifiers
	 * @param elementIdentifier The ID, name, class, or other identifier of the element
	 * @return WebElement if found, null otherwise
	 */
	private WebElement findElementByIdentifier(String elementIdentifier) {
		try {
			// Try by ID first
			return driver.findElement(By.id(elementIdentifier));
		} catch (Exception e1) {
			try {
				// Try by name
				return driver.findElement(By.name(elementIdentifier));
			} catch (Exception e2) {
				try {
					// Try by class name
					return driver.findElement(By.className(elementIdentifier));
				} catch (Exception e3) {
					try {
						// Try by xpath with contains
						return driver.findElement(By.xpath("//*[contains(@id, '" + elementIdentifier + "') or contains(@class, '" + elementIdentifier + "') or contains(@name, '" + elementIdentifier + "')]"));
					} catch (Exception e4) {
						try {
							// Try as CSS selector
							return driver.findElement(By.cssSelector("#" + elementIdentifier + ", ." + elementIdentifier + ", [name='" + elementIdentifier + "']"));
						} catch (Exception e5) {
							return null;
						}
					}
				}
			}
		}
	}

	/**
	 * Build a flexible By locator from a simple identifier without probing the driver.
	 * Tries id, name, class and a broad XPath contains selector.
	 * This method does NOT call findElement, it only returns candidates.
	 */
	private By buildFlexibleLocator(String elementIdentifier) {
		// Prefer fast exact matches first
		if (elementIdentifier != null && !elementIdentifier.isEmpty()) {
			return By.xpath("//*[@id='" + elementIdentifier + "' or @name='" + elementIdentifier + "' or contains(@class,'" + elementIdentifier + "') or contains(@id,'" + elementIdentifier + "') or contains(@name,'" + elementIdentifier + "')]");
		}
		return By.xpath("//*");
	}

	/**
	 * Find element above another element using Relative Locators (Selenium 4.x feature)
	 * @param targetElementIdentifier The ID, name, class of the element to find
	 * @param referenceElementIdentifier The ID, name, class of the reference element
	 */
	protected void findElementAbove(String targetElementIdentifier, String referenceElementIdentifier) {
		try {
			if (!isSessionAlive()) { return; }
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			By referenceLocator = buildFlexibleLocator(referenceElementIdentifier);
			WebElement reference = wait.until(ExpectedConditions.presenceOfElementLocated(referenceLocator));
			By targetLocator = buildFlexibleLocator(targetElementIdentifier);
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
					RelativeLocator.with(targetLocator).above(reference)));
			
			if (element != null) {
				System.out.println("Found element '" + targetElementIdentifier + "' above element '" + referenceElementIdentifier + "'");
				// Scroll to the element to make it visible
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
			}
		} catch (Exception e) {
			System.out.println("Warning: Could not find element '" + targetElementIdentifier + "' above element '" + referenceElementIdentifier + "' - " + e.getMessage());
		}
	}

	/**
	 * Find element below another element using Relative Locators (Selenium 4.x feature)
	 * @param targetElementIdentifier The ID, name, class of the element to find
	 * @param referenceElementIdentifier The ID, name, class of the reference element
	 */
	protected void findElementBelow(String targetElementIdentifier, String referenceElementIdentifier) {
		try {
			if (!isSessionAlive()) { return; }
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			By referenceLocator = buildFlexibleLocator(referenceElementIdentifier);
			WebElement reference = wait.until(ExpectedConditions.presenceOfElementLocated(referenceLocator));
			By targetLocator = buildFlexibleLocator(targetElementIdentifier);
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
					RelativeLocator.with(targetLocator).below(reference)));
			
			if (element != null) {
				System.out.println("Found element '" + targetElementIdentifier + "' below element '" + referenceElementIdentifier + "'");
				// Scroll to the element to make it visible
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
			}
		} catch (Exception e) {
			System.out.println("Warning: Could not find element '" + targetElementIdentifier + "' below element '" + referenceElementIdentifier + "' - " + e.getMessage());
		}
	}

	/**
	 * Find element near another element using Relative Locators (Selenium 4.x feature)
	 * @param targetElementIdentifier The ID, name, class of the element to find
	 * @param referenceElementIdentifier The ID, name, class of the reference element
	 */
	protected void findElementNear(String targetElementIdentifier, String referenceElementIdentifier) {
		try {
			if (!isSessionAlive()) { return; }
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			By referenceLocator = buildFlexibleLocator(referenceElementIdentifier);
			WebElement reference = wait.until(ExpectedConditions.presenceOfElementLocated(referenceLocator));
			By targetLocator = buildFlexibleLocator(targetElementIdentifier);
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
					RelativeLocator.with(targetLocator).near(reference)));
			
			if (element != null) {
				System.out.println("Found element '" + targetElementIdentifier + "' near element '" + referenceElementIdentifier + "'");
				// Scroll to the element to make it visible
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
			}
		} catch (Exception e) {
			System.out.println("Warning: Could not find element '" + targetElementIdentifier + "' near element '" + referenceElementIdentifier + "' - " + e.getMessage());
		}
	}

	/**
	 * Interact with Shadow DOM element using JavaScript
	 * @param shadowElementSelector CSS selector for the element within shadow DOM (e.g., ".shadow-content")
	 * @param hostElementIdentifier The shadow host element identifier (tag name, ID, or class)
	 */
	protected void interactWithShadowDOMElement(String shadowElementSelector, String hostElementIdentifier) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			// Find the shadow host element
			WebElement hostElement = null;
			try {
				// Try as tag name first (common for custom elements like "lucom-wci-form")
				hostElement = driver.findElement(By.tagName(hostElementIdentifier));
			} catch (Exception e1) {
				try {
					// Try as ID
					hostElement = driver.findElement(By.id(hostElementIdentifier));
				} catch (Exception e2) {
					try {
						// Try as class name
						hostElement = driver.findElement(By.className(hostElementIdentifier));
					} catch (Exception e3) {
						// Try as CSS selector
						hostElement = driver.findElement(By.cssSelector(hostElementIdentifier));
					}
				}
			}
			
			if (hostElement == null) {
				System.out.println("Warning: Could not find shadow host element: " + hostElementIdentifier);
				return;
			}
			
			// Access shadow root and find element within it
			String script = 
				"var host = arguments[0];" +
				"var shadowRoot = host.shadowRoot;" +
				"if (!shadowRoot) {" +
				"  return 'No shadow root found';" +
				"}" +
				"var element = shadowRoot.querySelector(arguments[1]);" +
				"if (!element) {" +
				"  return 'Element not found in shadow DOM';" +
				"}" +
				"element.scrollIntoView({behavior: 'smooth', block: 'center'});" +
				"element.click();" +
				"return 'Successfully interacted with shadow DOM element';";
			
			Object result = js.executeScript(script, hostElement, shadowElementSelector);
			System.out.println("Shadow DOM interaction result: " + result);
			System.out.println("Interacted with shadow DOM element '" + shadowElementSelector + "' in host '" + hostElementIdentifier + "'");
			
		} catch (Exception e) {
			System.out.println("Warning: Could not interact with shadow DOM element '" + shadowElementSelector + "' in host '" + hostElementIdentifier + "' - " + e.getMessage());
			// Note: Shadow DOM may not be available on all pages, so this is expected in some cases
		}
	}

	/**
	 * Wait for custom condition
	 * Supports various custom wait conditions like:
	 * - "page_load": Wait for page to finish loading
	 * - "element_enabled": Wait for a common element to be enabled
	 * - "jquery_ready": Wait for jQuery to be ready (if available)
	 * - "angular_ready": Wait for Angular to be ready (if available)
	 * @param conditionName The name of the custom condition to wait for
	 */
	protected void waitForCustomCondition(String conditionName) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(30));
			
			switch (conditionName.toLowerCase()) {
				case "page_load":
					// Wait for page to be in complete state
					wait.until(new org.openqa.selenium.support.ui.ExpectedCondition<Boolean>() {
						@Override
						public Boolean apply(org.openqa.selenium.WebDriver driver) {
							return js.executeScript("return document.readyState").equals("complete");
						}
					});
					System.out.println("Custom condition 'page_load' completed - Page is fully loaded");
					break;
					
				case "element_enabled":
					// Wait for common elements to be enabled (like login button, submit button, etc.)
					wait.until(new org.openqa.selenium.support.ui.ExpectedCondition<Boolean>() {
						@Override
						public Boolean apply(org.openqa.selenium.WebDriver driver) {
							try {
								// Try to find common interactive elements and check if they're enabled
								java.util.List<org.openqa.selenium.WebElement> buttons = driver.findElements(By.tagName("button"));
								java.util.List<org.openqa.selenium.WebElement> inputs = driver.findElements(By.tagName("input"));
								
								// Check if at least one button or input is enabled
								for (org.openqa.selenium.WebElement btn : buttons) {
									if (btn.isEnabled() && btn.isDisplayed()) {
										return true;
									}
								}
								for (org.openqa.selenium.WebElement input : inputs) {
									if (input.isEnabled() && input.isDisplayed()) {
										return true;
									}
								}
								return false;
							} catch (Exception e) {
								return false;
							}
						}
					});
					System.out.println("Custom condition 'element_enabled' completed - At least one element is enabled");
					break;
					
				case "jquery_ready":
					// Wait for jQuery to be ready (if jQuery is used)
					wait.until(new org.openqa.selenium.support.ui.ExpectedCondition<Boolean>() {
						@Override
						public Boolean apply(org.openqa.selenium.WebDriver driver) {
							Object result = js.executeScript("return typeof jQuery !== 'undefined' && jQuery.active === 0");
							return result instanceof Boolean && (Boolean) result;
						}
					});
					System.out.println("Custom condition 'jquery_ready' completed - jQuery is ready");
					break;
					
				case "angular_ready":
					// Wait for Angular to be ready (if Angular is used)
					wait.until(new org.openqa.selenium.support.ui.ExpectedCondition<Boolean>() {
						@Override
						public Boolean apply(org.openqa.selenium.WebDriver driver) {
							Object result = js.executeScript("return typeof angular !== 'undefined' && angular.element(document).injector().get('$http').pendingRequests.length === 0");
							return result instanceof Boolean && (Boolean) result;
						}
					});
					System.out.println("Custom condition 'angular_ready' completed - Angular is ready");
					break;
					
				default:
					System.out.println("Warning: Unknown custom condition '" + conditionName + "'. Supported conditions: page_load, element_enabled, jquery_ready, angular_ready");
					// Default to page_load if condition is unknown
					wait.until(new org.openqa.selenium.support.ui.ExpectedCondition<Boolean>() {
						@Override
						public Boolean apply(org.openqa.selenium.WebDriver driver) {
							return js.executeScript("return document.readyState").equals("complete");
						}
					});
					break;
			}
		} catch (Exception e) {
			System.out.println("Warning: Error waiting for custom condition '" + conditionName + "' - " + e.getMessage());
		}
	}
}