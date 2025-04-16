describe('User Login with Cross-Site Scripting (XSS) Attempt', () => {
  const loginPage = new LoginPage();

  it('should display error message and prevent XSS execution', () => {
    loginPage.visit();
    loginPage.enterUsername('<script>alert("XSS")</script>');
    loginPage.enterPassword('<script>alert("XSS")</script>');
    loginPage.clickLogin();
    loginPage.assertErrorMessageDisplayed();
    loginPage.assertNoScriptExecution();
  });
});