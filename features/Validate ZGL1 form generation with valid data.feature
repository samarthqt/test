Feature: Validate ZGL1 form generation with valid data  
  Ensure the system generates a ZGL1 form accurately when all required data is valid.  
  Ensure a valid Invoice Correction Request exists with all required data.  

  @TC-82
  Scenario Outline: Verify ZGL1 form generation with different Invoice Correction Request inputs  
    Given the user logs into the SAP S/4HANA system with "<user_credentials>"  
    When the user navigates to the Billing Correction Output form generation screen  
    And the user selects the Invoice Correction Request with ID "<invoice_correction_request_id>"  
    Then the system displays the Invoice Correction Request details with Correction Type "<correction_type>"  
    When the user attempts to generate a ZGL1 form  
    Then the system "<form_generation_status>" generates the ZGL1 form  
    And the generated ZGL1 form is "<form_link_status>" linked to the Invoice Correction Request and original billing document  
    And the generated ZGL1 form contains "<form_accuracy>" information  

    Examples:  
      | user_credentials  | invoice_correction_request_id | correction_type | form_generation_status | form_link_status | form_accuracy       |  
      | valid_credentials | 33333                         | Debit           | successfully           | correctly        | accurate and complete |  
      | valid_credentials | 44444                         | Credit          | successfully           | correctly        | accurate and complete |  
      | invalid_credentials | 33333                      | Debit           | fails                  | not              | inaccurate           |  
      | valid_credentials |                              | Debit           | fails                  | not              | inaccurate           |  
      | valid_credentials | 55555                         | InvalidType     | fails                  | not              | inaccurate           |  

  @TC-82
  Scenario: Verify navigation to Billing Correction Output form generation screen  
    Given the user logs into the SAP S/4HANA system with valid credentials  
    When the user navigates to the Billing Correction Output form generation screen  
    Then the Billing Correction Output form generation screen is displayed  

  @TC-82
  Scenario: Verify generated ZGL1 form accuracy and completeness  
    Given the user has successfully generated a ZGL1 form  
    When the user reviews the generated ZGL1 form  
    Then the ZGL1 form contains accurate and complete information