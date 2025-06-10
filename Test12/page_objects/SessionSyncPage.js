import { Selector } from 'testcafe';

class SessionSyncPage {
  constructor() {
    this.loginButton = Selector('#loginBtn');
    this.sessionStatus = Selector('#sessionStatus');
  }

  async loginDesktop(t) {
    await t
      .navigateTo('/login-desktop')
      .click(this.loginButton);
  }

  async switchToMobile(t) {
    await t.navigateTo('/login-mobile');
  }

  async verifySessionSync(t) {
    await t.expect(this.sessionStatus.innerText).contains('synced');
  }
}

export default SessionSyncPage;