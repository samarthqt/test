Feature: Negative test for missing original billing document references in ZL2C billing  
  Ensure that the system prevents the creation of ZL2C billing documents without valid references to the original billing document.  

  @TC-43  
  Scenario: User logs into the SAP S/4HANA system successfully  
    Given the user has appropriate credentials  
    When the user logs into the SAP S/4HANA system  
    Then the user is successfully logged into the system  

  @TC-43  
  Scenario: User navigates to the billing correction request creation screen  
    Given the user is logged into the SAP S/4HANA system  
    When the user navigates to the billing correction request creation screen  
    Then the billing correction request creation screen is displayed  

  @TC-43  
  Scenario Outline: Validate system behavior for missing original billing document references  
    Given the user is on the billing correction request creation screen  
    When the user enters an original billing document number "<originalBillingDocumentNumber>"  
      And the user selects billing correction request type "<billingCorrectionRequestType>"  
      And the user attempts to save the billing correction request  
    Then the system displays an error message "<errorMessage>"  
      And the system prevents the billing correction request from being saved  
      And the user attempts to generate a ZL2C billing document linked to the invalid billing correction request  
    Then the system prevents the ZL2C billing document from being generated  

    Examples:  
      | originalBillingDocumentNumber | billingCorrectionRequestType | errorMessage                          |  
      | 00000000                      | ZRK1                         | Original billing document does not exist |  

  @TC-43  
  Scenario: Verify system logs for missing original billing document references  
    Given the user attempted to create a billing correction request with a missing original billing document  
    When the user checks the system logs  
    Then the system logs contain detailed error messages regarding the missing original billing document references  

  @TC-43  
  Scenario: User logs out of the SAP S/4HANA system successfully  
    Given the user is logged into the SAP S/4HANA system  
    When the user logs out of the SAP S/4HANA system  
    Then the user is successfully logged out