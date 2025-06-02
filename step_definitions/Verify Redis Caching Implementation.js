import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RedisPage from "../pages/redisPage";

Given("the Redis server is installed and configured", () => {
 RedisPage.verifyInstallation();
});

When("I start the Redis server", () => {
 RedisPage.startServer();
});

Then("the Redis server starts successfully without errors", () => {
 RedisPage.checkServerStatus();
});

Given("the application is ready to connect", () => {
 RedisPage.verifyAppReady();
});

When("I configure the application to connect to the Redis server", () => {
 RedisPage.configureAppConnection();
});

Then("the application connects to Redis server successfully", () => {
 RedisPage.checkAppConnection();
});

Given("the application is connected to Redis", () => {
 RedisPage.verifyAppConnected();
});

When("I send a request to the application that should result in a cacheable response", () => {
 RedisPage.sendCacheableRequest();
});

Then("the application processes the request and stores the response in Redis", () => {
 RedisPage.verifyResponseStored();
});

Given("a cacheable response has been stored", () => {
 RedisPage.verifyResponseStored();
});

When("I check the Redis cache for the stored response", () => {
 RedisPage.checkCacheForResponse();
});

Then("the response is found in the Redis cache", () => {
 RedisPage.verifyResponseInCache();
});

Given("the response is stored in Redis cache", () => {
 RedisPage.verifyResponseStored();
});

When("I send the same request again to the application", () => {
 RedisPage.sendSameRequest();
});

Then("the application retrieves the response from Redis cache, not from the original source", () => {
 RedisPage.verifyResponseRetrievedFromCache();
});

Given("the response is retrieved from Redis cache", () => {
 RedisPage.verifyResponseRetrievedFromCache();
});

When("I verify the time taken to retrieve the response", () => {
 RedisPage.verifyRetrievalTime();
});

Then("the retrieval time is significantly less than fetching from the original source", () => {
 RedisPage.checkRetrievalTime();
});

Given("the response is stored in Redis cache", () => {
 RedisPage.verifyResponseStored();
});

When("I invalidate the cache for the specific response", () => {
 RedisPage.invalidateCache();
});

Then("the cache entry for the response is removed", () => {
 RedisPage.verifyCacheEntryRemoved();
});

Given("the cache entry for the response is removed", () => {
 RedisPage.verifyCacheEntryRemoved();
});

When("I send the request again after cache invalidation", () => {
 RedisPage.sendRequestAfterInvalidation();
});

Then("the application fetches the response from the original source and caches it again", () => {
 RedisPage.verifyResponseFetchedAndCachedAgain();
});

Given("the Redis server is stopped", () => {
 RedisPage.stopServer();
});

When("I send a request to the application", () => {
 RedisPage.sendRequest();
});

Then("the application handles the absence of cache gracefully and fetches data from the original source", () => {
 RedisPage.verifyGracefulHandlingWithoutCache();
});

Given("the Redis server is restarted", () => {
 RedisPage.restartServer();
});

When("I repeat the request", () => {
 RedisPage.repeatRequest();
});

Then("the application resumes caching responses as expected", () => {
 RedisPage.verifyCachingResumed();
});

Given("the caching process is ongoing", () => {
 RedisPage.verifyCachingProcess();
});

When("I check Redis logs for any errors during the caching process", () => {
 RedisPage.checkLogsForErrors();
});

Then("no errors related to caching are found in the Redis logs", () => {
 RedisPage.verifyNoErrorsInLogs();
});

Given("the caching process is ongoing", () => {
 RedisPage.verifyCachingProcess();
});

When("I verify the memory usage of Redis", () => {
 RedisPage.verifyMemoryUsage();
});

Then("memory usage is within expected limits and does not cause any performance issues", () => {
 RedisPage.checkMemoryUsageLimits();
});

Given("the application is under high load", () => {
 RedisPage.simulateHighLoad();
});

When("I simulate a high load of requests to the application", () => {
 RedisPage.sendHighLoadRequests();
});

Then("Redis handles the increased load without performance degradation", () => {
 RedisPage.verifyPerformanceUnderLoad();
});

Given("the application is under high load", () => {
 RedisPage.simulateHighLoad();
});

When("I verify the consistency of cached data", () => {
 RedisPage.verifyCachedDataConsistency();
});

Then("cached data remains consistent and accurate even under high load", () => {
 RedisPage.checkDataConsistencyUnderLoad();
});

Given("the expiration policy is configured", () => {
 RedisPage.configureExpirationPolicy();
});

When("I test the expiration policy of cached data", () => {
 RedisPage.testExpirationPolicy();
});

Then("cached data expires as per the configured policy, and new data is fetched and cached", () => {
 RedisPage.verifyExpirationAndCaching();
});