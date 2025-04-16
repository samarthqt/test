import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import SimulationPage from '../pageObjects/SimulationPage';

const simulationPage = new SimulationPage();

Given('a player has completed a simulation', () => {
  simulationPage.completeSimulation();
});

When('the simulation results are submitted', () => {
  simulationPage.submitResults();
});

Then('the player should receive feedback comparing their solutions with correct answers', () => {
  simulationPage.verifyFeedbackContainsCorrectAnswers();
});

Then('the feedback should include suggestions for optimal strategies', () => {
  simulationPage.verifyFeedbackIncludesOptimalStrategies();
});

When('the feedback is generated', () => {
  simulationPage.generateFeedback();
});

Then('the feedback should display the correct answers for the simulation', () => {
  simulationPage.verifyFeedbackDisplaysCorrectAnswers();
});

Then('the feedback should include optimal strategies for solving the simulation', () => {
  simulationPage.verifyFeedbackIncludesOptimalStrategies();
});

Then('the feedback should be presented in a clear and understandable format', () => {
  simulationPage.verifyFeedbackIsClearAndUnderstandable();
});

When('the player wants to review the feedback', () => {
  simulationPage.reviewFeedback();
});

Then('the feedback should be accessible to the player at any time', () => {
  simulationPage.verifyFeedbackIsAccessible();
});

Then('the player should receive feedback promptly without delay', () => {
  simulationPage.verifyFeedbackIsPrompt();
});