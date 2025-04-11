import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import DigitalWalletPage from '../page_objects/DigitalWalletPage';

Given('a user with access to the digital wallet', () => {
  DigitalWalletPage.visit();
  DigitalWalletPage.verifyAccess();
});

When('the user adds digital assets to the wallet', () => {
  DigitalWalletPage.addDigitalAssets();
});

Then('the user should be able to store and manage at least three types of digital assets such as loyalty points and gift cards', () => {
  DigitalWalletPage.verifyDigitalAssetsManagement();
});

Given('a user with a digital wallet', () => {
  DigitalWalletPage.visit();
  DigitalWalletPage.verifyAccess();
});

When('the user initiates a payment using Apple Pay', () => {
  DigitalWalletPage.initiateApplePayPayment();
});

Then('the transaction should be successfully processed through Apple Pay', () => {
  DigitalWalletPage.verifyApplePayTransaction();
});

When('the user initiates a payment using Google Wallet', () => {
  DigitalWalletPage.initiateGoogleWalletPayment();
});

Then('the transaction should be successfully processed through Google Wallet', () => {
  DigitalWalletPage.verifyGoogleWalletTransaction();
});

When('the user performs a transaction', () => {
  DigitalWalletPage.performTransaction();
});

Then('the transaction must comply with PCI-DSS security standards', () => {
  DigitalWalletPage.verifyPCIDSSCompliance();
});

When('the user completes a transaction', () => {
  DigitalWalletPage.completeTransaction();
});

Then('the user should receive a notification for the wallet transaction', () => {
  DigitalWalletPage.verifyTransactionNotification();
});

When('the user initiates a payment', () => {
  DigitalWalletPage.initiatePayment();
});

Then('the digital wallet must integrate with existing payment systems for seamless transactions', () => {
  DigitalWalletPage.verifyIntegrationWithPaymentSystems();
});