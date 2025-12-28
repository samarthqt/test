Feature: Verify system behavior for unsupported file formats

  @TC-510
  Scenario: User logs into the system successfully
    Given user has valid credentials
    When user logs into the system
    Then user is successfully logged in

  @TC-510
  Scenario: User navigates to the file upload section
    Given user has access to upload files
    When user navigates to the file upload section
    Then file upload section is displayed

  @TC-510
  Scenario Outline: Verify system rejection of unsupported file formats
    Given user is logged in and navigates to the file upload section
    When user selects an unsupported file format "<fileFormat>"
    And user attempts to upload the file
    Then system rejects the file and displays an error message
    And error log contains an entry indicating the unsupported file format
    And no processing occurs for unsupported file formats

    Examples:
      | fileFormat |
      | .csv       |
      | .xlsx      |

  @TC-510
  Scenario: User logs out of the system
    Given user is logged in
    When user logs out of the system
    Then user is successfully logged out