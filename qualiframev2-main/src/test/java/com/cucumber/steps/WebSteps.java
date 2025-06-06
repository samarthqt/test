//package com.cucumber.steps;
//
//import java.util.Properties;
//
//import com.framework.components.Settings;
//import com.framework.cucumber.TestHarness;
//import com.pageobjects.WebPage;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class WebSteps extends WebPage {
//
//	protected TestHarness testHarness = new TestHarness();
//	protected Properties properties = Settings.getInstance();
//
//	@When("Launch Application using {string}")
//	public void launch_Application(String tcid) {
//		String url = properties.getProperty("ApplicationUrl");
//		testHarness.initializeTestData(tcid);
//		launchApp(url);
//	}
//
//	@Then("verify home page displayed successfully")
//	public void verifyhome()  {
//		clickAcceptCookies();
//		verifyHome();
//		clickOkButton();
//	}
//
//	@Then("enter automation practice form details")
//	public void enterdetails() {
//		String firstName = testHarness.getData("General_Data", "FirstName");
//		String lastName = testHarness.getData("General_Data", "LastName");
//		String country = testHarness.getData("General_Data", "Country");
//		enterFistName(firstName);
//		enterLastName(lastName);
//		clickGender();
//		clickExperience();
//		clickProfession();
//		clickProfession();
//		clickToolProtractor();
//		clickToolSelenium();
//		selectCountry(country);
//	}
//
//	@Then("submit the entered details")
//	public void submitdetails() {
//		submitDetails();
//	}
//
//	@Given("run functional test script for {string} from {string}")
//	public void run_functional_test_script(String testcaseName, String file) {
//		if(file.contains(".json")) {
//			runAutomationTests(file,testcaseName);
//		} else {
//			findJsonFilesInFolder(file,testcaseName);
//		}
//	}
//
//}
