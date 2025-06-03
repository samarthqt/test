@E2E
Feature: Functionality of E-Book

  @LoginTest
  Scenario Outline: Successful Login with Valid Credentials
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    Examples:
      | tc_id    |
      | CWQA2405 |


  @HomeIconButtonTest
  Scenario Outline: Successful Re-directed to the Home Page
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And I click on home icon button navigation
    Examples:
      | tc_id    |
      | CWQA2405 |


  @TableOfContentsNavigationTest
  Scenario Outline: Table Of Contents Navigation
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And I click on table of contents Navigation
    Examples:
      | tc_id    |
      | CWQA2405 |


  @NavigationTest
  Scenario Outline: Navigation Toggle Functionality
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And I click on the bookmarks and recent and current page navigation
    Examples:
      | tc_id    |
      | CWQA2405 |

  @SearchButtonIconNavigationTest
  Scenario Outline: Verification Of Search Functionality
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And Verification of search functionality
    Examples:
      | tc_id    |
      | CWQA2405 |


  @NotebookTest
  Scenario Outline: Verification Of NoteBook
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And Verify RightSide Note Creation
    Examples:
      | tc_id    |
      | CWQA2405 |


  @FlashCardIconDesignMerged
  Scenario Outline: Verification Of flash
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And Verification of flashcardNote
    Examples:
      | tc_id    |
      | CWQA2405 |


  @DisplaySettingsNavigationTest
  Scenario Outline: Display Settings Functionality
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And I click on the display settings navigation
    Examples:
      | tc_id    |
      | CWQA2405 |


  @HideMenuOptionButtonTest
  Scenario Outline: Verification Of Hide Menu Option Button Functionality
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And I click on the hide menu option button
    Examples:
      | tc_id    |
      | CWQA2405 |


  @CheckSignOutFunctionalityTest
  Scenario Outline: Verification Of SignOut Functionality
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And Check signOut functionality
    Examples:
      | tc_id    |
      | CWQA2405 |


  @BookMarkTest
  Scenario Outline: Verification Of BookMark Functionality
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And I click on the add bookmark and remove bookmark button
    Examples:
      | tc_id    |
      | CWQA2405 |


  @LeftAndRightArrowNavigationTest
  Scenario Outline: Verification Of Left And Right Arrow Navigation Functionality
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And I click on the left and right arrow navigation
    Examples:
      | tc_id    |
      | CWQA2405 |


  @ExtractLinkTest
  Scenario Outline: Verification Link Functionality
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And Extract links in page of content
    Examples:
      | tc_id    |
      | CWQA2405 |


  @CheckVideoFunctionalityTest
  Scenario Outline: Verification Of Video Functionality
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And Video test functionality
    Examples:
      | tc_id    |
      | CWQA2405 |


  @CheckLightBoxImageViewerFunctionalityTest
  Scenario Outline: Verification Of Light Box Image Viewer Functionality
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And Light box image viewer functionality
    Examples:
      | tc_id    |
      | CWQA2405 |


  @ExtractLeftSideTOCContentTest
  Scenario Outline: Extract text from left side TOC
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And Extract left side TOC content
    Examples:
      | tc_id    |
      | CWQA2405 |


  @ExtractTextFromRightSideTest
  Scenario Outline: Extract text from right side
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And Extract text from right side
    Examples:
      | tc_id    |
      | CWQA2405 |














