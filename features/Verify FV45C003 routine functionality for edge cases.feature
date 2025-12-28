Feature: Verify FV45C003 routine functionality for edge cases  
  To ensure that the FV45C003 routine handles edge cases such as maximum data volume and special characters in partner data.

  @TC-194
  Scenario Outline: Create a Billing document with maximum data volume and special characters in partner data fields  
    Given the FV45C003 routine is configured and active  
    When the user creates a Billing document of type "<billingDocumentType>" with "<partnerData>"  
    Then the Billing document is created successfully with the specified data  

    Examples:  
      | billingDocumentType | partnerData                                |  
      | ZL2                | Maximum data volume and special characters |  

  @TC-194
  Scenario Outline: Generate a Sales document using the configured FV45C003 routine  
    Given the FV45C003 routine is configured and active  
    When the user generates a Sales document of type "<salesDocumentType>"  
    Then the Sales document is generated successfully without errors  

    Examples:  
      | salesDocumentType |  
      | ZCR              |  

  @TC-194
  Scenario Outline: Verify partner data is copied correctly to the target Sales document  
    Given a Sales document is generated using the FV45C003 routine  
    When the user verifies the partner data in the Sales document  
    Then the partner data, including "<partnerData>", is copied accurately  

    Examples:  
      | partnerData                                 |  
      | Maximum characters in Sold-to, Bill-to, Payer, Ship-to fields |  

  @TC-194
  Scenario: Check the document flow to ensure proper linkage between Billing and Sales documents  
    Given a Billing document and a Sales document are created  
    When the user checks the document flow  
    Then the document flow shows correct linkage without any issues  

  @TC-194
  Scenario: Validate system performance and response time during the process  
    Given the FV45C003 routine is configured and active  
    When the user performs the process of creating Billing and Sales documents  
    Then the system performance is within acceptable limits, and response time is not affected  

  @TC-194
  Scenario Outline: Handle edge case scenarios with empty partner data fields  
    Given the FV45C003 routine is configured and active  
    When the user creates a Billing document of type "<billingDocumentType>" with "<partnerData>"  
    Then the system handles the edge case gracefully without errors  

    Examples:  
      | billingDocumentType | partnerData       |  
      | ZL2                | Empty partner data |  

  @TC-194
  Scenario: Document the test results and provide recommendations for improving edge case handling  
    Given the tests for FV45C003 routine are completed  
    When the user documents the test results  
    Then the test results are documented, and recommendations are provided to enhance the routine's robustness