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

import static java.nio.charset.StandardCharsets.US_ASCII;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.framework.components.Settings;
import com.framework.report.Status;
import com.framework.reusable.GenericResuableComponents;
import com.saucelabs.saucebindings.SaucePlatform;
import com.saucelabs.saucebindings.SauceSession;
import com.saucelabs.saucebindings.options.SauceOptions;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class SauceLabWebDriverFactory {

	private static Properties properties=Settings.getInstance();
	private static ThreadLocal<SauceSession> sauceSession = new ThreadLocal<>();
	protected static RemoteWebDriver driver;

	public SauceLabWebDriverFactory() {
		// To prevent external instantiation of this class
	}

	/**
	 * Function to return the object for RemoteWebDriver {@link RemoteWebDriver}
	 * object
	 * 
	 * @param browserName
	 *            name of the browser
	 * @param browserVersion
	 *            version of the browser
	 * @param platformName
	 *             name of the platform
	 * @param testcaseName
	 *            name of the test case
	 * 
	 * @return Instance of the {@link RemoteWebDriver} object
	 */
	public static WebDriver getRemoteWebDriver(String browserName, String browserVersion, String platformName,String testcaseName) {
		System.setProperty("SAUCE_USERNAME", properties.getProperty("UserName"));
		System.setProperty("SAUCE_ACCESS_KEY", properties.getProperty("AccessKey"));
		SauceOptions sauceOptions = new SauceOptions();
		sauceOptions.setCapability("browserName", browserName.toLowerCase());
		sauceOptions.sauce().setName(testcaseName);
		if (browserVersion != null) {
			sauceOptions.setCapability("browserVersion",browserVersion);
		}
		if (platformName != null) {
			if(platformName.contains("WINDOWS"))
				sauceOptions.setPlatformName(SaucePlatform.WINDOWS_10);
		}
		//URL url;
		try {
			//url = new URL(mobileproperties.getProperty("RemoteUrl"));
			sauceSession.set(new SauceSession(sauceOptions));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = sauceSession.get().start();
		return driver;
	}
	
	/**
	 * Function to return the sharable link from Saucelabs
	 * 
	 * @param driver
	 *            Instance of the {@link RemoteWebDriver} object
	 */           
	public static String getShareableLink(RemoteWebDriver driver) throws NoSuchAlgorithmException, InvalidKeyException {
		GenericResuableComponents reusable = new GenericResuableComponents();
		String KEY = String.format("%s:%s", properties.getProperty("UserName"), properties.getProperty("AccessKey"));
		String SAUCE_TESTS_URL = "https://app.saucelabs.com/tests";
		String sauceJobId=driver.getSessionId().toString();
		SecretKeySpec sks = new SecretKeySpec(KEY.getBytes(US_ASCII), "HmacMD5");
		Mac mac = Mac.getInstance("HmacMD5");
		mac.init(sks);
		byte[] result = mac.doFinal(sauceJobId.getBytes(US_ASCII));
		StringBuilder hash = new StringBuilder();
		for (byte b : result) {	
			String hex = Integer.toHexString(0xFF & b);
			if (hex.length() == 1) {
				hash.append('0');
			}
			hash.append(hex);
		}
		String digest = hash.toString();
		System.out.println(String.format("%s/%s?auth=%s", SAUCE_TESTS_URL, sauceJobId, digest));
		reusable.addTestLog("SauceLab Execution Job Link ", String.format("%s/%s?auth=%s", SAUCE_TESTS_URL, sauceJobId, digest), Status.PASS);
		return String.format("%s/%s?auth=%s", SAUCE_TESTS_URL, sauceJobId, digest);
	}
	
	/**
	 * Function to return quit sauce session
	 * 
	 * @param testStatus
	 *            status of the test case
	 */
	
	public static void quitsession(String testStatus) throws InvalidKeyException, NoSuchAlgorithmException {
		if(testStatus.equalsIgnoreCase("Passed"))
			sauceSession.get().stop(true);
		else
			sauceSession.get().stop(false);
	}

	/**
	 * Function to download screenshots based on  sauce job details
	 * 			
	 */
	//Unused Method.Kept for future reference
	public void downloadScreenshot() {
		OkHttpClient client = new OkHttpClient().newBuilder()
				.build();
		Request request = new Request.Builder()
				.url("https://api.us-west-1.saucelabs.com/rest/v1/lamech/jobs/da5d76ddb9b44bbf90103feefb396c23/assets/screenshots.zip")
				.method("GET", null)
				.addHeader("Authorization", "Basic bGFtZWNoOmExMGNhZGI0LWJlM2ItNDE4Ny1iZTI5LTI2OTJkZGMxNjEzMg==")
				.build();
		try {
			Response response = client.newCall(request).execute();
			System.out.println(response.toString());
			InputStream is = (InputStream)response.body().byteStream();
			Files.copy(is, Paths.get("screenshots.zip"), StandardCopyOption.REPLACE_EXISTING);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Function to return the object for RemoteWebDriver {@link RemoteWebDriver}
	 * object
	 * 
	 * @param browserName
	 *            name of the browser
	 * @param browserVersion
	 *            version of the browser
	 * @param platformName
	 *             name of the platform
	 * @param testcaseName
	 *            name of the test case
	 * 
	 * @return Instance of the {@link RemoteWebDriver} object
	 */

	public static WebDriver getRemoteVisualWebDriver(String browserName, String browserVersion, String platformName,String testcaseName) {
		
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
		capabilities.setCapability(CapabilityType.BROWSER_VERSION, "latest");
		capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);

		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("username",properties.getProperty("UserName"));
		sauceOptions.setCapability("accesskey", properties.getProperty("AccessKey"));
		sauceOptions.setCapability("name",testcaseName );
		capabilities.setCapability("sauce:options", sauceOptions);

		MutableCapabilities visualOptions = new MutableCapabilities();
		visualOptions.setCapability("apiKey", properties.getProperty("SauceApiKey"));
		visualOptions.setCapability("projectName", properties.getProperty("SauceProjectName"));
		visualOptions.setCapability("viewportSize", "1280x1024");


		capabilities.setCapability("sauce:visual", visualOptions);
		// Visual requires validation when the browser version changes
		capabilities.setCapability(CapabilityType.BROWSER_VERSION, "94");

		URL url = null;
		try {
			url = new URL("https://hub.screener.io/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = new RemoteWebDriver(url, capabilities);
		return driver;
	}

	
	/**
	 * Function to intialise visual screen 
	 * 			
	 * @param testName  name of the test case
	 */
	public static void intializeTestscreener(String testName) {
		if(driver!=null)
			((JavascriptExecutor) driver).executeScript("/*@visual.init*/", testName);
	}
	
	
	/**
	 * Function to capture screenshots through screener
	 * 			
	 * @param screenName  name of the screenshot
	 */
	public static void captureSaucescreener(String screenName) {
		if(driver!=null)
			((JavascriptExecutor) driver).executeScript("/*@visual.snapshot*/", screenName);
	}
}
