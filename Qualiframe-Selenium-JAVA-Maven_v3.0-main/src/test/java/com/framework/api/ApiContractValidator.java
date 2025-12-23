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

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.responses.ApiResponse;
// import io.swagger.v3.parser.exception.OpenAPIParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.net.URL;

/**
 * API Contract Validator for OpenAPI/Swagger specification validation
 * 
 * <h2>Features:</h2>
 * <ul>
 *   <li><strong>OpenAPI Validation:</strong> Validates API responses against OpenAPI specifications</li>
 *   <li><strong>Schema Validation:</strong> Validates request/response schemas</li>
 *   <li><strong>Parameter Validation:</strong> Validates path, query, and header parameters</li>
 *   <li><strong>Response Validation:</strong> Validates response codes and content</li>
 *   <li><strong>Contract Testing:</strong> Ensures API contracts are maintained</li>
 * </ul>
 * 
 * @author Qualitest
 * @version 2.1.0
 * @since 2024
 */
public class ApiContractValidator {
    
    private static final Logger logger = LogManager.getLogger(ApiContractValidator.class);
    private OpenAPI openAPI;
    private Map<String, Object> validationResults = new HashMap<>();
    
    /**
     * Constructor with OpenAPI specification file
     * 
     * @param specFilePath Path to OpenAPI specification file
     * @throws Exception if specification parsing fails
     */
    public ApiContractValidator(String specFilePath) throws Exception {
        loadOpenAPISpecification(specFilePath);
    }
    
    /**
     * Load OpenAPI specification
     * 
     * @param specPath Path or URL to OpenAPI specification
     * @throws Exception if specification parsing fails
     */
    private void loadOpenAPISpecification(String specPath) throws Exception {
        try {
            OpenAPIParser parser = new OpenAPIParser();
            this.openAPI = parser.readLocation(specPath, null, null).getOpenAPI();
            logger.info("OpenAPI specification loaded successfully from: {}", specPath);
        } catch (Exception e) {
            logger.error("Failed to load OpenAPI specification from: {}", specPath, e);
            throw new Exception("Failed to load OpenAPI specification", e);
        }
    }
    
    /**
     * Validate API response against OpenAPI specification
     * 
     * @param path The API path
     * @param method The HTTP method
     * @param statusCode The response status code
     * @param responseBody The response body
     * @param responseHeaders The response headers
     * @return Validation result
     */
    public ValidationResult validateResponse(String path, String method, int statusCode, 
                                           String responseBody, Map<String, String> responseHeaders) {
        ValidationResult result = new ValidationResult();
        
        try {
            // Get path item from specification
            PathItem pathItem = openAPI.getPaths().get(path);
            if (pathItem == null) {
                result.addError("Path not found in specification: " + path);
                return result;
            }
            
            // Get operation based on method
            Operation operation = getOperation(pathItem, method);
            if (operation == null) {
                result.addError("Method not found in specification: " + method + " for path: " + path);
                return result;
            }
            
            // Validate status code
            validateStatusCode(operation, statusCode, result);
            
            // Validate response body
            validateResponseBody(operation, statusCode, responseBody, result);
            
            // Validate response headers
            validateResponseHeaders(operation, statusCode, responseHeaders, result);
            
            logger.debug("API response validation completed for {} {}", method, path);
            
        } catch (Exception e) {
            result.addError("Validation error: " + e.getMessage());
            logger.error("Error during API response validation", e);
        }
        
        return result;
    }
    
    /**
     * Validate API request against OpenAPI specification
     * 
     * @param path The API path
     * @param method The HTTP method
     * @param requestBody The request body
     * @param requestHeaders The request headers
     * @param pathParams The path parameters
     * @param queryParams The query parameters
     * @return Validation result
     */
    public ValidationResult validateRequest(String path, String method, String requestBody,
                                          Map<String, String> requestHeaders, Map<String, String> pathParams,
                                          Map<String, String> queryParams) {
        ValidationResult result = new ValidationResult();
        
        try {
            // Get path item from specification
            PathItem pathItem = openAPI.getPaths().get(path);
            if (pathItem == null) {
                result.addError("Path not found in specification: " + path);
                return result;
            }
            
            // Get operation based on method
            Operation operation = getOperation(pathItem, method);
            if (operation == null) {
                result.addError("Method not found in specification: " + method + " for path: " + path);
                return result;
            }
            
            // Validate path parameters
            validatePathParameters(operation, pathParams, result);
            
            // Validate query parameters
            validateQueryParameters(operation, queryParams, result);
            
            // Validate request headers
            validateRequestHeaders(operation, requestHeaders, result);
            
            // Validate request body
            validateRequestBody(operation, requestBody, result);
            
            logger.debug("API request validation completed for {} {}", method, path);
            
        } catch (Exception e) {
            result.addError("Validation error: " + e.getMessage());
            logger.error("Error during API request validation", e);
        }
        
        return result;
    }
    
    /**
     * Get operation from path item
     * 
     * @param pathItem The path item
     * @param method The HTTP method
     * @return Operation object
     */
    private Operation getOperation(PathItem pathItem, String method) {
        switch (method.toUpperCase()) {
            case "GET":
                return pathItem.getGet();
            case "POST":
                return pathItem.getPost();
            case "PUT":
                return pathItem.getPut();
            case "DELETE":
                return pathItem.getDelete();
            case "PATCH":
                return pathItem.getPatch();
            default:
                return null;
        }
    }
    
    /**
     * Validate status code
     * 
     * @param operation The operation
     * @param statusCode The status code
     * @param result The validation result
     */
    private void validateStatusCode(Operation operation, int statusCode, ValidationResult result) {
        Map<String, ApiResponse> responses = operation.getResponses();
        
        if (responses == null || responses.isEmpty()) {
            result.addWarning("No response definitions found in specification");
            return;
        }
        
        String statusCodeStr = String.valueOf(statusCode);
        if (!responses.containsKey(statusCodeStr)) {
            // Check for default response
            if (!responses.containsKey("default")) {
                result.addError("Status code " + statusCode + " not defined in specification");
            } else {
                result.addWarning("Status code " + statusCode + " not explicitly defined, using default");
            }
        }
    }
    
    /**
     * Validate response body
     * 
     * @param operation The operation
     * @param statusCode The status code
     * @param responseBody The response body
     * @param result The validation result
     */
    private void validateResponseBody(Operation operation, int statusCode, String responseBody, ValidationResult result) {
        Map<String, ApiResponse> responses = operation.getResponses();
        String statusCodeStr = String.valueOf(statusCode);
        
        ApiResponse apiResponse = responses.get(statusCodeStr);
        if (apiResponse == null) {
            apiResponse = responses.get("default");
        }
        
        if (apiResponse == null) {
            result.addWarning("No response definition found for status code: " + statusCode);
            return;
        }
        
        Content content = apiResponse.getContent();
        if (content == null || content.isEmpty()) {
            result.addWarning("No content definition found for status code: " + statusCode);
            return;
        }
        
        // Validate against content type schemas
        for (Map.Entry<String, MediaType> entry : content.entrySet()) {
            String contentType = entry.getKey();
            MediaType mediaType = entry.getValue();
            
            if (mediaType.getSchema() != null) {
                validateSchema(mediaType.getSchema(), responseBody, contentType, result);
            }
        }
    }
    
    /**
     * Validate response headers
     * 
     * @param operation The operation
     * @param statusCode The status code
     * @param responseHeaders The response headers
     * @param result The validation result
     */
    private void validateResponseHeaders(Operation operation, int statusCode, Map<String, String> responseHeaders, ValidationResult result) {
        Map<String, ApiResponse> responses = operation.getResponses();
        String statusCodeStr = String.valueOf(statusCode);
        
        ApiResponse apiResponse = responses.get(statusCodeStr);
        if (apiResponse == null) {
            apiResponse = responses.get("default");
        }
        
        if (apiResponse == null || apiResponse.getHeaders() == null) {
            return;
        }
        
        // Validate required headers
        for (Map.Entry<String, io.swagger.v3.oas.models.headers.Header> entry : apiResponse.getHeaders().entrySet()) {
            String headerName = entry.getKey();
            io.swagger.v3.oas.models.headers.Header header = entry.getValue();
            
            if (header.getRequired() != null && header.getRequired() && !responseHeaders.containsKey(headerName)) {
                result.addError("Required header missing: " + headerName);
            }
        }
    }
    
    /**
     * Validate path parameters
     * 
     * @param operation The operation
     * @param pathParams The path parameters
     * @param result The validation result
     */
    private void validatePathParameters(Operation operation, Map<String, String> pathParams, ValidationResult result) {
        if (operation.getParameters() == null) {
            return;
        }
        
        for (Parameter parameter : operation.getParameters()) {
            if ("path".equals(parameter.getIn())) {
                String paramName = parameter.getName();
                
                if (parameter.getRequired() != null && parameter.getRequired() && !pathParams.containsKey(paramName)) {
                    result.addError("Required path parameter missing: " + paramName);
                }
                
                if (pathParams.containsKey(paramName) && parameter.getSchema() != null) {
                    validateParameterSchema(parameter.getSchema(), pathParams.get(paramName), result);
                }
            }
        }
    }
    
    /**
     * Validate query parameters
     * 
     * @param operation The operation
     * @param queryParams The query parameters
     * @param result The validation result
     */
    private void validateQueryParameters(Operation operation, Map<String, String> queryParams, ValidationResult result) {
        if (operation.getParameters() == null) {
            return;
        }
        
        for (Parameter parameter : operation.getParameters()) {
            if ("query".equals(parameter.getIn())) {
                String paramName = parameter.getName();
                
                if (parameter.getRequired() != null && parameter.getRequired() && !queryParams.containsKey(paramName)) {
                    result.addError("Required query parameter missing: " + paramName);
                }
                
                if (queryParams.containsKey(paramName) && parameter.getSchema() != null) {
                    validateParameterSchema(parameter.getSchema(), queryParams.get(paramName), result);
                }
            }
        }
    }
    
    /**
     * Validate request headers
     * 
     * @param operation The operation
     * @param requestHeaders The request headers
     * @param result The validation result
     */
    private void validateRequestHeaders(Operation operation, Map<String, String> requestHeaders, ValidationResult result) {
        if (operation.getParameters() == null) {
            return;
        }
        
        for (Parameter parameter : operation.getParameters()) {
            if ("header".equals(parameter.getIn())) {
                String paramName = parameter.getName();
                
                if (parameter.getRequired() != null && parameter.getRequired() && !requestHeaders.containsKey(paramName)) {
                    result.addError("Required header missing: " + paramName);
                }
                
                if (requestHeaders.containsKey(paramName) && parameter.getSchema() != null) {
                    validateParameterSchema(parameter.getSchema(), requestHeaders.get(paramName), result);
                }
            }
        }
    }
    
    /**
     * Validate request body
     * 
     * @param operation The operation
     * @param requestBody The request body
     * @param result The validation result
     */
    private void validateRequestBody(Operation operation, String requestBody, ValidationResult result) {
        if (operation.getRequestBody() == null || operation.getRequestBody().getContent() == null) {
            return;
        }
        
        Content content = operation.getRequestBody().getContent();
        for (Map.Entry<String, MediaType> entry : content.entrySet()) {
            String contentType = entry.getKey();
            MediaType mediaType = entry.getValue();
            
            if (mediaType.getSchema() != null) {
                validateSchema(mediaType.getSchema(), requestBody, contentType, result);
            }
        }
    }
    
    /**
     * Validate schema
     * 
     * @param schema The schema
     * @param data The data to validate
     * @param contentType The content type
     * @param result The validation result
     */
    private void validateSchema(Schema schema, String data, String contentType, ValidationResult result) {
        // Basic schema validation
        if (schema.getType() != null) {
            validateType(schema.getType(), data, result);
        }
        
        if (schema.getFormat() != null) {
            validateFormat(schema.getFormat(), data, result);
        }
        
        if (schema.getPattern() != null) {
            validatePattern(schema.getPattern(), data, result);
        }
        
        if (schema.getMinLength() != null && data.length() < schema.getMinLength()) {
            result.addError("Data length " + data.length() + " is less than minimum " + schema.getMinLength());
        }
        
        if (schema.getMaxLength() != null && data.length() > schema.getMaxLength()) {
            result.addError("Data length " + data.length() + " is greater than maximum " + schema.getMaxLength());
        }
    }
    
    /**
     * Validate parameter schema
     * 
     * @param schema The schema
     * @param value The parameter value
     * @param result The validation result
     */
    private void validateParameterSchema(Schema schema, String value, ValidationResult result) {
        if (schema.getType() != null) {
            validateType(schema.getType(), value, result);
        }
        
        if (schema.getFormat() != null) {
            validateFormat(schema.getFormat(), value, result);
        }
        
        if (schema.getPattern() != null) {
            validatePattern(schema.getPattern(), value, result);
        }
    }
    
    /**
     * Validate data type
     * 
     * @param type The expected type
     * @param data The data to validate
     * @param result The validation result
     */
    private void validateType(String type, String data, ValidationResult result) {
        switch (type.toLowerCase()) {
            case "string":
                // String is always valid
                break;
            case "integer":
                try {
                    Integer.parseInt(data);
                } catch (NumberFormatException e) {
                    result.addError("Expected integer, got: " + data);
                }
                break;
            case "number":
                try {
                    Double.parseDouble(data);
                } catch (NumberFormatException e) {
                    result.addError("Expected number, got: " + data);
                }
                break;
            case "boolean":
                if (!"true".equalsIgnoreCase(data) && !"false".equalsIgnoreCase(data)) {
                    result.addError("Expected boolean, got: " + data);
                }
                break;
        }
    }
    
    /**
     * Validate data format
     * 
     * @param format The expected format
     * @param data The data to validate
     * @param result The validation result
     */
    private void validateFormat(String format, String data, ValidationResult result) {
        switch (format.toLowerCase()) {
            case "email":
                if (!isValidEmail(data)) {
                    result.addError("Invalid email format: " + data);
                }
                break;
            case "uri":
                if (!isValidUri(data)) {
                    result.addError("Invalid URI format: " + data);
                }
                break;
            case "date":
                if (!isValidDate(data)) {
                    result.addError("Invalid date format: " + data);
                }
                break;
            case "date-time":
                if (!isValidDateTime(data)) {
                    result.addError("Invalid date-time format: " + data);
                }
                break;
        }
    }
    
    /**
     * Validate pattern
     * 
     * @param pattern The regex pattern
     * @param data The data to validate
     * @param result The validation result
     */
    private void validatePattern(String pattern, String data, ValidationResult result) {
        try {
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(data);
            if (!matcher.matches()) {
                result.addError("Data does not match pattern " + pattern + ": " + data);
            }
        } catch (Exception e) {
            result.addWarning("Invalid regex pattern: " + pattern);
        }
    }
    
    /**
     * Check if email is valid
     * 
     * @param email The email to validate
     * @return true if valid, false otherwise
     */
    private boolean isValidEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailPattern);
    }
    
    /**
     * Check if URI is valid
     * 
     * @param uri The URI to validate
     * @return true if valid, false otherwise
     */
    private boolean isValidUri(String uri) {
        try {
            new java.net.URI(uri);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Check if date is valid
     * 
     * @param date The date to validate
     * @return true if valid, false otherwise
     */
    private boolean isValidDate(String date) {
        try {
            java.time.LocalDate.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Check if date-time is valid
     * 
     * @param dateTime The date-time to validate
     * @return true if valid, false otherwise
     */
    private boolean isValidDateTime(String dateTime) {
        try {
            java.time.Instant.parse(dateTime);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Get all available paths from specification
     * 
     * @return Set of available paths
     */
    public Set<String> getAvailablePaths() {
        if (openAPI.getPaths() == null) {
            return new HashSet<>();
        }
        return openAPI.getPaths().keySet();
    }
    
    /**
     * Get available methods for a path
     * 
     * @param path The API path
     * @return Set of available methods
     */
    public Set<String> getAvailableMethods(String path) {
        Set<String> methods = new HashSet<>();
        PathItem pathItem = openAPI.getPaths().get(path);
        
        if (pathItem != null) {
            if (pathItem.getGet() != null) methods.add("GET");
            if (pathItem.getPost() != null) methods.add("POST");
            if (pathItem.getPut() != null) methods.add("PUT");
            if (pathItem.getDelete() != null) methods.add("DELETE");
            if (pathItem.getPatch() != null) methods.add("PATCH");
        }
        
        return methods;
    }
    
    /**
     * Validation result class
     */
    public static class ValidationResult {
        private List<String> errors = new ArrayList<>();
        private List<String> warnings = new ArrayList<>();
        
        public void addError(String error) {
            errors.add(error);
        }
        
        public void addWarning(String warning) {
            warnings.add(warning);
        }
        
        public List<String> getErrors() {
            return errors;
        }
        
        public List<String> getWarnings() {
            return warnings;
        }
        
        public boolean isValid() {
            return errors.isEmpty();
        }
        
        public boolean hasWarnings() {
            return !warnings.isEmpty();
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (!errors.isEmpty()) {
                sb.append("Errors:\n");
                for (String error : errors) {
                    sb.append("  - ").append(error).append("\n");
                }
            }
            if (!warnings.isEmpty()) {
                sb.append("Warnings:\n");
                for (String warning : warnings) {
                    sb.append("  - ").append(warning).append("\n");
                }
            }
            return sb.toString();
        }
    }
}