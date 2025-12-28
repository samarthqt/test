Feature: Validate FV45C003 copy routine for transferring unique partner data when header data is missing  
  Ensure the system successfully copies unique partner data from reference items to the target document header using the FV45C003 routine.

  @TC-191
  Scenario: User logs into the SAP S/4HANA Cloud system  
    Given the user has appropriate credentials  
    When the user logs into the SAP S/4HANA Cloud system  
    Then the user is successfully logged into the system  

  @TC-191
  Scenario: User navigates to the transaction for creating Sales documents  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the transaction for creating Sales documents (e.g., VA01)  
    Then the VA01 transaction screen is displayed  

  @TC-191
  Scenario Outline: Validate the FV45C003 copy routine for partner data transfer  
    Given the user is on the VA01 transaction screen  
    When the user inputs the original Billing document number "<billing_document_number>" as the reference  
    Then the system accepts the Billing document number and fetches the details  
    And the reference items contain unique partner data: "<reference_item_data>"  
    When the user verifies the absence of header partner data in the Billing document  
    Then the header partner data is confirmed as missing  
    When the user executes the creation process for the Sales document  
    Then the system begins processing the Sales document creation  
    When the user observes the system behavior as it searches for partner data in the reference items  
    Then the system identifies unique partner data in the reference items  
    When the user validates that the system copies unique partner data from reference items to the target document header  
    Then unique partner data is successfully copied to the target document header  
    When the user verifies the completion of the FV45C003 copy routine  
    Then the copy routine completes successfully without errors  
    When the user checks the target document to ensure correct partner data is present in the header  
    Then the target document contains accurate partner data in the header  

    Examples:  
      | billing_document_number | reference_item_data           |  
      | 654321                  | Item1 - Partner A, Item2 - Partner B |  

  @TC-191
  Scenario: User saves the Sales document  
    Given the user has validated the partner data in the target document header  
    When the user saves the Sales document  
    Then the Sales document is saved successfully  

  @TC-191
  Scenario: Verify linkage between Billing document and Sales document  
    Given the Sales document is saved successfully  
    When the user verifies the linkage between the Billing document and the newly created Sales document  
    Then the linkage is established correctly in the document flow  

  @TC-191
  Scenario: User logs out of the SAP S/4HANA Cloud system  
    Given the user has completed the document creation and verification process  
    When the user logs out of the SAP S/4HANA Cloud system  
    Then the user is logged out successfully