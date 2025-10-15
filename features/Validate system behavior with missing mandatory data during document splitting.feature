Feature: Validate system behavior with missing mandatory data during document splitting  
  Ensure the system does not create billing documents and displays appropriate error messages when mandatory data is missing.

  @TC-176
  Scenario Outline: Validate error handling for missing mandatory data in source document  
    Given the user navigates to the billing due program in SAP S/4HANA  
    And the billing due program interface is displayed  
    When the user selects a source document with "<missing_data>"  
    Then the system displays an error message indicating the missing mandatory data  
    And no billing documents are created or posted to accounting  
    And the logs contain detailed information about the missing mandatory data  
    And the error message includes guidance on how to resolve the issue  

    Examples:  
      | missing_data             |  
      | missing pricing data     |  
      | incomplete customer data |  

  @TC-176
  Scenario: Validate successful processing after correcting missing mandatory data  
    Given the user navigates to the billing due program in SAP S/4HANA  
    And the billing due program interface is displayed  
    And the user selects a source document with corrected mandatory data  
    When the user executes the program to create billing documents  
    Then the system processes the corrected source document successfully  
    And billing documents are created successfully for the corrected source document  
    And the document flow shows proper linkage for the corrected source document  
    And accounting documents are correctly generated for the corrected billing documents  
    And the logs indicate that the error was resolved and the source document was successfully processed