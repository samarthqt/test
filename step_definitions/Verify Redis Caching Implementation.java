package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.RedisPage;

public class RedisCachingSteps extends RedisPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the Redis server is installed and configured")
    public void theRedisServerIsInstalledAndConfigured() {
        verifyRedisInstallation();
    }

    @When("I start the Redis server")
    public void iStartTheRedisServer() {
        startRedisServer();
    }

    @Then("the Redis server starts successfully without errors")
    public void theRedisServerStartsSuccessfullyWithoutErrors() {
        verifyRedisServerStarted();
    }

    @Given("the application is ready to connect")
    public void theApplicationIsReadyToConnect() {
        prepareApplicationForConnection();
    }

    @When("I configure the application to connect to the Redis server")
    public void iConfigureTheApplicationToConnectToTheRedisServer() {
        configureApplicationConnection();
    }

    @Then("the application connects to Redis server successfully")
    public void theApplicationConnectsToRedisServerSuccessfully() {
        verifyApplicationConnection();
    }

    @Given("the application is connected to Redis")
    public void theApplicationIsConnectedToRedis() {
        verifyApplicationConnection();
    }

    @When("I send a request to the application that should result in a cacheable response")
    public void iSendARequestToTheApplicationThatShouldResultInACacheableResponse() {
        sendCacheableRequest();
    }

    @Then("the application processes the request and stores the response in Redis")
    public void theApplicationProcessesTheRequestAndStoresTheResponseInRedis() {
        verifyResponseStoredInRedis();
    }

    @Given("a cacheable response has been stored")
    public void aCacheableResponseHasBeenStored() {
        verifyResponseStoredInRedis();
    }

    @When("I check the Redis cache for the stored response")
    public void iCheckTheRedisCacheForTheStoredResponse() {
        checkRedisCacheForResponse();
    }

    @Then("the response is found in the Redis cache")
    public void theResponseIsFoundInTheRedisCache() {
        verifyResponseInCache();
    }

    @Given("the response is stored in Redis cache")
    public void theResponseIsStoredInRedisCache() {
        verifyResponseStoredInRedis();
    }

    @When("I send the same request again to the application")
    public void iSendTheSameRequestAgainToTheApplication() {
        sendSameRequest();
    }

    @Then("the application retrieves the response from Redis cache, not from the original source")
    public void theApplicationRetrievesTheResponseFromRedisCacheNotFromTheOriginalSource() {
        verifyResponseRetrievedFromCache();
    }

    @Given("the response is retrieved from Redis cache")
    public void theResponseIsRetrievedFromRedisCache() {
        verifyResponseRetrievedFromCache();
    }

    @When("I verify the time taken to retrieve the response")
    public void iVerifyTheTimeTakenToRetrieveTheResponse() {
        verifyRetrievalTime();
    }

    @Then("the retrieval time is significantly less than fetching from the original source")
    public void theRetrievalTimeIsSignificantlyLessThanFetchingFromTheOriginalSource() {
        verifyRetrievalTimeEfficiency();
    }

    @Given("the response is stored in Redis cache")
    public void theResponseIsStoredInRedisCacheAgain() {
        verifyResponseStoredInRedis();
    }

    @When("I invalidate the cache for the specific response")
    public void iInvalidateTheCacheForTheSpecificResponse() {
        invalidateCacheForResponse();
    }

    @Then("the cache entry for the response is removed")
    public void theCacheEntryForTheResponseIsRemoved() {
        verifyCacheEntryRemoved();
    }

    @Given("the cache entry for the response is removed")
    public void theCacheEntryForTheResponseIsRemovedAgain() {
        verifyCacheEntryRemoved();
    }

    @When("I send the request again after cache invalidation")
    public void iSendTheRequestAgainAfterCacheInvalidation() {
        sendRequestAfterInvalidation();
    }

    @Then("the application fetches the response from the original source and caches it again")
    public void theApplicationFetchesTheResponseFromTheOriginalSourceAndCachesItAgain() {
        verifyResponseFetchedAndCachedAgain();
    }

    @Given("the Redis server is stopped")
    public void theRedisServerIsStopped() {
        stopRedisServer();
    }

    @When("I send a request to the application")
    public void iSendARequestToTheApplication() {
        sendRequestToApplication();
    }

    @Then("the application handles the absence of cache gracefully and fetches data from the original source")
    public void theApplicationHandlesTheAbsenceOfCacheGracefullyAndFetchesDataFromTheOriginalSource() {
        verifyGracefulHandlingOfCacheAbsence();
    }

    @Given("the Redis server is restarted")
    public void theRedisServerIsRestarted() {
        restartRedisServer();
    }

    @When("I repeat the request")
    public void iRepeatTheRequest() {
        repeatRequest();
    }

    @Then("the application resumes caching responses as expected")
    public void theApplicationResumesCachingResponsesAsExpected() {
        verifyCachingResumed();
    }

    @Given("the caching process is ongoing")
    public void theCachingProcessIsOngoing() {
        verifyCachingProcessOngoing();
    }

    @When("I check Redis logs for any errors during the caching process")
    public void iCheckRedisLogsForAnyErrorsDuringTheCachingProcess() {
        checkRedisLogsForErrors();
    }

    @Then("no errors related to caching are found in the Redis logs")
    public void noErrorsRelatedToCachingAreFoundInTheRedisLogs() {
        verifyNoErrorsInLogs();
    }

    @Given("the caching process is ongoing")
    public void theCachingProcessIsOngoingAgain() {
        verifyCachingProcessOngoing();
    }

    @When("I verify the memory usage of Redis")
    public void iVerifyTheMemoryUsageOfRedis() {
        verifyMemoryUsage();
    }

    @Then("memory usage is within expected limits and does not cause any performance issues")
    public void memoryUsageIsWithinExpectedLimitsAndDoesNotCauseAnyPerformanceIssues() {
        verifyMemoryUsageLimits();
    }

    @Given("the application is under high load")
    public void theApplicationIsUnderHighLoad() {
        simulateHighLoad();
    }

    @When("I simulate a high load of requests to the application")
    public void iSimulateAHighLoadOfRequestsToTheApplication() {
        simulateHighLoadRequests();
    }

    @Then("Redis handles the increased load without performance degradation")
    public void redisHandlesTheIncreasedLoadWithoutPerformanceDegradation() {
        verifyRedisPerformanceUnderLoad();
    }

    @Given("the application is under high load")
    public void theApplicationIsUnderHighLoadAgain() {
        simulateHighLoad();
    }

    @When("I verify the consistency of cached data")
    public void iVerifyTheConsistencyOfCachedData() {
        verifyCachedDataConsistency();
    }

    @Then("cached data remains consistent and accurate even under high load")
    public void cachedDataRemainsConsistentAndAccurateEvenUnderHighLoad() {
        verifyDataConsistencyUnderLoad();
    }

    @Given("the expiration policy is configured")
    public void theExpirationPolicyIsConfigured() {
        configureExpirationPolicy();
    }

    @When("I test the expiration policy of cached data")
    public void iTestTheExpirationPolicyOfCachedData() {
        testExpirationPolicy();
    }

    @Then("cached data expires as per the configured policy, and new data is fetched and cached")
    public void cachedDataExpiresAsPerTheConfiguredPolicyAndNewDataIsFetchedAndCached() {
        verifyExpirationAndCaching();
    }
}