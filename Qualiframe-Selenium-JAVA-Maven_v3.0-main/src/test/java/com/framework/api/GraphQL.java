/*
 *  © [2024] Qualitest. All rights reserved.
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
package com.framework.api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.framework.components.FrameworkException;
import com.framework.components.Settings;
import com.framework.report.Status;
import com.framework.reusable.GenericResuableComponents;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

/**
 * GraphQL Utility Class for API Automation
 * 
 * <h2>Features:</h2>
 * <ul>
 *   <li><strong>Query Support:</strong> Execute GraphQL queries to fetch data</li>
 *   <li><strong>Mutation Support:</strong> Execute GraphQL mutations to modify data</li>
 *   <li><strong>Response Parsing:</strong> Parse and extract data from GraphQL responses</li>
 *   <li><strong>Error Handling:</strong> Comprehensive error handling and validation</li>
 *   <li><strong>Variable Support:</strong> Support for GraphQL variables in queries/mutations</li>
 *   <li><strong>File-based Queries:</strong> Load GraphQL queries from files</li>
 * </ul>
 * 
 * <h2>Usage Example:</h2>
 * <pre>
 * GraphQL graphQL = new GraphQL();
 * 
 * // Execute a simple query
 * ValidatableResponse response = graphQL.executeQuery(
 *     "https://api.example.com/graphql",
 *     "{ user(id: 1) { name email } }",
 *     null,
 *     headers,
 *     200
 * );
 * 
 * // Execute a mutation with variables
 * Map&lt;String, Object&gt; variables = new HashMap&lt;&gt;();
 * variables.put("name", "John Doe");
 * variables.put("email", "john@example.com");
 * 
 * response = graphQL.executeMutation(
 *     "https://api.example.com/graphql",
 *     "mutation CreateUser($name: String!, $email: String!) { createUser(name: $name, email: $email) { id name } }",
 *     variables,
 *     headers,
 *     200
 * );
 * </pre>
 * 
 * @author Qualitest
 * @version 3.0.0
 * @since 2024
 */
public class GraphQL extends GenericResuableComponents {

    private Properties property = Settings.getInstance();
    private static final String CONTENT_TYPE_GRAPHQL = "application/json";
    private static final String GRAPHQL_QUERY_KEY = "query";
    private static final String GRAPHQL_VARIABLES_KEY = "variables";
    private static final String GRAPHQL_OPERATION_NAME_KEY = "operationName";
    private static final String GRAPHQL_DATA_KEY = "data";
    private static final String GRAPHQL_ERRORS_KEY = "errors";
    
    /**
     * Default constructor
     */
    public GraphQL() {
        super();
    }

    /**
     * Enum to declare GraphQL operation types
     */
    public enum OPERATION_TYPE {
        QUERY, MUTATION, SUBSCRIPTION
    }

    /**
     * Enum to declare GraphQL response assertion types
     */
    public enum ASSERT_RESPONSE {
        DATA, ERRORS, EXTENSIONS, FULL_RESPONSE
    }

    /**
     * Enum to declare comparison types for GraphQL assertions
     */
    public enum COMPARISON {
        IS_EXISTS, IS_EQUALS, IS_CONTAINS, IS_NULL, IS_NOT_NULL
    }

    /**
     * Execute a GraphQL query
     * 
     * @param endpoint The GraphQL endpoint URL
     * @param query The GraphQL query string
     * @param variables Map of variables to be used in the query (can be null)
     * @param headers Map of HTTP headers (can be null)
     * @param expectedStatusCode The expected HTTP status code (use -1 to skip validation)
     * @return ValidatableResponse object containing the response
     * @throws FrameworkException if the request fails
     */
    public ValidatableResponse executeQuery(String endpoint, String query, 
                                           Map<String, Object> variables, 
                                           Map<String, String> headers, 
                                           int expectedStatusCode) {
        return executeGraphQLOperation(endpoint, query, variables, null, headers, expectedStatusCode, true);
    }

    /**
     * Execute a GraphQL mutation
     * 
     * @param endpoint The GraphQL endpoint URL
     * @param mutation The GraphQL mutation string
     * @param variables Map of variables to be used in the mutation (can be null)
     * @param headers Map of HTTP headers (can be null)
     * @param expectedStatusCode The expected HTTP status code (use -1 to skip validation)
     * @return ValidatableResponse object containing the response
     * @throws FrameworkException if the request fails
     */
    public ValidatableResponse executeMutation(String endpoint, String mutation, 
                                              Map<String, Object> variables, 
                                              Map<String, String> headers, 
                                              int expectedStatusCode) {
        return executeGraphQLOperation(endpoint, mutation, variables, null, headers, expectedStatusCode, true);
    }

    /**
     * Execute a GraphQL operation (query or mutation) with operation name
     * 
     * @param endpoint The GraphQL endpoint URL
     * @param operation The GraphQL operation string (query or mutation)
     * @param variables Map of variables to be used in the operation (can be null)
     * @param operationName The name of the operation (optional, can be null)
     * @param headers Map of HTTP headers (can be null)
     * @param expectedStatusCode The expected HTTP status code
     * @return ValidatableResponse object containing the response
     * @throws FrameworkException if the request fails
     */
    public ValidatableResponse executeGraphQLOperation(String endpoint, String operation, 
                                                      Map<String, Object> variables, 
                                                      String operationName,
                                                      Map<String, String> headers, 
                                                      int expectedStatusCode) {
        return executeGraphQLOperation(endpoint, operation, variables, operationName, headers, expectedStatusCode, true);
    }

    /**
     * Execute a GraphQL operation (query or mutation) with operation name and optional status code validation
     * 
     * @param endpoint The GraphQL endpoint URL
     * @param operation The GraphQL operation string (query or mutation)
     * @param variables Map of variables to be used in the operation (can be null)
     * @param operationName The name of the operation (optional, can be null)
     * @param headers Map of HTTP headers (can be null)
     * @param expectedStatusCode The expected HTTP status code (used only if validateStatusCode is true)
     * @param validateStatusCode Whether to validate the status code during execution
     * @return ValidatableResponse object containing the response
     * @throws FrameworkException if the request fails
     */
    public ValidatableResponse executeGraphQLOperation(String endpoint, String operation, 
                                                      Map<String, Object> variables, 
                                                      String operationName,
                                                      Map<String, String> headers, 
                                                      int expectedStatusCode,
                                                      boolean validateStatusCode) {
        ValidatableResponse response = null;
        
        try {
            // Log the endpoint being called
            System.out.println("DEBUG: GraphQL Endpoint URL: " + endpoint);
            System.out.println("DEBUG: GraphQL Operation: " + operation);
            
            // Build the GraphQL request body
            JSONObject requestBody = buildGraphQLRequestBody(operation, variables, operationName);
            System.out.println("DEBUG: GraphQL Request Body: " + requestBody.toJSONString());
            
            // Execute the request - try POST first (standard GraphQL method)
            io.restassured.specification.RequestSpecification request = RestAssured
                    .given()
                    .relaxedHTTPSValidation()
                    .contentType(ContentType.JSON)
                    .body(requestBody.toJSONString());
            
            // Add headers if provided
            if (headers != null && !headers.isEmpty()) {
                request.headers(headers);
                System.out.println("DEBUG: GraphQL Headers: " + headers);
            }
            
            // Send POST request (GraphQL typically uses POST)
            Response httpResponse = request.post(endpoint);
            int statusCode = httpResponse.getStatusCode();
            System.out.println("DEBUG: GraphQL Response Status Code: " + statusCode);
            
            // If POST returns 405, try GET (some GraphQL servers support GET for queries)
            if (statusCode == 405 && operation.trim().toLowerCase().startsWith("query")) {
                System.out.println("DEBUG: POST returned 405, trying GET for query...");
                
                // For GET, we need to encode the query as a URL parameter
                try {
                    String queryParam = java.net.URLEncoder.encode(operation, "UTF-8");
                    String getUrl = endpoint + "?query=" + queryParam;
                    
                    // Add variables if present
                    if (variables != null && !variables.isEmpty()) {
                        String variablesJson = new JSONObject(variables).toJSONString();
                        getUrl += "&variables=" + java.net.URLEncoder.encode(variablesJson, "UTF-8");
                    }
                    
                    System.out.println("DEBUG: Trying GET request to: " + getUrl);
                    
                    io.restassured.specification.RequestSpecification getRequest = RestAssured
                            .given()
                            .relaxedHTTPSValidation();
                    
                    if (headers != null && !headers.isEmpty()) {
                        getRequest.headers(headers);
                    }
                    
                    httpResponse = getRequest.get(getUrl);
                    statusCode = httpResponse.getStatusCode();
                    System.out.println("DEBUG: GET Response Status Code: " + statusCode);
                } catch (Exception getException) {
                    System.out.println("DEBUG: GET request also failed: " + getException.getMessage());
                    // Continue with POST response
                }
            }
            
            // Validate status code if requested
            if (validateStatusCode) {
                response = httpResponse.then().assertThat().statusCode(expectedStatusCode);
                addTestLog(endpoint, "GraphQL Operation Executed", 
                          "Status Code: " + expectedStatusCode, Status.PASS);
            } else {
                response = httpResponse.then();
                addTestLog(endpoint, "GraphQL Operation Executed", 
                          "Status Code: " + statusCode + " (validation deferred)", Status.PASS);
            }
            
        } catch (AssertionError e) {
            addTestLog(endpoint, "GraphQL Operation Failed", 
                      e.getMessage() + " - Please check the request. Endpoint: " + endpoint, Status.FAIL);
            throw new FrameworkException("GraphQL operation failed: " + e.getMessage() + ". Endpoint: " + endpoint);
        } catch (Exception e) {
            addTestLog(endpoint, "GraphQL Operation Error", 
                      e.getMessage() + " - Please check the request. Endpoint: " + endpoint, Status.FAIL);
            throw new FrameworkException("GraphQL operation error: " + e.getMessage() + ". Endpoint: " + endpoint);
        }
        
        return response;
    }

    /**
     * Build GraphQL request body as JSON
     * 
     * @param operation The GraphQL operation string
     * @param variables Map of variables (can be null)
     * @param operationName The operation name (optional, can be null)
     * @return JSONObject containing the GraphQL request
     */
    @SuppressWarnings("unchecked")
    private JSONObject buildGraphQLRequestBody(String operation, Map<String, Object> variables, String operationName) {
        JSONObject requestBody = new JSONObject();
        
        // Add query/mutation
        requestBody.put(GRAPHQL_QUERY_KEY, operation);
        
        // Add variables if provided
        if (variables != null && !variables.isEmpty()) {
            JSONObject variablesJson = new JSONObject();
            variablesJson.putAll(variables);
            requestBody.put(GRAPHQL_VARIABLES_KEY, variablesJson);
        }
        
        // Add operation name if provided
        if (operationName != null && !operationName.isEmpty()) {
            requestBody.put(GRAPHQL_OPERATION_NAME_KEY, operationName);
        }
        
        return requestBody;
    }

    /**
     * Load GraphQL query/mutation from a file
     * 
     * @param filePath The path to the file containing the GraphQL operation
     * @return String containing the GraphQL operation
     * @throws FrameworkException if file cannot be read
     */
    public String loadQueryFromFile(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            return content.trim();
        } catch (IOException e) {
            throw new FrameworkException("Failed to load GraphQL query from file: " + filePath + " - " + e.getMessage());
        }
    }

    /**
     * Extract data from GraphQL response
     * 
     * @param response The ValidatableResponse object
     * @param dataPath The JSON path to the data field (e.g., "user.name" or "data.user.name")
     * @return Object containing the extracted data
     */
    public Object extractData(ValidatableResponse response, String dataPath) {
        if (response == null) {
            throw new FrameworkException("Response is null");
        }
        
        try {
            String responseBody = response.extract().body().asString();
            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(responseBody);
            
            // Check if response has data field
            if (jsonResponse.containsKey(GRAPHQL_DATA_KEY)) {
                JSONObject data = (JSONObject) jsonResponse.get(GRAPHQL_DATA_KEY);
                return extractValueFromJson(data, dataPath);
            } else {
                // If no data field, try to extract directly from response
                return extractValueFromJson(jsonResponse, dataPath);
            }
        } catch (ParseException e) {
            throw new FrameworkException("Failed to parse GraphQL response: " + e.getMessage());
        } catch (Exception e) {
            throw new FrameworkException("Failed to extract data from GraphQL response: " + e.getMessage());
        }
    }

    /**
     * Extract value from JSON object using dot notation path
     * 
     * @param jsonObject The JSON object to extract from
     * @param path The dot-notation path (e.g., "user.name" or "countries[0].name")
     * @return Object containing the extracted value
     */
    @SuppressWarnings("unchecked")
    private Object extractValueFromJson(JSONObject jsonObject, String path) {
        if (path == null || path.isEmpty()) {
            return jsonObject;
        }
        
        String[] keys = path.split("\\.");
        Object current = jsonObject;
        
        for (String key : keys) {
            if (current == null) {
                return null;
            }
            
            // Check if key contains array index notation (e.g., "countries[0]")
            if (key.contains("[") && key.contains("]")) {
                // Extract the key name and index
                String arrayKey = key.substring(0, key.indexOf("["));
                String indexStr = key.substring(key.indexOf("[") + 1, key.indexOf("]"));
                int index = Integer.parseInt(indexStr);
                
                // Get the array/list from current object
                if (current instanceof JSONObject) {
                    Object arrayValue = ((JSONObject) current).get(arrayKey);
                    if (arrayValue instanceof List) {
                        List<Object> list = (List<Object>) arrayValue;
                        if (index >= 0 && index < list.size()) {
                            current = list.get(index);
                        } else {
                            return null; // Index out of bounds
                        }
                    } else {
                        return null; // Key exists but is not a list
                    }
                } else {
                    return null; // Current is not a JSONObject, can't get array
                }
            } else {
                // Regular key access (no array index)
                if (current instanceof JSONObject) {
                    current = ((JSONObject) current).get(key);
                } else if (current instanceof List) {
                    // If current is a list and we're trying to access a key, it's invalid
                    return null;
                } else {
                    return null; // Current is a primitive value, can't access nested keys
                }
            }
        }
        
        return current;
    }

    /**
     * Check if GraphQL response contains errors
     * 
     * @param response The ValidatableResponse object
     * @return true if response contains errors, false otherwise
     */
    public boolean hasErrors(ValidatableResponse response) {
        if (response == null) {
            return true;
        }
        
        try {
            String responseBody = response.extract().body().asString();
            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(responseBody);
            
            return jsonResponse.containsKey(GRAPHQL_ERRORS_KEY) && 
                   jsonResponse.get(GRAPHQL_ERRORS_KEY) != null;
        } catch (Exception e) {
            return true;
        }
    }

    /**
     * Get errors from GraphQL response
     * 
     * @param response The ValidatableResponse object
     * @return List of error objects, or null if no errors
     */
    @SuppressWarnings("unchecked")
    public List<Object> getErrors(ValidatableResponse response) {
        if (response == null) {
            return null;
        }
        
        try {
            String responseBody = response.extract().body().asString();
            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(responseBody);
            
            if (jsonResponse.containsKey(GRAPHQL_ERRORS_KEY)) {
                Object errors = jsonResponse.get(GRAPHQL_ERRORS_KEY);
                if (errors instanceof List) {
                    return (List<Object>) errors;
                }
            }
            
            return null;
        } catch (Exception e) {
            throw new FrameworkException("Failed to extract errors from GraphQL response: " + e.getMessage());
        }
    }

    /**
     * Assert GraphQL response data
     * 
     * @param endpoint The GraphQL endpoint (for logging purposes)
     * @param response The ValidatableResponse object
     * @param dataPath The JSON path to the data field
     * @param expectedValue The expected value
     * @param comparison The comparison type
     * @return true if assertion passes, false otherwise
     */
    public boolean assertGraphQLData(String endpoint, ValidatableResponse response, 
                                    String dataPath, Object expectedValue, 
                                    COMPARISON comparison) {
        if (response == null) {
            addTestLog(endpoint, "Assert GraphQL Data", 
                      "Response is null", Status.FAIL);
            return false;
        }
        
        try {
            Object actualValue = extractData(response, dataPath);
            
            // Debug logging
            System.out.println("DEBUG: Extracting data from path: " + dataPath);
            System.out.println("DEBUG: Extracted value: " + actualValue);
            System.out.println("DEBUG: Expected value: " + expectedValue);
            System.out.println("DEBUG: Comparison type: " + comparison);
            
            if (compareGraphQLValue(comparison, actualValue, expectedValue)) {
                addTestLog(endpoint, "Assert GraphQL Data", 
                          "Expected: " + expectedValue + ", Actual: " + actualValue, 
                          Status.PASS);
                return true;
            } else {
                // If extraction returned null, try to show the response structure
                if (actualValue == null) {
                    try {
                        String responseBody = response.extract().body().asString();
                        System.out.println("DEBUG: Full GraphQL Response: " + responseBody);
                    } catch (Exception e) {
                        // Ignore
                    }
                }
                addTestLog(endpoint, "Assert GraphQL Data", 
                          "Expected: " + expectedValue + ", Actual: " + actualValue + 
                          " (Path: " + dataPath + ")", 
                          Status.FAIL);
                return false;
            }
        } catch (Exception e) {
            System.out.println("DEBUG: Exception during data extraction: " + e.getMessage());
            e.printStackTrace();
            addTestLog(endpoint, "Assert GraphQL Data", 
                      "Error: " + e.getMessage() + " (Path: " + dataPath + ")", Status.FAIL);
            return false;
        }
    }

    /**
     * Compare GraphQL values based on comparison type
     * 
     * @param comparison The comparison type
     * @param actualValue The actual value
     * @param expectedValue The expected value
     * @return true if comparison passes, false otherwise
     */
    private boolean compareGraphQLValue(COMPARISON comparison, Object actualValue, Object expectedValue) {
        if (actualValue == null && expectedValue == null) {
            return true;
        }
        
        if (actualValue == null || expectedValue == null) {
            return false;
        }
        
        switch (comparison) {
            case IS_EXISTS:
                return actualValue != null;
                
            case IS_EQUALS:
                return actualValue.toString().equals(expectedValue.toString());
                
            case IS_CONTAINS:
                return actualValue.toString().contains(expectedValue.toString());
                
            case IS_NULL:
                return actualValue == null;
                
            case IS_NOT_NULL:
                return actualValue != null;
                
            default:
                return false;
        }
    }

    /**
     * Verify GraphQL response has no errors
     * 
     * @param endpoint The GraphQL endpoint (for logging purposes)
     * @param response The ValidatableResponse object
     * @return true if no errors, false otherwise
     */
    public boolean verifyNoErrors(String endpoint, ValidatableResponse response) {
        if (response == null) {
            addTestLog(endpoint, "Verify No Errors", 
                      "Response is null", Status.FAIL);
            return false;
        }
        
        boolean hasErrors = hasErrors(response);
        
        if (!hasErrors) {
            addTestLog(endpoint, "Verify No Errors", 
                      "No errors found in GraphQL response", Status.PASS);
            return true;
        } else {
            List<Object> errors = getErrors(response);
            addTestLog(endpoint, "Verify No Errors", 
                      "Errors found in GraphQL response: " + errors, Status.FAIL);
            return false;
        }
    }

    /**
     * Get the full GraphQL response as string
     * 
     * @param response The ValidatableResponse object
     * @return String containing the full response
     */
    public String getResponseAsString(ValidatableResponse response) {
        if (response == null) {
            throw new FrameworkException("Response is null");
        }
        
        return response.extract().body().asString();
    }

    /**
     * Get the GraphQL data object from response
     * 
     * @param response The ValidatableResponse object
     * @return JSONObject containing the data, or null if not found
     */
    @SuppressWarnings("unchecked")
    public JSONObject getData(ValidatableResponse response) {
        if (response == null) {
            return null;
        }
        
        try {
            String responseBody = response.extract().body().asString();
            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(responseBody);
            
            if (jsonResponse.containsKey(GRAPHQL_DATA_KEY)) {
                Object data = jsonResponse.get(GRAPHQL_DATA_KEY);
                if (data instanceof JSONObject) {
                    return (JSONObject) data;
                }
            }
            
            return null;
        } catch (Exception e) {
            throw new FrameworkException("Failed to extract data from GraphQL response: " + e.getMessage());
        }
    }
}

