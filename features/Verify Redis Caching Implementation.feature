Feature: Verify Redis Caching Implementation
@TC-289
Scenario: Start the Redis server
Given the Redis server is installed and configured
When I start the Redis server
Then the Redis server starts successfully without errors
@TC-289
Scenario: Configure application to connect to Redis server
Given the application is ready to connect
When I configure the application to connect to the Redis server
Then the application connects to Redis server successfully
@TC-289
Scenario: Send a request resulting in a cacheable response
Given the application is connected to Redis
When I send a request to the application that should result in a cacheable response
Then the application processes the request and stores the response in Redis
@TC-289
Scenario: Check stored response in Redis cache
Given a cacheable response has been stored
When I check the Redis cache for the stored response
Then the response is found in the Redis cache
@TC-289
Scenario: Retrieve response from Redis cache
Given the response is stored in Redis cache
When I send the same request again to the application
Then the application retrieves the response from Redis cache, not from the original source
@TC-289
Scenario: Verify retrieval time from cache
Given the response is retrieved from Redis cache
When I verify the time taken to retrieve the response
Then the retrieval time is significantly less than fetching from the original source
@TC-289
Scenario: Invalidate cache for specific response
Given the response is stored in Redis cache
When I invalidate the cache for the specific response
Then the cache entry for the response is removed
@TC-289
Scenario: Fetch response after cache invalidation
Given the cache entry for the response is removed
When I send the request again after cache invalidation
Then the application fetches the response from the original source and caches it again
@TC-289
Scenario: Handle absence of cache gracefully
Given the Redis server is stopped
When I send a request to the application
Then the application handles the absence of cache gracefully and fetches data from the original source
@TC-289
Scenario: Resume caching after Redis server restart
Given the Redis server is restarted
When I repeat the request
Then the application resumes caching responses as expected
@TC-289
Scenario: Check Redis logs for errors
Given the caching process is ongoing
When I check Redis logs for any errors during the caching process
Then no errors related to caching are found in the Redis logs
@TC-289
Scenario: Verify memory usage during caching
Given the caching process is ongoing
When I verify the memory usage of Redis
Then memory usage is within expected limits and does not cause any performance issues
@TC-289
Scenario: Handle high load of requests
Given the application is under high load
When I simulate a high load of requests to the application
Then Redis handles the increased load without performance degradation
@TC-289
Scenario: Verify consistency of cached data under load
Given the application is under high load
When I verify the consistency of cached data
Then cached data remains consistent and accurate even under high load
@TC-289
Scenario: Test expiration policy of cached data
Given the expiration policy is configured
When I test the expiration policy of cached data
Then cached data expires as per the configured policy, and new data is fetched and cached