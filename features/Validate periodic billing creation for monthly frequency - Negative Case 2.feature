Feature: Validate periodic billing creation for monthly frequency - Negative Case 2  
  Ensure the system does not generate billing documents when the billing due program is inactive and Attribute 3 is set to 'ZM' for the Ship-to BP.

  @TC-573
  Scenario: User logs into the SAP S/4HANA Cloud system with valid credentials  
    Given the user has valid credentials for the SAP S/4HANA Cloud system  
    When the user logs into the system  
    Then the user is successfully logged in and navigates to the home screen  
    And the Ship-to BP has Attribute 3 set to 'ZM'  

  @TC-573
  Scenario: User navigates to the billing due program  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the billing due program  
    Then the billing due program screen is displayed  
    And a set of sales orders eligible for billing is visible  

  @TC-573
  Scenario: User deactivates the billing due program  
    Given the user is on the billing due program screen  
    When the user deactivates the billing due program  
    Then the billing due program is deactivated successfully  

  @TC-573
  Scenario: User attempts to execute the billing due program in foreground mode when it is inactive  
    Given the billing due program is deactivated  
    When the user attempts to execute the billing due program in foreground mode  
    Then the program does not execute  
    And an error message is displayed  

  @TC-573
  Scenario: User checks the error logs for details  
    Given the billing due program execution failed  
    When the user checks the error logs  
    Then the error logs provide detailed information about the issue  

  @TC-573
  Scenario: User documents the test results and observations  
    Given the user has completed testing the billing due program  
    When the user documents the test results and observations  
    Then the test results and observations are documented accurately