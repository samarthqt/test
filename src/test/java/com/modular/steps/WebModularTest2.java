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
package com.modular.steps;

import org.testng.annotations.Test;

import com.framework.components.DriverScript;
import com.framework.components.TestConfigurationsLite;
import com.framework.selenium.SeleniumTestParameters;
import com.pageobjects.HybridWebPage;

public class WebModularTest2 extends TestConfigurationsLite {

	@Test(dataProvider = "ChromeBrowser", dataProviderClass = TestConfigurationsLite.class)
	public void seleniumPracticeTest(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Test for Sample Selenium Test");
		DriverScript driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();
		tearDownTestRunner(testParameters, driverScript);
	}
	
	@Override
	public void setUp() {

	}

	@Override
	public void executeTest() {
		launchSeleniumUrl();
		verifyHome();
		loginDetails();
		submitDetails();
		verifyHome();

	}

	@Override
	public void tearDown() {
		
	}
	
	public void launchSeleniumUrl() {
		HybridWebPage sp=new HybridWebPage(scriptHelper);
		//String url = properties.getProperty("ApplicationUrl");
		sp.launchApp();
	}

	public void verifyHome() {
		HybridWebPage sp=new HybridWebPage(scriptHelper);
//		sp.clickAcceptCookies();
		sp.verifyHomeScreen();

	}

	public void loginDetails() {
		HybridWebPage sp=new HybridWebPage(scriptHelper);
		String loginName = dataTable.getData("General_Data", "UserName");
		String password = dataTable.getData("General_Data", "Password");
        sp.enterLoginId(loginName);
		sp.enterPassword(password);

	}

	public void submitDetails() {
		HybridWebPage sp=new HybridWebPage(scriptHelper);
		sp.clickSubmit();
	}
}
