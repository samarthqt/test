Feature: Validate error handling for non-unique partner data in Billing document items  
  Ensure the system prevents the creation of the Credit Memo Request when partner data in reference Billing document items is not unique.

  @TC-184
  Scenario Outline: Validate creation of Credit Memo Request with non-unique partner data
    Given the user navigates to transaction VA01 for creating a Credit Memo Request  
    When the user enters the Billing document number "<BillingDocumentNumber>" as the reference  
    Then the system loads the reference details with Sold-to "<SoldToPartners>" and Ship-to "<ShipToPartners>"  
    And the header-level partner data is "<HeaderPartnerData>"  
    When the user attempts to execute the creation process for the Credit Memo Request  
    Then the system prevents the creation process due to non-unique partner data  
    And the error message "<ErrorMessage>" is displayed  

    Examples:  
      | BillingDocumentNumber | SoldToPartners     | ShipToPartners     | HeaderPartnerData       | ErrorMessage                                |  
      | 100000002             | Partner A, Partner B | Partner D, Partner E | Missing or inconsistent | no unique partners found in reference items |  

  @TC-184
  Scenario: Validate system logs for error handling  
    Given the user attempts to create a Credit Memo Request with non-unique partner data  
    Then the system logs reflect the error message "no unique partners found in reference items"  
    And further processing is prevented  

  @TC-184
  Scenario: Validate audit trail for failed creation attempt  
    Given the user attempts to create a Credit Memo Request with non-unique partner data  
    Then the audit trail reflects the failure and the error message "no unique partners found in reference items"  

  @TC-184
  Scenario: Verify configuration of copy routine FV45C003  
    Given the user verifies the configuration of copy routine FV45C003  
    Then the configuration is set to handle non-unique partner data appropriately  

  @TC-184
  Scenario: Ensure no financial postings for failed creation attempt  
    Given the user attempts to create a Credit Memo Request with non-unique partner data  
    Then no financial postings are generated for the failed creation attempt  

  @TC-184
  Scenario: Validate impact on referenced sales orders  
    Given the user checks the 'display billing detail' report for referenced sales orders  
    Then the referenced sales orders remain unaffected in the report  

  @TC-184
  Scenario: Validate system recovery from failed creation attempt  
    Given the user attempts to create a Credit Memo Request with non-unique partner data  
    Then the system recovers gracefully without impacting other processes  

  @TC-184
  Scenario: Verify user notifications for error handling  
    Given the user attempts to create a Credit Memo Request with non-unique partner data  
    Then the user is notified with clear and actionable error messages