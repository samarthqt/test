import { Selector } from 'testcafe'; 

class LanguagePage {
  constructor() {
    this.languageDropdown = Selector('#languageDropdown');
    this.anotherPageLink = Selector('#anotherPageLink');
    this.contactUsLink = Selector('#contactUsLink');
    this.body = Selector('body');
  }

  async visitHomepage() {
    await t.navigateTo('/');
  }

  async selectLanguage(language) {
    await t.click(this.languageDropdown)
           .click(this.languageDropdown.find('option').withText(language));
  }

  async verifyLanguageContent(language) {
    await t.expect(this.body.innerText).contains(language);
  }

  async verifyDefaultLanguage() {
    await t.expect(this.body.innerText).contains('English');
  }

  async navigateToAnotherPage() {
    await t.click(this.anotherPageLink);
  }

  async navigateToContactUsPage() {
    await t.click(this.contactUsLink);
  }

  async verifyContactUsPageLanguage(language) {
    await t.expect(this.body.innerText).contains(language);
  }

  async verifyLanguageDropdownVisible() {
    await t.expect(this.languageDropdown.visible).ok();
  }
}

export default new LanguagePage();