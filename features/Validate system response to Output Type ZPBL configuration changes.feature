Feature: Validate system response to Output Type ZPBL configuration changes  
  Ensure the system adapts correctly to configuration changes for Output Type ZPBL. Validate cancellation billing document rendering and logging processes.

  @TC-12
  Scenario Outline: Validate Output Type ZPBL rendering with different cancellation billing documents
    Given the user logs into the SAP system with authorized credentials
    When the user navigates to transaction VF03
    And the user enters the cancellation billing document number "<document_number>" and executes
    Then the cancellation billing document details are displayed
    When the user selects the output rendering option from the menu
    And the user chooses Output Type ZPBL for rendering
    Then the system attempts to process the output rendering
    And the system adapts correctly to the updated configuration and processes rendering
    And the output document is generated successfully with updated details
    And the system logs confirm successful rendering of Output Type ZPBL

    Examples:
      | document_number |
      | 9000001234      |
      | 9000005678      |

  @TC-12
  Scenario Outline: Validate system behavior after Output Type ZPBL configuration changes
    Given the user logs into the SAP system with authorized credentials
    When the user navigates to transaction VF03
    And the user enters the cancellation billing document number "<document_number>" and executes
    And the user selects the output rendering option from the menu
    And the user chooses Output Type ZPBL for rendering
    Then the system adapts correctly to the updated configuration and processes rendering
    And the output document is generated successfully with updated details
    When the user reverts Output Type ZPBL configuration
    And the user repeats the rendering process for the same cancellation billing document "<document_number>"
    Then the system adapts correctly to the reverted configuration

    Examples:
      | document_number |
      | 9000001234      |
      | 9000005678      |

  @TC-12
  Scenario: Document configuration changes and rendering process
    Given the user logs into the SAP system with authorized credentials
    When the user navigates to transaction VF03
    And the user enters the cancellation billing document number "9000001234" and executes
    And the user selects the output rendering option from the menu
    And the user chooses Output Type ZPBL for rendering
    Then the system attempts to process the output rendering
    And the output document is generated successfully with updated details
    When the user documents the configuration changes and rendering process for audit purposes
    Then the configuration changes and rendering process are documented successfully

  @TC-12
  Scenario: Log out from the SAP system
    Given the user logs into the SAP system with authorized credentials
    When the user logs out from the SAP system
    Then the user logs out successfully