Feature: Test output determination logic without reliance on Attribute 7  
  Ensure output determination logic functions correctly without reliance on Attribute 7 in payer master data. Attribute 7 must not be configured in the payer master data for the test payer.  

  @TC-268  
  Scenario: User navigates to the billing document creation screen  
    Given the user logs into SAP S/4HANA  
    When the user navigates to the billing document creation screen  
    Then the billing document creation screen is displayed  

  @TC-268  
  Scenario Outline: User creates a billing document for a customer with missing Attribute 7  
    Given the system has at least one billing document with a payer missing Attribute 7  
    When the user creates a billing document for a customer with missing Attribute 7 in the payer master data  
    Then the billing document is created successfully  
    And the billing document is saved with a unique document number "<billingDocument>"  

    Examples:  
      | billingDocument |  
      | BD-003          |  

  @TC-268  
  Scenario: User triggers the output determination process for the billing document  
    Given the user has a saved billing document  
    When the user triggers the output determination process for the billing document  
    Then the output determination process is initiated successfully  

  @TC-268  
  Scenario: User inspects the output determination logic  
    Given the output determination process is initiated  
    When the user inspects the output determination logic  
    Then the output determination logic functions correctly without reliance on Attribute 7  

  @TC-268  
  Scenario: User verifies the output generated for the billing document  
    Given the output determination logic functions correctly  
    When the user verifies the output generated for the billing document  
    Then the output is generated successfully as per the configured rules  

  @TC-268  
  Scenario: User checks the KOMKBV3 and KOMB structures for errors or inconsistencies  
    Given the output is generated successfully  
    When the user checks the KOMKBV3 and KOMB structures  
    Then the KOMKBV3 and KOMB structures are error-free and consistent  

  @TC-268  
  Scenario: User reviews system logs for issues related to missing Attribute 7  
    Given the KOMKBV3 and KOMB structures are consistent  
    When the user reviews the system logs  
    Then no issues related to missing Attribute 7 are found in the logs  

  @TC-268  
  Scenario: User validates the document flow for correct linkage of the output  
    Given no issues are found in the system logs  
    When the user validates the document flow  
    Then the document flow shows correct linkage of the output to the billing document  

  @TC-268  
  Scenario: User confirms the billing document status after output determination  
    Given the document flow is correct  
    When the user confirms the billing document status  
    Then the billing document status is updated correctly after output determination  

  @TC-268  
  Scenario: User tests the impact of missing Attribute 7 on subsequent processes  
    Given the billing document status is updated  
    When the user tests the impact of missing Attribute 7 on subsequent processes  
    Then the subsequent processes are unaffected by the absence of Attribute 7  

  @TC-268  
  Scenario: User documents the results and observations for review  
    Given the subsequent processes are unaffected  
    When the user documents the results and observations  
    Then the results and observations are documented successfully