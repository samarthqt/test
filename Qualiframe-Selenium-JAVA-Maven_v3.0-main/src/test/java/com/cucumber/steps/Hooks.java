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
package com.cucumber.steps;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.framework.components.ApplitoolsOperations;
import com.framework.components.Settings;
import com.framework.cucumber.DriverManager;
import com.framework.cucumber.TestHarness;
import com.framework.selenium.CustomDriver;
import com.framework.selenium.CloudPlatformWebDriverFactory;
import com.framework.selenium.SeleniumTestParameters;
import com.framework.selenium.SeleniumParametersBuilders;
import com.framework.selenium.ExecutionMode;
import com.framework.selenium.Browser;
import com.framework.components.ToolName;
import com.framework.selenium.MobileExecutionPlatform;
import com.framework.selenium.SeleniumHttpClientInitializer;
import org.openqa.selenium.Platform;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import java.util.Properties;
import java.io.IOException;
import java.lang.reflect.Method;


public class Hooks {
	// Set HTTP client factory before any Selenium classes are loaded
	// This prevents NoClassDefFoundError for NettyClient$Factory
	static {
		// Initialize HTTP client factory before any Selenium classes are loaded
		SeleniumHttpClientInitializer.initialize();
		
		// Also set it directly as a fallback
		if (System.getProperty("webdriver.http.factory") == null) {
			System.setProperty("webdriver.http.factory", "jdk-http-client");
		}
	}
	
	static CustomDriver driver ;
	static Integer i=0;
	private TestHarness testHarness;
	public ApplitoolsOperations appli = new ApplitoolsOperations();
	Properties properties = Settings.getInstance();

	/**
	 * Method to initialize driver
	 * 
	 * @param scenario
	 */
	@Before
	public void setUp(Scenario scenario) {
		System.out.println("=== @Before hook started on thread: " + Thread.currentThread().getName() + " ===");
		testHarness = new TestHarness();
		
		// Initialize test parameters first
		initializeTestParameters(scenario);
		
		// Now set the scenario
		DriverManager.getTestParameters().setScenario(scenario);
		
		System.out.println("Calling invokeDriver for scenario: " + scenario.getName() + " on thread: " + Thread.currentThread().getName());
		testHarness.invokeDriver(scenario);
		System.out.println("invokeDriver completed. Verifying driver is set on thread: " + Thread.currentThread().getName());
		
		// Verify the driver was set correctly
		AppiumDriver verifyDriver = DriverManager.getAppiumDriver();
		System.out.println("Driver retrieved from DriverManager in @Before hook: " + (verifyDriver != null ? "SUCCESS" : "NULL") + " on thread: " + Thread.currentThread().getName());
		
		// Check if execution mode is not SAUCELABS and not API before initializing Applitools
		SeleniumTestParameters testParams = DriverManager.getTestParameters();
		if(testParams != null && testParams.getExecutionMode() != null && 
		   !testParams.getExecutionMode().toString().equalsIgnoreCase("SAUCELABS") &&
		   !testParams.isAPIExecution())
		{
			appli.invokeAppliTools(scenario.getName()+scenario.getLine());
			appli.openEyes(DriverManager.getWebDriver());
		}
		System.out.println("=== @Before hook completed on thread: " + Thread.currentThread().getName() + " ===");
	}

	/**
	 * To set execution approach as cucumber in property file
	 */
	@Before
	public void setExecutionApproach() {
		properties.setProperty("ExecutionApproach", "CUCUMBER");
	}

	/**
	 * Initialize test parameters based on configuration
	 * 
	 * @param scenario
	 */
	private void initializeTestParameters(Scenario scenario) {
		String testConfigurationID = properties.getProperty("TestConfigurationID", "LOCALChrome");
		String scenarioName = scenario.getName();
		String testCaseId = scenarioName; // You can modify this based on your naming convention
		
		// Check if this is an API test based on scenario tags
		boolean isAPITest = scenario.getSourceTagNames().stream()
				.anyMatch(tag -> tag.equals("@api") || tag.contains("@api"));
		
		// Override testConfigurationID for API tests
		if (isAPITest) {
			testConfigurationID = "API";
		}
		
		// Check if this is a mobile test based on scenario tags
		boolean isMobileTest = scenario.getSourceTagNames().stream()
				.anyMatch(tag -> tag.contains("@Android") || tag.contains("@iOS") || tag.contains("@Mobile"));
		
		// Determine mobile execution platform from tags
		MobileExecutionPlatform mobilePlatform = null;
		if (isMobileTest) {
			if (scenario.getSourceTagNames().stream().anyMatch(tag -> tag.contains("@Android"))) {
				mobilePlatform = MobileExecutionPlatform.Android;
			} else if (scenario.getSourceTagNames().stream().anyMatch(tag -> tag.contains("@iOS"))) {
				mobilePlatform = MobileExecutionPlatform.iOS;
			}
		}
		
		// Create test parameters using builder pattern
		SeleniumParametersBuilders builder = new SeleniumParametersBuilders(scenarioName, testCaseId)
				.executionMode(getExecutionMode(testConfigurationID))
				.browser(getBrowser(testConfigurationID))
				.browserVersion(getBrowserVersion(testConfigurationID))
				.platform(getPlatform(testConfigurationID))
				.toolName(getToolName(testConfigurationID, isMobileTest));
		
		// Set mobile-specific parameters if it's a mobile test
		if (isMobileTest && mobilePlatform != null) {
			builder.mobileExecutionPlatform(mobilePlatform);
			// Set device name and OS version from properties if available
			Properties mobileProps = Settings.getMobilePropertiesInstance();
			// Use platform-specific device names based on the mobile platform
			String deviceName;
			String osVersion;
			if (mobilePlatform == MobileExecutionPlatform.Android) {
				deviceName = mobileProps.getProperty("AndroidDeviceName", 
					mobileProps.getProperty("DeviceName", "Samsung Galaxy S21 5G"));
				osVersion = mobileProps.getProperty("AndroidOSVersion", 
					mobileProps.getProperty("OSVersion", "12"));
			} else if (mobilePlatform == MobileExecutionPlatform.iOS) {
				deviceName = mobileProps.getProperty("IOSDeviceName", 
					mobileProps.getProperty("DeviceName", "iPhone 13 Pro Max"));
				osVersion = mobileProps.getProperty("IOSOSVersion", 
					mobileProps.getProperty("OSVersion", "15"));
			} else {
				// Default fallback
				deviceName = mobileProps.getProperty("DeviceName", "Samsung Galaxy S21 5G");
				osVersion = mobileProps.getProperty("OSVersion", "12");
			}
			builder.deviceName(deviceName);
			builder.mobileOsVersion(osVersion);
		}
		
		SeleniumTestParameters testParameters = builder.build();
		
		// Set the test parameters in DriverManager
		DriverManager.setTestParameters(testParameters);
	}

	/**
	 * Get execution mode from configuration ID
	 */
	private ExecutionMode getExecutionMode(String testConfigurationID) {
		if (testConfigurationID.toUpperCase().contains("LOCAL")) {
			return ExecutionMode.LOCAL;
		} else if (testConfigurationID.toUpperCase().contains("SAUCELABS")) {
			return ExecutionMode.SAUCELABS;
		} else if (testConfigurationID.toUpperCase().contains("LAMBDATEST")) {
			return ExecutionMode.LAMBDATEST;
		} else if (testConfigurationID.toUpperCase().contains("BROWSERSTACK")) {
			return ExecutionMode.BROWSERSTACK;
		} else if (testConfigurationID.toUpperCase().contains("AWSDEVICEFARM")) {
			return ExecutionMode.AWSDEVICEFARM;
		} else if (testConfigurationID.toUpperCase().contains("PERFECTO")) {
			return ExecutionMode.PERFECTO;
		} else if (testConfigurationID.toUpperCase().contains("WINDOWS")) {
			return ExecutionMode.WINDOWS;
		} else if (testConfigurationID.toUpperCase().contains("API")) {
			return ExecutionMode.API;
		} else if (testConfigurationID.toUpperCase().contains("MOBILE")) {
			return ExecutionMode.MOBILE;
		} else {
			return ExecutionMode.LOCAL; // Default fallback
		}
	}

	/**
	 * Get browser from configuration ID
	 */
	private Browser getBrowser(String testConfigurationID) {
		if (testConfigurationID.toUpperCase().contains("CHROME")) {
			return Browser.CHROME;
		} else if (testConfigurationID.toUpperCase().contains("FIREFOX")) {
			return Browser.FIREFOX;
		} else if (testConfigurationID.toUpperCase().contains("EDGE")) {
			return Browser.EDGE;
		} else if (testConfigurationID.toUpperCase().contains("SAFARI")) {
			return Browser.SAFARI;
		} else {
			return Browser.CHROME; // Default fallback
		}
	}

	/**
	 * Get browser version from configuration ID
	 */
	private String getBrowserVersion(String testConfigurationID) {
		// Extract version if present in configuration ID
		// For now, return latest version
		return "latest";
	}

	/**
	 * Get platform from configuration ID
	 */
	private Platform getPlatform(String testConfigurationID) {
		if (testConfigurationID.toUpperCase().contains("WINDOWS")) {
			return Platform.WINDOWS;
		} else if (testConfigurationID.toUpperCase().contains("MAC")) {
			return Platform.MAC;
		} else if (testConfigurationID.toUpperCase().contains("LINUX")) {
			return Platform.LINUX;
		} else {
			return Platform.ANY; // Default fallback
		}
	}

	/**
	 * Get tool name from configuration ID and mobile test flag
	 */
	private ToolName getToolName(String testConfigurationID, boolean isMobileTest) {
		// If it's a mobile test, use APPIUM
		if (isMobileTest) {
			return ToolName.APPIUM;
		}
		// Otherwise, check configuration ID
		if (testConfigurationID.toUpperCase().contains("APPIUM")) {
			return ToolName.APPIUM;
		} else {
			return ToolName.REMOTE_WEBDRIVER; // Default for web testing
		}
	}

	/**
	 * Method to take screenshot after each step
	 * @param scenario
	 */
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		// Skip screenshots for API tests
		if (DriverManager.getTestParameters() == null || DriverManager.getTestParameters().isAPIExecution()) {
			return;
		}

		if (!(DriverManager.getTestParameters().getExecutionMode().toString().equalsIgnoreCase("SAUCELABS"))) {
			if (Boolean.parseBoolean(properties.getProperty("TakeScreenshotPassedStep"))) {
				if (!DriverManager.getTestParameters().isMobileExecution()) {
					if (!DriverManager.getTestParameters().isWindowsExecution()) {
					try {
						WebDriver driver = DriverManager.getWebDriver();
						if (driver == null) {
							return; // Skip screenshot if driver is null
						}
						final byte[] screenshot = ((TakesScreenshot) driver)
								.getScreenshotAs(OutputType.BYTES);
						scenario.attach(screenshot, "image/png", "image");
					} catch (org.openqa.selenium.WebDriverException e) {
						System.out.println("Skipping screenshot: session not available - " + e.getMessage());
					}
				} else{
						try {
							final byte[] screenshot = ((TakesScreenshot) DriverManager.getWindowsDriver())
									.getScreenshotAs(OutputType.BYTES);
							scenario.attach(screenshot, "image/png", "image");
						} catch (org.openqa.selenium.WebDriverException e) {
							System.out.println("Skipping screenshot (Windows): session not available - " + e.getMessage());
						}
					}
				}else {
					try {
						final byte[] screenshot = ((TakesScreenshot) DriverManager.getAppiumDriver())
								.getScreenshotAs(OutputType.BYTES);
						scenario.attach(screenshot, "image/png", "image");
					} catch (org.openqa.selenium.WebDriverException e) {
						System.out.println("Skipping screenshot (Mobile): session not available - " + e.getMessage());
					}
				}
			} else {
				if (!DriverManager.getTestParameters().isMobileExecution()) {
					if (!DriverManager.getTestParameters().isWindowsExecution()) {
					if (scenario.isFailed()) {
						try {
							WebDriver driver = DriverManager.getWebDriver();
							if (driver == null) {
								return; // Skip screenshot if driver is null
							}
							final byte[] screenshot = ((TakesScreenshot) driver)
									.getScreenshotAs(OutputType.BYTES);
							scenario.attach(screenshot, "image/png", "image");
						} catch (org.openqa.selenium.WebDriverException e) {
							System.out.println("Skipping failure screenshot: session not available - " + e.getMessage());
						}
					}
				} else {

					if (scenario.isFailed()) {
						try {
							final byte[] screenshot = ((TakesScreenshot) DriverManager.getWindowsDriver())
									.getScreenshotAs(OutputType.BYTES);
							scenario.attach(screenshot, "image/png", "image");
						} catch (org.openqa.selenium.WebDriverException e) {
							System.out.println("Skipping failure screenshot (Windows): session not available - " + e.getMessage());
						}
					}
				}
				} else {
					if (scenario.isFailed()) {
						try {
							final byte[] screenshot = ((TakesScreenshot) DriverManager.getAppiumDriver())
									.getScreenshotAs(OutputType.BYTES);
							scenario.attach(screenshot, "image/png", "image");
						} catch (org.openqa.selenium.WebDriverException e) {
							System.out.println("Skipping failure screenshot (Mobile): session not available - " + e.getMessage());
						}
					}
				}
			}
		}
	}

	/**
	 * Method to capture content/visual screen using appli tools
	 */
	@AfterStep
	public void captureContent(Scenario sc) {
		// Check if AfterStepAppliTools property exists and is set to True
		String afterStepAppliTools = properties.getProperty("AfterStepAppliTools", "False");
		if("True".equalsIgnoreCase(afterStepAppliTools)) {
			appli.captureContent(sc.getName()+sc.getLine()+"screen"+i);
		}
		CloudPlatformWebDriverFactory.captureSaucescreener(sc.getLine()+"screen"+i);
		i++;
	}


	/**
	 * Method to close respective drivers
	 * @param scenario
	 * @throws IOException
	 */
	@After
	public void tearDown(Scenario scenario) throws IOException {
		appli.closeAppliTools();
		testHarness.closeRespectiveDriver(scenario);
	}

}
