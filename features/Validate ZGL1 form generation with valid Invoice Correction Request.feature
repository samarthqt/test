Feature: Validate ZGL1 form generation with valid Invoice Correction Request  
  Verify that the system successfully generates a ZGL1 form when a valid Invoice Correction Request is provided.  

  @TC-79  
  Scenario Outline: Generate and validate ZGL1 form using Invoice Correction Request  
    Given the user is logged into the SAP S/4HANA system with valid credentials  
    And a valid Invoice Correction Request with ID "<Invoice Correction Request ID>" exists in the system  
    When the user navigates to the Billing Correction Output form generation screen  
    And the user selects the Invoice Correction Request with Billing Document Reference "<Billing Document Reference>" and Correction Type "<Correction Type>"  
    And the user attempts to generate a ZGL1 form  
    Then the system generates the ZGL1 form successfully  
    And the generated ZGL1 form is linked to the Invoice Correction Request and original billing document  
    And the generated ZGL1 form contains accurate and complete information  

    Examples:  
      | Invoice Correction Request ID | Billing Document Reference | Correction Type |  
      | 54321                         | Valid                     | Debit           |