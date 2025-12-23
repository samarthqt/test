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

import com.framework.utils.PlatformUtils;
import com.framework.report.Status;
import com.framework.selenium.SeleniumReport;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.io.IOException;
import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

/**
 * Cross-platform RestAssured utility for API testing
 * Works on Windows, macOS, and Linux platforms
 * 
 * @author QualiFrameV2 Team
 * @version 2.0.1
 */
public class CrossPlatformRestAssuredUtils {
    
    private static final Logger logger = Logger.getLogger(CrossPlatformRestAssuredUtils.class.getName());
    private static Properties properties = Settings.getInstance();
    private SeleniumReport report;
    
    /**
     * HTTP methods supported by the framework
     */
    public enum HttpMethod {
        GET, POST, PUT, DELETE, PATCH, HEAD, OPTIONS
    }
    
    /**
     * Content types supported by the framework
     */
    public enum ContentType {
        JSON, XML, TEXT, HTML, FORM, MULTIPART, BINARY
    }
    
    /**
     * Response validation types
     */
    public enum ValidationType {
        STATUS_CODE, HEADER, BODY, JSON_PATH, XML_PATH, RESPONSE_TIME
    }
    
    /**
     * Comparison operators for validation
     */
    public enum ComparisonOperator {
        EQUALS, CONTAINS, STARTS_WITH, ENDS_WITH, MATCHES, GREATER_THAN, LESS_THAN, NOT_NULL, IS_EMPTY
    }
    
    /**
     * Constructor
     */
    public CrossPlatformRestAssuredUtils() {
        initializeRestAssured();
    }
    
    /**
     * Initialize RestAssured with cross-platform configurations
     */
    private void initializeRestAssured() {
        logger.info("Initializing RestAssured for cross-platform API testing");
        
        // Set base URI from properties
        String baseURI = properties.getProperty("RestAssuredBaseURL", "http://localhost:8080");
        RestAssured.baseURI = baseURI;
        
        // Set timeouts
        int connectionTimeout = Integer.parseInt(properties.getProperty("RestAssuredConnectionTimeout", "10000"));
        int readTimeout = Integer.parseInt(properties.getProperty("RestAssuredReadTimeout", "30000"));
        
        // Configure RestAssured
        RestAssuredConfig config = RestAssuredConfig.config()
            .logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())
            .httpClient(RestAssuredConfig.config().getHttpClientConfig()
                .setParam("http.connection.timeout", connectionTimeout)
                .setParam("http.socket.timeout", readTimeout));
        
        RestAssured.config = config;
        
        // Set default headers
        RestAssured.given()
            .header("User-Agent", "QualiFrameV2-API-Test/" + getFrameworkVersion())
            .header("Accept", "application/json")
            .header("Content-Type", "application/json");
        
        logger.info("RestAssured initialized successfully");
        logger.info("Base URI: " + baseURI);
        logger.info("Connection Timeout: " + connectionTimeout + "ms");
        logger.info("Read Timeout: " + readTimeout + "ms");
    }
    
    /**
     * Set the report object for logging
     */
    public void setReport(SeleniumReport report) {
        this.report = report;
    }
    
    /**
     * Send HTTP request and get response
     */
    public ValidatableResponse sendRequest(HttpMethod method, String endpoint, 
                                         Map<String, String> headers, 
                                         Object body, 
                                         ContentType contentType) {
        
        logger.info("Sending " + method + " request to: " + endpoint);
        
        try {
            RequestSpecification request = RestAssured.given()
                .relaxedHTTPSValidation();
            
            // Add headers
            if (headers != null && !headers.isEmpty()) {
                request.headers(headers);
                logRequest("Headers", headers.toString());
            }
            
            // Add body if provided
            if (body != null) {
                request.body(body);
                logRequest("Body", body.toString());
            }
            
            // Set content type
            if (contentType != null) {
                request.contentType(getContentType(contentType));
            }
            
            // Send request based on method
            ValidatableResponse response = null;
            switch (method) {
                case GET:
                    response = request.get(endpoint).then();
                    break;
                case POST:
                    response = request.post(endpoint).then();
                    break;
                case PUT:
                    response = request.put(endpoint).then();
                    break;
                case DELETE:
                    response = request.delete(endpoint).then();
                    break;
                case PATCH:
                    response = request.patch(endpoint).then();
                    break;
                case HEAD:
                    response = request.head(endpoint).then();
                    break;
                case OPTIONS:
                    response = request.options(endpoint).then();
                    break;
                default:
                    throw new FrameworkException("Unsupported HTTP method: " + method);
            }
            
            logResponse("Status Code", String.valueOf(response.extract().statusCode()));
            logResponse("Response Time", String.valueOf(response.extract().time()) + "ms");
            
            return response;
            
        } catch (Exception e) {
            String errorMessage = e.getMessage() != null ? e.getMessage() : "Unknown error";
            logger.severe("Request failed: " + errorMessage);
            logError("Request Failed", errorMessage);
            throw new FrameworkException("API request failed: " + errorMessage);
        }
    }
    
    /**
     * Send GET request
     */
    public ValidatableResponse get(String endpoint, Map<String, String> headers) {
        return sendRequest(HttpMethod.GET, endpoint, headers, null, null);
    }
    
    /**
     * Send POST request
     */
    public ValidatableResponse post(String endpoint, Map<String, String> headers, 
                                  Object body, ContentType contentType) {
        return sendRequest(HttpMethod.POST, endpoint, headers, body, contentType);
    }
    
    /**
     * Send PUT request
     */
    public ValidatableResponse put(String endpoint, Map<String, String> headers, 
                                 Object body, ContentType contentType) {
        return sendRequest(HttpMethod.PUT, endpoint, headers, body, contentType);
    }
    
    /**
     * Send DELETE request
     */
    public ValidatableResponse delete(String endpoint, Map<String, String> headers) {
        return sendRequest(HttpMethod.DELETE, endpoint, headers, null, null);
    }
    
    /**
     * Validate response
     */
    public boolean validateResponse(ValidatableResponse response, ValidationType validationType, 
                                  String path, Object expectedValue, ComparisonOperator operator) {
        
        try {
            Object actualValue = null;
            
            switch (validationType) {
                case STATUS_CODE:
                    actualValue = response.extract().statusCode();
                    break;
                case HEADER:
                    actualValue = response.extract().header(path);
                    break;
                case BODY:
                    actualValue = response.extract().body().asString();
                    break;
                case JSON_PATH:
                    actualValue = response.extract().jsonPath().get(path);
                    break;
                case XML_PATH:
                    actualValue = response.extract().xmlPath().get(path);
                    break;
                case RESPONSE_TIME:
                    actualValue = response.extract().time();
                    break;
                default:
                    throw new FrameworkException("Unsupported validation type: " + validationType);
            }
            
            boolean isValid = compareValues(actualValue, expectedValue, operator);
            
            if (isValid) {
                logValidation("PASS", path, expectedValue, actualValue);
            } else {
                logValidation("FAIL", path, expectedValue, actualValue);
            }
            
            return isValid;
            
        } catch (Exception e) {
            String errorMessage = e.getMessage() != null ? e.getMessage() : "Unknown error";
            logger.severe("Validation failed: " + errorMessage);
            logError("Validation Failed", errorMessage);
            return false;
        }
    }
    
    /**
     * Compare values based on operator
     */
    private boolean compareValues(Object actual, Object expected, ComparisonOperator operator) {
        if (actual == null && expected == null) {
            return true;
        }
        if (actual == null || expected == null) {
            return false;
        }
        
        String actualStr = actual.toString();
        String expectedStr = expected.toString();
        
        switch (operator) {
            case EQUALS:
                return actualStr.equals(expectedStr);
            case CONTAINS:
                return actualStr.contains(expectedStr);
            case STARTS_WITH:
                return actualStr.startsWith(expectedStr);
            case ENDS_WITH:
                return actualStr.endsWith(expectedStr);
            case MATCHES:
                return actualStr.matches(expectedStr);
            case GREATER_THAN:
                return Double.parseDouble(actualStr) > Double.parseDouble(expectedStr);
            case LESS_THAN:
                return Double.parseDouble(actualStr) < Double.parseDouble(expectedStr);
            case NOT_NULL:
                return actual != null;
            case IS_EMPTY:
                return actualStr.isEmpty();
            default:
                return false;
        }
    }
    
    /**
     * Read file content for request body
     */
    public String readFileContent(String filePath) {
        try {
            Path path = Paths.get(filePath);
            if (!Files.exists(path)) {
                throw new FrameworkException("File not found: " + filePath);
            }
            
            String content = Files.readString(path);
            logRequest("File Content", "Read from: " + filePath);
            return content;
            
        } catch (IOException e) {
            String errorMessage = e.getMessage() != null ? e.getMessage() : "Unknown error";
            logger.severe("Failed to read file: " + errorMessage);
            throw new FrameworkException("Failed to read file: " + filePath);
        }
    }
    
    /**
     * Save response to file
     */
    public void saveResponseToFile(ValidatableResponse response, String filePath) {
        try {
            String responseBody = response.extract().body().asString();
            Path path = Paths.get(filePath);
            
            // Create directory if it doesn't exist
            Files.createDirectories(path.getParent());
            
            // Write response to file
            Files.write(path, responseBody.getBytes());
            
            logResponse("Saved to File", filePath);
            
        } catch (IOException e) {
            String errorMessage = e.getMessage() != null ? e.getMessage() : "Unknown error";
            logger.severe("Failed to save response to file: " + errorMessage);
            throw new FrameworkException("Failed to save response to file: " + filePath);
        }
    }
    
    /**
     * Get content type for RestAssured
     */
    private io.restassured.http.ContentType getContentType(ContentType contentType) {
        switch (contentType) {
            case JSON:
                return io.restassured.http.ContentType.JSON;
            case XML:
                return io.restassured.http.ContentType.XML;
            case TEXT:
                return io.restassured.http.ContentType.TEXT;
            case HTML:
                return io.restassured.http.ContentType.HTML;
            case FORM:
                return io.restassured.http.ContentType.URLENC;
            case MULTIPART:
                return io.restassured.http.ContentType.MULTIPART;
            case BINARY:
                return io.restassured.http.ContentType.BINARY;
            default:
                return io.restassured.http.ContentType.JSON;
        }
    }
    
    /**
     * Get framework version
     */
    private String getFrameworkVersion() {
        return properties.getProperty("framework.version", "2.0.1");
    }
    
    /**
     * Log request information
     */
    private void logRequest(String type, String message) {
        if (report != null) {
            report.updateTestLog("API Request - " + type, message, Status.INFO);
        }
        logger.info("API Request - " + type + ": " + message);
    }
    
    /**
     * Log response information
     */
    private void logResponse(String type, String message) {
        if (report != null) {
            report.updateTestLog("API Response - " + type, message, Status.INFO);
        }
        logger.info("API Response - " + type + ": " + message);
    }
    
    /**
     * Log validation result
     */
    private void logValidation(String result, String path, Object expected, Object actual) {
        String message = String.format("Path: %s, Expected: %s, Actual: %s", path, expected, actual);
        Status status = "PASS".equals(result) ? Status.PASS : Status.FAIL;
        
        if (report != null) {
            report.updateTestLog("API Validation - " + result, message, status);
        }
        logger.info("API Validation - " + result + ": " + message);
    }
    
    /**
     * Log error information
     */
    private void logError(String type, String message) {
        if (report != null) {
            report.updateTestLog("API Error - " + type, message, Status.FAIL);
        }
        logger.severe("API Error - " + type + ": " + message);
    }
    
    /**
     * Get platform information for API testing
     */
    public String getAPIPlatformInfo() {
        StringBuilder info = new StringBuilder();
        info.append("API Testing Platform Information:\n");
        info.append("  Operating System: ").append(PlatformUtils.getOperatingSystem()).append("\n");
        info.append("  Architecture: ").append(PlatformUtils.getArchitecture()).append("\n");
        info.append("  Java Version: ").append(System.getProperty("java.version")).append("\n");
        info.append("  Base URI: ").append(RestAssured.baseURI).append("\n");
        info.append("  Connection Timeout: ").append(properties.getProperty("RestAssuredConnectionTimeout", "10000")).append("ms\n");
        info.append("  Read Timeout: ").append(properties.getProperty("RestAssuredReadTimeout", "30000")).append("ms\n");
        
        return info.toString();
    }
}