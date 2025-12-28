Feature: Test system behavior for null KATR1/KATR2 values  

  @TC-455  
  Scenario Outline: Validate system behavior with null KATR1/KATR2 values during Sales Order to Billing Document copy process  
    Given user logs into the SAP S/4HANA Cloud system with appropriate credentials  
    And user navigates to the Sales Order to Billing Document copy process screen  
    When user selects a Sales Order with KATR1 as "<KATR1>" and KATR2 as "<KATR2>"  
    And user initiates the copy process to generate a billing document  
    Then the system should generate "<message_type>" message indicating "<message_details>"  
    And user documents the "<message_type>" message details for review  
    And user logs out of the SAP S/4HANA Cloud system  

    Examples:  
      | KATR1  | KATR2  | message_type | message_details                             |  
      | null   | null   | error        | Null KATR1/KATR2 values detected            |  
      | null   | null   | warning      | Warning: KATR1/KATR2 values are missing     |  

  @TC-455  
  Scenario: Verify successful login to SAP S/4HANA Cloud system  
    Given user logs into the SAP S/4HANA Cloud system with appropriate credentials  
    Then user is successfully logged into the system  

  @TC-455  
  Scenario: Verify navigation to Sales Order to Billing Document copy process screen  
    Given user navigates to the Sales Order to Billing Document copy process screen  
    Then the Sales Order to Billing Document copy process screen is displayed  

  @TC-455  
  Scenario: Verify successful logout from SAP S/4HANA Cloud system  
    Given user logs out of the SAP S/4HANA Cloud system  
    Then user is logged out successfully