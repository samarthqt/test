package com.cucumber.steps;

import java.util.HashMap;
import java.util.Properties;

import org.testng.Assert;

import com.framework.components.RestAssuredUtils.ASSERT_RESPONSE;
import com.framework.components.RestAssuredUtils.COMPARISON;
import com.framework.components.RestAssuredUtils.SERVICEFORMAT;
import com.framework.components.RestAssuredUtils.SERVICEMETHOD;
import com.framework.components.Settings;
import com.framework.cucumber.TestHarness;
import com.framework.reusable.ApiResuableComponents;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class APISteps extends ApiResuableComponents {
	Properties prop=Settings.getApiPropertiesInstance();
	String baseurl=prop.getProperty("BaseURL");
	String endpturl;
	String postBodyContent;
	static ValidatableResponse response;
	private long petId;
	private String petName;
	private String petStatus;
	HashMap<String, String> map = new HashMap<String, String>();
	TestHarness th=new TestHarness();

	@Given("Access {string} with {string} for {string}")
	public void access_with(String url, String header,String tcid) {
		th.initializeTestData(tcid);
		endpturl=baseurl+prop.getProperty(url);
		if(header.equalsIgnoreCase("NA"))
			map=null;
		else {
			map=getHeaders(header);
		}
	}

	@When("Send {string} with request body {string}")
	public void send_with_request_body(String requestname, String payload) {
		if(payload.equalsIgnoreCase("NA"))
			postBodyContent=null;
		else
			postBodyContent=readTemplate(TestHarness.data.get("General_Data"),"payload/"+payload);
		response = apiDriver.sendNReceive(endpturl, SERVICEMETHOD.valueOf(requestname), SERVICEFORMAT.JSON, postBodyContent, map,
				200);		
	}

	@Then("verify request is success with status {string}")
	public void verify_request_is_success_with_status(String statuscode) {
		apiDriver.verifyStatusCode(endpturl,response,Integer.parseInt(statuscode));
	}


	@Then("verify {string} in response body is {string}")
	public void verify_in_response_body_is(String key, String value) {
		Assert.assertTrue(apiDriver.assertIt(endpturl, response, ASSERT_RESPONSE.TAG, key ,(Object)value, COMPARISON.IS_EQUALS),
				response.toString());
	}

	@When("Send {string}")
	public void send(String requestname) {
		response =apiDriver.sendNReceive(endpturl, SERVICEMETHOD.valueOf(requestname), map,200);
	}


//
//	@Given("I have a pet named {string} with status {string}")
//	public void i_have_a_pet_named_with_status(String name, String status) {
//		petId = System.currentTimeMillis();
//		petName = name;
//		petStatus = status;
//
//		String body = String.format("""
//            {
//              "id": %d,
//              "name": "%s",
//              "status": "%s"
//            }
//            """, petId, petName, petStatus);
//
//		response = given()
//				.header("Content-Type", "application/json")
//				.body(body)
//				.post("https://petstore.swagger.io/v2/pet");
//
//		Assert.assertEquals(200, response.getStatusCode());
//	}
//
//	@When("I add the pet to the store")
//	public void i_add_the_pet_to_the_store() {
//		// Already added in the previous step
//	}
//
//	@Then("the pet should be added successfully")
//	public void the_pet_should_be_added_successfully() {
//		Assert.assertEquals(200, response.getStatusCode());
//		Assert.assertEquals(petName, response.jsonPath().getString("name"));
//	}
//
//	@Given("I have added a pet named {string} with status {string}")
//	public void i_have_added_a_pet_named(String name, String status) {
//		i_have_a_pet_named_with_status(name, status);
//	}
//
//	@When("I retrieve the pet by ID")
//	public void i_retrieve_the_pet_by_id() {
//		response = given()
//				.get("https://petstore.swagger.io/v2/pet/" + petId);
//	}
//
//	@Then("the response should contain the pet name {string} and status {string}")
//	public void the_response_should_contain_pet(String name, String status) {
//		Assert.assertEquals(200, response.getStatusCode());
//		Assert.assertEquals(name, response.jsonPath().getString("name"));
//		Assert.assertEquals(status, response.jsonPath().getString("status"));
//	}
//
//	@When("I update the pet's status to {string}")
//	public void i_update_the_pet_status(String newStatus) {
//		petStatus = newStatus;
//
//		String updatedBody = String.format("""
//            {
//              "id": %d,
//              "name": "%s",
//              "status": "%s"
//            }
//            """, petId, petName, petStatus);
//
//		response = given()
//				.header("Content-Type", "application/json")
//				.body(updatedBody)
//				.put("https://petstore.swagger.io/v2/pet");
//
//		Assert.assertEquals(200, response.getStatusCode());
//	}
//
//	@Then("the updated pet should have status {string}")
//	public void the_updated_pet_should_have_status(String status) {
//		Assert.assertEquals(status, response.jsonPath().getString("status"));
//	}
//
//	@When("I delete the pet")
//	public void i_delete_the_pet() {
//		response = given()
//				.delete("https://petstore.swagger.io/v2/pet/" + petId);
//
//		Assert.assertEquals(200, response.getStatusCode());
//	}
//
//	@Then("retrieving the pet by ID should return status 404")
//	public void retrieving_deleted_pet_should_return_404() {
//		response = given()
//				.get("https://petstore.swagger.io/v2/pet/" + petId);
//
//		Assert.assertEquals(404, response.getStatusCode());
//	}
//}

}
