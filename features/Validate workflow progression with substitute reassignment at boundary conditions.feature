Feature: Validate workflow progression with substitute reassignment at boundary conditions  
  Ensure the system handles substitute reassignment when multiple substitutes become unavailable simultaneously and preserves workflow integrity.

  @TC-252  
  Scenario: User logs in to the SAP system as an administrator  
    Given the user has valid administrative credentials  
    When the user logs in to the SAP system  
    Then the user successfully accesses the system  

  @TC-252  
  Scenario: User navigates to the workflow management module  
    Given the user is logged in as an administrator  
    When the user navigates to the workflow management module  
    Then the workflow management module is displayed with active workflows  

  @TC-252  
  Scenario: User searches for Billing Correction Request ID  
    Given the user is in the workflow management module  
    When the user searches for Billing Correction Request ID "BCR006"  
    Then the Billing Correction Request details are displayed  

  @TC-252  
  Scenario Outline: Substitute Reviewer is marked as unavailable and reassigned  
    Given the user has accessed the Billing Correction Request details  
    When the user marks the currently assigned substitute Reviewer "<Reviewer>" as unavailable  
    Then the system updates the status of "<Reviewer>" to unavailable  
    And the system automatically assigns a new substitute Reviewer  
    And the updated workflow is displayed  

    Examples:  
      | Reviewer |  
      | UserE    |  

  @TC-252  
  Scenario Outline: Substitute Approver is marked as unavailable and reassigned  
    Given the user has accessed the Billing Correction Request details  
    When the user marks the currently assigned substitute Approver "<Approver>" as unavailable  
    Then the system updates the status of "<Approver>" to unavailable  
    And the system automatically assigns a new substitute Approver  
    And the updated workflow is displayed  

    Examples:  
      | Approver |  
      | UserF    |  

  @TC-252  
  Scenario: User checks the workflow logs for reassignment details  
    Given the user has performed substitute reassignments  
    When the user checks the workflow logs  
    Then the workflow logs show successful reassignment without errors  

  @TC-252  
  Scenario: User confirms workflow progression without interruption  
    Given the user has verified the workflow logs  
    When the user observes the workflow progression  
    Then the workflow continues to the next step without delays  

  @TC-252  
  Scenario: User validates the approval sequence remains intact  
    Given the user is observing the workflow progression  
    When the user checks the approval sequence  
    Then the approval sequence is preserved as per the workflow configuration  

  @TC-252  
  Scenario: User checks the Billing Correction Request status updates  
    Given the user is observing the workflow progression  
    When the user checks the Billing Correction Request status  
    Then the Billing Correction Request status reflects the current workflow stage  

  @TC-252  
  Scenario: User ensures the system generates an audit log for reassignments  
    Given the user has performed substitute reassignments  
    When the user checks the audit logs  
    Then the audit log is created with details of both reassignments