Feature: Validate successful Invoice List generation with maximum linked invoices  
  To ensure the system generates an Invoice List output with the maximum number of linked invoices efficiently and without errors.  
  Ensure the system is configured to handle the maximum number of invoices linked to a single invoice list document.  

  @TC-202  
  Scenario Outline: Validate Invoice List generation with maximum linked invoices  
    Given the user logs in to the SAP S/4HANA system with valid credentials  
    When the user navigates to the VF23 transaction  
    And the user inputs the invoice list document number "<invoice_list_document_number>"  
    And the user executes the transaction to trigger the Invoice List output  
    Then the system processes the Invoice List output generation request  
    And the output contains all "<maximum_linked_invoices>" linked invoices without any missing entries  
    And the system performs efficiently without any noticeable delays or performance degradation  
    And the output format and content meet the predefined requirements and standards  
    And the system logs indicate successful processing without any errors or warnings  
    When the user re-triggers the output for the same Invoice List document  
    Then the system allows re-triggering and generates the output successfully again  
    And the output remains consistent across multiple generations  

    Examples:  
      | invoice_list_document_number | maximum_linked_invoices |  
      | INVLIST_MAX                  | 1000                    |  

  @TC-202  
  Scenario: Document the test results and log out of the system  
    Given the user has completed the Invoice List generation process  
    When the user documents the test results and observations  
    Then the test results and observations are documented for further analysis  
    And the user logs out of the SAP S/4HANA system  
    Then the user is successfully logged out of the system