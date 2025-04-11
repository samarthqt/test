import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ChatbotPage from '../../support/pageObjects/ChatbotPage';

const chatbotPage = new ChatbotPage();

Given('the AI-powered chatbot is active', () => {
  chatbotPage.verifyChatbotIsActive();
});

When('a user asks a common banking query', () => {
  chatbotPage.askCommonBankingQuery();
});

Then('the chatbot should respond with the correct information', () => {
  chatbotPage.verifyChatbotResponse();
});

Then('the chatbot should handle at least 10 different common banking queries', () => {
  chatbotPage.verifyHandlingMultipleQueries(10);
});

When('a user sends a query', () => {
  chatbotPage.sendQuery();
});

Then('the chatbot should respond in less than 2 seconds', () => {
  chatbotPage.verifyResponseTime(2000);
});

When('a user query cannot be resolved within 3 interactions', () => {
  chatbotPage.simulateUnresolvedQuery();
});

Then('the chatbot should escalate the query to a human agent', () => {
  chatbotPage.verifyEscalationToHumanAgent();
});

When('a user interacts with the chatbot', () => {
  chatbotPage.interactWithChatbot();
});

Then('all interactions should comply with data privacy standards', () => {
  chatbotPage.verifyDataPrivacyCompliance();
});

When('a user finishes interacting with the chatbot', () => {
  chatbotPage.finishInteraction();
});

Then('the user should be able to rate their chatbot experience for continuous improvement', () => {
  chatbotPage.verifyRatingFeature();
});