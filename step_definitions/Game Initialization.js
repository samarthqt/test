import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import GamePage from '../page_objects/GamePage';

const gamePage = new GamePage();

Given('the game application is installed', () => {
  gamePage.verifyGameInstalled();
});

When('the player launches the game', () => {
  gamePage.launchGame();
});

Then('the game should load without errors', () => {
  gamePage.verifyGameLoadsWithoutErrors();
});

Then('the main menu should be displayed', () => {
  gamePage.verifyMainMenuDisplayed();
});

Given('the game is loaded and the main menu is displayed', () => {
  gamePage.verifyGameLoadedAndMainMenuDisplayed();
});

When('the player selects the "Start Game" option', () => {
  gamePage.selectStartGameOption();
});

Then('the game should transition to the pre-examination stage', () => {
  gamePage.verifyTransitionToPreExaminationStage();
});

Then('the pre-examination stage interface should be displayed correctly', () => {
  gamePage.verifyPreExaminationStageInterface();
});

When('there is an error during loading', () => {
  gamePage.simulateLoadingError();
});

Then('an error message should be displayed', () => {
  gamePage.verifyErrorMessageDisplayed();
});

Then('the player should be prompted to retry or exit the game', () => {
  gamePage.verifyRetryOrExitPrompt();
});

Given('the game is in the loading phase', () => {
  gamePage.verifyGameInLoadingPhase();
});

When('the loading process is complete', () => {
  gamePage.completeLoadingProcess();
});

Then('all necessary game resources should be loaded', () => {
  gamePage.verifyGameResourcesLoaded();
});

Then('the game should be ready for the pre-examination stage', () => {
  gamePage.verifyGameReadyForPreExaminationStage();
});

Given('the game has transitioned to the pre-examination stage', () => {
  gamePage.verifyTransitionedToPreExaminationStage();
});

When('the pre-examination stage is displayed', () => {
  gamePage.verifyPreExaminationStageDisplayed();
});

Then('the player should see all necessary instructions and options', () => {
  gamePage.verifyInstructionsAndOptionsDisplayed();
});

Then('the game should be ready to proceed to the next stage upon player confirmation', () => {
  gamePage.verifyGameReadyToProceed();
});