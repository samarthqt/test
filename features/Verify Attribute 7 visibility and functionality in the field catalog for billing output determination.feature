Feature: Verify Attribute 7 visibility and functionality in the field catalog for billing output determination

  @TC-273
  Scenario: User logs into the SAP S/4 HANA system
    Given the user has appropriate credentials
    When the user logs into the SAP S/4 HANA system
    Then the user is successfully logged in

  @TC-273
  Scenario: User navigates to the configuration screen for billing output determination
    Given the user is logged into the SAP S/4 HANA system
    When the user navigates to the configuration screen for billing output determination
    Then the configuration screen for billing output determination is displayed

  @TC-273
  Scenario: User accesses the field catalog (ZPDT) settings
    Given the user is on the configuration screen for billing output determination
    When the user accesses the field catalog (ZPDT) settings
    Then the field catalog settings are accessible

  @TC-273
  Scenario Outline: User searches for Attribute 7 in the field catalog list
    Given the user has accessed the field catalog (ZPDT) settings
    When the user searches for "<attribute>" in the field catalog list
    Then "<attribute>" is visible in the field catalog list

    Examples:
      | attribute    |
      | Attribute 7  |

  @TC-273
  Scenario Outline: User selects Attribute 7 and verifies its properties
    Given the user has found "<attribute>" in the field catalog list
    When the user selects "<attribute>" and verifies its properties
    Then "<attribute>" is selectable and its properties such as "<property>" are correct

    Examples:
      | attribute    | property             |
      | Attribute 7  | data type, length    |

  @TC-273
  Scenario: User saves configuration changes
    Given the user has made modifications to the field catalog settings
    When the user saves the configuration changes
    Then the changes are saved successfully without errors

  @TC-273
  Scenario: User creates a new billing document to test the visibility of Attribute 7
    Given the user is logged into the SAP S/4 HANA system
    When the user creates a new billing document
    Then the billing document creation screen is displayed

  @TC-273
  Scenario Outline: User enters required details for the billing document including Attribute 7
    Given the user is on the billing document creation screen
    When the user enters the required details including "<attribute>"
    Then the details are entered successfully and "<attribute>" is selectable

    Examples:
      | attribute    |
      | Attribute 7  |

  @TC-273
  Scenario Outline: User configures an output determination rule using Attribute 7
    Given the user has entered the required details for the billing document
    When the user configures an output determination rule using "<attribute>"
    Then the output determination rule is configured successfully

    Examples:
      | attribute    |
      | Attribute 7  |

  @TC-273
  Scenario: User triggers the output determination process for the billing document
    Given the user has configured the output determination rule
    When the user triggers the output determination process for the billing document
    Then the output determination process is triggered without errors

  @TC-273
  Scenario Outline: User validates that Attribute 7 is used in the output determination logic
    Given the user has triggered the output determination process
    When the user validates that "<attribute>" is used in the output determination logic
    Then "<attribute>" is correctly applied in the output determination logic

    Examples:
      | attribute    |
      | Attribute 7  |

  @TC-273
  Scenario: User generates a report to confirm the visibility and usage of Attribute 7
    Given the user has validated the output determination logic
    When the user generates a report to confirm the visibility and usage of Attribute 7
    Then the report confirms that Attribute 7 is visible and used as expected