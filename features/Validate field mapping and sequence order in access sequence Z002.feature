Feature: Validate field mapping and sequence order in access sequence Z002  
  Ensure that field mapping and sequence order for condition table 911 are correctly defined within access sequence Z002.

  @TC-293  
  Scenario: User navigates to access sequence maintenance screen  
    Given the user navigates to transaction "V/07" for maintaining access sequences  
    Then the access sequence maintenance screen is displayed  
    And the access sequence "Z002" is available for editing  

  @TC-293  
  Scenario: User selects access sequence Z002 for editing  
    Given the user searches for and selects access sequence "Z002"  
    Then the access sequence "Z002" is displayed for editing  
    And the user has authorization to modify access sequences  

  @TC-293  
  Scenario: User adds condition table 911 to access sequence Z002  
    Given the user adds condition table "911" to the access sequence "Z002"  
    Then condition table "911" is added to the access sequence  
    And the field mapping includes "Sales Org," "Billing Type," and "Attribute 7"  

  @TC-293  
  Scenario Outline: User defines field mapping for condition table 911  
    Given the user defines the field mapping for condition table "911" with the following fields:  
      | Field Name   | Value          |  
      | Sales Org    | <SalesOrg>     |  
      | Billing Type | <BillingType>  |  
      | Attribute 7  | <Attribute7>   |  
    Then the field mapping is defined successfully  

    Examples:  
      | SalesOrg | BillingType | Attribute7 |  
      | SO01     | BT01        | A7Value1   |  
      | SO02     | BT02        | A7Value2   |  

  @TC-293  
  Scenario: User verifies field mapping is saved and displayed correctly  
    Given the user verifies that the field mapping for condition table "911" is saved  
    Then the field mapping is displayed correctly in the access sequence  

  @TC-293  
  Scenario Outline: User sets sequence order for condition table 911  
    Given the user sets the sequence order for condition table "911" within access sequence "Z002" to "<SequenceOrder>"  
    Then the sequence order is set correctly  

    Examples:  
      | SequenceOrder |  
      | 1            |  
      | 2            |  

  @TC-293  
  Scenario: User saves changes to access sequence Z002  
    Given the user saves the changes to access sequence "Z002"  
    Then the changes are saved successfully  

  @TC-293  
  Scenario: User activates access sequence Z002  
    Given the user activates access sequence "Z002"  
    Then the access sequence "Z002" is activated  

  @TC-293  
  Scenario Outline: User verifies field mapping during output determination  
    Given the user creates a billing document  
    When the user verifies the field mapping during output determination  
    Then the field mapping is correctly referenced  

    Examples:  
      | BillingDocumentID |  
      | BD001             |  
      | BD002             |  

  @TC-293  
  Scenario Outline: User validates sequence order during output determination  
    Given the user validates the sequence order for condition table "911" in the output determination process  
    Then the sequence order "<SequenceOrder>" is correctly applied  

    Examples:  
      | SequenceOrder |  
      | 1            |  
      | 2            |  

  @TC-293  
  Scenario: User tests field mapping and sequence order consistency  
    Given the user tests additional scenarios to ensure field mapping and sequence order work consistently  
    Then the field mapping and sequence order behave consistently across scenarios  

  @TC-293  
  Scenario: User documents results and confirms configuration  
    Given the user documents the test results  
    Then the configuration for access sequence "Z002" is confirmed successfully