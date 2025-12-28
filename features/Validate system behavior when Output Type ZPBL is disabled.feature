Feature: Validate system behavior when Output Type ZPBL is disabled

  @TC-10
  Scenario Outline: Validate system response for Output Type ZPBL when disabled or enabled
    Given the user logs into the SAP system with authorized credentials
    And the user navigates to transaction VF03
    And the VF03 transaction screen is displayed
    When the user enters the cancellation billing document number "<cancellationBillingDocument>" and executes
    Then the cancellation billing document details are displayed
    When the user selects the output rendering option from the menu
    And the user chooses Output Type ZPBL for rendering
    Then the system attempts to process the output rendering
    And the system displays "<expectedMessage>" indicating the Output Type ZPBL status
    And the output rendering process "<renderingProcess>"
    And the system logs "<logStatus>" error messages related to Output Type ZPBL
    When the user attempts to enable Output Type ZPBL and repeats the rendering process
    Then the system accepts the configuration and allows rendering
    And the output rendering process completes successfully

    Examples:
      | cancellationBillingDocument | expectedMessage                       | renderingProcess           | logStatus               |
      | 9000001234                  | Output Type ZPBL is disabled          | does not proceed           | generates               |
      | 9000001234                  | Output rendering process completes    | proceeds successfully      | does not generate       |

  @TC-10
  Scenario: Document error message and resolution steps
    Given the user logs into the SAP system with authorized credentials
    When the user documents the error message and resolution steps for audit purposes
    Then the error message and resolution steps are documented successfully

  @TC-10
  Scenario: Validate user logout from the SAP system
    Given the user is logged into the SAP system
    When the user logs out from the SAP system
    Then the user logs out successfully