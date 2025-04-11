import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import MealPlanPage from '../pageObjects/MealPlanPage';
import PaymentPage from '../pageObjects/PaymentPage';
import SubscriptionPage from '../pageObjects/SubscriptionPage';

const mealPlanPage = new MealPlanPage();
const paymentPage = new PaymentPage();
const subscriptionPage = new SubscriptionPage();

Given('the user is on the meal plan selection page', () => {
    mealPlanPage.visit();
});

When('the user selects a dietary preference such as keto, vegan, or diabetic-friendly', () => {
    mealPlanPage.selectDietaryPreference('keto');
});

Then('the system displays meal plans matching the selected dietary preference', () => {
    mealPlanPage.verifyMealPlansDisplayed();
});

Given('the user has selected a meal plan', () => {
    mealPlanPage.selectMealPlan();
});

When('the user views the details of a meal', () => {
    mealPlanPage.viewMealDetails();
});

Then('the system displays the nutritional information for that meal', () => {
    mealPlanPage.verifyNutritionalInformation();
});

Given('the user has an active subscription', () => {
    subscriptionPage.verifyActiveSubscription();
});

When('the user chooses to modify or cancel their subscription', () => {
    subscriptionPage.modifyOrCancelSubscription();
});

Then('the system allows the user to make changes or cancel the subscription easily', () => {
    subscriptionPage.verifySubscriptionModification();
});

Given('the user is browsing meal plans', () => {
    mealPlanPage.browseMealPlans();
});

When('the user views the available meal options', () => {
    mealPlanPage.viewAvailableMealOptions();
});

Then('the system provides a variety of meal options catering to different dietary needs', () => {
    mealPlanPage.verifyVarietyOfMealOptions();
});

When('the delivery date approaches', () => {
    subscriptionPage.checkDeliveryDate();
});

Then('the system ensures timely delivery of meal kits to the subscriber', () => {
    subscriptionPage.verifyTimelyDelivery();
});

When('the user browses and selects meal plans', () => {
    mealPlanPage.browseAndSelectMealPlans();
});

Then('the system provides a user-friendly interface for easy navigation and selection', () => {
    mealPlanPage.verifyUserFriendlyInterface();
});

Given('the user is on the payment page', () => {
    paymentPage.visit();
});

When('the user enters payment information', () => {
    paymentPage.enterPaymentInformation();
});

Then('the system securely handles the payment information and transactions', () => {
    paymentPage.verifySecurePaymentHandling();
});

When('there is an upcoming delivery or a change to the subscription', () => {
    subscriptionPage.checkForUpcomingDeliveryOrChange();
});

Then('the system notifies the user of the upcoming delivery and any subscription changes', () => {
    subscriptionPage.verifyNotifications();
});

Given('the user has received a meal delivery', () => {
    subscriptionPage.verifyMealDelivery();
});

When('the user chooses to provide feedback', () => {
    subscriptionPage.provideFeedback();
});

Then('the system allows the user to submit feedback on the meals and service', () => {
    subscriptionPage.verifyFeedbackSubmission();
});

Given('the service is operational', () => {
    subscriptionPage.verifyServiceOperational();
});

When('meals are prepared and delivered', () => {
    subscriptionPage.prepareAndDeliverMeals();
});

Then('the service complies with food safety and handling regulations', () => {
    subscriptionPage.verifyComplianceWithRegulations();
});