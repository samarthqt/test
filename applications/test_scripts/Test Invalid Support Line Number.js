describe('TC-95 73 Test Invalid Support Line Number', () => {
  it('should show an error message when an invalid support line number is dialed', () => {
    const invalidNumber = '+0000000000';
    const supportPage = new SupportPage();
    
    supportPage.visit();
    supportPage.dialNumber(invalidNumber);
    
    supportPage.getErrorMessage().should('contain', 'invalid');
  });
});