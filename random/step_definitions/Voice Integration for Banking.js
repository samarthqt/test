import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import VoiceBankingPage from '../page_objects/VoiceBankingPage';

const voiceBankingPage = new VoiceBankingPage();

Given('a user has a voice assistant integrated with their banking app', () => {
  voiceBankingPage.integrateVoiceAssistant();
});

When('the user gives a voice command to check their balance', () => {
  voiceBankingPage.giveVoiceCommand('check balance');
});

Then('the system should process the command within 5 seconds', () => {
  voiceBankingPage.verifyCommandProcessedWithin(5000);
});

Then('the system should provide the account balance to the user', () => {
  voiceBankingPage.verifyAccountBalanceProvided();
});

When('the user gives a voice command to transfer funds', () => {
  voiceBankingPage.giveVoiceCommand('transfer funds');
});

When('the transaction amount is below the multi-factor authentication threshold', () => {
  voiceBankingPage.verifyTransactionAmountBelowThreshold();
});

Then('the system should transfer the funds as requested', () => {
  voiceBankingPage.verifyFundsTransferred();
});

When('the transaction amount is above the multi-factor authentication threshold', () => {
  voiceBankingPage.verifyTransactionAmountAboveThreshold();
});

Then('the system should request multi-factor authentication', () => {
  voiceBankingPage.requestMultiFactorAuthentication();
});

Then('the user provides valid authentication', () => {
  voiceBankingPage.provideValidAuthentication();
});

When('the user gives a voice command to view transaction history', () => {
  voiceBankingPage.giveVoiceCommand('view transaction history');
});

Then('the system should provide the transaction history to the user', () => {
  voiceBankingPage.verifyTransactionHistoryProvided();
});

Given('a user has performed a banking task using a voice command', () => {
  voiceBankingPage.performBankingTaskUsingVoiceCommand();
});

Then('the system must log the voice interaction for audit purposes', () => {
  voiceBankingPage.verifyVoiceInteractionLogged();
});

When('a voice command execution is successful', () => {
  voiceBankingPage.verifyVoiceCommandExecutionSuccess();
});

Then('the user should be notified of the successful execution', () => {
  voiceBankingPage.verifyUserNotifiedOfSuccess();
});

When('a voice command execution fails', () => {
  voiceBankingPage.verifyVoiceCommandExecutionFailure();
});

Then('the user should be notified of the failed execution', () => {
  voiceBankingPage.verifyUserNotifiedOfFailure();
});