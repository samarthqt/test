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

// IMPORTANT: Load SeleniumHttpClientInitializer FIRST to set system property before any Selenium classes
// This must be imported and initialized before other Selenium imports
import com.framework.selenium.SeleniumHttpClientInitializer;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.framework.components.FrameworkException;
import com.framework.components.Settings;
import com.framework.cucumber.TestNGListener;
import com.framework.report.ResultSummaryManager;
import com.framework.utils.PlatformUtils;
import com.framework.selenium.HealeniumDriverWrapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.io.File;
import java.time.Duration;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Enhanced Factory class for creating the {@link WebDriver} object with modern Selenium 4.x features
 * 
 * <h2>Usage Examples:</h2>
 * 
 * <h3>Basic WebDriver Creation:</h3>
 * <pre>{@code
 * // Create a Chrome WebDriver
 * SeleniumTestParameters params = new SeleniumTestParameters();
 * params.setBrowser(Browser.CHROME);
 * WebDriver driver = WebDriverFactory.getWebDriver(params);
 * 
 * // Create a headless Chrome WebDriver
 * params.setBrowser(Browser.CHROME_HEADLESS);
 * WebDriver headlessDriver = WebDriverFactory.getWebDriver(params);
 * }</pre>
 * 
 * <h3>Mobile Emulation:</h3>
 * <pre>{@code
 * // Emulate mobile device
 * WebDriver mobileDriver = WebDriverFactory.getEmulatedWebDriver("Galaxy S5");
 * 
 * // Custom mobile emulation
 * WebDriver customMobile = WebDriverFactory.getEmulatedWebDriver(375, 667, 2.0f, 
 *     "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X)");
 * }</pre>
 * 
 * <h3>Remote WebDriver:</h3>
 * <pre>{@code
 * // Connect to Selenium Grid
 * WebDriver remoteDriver = WebDriverFactory.getRemoteWebDriver(Browser.CHROME, 
 *     "http://localhost:4444/wd/hub");
 * 
 * // Remote with specific capabilities
 * WebDriver customRemote = WebDriverFactory.getRemoteWebDriver(Browser.FIREFOX, 
 *     "47.0", Platform.WINDOWS, "http://grid.example.com:4444/wd/hub");
 * }</pre>
 * 
 * <h3>Performance Optimization:</h3>
 * <pre>{@code
 * // Use with PerformanceOptimizer for enhanced monitoring
 * WebDriver driver = WebDriverFactory.getWebDriver(params);
 * WebDriverWait wait = PerformanceOptimizer.createOptimizedWait(driver);
 * }</pre>
 * 
 * @author Qualitest
 * @version 2.0.1
 * @since 2022
 */
public class WebDriverFactory {
	
	private static final Logger logger = Logger.getLogger(WebDriverFactory.class.getName());
	private static Properties properties;
	private static TestNGListener listener = new TestNGListener();

	private static String downloadPath;
	
	// Configure Selenium to use JDK HTTP client instead of Netty to avoid NettyClient$Factory issues
	// This MUST be executed before any Selenium classes are loaded
	static {
		// Force initialization of HTTP client factory before any Selenium classes load
		SeleniumHttpClientInitializer.initialize();
		
		// Force JDK HTTP client to be used - this prevents ServiceLoader from trying to load NettyClient$Factory
		System.setProperty("webdriver.http.factory", "jdk-http-client");
	}
	
	private WebDriverFactory() {
		// To prevent external instantiation of this class
	}
	
	/**
	 * Get the download path for file downloads
	 * 
	 * @return The configured download path
	 * 
	 * @example
	 * <pre>{@code
	 * String downloadPath = WebDriverFactory.getDownloadPath();
	 * System.out.println("Files will be downloaded to: " + downloadPath);
	 * }</pre>
	 */
	public static String getDownloadPath() {
		return downloadPath;
	}

	/**
	 * Function to return the appropriate {@link WebDriver} object based on the
	 * parameters passed with modern Selenium 4.x features
	 * 
	 * <p>This method creates WebDriver instances with optimized configurations for each browser.
	 * It includes modern features like:</p>
	 * <ul>
	 *   <li>Automation detection prevention</li>
	 *   <li>Optimized performance settings</li>
	 *   <li>Enhanced security configurations</li>
	 *   <li>Mobile emulation support</li>
	 * </ul>
	 * 
	 * @param testParameters The {@link Browser} to be used for the test execution
	 * @return The corresponding {@link WebDriver} object
	 * 
	 * @throws FrameworkException if the browser is not supported or initialization fails
	 * 
	 * @example
	 * <pre>{@code
	 * // Create Chrome WebDriver
	 * SeleniumTestParameters chromeParams = new SeleniumTestParameters();
	 * chromeParams.setBrowser(Browser.CHROME);
	 * WebDriver chromeDriver = WebDriverFactory.getWebDriver(chromeParams);
	 * 
	 * // Create Firefox WebDriver
	 * SeleniumTestParameters firefoxParams = new SeleniumTestParameters();
	 * firefoxParams.setBrowser(Browser.FIREFOX);
	 * WebDriver firefoxDriver = WebDriverFactory.getWebDriver(firefoxParams);
	 * 
	 * // Create Edge WebDriver
	 * SeleniumTestParameters edgeParams = new SeleniumTestParameters();
	 * edgeParams.setBrowser(Browser.EDGE);
	 * WebDriver edgeDriver = WebDriverFactory.getWebDriver(edgeParams);
	 * }</pre>
	 */
	public static WebDriver getWebDriver(SeleniumTestParameters testParameters) {
		WebDriver driver = null;
		properties = Settings.getInstance();
		
		try {
			// Use the new WebDriver Manager for automatic driver management
			String testConfiguration = getTestConfigurationFromBrowser(testParameters.getBrowser());
			// Temporarily use legacy method until WebDriverManager is fixed
			driver = createWebDriverLegacy(testParameters);
			
			// Set modern timeouts
			if (driver != null) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
			}
			
		} catch (Exception e) {
			// Fallback to original implementation if new WebDriver Manager fails
			logger.warning("New WebDriver Manager failed, falling back to original implementation: " + e.getMessage());
			driver = createWebDriverLegacy(testParameters);
		}

		// Wrap driver with Healenium if enabled
		if (driver != null) {
			driver = HealeniumDriverWrapper.wrapDriver(driver);
		}

		return driver;
	}
	
	/**
	 * Legacy WebDriver creation method as fallback
	 * 
	 * @param testParameters The test parameters
	 * @return WebDriver instance
	 */
	private static WebDriver createWebDriverLegacy(SeleniumTestParameters testParameters) {
		WebDriver driver = null;
		Browser browser = testParameters.getBrowser();
		
		// CRITICAL: Ensure HTTP client factory is set before any WebDriver instantiation
		// This prevents ServiceLoader from trying to load NettyClient$Factory
		SeleniumHttpClientInitializer.initialize();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("selenium.http.factory", "jdk-http-client");
		
		switch (browser) {
		case CHROME:
			// CRITICAL: Ensure HTTP client factory is set right before WebDriver instantiation
			SeleniumHttpClientInitializer.initialize();
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			System.setProperty("selenium.http.factory", "jdk-http-client");
			
			WebDriverManager.chromedriver().clearDriverCache().setup();
			ChromeOptions chrome = createModernChromeOptions();
			
			// Wrap ChromeDriver instantiation to catch and handle NoClassDefFoundError
			try {
				driver = new ChromeDriver(chrome);
			} catch (NoClassDefFoundError | ExceptionInInitializerError e) {
				if (e.getMessage() != null && e.getMessage().contains("NettyClient$Factory")) {
					// Netty client factory error - retry with explicit JDK HTTP client
					logger.warning("Caught NettyClient$Factory error, retrying with JDK HTTP client: " + e.getMessage());
					System.setProperty("webdriver.http.factory", "jdk-http-client");
					System.setProperty("selenium.http.factory", "jdk-http-client");
					// Force reload of HTTP client factory
					try {
						Thread.sleep(100); // Brief pause to allow system property to propagate
					} catch (InterruptedException ie) {
						Thread.currentThread().interrupt();
					}
					driver = new ChromeDriver(chrome);
				} else {
					throw e; // Re-throw if it's a different error
				}
			}
			disablePasswordLeakDetection((ChromeDriver) driver);
			break;

        case CHROME_MOBILE_EMULATION:
            driver = createMobileEmulatedChromeDriver("Galaxy S5");
            break;
            
		case CHROME_HEADLESS:
			driver = createHeadlessChromeDriver();
			if (driver instanceof ChromeDriver) {
				disablePasswordLeakDetection((ChromeDriver) driver);
			}
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = createModernFirefoxOptions();
			driver = new FirefoxDriver(firefoxOptions);
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOptions = createModernEdgeOptions();
			driver = new EdgeDriver(edgeOptions);
			break;

		case SAFARI:
			SafariOptions safariOptions = new SafariOptions();
			driver = new SafariDriver(safariOptions);
			break;

		case GHOST_DRIVER:
			System.setProperty("phantomjs.binary.path", properties.getProperty("PhantomJSPath"));
			driver = new PhantomJSDriver();
			break;

		case INTERNET_EXPLORER:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			throw new FrameworkException("Unhandled browser: " + browser);
		}

		return driver;
	}
	
	/**
	 * Convert browser enum to test configuration string
	 * 
	 * @param browser The browser enum
	 * @return Test configuration string
	 */
	private static String getTestConfigurationFromBrowser(Browser browser) {
		switch (browser) {
		case CHROME:
			return "LOCALChrome";
		case CHROME_HEADLESS:
			return "LOCALChrome_HEADLESS";
		case FIREFOX:
			return "LOCALFirefox";
		case EDGE:
			return "LOCALEdge";
		case SAFARI:
			return "LOCALSafari";
		case CHROME_MOBILE_EMULATION:
			return "LOCALChromeEmulation";
		default:
			return "LOCALChrome";
		}
	}

	/**
	 * Creates modern Chrome options with enhanced capabilities
	 * 
	 * <p>This method configures Chrome with modern settings including:</p>
	 * <ul>
	 *   <li>Automation detection prevention</li>
	 *   <li>Performance optimizations</li>
	 *   <li>Security enhancements</li>
	 *   <li>Download preferences</li>
	 *   <li>Cross-platform compatibility</li>
	 * </ul>
	 * 
	 * @return Configured ChromeOptions with modern settings
	 * 
	 * @example
	 * <pre>{@code
	 * ChromeOptions options = WebDriverFactory.createModernChromeOptions();
	 * WebDriver driver = new ChromeDriver(options);
	 * }</pre>
	 */
	private static ChromeOptions createModernChromeOptions() {
		ChromeOptions chrome = new ChromeOptions();
		
		// Cross-platform Chrome arguments
		chrome.addArguments(
			"--ignore-certificate-errors",
			"--test-type",
			"--disable-extensions",
			"--disable-infobars",
			"--disable-save-password-bubble",
			"--disable-gpu",
			"--enable-geolocation",
			"--start-maximized",
			"--disable-notifications",
			"--disable-component-update",
			"--remote-allow-origins=*",
			"--no-sandbox",
			"--disable-dev-shm-usage",
			"--safebrowsing-disable-download-protection",
			"--safebrowsing-disable-extension-blacklist",
			"--disable-blink-features=AutomationControlled", // Hide automation
			"--disable-password-manager-reauthentication", // Disable password manager reauthentication
			"--disable-features=PasswordLeakDetection", // Disable password leak detection feature
			"--disable-features=PasswordManagerOnboarding" // Disable password manager onboarding
		);
		
		// Add platform-specific arguments
		if (PlatformUtils.isLinux()) {
			chrome.addArguments("--disable-dev-shm-usage", "--no-sandbox");
		} else if (PlatformUtils.isMac()) {
			chrome.addArguments("--disable-gpu-sandbox");
		} else if (PlatformUtils.isWindows()) {
			chrome.addArguments("--disable-gpu");
		}
		
		// Always set preferences (including password manager settings)
		Map<String, Object> prefs = new HashMap<>();
		
		// Password Manager and Breach Detection Settings
		// Disable Google Password Manager to prevent password breach popup
		prefs.put("credentials_enable_service", false);
		prefs.put("credentials_enable_autosignin", false);
		prefs.put("password_manager_enabled", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.default_content_setting_values.notifications", 2); // Block notifications
		
		// Additional password leak detection settings
		prefs.put("password_manager_leak_detection", false);
		prefs.put("profile.password_manager_leak_detection", false);
		prefs.put("safe_browsing.enabled", false);
		prefs.put("safe_browsing_for_trusted_sources_enabled", false);
		
		// Download preferences (if path is specified)
		if (downloadPath != null) {
			prefs.put("download.default_directory", downloadPath);
			prefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
			prefs.put("download.prompt_for_download", false);
		}
		
		// Safe browsing and plugin settings
		prefs.put("safebrowsing.enabled", false);
		prefs.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });
		prefs.put("plugins.always_open_pdf_externally", true);
		
		chrome.setExperimentalOption("prefs", prefs);

		// Modern capabilities
		chrome.setCapability("acceptInsecureCerts", true);
		chrome.setCapability("unhandledPromptBehavior", "accept");
		
		return chrome;
	}

	/**
	 * Creates headless Chrome driver with modern options
	 * 
	 * <p>Headless mode is useful for:</p>
	 * <ul>
	 *   <li>CI/CD pipelines</li>
	 *   <li>Server environments</li>
	 *   <li>Performance testing</li>
	 *   <li>Automated testing without UI</li>
	 * </ul>
	 * 
	 * @return Configured headless Chrome WebDriver
	 * 
	 * @example
	 * <pre>{@code
	 * WebDriver headlessDriver = WebDriverFactory.createHeadlessChromeDriver();
	 * // Use for automated testing without visible browser
	 * }</pre>
	 */
	private static WebDriver createHeadlessChromeDriver() {
		// CRITICAL: Ensure HTTP client factory is set before WebDriver instantiation
		SeleniumHttpClientInitializer.initialize();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("selenium.http.factory", "jdk-http-client");
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		
		// Add arguments to disable password leak detection
		chromeOptions.addArguments(
			"--disable-password-manager-reauthentication",
			"--disable-features=PasswordLeakDetection",
			"--disable-features=PasswordManagerOnboarding"
		);
		
		Map<String, Object> prefsHeadless = new HashMap<>();
		
		// Password Manager and Breach Detection Settings
		// Disable Google Password Manager to prevent password breach popup
		prefsHeadless.put("credentials_enable_service", false);
		prefsHeadless.put("credentials_enable_autosignin", false);
		prefsHeadless.put("password_manager_enabled", false);
		prefsHeadless.put("profile.password_manager_enabled", false);
		prefsHeadless.put("profile.default_content_setting_values.notifications", 2); // Block notifications
		
		// Download preferences (if path is specified)
		if (downloadPath != null) {
			prefsHeadless.put("download.default_directory", downloadPath + File.separator);
			prefsHeadless.put("profile.default_content_setting_values.automatic_downloads", 1);
		}
		
		// Safe browsing and plugin settings
		prefsHeadless.put("safebrowsing.enabled", false); 
		prefsHeadless.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });
		prefsHeadless.put("plugins.always_open_pdf_externally", true);
		
		chromeOptions.setExperimentalOption("prefs", prefsHeadless);
		
		chromeOptions.addArguments(
			"--headless=new", // Modern headless mode
			"--window-size=1920,1080",
			"--disable-blink-features=AutomationControlled"
		);
		
		// CRITICAL: Ensure HTTP client factory is set right before WebDriver instantiation
		SeleniumHttpClientInitializer.initialize();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("selenium.http.factory", "jdk-http-client");
		
		// Wrap ChromeDriver instantiation to catch and handle NoClassDefFoundError
		try {
			return new ChromeDriver(chromeOptions);
		} catch (NoClassDefFoundError | ExceptionInInitializerError e) {
			if (e.getMessage() != null && e.getMessage().contains("NettyClient$Factory")) {
				logger.warning("Caught NettyClient$Factory error in createHeadlessChromeDriver, retrying: " + e.getMessage());
				System.setProperty("webdriver.http.factory", "jdk-http-client");
				System.setProperty("selenium.http.factory", "jdk-http-client");
				try {
					Thread.sleep(100);
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
				}
				return new ChromeDriver(chromeOptions);
			} else {
				throw e;
			}
		}
	}

	/**
	 * Creates mobile emulated Chrome driver
	 * 
	 * <p>Mobile emulation allows testing responsive designs and mobile-specific features
	 * without requiring actual mobile devices.</p>
	 * 
	 * @param deviceName The name of the device to emulate (e.g., "Galaxy S5", "iPhone 6")
	 * @return Configured mobile emulated Chrome WebDriver
	 * 
	 * @example
	 * <pre>{@code
	 * // Emulate iPhone
	 * WebDriver mobileDriver = WebDriverFactory.createMobileEmulatedChromeDriver("iPhone 6");
	 * 
	 * // Emulate Android device
	 * WebDriver androidDriver = WebDriverFactory.createMobileEmulatedChromeDriver("Galaxy S5");
	 * }</pre>
	 */
	private static WebDriver createMobileEmulatedChromeDriver(String deviceName) {
		// CRITICAL: Ensure HTTP client factory is set before WebDriver instantiation
		SeleniumHttpClientInitializer.initialize();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("selenium.http.factory", "jdk-http-client");
		
		WebDriverManager.chromedriver().setup();
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", deviceName);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("mobileEmulation", mobileEmulation);
		
		// CRITICAL: Ensure HTTP client factory is set right before WebDriver instantiation
		SeleniumHttpClientInitializer.initialize();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("selenium.http.factory", "jdk-http-client");
		
		// Wrap ChromeDriver instantiation to catch and handle NoClassDefFoundError
		try {
			return new ChromeDriver(options);
		} catch (NoClassDefFoundError | ExceptionInInitializerError e) {
			if (e.getMessage() != null && e.getMessage().contains("NettyClient$Factory")) {
				logger.warning("Caught NettyClient$Factory error in createMobileEmulatedChromeDriver, retrying: " + e.getMessage());
				System.setProperty("webdriver.http.factory", "jdk-http-client");
				System.setProperty("selenium.http.factory", "jdk-http-client");
				try {
					Thread.sleep(100);
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
				}
				return new ChromeDriver(options);
			} else {
				throw e;
			}
		}
	}

	/**
	 * Creates modern Firefox options
	 * 
	 * <p>Firefox options are configured for optimal performance and security.</p>
	 * 
	 * @return Configured FirefoxOptions with modern settings
	 * 
	 * @example
	 * <pre>{@code
	 * FirefoxOptions options = WebDriverFactory.createModernFirefoxOptions();
	 * WebDriver driver = new FirefoxDriver(options);
	 * }</pre>
	 */
	private static FirefoxOptions createModernFirefoxOptions() {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addArguments("--start-maximized");
		firefoxOptions.addPreference("dom.webnotifications.enabled", false);
		firefoxOptions.addPreference("geo.enabled", false);
		return firefoxOptions;
	}

	/**
	 * Creates modern Edge options
	 * 
	 * <p>Edge options are configured for optimal performance and security.</p>
	 * 
	 * @return Configured EdgeOptions with modern settings
	 * 
	 * @example
	 * <pre>{@code
	 * EdgeOptions options = WebDriverFactory.createModernEdgeOptions();
	 * WebDriver driver = new EdgeDriver(options);
	 * }</pre>
	 */
	private static EdgeOptions createModernEdgeOptions() {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--start-maximized");
		edgeOptions.addArguments("--disable-notifications");
		edgeOptions.addArguments("--disable-blink-features=AutomationControlled");
		return edgeOptions;
	}

	/**
	 * Function to return the Desired Capabilities {@link DesiredCapabilities} 
	 * 
	 * <p>This method creates proxy capabilities for environments requiring proxy configuration.</p>
	 * 
	 * @return DesiredCapabilities with proxy configuration
	 * 
	 * @example
	 * <pre>{@code
	 * DesiredCapabilities capabilities = WebDriverFactory.getProxyCapabilities();
	 * WebDriver driver = new RemoteWebDriver(new URL("http://grid:4444/wd/hub"), capabilities);
	 * }</pre>
	 */
	private static DesiredCapabilities getProxyCapabilities() {
		properties = Settings.getInstance();
		String proxyUrl = properties.getProperty("ProxyHost") + ":" + properties.getProperty("ProxyPort");

		Proxy proxy = new Proxy();
		proxy.setProxyType(ProxyType.MANUAL);
		proxy.setHttpProxy(proxyUrl);
		proxy.setFtpProxy(proxyUrl);
		proxy.setSslProxy(proxyUrl);

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(CapabilityType.PROXY, proxy);

		return desiredCapabilities;
	}

	/**
	 * Function to return the {@link RemoteWebDriver} object based on the parameters
	 * passed with modern Selenium 4.x capabilities
	 * 
	 * <p>Remote WebDriver is used for distributed testing across multiple machines
	 * or cloud-based testing platforms.</p>
	 * 
	 * @param browser The browser to use
	 * @param browserVersion The browser version (optional)
	 * @param platform The platform to run on (optional)
	 * @param remoteUrl The URL of the remote WebDriver server
	 * @return Configured RemoteWebDriver instance
	 * 
	 * @throws FrameworkException if the remote URL is malformed
	 * 
	 * @example
	 * <pre>{@code
	 * // Connect to Selenium Grid
	 * WebDriver remoteDriver = WebDriverFactory.getRemoteWebDriver(
	 *     Browser.CHROME, "latest", Platform.WINDOWS, "http://grid:4444/wd/hub");
	 * 
	 * // Connect to cloud provider
	 * WebDriver cloudDriver = WebDriverFactory.getRemoteWebDriver(
	 *     Browser.FIREFOX, "47.0", Platform.LINUX, "https://cloud.example.com/wd/hub");
	 * }</pre>
	 */
	public static WebDriver getRemoteWebDriver(Browser browser, String browserVersion, Platform platform,
			String remoteUrl) {
		properties = Settings.getInstance();

		boolean proxyRequired = Boolean.parseBoolean(properties.getProperty("ProxyRequired"));

		DesiredCapabilities desiredCapabilities = null;
		if (proxyRequired) {
			desiredCapabilities = getProxyCapabilities();
		} else {
			desiredCapabilities = new DesiredCapabilities();
		}

		desiredCapabilities.setBrowserName(browser.getValue());

		if (browserVersion != null) {
			desiredCapabilities.setVersion(browserVersion);
		}
		if (platform != null) {
			desiredCapabilities.setPlatform(platform);
		}

		if(browser.getValue().equalsIgnoreCase("chrome")) {
			desiredCapabilities.merge(setSelenoidGridOptions());
		}

		URL url = getUrl(remoteUrl);

		WebDriver driver = new RemoteWebDriver(url, desiredCapabilities);
		
		// Wrap driver with Healenium if enabled
		return HealeniumDriverWrapper.wrapDriver(driver);
	}

	/**
	 * Function to return the selenoidGridOptions with modern capabilities
	 * 
	 * <p>Selenoid is a lightweight Selenium Grid implementation that provides
	 * additional capabilities for video recording, VNC access, and more.</p>
	 * 
	 * @return ChromeOptions configured for Selenoid Grid
	 * 
	 * @example
	 * <pre>{@code
	 * ChromeOptions selenoidOptions = WebDriverFactory.setSelenoidGridOptions();
	 * // Use with Selenoid Grid for enhanced capabilities
	 * }</pre>
	 */
	public static ChromeOptions setSelenoidGridOptions(){
		ChromeOptions selenoidGrid = new ChromeOptions();
		Map<String, Object> selenoidOptions = new HashMap<>();
		selenoidOptions.put("enableVNC", true);
		selenoidOptions.put("enableVideo", true);
		selenoidOptions.put("screenResolution", "1920x1080x24");
		selenoidOptions.put("sessionTimeout", "15m");
		selenoidGrid.setCapability("selenoid:options", selenoidOptions);
		return selenoidGrid;
	}

	/**
	 * Function to return the URL {@link URL} 
	 * 
	 * @param remoteUrl The remote URL string
	 * @return URL object for the remote WebDriver server
	 * @throws FrameworkException if the URL is malformed
	 */
	private static URL getUrl(String remoteUrl) {
		URL url;
		try {
			url = new URL(remoteUrl);
		} catch (MalformedURLException e) {
			throw new FrameworkException("The specified remote URL is malformed");
		}
		return url;
	}

	/**
	 * Function to return the {@link RemoteWebDriver} object based on the parameters
	 * passed
	 * 
	 * @param browser The browser to use
	 * @param remoteUrl The URL of the remote WebDriver server
	 * @return Configured RemoteWebDriver instance
	 */
	public static WebDriver getRemoteWebDriver(Browser browser, String remoteUrl) {
		WebDriver driver = getRemoteWebDriver(browser, null, null, remoteUrl);
		// Driver is already wrapped in getRemoteWebDriver method above
		return driver;
	}

	/**
	 * Function to return the {@link ChromeDriver} object emulating the device
	 * specified by the user with modern capabilities
	 * 
	 * @param deviceName The name of the device to emulate
	 * @return Configured mobile emulated Chrome WebDriver
	 * 
	 * @example
	 * <pre>{@code
	 * // Emulate iPhone
	 * WebDriver iphoneDriver = WebDriverFactory.getEmulatedWebDriver("iPhone 6");
	 * 
	 * // Emulate Android device
	 * WebDriver androidDriver = WebDriverFactory.getEmulatedWebDriver("Galaxy S5");
	 * }</pre>
	 */
	@SuppressWarnings("deprecation")
	public static WebDriver getEmulatedWebDriver(String deviceName) {
		// CRITICAL: Ensure HTTP client factory is set before WebDriver instantiation
		SeleniumHttpClientInitializer.initialize();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("selenium.http.factory", "jdk-http-client");
		
		ChromeOptions options = getEmulatedChromeDriverCapabilities(deviceName);
		try {
			return new ChromeDriver(options);
		} catch (NoClassDefFoundError | ExceptionInInitializerError e) {
			if (e.getMessage() != null && e.getMessage().contains("NettyClient$Factory")) {
				logger.warning("Caught NettyClient$Factory error in getEmulatedWebDriver(String), retrying: " + e.getMessage());
				System.setProperty("webdriver.http.factory", "jdk-http-client");
				System.setProperty("selenium.http.factory", "jdk-http-client");
				try {
					Thread.sleep(100);
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
				}
				return new ChromeDriver(options);
			} else {
				throw e;
			}
		}
	}

	/**
	 * Function to return the {@link ChromeDriver} object emulating the device
	 * specified by the user
	 * 
	 * @param deviceName The name of the device to emulate
	 * @return ChromeOptions configured for mobile emulation
	 */
	private static ChromeOptions getEmulatedChromeDriverCapabilities(String deviceName) {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", deviceName);

		ChromeOptions options = new ChromeOptions();
		options.setCapability("mobileEmulation", mobileEmulation);
		options.addArguments("--disable-blink-features=AutomationControlled");
		return options;
	}

	/**
	 * Function to return the {@link RemoteWebDriver} object emulating the device
	 * specified by the user
	 * 
	 * @param deviceName The name of the device to emulate
	 * @param remoteUrl The URL of the remote WebDriver server
	 * @return Configured mobile emulated RemoteWebDriver
	 */
	public static WebDriver getEmulatedRemoteWebDriver(String deviceName, String remoteUrl) {
		ChromeOptions options = getEmulatedChromeDriverCapabilities(deviceName);
		options.addArguments("--enable-javascript");
		URL url = getUrl(remoteUrl);
		return new RemoteWebDriver(url, options);
	}

	/**
	 * Function to return the {@link ChromeDriver} object emulating the device
	 * attributes specified by the user
	 * 
	 * @param deviceWidth The width of the device to emulate (in pixels)
	 * @param deviceHeight The height of the device to emulate (in pixels)
	 * @param devicePixelRatio The device's pixel ratio
	 * @param userAgent The user agent string
	 * @return Configured mobile emulated Chrome WebDriver
	 * 
	 * @example
	 * <pre>{@code
	 * // Custom mobile emulation
	 * WebDriver customMobile = WebDriverFactory.getEmulatedWebDriver(375, 667, 2.0f, 
	 *     "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X)");
	 * }</pre>
	 */
	@SuppressWarnings("deprecation")
	public static WebDriver getEmulatedWebDriver(int deviceWidth, int deviceHeight, float devicePixelRatio,
			String userAgent) {
		// CRITICAL: Ensure HTTP client factory is set before WebDriver instantiation
		SeleniumHttpClientInitializer.initialize();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("selenium.http.factory", "jdk-http-client");
		
		ChromeOptions options = getEmulatedChromeDriverCapabilities(deviceWidth, deviceHeight,
				devicePixelRatio, userAgent);
		try {
			return new ChromeDriver(options);
		} catch (NoClassDefFoundError | ExceptionInInitializerError e) {
			if (e.getMessage() != null && e.getMessage().contains("NettyClient$Factory")) {
				logger.warning("Caught NettyClient$Factory error in getEmulatedWebDriver(int, int, float, String), retrying: " + e.getMessage());
				System.setProperty("webdriver.http.factory", "jdk-http-client");
				System.setProperty("selenium.http.factory", "jdk-http-client");
				try {
					Thread.sleep(100);
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
				}
				return new ChromeDriver(options);
			} else {
				throw e;
			}
		}
	}

	/**
	 * Function to return the {@link ChromeDriver} object emulating the device
	 * attributes specified by the user
	 * 
	 * @param deviceWidth The width of the device to emulate (in pixels)
	 * @param deviceHeight The height of the device to emulate (in pixels)
	 * @param devicePixelRatio The device's pixel ratio
	 * @param userAgent The user agent string
	 * @return ChromeOptions configured for custom mobile emulation
	 */
	private static ChromeOptions getEmulatedChromeDriverCapabilities(int deviceWidth, int deviceHeight,
			float devicePixelRatio, String userAgent) {
		Map<String, Object> deviceMetrics = new HashMap<String, Object>();
		deviceMetrics.put("width", deviceWidth);
		deviceMetrics.put("height", deviceHeight);
		deviceMetrics.put("pixelRatio", devicePixelRatio);

		Map<String, Object> mobileEmulation = new HashMap<String, Object>();
		mobileEmulation.put("deviceMetrics", deviceMetrics);
		mobileEmulation.put("userAgent", userAgent);
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability("mobileEmulation", mobileEmulation);
		options.addArguments("--disable-blink-features=AutomationControlled");
		return options;
	}

	/**
	 * Function to return the {@link RemoteWebDriver} object emulating the device
	 * attributes specified by the user
	 * 
	 * @param deviceWidth The width of the device to emulate (in pixels)
	 * @param deviceHeight The height of the device to emulate (in pixels)
	 * @param devicePixelRatio The device's pixel ratio
	 * @param userAgent The user agent string
	 * @param remoteUrl The URL of the remote WebDriver server
	 * @return Configured mobile emulated RemoteWebDriver
	 */
	public static WebDriver getEmulatedRemoteWebDriver(int deviceWidth, int deviceHeight, float devicePixelRatio,
			String userAgent, String remoteUrl) {
		ChromeOptions options = getEmulatedChromeDriverCapabilities(deviceWidth, deviceHeight,
				devicePixelRatio, userAgent);
		options.addArguments("--enable-javascript");
		URL url = getUrl(remoteUrl);
		return new RemoteWebDriver(url, options);
	}

	/**
	 * Disables password leak detection using Chrome DevTools Protocol (CDP)
	 * and handles password breach popup if it appears
	 * 
	 * @param driver The ChromeDriver instance
	 */
	private static void disablePasswordLeakDetection(ChromeDriver driver) {
		// Password leak detection is disabled via Chrome preferences and arguments
		// set in createModernChromeOptions(). No additional CDP commands needed.
		// The Chrome preferences (credentials_enable_service, password_manager_enabled, etc.)
		// and Chrome arguments (--disable-features=PasswordLeakDetection) should prevent
		// the password breach popup from appearing.
		// If the popup still appears, it will be handled by handlePasswordBreachPopup().
	}
	
	/**
	 * Handles and dismisses password breach popup if it appears
	 * This method should be called after entering passwords in forms
	 * 
	 * @param driver The WebDriver instance
	 */
	public static void handlePasswordBreachPopup(WebDriver driver) {
		try {
			// Wait a short time for popup to appear
			Thread.sleep(500);
			
			// Try to find and dismiss the popup using various strategies
			// Strategy 1: Look for common popup elements
			try {
				// Check for Google Password Manager popup
				driver.switchTo().activeElement();
				// Try to press Escape key to dismiss popup
				org.openqa.selenium.Keys escape = org.openqa.selenium.Keys.ESCAPE;
				driver.switchTo().activeElement().sendKeys(escape);
			} catch (Exception e1) {
				// Popup might not be present or not dismissible this way
			}
			
			// Strategy 2: Use JavaScript to close any modals or popups
			try {
				if (driver instanceof JavascriptExecutor) {
					((JavascriptExecutor) driver).executeScript(
						"var popups = document.querySelectorAll('[role=\"dialog\"], .modal, [class*=\"popup\"], [class*=\"overlay\"]');" +
						"popups.forEach(function(popup) {" +
						"  var text = popup.textContent || popup.innerText;" +
						"  if (text && (text.includes('password') || text.includes('breach') || text.includes('change'))) {" +
						"    var closeBtn = popup.querySelector('button[aria-label*=\"Close\"], button[aria-label*=\"Dismiss\"], .close, [class*=\"close\"]');" +
						"    if (closeBtn) closeBtn.click();" +
						"    else popup.style.display = 'none';" +
						"  }" +
						"});"
					);
				}
			} catch (Exception e2) {
				// JavaScript execution might fail
			}
			
			// Strategy 3: Press Escape key globally
			try {
				org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
				actions.sendKeys(org.openqa.selenium.Keys.ESCAPE).perform();
			} catch (Exception e3) {
				// Actions might fail
			}
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} catch (Exception e) {
			// If all strategies fail, log but don't throw
			logger.warning("Could not handle password breach popup: " + e.getMessage());
		}
	}
}