import { Selector } from 'testcafe';
class PlayStorePage {
  constructor() {
    this.searchInput = Selector('input[aria-label=\Search\]');
    this.searchButton = Selector('button').withText('Search');
    this.appTitle = Selector('h1[itemprop=
ame\]');
    this.installButton = Selector('button').withText('Install');
    this.openButton = Selector('button').withText('Open');
    this.downloadProgress = Selector('.progress-bar');
  }

  static ensureAccess() {
    cy.visit('https://play.google.com/store');
    cy.url().should('include', '/store');
  }

  static open() {
    cy.visit('https://play.google.com/store');
  }

  static verifyOpen() {
    cy.url().should('include', '/store');
  }

  static searchForApp(appName) {
    cy.get(this.searchInput).type(appName);
    cy.get(this.searchButton).click();
  }

  static verifyAppInResults(appName) {
    cy.contains(appName).should('be.visible');
  }

  static selectApp(appName) {
    cy.contains(appName).click();
  }

  static verifyAppDetailsPage(appName) {
    cy.get(this.appTitle).should('contain', appName);
  }

  static initiateDownload() {
    cy.get(this.installButton).click();
  }

  static verifyDownloadStarts() {
    cy.get(this.downloadProgress).should('be.visible');
  }

  static verifyAppInstalled() {
    cy.get(this.openButton).should('be.visible');
  }

  static openApp() {
    cy.get(this.openButton).click();
  }

  static verifyAppLaunch(appName) {
    cy.contains(appName).should('be.visible');
  }

  static completeInitialSetup() {
    // Logic for completing initial setup
  }

  static verifySetupComplete() {
    // Logic to verify setup completion
  }
}

export default PlayStorePage;