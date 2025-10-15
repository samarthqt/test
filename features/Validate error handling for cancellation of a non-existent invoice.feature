Feature: Validate error handling for cancellation of a non-existent invoice  
  Ensure that the system prevents cancellation of a non-existent invoice and displays appropriate error messages.  

  @TC-5  
  Scenario Outline: User attempts to cancel a non-existent invoice  
    Given user logs in to the SAP system with valid credentials  
    When user navigates to the VF11 transaction for invoice cancellation  
    And user enters the invoice number "<Invoice Number>" in the cancellation screen  
    And user selects the cancellation document type "<Cancellation Document Type>"  
    And user initiates the cancellation process  
    Then system displays an error message "<Error Message>"  
    And no cancellation billing document is created  
    And system logs contain detailed error messages about the non-existent invoice  
    And user attempts to navigate to the document flow for the invoice  
    Then system displays an error message "<Document Flow Error Message>"  
    And financial postings remain unaffected  

    Examples:  
      | Invoice Number | Cancellation Document Type | Error Message                   | Document Flow Error Message      |  
      | INV99999       | S1                         | Invoice does not exist         | Document does not exist          |  

  @TC-5  
  Scenario: User logs out of the SAP system  
    Given user is logged into the SAP system  
    When user logs out of the SAP system  
    Then user is logged out successfully