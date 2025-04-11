class MealPlanPage {
    visit() {
        cy.visit('/meal-plan-selection');
    }

    selectDietaryPreference(preference) {
        cy.get(`[data-test=${preference}]`).click();
    }

    verifyMealPlansDisplayed() {
        cy.get('.meal-plan').should('be.visible');
    }

    selectMealPlan() {
        cy.get('.meal-plan').first().click();
    }

    viewMealDetails() {
        cy.get('.meal-details').click();
    }

    verifyNutritionalInformation() {
        cy.get('.nutritional-info').should('be.visible');
    }

    browseMealPlans() {
        cy.get('.browse-meal-plans').click();
    }

    viewAvailableMealOptions() {
        cy.get('.meal-options').click();
    }

    verifyVarietyOfMealOptions() {
        cy.get('.meal-options-variety').should('be.visible');
    }

    browseAndSelectMealPlans() {
        cy.get('.meal-plan').click();
    }

    verifyUserFriendlyInterface() {
        cy.get('.user-friendly-interface').should('exist');
    }
}

class PaymentPage {
    visit() {
        cy.visit('/payment');
    }

    enterPaymentInformation() {
        cy.get('#payment-info').type('4111111111111111');
    }

    verifySecurePaymentHandling() {
        cy.get('.secure-payment').should('exist');
    }
}

class SubscriptionPage {
    verifyActiveSubscription() {
        cy.get('.active-subscription').should('exist');
    }

    modifyOrCancelSubscription() {
        cy.get('.modify-cancel-subscription').click();
    }

    verifySubscriptionModification() {
        cy.get('.subscription-modified').should('exist');
    }

    checkDeliveryDate() {
        cy.get('.delivery-date').should('exist');
    }

    verifyTimelyDelivery() {
        cy.get('.timely-delivery').should('exist');
    }

    checkForUpcomingDeliveryOrChange() {
        cy.get('.upcoming-delivery-or-change').should('exist');
    }

    verifyNotifications() {
        cy.get('.notifications').should('exist');
    }

    verifyMealDelivery() {
        cy.get('.meal-delivery').should('exist');
    }

    provideFeedback() {
        cy.get('.provide-feedback').click();
    }

    verifyFeedbackSubmission() {
        cy.get('.feedback-submitted').should('exist');
    }

    verifyServiceOperational() {
        cy.get('.service-operational').should('exist');
    }

    prepareAndDeliverMeals() {
        cy.get('.prepare-deliver-meals').click();
    }

    verifyComplianceWithRegulations() {
        cy.get('.compliance-regulations').should('exist');
    }
}