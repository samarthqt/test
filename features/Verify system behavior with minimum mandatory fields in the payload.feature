Feature: Verify system behavior with minimum mandatory fields in the payload  
  Ensure the system processes the order creation correctly when the payload contains only the minimum mandatory fields.  

  @TC-501  
  Scenario Outline: Validate order creation with minimum mandatory fields in the payload  
    Given the user triggers the inbound interface from Lisbon to S/4HANA with a payload containing "<Order ID>" and "<Sales Area>"  
    When the payload is sent for processing  
    Then the system processes the payload successfully without errors  
    And a new standard order (ZOR) is created in the S/4HANA system  
    And the created order is assigned the correct "<Sales Area>"  
    And the order details match the information provided in the payload  
    And the system generates a unique order number for the new ZOR order  
    And the order creation is logged in the system for traceability  
    And the interface logs indicate successful processing without critical warnings  
    And the created order adheres to the standard order format (ZOR)  
    And the system sends an acknowledgment back to Lisbon confirming the successful creation of the order  

    Examples:  
      | Order ID                                  | Sales Area   |  
      | 123e4567-e89b-12d3-a456-426614174004     | 1022/10/10   |  

  @TC-501  
  Scenario: Verify system processes minimal payload efficiently  
    Given the user sends a payload with only minimum mandatory fields  
    When the system processes the payload  
    Then the system creates the order successfully without any errors  
    And the system processes the minimal payload efficiently