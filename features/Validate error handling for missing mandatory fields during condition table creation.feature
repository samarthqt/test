Feature: Validate error handling for missing mandatory fields during condition table creation  
  Ensure the system prevents creation of condition table 911 if mandatory fields are missing.  

  @TC-288  
  Scenario: User logs into the SAP system with valid credentials  
    Given the SAP system is configured and accessible  
    When the user logs into the SAP system with valid credentials  
    Then the user is successfully logged into the SAP system  

  @TC-288  
  Scenario: User navigates to the condition table creation screen  
    Given the user has appropriate authorization to create condition tables  
    When the user navigates to the condition table creation screen via transaction code SE11  
    Then the condition table creation screen is displayed  

  @TC-288  
  Scenario: User enters the table name and initiates creation  
    Given the user is on the condition table creation screen  
    When the user enters the table name "911" and chooses to create the table  
    Then the system allows entry to create the condition table  

  @TC-288  
  Scenario Outline: Validate error handling for missing mandatory fields  
    Given the user is defining the table fields  
    When the user omits mandatory fields such as <Sales Org>, <Billing Type>, and <Attribute 7>  
    Then the system displays an error message indicating mandatory fields are missing  
    And the system prevents saving the table definition  
    And the system prevents activating the condition table  
    Examples:  
      | Sales Org | Billing Type | Attribute 7 |  
      | NULL      | NULL         | NULL        |  

  @TC-288  
  Scenario: User checks error logs for missing mandatory fields  
    Given the user is aware of error prevention during table creation  
    When the user checks the error logs using transaction SM21  
    Then the error logs display detailed information about the missing mandatory fields  

  @TC-288  
  Scenario: User corrects the table definition by adding mandatory fields  
    Given the user is correcting the table definition  
    When the user adds the missing mandatory fields  
    Then the system accepts the corrected table definition  

  @TC-288  
  Scenario: User saves and activates the corrected condition table  
    Given the user has corrected the condition table definition  
    When the user attempts to save and activate the corrected table  
    Then the condition table is saved and activated successfully  

  @TC-288  
  Scenario: User verifies the corrected table definition  
    Given the user has saved and activated the corrected table  
    When the user verifies the corrected table definition using transaction SE16  
    Then the corrected table structure displays the mandatory fields  

  @TC-288  
  Scenario: User populates the corrected table with test data  
    Given the user has verified the corrected table  
    When the user populates the corrected table with test data using transaction VK11  
    Then the test data is populated successfully in the corrected table  

  @TC-288  
  Scenario: User tests the output determination process using the corrected table  
    Given the user has populated the corrected table with test data  
    When the user tests the output determination process using the corrected table  
    Then the output determination works correctly using the corrected table