Feature: Validate system behavior for Output Type ZPBL when configuration is added

  @TC-9
  Scenario: User logs into the SAP system successfully
    Given the user has authorized credentials
    When the user logs into the SAP system
    Then the user is successfully logged into the SAP system

  @TC-9
  Scenario: User navigates to transaction VF03
    Given the user is logged into the SAP system
    When the user navigates to transaction VF03
    Then the VF03 transaction screen is displayed

  @TC-9
  Scenario Outline: Validate cancellation billing document details and rendering process
    Given the user is on the VF03 transaction screen
    When the user enters the cancellation billing document number "<CancellationBillingDocumentNumber>" and executes
    Then the cancellation billing document details are displayed
    When the user selects the output rendering option from the menu
    Then the output rendering options are displayed
    When the user chooses Output Type ZPBL for rendering
    Then the system attempts to process the output rendering
    When the user verifies the system's response for Output Type ZPBL configuration
    Then the system processes the output rendering successfully
    When the user validates the output document generation
    Then the output document is generated successfully with expected details
    When the user checks the system logs for rendering messages
    Then the system logs confirm successful rendering of Output Type ZPBL
    When the user validates the generated output document for accuracy
    Then the output document contains accurate details as configured

    Examples:
      | CancellationBillingDocumentNumber |
      | 9000001234                        |
      | 9000005678                        |

  @TC-9
  Scenario: Document the successful rendering process for audit purposes
    Given the user has successfully generated the output document
    When the user documents the rendering process and output document details
    Then the rendering process and output document details are documented successfully

  @TC-9
  Scenario Outline: Repeat rendering process for consistency
    Given the user has successfully completed one rendering process
    When the user repeats the rendering process for another cancellation billing document "<NewCancellationBillingDocumentNumber>"
    Then the output rendering process completes successfully for the new document

    Examples:
      | NewCancellationBillingDocumentNumber |
      | 9000006789                           |
      | 9000007890                           |

  @TC-9
  Scenario: User logs out from the SAP system
    Given the user has completed all required processes in the SAP system
    When the user logs out from the SAP system
    Then the user logs out successfully