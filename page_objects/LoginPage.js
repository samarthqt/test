import { Selector } from 'testcafe'

class LoginPage {
  constructor() {
    this.usernameInput = Selector('#username');
    this.passwordInput = Selector('#password');
    this.loginButton = Selector('#loginButton');
    this.errorMessage = Selector('.error-message');
  }

  async login(username, password) {
    await t
      .typeText(this.usernameInput, username)
      .typeText(this.passwordInput, password)
      .click(this.loginButton);
  }

  async loginWithValidation(username, password) {
    await this.login(username, password);
    await t.expect(this.errorMessage.exists).notOk('Login failed. Error message is displayed.');
  }

  async isErrorMessageDisplayed() {
    return await this.errorMessage.exists;
  }
}

export default LoginPage;