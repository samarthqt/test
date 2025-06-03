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
package com.framework.cucumber;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.framework.components.FrameworkException;
import com.framework.components.Settings;
import com.framework.components.ToolName;
import com.framework.data.AccessDatabase;
import com.framework.data.CsvReader;
import com.framework.data.DataTable;
import com.framework.data.ExcelDataAccess;
import com.framework.data.JsonData;
import com.framework.report.Util;
import com.framework.selenium.SauceLabWebDriverFactory;
import com.framework.selenium.SeleniumTestParameters;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Scenario;

public class TestHarness {

	private Properties properties;
	@SuppressWarnings("unused")
	private Properties mobileproperties;
	public HashMap<String, HashMap<String, String>> data = new HashMap<String, HashMap<String, String>>();
	public HashMap<String, String> csvdata = new HashMap<String, String>();
	public String currentTestcase;

	/**
	 * Constructor to initialize the {@link TestHarness} object
	 */
	public TestHarness() {
		mobileproperties = Settings.getMobilePropertiesInstance();
		properties = Settings.getInstance();
		System.setProperty("reportPath", TestNGListener.resultFolder);
	}

	@SuppressWarnings("rawtypes")
	public void invokeDriver(Scenario scenario) {

		WebDriver driver;
		AppiumDriver appiumDriver;

		SeleniumTestParameters currentTestParameters = DriverManager.getTestParameters();
		switch (currentTestParameters.getExecutionMode()) {

		case API:
			break;

		case LOCAL:
		case GRID:
			driver = DriverManager.createWebDriverInstance(currentTestParameters, scenario.getName());
			DriverManager.setWebDriver(driver);
			break;

		case SAUCELABS:
			if (currentTestParameters.getMobileToolName().equals(ToolName.APPIUM)) {
				appiumDriver = DriverManager.createAppiumInstance(currentTestParameters);
				DriverManager.setAppiumDriver(appiumDriver);
			} else {
				driver = DriverManager.createWebDriverInstance(currentTestParameters, scenario.getName());
				DriverManager.setWebDriver(driver);
			}
			break;

		case MOBILE:
			appiumDriver = DriverManager.createAppiumInstance(currentTestParameters);
			DriverManager.setAppiumDriver(appiumDriver);
			break;

		default:
			break;

		}
	}

	public void closeRespestiveDriver(Scenario scenario) {
		SeleniumTestParameters testParameters = DriverManager.getTestParameters();

		switch (testParameters.getExecutionMode()) {
		case LOCAL:
		case GRID:
			DriverManager.getWebDriver().quit();
			break;
		case MOBILE:
			DriverManager.getAppiumDriver().quit();
			break;
		case SAUCELABS:

			if(testParameters.getMobileToolName().equals(ToolName.REMOTE_WEBDRIVER)&&
					properties.get("SauceVisualRunner").toString().equalsIgnoreCase("False")
					) {
				try {
					System.out.println(SauceLabWebDriverFactory.getShareableLink((RemoteWebDriver) DriverManager.getWebDriver()));

					SauceLabWebDriverFactory.quitsession(scenario.getStatus().toString().toLowerCase());
				} catch (InvalidKeyException e) {
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			} else  {
				try {
					if(DriverManager.getAppiumDriver()!=null) {
						SauceLabWebDriverFactory.getShareableLink((RemoteWebDriver) DriverManager.getAppiumDriver());
						((JavascriptExecutor) DriverManager.getAppiumDriver()).
						executeScript("sauce:job-result=" + scenario.getStatus().toString().toLowerCase());
					} else {
						SauceLabWebDriverFactory.getShareableLink((RemoteWebDriver) DriverManager.getWebDriver());
						((JavascriptExecutor) DriverManager.getWebDriver())
						.executeScript("sauce:job-result=" + scenario.getStatus().toString().toLowerCase());
					}
				} catch (InvalidKeyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					System.out.println("Sauce - release driver");
					if(DriverManager.getAppiumDriver()!=null)  {
						DriverManager.getAppiumDriver().quit();
					}
					else {
						DriverManager.getWebDriver().quit();	
					}
				}
			}
			break;

		case API:
			break;

		default:
			throw new FrameworkException("Unhandled Execution Mode!");
		}

	}

	/**
	 * Function to wait until the specified element is located
	 * 
	 * @param by               The {@link WebDriver} locator used to identify the
	 *                         element
	 * @param timeOutInSeconds The wait timeout in seconds
	 */
	public void waitUntilElementLocated(By by, long timeOutInSeconds) {
		(new WebDriverWait(DriverManager.getWebDriver(), timeOutInSeconds))
		.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	/**
	 * Function to initialise data, to read data from external source (JSON, Excel,
	 * CSV, Access DB..)
	 * 
	 * @param testID The Test ID from feature file (tc_id)
	 * @throws SQLException
	 * @throws InterruptedException
	 * @throws ClassNotFoundException
	 */
	public void initializeTestData(String currentTestID) {

		String datatablePath = System.getProperty("user.dir") + Util.getFileSeparator() + "src"
				+ Util.getFileSeparator() + "test" + Util.getFileSeparator() + "resources" + Util.getFileSeparator()
				+ "datatables";
		currentTestcase = currentTestID;

		switch (properties.getProperty("TestData").toString()) {

		case "JSON":

			JsonData jsdata = new JsonData();
			data = jsdata.readJson(datatablePath, properties.getProperty("DataTable").toString(), currentTestID);

			break;

		case "EXCEL":

			DataTable excel = new DataTable(datatablePath, properties.getProperty("DataTable").toString());
			excel.setCurrentRow(currentTestcase, 1);
			ExcelDataAccess testDataAccess = new ExcelDataAccess(datatablePath,
					properties.getProperty("DataTable").toString());
			data = testDataAccess.readExcelValue(currentTestcase, 1);
			break;

		case "CSV":

			CsvReader csvData = new CsvReader();
			csvdata = csvData.readCSVasHashMap(datatablePath, properties.getProperty("DataTable").toString(),
					currentTestID);

			break;

		case "ACCESSDB":

			AccessDatabase accdb = new AccessDatabase();

			try {

				data = accdb.executeAccessData(datatablePath, properties.getProperty("DataTable").toString(),
						currentTestID);

			} catch (ClassNotFoundException | InterruptedException | SQLException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			break;

		default:
			throw new FrameworkException("Invalid parameters provided for TestData in Global Settings file."
					+ "Please provide the valid name");

		}
	}

	/**
	 * Function to get data by providing sheetname and key value
	 * 
	 * @param Sheetname
	 * @param Key
	 * @return
	 */
	public String getData(String Sheetname, String Key) {

		return data.get(Sheetname).get(Key);

	}

	/**
	 * Function to get data by providing the key value
	 *
	 * @param Key
	 * @return
	 */
	public String getData(String Key) {

		return csvdata.get(Key);

	}

	/**
	 * Function create/update data in a output file
	 * 
	 * @param column
	 * @param value
	 */
	public void putData(String column, String value) {

		String datatablePath = System.getProperty("user.dir") + Util.getFileSeparator() + "src"
				+ Util.getFileSeparator() + "test" + Util.getFileSeparator() + "resources" + Util.getFileSeparator()
				+ "datatables";

		DataTable datatable = new DataTable(datatablePath, properties.getProperty("DataTable").toString());

		datatable.setCurrentRow(currentTestcase, 1);

		datatable.putData(column, value);

	}

}
