Feature: Verify manual input of Debit Memo Request details without a Billing Document reference

  @TC-228
  Scenario: User logs in to the SAP Fiori app
    Given the user has valid credentials for the SAP Fiori app
    When the user logs in to the SAP Fiori app
    Then the user successfully accesses the app

  @TC-228
  Scenario: User navigates to the Debit Memo Request creation section
    Given the user is logged into the SAP Fiori app
    When the user navigates to the Debit Memo Request creation section
    Then the Debit Memo Request creation screen is displayed

  @TC-228
  Scenario Outline: User inputs header details for the Debit Memo Request
    Given the user is on the Debit Memo Request creation screen
    When the user enters header details such as "<customer_name>", "<request_type>", and "<date>"
    Then the system accepts the header details but flags the missing Billing Document reference

    Examples:
      | customer_name | request_type | date       |
      | Customer A    | RequestType1 | 2023-01-01 |
      | Customer B    | RequestType2 | 2023-12-31 |

  @TC-228
  Scenario Outline: User inputs item details for the Debit Memo Request
    Given the user has entered header details
    When the user enters item details such as "<quantity>", "<price>", and "<description>"
    Then the system accepts the item details but flags the missing Billing Document reference

    Examples:
      | quantity | price | description        |
      | 10       | 100   | Item Description 1 |
      | 5        | 50    | Item Description 2 |

  @TC-228
  Scenario: User submits the Debit Memo Request without a Billing Document reference
    Given the user has entered header and item details
    When the user submits the Debit Memo Request
    Then the system prevents submission and displays an error message regarding the missing Billing Document reference

  @TC-228
  Scenario: User checks system logs for validation messages
    Given the user has attempted to submit a Debit Memo Request without a Billing Document reference
    When the user checks the system logs
    Then the system logs indicate the error and validation failure due to the missing Billing Document reference

  @TC-228
  Scenario Outline: User provides a valid Billing Document reference and resubmits the request
    Given the user has entered header and item details
    When the user provides a valid Billing Document reference "<billing_document_reference>" and resubmits the request
    Then the system accepts the request and processes it successfully

    Examples:
      | billing_document_reference |
      | BD12345                    |
      | BD67890                    |

  @TC-228
  Scenario: User verifies workflow initiation for the submitted request
    Given the user has submitted a valid Debit Memo Request
    When the user verifies the workflow initiation for the request
    Then the workflow is triggered successfully for the valid request

  @TC-228
  Scenario: User checks the status of the Debit Memo Request
    Given the user has submitted a valid Debit Memo Request
    When the user checks the status of the request in the system
    Then the request status is updated to 'Submitted'

  @TC-228
  Scenario: System ensures error handling for missing mandatory fields
    Given the user attempts to submit a Debit Memo Request with missing mandatory fields
    When the system validates the request
    Then the system ensures compliance by preventing incomplete requests

  @TC-228
  Scenario: User attempts to save the incomplete Debit Memo Request
    Given the user has entered incomplete details for the Debit Memo Request
    When the user attempts to save the request
    Then the system prevents saving and displays a detailed error message

  @TC-228
  Scenario: User checks system logs for errors related to missing references
    Given the user has attempted to submit or save a Debit Memo Request with missing references
    When the user checks the system logs
    Then the system logs all errors related to missing mandatory fields