# Healenium Integration Guide

## Overview

Healenium is a self-healing test automation solution that automatically fixes broken locators at runtime when web elements change. This guide explains how Healenium has been integrated into the QualiFrame Java Framework and how to use it.

## What is Healenium?

Healenium improves the stability of Selenium-based test cases by:

- **Self-Healing Capabilities**: Automatically replaces broken locators with new values that match best
- **Runtime Fixes**: Fixes tests in runtime without manual intervention
- **Minimizes Maintenance**: Reduces maintenance time related to updated web pages
- **CI Pipeline Stability**: Improves CI pipeline stability by reducing test failures due to non-product related issues
- **Detailed Reporting**: Provides detailed reporting with fixed control values and screenshots
- **IntelliJ Plugin**: Updates controls with new values in the code base with one click (optional)

## How Healenium Works

1. **Intercepts Failures**: When a `NoSuchElementException` occurs, Healenium intercepts it
2. **ML Algorithm**: Uses machine learning algorithms to identify page changes
3. **Finds New Locators**: Searches for new locators that match the element
4. **Replaces Locator**: Replaces the broken locator with the new one at runtime
5. **Continues Execution**: Test continues execution successfully
6. **Reports**: Provides detailed reporting about what was fixed

## Prerequisites

> **⚠️ Docker Image Issue?** If you're getting authorization errors when pulling Docker images, see **[HEALENIUM_SETUP_ALTERNATIVE.md](HEALENIUM_SETUP_ALTERNATIVE.md)** for alternative setup methods (building from source is recommended).

### 1. Healenium Backend Service

Healenium requires a backend service to be running. You have several options:

#### Option A: Build from Source (Recommended)

Since Docker images may not be publicly available, building from source is the most reliable method:

```bash
# Clone the Healenium backend repository
git clone https://github.com/healenium/healenium-backend.git
cd healenium-backend

# Build the project using Maven
mvn clean install -DskipTests

# Run the backend service
java -jar target/healenium-backend-*.jar

# Or use Spring Boot Maven plugin
mvn spring-boot:run
```

The backend will start on  by default.

#### Option B: Use Docker Compose (If Available)

If you have access to Docker images, you can use docker-compose:

```bash
# Download docker-compose.yml from Healenium repository
curl -o docker-compose.yml https://raw.githubusercontent.com/healenium/healenium-backend/master/docker-compose.yml

# Start services
docker-compose up -d

# Check status
docker-compose ps
```

#### Option C: Manual Installation with JAR

Download the pre-built JAR from Healenium releases:

```bash
# Download the latest release JAR
wget https://github.com/healenium/healenium-backend/releases/latest/download/healenium-backend.jar

# Run the backend
java -jar healenium-backend.jar
```

#### Option D: Run as Spring Boot Application

If you have the source code:

```bash
cd healenium-backend
mvn spring-boot:run
```

**Note**: If Docker images are not accessible, Option A (build from source) is the recommended approach.

### 2. Database (PostgreSQL or H2)

Healenium backend requires a database. By default, it uses H2 (embedded), which is sufficient for development and testing.

**For Development/Testing**: H2 is embedded and requires no setup.

**For Production (PostgreSQL)**:
```bash
# Using Docker
docker run -d -p 5432:5432 \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=healenium \
  --name healenium-db \
  postgres:13

# Or install PostgreSQL locally and create database
createdb healenium
```

Configure PostgreSQL in `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/healenium
spring.datasource.username=postgres
spring.datasource.password=postgres
```

## Configuration

### 1. Enable Healenium in Global Settings

Edit `src/test/resources/properties/Global Settings.properties`:

```properties
# Enable Healenium
HealeniumEnabled=true

# Healenium Backend URL (default: http://localhost:8080)
HealeniumBackendUrl=http://localhost:8080
```

### 2. Verify Backend is Running

Check if Healenium backend is accessible:

```bash
curl http://localhost:8080/actuator/health
```

You should see a response indicating the service is up.

## Framework Integration

### Architecture

The Healenium integration follows this architecture:

```
Test Execution
    ↓
WebDriverFactory.getWebDriver()
    ↓
Creates Standard WebDriver
    ↓
HealeniumDriverWrapper.wrapDriver()
    ↓
Wraps with SelfHealingDriver
    ↓
Returns SelfHealingDriver to Tests
```

### Key Components

#### 1. HealeniumDriverWrapper

Location: `com.framework.selenium.HealeniumDriverWrapper`

This utility class wraps WebDriver instances with SelfHealingDriver:

```java
// Automatically wraps driver if Healenium is enabled
WebDriver driver = WebDriverFactory.getWebDriver(testParameters);
// driver is now a SelfHealingDriver if HealeniumEnabled=true
```

#### 2. WebDriverFactory Integration

The `WebDriverFactory` class has been updated to automatically wrap drivers with Healenium:

```java
// In WebDriverFactory.getWebDriver()
driver = createWebDriverLegacy(testParameters);
// Wrap with Healenium if enabled
driver = HealeniumDriverWrapper.wrapDriver(driver);
return driver;
```

#### 3. TestHarness Integration

The `TestHarness` class uses `HealeniumDriverWrapper.quitDriver()` to properly clean up Healenium-wrapped drivers:

```java
// Properly quits both SelfHealingDriver and underlying driver
HealeniumDriverWrapper.quitDriver(DriverManager.getWebDriver());
```

## Usage

### Basic Usage

No changes are required to your existing test code! Healenium works transparently:

```java
// Your existing code works as-is
WebDriver driver = DriverManager.getWebDriver();
driver.findElement(By.id("login-button")).click();
// If the locator breaks, Healenium will automatically fix it
```

### Example Test Scenario

```java
@Given("User clicks on login button")
public void clickLoginButton() {
    WebDriver driver = DriverManager.getWebDriver();
    
    // If this locator breaks due to UI changes, Healenium will:
    // 1. Detect the NoSuchElementException
    // 2. Find a new locator using ML algorithms
    // 3. Replace it automatically
    // 4. Continue test execution
    driver.findElement(By.id("login-button")).click();
}
```

### Programmatic Usage

If you need to check if Healenium is enabled:

```java
if (HealeniumDriverWrapper.isHealeniumEnabled()) {
    System.out.println("Healenium is active");
    System.out.println("Backend URL: " + HealeniumDriverWrapper.getHealeniumBackendUrl());
}
```

### Unwrapping Driver (Advanced)

If you need to access the underlying WebDriver:

```java
WebDriver driver = DriverManager.getWebDriver();
WebDriver originalDriver = HealeniumDriverWrapper.unwrapDriver(driver);
// originalDriver is the underlying WebDriver (ChromeDriver, FirefoxDriver, etc.)
```

## Execution Modes

Healenium works with all execution modes:

- ✅ **LOCAL**: Local browser execution
- ✅ **GRID**: Selenium Grid execution
- ✅ **SAUCELABS**: Sauce Labs cloud execution
- ✅ **BROWSERSTACK**: BrowserStack cloud execution
- ✅ **LAMBDATEST**: LambdaTest cloud execution
- ✅ **AWSDEVICEFARM**: AWS Device Farm execution

## Reporting

### Healenium Reports

Healenium provides detailed reports showing:

- **Fixed Locators**: Which locators were fixed
- **Original Locators**: What the original locator was
- **New Locators**: What the new locator is
- **Screenshots**: Screenshots of the fixed elements
- **Success Rate**: How many fixes were successful

Access reports at: `http://localhost:8080/report`

### Framework Reports

The framework's existing reporting (Extent Reports, Cucumber Reports) continues to work normally. Healenium fixes are transparent to the test execution.

## Best Practices

### 1. Start with Healenium Disabled

When first integrating, start with `HealeniumEnabled=false` to ensure your tests run correctly. Then enable it to see the self-healing in action.

### 2. Monitor Healenium Reports

Regularly check Healenium reports to understand:
- Which locators are frequently breaking
- What patterns exist in element changes
- Whether you need to improve your locator strategies

### 3. Use Stable Locators

Even with Healenium, prefer stable locators:
- ✅ Use IDs when available
- ✅ Use data-testid attributes
- ✅ Avoid XPath with position-based selectors
- ❌ Avoid fragile locators like `//div[1]/div[2]/span[3]`

### 4. Review Fixed Locators

Periodically review the locators that Healenium fixes:
- Understand why they broke
- Update your test code with the new locators
- Use IntelliJ IDEA plugin to update code automatically (optional)

### 5. Database Maintenance

If using PostgreSQL, regularly maintain the database:
- Clean up old healing records
- Monitor database size
- Backup regularly

## Troubleshooting

### Issue: Tests fail with connection errors

**Solution**: Ensure Healenium backend is running:
```bash
# If using Docker
docker ps | grep healenium

# Check backend health (default port is 7878)
curl http://localhost:7878/actuator/health

# If backend is not running, see HEALENIUM_SETUP_ALTERNATIVE.md
```

### Issue: Docker Image Authorization Error

**Problem**: Getting "You are not authorized to view this page" when pulling Docker images.

**Solution**: Use alternative setup method - build from source:
```bash
git clone https://github.com/healenium/healenium-backend.git
cd healenium-backend
mvn clean install -DskipTests
mvn spring-boot:run
```

See **[HEALENIUM_SETUP_ALTERNATIVE.md](HEALENIUM_SETUP_ALTERNATIVE.md)** for detailed instructions.

### Issue: Healenium not fixing broken locators

**Possible Causes**:
1. Healenium is disabled - Check `HealeniumEnabled=true` in properties
2. Backend URL is incorrect - Verify `HealeniumBackendUrl` is correct (default: http://localhost:7878)
3. Backend is not accessible - Check network connectivity
4. Element truly doesn't exist - Verify the element exists in the DOM

**Solution**: Check logs for Healenium messages:
```java
// Enable debug logging
logger.setLevel(Level.FINE);
```

### Issue: Performance degradation

**Solution**: Healenium adds minimal overhead. If you notice performance issues:
1. Check backend performance
2. Monitor database performance
3. Consider using PostgreSQL instead of H2 for better performance

### Issue: Driver not wrapping correctly

**Solution**: Verify the driver is being wrapped:
```java
WebDriver driver = DriverManager.getWebDriver();
if (driver instanceof SelfHealingDriver) {
    System.out.println("Driver is wrapped with Healenium");
} else {
    System.out.println("Driver is NOT wrapped - check configuration");
}
```

## Advanced Configuration

### Custom Backend URL

If your Healenium backend is on a different host/port:

```properties
HealeniumBackendUrl=http://your-healenium-server:8080
```

### Disable Healenium for Specific Tests

You can disable Healenium for specific tests by setting it to false before creating the driver:

```java
// Temporarily disable Healenium
Properties props = Settings.getInstance();
props.setProperty("HealeniumEnabled", "false");

// Create driver (will not be wrapped)
WebDriver driver = WebDriverFactory.getWebDriver(testParameters);

// Re-enable if needed
props.setProperty("HealeniumEnabled", "true");
```

## IntelliJ IDEA Plugin (Optional)

Healenium provides an IntelliJ IDEA plugin that can automatically update your code with fixed locators:

1. Install the plugin from: https://github.com/healenium/healenium-idea
2. Configure it to connect to your Healenium backend
3. When tests run and locators are fixed, the plugin can update your code automatically

## CI/CD Integration

### Docker Compose Example

Add Healenium to your Docker Compose setup:

```yaml
services:
  healenium-backend:
    image: healenium/healenium-backend
    ports:
      - "8080:8080"
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://healenium-db:5432/healenium
      - SPRING_DATASOURCE_USERNAME=postgres
      - SPRING_DATASOURCE_PASSWORD=postgres
  
  healenium-db:
    image: postgres:13
    environment:
      - POSTGRES_DB=healenium
      - POSTGRES_PASSWORD=postgres
    volumes:
      - healenium-data:/var/lib/postgresql/data

volumes:
  healenium-data:
```

### Jenkins Pipeline Example

```groovy
pipeline {
    agent any
    
    stages {
        stage('Start Healenium') {
            steps {
                sh 'docker-compose up -d healenium-backend healenium-db'
                sh 'sleep 10' // Wait for services to start
            }
        }
        
        stage('Run Tests') {
            steps {
                sh 'mvn clean test -PrunBDDTests'
            }
        }
        
        stage('View Reports') {
            steps {
                echo 'Healenium reports available at http://localhost:8080/report'
            }
        }
    }
    
    post {
        always {
            sh 'docker-compose down'
        }
    }
}
```

## Performance Considerations

### Overhead

Healenium adds minimal overhead:
- **Normal Execution**: ~5-10ms per element interaction
- **Healing Process**: ~100-500ms when a locator needs to be fixed
- **Database Operations**: Minimal, mostly asynchronous

### Optimization Tips

1. **Use PostgreSQL**: Better performance than H2 for production
2. **Database Indexing**: Ensure proper indexes on healing records
3. **Backend Resources**: Allocate sufficient resources to backend service
4. **Connection Pooling**: Configure proper connection pooling

## Limitations

1. **Not a Replacement for Good Practices**: Healenium helps but doesn't replace good test design
2. **ML Limitations**: May not always find the correct element if page structure changes drastically
3. **Performance**: Adds slight overhead, especially during healing
4. **Backend Dependency**: Requires backend service to be running

## Resources

- **Official Website**: https://healenium.io/
- **GitHub Repository**: https://github.com/healenium/healenium-web
- **Documentation**: https://github.com/healenium/healenium-web/wiki
- **IntelliJ Plugin**: https://github.com/healenium/healenium-idea
- **Example Project**: https://github.com/healenium/healenium-example-maven

## Support

For Healenium-specific issues:
- **GitHub Issues**: https://github.com/healenium/healenium-web/issues
- **Community**: Check Healenium GitHub discussions

For QualiFrame integration issues:
- Check framework logs
- Review this documentation
- Contact framework support team

## Summary

Healenium integration provides:

✅ **Automatic Self-Healing**: Fixes broken locators automatically  
✅ **Zero Code Changes**: Works with existing test code  
✅ **Transparent Operation**: No changes needed to test logic  
✅ **Detailed Reporting**: See what was fixed and how  
✅ **CI/CD Ready**: Easy to integrate into pipelines  
✅ **Production Ready**: Battle-tested in enterprise environments  

Enable Healenium today and reduce your test maintenance time!

---

**Version**: 1.0.0  
**Last Updated**: 2024  
**Framework Version**: QualiFrame V3.0

