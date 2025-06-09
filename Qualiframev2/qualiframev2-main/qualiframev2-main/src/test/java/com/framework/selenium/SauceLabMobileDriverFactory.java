package com.framework.selenium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.framework.components.FrameworkException;
import com.framework.components.Settings;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SauceLabMobileDriverFactory {

	private static Properties mobileProperties;

	private static Properties properties = Settings.getInstance();

	private SauceLabMobileDriverFactory() {
		// To prevent external instantiation of this class
	}

	/**
	 * Function to return the Saucelabs DesktopCloud {@link RemoteWebDriver} object
	 * based on the parameters passed
	 * 
	 * @param sauceUrl       The Saucelabs URL to be used for the test execution
	 * @param browser        Browser {@link Browser}
	 * @param browserVersion The browser version to be used for the test execution
	 * @param platformName   The platform to be used for the test execution
	 *                       (Windows, Mac, etc.)
	 * @return The corresponding {@link RemoteWebDriver} object
	 */
	public static WebDriver getSauceRemoteWebDriver(String sauceURL, Browser browser, String browserVersion,
			Platform platformName, SeleniumTestParameters testParameters) {
		WebDriver driver = null;
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platform", platformName);
		desiredCapabilities.setCapability("version", browserVersion);
		desiredCapabilities.setCapability("browserName", browser);
		desiredCapabilities.setCapability("name", testParameters.getCurrentTestcase());

		try {
			driver = new RemoteWebDriver(new URL(sauceURL), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new FrameworkException(
					"The RemoteWebDriver driver invokation has problem, please re-check the capabilities and check the SauceLabs details URL, Username and accessKey ");
		}
		return driver;
	}

	/**
	 * Function to return the object for AppiumDriver {@link AppiumDriver} object
	 * 
	 * @param executionPlatform executionPlatform{@link MobileExecutionPlatform}
	 * @param deviceName        The deviceName
	 * @param sauceURL          Sauce URL
	 * @param testParameters    Test Parameters {@link SeleniumTestParameters}
	 * 
	 * @return Instance of the {@link AppiumDriver} object
	 */
	@SuppressWarnings("rawtypes")
	public static AppiumDriver getSauceAppiumDriver(MobileExecutionPlatform executionPlatform, String deviceName,
			String sauceURL, SeleniumTestParameters testParameters) {

		AppiumDriver driver = null;

		mobileProperties = Settings.getMobilePropertiesInstance();

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();



		try {
			switch (executionPlatform) {

			case ANDROID:
				if (Boolean.parseBoolean(mobileProperties.getProperty("UploadMobileAppInSauceLab"))) {
					uploadAPPUsingAPI(executionPlatform);
				}
				desiredCapabilities.setCapability("appiumVersion",
						mobileProperties.getProperty("SaucelabAppiumDriverVersion"));
				desiredCapabilities.setCapability("platformName", "Android");
				desiredCapabilities.setCapability("platformVersion", testParameters.getMobileOSVersion());
				desiredCapabilities.setCapability("deviceName", "Android GoogleAPI Emulator");
				desiredCapabilities.setCapability("app", "storage:filename="+mobileProperties.get("SauceAndroidIdentifier"));
				if (!(testParameters.getCurrentTestcase() == ""))
					desiredCapabilities.setCapability("name", testParameters.getCurrentTestcase());
				else
					desiredCapabilities.setCapability("name", testParameters.getScenario().getName());
				try {
					driver = new AndroidDriver(new URL(sauceURL), desiredCapabilities);
				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The android driver invokation has problem, please re-check the capabilities and check the SauceLabs details URL, Username and accessKey ");
				}
				break;

			case IOS:
				if (Boolean.parseBoolean(mobileProperties.getProperty("UploadMobileAppInSauceLab"))) {
					uploadAPPUsingAPI(executionPlatform);
				}
				desiredCapabilities.setCapability("app", "storage:filename="+mobileProperties.get("appNameSauceLabs"));
				desiredCapabilities.setCapability("deviceName", mobileProperties.getProperty("deviceNameSauceLabs"));
				desiredCapabilities.setCapability("platformName", "iOS");
				desiredCapabilities.setCapability("automationName", mobileProperties.getProperty("automationname"));
				if (!(testParameters.getCurrentTestcase() == ""))
					desiredCapabilities.setCapability("name", testParameters.getCurrentTestcase());
				else
					desiredCapabilities.setCapability("name", testParameters.getScenario().getName());
				desiredCapabilities.setCapability("noReset", mobileProperties.getProperty("ios_appreset"));
				desiredCapabilities.setCapability("cacheId", "1234");

				try {
					driver = new IOSDriver(new URL(sauceURL), desiredCapabilities);
				} catch (Exception e) {
					System.out.println("*** Problem to create the iOS driver " + e.getMessage());
					throw new RuntimeException(e);
				}
				System.out.println("Test App launched in Saucelabs Real device");
				break;

			case WEB_ANDROID:
				desiredCapabilities.setCapability("appiumVersion",
						mobileProperties.getProperty("SaucelabAppiumDriverVersion"));
				desiredCapabilities.setCapability("deviceName", testParameters.getDeviceName());
				desiredCapabilities.setCapability("browserName", testParameters.getBrowser());
				desiredCapabilities.setCapability("platformVersion", testParameters.getMobileOSVersion());
				desiredCapabilities.setCapability("platformName", "Android");
				desiredCapabilities.setCapability("automationName", "UiAutomator2");
				if (!(testParameters.getCurrentTestcase() == ""))
					desiredCapabilities.setCapability("name", testParameters.getCurrentTestcase());
				else
					desiredCapabilities.setCapability("name", testParameters.getScenario().getName());

				try {
					driver = new AndroidDriver(new URL(sauceURL), desiredCapabilities);
				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The android driver/browser invokation has problem, please re-check the capabilities and check the SauceLabs details URL, Username and accessKey ");
				}
				break;

			case WEB_IOS:
				desiredCapabilities.setCapability("appiumVersion",
						mobileProperties.getProperty("SaucelabAppiumDriverVersion"));
				desiredCapabilities.setCapability("platformName", "ios");
				desiredCapabilities.setCapability("deviceName", testParameters.getDeviceName());
				if (!(testParameters.getCurrentTestcase() == ""))
					desiredCapabilities.setCapability("name", testParameters.getCurrentTestcase());
				else
					desiredCapabilities.setCapability("name", testParameters.getScenario().getName());
				desiredCapabilities.setCapability("browserName", testParameters.getBrowser());
				desiredCapabilities.setCapability("platformVersion", testParameters.getMobileOSVersion());

				try {
					driver = new IOSDriver(new URL(sauceURL), desiredCapabilities);

				} catch (MalformedURLException e) {
					throw new FrameworkException(
							"The IOS driver invokation/browser has problem, please re-check the capabilities and check the SauceLabs details URL, Username and accessKey ");
				}
				break;

			default:
				throw new FrameworkException("Unhandled ExecutionMode!");

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new FrameworkException(
					"The Sauce appium driver invocation created a problem , please check the capabilities");
		}
		return driver;

	}

	/**
	 * Function to upload app in Sauce Mobile using API
	 * 
	 * @param executionPlatform executionPlatform{@link MobileExecutionPlatform}
	 */

	public static void uploadAPPUsingAPI(MobileExecutionPlatform executionPlatform) {
		File theFile = new File(mobileProperties.getProperty("SauceLabsMobileUploadPath"));
		String parentPathFile = theFile.getParent();
		String destinationPathFile = theFile.getName();
		System.out.println("Have the Parent path file-->"+parentPathFile);
		System.out.println("Have the Destination path file-->"+destinationPathFile);
		String encodedString = Base64.getEncoder().encodeToString((properties.get("UserName").toString() + ":" 
				+ properties.getProperty("AccessKey").toString()).getBytes());
		OkHttpClient client = new OkHttpClient().newBuilder()
				.build();
		RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
				.addFormDataPart("payload",parentPathFile)
				.addFormDataPart("name",destinationPathFile)
				.build();
		Request request = new Request.Builder()
				.url("https://api.us-west-1.saucelabs.com/v1/storage/upload")
				.method("POST", body)
				.addHeader("Authorization", "Basic "+ encodedString)
				.build();
		try {
			Response response = client.newCall(request).execute();
			String jsonData = response.body().string();
			System.out.println("Test app is uploaded in Sauce Labs: \n" + jsonData);
//			JSONObject Jobject = new JSONObject(jsonData);
//			JSONObject getSth = Jobject.getJSONObject("item");
//			String value = getSth.get("id").toString();
//			if(String.valueOf(executionPlatform).equals("IOS")) {
//				mobileProperties.setProperty("appNameSauceLabs", value);
//			} else {
//				mobileProperties.setProperty("SauceAndroidIdentifier", value);
//			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
