Feature: Validate routing of ZRK requests based on two-level approval bucket  
  Ensure ZRK requests are routed to the correct Reviewer(s) and Approver(s) based on their value bucket with two approval levels. The system is configured with workflow rules for ZRK and ZRK1 document types.

  @TC-551
  Scenario Outline: Validate creation and submission of a ZRK request  
    Given the user is logged into the SAP system with authorization to create Billing Correction Requests  
    When the user navigates to the Billing Correction Request creation screen  
    And the user enters the document type as "<DocumentType>"  
    And the user enters a value of "<Value>"  
    And the user submits the ZRK request for workflow routing  
    Then the ZRK request is successfully submitted for workflow routing  

    Examples:  
      | DocumentType | Value  |  
      | ZRK          | 1000   |  
      | ZRK          | 5000   |  
      | ZRK          | 9999   |  

  @TC-551
  Scenario Outline: Validate first-level approval of a ZRK request  
    Given the user is logged into the SAP system as the designated first-level Reviewer for the ZRK request  
    When the Reviewer sees the ZRK request in their workflow inbox  
    And the Reviewer approves the ZRK request at the first level  
    Then the ZRK request is routed to the second-level Reviewer or Approver  

    Examples:  
      | ReviewerRole |  
      | Reviewer1    |  
      | Reviewer2    |  

  @TC-551
  Scenario Outline: Validate second-level approval of a ZRK request  
    Given the user is logged into the SAP system as the designated second-level Reviewer or Approver for the ZRK request  
    When the second-level Reviewer or Approver sees the ZRK request in their workflow inbox  
    And the second-level Reviewer or Approver approves the ZRK request  
    Then the ZRK request is marked as approved and proceeds to billing  

    Examples:  
      | ApproverRole |  
      | Approver1    |  
      | Approver2    |  

  @TC-551
  Scenario: Verify routing of ZRK request at each level  
    Given the ZRK request has been submitted for workflow routing  
    When the user checks the routing of the ZRK request at each level  
    Then the ZRK request is routed to the correct Reviewer(s) and Approver(s) based on its value bucket  

  @TC-551
  Scenario: Verify the status of the ZRK request after final approval  
    Given the ZRK request has been approved at the second level  
    When the user checks the status of the ZRK request  
    Then the ZRK request is marked as approved and proceeds to billing  

  @TC-551
  Scenario: Verify workflow logs for the ZRK request  
    Given the ZRK request has been processed through the workflow  
    When the user checks the workflow logs for the ZRK request  
    Then the workflow logs show the correct routing and approval sequence for the ZRK request