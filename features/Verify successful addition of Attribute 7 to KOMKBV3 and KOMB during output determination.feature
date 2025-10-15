Feature: Verify successful addition of Attribute 7 to KOMKBV3 and KOMB during output determination

  @TC-554
  Scenario: User logs into the SAP S/4HANA system
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the system

  @TC-554
  Scenario: User navigates to the billing document creation transaction
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the billing document creation transaction
    Then the billing document creation screen is displayed

  @TC-554
  Scenario Outline: User enters required data for the billing document
    Given the user is on the billing document creation screen
    When the user enters the required data for the billing document with payer master data having Attribute 7 as "<attribute_value>"
    Then the billing document data is entered successfully

    Examples:
      | attribute_value    |
      | SpecialDiscount    |

  @TC-554
  Scenario: User saves the billing document
    Given the user has entered the required data for the billing document
    When the user saves the billing document
    Then the billing document is saved, and a document number is generated

  @TC-554
  Scenario: User triggers the output determination process
    Given the billing document is saved
    When the user triggers the output determination process for the billing document
    Then the output determination process is triggered without errors

  @TC-554
  Scenario: User accesses debugging tools to inspect communication structures
    Given the output determination process is triggered
    When the user accesses the debugging tools
    Then the debugging tools are successfully accessed

  @TC-554
  Scenario: User validates the presence of Attribute 7 in KOMKBV3 structure
    Given the debugging tools are accessed
    When the user locates the Attribute 7 field in the KOMKBV3 structure
    Then the Attribute 7 field is present in the KOMKBV3 structure

  @TC-554
  Scenario: User validates the presence of Attribute 7 in KOMB structure
    Given the debugging tools are accessed
    When the user locates the Attribute 7 field in the KOMB structure
    Then the Attribute 7 field is present in the KOMB structure

  @TC-554
  Scenario Outline: User validates the value of Attribute 7
    Given the Attribute 7 field is present in both KOMKBV3 and KOMB structures
    When the user validates that the value of Attribute 7 matches the value "<attribute_value>" from the payer master data
    Then the value of Attribute 7 matches the payer master data

    Examples:
      | attribute_value    |
      | SpecialDiscount    |

  @TC-554
  Scenario: User verifies no errors or warnings during output determination
    Given the output determination process is triggered
    When the user verifies the logs for errors or warnings
    Then no errors or warnings are logged during the output determination process

  @TC-554
  Scenario: User generates a report confirming the addition of Attribute 7
    Given the output determination process is completed
    When the user generates a report or log file
    Then the report or log file confirms the successful addition of Attribute 7 to the communication structures

  @TC-554
  Scenario: User saves changes and exits the system
    Given the report or log file is generated
    When the user saves the changes and exits the system
    Then the changes are saved, and the user exits the system