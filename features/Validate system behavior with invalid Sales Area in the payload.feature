Feature: Validate system behavior with invalid Sales Area in the payload  
  Ensure the system rejects the order creation if the provided Sales Area is invalid or not configured.

  @TC-499
  Scenario Outline: Verify system processing and error handling for invalid Sales Area  
    Given the user triggers the inbound interface from Lisbon to S/4HANA with a payload containing Sales Area "<Sales Area>"  
    And the payload includes all mandatory fields, including the Sales Area details  
    When the system processes the payload  
    Then the system identifies the Sales Area as "<Validation Result>"  
    And the system does not create a new order  
    And an error message "<Error Message>" is logged in the system  
    And the system sends an error acknowledgment back to Lisbon  
    And the interface logs contain details of the rejected order creation attempt  
    And the system does not create any entries in the database for the invalid order  
    And the system maintains consistent performance during the error handling process  
    And the error handling process adheres to the configured business rules  
    And the rejection event is logged with a timestamp for audit purposes  

    Examples:  
      | Sales Area  | Validation Result          | Error Message                          |  
      | 9999/99/99  | invalid or not configured | Sales Area is invalid or not configured |  
      | 1022/10/10  | valid                     | No error                                |