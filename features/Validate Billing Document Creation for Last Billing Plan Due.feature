Feature: Validate Billing Document Creation for Last Billing Plan Due  
  Ensure the system triggers the creation of a billing document when the last billing plan is set to 'Due'.  

  @TC-119  
  Scenario: User logs into the SAP S/4HANA Cloud system  
    Given the user has valid credentials with necessary access rights  
    When the user logs into the SAP S/4HANA Cloud system  
    Then the user is successfully logged into the system  

  @TC-119  
  Scenario: User navigates to the Billing Plan module  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the Billing Plan module  
    Then the Billing Plan module is displayed with a list of configured billing plans  

  @TC-119  
  Scenario: User sets the last billing plan as 'Due'  
    Given the user is in the Billing Plan module  
    When the user sets the last billing plan in the system as 'Due' for billing  
    Then the status of the last billing plan is updated to 'Due'  

  @TC-119  
  Scenario: System triggers billing document creation  
    Given the last billing plan is set to 'Due'  
    When the system processes the billing plan  
    Then the system automatically triggers the creation of a billing document  

  @TC-119  
  Scenario: Verify the SAP sales document type of the billing document  
    Given a billing document is created by the system  
    When the user checks the SAP sales document type of the created billing document  
    Then the sales document type is set to ZFR  

  @TC-119  
  Scenario: Confirm billing document is prepared for revenue recognition  
    Given a billing document is created by the system  
    When the user reviews the billing document  
    Then the billing document is marked as ready for revenue recognition  

  @TC-119  
  Scenario: Verify email with billing form attachment is sent  
    Given a billing document is created by the system  
    When the system sends an email with the billing form attachment to the customer's email address  
    Then the customer receives the email without any errors  

  @TC-119  
  Scenario: Check email logs for successful dispatch  
    Given the system has sent an email with the billing form attachment  
    When the user checks the email logs in the system  
    Then the email logs indicate successful dispatch of the email  

  @TC-119  
  Scenario: Review billing document for accuracy  
    Given a billing document is created by the system  
    When the user reviews the billing document  
    Then the billing document contains accurate customer details and billing amounts  

  @TC-119  
  Scenario: Ensure billing document is linked to the billing plan  
    Given a billing document is created by the system  
    When the user reviews the document flow  
    Then the billing document is correctly linked to the corresponding billing plan  

  @TC-119  
  Scenario: Validate billing document is posted in the financial ledger  
    Given a billing document is created by the system  
    When the user checks the financial ledger  
    Then the billing document is posted successfully without errors  

  @TC-119  
  Scenario: Verify system generates confirmation message  
    Given a billing document is created by the system  
    When the user reviews the system notifications  
    Then the system displays a confirmation message indicating successful billing document creation