describe('Push Notification Edge Case for Maximum Character Limit', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const notificationPage = new NotificationPage();

  it('should log in successfully and check push notification', () => {
    // Step 1: Log in to the application as a registered user
    loginPage.visit();
    loginPage.enterUsername('registeredUser');
    loginPage.enterPassword('userPassword');
    loginPage.submit();

    // Assertion: User successfully logs in and is directed to the home screen
    homePage.verifyHomePage();

    // Step 2: Ensure push notifications are enabled in the device settings
    notificationPage.enablePushNotifications();

    // Assertion: Push notifications are enabled
    notificationPage.verifyPushNotificationsEnabled();

    // Step 3: Trigger a long message notification from the admin panel
    notificationPage.triggerLongMessageNotification();

    // Step 4: Check the user's device for the notification
    notificationPage.verifyNotificationReceived(
      'This is a very long system update message designed to test the maximum character limit of push notifications. Please ensure that the message is displayed correctly without any truncation or errors.'
    );
  });
});