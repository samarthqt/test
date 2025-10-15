Feature: Verify output determination logic failure due to missing Attribute 7  
  Ensure that the output determination logic fails gracefully when Attribute 7 is missing from the field catalog. Attribute 7 must not be included in the field catalog for billing output (ZPDT).

  @TC-277
  Scenario: User logs in and navigates to the billing document creation screen  
    Given the user logs in to the SAP S/4 HANA system with appropriate credentials  
    When the user navigates to the billing document creation screen  
    Then the billing document creation screen is displayed  

  @TC-277
  Scenario Outline: User enters billing document details and saves the document  
    Given the user is on the billing document creation screen  
    When the user enters the details for a new billing document with billing document type "<BillingDocumentType>" and medium "<Medium>"  
    And the user saves the billing document  
    Then the billing document is saved successfully  

    Examples:  
      | BillingDocumentType | Medium |  
      | ZF2                | Email  |  
      | ZF2                | Print  |  

  @TC-277
  Scenario: User accesses output determination settings for the created billing document  
    Given the user has created and saved a billing document  
    When the user accesses the output determination settings for the created billing document  
    Then the output determination settings are accessible  

  @TC-277
  Scenario Outline: User attempts to configure an output determination rule using Attribute 7  
    Given the user is in the output determination settings for the created billing document  
    When the user attempts to configure an output determination rule using Attribute 7  
    Then the system throws an error indicating the absence of Attribute 7 in the field catalog  

  @TC-277
  Scenario: Output determination process fails gracefully  
    Given the user has attempted to configure an output determination rule using Attribute 7  
    When the user triggers the output determination process  
    Then the output determination process fails gracefully with an error message  

  @TC-277
  Scenario: User reviews error logs for details about the missing Attribute 7  
    Given the output determination process has failed gracefully with an error message  
    When the user reviews the error logs  
    Then the error logs provide detailed information about the missing Attribute 7  

  @TC-277
  Scenario: User logs out of the system  
    Given the user has completed the review of error logs  
    When the user logs out of the system  
    Then the user is logged out successfully