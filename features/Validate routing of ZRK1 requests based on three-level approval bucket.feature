Feature: Validate routing of ZRK1 requests based on three-level approval bucket

  @TC-552
  Scenario: User logs in and navigates to the Billing Correction Request creation screen
    Given the user is authorized to create Billing Correction Requests
    When the user logs in to the SAP system
    Then the user is successfully logged in and has access to create Billing Correction Requests
    When the user navigates to the Billing Correction Request creation screen
    Then the Billing Correction Request creation screen is displayed

  @TC-552
  Scenario Outline: Validate creation and routing of ZRK1 requests based on approval levels
    Given the user is on the Billing Correction Request creation screen
    When the user enters the document type as "<document_type>"
    Then the system accepts the document type "<document_type>"
    When the user enters a value of "<request_value>"
    Then the system validates and accepts the value "<request_value>" within the specified range
    When the user submits the ZRK1 request for workflow routing
    Then the ZRK1 request is successfully submitted for workflow routing

    Examples:
      | document_type | request_value |
      | ZRK1          | 1000          |
      | ZRK1          | 5000          |
      | ZRK1          | 10000         |

  @TC-552
  Scenario Outline: Validate first-level approval of ZRK1 requests
    Given the first-level Reviewer logs in to the SAP system
    When the user navigates to their workflow inbox
    Then the ZRK1 request is visible in the workflow inbox
    When the user reviews and approves the ZRK1 request at the first level
    Then the ZRK1 request is approved and routed to the second level

    Examples:
      | reviewer_level |
      | First          |

  @TC-552
  Scenario Outline: Validate second-level approval of ZRK1 requests
    Given the second-level Reviewer or Approver logs in to the SAP system
    When the user navigates to their workflow inbox
    Then the ZRK1 request is visible in the workflow inbox
    When the user approves the ZRK1 request at the second level
    Then the ZRK1 request is approved and routed to the third level

    Examples:
      | reviewer_level |
      | Second         |

  @TC-552
  Scenario Outline: Validate third-level approval of ZRK1 requests
    Given the third-level Reviewer or Approver logs in to the SAP system
    When the user navigates to their workflow inbox
    Then the ZRK1 request is visible in the workflow inbox
    When the user approves the ZRK1 request at the third level
    Then the ZRK1 request is approved and proceeds to billing

    Examples:
      | reviewer_level |
      | Third          |

  @TC-552
  Scenario: Validate workflow logs for ZRK1 requests
    Given the user has completed the approval process for the ZRK1 request
    When the user checks the workflow logs for the ZRK1 request
    Then the workflow logs show the correct routing and approval sequence for the ZRK1 request