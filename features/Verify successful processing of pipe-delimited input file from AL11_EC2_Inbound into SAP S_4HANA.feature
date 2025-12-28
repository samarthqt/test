Feature: Verify successful processing of pipe-delimited input file from AL11/EC2/Inbound into SAP S/4HANA

  @TC-356
  Scenario: User logs in to the SAP S/4HANA system using valid credentials
    Given the user has valid SAP S/4HANA credentials
    When the user logs into the SAP S/4HANA system
    Then the user successfully logs into the system

  @TC-356
  Scenario: User navigates to AL11/EC2/Inbound location to confirm the presence of the pipe-delimited input file
    Given the pipe-delimited input file is correctly formatted and available in the specified location
    When the user navigates to the AL11/EC2/Inbound location
    Then the pipe-delimited input file is present in the specified location

  @TC-356
  Scenario Outline: Validate default values of selection screen parameters
    Given the user navigates to the selection screen
    When the user views the selection screen parameters
    Then the default values for the following parameters are set:
      | Parameter             | Default Value       |
      | Sales Document Type   | <SalesDocumentType> |
      | Sales Organization    | <SalesOrganization> |
      | Distribution Channel  | <DistributionChannel> |
      | Division              | <Division>          |
      | Run Date              | <RunDate>           |
      | File Path             | <FilePath>          |

    Examples:
      | SalesDocumentType | SalesOrganization | DistributionChannel | Division | RunDate   | FilePath         |
      | Standard Order    | 1000              | Online              | A1       | 2023-10-01 | /path/to/file    |

  @TC-356
  Scenario: User executes the background job manually or waits for the daily scheduled execution
    Given the daily background job is scheduled and active
    When the user manually executes the background job or waits for the daily scheduled execution
    Then the background job executes successfully

  @TC-356
  Scenario: Verify the background job picks up the file and begins processing
    Given the pipe-delimited input file is present in the specified location
    When the background job starts execution
    Then the background job picks up the file and begins processing

  @TC-356
  Scenario: Validate system logs confirm creation or update of Customer Master Data and Site Master Data
    Given the background job successfully processes the input file
    When the user checks the system logs
    Then the system logs confirm successful creation or update of Customer Master Data and Site Master Data using distinct API paths

  @TC-356
  Scenario Outline: Validate the accuracy of processed Customer Master Data
    Given the Customer Master Data is processed from the input file
    When the user validates the processed Customer Master Data
    Then the processed Customer Master Data matches the input file

    Examples:
      | CustomerID | CustomerName | Address          | PhoneNumber |
      | 123        | John Doe     | 123 Main St     | 1234567890  |

  @TC-356
  Scenario Outline: Validate the accuracy of processed Site Master Data
    Given the Site Master Data is processed from the input file
    When the user validates the processed Site Master Data
    Then the processed Site Master Data matches the input file

    Examples:
      | SiteID | SiteName   | Location        | ManagerName |
      | 456    | Site A     | 456 Elm St     | Jane Smith  |

  @TC-356
  Scenario: Ensure no errors or warnings are displayed in the system logs
    Given the background job has completed execution
    When the user checks the system logs
    Then the system logs display no errors or warnings

  @TC-356
  Scenario Outline: Verify total number of records processed matches the input file record count
    Given the input file contains <TotalRecords> records
    When the background job processes the file
    Then the total number of records processed matches <TotalRecords>

    Examples:
      | TotalRecords |
      | 100          |
      | 250          |

  @TC-356
  Scenario: Check for performance-related issues during job execution
    Given the background job is processing the input file
    When the user monitors the job execution
    Then no performance-related issues are observed during job execution

  @TC-356
  Scenario: Validate processed data is accessible in relevant transaction screens
    Given the background job has successfully processed the input file
    When the user navigates to the relevant transaction screens
    Then the processed data is accessible and accurate in the transaction screens

  @TC-356
  Scenario: Ensure dependent workflows or processes triggered by the job are successfully executed
    Given the background job has completed execution
    When the user checks the status of dependent workflows or processes
    Then all dependent workflows or processes are successfully executed