Feature: Verify system behavior for extended delay in Credit Memo Request approval/rejection

  @TC-256
  Scenario Outline: Ensure the system handles Credit Memo Request approval/rejection delays without compromising data integrity
    Given the user logs into the SAP system using an authorized account
    When the user creates a Credit Memo Request with ID "<CreditMemoRequestID>" and submits it for approval
    And the Credit Memo Request remains in the approval/rejection workflow for "<DelayDuration>"
    Then the Credit Memo Request remains in the workflow without any changes

    Examples:
      | CreditMemoRequestID | DelayDuration |
      | CMR12345            | 30 days       |
      | CMR67890            | 45 days       |

  @TC-256
  Scenario Outline: Approve Credit Memo Request after an extended delay
    Given the Credit Memo Request with ID "<CreditMemoRequestID>" is in the approval workflow for "<DelayDuration>"
    When the user logs in as an approver and approves the Credit Memo Request
    Then the system successfully processes the approval and updates the status of the Credit Memo Request
    And the user attempts to edit the approved Credit Memo Request
    Then the system allows editing as per the defined process steps

    Examples:
      | CreditMemoRequestID | DelayDuration |
      | CMR12345            | 30 days       |
      | CMR67890            | 45 days       |

  @TC-256
  Scenario Outline: Reject Credit Memo Request after an extended delay
    Given the Credit Memo Request with ID "<CreditMemoRequestID>" is in the approval workflow for "<DelayDuration>"
    When the user logs in as an approver and rejects the Credit Memo Request
    Then the system successfully processes the rejection and updates the status of the Credit Memo Request
    And the user attempts to edit the rejected Credit Memo Request
    Then the system does not allow editing of the rejected request

    Examples:
      | CreditMemoRequestID | DelayDuration |
      | CMR12345            | 30 days       |
      | CMR67890            | 45 days       |

  @TC-256
  Scenario: User logs out of the SAP system
    Given the user is logged into the SAP system
    When the user logs out of the system
    Then the user is successfully logged out