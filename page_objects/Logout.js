import { Selector } from 'testcafe';
 
class Logout {
  constructor() {
    this.logoutButton = Selector('#logout-button');
    this.confirmLogoutButton = Selector('#confirm-logout');
    this.logoutMessage = Selector('.logout-message');
  }

  async performLogout() {
    await t.click(this.logoutButton);
    await t.click(this.confirmLogoutButton);
  }

  async verifyLogoutMessage(expectedMessage) {
    await t.expect(this.logoutMessage.innerText).eql(expectedMessage, 'Logout message is incorrect');
  }
}

export default Logout;