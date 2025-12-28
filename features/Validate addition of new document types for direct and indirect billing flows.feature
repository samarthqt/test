Feature: Validate addition of new document types for direct and indirect billing flows

  Ensure that new document types (ZF2, S1, ZG2C, ZL2C) are added successfully for direct and indirect billing flows without impacting existing configurations in the SAP S/4HANA system.

  @TC-523
  Scenario: User accesses SAP S/4HANA configuration settings for billing document types
    Given the SAP S/4HANA system is configured with existing billing document types
    When the user accesses the configuration settings for billing document types
    Then the configuration settings are accessible without errors
    And the cross-reference table ZOTC_CROSSREFTAB is accessible

  @TC-523
  Scenario: User navigates to the section for defining billing document types
    Given the user is in the SAP S/4HANA configuration settings
    When the user navigates to the section for defining billing document types
    Then the section for billing document types is displayed
    And existing billing document types in the system are visible

  @TC-523
  Scenario Outline: User adds new document types in the configuration
    Given the user is in the section for defining billing document types
    When the user adds a new document type "<document_type>" in the configuration
    Then the new document type "<document_type>" is added successfully without errors

    Examples:
      | document_type |
      | ZF2           |
      | S1            |
      | ZG2C          |
      | ZL2C          |

  @TC-523
  Scenario: User saves the configuration changes
    Given the user has added new document types in the configuration
    When the user saves the configuration changes
    Then the configuration changes are saved successfully

  @TC-523
  Scenario: User accesses the cross-reference table ZOTC_CROSSREFTAB
    Given the user has saved the configuration changes
    When the user accesses the cross-reference table ZOTC_CROSSREFTAB
    Then the cross-reference table is accessible without errors

  @TC-523
  Scenario Outline: User updates the cross-reference table with mappings for new document types
    Given the user has accessed the cross-reference table ZOTC_CROSSREFTAB
    When the user updates the table with mappings for the new document type "<document_type>"
    Then the mappings for the new document type "<document_type>" are updated successfully

    Examples:
      | document_type |
      | ZF2           |
      | S1            |
      | ZG2C          |
      | ZL2C          |

  @TC-523
  Scenario: User validates the mapping logic for direct billing flows
    Given the mappings for new document types have been updated
    When the user validates the mapping logic for direct billing flows using sample data
    Then the mapping logic for direct billing flows is validated successfully

  @TC-523
  Scenario: User validates the mapping logic for indirect billing flows
    Given the mappings for new document types have been updated
    When the user validates the mapping logic for indirect billing flows using sample data
    Then the mapping logic for indirect billing flows is validated successfully

  @TC-523
  Scenario: User triggers end-to-end data transmission to Model N
    Given the mapping logic for direct and indirect billing flows has been validated
    When the user triggers end-to-end data transmission to Model N
    Then the data transmission to Model N is triggered successfully

  @TC-523
  Scenario: User monitors the logs for successful data transmission
    Given the data transmission to Model N has been triggered
    When the user monitors the logs for successful data transmission
    Then the logs indicate successful data transmission to Model N

  @TC-523
  Scenario: User verifies the functionality of new document types in the system
    Given the logs indicate successful data transmission to Model N
    When the user verifies the functionality of the new document types in the system
    Then the new document types are functional without impacting existing configurations

  @TC-523
  Scenario: User ensures the mappings align with the expected configurations
    Given the new document types are functional in the system
    When the user ensures the mappings align with the expected configurations
    Then the mappings align with the expected configurations without errors