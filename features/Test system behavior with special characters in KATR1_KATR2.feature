Feature: Test system behavior with special characters in KATR1/KATR2  
  Ensure the system handles special characters in KATR1/KATR2 without errors or data corruption.

  @TC-457  
  Scenario Outline: Validate system handling of special characters in KATR1 and KATR2 during the Sales Order to Billing Document copy process  
    Given the user is logged into the SAP S/4HANA Cloud system  
    And the user navigates to the Sales Order to Billing Document copy process screen  
    When the user selects Sales Order with KATR1 as "<KATR1>" and KATR2 as "<KATR2>"  
    And the user initiates the copy process to generate a billing document  
    Then the system should process the special characters without errors or warnings  
    And the user documents the results successfully  
    And the user logs out of the SAP S/4HANA Cloud system  

    Examples:  
      | KATR1        | KATR2      |  
      | @Special$    | #Char&     |  
      | %Test123     | ^Example!  |  
      | !EdgeCase    | *Boundary$ |  
      | Blank        | Blank      |  
      | NormalValue1 | NormalValue2 |