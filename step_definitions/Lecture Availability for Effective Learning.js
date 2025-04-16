import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import LecturePage from '../page_objects/LecturePage';

const lecturePage = new LecturePage();

Given('the player is logged into the game', () => {
  // Implement login functionality
  cy.login();
});

When('the player navigates to the lecture section', () => {
  lecturePage.navigateToLectureSection();
});

Then('the player should see a list of available lecture slides', () => {
  lecturePage.verifyLectureSlidesList();
});

Then('the player should be able to open and view each lecture slide', () => {
  lecturePage.openAndViewLectureSlides();
});

Then('the player should see a list of available lecture videos', () => {
  lecturePage.verifyLectureVideosList();
});

Then('the player should be able to play each lecture video', () => {
  lecturePage.playLectureVideos();
});

Then('the player should have access to both slides and videos', () => {
  lecturePage.verifyAccessToSlidesAndVideos();
});

Then('the content should be relevant to the game learning objectives', () => {
  lecturePage.verifyContentRelevance();
});

When('the player checks the lecture section', () => {
  lecturePage.checkLectureSection();
});

Then('the system should confirm the availability of all required lecture slides and videos', () => {
  lecturePage.confirmContentAvailability();
});

Then('notify the player if any content is missing', () => {
  lecturePage.notifyMissingContent();
});