class SymptomCheckerPage {
  static get symptomInputField() {
    return '#symptom-input';
  }

  static get checkSymptomsButton() {
    return '#check-symptoms';
  }

  static get diagnosisList() {
    return '#diagnosis-list';
  }
}

class LoginPage {
  static login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#login-button').click();
  }
}

class LogoutPage {
  static logout() {
    cy.get('#logout-button').click();
  }
}