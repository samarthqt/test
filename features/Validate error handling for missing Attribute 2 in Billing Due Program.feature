Feature: Validate error handling for missing Attribute 2 in Billing Due Program  
  Ensure the system rejects missing or empty Attribute 2 values and displays appropriate error messages.  

  @TC-160  
  Scenario Outline: Validate Attribute 2 input and system behavior during Billing Due Program execution  
    Given the user logs into the SAP S/4HANA Cloud system with valid credentials  
    And the user navigates to the billing due program  
    When the user enters Attribute 1 as "<Attribute1>"  
    And the user enters Subtype as "<Subtype>"  
    And the user enters Attribute 2 as "<Attribute2>"  
    And the user executes the billing due program  
    Then the system displays the message "<SystemMessage>"  
    And the system behavior is "<SystemBehavior>"

    Examples:  
      | Attribute1 | Subtype | Attribute2 | SystemMessage                          | SystemBehavior                          |  
      | ZC         | 20      |            | Error: Missing Attribute 2            | Billing program execution halted        |  
      | ZC         | 20      | ValidData  | No errors                              | Billing program executed successfully   |  

  @TC-160  
  Scenario: Verify error details for missing Attribute 2 in system logs  
    Given the user executes the billing due program with missing Attribute 2  
    When the user checks the system logs for error details  
    Then the logs display detailed error information for missing Attribute 2  

  @TC-160  
  Scenario: Prevent further processing when Attribute 2 is missing  
    Given the user executes the billing due program with missing Attribute 2  
    When the user attempts to proceed with billing document creation  
    Then the system prevents further processing  

  @TC-160  
  Scenario: Validate successful execution after correcting Attribute 2  
    Given the user populates Attribute 2 with valid data  
    When the user re-executes the billing due program  
    Then the billing due program executes successfully with no errors  

  @TC-160  
  Scenario: Ensure no invalid billing documents are created during error  
    Given the user executes the billing due program with missing Attribute 2  
    When the user verifies the system for invalid billing documents  
    Then no invalid billing documents are present in the system  

  @TC-160  
  Scenario: Verify system readiness for further processing  
    Given the user has executed the billing due program with valid Attribute 2  
    When the user ensures the system is ready for further processing  
    Then the system is ready for further processing