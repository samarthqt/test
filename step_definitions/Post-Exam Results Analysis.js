import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import PostExamResultsPage from '../pageObjects/PostExamResultsPage';

const postExamResultsPage = new PostExamResultsPage();

Given('the player has completed an examination', () => {
  // Assuming the player has already completed the exam
});

When('the player accesses the post-exam results section', () => {
  postExamResultsPage.accessResultsSection();
});

Then('the player should see a detailed report of their examination results', () => {
  postExamResultsPage.verifyDetailedReport();
});

Given('the player is viewing the examination results', () => {
  postExamResultsPage.viewResults();
});

When('the player analyzes the results', () => {
  postExamResultsPage.analyzeResults();
});

Then('the player should be able to identify areas of strength', () => {
  postExamResultsPage.verifyStrengths();
});

Then('the player should be able to identify areas for improvement', () => {
  postExamResultsPage.verifyImprovements();
});

When('the player selects a specific question from the results', () => {
  postExamResultsPage.selectSpecificQuestion();
});

Then('the player should see a detailed analysis of their answer to that question', () => {
  postExamResultsPage.verifyQuestionAnalysis();
});

Then('the player should see the correct answer and explanations for the question', () => {
  postExamResultsPage.verifyCorrectAnswerAndExplanations();
});

When('the player chooses to filter the results', () => {
  postExamResultsPage.filterResults();
});

Then('the player should be able to filter the results by subject', () => {
  postExamResultsPage.filterBySubject();
});

Then('the player should be able to filter the results by topic', () => {
  postExamResultsPage.filterByTopic();
});

Given('the player has past examination results available', () => {
  postExamResultsPage.verifyPastResultsAvailable();
});

When('the player chooses to compare current results with past results', () => {
  postExamResultsPage.compareWithPastResults();
});

Then('the player should see a comparison chart or table', () => {
  postExamResultsPage.verifyComparisonChart();
});

Then('the player should be able to identify trends in performance over time', () => {
  postExamResultsPage.verifyPerformanceTrends();
});

Given('the player has analyzed the examination results', () => {
  postExamResultsPage.analyzedResults();
});

When('the player requests a summary report', () => {
  postExamResultsPage.requestSummaryReport();
});

Then('the player should receive a report highlighting key areas for improvement', () => {
  postExamResultsPage.verifySummaryReport();
});

Then('the report should provide recommendations for further study or practice', () => {
  postExamResultsPage.verifyRecommendations();
});