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

import com.framework.components.DriverScript;
import com.framework.components.TestConfigurationsLite;
import com.framework.selenium.SeleniumTestParameters;
import com.pageobjects.WebDisney;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WebModularTestDisney extends TestConfigurationsLite {

    public WebDriver driver;

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
        searchQuery();

    }

    @Override
    public void tearDown() {
        //Closing any objects
    }

    public void launchSeleniumUrl() {
        WebDisney sp = new WebDisney(scriptHelper);
        String url = properties.getProperty("ApplicationUrl");
        sp.launchApp(url);
    }
    public void searchQuery() {
        WebDisney sp = new WebDisney(scriptHelper);
//        sp.refresh();
        sp.searchQuery();
        String username = dataTable.getData("General_Data", "QuerySearch");
        sp.enterQuery(username);
        sp.SearchSubmit();
        sp.verifyResult();
        sp.scroll();
    }





}
