class RegistrationPage {
  visit() {
    cy.visit('/registration');
  }

  selectRole(role) {
    cy.get('select#role').select(role);
  }

  enterUsername(username) {
    cy.get('input[name="username"]').type(username);
  }

  enterPassword(password) {
    cy.get('input[name="password"]').type(password);
  }

  submit() {
    cy.get('button[type="submit"]').click();
  }
}

class SecurityPage {
  performTransaction() {
    cy.get('button#performTransaction').click();
  }
}

class RiskAssessmentPage {
  visit() {
    cy.visit('/risk-assessment');
  }
}

class CompliancePage {
  engageActivities() {
    cy.get('button#engageActivities').click();
  }
}

class NotificationPage {
  completeTransaction() {
    cy.completeTransaction();
  }
}

class LoanApplicationPage {
  visit() {
    cy.visit('/loan-application');
  }

  submitApplication() {
    cy.get('button#submitApplication').click();
  }
}

class CommunicationPage {
  visit() {
    cy.visit('/communication');
  }

  exchangeMessages() {
    cy.get('button#exchangeMessages').click();
  }
}

class LoanDetailsPage {
  visit() {
    cy.visit('/loan-details');
  }
}

class AccessibilityPage {
  visit() {
    cy.visit('/');
  }
}