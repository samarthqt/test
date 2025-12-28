Feature: Validate successful creation of condition table 911 with correct field entries  
  Ensure condition table 911 is created successfully with mandatory fields such as Sales Org, Billing Type, and Attribute 7.  

  @TC-287  
  Scenario: User logs into the SAP system with valid credentials  
    Given the SAP system is configured and accessible  
    When the user logs into the SAP system with valid credentials  
    Then the user is successfully logged into the SAP system  

  @TC-287  
  Scenario: User navigates to the condition table creation screen  
    Given the user has appropriate authorization to create condition tables  
    When the user navigates to the condition table creation screen using transaction code SE11  
    Then the condition table creation screen is displayed  

  @TC-287  
  Scenario Outline: User creates condition table 911 with mandatory fields  
    Given the user is on the condition table creation screen  
    When the user enters the table name "<table_name>" and chooses to create  
    And the user defines the table fields: Sales Org, Billing Type, and Attribute 7  
    And the user saves the table definition  
    And the user activates the condition table  
    Then the condition table "<table_name>" is activated without errors  

    Examples:  
      | table_name |  
      | 911        |  

  @TC-287  
  Scenario: User verifies the table definition  
    Given the condition table 911 is activated  
    When the user navigates to transaction SE16 and views the table structure  
    Then the table structure displays the defined fields correctly  

  @TC-287  
  Scenario Outline: User populates condition table 911 with test data  
    Given the user is on transaction code VK11  
    When the user populates the table with test data for Sales Org "<sales_org>", Billing Type "<billing_type>", and Attribute 7 "<attribute_7>"  
    Then the test data is populated successfully in the condition table  

    Examples:  
      | sales_org | billing_type | attribute_7 |  
      | 1000      | F2           | 10          |  

  @TC-287  
  Scenario: User validates the table data  
    Given the condition table 911 is populated with test data  
    When the user performs a query using transaction SE16  
    Then the populated data is displayed correctly in the query results  

  @TC-287  
  Scenario Outline: User links condition table 911 to an access sequence  
    Given the user is on transaction code V/07  
    When the user links the condition table "<table_name>" to an access sequence  
    Then the condition table "<table_name>" is successfully linked to the specified access sequence  

    Examples:  
      | table_name |  
      | 911        |  

  @TC-287  
  Scenario: User tests the output determination process  
    Given the condition table 911 is linked to an access sequence  
    When the user tests the output determination process using transaction code VF01  
    Then the output determination works correctly using the condition table  

  @TC-287  
  Scenario: User verifies logs for errors or warnings  
    Given the user has completed all steps related to the condition table creation and usage  
    When the user verifies the logs for errors or warnings during the process  
    Then no errors or warnings are found in the logs