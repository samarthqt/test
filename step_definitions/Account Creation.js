import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import AccountCreationPage from '../page_objects/AccountCreationPage';

const accountCreationPage = new AccountCreationPage();

Given('I am logged in to the system with valid credentials', () => {
  cy.login('validUsername', 'validPassword');
});

When('I navigate to the account creation page', () => {
  accountCreationPage.visit();
});

When('I enter valid account details in the required fields', () => {
  accountCreationPage.enterAccountDetails({
    name: 'John Doe',
    email: 'johndoe@example.com',
    password: 'securePassword123'
  });
});

When('I click on the {string} button', (buttonText) => {
  accountCreationPage.clickButton(buttonText);
});

Then('I should see a confirmation message indicating the successful creation of the account', () => {
  accountCreationPage.verifyConfirmationMessage('Account created successfully');
});