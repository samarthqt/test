Feature: Validate system behavior with missing Attribute2 in Sales Order  
  Ensure the system displays appropriate error messages and halts the billing due program when Attribute2 is missing.  

  @TC-150  
  Scenario: User logs into the SAP S/4HANA Cloud system  
    Given the user has valid credentials  
    When the user logs into the SAP S/4HANA Cloud system  
    Then the user gains access to the system dashboard  

  @TC-150  
  Scenario: User navigates to the Sales Order creation screen  
    Given the user is on the system dashboard  
    When the user navigates to the Sales Order creation screen  
    Then the Sales Order creation screen is displayed  

  @TC-150  
  Scenario Outline: User creates a Sales Order of type ZOR with various Attribute2 values  
    Given the user is on the Sales Order creation screen  
    When the user creates a Sales Order of type ZOR with Attribute1 as "<Attribute1>" and Attribute2 as "<Attribute2>"  
    Then the Sales Order is created with Attribute2 as "<Attribute2>"  
    And the Sales Order is saved successfully with a unique Order ID  

    Examples:  
      | Attribute1     | Attribute2  |  
      | ValidValue     | <missing>   |  
      | ValidValue     | ValidValue  |  

  @TC-150  
  Scenario: User navigates to the billing due program screen  
    Given the user is on the system dashboard  
    When the user navigates to the billing due program screen  
    Then the billing due program screen is displayed  

  @TC-150  
  Scenario Outline: User triggers the billing due program for a Sales Order  
    Given the user is on the billing due program screen  
    When the user triggers the billing due program for the Sales Order with Attribute2 as "<Attribute2>"  
    Then the billing due program "<ProgramOutcome>"  
    And the system displays "<ErrorMessage>"  

    Examples:  
      | Attribute2  | ProgramOutcome            | ErrorMessage                     |  
      | <missing>   | halts execution           | Error: Missing Attribute2        |  
      | ValidValue  | completes successfully    | No errors                        |  

  @TC-150  
  Scenario: User captures the displayed error message  
    Given the billing due program halts execution and displays an error message  
    When the user captures the displayed error message  
    Then the error message is captured successfully  

  @TC-150  
  Scenario: User navigates to the error log screen  
    Given the user is on the system dashboard  
    When the user navigates to the error log screen  
    Then the error log screen is displayed  

  @TC-150  
  Scenario: User verifies the error log for the captured error message  
    Given the user is on the error log screen  
    When the user verifies the error log for the captured error message  
    Then the error log contains the captured error message indicating missing Attribute2  

  @TC-150  
  Scenario Outline: User resolves the error by editing the Sales Order  
    Given the user is on the Sales Order edit screen  
    When the user edits the Sales Order with Order ID "<OrderID>" and adds Attribute2 as "<Attribute2>"  
    Then the Sales Order is updated successfully with Attribute2  

    Examples:  
      | OrderID  | Attribute2  |  
      | 100002   | ValidValue  |  

  @TC-150  
  Scenario: User re-triggers the billing due program and verifies successful execution  
    Given the user is on the billing due program screen  
    When the user re-triggers the billing due program for the updated Sales Order  
    Then the billing due program completes successfully without errors