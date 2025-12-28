Feature: Validate Revenue Recognition Readiness for Billing Document  
  Ensure the created billing document is prepared for revenue recognition, with the last billing plan set as 'Due'.

  @TC-121
  Scenario: User logs into the SAP S/4HANA Cloud system  
    Given the user has valid credentials  
    When the user logs into the SAP S/4HANA Cloud system  
    Then the user is successfully logged into the SAP S/4HANA Cloud system  

  @TC-121
  Scenario: User confirms the last billing plan is set as 'Due'  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the Billing Plan module  
    Then the user confirms the last billing plan is set as 'Due'  

  @TC-121
  Scenario: User creates a billing document for the last billing plan  
    Given the last billing plan is set as 'Due'  
    When the user triggers the creation of a billing document for the last billing plan  
    Then the billing document is created successfully  

  @TC-121
  Scenario: User navigates to the revenue recognition section of the billing document  
    Given the billing document is created  
    When the user opens the created billing document and navigates to the revenue recognition section  
    Then the revenue recognition section is accessible for the billing document  

  @TC-121
  Scenario: User verifies the billing document is ready for revenue recognition  
    Given the user is in the revenue recognition section of the billing document  
    When the user verifies the readiness status of the billing document  
    Then the billing document is marked as ready for revenue recognition  

  @TC-121
  Scenario: User checks the revenue recognition configuration settings  
    Given the billing document is marked as ready for revenue recognition  
    When the user checks the revenue recognition configuration settings applied to the billing document  
    Then the revenue recognition configuration settings are correctly applied to the billing document  

  @TC-121
  Scenario: User validates the revenue recognition status in the financial ledger  
    Given the revenue recognition configuration settings are applied to the billing document  
    When the user validates the revenue recognition status in the financial ledger  
    Then the revenue recognition status is updated in the financial ledger without errors  

  @TC-121
  Scenario: User confirms the billing document is included in the revenue recognition report  
    Given the revenue recognition status is updated in the financial ledger  
    When the user checks the revenue recognition report  
    Then the billing document is included in the revenue recognition report  

  @TC-121
  Scenario: User verifies no errors or warnings during the revenue recognition readiness check  
    Given the user is performing the revenue recognition readiness check  
    When the readiness check is completed  
    Then no errors or warnings are generated during the revenue recognition readiness check  

  @TC-121
  Scenario: User ensures revenue recognition readiness status is logged for audit purposes  
    Given the revenue recognition readiness check is completed  
    When the user ensures the readiness status is logged in the system  
    Then the revenue recognition readiness status is logged in the system with all relevant details  

  @TC-121
  Scenario: User validates alignment with configured business rules  
    Given the revenue recognition readiness status is logged  
    When the user validates the readiness status against the configured business rules  
    Then the revenue recognition readiness aligns with the configured business rules  

  @TC-121
  Scenario: User verifies no impact on other statuses of the billing document  
    Given the revenue recognition readiness process is completed  
    When the user checks the statuses of the billing document  
    Then the revenue recognition readiness process does not impact the billing document's other statuses