Feature: Simultaneous Updates with Maximum Field Lengths  
  To verify the system processes simultaneous updates to ExternalInvoiceDate and ExternalParentDistrDebitMemoDate with maximum allowable field lengths.  

  @TC-62  
  Scenario: User logs into the SAP S/4HANA Cloud system  
    Given the user has appropriate credentials  
    When the user logs into the SAP S/4HANA Cloud system  
    Then the user is successfully logged into the system  

  @TC-62  
  Scenario: User navigates to the billing document creation screen  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the billing document creation screen  
    Then the billing document creation screen is displayed  

  @TC-62  
  Scenario: User creates an indirect sales cancellation invoice with billing type S1  
    Given the user is on the billing document creation screen  
    When the user creates an indirect sales cancellation invoice with billing type "S1"  
    Then the indirect sales cancellation invoice is successfully created with billing type "S1"  

  @TC-62  
  Scenario: User opens the newly created invoice in edit mode  
    Given the user has created an indirect sales cancellation invoice  
    When the user opens the newly created invoice in edit mode  
    Then the invoice is opened in edit mode  

  @TC-62  
  Scenario Outline: User updates ExternalInvoiceDate and ExternalParentDistrDebitMemoDate fields  
    Given the user is editing the invoice  
    When the user updates the ExternalInvoiceDate field to "<ExternalInvoiceDate>"  
    And the user updates the ExternalParentDistrDebitMemoDate field to "<ExternalParentDistrDebitMemoDate>"  
    Then both fields are updated with the maximum allowable values  

    Examples:  
      | ExternalInvoiceDate | ExternalParentDistrDebitMemoDate |  
      | 2023-12-31         | 2023-12-31                       |  

  @TC-62  
  Scenario: User saves the changes to the invoice  
    Given the user has updated the ExternalInvoiceDate and ExternalParentDistrDebitMemoDate fields  
    When the user saves the changes to the invoice  
    Then the changes are successfully saved without errors  

  @TC-62  
  Scenario: User verifies the updated values in the invoice  
    Given the user has saved the changes to the invoice  
    When the user views the updated invoice  
    Then the ExternalInvoiceDate and ExternalParentDistrDebitMemoDate fields display the updated values  

  @TC-62  
  Scenario: User checks the system logs for errors or warnings  
    Given the user has updated the invoice  
    When the user checks the system logs  
    Then no errors or warnings are logged for the updates  

  @TC-62  
  Scenario: User verifies data consistency in the relevant database tables  
    Given the user has updated the invoice  
    When the user verifies the data in the relevant database tables  
    Then the data in the database tables is consistent with the updated fields  

  @TC-62  
  Scenario: User validates invoice linkage to parent documents  
    Given the user has updated the invoice  
    When the user checks the linkage of the invoice to its parent documents  
    Then the invoice maintains correct linkage to parent documents  

  @TC-62  
  Scenario: User generates a report to confirm updates in downstream systems  
    Given the user has updated the invoice  
    When the user generates a report  
    Then the report confirms that the updates are accurately reflected in downstream systems  

  @TC-62  
  Scenario: User verifies no truncation or data corruption due to maximum field lengths  
    Given the user has updated the invoice with maximum field lengths  
    When the user verifies the fields  
    Then the field lengths are processed without truncation or data corruption