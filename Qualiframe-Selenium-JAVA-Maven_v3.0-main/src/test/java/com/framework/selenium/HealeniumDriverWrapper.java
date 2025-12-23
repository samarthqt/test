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
package com.framework.selenium;

import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

import com.epam.healenium.SelfHealingDriver;
import com.framework.components.Settings;

/**
 * Healenium Driver Wrapper - Wraps WebDriver instances with SelfHealingDriver
 * 
 * <p>Healenium is a self-healing test automation solution that automatically fixes
 * broken locators at runtime when web elements change. This wrapper integrates
 * Healenium into the QualiFrame framework.</p>
 * 
 * <h2>How Healenium Works:</h2>
 * <ul>
 *   <li>Intercepts NoSuchElement exceptions</li>
 *   <li>Uses ML algorithms to find new locators for changed elements</li>
 *   <li>Replaces broken locators with new ones at runtime</li>
 *   <li>Updates test code base via IntelliJ IDEA plugin (optional)</li>
 *   <li>Provides detailed reporting with fixed control values and screenshots</li>
 * </ul>
 * 
 * <h2>Usage Example:</h2>
 * <pre>{@code
 * // Create a regular WebDriver
 * WebDriver driver = WebDriverFactory.getWebDriver(testParameters);
 * 
 * // Wrap it with Healenium (if enabled)
 * WebDriver selfHealingDriver = HealeniumDriverWrapper.wrapDriver(driver);
 * 
 * // Use selfHealingDriver as normal - Healenium will handle broken locators automatically
 * selfHealingDriver.findElement(By.id("login-button")).click();
 * }</pre>
 * 
 * <h2>Configuration:</h2>
 * <p>Add the following to Global Settings.properties:</p>
 * <pre>
 * # Enable/Disable Healenium
 * HealeniumEnabled=true
 * 
 * # Healenium Backend URL (optional, defaults to http://localhost:8080)
 * HealeniumBackendUrl=http://localhost:8080
 * </pre>
 * 
 * @author Qualitest
 * @version 3.0.0
 * @since 2024
 */
public class HealeniumDriverWrapper {
	
	private static final Logger logger = Logger.getLogger(HealeniumDriverWrapper.class.getName());
	private static Properties properties = Settings.getInstance();
	
	// Default Healenium backend URL (Healenium uses port 7878 by default)
	private static final String DEFAULT_HEALENIUM_URL = "http://localhost:7878";
	
	/**
	 * Wraps a WebDriver instance with SelfHealingDriver if Healenium is enabled.
	 * 
	 * <p>This method checks if Healenium is enabled in the configuration. If enabled,
	 * it wraps the provided WebDriver with SelfHealingDriver. If disabled or if
	 * wrapping fails, it returns the original driver.</p>
	 * 
	 * @param driver The original WebDriver instance to wrap
	 * @return SelfHealingDriver if Healenium is enabled, otherwise the original driver
	 * 
	 * @example
	 * <pre>{@code
	 * WebDriver driver = WebDriverFactory.getWebDriver(testParameters);
	 * WebDriver selfHealingDriver = HealeniumDriverWrapper.wrapDriver(driver);
	 * // Now use selfHealingDriver - it will automatically heal broken locators
	 * }</pre>
	 */
	public static WebDriver wrapDriver(WebDriver driver) {
		if (driver == null) {
			logger.warning("Cannot wrap null driver with Healenium");
			return null;
		}
		
		// Check if Healenium is enabled
		boolean healeniumEnabled = Boolean.parseBoolean(
			properties.getProperty("HealeniumEnabled", "false")
		);
		
		if (!healeniumEnabled) {
			logger.info("Healenium is disabled. Using standard WebDriver.");
			return driver;
		}
		
		try {
			// Get Healenium backend URL from configuration
			String healeniumUrl = properties.getProperty(
				"HealeniumBackendUrl", 
				DEFAULT_HEALENIUM_URL
			);
			
			logger.info("Wrapping WebDriver with Healenium. Backend URL: " + healeniumUrl);
			
			// Set Healenium properties if not already set via healenium.properties file
			// These can also be configured in src/test/resources/healenium.properties
			System.setProperty("hlm.server.url", healeniumUrl);
			
			// Create SelfHealingDriver using the create() method
			// Healenium reads configuration from healenium.properties or system properties
			SelfHealingDriver selfHealingDriver = SelfHealingDriver.create(driver);
			
			logger.info("Successfully wrapped WebDriver with Healenium SelfHealingDriver");
			return selfHealingDriver;
			
		} catch (Exception e) {
			logger.warning("Failed to wrap driver with Healenium: " + e.getMessage() + 
				". Falling back to standard WebDriver.");
			logger.warning("Exception details: " + e.getClass().getName());
			
			// Return original driver if wrapping fails
			return driver;
		}
	}
	
	/**
	 * Checks if Healenium is enabled in the configuration.
	 * 
	 * @return true if Healenium is enabled, false otherwise
	 */
	public static boolean isHealeniumEnabled() {
		return Boolean.parseBoolean(
			properties.getProperty("HealeniumEnabled", "false")
		);
	}
	
	/**
	 * Gets the Healenium backend URL from configuration.
	 * 
	 * @return The Healenium backend URL, or default URL if not configured
	 */
	public static String getHealeniumBackendUrl() {
		// Check system property first (set by wrapDriver), then properties file
		String url = System.getProperty("hlm.server.url");
		if (url == null || url.isEmpty()) {
			url = properties.getProperty("HealeniumBackendUrl", DEFAULT_HEALENIUM_URL);
		}
		return url;
	}
	
	/**
	 * Unwraps a SelfHealingDriver to get the underlying WebDriver.
	 * 
	 * <p>This is useful when you need to access the original driver instance
	 * or when closing the driver.</p>
	 * 
	 * @param driver The driver (may be SelfHealingDriver or regular WebDriver)
	 * @return The underlying WebDriver instance
	 * 
	 * @example
	 * <pre>{@code
	 * // Unwrap to get original driver
	 * WebDriver originalDriver = HealeniumDriverWrapper.unwrapDriver(selfHealingDriver);
	 * originalDriver.quit();
	 * }</pre>
	 */
	public static WebDriver unwrapDriver(WebDriver driver) {
		if (driver instanceof SelfHealingDriver) {
			return ((SelfHealingDriver) driver).getDelegate();
		}
		return driver;
	}
	
	/**
	 * Quits the driver properly, handling both SelfHealingDriver and regular WebDriver.
	 * 
	 * <p>This method ensures proper cleanup of both Healenium and the underlying driver.</p>
	 * 
	 * @param driver The driver to quit (may be SelfHealingDriver or regular WebDriver)
	 */
	public static void quitDriver(WebDriver driver) {
		if (driver == null) {
			return;
		}
		
		try {
			if (driver instanceof SelfHealingDriver) {
				logger.info("Quitting SelfHealingDriver");
				SelfHealingDriver selfHealingDriver = (SelfHealingDriver) driver;
				selfHealingDriver.quit();
			} else {
				logger.info("Quitting standard WebDriver");
				driver.quit();
			}
		} catch (Exception e) {
			logger.warning("Error while quitting driver: " + e.getMessage());
		}
	}
}

