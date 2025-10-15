Feature: Verify VBRK-KUNAG and VBRK-REGIO fields are cleared for ZF2C billing document type  
  Ensure that VBRK-KUNAG and VBRK-REGIO fields are cleared when creating a billing document with type ZF2C.  

  @TC-458  
  Scenario Outline: Validate VBRK-KUNAG and VBRK-REGIO fields are cleared for ZF2C billing document type  
    Given the user logs into the SAP S/4HANA system with valid credentials  
    And a source sales order or billing document <Source Sales Order> exists with populated VBRK-KUNAG and VBRK-REGIO fields  
    When the user navigates to the billing document creation transaction  
    And the user inputs the source sales order number "<Source Sales Order>" in the relevant field  
    And the user sets the target billing document type to "<Billing Document Type>"  
    And the user executes the process to create the billing document  
    Then the billing document is successfully created  
    When the user navigates to the display billing document transaction  
    And the user retrieves the newly created billing document by entering its document number  
    Then the VBRK-KUNAG field in the billing document header is empty  
    And the VBRK-REGIO field in the billing document header is empty  
    And no additional customer or region data is carried forward  

    Examples:  
      | Source Sales Order | Billing Document Type |  
      | SO12345            | ZF2C                 |  

  @TC-458  
  Scenario: Log the results of the test case execution  
    Given the user has validated the VBRK-KUNAG and VBRK-REGIO fields are cleared  
    When the user logs the results of the test case execution  
    Then the test case results are logged successfully  

  @TC-458  
  Scenario: Logout from the SAP S/4HANA system  
    Given the user has completed the test case execution  
    When the user logs out from the SAP S/4HANA system  
    Then the user is logged out of the system