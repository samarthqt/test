Feature: Microclass Exercise Availability
TCID:Req-2
""
As a player, I need to be able to access and complete the microclass exercise prior to examination to fully understand the concepts involved.
""
Scenario: Accessing the microclass exercise
Given I am a registered player
When I navigate to the microclass section
Then I should see a list of available microclass exercises
And the microclass exercises should be accessible
""
Scenario: Completing a microclass exercise
Given I have accessed a microclass exercise
When I start the exercise
Then I should be able to complete all tasks within the exercise
And I should receive feedback on my performance
""
Scenario: Accessing microclass exercise prior to examination
Given I am a registered player
And there is an upcoming examination
When I navigate to the microclass section
Then I should be able to access and complete the microclass exercise related to the examination topics
""
Scenario: Understanding concepts through microclass exercise
Given I have completed a microclass exercise
When I review the exercise feedback
Then I should have a better understanding of the concepts involved
And I should feel prepared for the examination
```gherkin
TCID:Req-3