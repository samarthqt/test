Feature: Verify maximum allowable field lengths in payload processing  
  Ensure the system processes payloads with maximum allowable field lengths and data volume successfully without errors or performance degradation.

  @TC-337
  Scenario Outline: Validate payload processing with maximum allowable field lengths and data volume  
    Given the Lisbon system is active and configured to send payloads  
    When the user triggers the inbound interface from Lisbon to S/4HANA using a payload containing "<field_lengths>" and "<data_volume>"  
    Then the payload is successfully sent to the S/4HANA system  
    And the interface processes the payload without performance degradation or errors  
    And an order is created or updated in S/4HANA with all data accurately reflected  
    And no warnings or errors are logged during payload processing  
    And all data fields in the created or updated order match the payload values accurately  
    And the system processes all line items without splitting or truncation  
    And the system performance remains within acceptable thresholds  
    And no duplicate or missing records are created during the payload processing  
    And the payload adheres to the defined schema and format during processing  
    And the system demonstrates scalability without any performance bottlenecks  
    And appropriate audit logs are generated with detailed information about the payload processing  
    And the system recovers seamlessly from transient errors without data loss  

    Examples:  
      | field_lengths                 | data_volume                 |  
      | maximum allowable field lengths | maximum allowable data volume |  
      | minimum allowable field lengths | minimum allowable data volume |  
      | blank fields                  | zero data volume            |  
      | invalid field lengths         | excessive data volume       |  
      | edge case field lengths       | edge case data volume       |