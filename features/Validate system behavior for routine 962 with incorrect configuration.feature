Feature: Validate system behavior for routine 962 with incorrect configuration  
  Ensure the system does not generate outputs for invoice-list relevant orders and highlights misconfiguration for non-relevant orders.  

  @TC-321  
  Scenario: User logs into the SAP S/4HANA system  
    Given the user has valid credentials  
    When the user logs into the SAP S/4HANA system  
    Then the user is logged in successfully and has access to the relevant modules  

  @TC-321  
  Scenario: User navigates to the output determination strategy configuration for ZPDT  
    Given the user is logged into the SAP S/4HANA system  
    When the user navigates to the output determination strategy configuration for ZPDT  
    Then the output determination strategy screen is displayed  

  @TC-321  
  Scenario: User assigns routine 962 to the output determination strategy  
    Given the user is on the output determination strategy configuration screen for ZPDT  
    When the user assigns routine 962 to the output determination strategy  
    Then routine 962 is successfully assigned  

  @TC-321  
  Scenario Outline: Validate system behavior for invoice-list and non-invoice-list relevant orders  
    Given routine 962 is assigned to the output determination strategy  
    When the user creates an order with "<order type>"  
    And the user processes the order through the billing workflow  
    Then the system "<output behavior>"  
    And the system logs "<error messages>" related to routine 962  

    Examples:  
      | order type                  | output behavior                                    | error messages                               |  
      | invoice-list relevant       | generates no outputs                              | indicates the misconfiguration of routine 962 |  
      | non-invoice-list relevant   | generates incorrect outputs                       | indicates the misconfiguration of routine 962 |  

  @TC-321  
  Scenario: Verify system highlights the need for proper configuration  
    Given routine 962 is assigned to the output determination strategy  
    When the user processes any order through the billing workflow  
    Then the system provides warnings or error messages to prompt the user to correct the configuration  

  @TC-321  
  Scenario: User documents findings and shares with the configuration team  
    Given the system has logged errors or warnings related to routine 962  
    When the user documents the findings  
    And the user shares the findings with the configuration team  
    Then the findings are documented and communicated effectively  

  @TC-321  
  Scenario: User logs out of the SAP system  
    Given the user has completed all tasks in the SAP system  
    When the user logs out of the SAP system  
    Then the user is logged out successfully