import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import HealthcareMarketplacePage from '../pageObjects/HealthcareMarketplacePage';

const healthcarePage = new HealthcareMarketplacePage();

Given('the user is on the healthcare marketplace platform', () => {
  healthcarePage.visitPlatform();
});

When('the user searches for healthcare professionals by specialty {string} and location {string}', (specialty, location) => {
  healthcarePage.searchProfessionals(specialty, location);
});

Then('the system should display a list of healthcare professionals matching the criteria', () => {
  healthcarePage.verifySearchResults();
});

When('the user selects a healthcare service', () => {
  healthcarePage.selectHealthcareService();
});

Then('the user should be able to read existing reviews', () => {
  healthcarePage.readReviews();
});

Then('the user should be able to write a new review for the service', () => {
  healthcarePage.writeReview();
});

When('the user selects a healthcare professional to book an appointment', () => {
  healthcarePage.selectProfessionalForAppointment();
});

Then('the system should display real-time availability of appointments', () => {
  healthcarePage.checkAppointmentAvailability();
});

Then('the user should be able to book an appointment successfully', () => {
  healthcarePage.bookAppointment();
});

When('the user views the details of a healthcare service', () => {
  healthcarePage.viewServiceDetails();
});

Then('the system should display clear and transparent pricing information', () => {
  healthcarePage.verifyPricingTransparency();
});

Given('the user has booked an appointment on the healthcare marketplace platform', () => {
  healthcarePage.bookedAppointment();
});

When('the appointment is confirmed', () => {
  healthcarePage.confirmAppointment();
});

Then('the system should send a confirmation notification to the user', () => {
  healthcarePage.sendConfirmationNotification();
});

Then('the system should send a reminder notification prior to the appointment', () => {
  healthcarePage.sendReminderNotification();
});

When('the user enters personal and payment information', () => {
  healthcarePage.enterPersonalAndPaymentInfo();
});

Then('the system should ensure that all user data and payment information is securely protected', () => {
  healthcarePage.verifyDataProtection();
});

Given('the user is interacting with the healthcare marketplace platform', () => {
  healthcarePage.interactingWithPlatform();
});

When('the user performs any action', () => {
  healthcarePage.performAnyAction();
});

Then('the system should log the interaction for future analysis and improvement', () => {
  healthcarePage.logUserInteraction();
});

Given('the healthcare marketplace platform is integrated with providers' scheduling systems', () => {
  healthcarePage.integratedWithSchedulingSystems();
});

When('the user books an appointment', () => {
  healthcarePage.bookAppointmentWithProvider();
});

Then('the system should synchronize with the provider's scheduling system to confirm the booking', () => {
  healthcarePage.synchronizeWithProvider();
});

Given('the healthcare marketplace platform is operational', () => {
  healthcarePage.platformOperational();
});

When('the platform processes healthcare services and transactions', () => {
  healthcarePage.processServicesAndTransactions();
});

Then('the system should comply with all relevant healthcare and e-commerce regulations', () => {
  healthcarePage.verifyCompliance();
});