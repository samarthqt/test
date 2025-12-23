# QualiFrame V3.0 - Agent Skill Documentation

## Framework Overview

**QualiFrame V3.0** is an enterprise-grade test automation framework built on Java 17 and Maven. It provides comprehensive test automation capabilities across multiple platforms (Web, Mobile, API, Windows) with support for multiple testing approaches (BDD, Modular, Keyword-Driven) and execution environments (Local, Grid, Cloud).

### Core Identity
- **Framework Name**: QualiFrame V3.0 Enhanced
- **Version**: 3.0.0
- **Technology Stack**: Java 17, Maven 3.8.4+, Selenium 4.28.1, Cucumber 7.11.2, TestNG 7.7.1
- **Build Tool**: Maven
- **License**: Apache License 2.0

---

## Key Capabilities

### 1. Multi-Platform Testing
- **Web Automation**: Selenium 4.28.1 with Chrome, Firefox, Edge, Safari support
- **Mobile Automation**: Appium 9.4.0 for Android and iOS (Native & Web)
- **API Testing**: REST Assured 5.3.0, GraphQL, gRPC support
- **Windows Application**: WinAppDriver integration
- **Database Testing**: PostgreSQL, MSSQL, Access Database support

### 2. Multiple Testing Approaches
- **BDD (Behavior-Driven Development)**: Cucumber with Gherkin syntax
- **Modular/Hybrid**: TestNG-based structured test classes
- **Keyword-Driven**: Excel-based keyword execution
- **Data-Driven**: Excel, JSON, CSV, Access Database, SQL data sources

### 3. Execution Environments
- **Local Execution**: Direct browser/device execution
- **Selenium Grid**: Distributed test execution
- **Cloud Platforms**: 
  - Sauce Labs
  - BrowserStack
  - LambdaTest
  - AWS Device Farm
  - Perfecto
  - Experitest

### 4. Advanced Features
- **AI/ML Integration**: Smart test selection, failure pattern analysis
- **Self-Healing Tests**: Healenium 3.4.7 integration
- **Performance Monitoring**: Execution time tracking, resource utilization
- **Security**: AES/GCM encryption, secure credential management
- **Containerization**: Docker and Docker Compose support
- **Visual Testing**: Applitools integration

### 5. Reporting & Analytics
- **Extent Reports**: Rich HTML reports with custom themes
- **Cucumber Reports**: HTML, JSON, JUnit XML formats
- **Allure Reports**: Advanced reporting with trends
- **TestNG Reports**: Standard TestNG reporting

---

## Project Structure

```
Qualiframe-JAVA-Maven_v3.0/
├── src/test/
│   ├── java/com/
│   │   ├── cucumber/steps/          # BDD Step Definitions
│   │   │   ├── WebSteps.java
│   │   │   ├── MobileSteps.java
│   │   │   ├── APISteps.java
│   │   │   ├── GRPCSteps.java
│   │   │   └── Hooks.java
│   │   ├── framework/               # Core Framework Components
│   │   │   ├── components/         # Core utilities
│   │   │   │   ├── DriverScript.java
│   │   │   │   ├── ModularTestCase.java
│   │   │   │   ├── ScriptHelper.java
│   │   │   │   ├── Settings.java
│   │   │   │   ├── TestConfigurationsLite.java
│   │   │   │   ├── SmartTestSelector.java
│   │   │   │   └── SecureCredentialManager.java
│   │   │   ├── selenium/           # WebDriver factories
│   │   │   │   ├── WebDriverFactory.java
│   │   │   │   ├── AppiumDriverFactory.java
│   │   │   │   └── CustomDriver.java
│   │   │   ├── data/               # Data access layers
│   │   │   │   ├── FrameworkDataTable.java
│   │   │   │   ├── ExcelDataAccess.java
│   │   │   │   ├── JsonData.java
│   │   │   │   ├── CsvReader.java
│   │   │   │   └── AccessDatabase.java
│   │   │   ├── reusable/           # Reusable components
│   │   │   │   ├── WebReusableComponents.java
│   │   │   │   ├── MobileResuableComponents.java
│   │   │   │   ├── ApiResuableComponents.java
│   │   │   │   └── GenericResuableComponents.java
│   │   │   ├── report/             # Reporting engines
│   │   │   │   ├── ExtentReport.java
│   │   │   │   ├── SeleniumReport.java
│   │   │   │   └── ResultSummaryManager.java
│   │   │   ├── cucumber/           # Cucumber integration
│   │   │   │   ├── DriverManager.java
│   │   │   │   ├── TestHarness.java
│   │   │   │   └── TestNGListener.java
│   │   │   ├── api/                # API testing utilities
│   │   │   │   ├── GraphQL.java
│   │   │   │   └── ApiContractValidator.java
│   │   │   ├── ai/                 # AI/ML features
│   │   │   │   └── EnhancedAITestEngine.java
│   │   │   └── security/           # Security features
│   │   │       └── AdvancedSecurityEngine.java
│   │   ├── modular/steps/          # Modular Test Classes
│   │   ├── keyword/steps/          # Keyword-Driven Tests
│   │   ├── pageobjects/            # Page Object Model
│   │   └── runners/                # Test Runners
│   │       ├── CucumberRunner.java
│   │       └── HybridRunner.java
│   └── resources/
│       ├── features/                # Cucumber Feature Files
│       ├── datatables/             # Test Data Files
│       ├── properties/              # Configuration Files
│       └── api/                     # API Resources
├── pom.xml                          # Maven Configuration
├── framework-config.properties      # Framework Config
├── Dockerfile                       # Docker Configuration
├── docker-compose.yml              # Docker Compose
└── README.md                        # Framework Documentation
```

---

## Configuration Management

### Primary Configuration File
**Location**: `src/test/resources/properties/Global Settings.properties`

### Key Configuration Parameters

#### Execution Approach
```properties
ExecutionApproach=CUCUMBER  # Options: CUCUMBER, MODULAR, KEYWORD
```

#### Test Configuration ID
```properties
# Local Web Execution
TestConfigurationID=LOCALChrome
TestConfigurationID=LOCALFirefox
TestConfigurationID=LOCALEdge
TestConfigurationID=LOCALChrome_HEADLESS

# Local Mobile Execution
TestConfigurationID=AppiumNativeAndroid
TestConfigurationID=AppiumNativeIOS
TestConfigurationID=AppiumWebAndroid
TestConfigurationID=AppiumWebIOS

# Cloud Execution (Sauce Labs)
TestConfigurationID=SaucelabsWebChrome
TestConfigurationID=SaucelabsMobileAndroid

# Cloud Execution (BrowserStack)
TestConfigurationID=BROWSERSTACKWebChrome
TestConfigurationID=BROWSERSTACKMobileAndroid

# Cloud Execution (LambdaTest)
TestConfigurationID=LAMBDATESTWebChrome
TestConfigurationID=LAMBDATESTMobileAndroid

# Windows Application
TestConfigurationID=WINDOWSEXECUTION

# API Testing
TestConfigurationID=API
```

#### Test Data Source
```properties
TestData=EXCEL  # Options: EXCEL, JSON, CSV, ACCESSDB, MSSQL
DataTable=WebModularScenario  # Excel file name (without extension)
DefaultDataSheet=General_Data  # Default sheet name
```

#### Application URLs
```properties
qaAppUrl=https://www.saucedemo.com/
prodAppUrl=https://www.saucedemo.com/
defaultEnvironment=qa  # Options: qa, prod
```

#### Reporting Configuration
```properties
HtmlReport=True
TakeScreenshotFailedStep=True
TakeScreenshotPassedStep=True
SaveReports=True
Allure-Report=False
```

#### Healenium (Self-Healing)
```properties
HealeniumEnabled=false
HealeniumBackendUrl=http://localhost:7878
```

#### Applitools (Visual Testing)
```properties
AppliTools=False
AfterStepAppliTools=False
APIKey=your_api_key
BatchInfo=ProjectName
```

---

## Execution Patterns

### BDD Test Execution (Cucumber)

#### Maven Command Structure
```bash
mvn clean test -PrunBDDTests [OPTIONS]
```

#### Common Execution Patterns

**Run all BDD tests:**
```bash
mvn clean test -PrunBDDTests
```

**Run tests with specific tags:**
```bash
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@WebDemo"
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@WebDemo and @P1-High"
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@WebDemo and not @Skip"
```

**Run specific feature file:**
```bash
mvn clean test -PrunBDDTests -Dcucumber.features="src/test/resources/features/Web.feature"
```

**Run with custom configuration:**
```bash
mvn clean test -PrunBDDTests \
  -DTestConfiguration=LOCALFirefox \
  -Dcucumber.filter.tags="@WebDemo"
```

**Run mobile tests:**
```bash
# Android
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@Android"

# iOS
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@iOS"
```

**Run API tests:**
```bash
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@api"
```

**Run GraphQL tests:**
```bash
# All GraphQL tests
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@graphql"

# Only queries (exclude mutations)
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@graphql and not @graphql-mutation"

# Only mutations
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@graphql-mutation"
```

### Modular Test Execution (TestNG)

#### Maven Command Structure
```bash
mvn clean test -PrunTestNGTests [OPTIONS]
```

#### Common Execution Patterns

**Run all modular tests:**
```bash
mvn clean test -PrunTestNGTests
```

**Run specific test class:**
```bash
mvn clean test -PrunTestNGTests -Dtest=OrangeModular_Login_PerformValidLogin
```

**Run tests from TestNG XML:**
```bash
mvn clean test -PrunTestNGTests \
  -DsuiteXmlFile=src/test/resources/TestNGHybrid.xml
```

### Docker Execution

**Build Docker image:**
```bash
docker build -t qualiframe-v3 .
```

**Run tests in container:**
```bash
docker run --rm qualiframe-v3 mvn clean test -PrunBDDTests
```

**Run with volume mount for reports:**
```bash
docker run --rm \
  -v $(pwd)/Results:/app/Results \
  qualiframe-v3 mvn clean test -PrunBDDTests
```

**Using Docker Compose:**
```bash
docker-compose run --rm qualiframe-app mvn clean test -PrunBDDTests
```

---

## Test Data Management

### Supported Data Sources
1. **Excel Files** (`.xls`, `.xlsx`)
   - Location: `src/test/resources/datatables/`
   - Structure: Multiple sheets (Test_Data, Business_Flow)
   - Access: Via `FrameworkDataTable.getData(sheetName, fieldName)`

2. **JSON Files** (`.json`)
   - Location: `src/test/resources/datatables/`
   - Structure: Nested JSON with test case IDs as keys
   - Access: Via `JsonData` class

3. **CSV Files** (`.csv`)
   - Location: `src/test/resources/datatables/`
   - Access: Via `CsvReader` class

4. **Access Database** (`.accdb`, `.mdb`)
   - Location: `src/test/resources/datatables/`
   - Access: Via `AccessDatabase` class

5. **SQL Database** (PostgreSQL, MSSQL)
   - Configuration: In `Global Settings.properties`
   - Access: Via SQL queries

### Data Loading in BDD
Test data is automatically loaded based on `tc_id` specified in Examples table:
```gherkin
Examples:
  | tc_id                 |
  | SeleniumPracticeTest4 |
```
Framework loads data for `SeleniumPracticeTest4` from datatable files.

### Data Loading in Modular
```java
String userName = dataTable.getData("Test_Data", "UserName");
String password = dataTable.getData("Test_Data", "Password");
```

---

## BDD Workflow (Cucumber)

### 1. Feature Files
**Location**: `src/test/resources/features/`

**Example Feature File** (`Web.feature`):
```gherkin
Feature: Web Demo Application
  As a user, I want to be able to login to the application
  when I present valid credentials

  @WebDemo @P1-High
  Scenario Outline: User login with valid credentials
    Given Launch Application using "<tc_id>"
    Then verify login page displayed successfully
    When User enters userCredentials in text field
    And User clicks Login button
    Then verify home page displayed successfully

    Examples:
      | tc_id                 |
      | SeleniumPracticeTest4 |
```

### 2. Step Definitions
**Location**: `src/test/java/com/cucumber/steps/`

**Example Step Definition** (`WebSteps.java`):
```java
@Given("Launch Application using {string}")
public void launch_Application(String tcid) {
    testHarness.initializeTestData(tcid);
    launchApp();
}

@When("User enters userCredentials in text field")
public void enterUserCredentials() {
    String userName = "standard_user";
    String password = "secret_sauce";
    enterUserName(userName);
    enterPassword(password);
}
```

### 3. Hooks
**Location**: `src/test/java/com/cucumber/steps/Hooks.java`

Handles setup and teardown:
- `@Before`: Initialize driver, test data, Applitools
- `@AfterStep`: Take screenshots
- `@After`: Close driver, finalize reporting

### 4. Test Runner
**Location**: `src/test/java/com/runners/CucumberRunner.java`

```java
@CucumberOptions(
    features = "src/test/resources/features",
    glue = { "com.cucumber.steps", "com.framework.webcrawler" },
    tags = "@P1-High",
    plugin = {
        "pretty",
        "html:target/cucumber-report/report.html",
        "json:target/cucumber-report/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
)
```

---

## Modular Framework Workflow

### 1. Base Test Class
All modular tests extend `ModularTestCase`:
```java
public abstract class ModularTestCase {
    protected FrameworkDataTable dataTable;
    protected SeleniumReport report;
    protected CustomDriver driver;
    protected ScriptHelper scriptHelper;
    
    public abstract void setUp();
    public abstract void executeTest();
    public abstract void tearDown();
}
```

### 2. Test Configuration
Provides data providers for different execution modes:
```java
@DataProvider(name = "ChromeBrowser")
public Object[][] desktopBrowsers(Method currentMethod) {
    return new Object[][] { {
        new SeleniumParametersBuilders(currentScenario, currentTestcase)
            .testInstance("Instance1")
            .executionMode(ExecutionMode.LOCAL)
            .browser(Browser.CHROME)
            .build()
    } };
}
```

### 3. Modular Test Example
```java
public class OrangeModular_Login_PerformValidLogin 
    extends TestConfigurationsLite {
    
    @Test(dataProvider = "ChromeBrowser", 
          dataProviderClass = TestConfigurationsLite.class)
    public void performLogin(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Login Test");
        DriverScript driverScript = new DriverScript(testParameters);
        driverScript.driveTestExecution();
        tearDownTestRunner(testParameters, driverScript);
    }
    
    @Override
    public void setUp() {
        // Initialize test environment
    }
    
    @Override
    public void executeTest() {
        // Execute test steps
        String userName = dataTable.getData("Test_Data", "UserName");
        // Use userName in test
    }
    
    @Override
    public void tearDown() {
        // Cleanup
    }
}
```

---

## Key Framework Components

### DriverScript
**Location**: `com.framework.components.DriverScript`

Core execution engine that orchestrates test execution:
- Initializes WebDriver/AppiumDriver
- Loads test data
- Initializes reporting
- Executes test iterations
- Handles exceptions
- Generates reports

### TestHarness (BDD)
**Location**: `com.framework.cucumber.TestHarness`

Manages driver lifecycle for Cucumber tests:
- Creates drivers based on execution mode
- Initializes test data
- Manages driver instances

### WebDriverFactory
**Location**: `com.framework.selenium.WebDriverFactory`

Creates and configures WebDriver instances:
- Supports Chrome, Firefox, Edge, Safari
- Headless mode support
- Mobile emulation
- Remote execution

### FrameworkDataTable
**Location**: `com.framework.data.FrameworkDataTable`

Manages test data from multiple sources:
- Excel, JSON, CSV, Access Database, SQL
- Methods: `getData()`, `putData()`

### ScriptHelper
**Location**: `com.framework.components.ScriptHelper`

Wrapper providing access to framework objects:
- FrameworkDataTable
- SeleniumReport
- CustomDriver
- RestAssuredUtils

---

## API Testing Capabilities

### REST API Testing
- **Library**: REST Assured 5.3.0
- **Step Definitions**: `APISteps.java`
- **Feature File**: `API.feature`

### GraphQL Testing
- **Library**: GraphQL Java 21.3
- **Step Definitions**: `APISteps.java` (GraphQL methods)
- **Feature File**: `API.feature` with `@graphql` tag
- **Query Files**: `src/test/resources/api/graphql/*.graphql`

**Example GraphQL Test:**
```gherkin
@graphql
Scenario Outline: Execute GraphQL query
  Given Access GraphQL endpoint "GraphQLEndpoint" with "header2" for "<tc_id>"
  When Execute GraphQL query "<query>" with variables "<variables>"
  Then verify GraphQL request is success with status "<code>"
  And verify GraphQL response has no errors
  And verify GraphQL data path "<dataPath>" is "<expectedValue>"
```

### gRPC Testing
- **Library**: gRPC Java 1.58.0
- **Step Definitions**: `GRPCSteps.java`
- **Proto Files**: `src/test/resources/api/payload/*.proto`

---

## Mobile Testing Capabilities

### Supported Platforms
- **Android**: Native apps, Web browsers (Chrome)
- **iOS**: Native apps, Web browsers (Safari)

### Execution Modes
- **Local**: Appium server on local machine
- **Cloud**: Sauce Labs, BrowserStack, LambdaTest, AWS Device Farm, Perfecto

### Configuration
**Location**: `src/test/resources/properties/Mobile Automation Settings.properties`

### Mobile Test Example (BDD)
```gherkin
@Android
Scenario Outline: Mobile app login
  Given Launch Mobile Application using "<tc_id>"
  When User enters mobile credentials
  Then verify mobile home screen displayed
```

---

## Reporting

### Report Locations
- **Extent Reports**: `Results/ExtentReport/`
- **Cucumber Reports**: `target/cucumber-report/`
- **Allure Reports**: `target/allure-results/` (generate with `mvn allure:report`)
- **TestNG Reports**: `test-output/`

### Report Features
- Test execution summary
- Step-by-step logs
- Screenshots (on failure/pass)
- Execution time
- Pass/Fail statistics
- Historical trends (Allure)

---

## Advanced Features

### 1. Healenium (Self-Healing Tests)
**Version**: 3.4.7

Automatically fixes broken locators at runtime:
- Zero code changes required
- ML-based locator healing
- Backend service integration

**Configuration**:
```properties
HealeniumEnabled=true
HealeniumBackendUrl=http://localhost:7878
```

**Setup**: See `HEALENIUM_INTEGRATION_GUIDE.md`

### 2. AI/ML Integration
- **Smart Test Selection**: Recommends tests based on historical data
- **Failure Pattern Analysis**: Identifies common failure patterns
- **Performance Analytics**: Tracks execution trends

**Components**:
- `EnhancedAITestEngine.java`
- `SmartTestSelector.java`

### 3. Performance Monitoring
- Execution time tracking
- Resource utilization monitoring
- Dynamic timeout adjustments
- Thread pool management

### 4. Security Features
- **Secure Credential Management**: AES/GCM encryption
- **KeyStore Integration**: Java KeyStore for secure key storage
- **Audit Logging**: Comprehensive access logs

**Component**: `SecureCredentialManager.java`

### 5. Visual Testing (Applitools)
- Visual regression testing
- Cross-browser visual validation
- Step-level visual checks

**Configuration**:
```properties
AppliTools=True
APIKey=your_api_key
BatchInfo=ProjectName
```

---

## Common Tasks for AI Agents

### Task 1: Create a New BDD Test
1. Create feature file in `src/test/resources/features/`
2. Write Gherkin scenarios with tags
3. Create/update step definitions in `com.cucumber.steps`
4. Add test data to datatable files
5. Run: `mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@YourTag"`

### Task 2: Create a New Modular Test
1. Create test class extending `TestConfigurationsLite`
2. Implement `setUp()`, `executeTest()`, `tearDown()` methods
3. Add test data to Excel/JSON files
4. Add to `TestNGHybrid.xml` if needed
5. Run: `mvn clean test -PrunTestNGTests -Dtest=YourTestClass`

### Task 3: Configure Cloud Execution
1. Update `Global Settings.properties` with cloud credentials
2. Set `TestConfigurationID` to cloud configuration (e.g., `BROWSERSTACKWebChrome`)
3. Run tests normally - framework handles cloud connection

### Task 4: Add New Test Data
1. For Excel: Add rows to `src/test/resources/datatables/WebModularScenario.xls`
2. For JSON: Add entries to `src/test/resources/datatables/Sample.json`
3. Reference in tests using `dataTable.getData(sheetName, fieldName)`

### Task 5: Enable Self-Healing (Healenium)
1. Start Healenium backend: `mvn spring-boot:run` (in healenium-backend project)
2. Set `HealeniumEnabled=true` in `Global Settings.properties`
3. Run tests - broken locators will be automatically fixed

### Task 6: Generate Reports
1. **Extent Reports**: Automatically generated in `Results/ExtentReport/`
2. **Cucumber Reports**: Generated in `target/cucumber-report/`
3. **Allure Reports**: Run `mvn allure:report` then `mvn allure:serve`

### Task 7: Run Tests in Docker
1. Build image: `docker build -t qualiframe-v3 .`
2. Run tests: `docker run --rm qualiframe-v3 mvn clean test -PrunBDDTests`
3. Mount volumes for reports: `-v $(pwd)/Results:/app/Results`

---

## Best Practices

### 1. Test Organization
- Use meaningful tags for BDD tests (`@Smoke`, `@Regression`, `@P1-High`)
- Group related tests in feature files
- Use Page Object Model for web tests
- Keep step definitions reusable

### 2. Data Management
- Externalize all test data
- Use descriptive test case IDs
- Maintain separate data files per test suite
- Use data-driven approach for parameterized tests

### 3. Error Handling
- Implement proper exception handling
- Use framework's `OnError` configuration
- Take screenshots on failures
- Log detailed error messages

### 4. Reporting
- Enable screenshots for failed steps
- Use descriptive test descriptions
- Include test data in reports (if needed)
- Review reports regularly

### 5. Performance
- Use parallel execution for faster runs
- Configure appropriate thread counts
- Use cloud platforms for scalability
- Monitor execution times

### 6. Maintenance
- Keep dependencies updated
- Review and update locators regularly
- Clean up unused test data
- Maintain documentation

---

## Troubleshooting Guide

### Issue: Tests not finding step definitions
**Solution**: Ensure step definition package is in `glue` parameter:
```java
@CucumberOptions(glue = { "com.cucumber.steps" })
```

### Issue: WebDriver not initialized
**Solution**: Check `TestConfigurationID` in properties file matches execution mode.

### Issue: Test data not loading
**Solution**: Verify test data file exists and `tc_id` matches test case ID in data file.

### Issue: Selenium 4.28.1 NettyClient errors
**Solution**: Framework includes stub NettyClient. Ensure system properties are set:
```properties
-Dwebdriver.http.factory=jdk-http-client
-Dselenium.http.factory=jdk-http-client
```

### Issue: Healenium connection errors
**Solution**: 
1. Ensure Healenium backend is running: `curl http://localhost:7878/actuator/health`
2. Check `HealeniumEnabled=true` in properties
3. Verify `HealeniumBackendUrl` is correct

### Issue: GraphQL 405 errors
**Solution**: Framework automatically tries GET for queries if POST returns 405. Verify endpoint URL is correct.

---

## Framework Dependencies

### Core Dependencies
- **Java**: 17 (LTS) - Required
- **Maven**: 3.8.4+ (3.9.6 included)
- **Selenium**: 4.28.1
- **Appium**: 9.4.0
- **Cucumber**: 7.11.2
- **TestNG**: 7.7.1
- **REST Assured**: 5.3.0

### Key Libraries
- **WebDriverManager**: 5.7.0 - Automatic driver management
- **Apache POI**: 5.2.4 - Excel handling
- **Jackson**: 2.20.0 - JSON processing
- **Gson**: 2.13.1 - JSON handling
- **Extent Reports**: 1.1.0 - HTML reporting
- **Allure**: 2.24.0 - Advanced reporting
- **Healenium**: 3.4.7 - Self-healing automation

---

## Integration Points

### CI/CD Integration
- **GitLab CI**: `.gitlab-ci.yml` configuration available
- **Jenkins**: Compatible with Jenkins pipelines
- **GitHub Actions**: Can be configured

### Cloud Platform Integration
- Sauce Labs, BrowserStack, LambdaTest, AWS Device Farm, Perfecto, Experitest
- Configuration via `Global Settings.properties`

### Reporting Integration
- Extent Reports, Cucumber Reports, Allure Reports
- JIRA integration via Zephyr Scale (configurable)

---

## Version Information

- **Framework Version**: 3.0.0
- **Java Version**: 17 (LTS)
- **Maven Version**: 3.9.6 (included)
- **Selenium Version**: 4.28.1
- **Cucumber Version**: 7.11.2
- **TestNG Version**: 7.7.1
- **Last Updated**: 2024

---

## Additional Resources

### Documentation Files
- `README.md` - Comprehensive framework documentation
- `FRAMEWORK_REVIEW.md` - Framework review and analysis
- `TECHNICAL_ANALYSIS.md` - Technical deep dive
- `IMPLEMENTATION_GUIDE.md` - Implementation guide
- `HEALENIUM_INTEGRATION_GUIDE.md` - Healenium setup guide
- `MCP_CONFIGURATION_GUIDE.md` - MCP server configuration

### Configuration Files
- `pom.xml` - Maven dependencies and build configuration
- `framework-config.properties` - Framework feature flags
- `src/test/resources/properties/Global Settings.properties` - Main configuration
- `Dockerfile` - Docker container configuration
- `docker-compose.yml` - Docker Compose services

---

## Agent Usage Guidelines

### When to Use This Framework
- **Web Testing**: Use for Selenium-based web automation
- **Mobile Testing**: Use for Appium-based mobile automation
- **API Testing**: Use for REST, GraphQL, gRPC API testing
- **Cross-Platform**: Use for multi-platform test execution
- **BDD Approach**: Use when business-readable tests are needed
- **Modular Approach**: Use for complex test logic

### Framework Strengths
- Comprehensive platform support
- Multiple testing approaches
- Enterprise-grade features
- Extensive reporting
- Cloud platform integration
- Self-healing capabilities

### Framework Limitations
- Requires Java 17 (not backward compatible with older Java versions)
- Complex setup for beginners
- Large dependency footprint
- Requires understanding of multiple testing approaches

---

## Quick Reference Commands

```bash
# Build project
mvn clean install -DskipTests

# Run BDD tests
mvn clean test -PrunBDDTests

# Run BDD tests with tags
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@WebDemo"

# Run modular tests
mvn clean test -PrunTestNGTests

# Run specific test class
mvn clean test -PrunTestNGTests -Dtest=YourTestClass

# Generate Allure report
mvn allure:report
mvn allure:serve

# Docker build
docker build -t qualiframe-v3 .

# Docker run
docker run --rm qualiframe-v3 mvn clean test -PrunBDDTests
```

---

**End of Skill Documentation**

This Skill.md file provides comprehensive information about QualiFrame V3.0 for AI agents to understand, interact with, and utilize the framework effectively.

