Feature: Validate error messages for invalid billing document attributes  
  Ensure that the system displays clear and actionable error messages when invalid Attribute 1 or Attribute 2 values are provided.

  @TC-430
  Scenario Outline: Validate error messages for invalid input values in billing document attributes
    Given the user is logged into the SAP S/4HANA Cloud system  
    And the user navigates to the billing due program interface  
    When the user enters Attribute 1 as "<Attribute1>"  
    And the user enters Attribute 2 as "<Attribute2>"  
    And the user initiates the billing due program execution  
    Then the system displays error messages indicating invalid Attribute 1 and Attribute 2 values  
    And the error messages provide actionable guidance on correcting the input values  
    And no billing documents are generated  
    And the system logs contain detailed entries about the invalid input values  

    Examples:  
      | Attribute1       | Attribute2       |  
      | INVALID_ATTR1    | INVALID_ATTR2    |  
      | INVALID_FORMAT   | INVALID_LENGTH   |  
      | BLANK           | INVALID_ATTR2    |  
      | INVALID_ATTR1    | BLANK           |  
      | INVALID_EDGECASE | INVALID_EDGECASE |  

  @TC-430
  Scenario Outline: Validate successful processing of valid input values in billing document attributes  
    Given the user is logged into the SAP S/4HANA Cloud system  
    And the user navigates to the billing due program interface  
    When the user enters Attribute 1 as "<Attribute1>"  
    And the user enters Attribute 2 as "<Attribute2>"  
    And the user initiates the billing due program execution  
    Then the system processes the program successfully with valid input values  

    Examples:  
      | Attribute1       | Attribute2       |  
      | VALID_ATTR1      | VALID_ATTR2      |  
      | EDGECASE_VALID1  | EDGECASE_VALID2  |  

  @TC-430
  Scenario: Log out of the SAP S/4HANA Cloud system  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user logs out of the system  
    Then the user is logged out successfully