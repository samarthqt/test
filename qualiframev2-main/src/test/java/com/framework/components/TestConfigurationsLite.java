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
package com.framework.components;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;
import com.framework.selenium.Browser;
import com.framework.selenium.ExecutionMode;
import com.framework.selenium.MobileExecutionPlatform;
import com.framework.selenium.SeleniumParametersBuilders;

public class TestConfigurationsLite extends ModularTestCase {

	@DataProvider(name = "ChromeBrowser")
	public Object[][] desktopBrowsers(Method currentMethod) {

		@SuppressWarnings("unused")
		String[] currentPackageSplit = currentMethod.getDeclaringClass().getPackage().toString().split("com.modular.");
		//currentScenario = currentPackageSplit[1];
		currentScenario=currentMethod.getDeclaringClass().getSimpleName().split("Test")[0]+"Scenario";
		currentTestcase = currentMethod.getDeclaringClass().getSimpleName();

		return new Object[][] { { new SeleniumParametersBuilders(currentScenario, currentTestcase)
				.testInstance("Instance1").executionMode(ExecutionMode.LOCAL).browser(Browser.CHROME).build() } };
	}

	@DataProvider(name = "EDGEBrowser")
	public Object[][] desktopBrowsers1(Method currentMethod) {

		@SuppressWarnings("unused")
		String[] currentPackageSplit = currentMethod.getDeclaringClass().getPackage().toString().split("com.modular.");
		//currentScenario = currentPackageSplit[1];
		currentScenario=currentMethod.getDeclaringClass().getSimpleName().split("Test")[0]+"Scenario";
		currentTestcase = currentMethod.getDeclaringClass().getSimpleName();

		return new Object[][] { { new SeleniumParametersBuilders(currentScenario, currentTestcase)
				.testInstance("Instance1").executionMode(ExecutionMode.LOCAL).browser(Browser.EDGE).build() } };
	}

	@DataProvider(name = "ChromeAndEdgeBrowsers", parallel = true)

	public Object[][] pBrowsers(Method currentMethod) {
		String[] currentPackageSplit = currentMethod.getDeclaringClass().getPackage().toString().split("com.modular.");
		String currentScenario = currentMethod.getDeclaringClass().getSimpleName().split("Test")[0] + "Scenario";
		String currentTestcase = currentMethod.getDeclaringClass().getSimpleName();

		return new Object[][]{
				{

						new SeleniumParametersBuilders(currentScenario, currentTestcase)
								.testInstance("Instance")
								.executionMode(ExecutionMode.LOCAL)
								.browser(Browser.EDGE)
								.build()

				},

//				{
//
//						new SeleniumParametersBuilders(currentScenario, currentTestcase)
//								.testInstance("Instance")
//								.executionMode(ExecutionMode.LOCAL)
//								.browser(Browser.FIREFOX)
//								.build()
//
//				},

				{

						new SeleniumParametersBuilders(currentScenario, currentTestcase)
								.testInstance("Instance")
								.executionMode(ExecutionMode.LOCAL)
								.browser(Browser.CHROME)
								.build()

				}

		};

	}

	@DataProvider(name = "SauceChromeBrowser")
	public Object[][] SaucedesktopBrowsers(Method currentMethod) {

		currentScenario=currentMethod.getDeclaringClass().getSimpleName().split("Test")[0]+"Scenario";
		currentTestcase = currentMethod.getDeclaringClass().getSimpleName();

		return new Object[][] { { new SeleniumParametersBuilders(currentScenario, currentTestcase)
				.testInstance("Instance1").executionMode(ExecutionMode.SAUCELABS).browser(Browser.CHROME).build() } };
	}
	@DataProvider(name = "MobileAndriod")
	public Object[][] mobileDevice(Method currentMethod) {
		currentScenario=currentMethod.getDeclaringClass().getSimpleName().split("Test")[0]+"Scenario";
		currentTestcase = currentMethod.getDeclaringClass().getSimpleName();

		return new Object[][] {
				{ new SeleniumParametersBuilders(currentScenario, currentTestcase).testInstance("Instance1")
						.executionMode(ExecutionMode.MOBILE).mobileExecutionPlatform(MobileExecutionPlatform.ANDROID)
						.toolName(ToolName.APPIUM).deviceName("emulator-5554").build() } };
	}

	@DataProvider(name = "ChromeParallel", parallel = true)
	public Object[][] desktopBrowsersParallel(Method currentMethod) {
		currentScenario = currentMethod.getDeclaringClass().getSimpleName();
		currentTestcase = currentMethod.getName();
		currentTestcase = currentTestcase.substring(0, 1).toUpperCase().concat(currentTestcase.substring(1));

		return new Object[][] {
				{ new SeleniumParametersBuilders(currentScenario, currentTestcase).testInstance("Instance1")
						.executionMode(ExecutionMode.LOCAL).browser(Browser.CHROME).build() },
				{ new SeleniumParametersBuilders(currentScenario, currentTestcase).testInstance("Instance2")
						.executionMode(ExecutionMode.LOCAL).browser(Browser.CHROME).build() },
				{ new SeleniumParametersBuilders(currentScenario, currentTestcase).testInstance("Instance3")
						.executionMode(ExecutionMode.LOCAL).browser(Browser.CHROME).build() } };
	
						
	}
	@DataProvider(name = "API")
	public Object[][] API(Method currentMethod) {
		currentScenario=currentMethod.getDeclaringClass().getSimpleName().split("Test")[0]+"Scenario";
		currentTestcase = currentMethod.getDeclaringClass().getSimpleName();

		return new Object[][] {
				{ new SeleniumParametersBuilders(currentScenario, currentTestcase).testInstance("Instance1")
						.executionMode(ExecutionMode.API).build() } };
	}

	@Override
	public void setUp() {
		// TODO Auto-generated method stub
	}

	@Override
	public void executeTest() throws InterruptedException {
		// TODO Auto-generated method stub
	}

	@Override
	public void tearDown() {
		// TODO Auto-generated method stub
	}

	
}