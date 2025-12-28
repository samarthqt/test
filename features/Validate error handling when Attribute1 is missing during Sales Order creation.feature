Feature: Validate error handling when Attribute1 is missing during Sales Order creation  
  Ensure the system displays an error message and prevents Sales Order creation when Attribute1 is missing. Sales Order type ZOR must be configured in the system.

  @TC-147
  Scenario Outline: Validate Sales Order creation with missing or provided Attribute1  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the Sales Order creation module  
    And the user attempts to create a new Sales Order of type "<SalesOrderType>" with Attribute1 set to "<Attribute1>"  
    Then the system displays the message "<Message>"  
    And the system "<Action>" the Sales Order  

    Examples:  
      | SalesOrderType | Attribute1 | Message                                  | Action              |  
      | ZOR            | Missing    | Attribute1 is mandatory                 | prevents saving     |  
      | ZOR            | Provided   | Sales Order created successfully        | allows saving       |  

  @TC-147
  Scenario: Verify system logs for missing Attribute1  
    Given the user attempts to create a Sales Order of type ZOR without setting Attribute1  
    When the user checks the system logs  
    Then the system logs show an error entry for the missing Attribute1  

  @TC-147
  Scenario: Edit Sales Order to add missing Attribute1  
    Given the user has created a Sales Order of type ZOR with missing Attribute1  
    When the user edits the Sales Order and adds Attribute1  
    Then the system allows editing and Attribute1 is added  

  @TC-147
  Scenario: Save Sales Order after adding Attribute1  
    Given the user has added Attribute1 to the Sales Order  
    When the user saves the Sales Order  
    Then the Sales Order is saved successfully  

  @TC-147
  Scenario: Trigger billing due program for corrected Sales Order  
    Given the user has corrected the Sales Order by adding Attribute1  
    When the user triggers the billing due program  
    Then the billing due program is executed successfully  

  @TC-147
  Scenario: Verify billing document creation for corrected Sales Order  
    Given the user has triggered the billing due program for the corrected Sales Order  
    When the user checks the billing documents  
    Then a billing document of type ZF2 is created successfully  

  @TC-147
  Scenario: Validate content of the generated billing document  
    Given a billing document of type ZF2 is created for the corrected Sales Order  
    When the user validates the content of the billing document  
    Then the billing document content matches the defined rules and mappings  

  @TC-147
  Scenario: Check document flow for proper linkage  
    Given the user has created a billing document for the corrected Sales Order  
    When the user checks the document flow  
    Then the document flow shows correct linkage between the corrected Sales Order and the billing document  

  @TC-147
  Scenario: Ensure compliance with formatting and content standards  
    Given the user has created a billing document of type ZF2  
    When the user verifies the document compliance  
    Then the billing document complies with the organization's formatting and content standards