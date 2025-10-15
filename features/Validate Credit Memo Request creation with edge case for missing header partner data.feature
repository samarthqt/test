Feature: Validate Credit Memo Request creation with edge case for missing header partner data  
  Ensure the system handles the creation process when header partner data is missing but item-level partner data is unique.

  @TC-185
  Scenario Outline: Validate Credit Memo Request creation with missing header partner data  
    Given the user navigates to transaction VA01 to create a Credit Memo Request  
    When the user inputs the original Billing document number "<Billing Document Number>" as the reference  
    Then the reference details are loaded and the Billing document number is accepted  
    And the user verifies that header-level partner data is missing  
    And the user validates that item-level partner data is unique and sufficient for processing  
    When the user executes the creation process for the Credit Memo Request  
    Then the Credit Memo Request is created successfully using item-level partner data  
    And the user validates that item-level partner data is correctly copied to header-level fields  
    And the user verifies that the referenced sales orders are visible in the 'display billing detail' report  
    And the user checks the linkage between the Credit Memo Request and the original Billing document in the document flow  
    And the user validates that financial postings associated with the Credit Memo Request are accurate  
    And the user verifies that the Credit Memo Request adheres to the configured copy routine "<Copy Routine>"  
    And the user checks for any errors or warnings in the system during the creation process  
    And the user validates the audit trail for the creation of the Credit Memo Request  

    Examples:  
      | Billing Document Number | Copy Routine |  
      | 100000003               | FV45C003     |