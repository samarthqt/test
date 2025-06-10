package com.modular.steps;

import com.framework.components.DriverScript;
import com.framework.components.TestConfigurationsLite;
import com.framework.selenium.SeleniumTestParameters;
import com.pageobjects.DragAndDrop;
import org.testng.annotations.Test;

public class WebModularTestNew extends TestConfigurationsLite {

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
        public void executeTest() throws InterruptedException {
            launchSeleniumUrl();
            DragAndDropMethods();


        }



        public void launchSeleniumUrl() {
            DragAndDrop sp = new DragAndDrop(scriptHelper);
            String url = properties.getProperty("ApplicationUrl");
            sp.launchApp(url);
        }
        public void DragAndDropMethods() {
            DragAndDrop sp = new DragAndDrop(scriptHelper);
            sp.performDragAndDrop();
        }
}
