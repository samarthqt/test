package com.cucumber.steps;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;

import com.framework.api.GraphQL;
import com.framework.components.FrameworkException;
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

public class APISteps extends ApiResuableComponents {
	Properties prop=Settings.getApiPropertiesInstance();
	String baseurl=prop.getProperty("BaseURL");
	String endpturl;
	String postBodyContent;
	static ValidatableResponse response;
	HashMap<String, String> map = new HashMap<String, String>();
	TestHarness th=new TestHarness();
	
	// GraphQL instance for GraphQL operations
	GraphQL graphQL = new GraphQL();
	static ValidatableResponse graphQLResponse;
	String graphQLEndpoint;
	Map<String, Object> graphQLVariables;
	int expectedGraphQLStatusCode = 200; // Default status code

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

	// ==================== GraphQL Step Definitions ====================
	
	/**
	 * Step definition to access GraphQL endpoint
	 * 
	 * @param url The GraphQL endpoint URL key from properties
	 * @param header The header type (header1, header2, header3, or NA)
	 * @param tcid The test case ID for initializing test data
	 */
	@Given("Access GraphQL endpoint {string} with {string} for {string}")
	public void access_graphql_endpoint_with_for(String url, String header, String tcid) {
		th.initializeTestData(tcid);
		
		// Get the endpoint property value
		String endpointProperty = prop.getProperty(url);
		if (endpointProperty == null || endpointProperty.isEmpty()) {
			throw new FrameworkException("GraphQL endpoint property '" + url + "' not found in API properties file. " +
					"Please ensure the property exists in your API configuration.");
		}
		
		// Check if endpointProperty is a full URL (starts with http:// or https://)
		// If it's a full URL, use it as-is; otherwise, append to baseurl
		if (endpointProperty.startsWith("http://") || endpointProperty.startsWith("https://")) {
			graphQLEndpoint = endpointProperty;
		} else {
			// Ensure proper path concatenation (handle trailing/leading slashes)
			String base = baseurl.endsWith("/") ? baseurl.substring(0, baseurl.length() - 1) : baseurl;
			String endpoint = endpointProperty.startsWith("/") ? endpointProperty : "/" + endpointProperty;
			graphQLEndpoint = base + endpoint;
		}
		
		System.out.println("DEBUG: Base URL: " + baseurl);
		System.out.println("DEBUG: Endpoint Property Key: " + url);
		System.out.println("DEBUG: Endpoint Property Value: " + endpointProperty);
		System.out.println("DEBUG: Full GraphQL Endpoint URL: " + graphQLEndpoint);
		
		if (header.equalsIgnoreCase("NA")) {
			map = null;
		} else {
			map = getHeaders(header);
			System.out.println("DEBUG: GraphQL Headers: " + map);
		}
	}

	/**
	 * Step definition to execute GraphQL query
	 * 
	 * @param query The GraphQL query string
	 * @param variables The variables key from test data (or NA if no variables)
	 */
	@When("Execute GraphQL query {string} with variables {string}")
	public void execute_graphql_query_with_variables(String query, String variables) {
		// Parse variables if provided
		graphQLVariables = parseGraphQLVariables(variables);
		
		// Execute the GraphQL query without status code validation (will be validated in Then step)
		graphQLResponse = graphQL.executeGraphQLOperation(graphQLEndpoint, query, graphQLVariables, null, map, 200, false);
	}

	/**
	 * Step definition to execute GraphQL mutation
	 * 
	 * @param mutation The GraphQL mutation string
	 * @param variables The variables key from test data (or NA if no variables)
	 */
	@When("Execute GraphQL mutation {string} with variables {string}")
	public void execute_graphql_mutation_with_variables(String mutation, String variables) {
		// Parse variables if provided
		graphQLVariables = parseGraphQLVariables(variables);
		
		// Execute the GraphQL mutation without status code validation (will be validated in Then step)
		graphQLResponse = graphQL.executeGraphQLOperation(graphQLEndpoint, mutation, graphQLVariables, null, map, 200, false);
	}

	/**
	 * Step definition to execute GraphQL query from file
	 * 
	 * @param queryFile The name of the file containing the GraphQL query
	 */
	@When("Execute GraphQL query from file {string}")
	public void execute_graphql_query_from_file(String queryFile) {
		// Load query from file - try multiple possible paths
		String basePath = System.getProperty("user.dir");
		String[] possiblePaths = {
			basePath + File.separator + "src" + File.separator + "test" + File.separator 
				+ "resources" + File.separator + "api" + File.separator + "graphql" + File.separator + queryFile,
			"." + File.separator + "src" + File.separator + "test" + File.separator 
				+ "resources" + File.separator + "api" + File.separator + "graphql" + File.separator + queryFile,
			basePath + File.separator + "src" + File.separator + "test" + File.separator 
				+ "resources" + File.separator + "graphql" + File.separator + queryFile
		};
		
		String query = null;
		Exception lastException = null;
		
		for (String queryFilePath : possiblePaths) {
			try {
				query = graphQL.loadQueryFromFile(queryFilePath);
				break; // Success, exit loop
			} catch (Exception e) {
				lastException = e;
				// Try next path
			}
		}
		
		if (query == null) {
			throw new FrameworkException("Failed to load GraphQL query from file: " + queryFile + 
					". Tried paths: " + String.join(", ", possiblePaths) + 
					(lastException != null ? ". Last error: " + lastException.getMessage() : ""));
		}
		
		// Execute the GraphQL query without status code validation (will be validated in Then step)
		graphQLResponse = graphQL.executeGraphQLOperation(graphQLEndpoint, query, null, null, map, 200, false);
	}

	/**
	 * Step definition to verify GraphQL request status
	 * 
	 * @param statuscode The expected HTTP status code
	 */
	@Then("verify GraphQL request is success with status {string}")
	public void verify_graphql_request_is_success_with_status(String statuscode) {
		// Verify response is not null
		Assert.assertNotNull(graphQLResponse, "GraphQL response should not be null");
		
		// Validate the actual status code matches expected
		int expectedStatusCode = Integer.parseInt(statuscode);
		int actualStatusCode = graphQLResponse.extract().statusCode();
		
		// Provide helpful error message for common errors
		String errorMessage = "GraphQL response status code should be " + expectedStatusCode + " but was " + actualStatusCode;
		if (actualStatusCode == 405) {
			errorMessage += ". HTTP 405 Method Not Allowed - Please verify: " +
					"1) The GraphQL endpoint URL is correct, " +
					"2) The endpoint accepts POST requests, " +
					"3) The endpoint path is correct (e.g., /graphql, /api/graphql)";
		} else if (actualStatusCode == 404) {
			errorMessage += ". HTTP 404 Not Found - Please verify the GraphQL endpoint URL is correct";
		} else if (actualStatusCode >= 500) {
			errorMessage += ". HTTP " + actualStatusCode + " Server Error - The GraphQL server encountered an error";
		}
		
		Assert.assertEquals(actualStatusCode, expectedStatusCode, errorMessage);
	}

	/**
	 * Step definition to verify GraphQL response has no errors
	 */
	@Then("verify GraphQL response has no errors")
	public void verify_graphql_response_has_no_errors() {
		Assert.assertTrue(graphQL.verifyNoErrors(graphQLEndpoint, graphQLResponse), 
				"GraphQL response should not contain errors");
	}

	/**
	 * Step definition to verify GraphQL data path value
	 * 
	 * @param dataPath The JSON path to the data field (e.g., "user.name")
	 * @param expectedValue The expected value
	 */
	@Then("verify GraphQL data path {string} is {string}")
	public void verify_graphql_data_path_is(String dataPath, String expectedValue) {
		Assert.assertTrue(graphQL.assertGraphQLData(graphQLEndpoint, graphQLResponse, dataPath, 
				expectedValue, GraphQL.COMPARISON.IS_EQUALS), 
				"GraphQL data path " + dataPath + " should be " + expectedValue);
	}

	/**
	 * Step definition to verify GraphQL data path exists
	 * 
	 * @param dataPath The JSON path to the data field (e.g., "user.name")
	 */
	@Then("verify GraphQL data path {string} exists")
	public void verify_graphql_data_path_exists(String dataPath) {
		Assert.assertTrue(graphQL.assertGraphQLData(graphQLEndpoint, graphQLResponse, dataPath, 
				null, GraphQL.COMPARISON.IS_EXISTS), 
				"GraphQL data path " + dataPath + " should exist");
	}

	/**
	 * Helper method to parse GraphQL variables from test data
	 * 
	 * @param variablesKey The key to look up in test data (or "NA" if no variables)
	 * @return Map of variables, or null if variablesKey is "NA"
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Object> parseGraphQLVariables(String variablesKey) {
		if (variablesKey == null || variablesKey.equalsIgnoreCase("NA")) {
			return null;
		}
		
		Map<String, Object> variables = new HashMap<>();
		
		try {
			// Try to get variables from test data
			// TestHarness.data is HashMap<String, HashMap<String, String>>
			if (TestHarness.data != null) {
				// Check if the key exists in the outer map (test case level)
				// We need to check the current test case's data
				HashMap<String, String> testCaseData = TestHarness.data.get("General_Data");
				
				if (testCaseData != null && testCaseData.containsKey(variablesKey)) {
					// Get the value - it could be a JSON string or already a map structure
					Object variableValue = testCaseData.get(variablesKey);
					
					if (variableValue instanceof String) {
						// Parse JSON string to Map
						JSONParser parser = new JSONParser();
						JSONObject jsonObject = (JSONObject) parser.parse((String) variableValue);
						variables.putAll(jsonObject);
						System.out.println("DEBUG: Parsed GraphQL variables from test data: " + variables);
					} else if (variableValue instanceof Map) {
						// Already a map, convert to our format
						variables.putAll((Map<String, Object>) variableValue);
						System.out.println("DEBUG: Using GraphQL variables from test data: " + variables);
					}
				} else {
					// If not found in test data, try to parse variablesKey as JSON directly
					try {
						JSONParser parser = new JSONParser();
						JSONObject jsonObject = (JSONObject) parser.parse(variablesKey);
						variables.putAll(jsonObject);
						System.out.println("DEBUG: Parsed GraphQL variables as JSON: " + variables);
					} catch (Exception jsonEx) {
						// If it's not valid JSON, it's probably a test data key that doesn't exist
						System.out.println("WARNING: GraphQL variables key '" + variablesKey + "' not found in test data. " +
								"Please ensure the key exists in your test data file or provide variables as JSON string. " +
								"Error: " + jsonEx.getMessage());
						return null; // Return null to indicate variables are missing
					}
				}
			} else {
				// If TestHarness.data is null, try to parse variablesKey as JSON directly
				try {
					JSONParser parser = new JSONParser();
					JSONObject jsonObject = (JSONObject) parser.parse(variablesKey);
					variables.putAll(jsonObject);
					System.out.println("DEBUG: Parsed GraphQL variables as JSON (no test data): " + variables);
				} catch (Exception jsonEx) {
					System.out.println("WARNING: TestHarness.data is null and variablesKey is not valid JSON. " +
							"Variables key: '" + variablesKey + "'. Error: " + jsonEx.getMessage());
					return null;
				}
			}
		} catch (Exception e) {
			// If parsing fails, log the error and return null
			System.out.println("WARNING: Could not parse GraphQL variables. Key: '" + variablesKey + 
					"', Error: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
		return variables.isEmpty() ? null : variables;
	}

}
