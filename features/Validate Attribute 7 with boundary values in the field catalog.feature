Feature: Validate Attribute 7 with boundary values in the field catalog

  @TC-278
  Scenario Outline: Validate processing of Attribute 7 with boundary values in the field catalog
    Given user logs into the SAP S/4 HANA system with appropriate credentials
    When user navigates to the configuration screen for billing output determination
    And user accesses the field catalog settings
    And user searches for Attribute 7 in the field catalog list
    And user enters "<attribute_value>" for Attribute 7
    And user saves the changes to the field catalog
    And user creates a new billing document using the boundary values for Attribute 7
    And user triggers the output determination process for the billing document
    Then the output determination logic should handle the boundary values "<attribute_value>" correctly
    And user generates a report confirming the processing of boundary values "<attribute_value>"

    Examples:
      | attribute_value |
      | 999999          |
      | !@#$%           |

  @TC-278
  Scenario: Log out of the system
    Given user logs out of the SAP S/4 HANA system
    Then user is logged out successfully