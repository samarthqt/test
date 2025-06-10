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

import com.pageobjects.KSM_LoginPage;
import org.testng.annotations.Test;

import com.framework.components.DriverScript;
import com.framework.components.TestConfigurationsLite;
import com.framework.selenium.SeleniumTestParameters;
import com.pageobjects.HybridWebPage;

public class WebModularTest1 extends TestConfigurationsLite {

    @Test(dataProvider = "ChromeBrowser", dataProviderClass = TestConfigurationsLite.class)
    public void seleniumPracticeTest(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test for Sample Selenium Test");
        DriverScript driverScript = new DriverScript(testParameters);
        driverScript.driveTestExecution();
        tearDownTestRunner(testParameters, driverScript);
    }

    @Override
    public void setUp() {
        //Any initialisation can be done in setup step
    }

    @Override
    public void executeTest() {
        launchSeleniumUrl();
        enterDetails();

    }

    @Override
    public void tearDown() {
        //Closing any objects
    }

    public void launchSeleniumUrl() {
        KSM_LoginPage sp = new KSM_LoginPage(scriptHelper);
        String url = properties.getProperty("ApplicationUrl");
        sp.launchApp(url);
    }

    public void enterDetails() {
        KSM_LoginPage sp = new KSM_LoginPage(scriptHelper);
        sp.clickOrganizationBtn();
        String phoneNumber1 = dataTable.getData("General_Data", "phoneNumber1");
        String organizationName = dataTable.getData("General_Data", "organizationName");
        sp.enterPhoneNumberTxt1(phoneNumber1);
        sp.enterOrganizationNameTxt(organizationName);
        sp.clickSendOTPBtn1();
    }


}
