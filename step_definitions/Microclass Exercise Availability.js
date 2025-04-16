import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import MicroclassPage from '../pageObjects/MicroclassPage';

const microclassPage = new MicroclassPage();

Given('I am a registered player', () => {
  // Assume user is already registered and logged in
  cy.login();
});

When('I navigate to the microclass section', () => {
  microclassPage.navigateToMicroclassSection();
});

Then('I should see a list of available microclass exercises', () => {
  microclassPage.verifyListOfExercises();
});

Then('the microclass exercises should be accessible', () => {
  microclassPage.verifyExercisesAccessibility();
});

Given('I have accessed a microclass exercise', () => {
  microclassPage.accessMicroclassExercise();
});

When('I start the exercise', () => {
  microclassPage.startExercise();
});

Then('I should be able to complete all tasks within the exercise', () => {
  microclassPage.completeAllTasks();
});

Then('I should receive feedback on my performance', () => {
  microclassPage.verifyFeedbackReceived();
});

Given('there is an upcoming examination', () => {
  // Assume there is a method to check for upcoming exams
  cy.checkUpcomingExamination();
});

Then('I should be able to access and complete the microclass exercise related to the examination topics', () => {
  microclassPage.accessAndCompleteExamRelatedExercise();
});

Given('I have completed a microclass exercise', () => {
  microclassPage.completeMicroclassExercise();
});

When('I review the exercise feedback', () => {
  microclassPage.reviewExerciseFeedback();
});

Then('I should have a better understanding of the concepts involved', () => {
  microclassPage.verifyConceptUnderstanding();
});

Then('I should feel prepared for the examination', () => {
  microclassPage.verifyExamPreparation();
});