Feature: Verify creation of condition table 911 with fields Sales Org, Billing Type, and Attribute 7  
  Ensure that condition table 911 is created with the specified fields and activated successfully.  

  @TC-491  
  Scenario: User logs into the SAP system  
    Given the user has valid credentials  
    When the user logs into the SAP system  
    Then the user is successfully logged into the SAP system  

  @TC-491  
  Scenario: User navigates to the Create Condition Tables screen  
    Given the user is logged into the SAP system  
    When the user navigates to transaction code V/03  
    Then the Create Condition Tables screen is displayed  

  @TC-491  
  Scenario: User enters the condition table number  
    Given the user is on the Create Condition Tables screen  
    When the user enters "911" as the condition table number  
    Then the system accepts the input and displays the condition table creation screen  

  @TC-491  
  Scenario: User adds fields to the condition table  
    Given the user is on the condition table creation screen  
    When the user adds the fields Sales Org, Billing Type, and Attribute 7 to the condition table  
    Then the fields are successfully added to the condition table  

  @TC-491  
  Scenario: User saves the condition table  
    Given the user has added fields to the condition table  
    When the user saves the condition table  
    Then the condition table is saved successfully  

  @TC-491  
  Scenario: User activates the condition table  
    Given the condition table is saved  
    When the user activates the condition table  
    Then the condition table is activated successfully  

  @TC-491  
  Scenario: User navigates to Maintain Table Views screen  
    Given the user is logged into the SAP system  
    When the user navigates to transaction code SM30  
    Then the Maintain Table Views screen is displayed  

  @TC-491  
  Scenario: User enters the table name for maintenance  
    Given the user is on the Maintain Table Views screen  
    When the user enters the table name and chooses to maintain it  
    Then the table maintenance screen is displayed  

  @TC-491  
  Scenario Outline: User populates the table with test data  
    Given the user is on the table maintenance screen  
    When the user populates the table with test data for Sales Org "<Sales Org>", Billing Type "<Billing Type>", and Attribute 7 "<Attribute 7>"  
    Then the test data is successfully entered into the table  

    Examples:  
      | Sales Org | Billing Type | Attribute 7 |  
      | 1000      | F2           | ZPDT        |  

  @TC-491  
  Scenario: User saves the table entries  
    Given the user has populated the table with test data  
    When the user saves the entries in the table  
    Then the entries are saved successfully  

  @TC-491  
  Scenario: User validates the table in the data dictionary  
    Given the condition table is created and activated  
    When the user validates that the table is accessible in the data dictionary  
    Then the condition table 911 is visible in the data dictionary  

  @TC-491  
  Scenario: User verifies the table fields and data  
    Given the condition table is visible in the data dictionary  
    When the user verifies that the table contains the fields Sales Org, Billing Type, and Attribute 7, and the data  
    Then the table includes the correct fields and accurate data