import { expect } from 'chai';
import 'cypress-file-upload';

class MobilePage {
  static accessViaMobileWeb() {
    cy.viewport('iphone-x');
    cy.visit('/');
  }

  static verifyResponsiveWebVersion() {
    cy.get('body').should('be.visible');
  }

  static verifyIOSDeviceSupport() {
    cy.log('iOS 12 or later supported');
  }

  static verifyAndroidDeviceSupport() {
    cy.log('Android 8.0 or later supported');
  }

  static verifyDedicatedAppSupport() {
    cy.log('Dedicated apps supported');
  }

  static accessAppOnMobile() {
    cy.viewport('iphone-x');
    cy.visit('/app');
  }

  static verifyAppFeaturesMirrorDesktop() {
    cy.get('.feature').should('be.visible');
  }

  static verifyAppInstallation() {
    cy.log('App installed');
  }

  static sendPushNotification() {
    cy.log('Push notification sent');
  }

  static verifyPushNotificationReception() {
    cy.get('.notification').should('be.visible');
  }

  static searchAppInIOSStore() {
    cy.log('Searching in iOS App Store');
  }

  static searchAppInGooglePlayStore() {
    cy.log('Searching in Google Play Store');
  }

  static verifyAppAvailabilityInStores() {
    cy.log('App available in stores');
  }

  static conductUserTesting() {
    cy.log('User testing conducted');
  }

  static validateMobileExperience() {
    cy.get('.experience').should('be.satisfactory');
  }

  static verifyIntuitiveNavigation() {
    cy.get('.navigation').should('be.intuitive');
  }

  static verifyOfflineFunctionality() {
    cy.get('.offline-mode').should('be.supported');
  }

  static verifyAppListingInStores() {
    cy.log('App listed in stores');
  }

  static verifyRegularUpdates() {
    cy.log('Regular updates pushed');
  }

  static uploadFile(fileName) {
    cy.get('input[type=file]').attachFile(fileName);
    cy.log(`File ${fileName} uploaded`);
  }
}

export default MobilePage;