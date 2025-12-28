Feature: Verify error handling for duplicate Unique Order ID  
  Ensure the system rejects the creation of a new order if the provided Unique Order ID already exists.  

  @TC-498  
  Scenario Outline: Validate error handling for duplicate Unique Order ID  
    Given the user triggers the inbound interface from Lisbon to S/4HANA with a payload containing Unique Order ID "<Unique_Order_ID>"  
    And the payload includes all mandatory fields including Sales Area "<Sales_Area>"  
    When the system processes the payload  
    Then the system identifies the duplicate Unique Order ID  
    And the system rejects the order creation and logs an error for the duplicate ID  
    And the error message in the system logs indicates that the Unique Order ID already exists  
    And no new order is created in the system  
    And the system sends an error acknowledgment back to Lisbon indicating the failure to create the order  
    And the interface logs provide details of the rejected order creation attempt  
    And the system does not create any duplicate entries in the database  
    And the system maintains consistent performance during the error handling process  
    And the error handling process adheres to the configured business rules for duplicate IDs  
    And the system logs the rejection event with a timestamp for audit purposes  

    Examples:  
      | Unique_Order_ID                          | Sales_Area     |  
      | 123e4567-e89b-12d3-a456-426614174001     | 1022/10/10     |