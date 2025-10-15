Feature: Validate Plant determination and Partner resolution using valid CMO_ID and Site_ID

  @TC-326
  Scenario Outline: Validate the upload of inbound file containing valid CMO_ID and Site_ID
    Given the user uploads an inbound file with CMO_ID "<CMO_ID>" and Site_ID "<Site_ID>" into the SAP system
    Then the file is successfully uploaded without any errors

    Examples:
      | CMO_ID  | Site_ID |
      | 12345   | 98765   |

  @TC-326
  Scenario: Trigger the inbound interface processing manually
    Given the user triggers the inbound interface processing manually
    Then the interface processing starts without any issues

  @TC-326
  Scenario: Validate Plant determination based on CMO_ID and Sofie/Petnet logic
    Given the user has uploaded the inbound file and triggered processing
    Then the Plant is determined correctly based on the CMO_ID and Sofie/Petnet logic

  @TC-326
  Scenario: Verify Ship To and Sold To partners resolution using Site_ID and KNVP lookups
    Given the user has uploaded the inbound file and triggered processing
    Then the Ship To and Sold To partners are resolved correctly using Site_ID and KNVP lookups

  @TC-326
  Scenario: Confirm Bill To and Payer assignment per Sofie/Petnet rules
    Given the user has uploaded the inbound file and triggered processing
    Then the Bill To and Payer partners are assigned correctly as per Sofie/Petnet rules

  @TC-326
  Scenario: Validate addition of 3rd party/central ordering partner row when Site_ID is present
    Given the user has uploaded the inbound file and triggered processing
    Then a 3rd party/central ordering partner row is added successfully when Site_ID is present

  @TC-326
  Scenario: Check logs for any errors or warnings during processing
    Given the user checks the logs after processing the inbound file
    Then no errors or warnings are observed in the logs

  @TC-326
  Scenario: Review processed data for consistency with the input file
    Given the user reviews the processed data in the system
    Then the processed data matches the input file accurately

  @TC-326
  Scenario: Verify database updates with correct partner and Plant information
    Given the user checks the database after processing
    Then the database is updated with accurate partner and Plant information

  @TC-326
  Scenario: Cross-check Plant and partner assignments with business rules
    Given the user cross-checks the Plant and partner assignments
    Then the assignments comply with the defined business rules

  @TC-326
  Scenario Outline: Validate the system's ability to handle multiple records in the inbound file
    Given the user uploads an inbound file with "<record_count>" records
    When the user triggers the processing of the file
    Then the system processes all records without errors

    Examples:
      | record_count |
      | 1            |
      | 10           |
      | 100          |

  @TC-326
  Scenario: Ensure processed data is ready for subsequent workflows
    Given the user reviews the processed data
    Then the data is prepared for further processing without issues