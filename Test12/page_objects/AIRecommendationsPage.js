import { Selector } from 'testcafe';
import { expect } from 'chai';

class AIRecommendationsPage {
  constructor() {
    this.optInButton = Selector('#opt-in');
    this.optOutButton = Selector('#opt-out');
    this.recommendationsSection = Selector('#recommendations');
    this.explanationButton = Selector('#explanation');
    this.userHistorySection = Selector('#user-history');
    this.newDataIndicator = Selector('#new-data');
  }

  async userInteracts(t) {
    await t.click(this.userHistorySection);
  }

  async analyzeBehavior(t) {
    await t.click(this.recommendationsSection);
  }

  async verifyAnalysisAccuracy(t) {
    const analysisAccuracy = await this.recommendationsSection.getAttribute('data-accuracy');
    expect(analysisAccuracy).to.be.above(0.8);
  }

  async userHasHistory(t) {
    const historyExists = await this.userHistorySection.exists;
    expect(historyExists).to.be.true;
  }

  async generateRecommendations(t) {
    await t.click(this.recommendationsSection);
  }

  async verifyRecommendationsRelevance(t) {
    const relevanceScore = await this.recommendationsSection.getAttribute('data-relevance');
    expect(relevanceScore).to.be.above(0.7);
  }

  async verifyRecommendationsPersonalization(t) {
    const personalizationScore = await this.recommendationsSection.getAttribute('data-personalization');
    expect(personalizationScore).to.be.above(0.7);
  }

  async userNotOptedIn(t) {
    const isOptedIn = await this.optInButton.hasAttribute('disabled');
    expect(isOptedIn).to.be.false;
  }

  async userOptsIn(t) {
    await t.click(this.optInButton);
  }

  async verifyStartRecommendations(t) {
    const recommendationsStarted = await this.recommendationsSection.hasAttribute('data-active');
    expect(recommendationsStarted).to.be.true;
  }

  async userOptedIn(t) {
    const isOptedIn = await this.optInButton.hasAttribute('disabled');
    expect(isOptedIn).to.be.true;
  }

  async userOptsOut(t) {
    await t.click(this.optOutButton);
  }

  async verifyStopRecommendations(t) {
    const recommendationsStopped = await this.recommendationsSection.hasAttribute('data-active');
    expect(recommendationsStopped).to.be.false;
  }

  async recommendationsGenerated(t) {
    const recommendationsExist = await this.recommendationsSection.exists;
    expect(recommendationsExist).to.be.true;
  }

  async newDataAvailable(t) {
    await t.click(this.newDataIndicator);
  }

  async verifyRecommendationsUpdate(t) {
    const recommendationsUpdated = await this.recommendationsSection.hasAttribute('data-updated');
    expect(recommendationsUpdated).to.be.true;
  }

  async userReceivesRecommendations(t) {
    const recommendationsReceived = await this.recommendationsSection.exists;
    expect(recommendationsReceived).to.be.true;
  }

  async requestExplanation(t) {
    await t.click(this.explanationButton);
  }

  async verifyExplanationProvided(t) {
    const explanationProvided = await this.explanationButton.hasAttribute('data-explanation');
    expect(explanationProvided).to.be.true;
  }
}

export default AIRecommendationsPage;