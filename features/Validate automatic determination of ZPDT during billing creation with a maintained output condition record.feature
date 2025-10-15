Feature: Validate automatic determination of ZPDT during billing creation with a maintained output condition record

  @TC-304
  Scenario: User logs into the SAP S/4HANA system and accesses the billing module
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged in and has access to the billing module

  @TC-304
  Scenario: User navigates to the output condition record maintenance screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the transaction for maintaining output condition records
    Then the output condition record maintenance screen is displayed

  @TC-304
  Scenario Outline: User creates or verifies an output condition record for ZPDT determination
    Given the user is on the output condition record maintenance screen
    When the user creates or verifies an output condition record with Attribute 7 set to "<attribute_value>"
    Then the output condition record is saved successfully
    And the system is configured for output determination

    Examples:
      | attribute_value |
      | 10              |

  @TC-304
  Scenario: User navigates to the billing creation transaction
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the billing creation transaction
    Then the billing creation screen is displayed

  @TC-304
  Scenario Outline: User enters details to create a billing document meeting ZPDT determination criteria
    Given the user is on the billing creation screen
    When the user enters the required details to create a billing document that meets the ZPDT determination criteria
    Then the billing document details are entered successfully

  @TC-304
  Scenario: User saves the billing document to trigger output determination
    Given the user has entered billing document details
    When the user saves the billing document
    Then the billing document is saved
    And the output determination process is triggered

  @TC-304
  Scenario: System automatically determines and applies ZPDT to the billing document
    Given the billing document meets the ZPDT determination criteria
    When the output determination process is triggered
    Then ZPDT is successfully determined and applied to the billing document without manual intervention

  @TC-304
  Scenario: User verifies ZPDT determination in the output log
    Given the billing document is created
    When the user checks the output log for the billing document
    Then the output log confirms ZPDT determination and application

  @TC-304
  Scenario: User verifies Attribute 7 propagation in the billing document
    Given the billing document is created
    When the user inspects the billing document
    Then Attribute 7 is correctly propagated to the KOMKBV3 structure

  @TC-304
  Scenario: User inspects billing document compliance with ZPDT determination rules
    Given the billing document is created
    When the user inspects the billing document
    Then the billing document complies with ZPDT determination rules

  @TC-304
  Scenario: User validates no errors during ZPDT determination
    Given the billing document is created
    When the user checks for errors during the ZPDT determination process
    Then no errors are logged
    And the process completes successfully

  @TC-304
  Scenario: User documents results and verifies business impact
    Given the ZPDT determination process is completed
    When the user documents the results
    Then the results are documented
    And the business impact is confirmed as positive