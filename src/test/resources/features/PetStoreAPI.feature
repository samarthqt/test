Feature: Everything about your Pets

  Scenario: Add a new pet to the store
    Given I have a pet named "Buddy" with status "available"
    When I add the pet to the store
    Then the pet should be added successfully

  Scenario: Get pet by ID
    Given I have added a pet named "Whiskers" with status "sold"
    When I retrieve the pet by ID
    Then the response should contain the pet name "Whiskers" and status "sold"

  Scenario: Update an existing pet
    Given I have added a pet named "Max" with status "pending"
    When I update the pet's status to "available"
    Then the updated pet should have status "available"

  Scenario: Delete a pet
    Given I have added a pet named "Ghost" with status "available"
    When I delete the pet
    Then retrieving the pet by ID should return status 404