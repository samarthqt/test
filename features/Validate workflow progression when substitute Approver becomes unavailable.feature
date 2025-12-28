Feature: Validate workflow progression when substitute Approver becomes unavailable  
  Ensure the system reassigns a substitute Approver when the original substitute becomes unavailable, maintaining workflow progression.  

  @TC-248  
  Scenario: Administrator logs in to the SAP system  
    Given the user has administrative access credentials  
    When the user logs in to the SAP system as an administrator  
    Then the user successfully accesses the system  

  @TC-248  
  Scenario: User navigates to the workflow management module  
    Given the user is logged in as an administrator  
    When the user navigates to the workflow management module  
    Then the workflow management module is displayed with active workflows  

  @TC-248  
  Scenario: User searches for a specific Billing Correction Request  
    Given the user is in the workflow management module  
    When the user searches for Billing Correction Request ID "BCR002"  
    Then the Billing Correction Request details are displayed  

  @TC-248  
  Scenario Outline: Mark substitute Approver as unavailable and verify reassignment  
    Given the user views the Billing Correction Request details  
    When the user marks the currently assigned substitute Approver "<substitute_approver>" as unavailable  
    Then the system updates the status of "<substitute_approver>" to unavailable  
    And the system automatically assigns a new substitute Approver  
    And the updated workflow is displayed  
    And the workflow logs show successful reassignment without errors  
    And the new substitute Approver receives a notification of the reassignment  

    Examples:  
      | substitute_approver |  
      | UserB               |  

  @TC-248  
  Scenario: Confirm workflow progression without interruption  
    Given the system has reassigned a new substitute Approver  
    When the user checks the workflow progression  
    Then the workflow continues to the next step without delays  

  @TC-248  
  Scenario: Validate approval sequence remains intact  
    Given the workflow is progressing without interruption  
    When the user verifies the approval sequence  
    Then the approval sequence is preserved as per the workflow configuration  

  @TC-248  
  Scenario: Verify Billing Correction Request status updates correctly  
    Given the workflow is progressing without interruption  
    When the user checks the status of the Billing Correction Request  
    Then the Billing Correction Request status reflects the current workflow stage  

  @TC-248  
  Scenario: Ensure audit log is generated for reassignment  
    Given the system has reassigned a new substitute Approver  
    When the user checks the audit logs  
    Then the system generates an audit log with details of the reassignment  

  @TC-248  
  Scenario: Administrator logs out of the system  
    Given the user has completed all tasks in the workflow management module  
    When the user logs out of the SAP system  
    Then the user successfully logs out