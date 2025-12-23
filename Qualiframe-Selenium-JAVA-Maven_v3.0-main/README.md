# QualiFrame V3.0 - Enterprise Test Automation Framework

**QualiFrame V3.0** is a comprehensive, enterprise-grade test automation framework built on Java and Maven. It supports multiple testing approaches (BDD and Modular), multiple platforms (Web, Mobile, API, Windows), and provides extensive features for test automation including AI/ML integration, containerization, performance monitoring, and security enhancements.

## 📋 Table of Contents

- [Framework Overview](#framework-overview)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [BDD Workflow](#bdd-workflow)
- [Modular Framework Workflow](#modular-framework-workflow)
- [Setup Instructions](#setup-instructions)
- [Execution Instructions](#execution-instructions)
- [Key Components](#key-components)
- [Data Management](#data-management)
- [Reporting](#reporting)
- [Additional Features](#additional-features)
- [Developer Onboarding](#developer-onboarding)

---

## Framework Overview

QualiFrame V3.0 is designed to support both **Behavior-Driven Development (BDD)** using Cucumber and **Modular/Keyword-Driven** approaches using TestNG. The framework provides:

- **Multi-Platform Support**: Web (Selenium), Mobile (Appium), API (REST Assured), Windows Application testing
- **Multiple Execution Modes**: Local, Grid, Cloud platforms (Sauce Labs, BrowserStack, LambdaTest, AWS Device Farm, Perfecto, Experitest)
- **Flexible Data Management**: Excel, JSON, CSV, Access Database, SQL
- **Comprehensive Reporting**: Extent Reports, Cucumber Reports, Allure Reports
- **Advanced Features**: AI/ML test selection, performance monitoring, security enhancements, Docker support

---

## Technology Stack

### Core Technologies

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | 17 | Programming language |
| **Maven** | 3.8.4+ | Build automation and dependency management |
| **Selenium** | 4.28.1 | Web automation (JDK HTTP client) |
| **Appium** | 9.4.0 | Mobile automation |
| **Cucumber** | 7.11.2 | BDD framework |
| **TestNG** | 7.7.1 | Test framework for modular approach |
| **Rest Assured** | 5.3.0 | API testing |
| **Extent Reports** | 1.1.0 | HTML reporting |
| **Apache POI** | 5.2.4 | Excel file handling |

### Additional Dependencies

- **WebDriverManager**: 5.7.0 - Automatic driver management
- **Jackson**: JSON processing
- **Gson**: JSON handling
- **PostgreSQL/MSSQL**: Database connectivity
- **Docker Java Client**: Containerization support
- **GraphQL Java**: GraphQL API support
- **gRPC**: gRPC API support
- **Applitools**: Visual testing
- **Allure**: Advanced reporting
- **Healenium**: 3.4.7 - Self-healing test automation

---

## Project Structure

```
Qualiframe-JAVA-Maven_v3.0/
│
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       ├── cucumber/
│       │       │   └── steps/          # BDD Step Definitions
│       │       │       ├── WebSteps.java
│       │       │       ├── MobileSteps.java
│       │       │       ├── APISteps.java
│       │       │       ├── GRPCSteps.java
│       │       │       └── Hooks.java
│       │       │
│       │       ├── framework/           # Core Framework Components
│       │       │   ├── components/     # Core framework classes
│       │       │   │   ├── DriverScript.java
│       │       │   │   ├── ModularTestCase.java
│       │       │   │   ├── ScriptHelper.java
│       │       │   │   ├── Settings.java
│       │       │   │   └── TestConfigurationsLite.java
│       │       │   ├── selenium/       # Selenium/WebDriver classes
│       │       │   │   ├── WebDriverFactory.java
│       │       │   │   ├── AppiumDriverFactory.java
│       │       │   │   └── CustomDriver.java
│       │       │   ├── data/          # Data handling classes
│       │       │   │   ├── FrameworkDataTable.java
│       │       │   │   ├── ExcelDataAccess.java
│       │       │   │   ├── JsonData.java
│       │       │   │   ├── CsvReader.java
│       │       │   │   └── AccessDatabase.java
│       │       │   ├── reusable/      # Reusable component libraries
│       │       │   │   ├── WebReusableComponents.java
│       │       │   │   ├── MobileResuableComponents.java
│       │       │   │   ├── ApiResuableComponents.java
│       │       │   │   └── GenericResuableComponents.java
│       │       │   ├── report/        # Reporting classes
│       │       │   │   ├── ExtentReport.java
│       │       │   │   ├── SeleniumReport.java
│       │       │   │   └── ResultSummaryManager.java
│       │       │   ├── cucumber/      # Cucumber integration
│       │       │   │   ├── DriverManager.java
│       │       │   │   ├── TestHarness.java
│       │       │   │   └── TestNGListener.java
│       │       │   ├── api/          # API testing utilities
│       │       │   │   ├── GraphQL.java
│       │       │   │   └── ApiContractValidator.java
│       │       │   ├── ai/          # AI/ML features
│       │       │   │   └── EnhancedAITestEngine.java
│       │       │   ├── security/    # Security features
│       │       │   │   └── AdvancedSecurityEngine.java
│       │       │   └── cloud/      # Cloud-native features
│       │       │       └── CloudNativeTestOrchestrator.java
│       │       │
│       │       ├── modular/
│       │       │   └── steps/       # Modular Test Classes
│       │       │       ├── WebModularTest1.java
│       │       │       ├── WebModularTest2.java
│       │       │       ├── MobileModularTest.java
│       │       │       ├── APIModularTest.java
│       │       │       └── OrangeModular_Login_PerformValidLogin.java
│       │       │
│       │       ├── keyword/
│       │       │   └── steps/      # Keyword-Driven Test Classes
│       │       │       ├── WebKeyword.java
│       │       │       ├── MobileKeyword.java
│       │       │       └── APIKeyword.java
│       │       │
│       │       ├── pageobjects/     # Page Object Model Classes
│       │       │   ├── WebPage.java
│       │       │   ├── HybridWebPage.java
│       │       │   └── Orange_Application/
│       │       │
│       │       └── runners/        # Test Runners
│       │           ├── CucumberRunner.java
│       │           └── HybridRunner.java
│       │
│       └── resources/
│           ├── features/          # Cucumber Feature Files
│           │   ├── Web.feature
│           │   ├── Mobile.feature
│           │   ├── API.feature
│           │   ├── ModernWeb.feature
│           │   └── WinApp.feature
│           │
│           ├── datatables/        # Test Data Files
│           │   ├── *.xls          # Excel test data
│           │   ├── *.json         # JSON test data
│           │   └── *.csv          # CSV test data
│           │
│           ├── properties/        # Configuration Files
│           │   ├── Global Settings.properties
│           │   ├── Mobile Automation Settings.properties
│           │   ├── API Automation Endpoints.properties
│           │   └── Cross-Platform Settings.properties
│           │
│           ├── api/              # API Resources
│           │   ├── graphql/      # GraphQL query files
│           │   └── payloads/     # API payloads
│           │
│           └── TestNGHybrid.xml # TestNG Suite Configuration
│
├── Results/                     # Test Execution Reports
│   ├── CucumberReport/
│   ├── ExtentReport/
│   └── Screenshots/
│
├── logs/                        # Application Logs
├── pom.xml                      # Maven Project Configuration
├── framework-config.properties  # Framework Configuration
├── Dockerfile                   # Docker Configuration
├── docker-compose.yml          # Docker Compose Configuration
├── .gitlab-ci.yml              # CI/CD Configuration
└── README.md                   # This File
```

---

## BDD Workflow

The BDD (Behavior-Driven Development) approach uses **Cucumber** to write tests in natural language (Gherkin syntax) and execute them through step definitions.

### BDD Components

#### 1. Feature Files (`src/test/resources/features/`)

Feature files contain test scenarios written in Gherkin syntax:

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

#### 2. Step Definitions (`src/test/java/com/cucumber/steps/`)

Step definitions map Gherkin steps to Java code:

```java
package com.cucumber.steps;

public class WebSteps extends WebPage {
    
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
    
    @Then("verify home page displayed successfully")
    public void verifyhome() {
        verifyHome();
    }
}
```

#### 3. Hooks (`src/test/java/com/cucumber/steps/Hooks.java`)

Hooks handle setup and teardown operations:

```java
@Before
public void setUp(Scenario scenario) {
    // Initialize test parameters
    initializeTestParameters(scenario);
    
    // Create and initialize driver
    testHarness.invokeDriver(scenario);
    
    // Initialize Applitools (if enabled)
    if (appliToolsEnabled) {
        appli.invokeAppliTools(scenario.getName());
    }
}

@AfterStep
public void addScreenshot(Scenario scenario) {
    // Take screenshot after each step
    if (scenario.isFailed() || takeScreenshotOnPass) {
        byte[] screenshot = ((TakesScreenshot) driver)
            .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");
    }
}

@After
public void tearDown(Scenario scenario) {
    // Close Applitools
    appli.closeAppliTools();
    
    // Close driver
    testHarness.closeRespectiveDriver(scenario);
}
```

#### 4. Test Runner (`src/test/java/com/runners/CucumberRunner.java`)

The Cucumber runner executes feature files:

```java
@CucumberOptions(
    features = "src/test/resources/features",
    glue = { "com.cucumber.steps", "com.framework.webcrawler" },
    tags = "@WebDemo",
    monochrome = true,
    plugin = {
        "pretty",
        "html:target/cucumber-report/report.html",
        "json:target/cucumber-report/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
    
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
```

### BDD Execution Flow

1. **Feature File Parsing**: Cucumber reads `.feature` files
2. **Scenario Matching**: Scenarios matching tags are selected
3. **Step Definition Mapping**: Each step is mapped to corresponding Java method
4. **Test Execution**: Steps are executed in sequence
5. **Hooks Execution**: `@Before` and `@After` hooks run for each scenario
6. **Reporting**: Results are captured in Extent Reports and Cucumber Reports

### BDD Data Management

Test data is loaded from Excel/JSON/CSV files based on the test case ID (`tc_id`) specified in the Examples table:

```gherkin
Examples:
  | tc_id                 |
  | SeleniumPracticeTest4 |
```

The framework automatically loads test data for `SeleniumPracticeTest4` from the datatable files.

---

## Modular Framework Workflow

The Modular approach uses **TestNG** with a structured class hierarchy. Tests extend base classes and implement specific methods.

### Modular Components

#### 1. Base Test Class (`ModularTestCase.java`)

All modular tests extend `ModularTestCase`:

```java
public abstract class ModularTestCase {
    protected FrameworkDataTable dataTable;
    protected SeleniumReport report;
    protected CustomDriver driver;
    protected ScriptHelper scriptHelper;
    protected Properties properties;
    protected RestAssuredUtils apiDriver;
    
    // Abstract methods to be implemented by test classes
    public abstract void setUp();
    public abstract void executeTest();
    public abstract void tearDown();
}
```

#### 2. Test Configuration (`TestConfigurationsLite.java`)

Provides data providers for different execution modes:

```java
public class TestConfigurationsLite extends ModularTestCase {
    
    @DataProvider(name = "ChromeBrowser")
    public Object[][] desktopBrowsers(Method currentMethod) {
        currentScenario = currentMethod.getDeclaringClass()
            .getSimpleName().split("Test")[0] + "Scenario";
        currentTestcase = currentMethod.getDeclaringClass().getSimpleName();
        
        return new Object[][] { {
            new SeleniumParametersBuilders(currentScenario, currentTestcase)
                .testInstance("Instance1")
                .executionMode(ExecutionMode.LOCAL)
                .browser(Browser.CHROME)
                .build()
        } };
    }
    
    @DataProvider(name = "MobileAndroid")
    public Object[][] mobileDevice(Method currentMethod) {
        // Similar structure for mobile tests
    }
}
```

#### 3. Modular Test Class Example

```java
public class OrangeModular_Login_PerformValidLogin 
    extends TestConfigurationsLite {
    
    @Test(dataProvider = "ChromeBrowser", 
          dataProviderClass = TestConfigurationsLite.class)
    public void linkUnregisteredOMNYCard(
            SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription(
            "MSD CRM - Link Unregistered OMNY Card to Customer");
        
        DriverScript driverScript = new DriverScript(testParameters);
        driverScript.driveTestExecution();
        tearDownTestRunner(testParameters, driverScript);
    }
    
    @Override
    public void setUp() {
        // Initialize test environment
        System.out.println("Setup: Initializing test environment");
    }
    
    @Override
    public void executeTest() {
        // Execute test steps
        navigateToMasterSearch();
        searchUnregisteredOMNYCard();
        clickLinkToCustomerAction();
        // ... more steps
    }
    
    @Override
    public void tearDown() {
        // Cleanup
        System.out.println("Teardown: Cleaning up test resources");
    }
}
```

#### 4. Driver Script (`DriverScript.java`)

The core execution engine that orchestrates test execution:

```java
public class DriverScript {
    public void driveTestExecution() {
        startUp();                    // Load properties and settings
        initializeTestIterations();   // Set up data iterations
        initializeWebDriver();        // Create WebDriver instance
        initializeTestReport();       // Initialize reporting
        initializeDatatable();        // Load test data
        executeFramework();           // Execute test (BDD or Modular)
        quitWebDriver();              // Close driver
        wrapUp();                     // Finalize reporting
    }
}
```

### Modular Execution Flow

1. **TestNG Suite**: TestNG reads `TestNGHybrid.xml` or test classes
2. **Data Provider**: Provides test parameters (browser, execution mode, etc.)
3. **Test Initialization**: `DriverScript` initializes framework components
4. **Test Execution**: Calls `setUp()`, `executeTest()`, `tearDown()` methods
5. **Reporting**: Results captured in Extent Reports
6. **Summary Report**: Test summary generated at suite level

### Keyword-Driven Approach

The framework also supports **Keyword-Driven** testing where test steps are defined in Excel files:

1. **Business Flow Sheet**: Contains keywords and iterations
2. **Keyword Classes**: Java classes in `com.keyword.steps` package
3. **Keyword Methods**: Methods matching keyword names
4. **Execution**: DriverScript invokes keywords dynamically

Example Keyword Class:

```java
public class WebKeyword extends HybridWebPage {
    public WebKeyword(ScriptHelper scriptHelper) {
        super(scriptHelper);
    }
    
    public void launchSeleniumUrl() {
        launchApp();
    }
    
    public void verifyHome() {
        clickAcceptCookies();
        verifyHomeScreen();
        clickOkButton();
    }
}
```

---

## Setup Instructions

### Prerequisites

1. **Java Development Kit (JDK)**
   - Version: **Java 17** (required)
   - Download: [Oracle JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or [OpenJDK](https://adoptium.net/)
   - Verify: `java -version`

2. **Maven**
   - Version: **3.8.4** or higher
   - Download: [Apache Maven](https://maven.apache.org/download.cgi)
   - Verify: `mvn -version`

3. **IDE** (Optional but recommended)
   - IntelliJ IDEA (recommended)
   - Eclipse
   - VS Code with Java extensions

4. **Browsers** (for local execution)
   - Chrome (latest version)
   - Firefox (latest version)
   - Edge (latest version)

5. **Mobile Testing** (if needed)
   - Appium Server
   - Android SDK / Xcode
   - Emulators/Simulators or real devices

### Installation Steps

#### 1. Clone/Download the Framework

```bash
# If using Git
git clone <repository-url>
cd Qualiframe-JAVA-Maven_v3.0

# Or extract the downloaded ZIP file
```

#### 2. Configure Java

```bash
# Set JAVA_HOME environment variable
export JAVA_HOME=/path/to/jdk-17
export PATH=$JAVA_HOME/bin:$PATH

# Verify installation
java -version
```

#### 3. Configure Maven

```bash
# Set M2_HOME environment variable
export M2_HOME=/path/to/maven
export PATH=$M2_HOME/bin:$PATH

# Verify installation
mvn -version
```

#### 4. Build the Project

```bash
# Navigate to project root
cd Qualiframe-JAVA-Maven_v3.0

# Clean and compile
mvn clean compile

# Install dependencies
mvn clean install -DskipTests
```

#### 5. Configure Framework Settings

Edit `src/test/resources/properties/Global Settings.properties`:

```properties
# Execution Approach: BDD, MODULAR, or KEYWORD
ExecutionApproach=BDD

# Test Configuration
TestConfigurationID=LOCALChrome

# Test Data Source: EXCEL, JSON, CSV, or ACCESSDB
TestData=EXCEL

# Default Data Sheet
DefaultDataSheet=Test_Data

# Reporting
HtmlReport=true
TakeScreenshotFailedStep=true
TakeScreenshotPassedStep=false

# Project Name
ProjectName=QualiFrameV3 Project

# Application URLs
qaAppUrl=https://qa.example.com
prodAppUrl=https://prod.example.com
defaultEnvironment=qa
```

#### 6. Configure Test Data

Place test data files in `src/test/resources/datatables/`:
- Excel files: `*.xls` or `*.xlsx`
- JSON files: `*.json`
- CSV files: `*.csv`

#### 7. Verify Setup

```bash
# Run a simple test to verify setup
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@WebDemo"
```

---

## Execution Instructions

### BDD Test Execution

#### Run All BDD Tests

```bash
mvn clean test -PrunBDDTests
```

#### Run Tests with Specific Tags

```bash
# Run tests with @WebDemo tag
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@WebDemo"

# Run tests with multiple tags
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@WebDemo and @P1-High"

# Exclude specific tags
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@WebDemo and not @Skip"
```

#### Run Specific Feature File

```bash
mvn clean test -PrunBDDTests -Dcucumber.features="src/test/resources/features/Web.feature"
```

#### Run with Custom Configuration

```bash
mvn clean test -PrunBDDTests \
  -DTestConfiguration=LOCALFirefox \
  -Dcucumber.filter.tags="@WebDemo"
```

### Modular Test Execution

#### Run All Modular Tests

```bash
mvn clean test -PrunTestNGTests
```

#### Run Specific Test Class

```bash
mvn clean test -PrunTestNGTests \
  -Dtest=OrangeModular_Login_PerformValidLogin
```

#### Run Tests from TestNG XML

```bash
mvn clean test -PrunTestNGTests \
  -DsuiteXmlFile=src/test/resources/TestNGHybrid.xml
```

#### Run with Parallel Execution

Edit `TestNGHybrid.xml`:

```xml
<suite name="Regression" parallel="methods" thread-count="4">
    <test name="Test Suite">
        <classes>
            <class name="com.modular.steps.WebModularTest1" />
        </classes>
    </test>
</suite>
```

### Execution Modes

#### Local Execution

```bash
# Set TestConfigurationID in properties or command line
mvn clean test -PrunBDDTests \
  -DTestConfigurationID=LOCALChrome
```

#### Grid Execution

```bash
# Configure RemoteUrl in Global Settings.properties
mvn clean test -PrunBDDTests \
  -DTestConfigurationID=GRIDChrome
```

#### Cloud Platform Execution

```bash
# Sauce Labs
mvn clean test -PrunBDDTests \
  -DTestConfigurationID=SAUCELABSChrome

# BrowserStack
mvn clean test -PrunBDDTests \
  -DTestConfigurationID=BROWSERSTACKChrome

# LambdaTest
mvn clean test -PrunBDDTests \
  -DTestConfigurationID=LAMBDATESTChrome
```

### Mobile Test Execution

#### Android

```bash
mvn clean test -PrunBDDTests \
  -Dcucumber.filter.tags="@Android"
```

#### iOS

```bash
mvn clean test -PrunBDDTests \
  -Dcucumber.filter.tags="@iOS"
```

### API Test Execution

```bash
mvn clean test -PrunBDDTests \
  -Dcucumber.filter.tags="@api"
```

### Docker Execution

```bash
# Build Docker image
docker build -t qualiframe-v3 .

# Run tests in container
docker run --rm qualiframe-v3 mvn clean test -PrunBDDTests

# With volume mount for reports
docker run --rm \
  -v $(pwd)/Results:/app/Results \
  qualiframe-v3 mvn clean test -PrunBDDTests
```

---

## Key Components

### 1. DriverScript

The core execution engine that orchestrates test execution:

- **Location**: `com.framework.components.DriverScript`
- **Responsibilities**:
  - Initialize WebDriver/AppiumDriver
  - Load test data
  - Initialize reporting
  - Execute test iterations
  - Handle exceptions
  - Generate reports

### 2. ModularTestCase

Base class for all modular tests:

- **Location**: `com.framework.components.ModularTestCase`
- **Key Methods**:
  - `setUp()`: Pre-test setup
  - `executeTest()`: Test execution
  - `tearDown()`: Post-test cleanup

### 3. ScriptHelper

Wrapper class providing access to framework objects:

- **Location**: `com.framework.components.ScriptHelper`
- **Provides Access To**:
  - `FrameworkDataTable`: Test data
  - `SeleniumReport`: Reporting
  - `CustomDriver`: WebDriver wrapper
  - `RestAssuredUtils`: API utilities

### 4. FrameworkDataTable

Manages test data from multiple sources:

- **Location**: `com.framework.data.FrameworkDataTable`
- **Supported Formats**: Excel, JSON, CSV, Access Database
- **Key Methods**:
  - `getData(datasheetName, fieldName)`: Get test data
  - `putData(datasheetName, fieldName, value)`: Set test data

### 5. WebDriverFactory

Creates and configures WebDriver instances:

- **Location**: `com.framework.selenium.WebDriverFactory`
- **Supported Browsers**: Chrome, Firefox, Edge, Safari
- **Features**: Headless mode, mobile emulation, remote execution

### 6. TestHarness (BDD)

Manages driver lifecycle for Cucumber tests:

- **Location**: `com.framework.cucumber.TestHarness`
- **Responsibilities**:
  - Create drivers based on execution mode
  - Initialize test data
  - Manage driver instances

---

## Data Management

### Excel Data Management

Test data is stored in Excel files with the following structure:

```
Test_Data Sheet:
| TestCaseID | Iteration | UserName | Password | ExpectedResult |
|------------|-----------|----------|----------|----------------|
| Test1      | 1         | user1    | pass1    | Success        |
| Test1      | 2         | user2    | pass2    | Success        |

Business_Flow Sheet:
| TestCaseID | Keyword1 | Keyword2 | Keyword3 |
|------------|----------|----------|-----------|
| Test1      | login    | search   | logout   |
```

**Usage in Tests**:

```java
// Modular approach
String userName = dataTable.getData("Test_Data", "UserName");
String password = dataTable.getData("Test_Data", "Password");

// BDD approach - data loaded automatically based on tc_id
```

### JSON Data Management

Test data in JSON format:

```json
{
  "SeleniumPracticeTest4": {
    "General_Data": {
      "UserName": "standard_user",
      "Password": "secret_sauce"
    }
  }
}
```

### CSV Data Management

Test data in CSV format:

```csv
TestCaseID,UserName,Password
SeleniumPracticeTest4,standard_user,secret_sauce
```

### Access Database

Test data stored in Microsoft Access database files (`.mdb` or `.accdb`).

---

## Reporting

### Extent Reports

Comprehensive HTML reports with:
- Test execution summary
- Step-by-step logs
- Screenshots
- Execution time
- Pass/Fail statistics

**Location**: `Results/ExtentReport/`

### Cucumber Reports

Cucumber HTML and JSON reports:
- Feature execution status
- Scenario results
- Step definitions mapping

**Location**: `target/cucumber-report/`

### Allure Reports

Advanced reporting with:
- Historical trends
- Test analytics
- Performance metrics

**Generate Report**:
```bash
mvn allure:report
```

---

## Additional Features

### AI/ML Integration

- **Smart Test Selection**: Recommends tests based on historical data
- **Failure Pattern Analysis**: Identifies common failure patterns
- **Performance Analytics**: Tracks execution trends

### Performance Monitoring

- **Execution Time Tracking**: Monitors test execution duration
- **Resource Utilization**: Tracks CPU and memory usage
- **Performance Optimization**: Dynamic timeout adjustments

### Security Features

- **Secure Credential Management**: AES/GCM encryption
- **KeyStore Integration**: Secure key storage
- **Audit Logging**: Comprehensive access logs

### Docker Support

- **Containerized Execution**: Run tests in Docker containers
- **Selenium Grid Integration**: Docker Compose setup
- **Multi-stage Builds**: Optimized image sizes

### CI/CD Integration

- **GitLab CI**: `.gitlab-ci.yml` configuration
- **Jenkins**: Compatible with Jenkins pipelines
- **GitHub Actions**: Can be configured for GitHub Actions

---

## Developer Onboarding

### Getting Started Checklist

- [ ] Install Java 17 and Maven 3.8.4+
- [ ] Clone/download the framework
- [ ] Build the project: `mvn clean install`
- [ ] Configure `Global Settings.properties`
- [ ] Create test data files
- [ ] Run sample test to verify setup

### Creating Your First BDD Test

1. **Create Feature File** (`src/test/resources/features/MyFeature.feature`):

```gherkin
Feature: My First Test

  @MyTest
  Scenario Outline: Test scenario
    Given I navigate to application
    When I perform action "<action>"
    Then I verify result "<result>"

    Examples:
      | action | result |
      | click  | success|
```

2. **Create Step Definitions** (`src/test/java/com/cucumber/steps/MySteps.java`):

```java
public class MySteps extends WebPage {
    @Given("I navigate to application")
    public void navigateToApplication() {
        launchApp();
    }
    
    @When("I perform action {string}")
    public void performAction(String action) {
        // Implementation
    }
    
    @Then("I verify result {string}")
    public void verifyResult(String result) {
        // Implementation
    }
}
```

3. **Run the Test**:

```bash
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@MyTest"
```

### Creating Your First Modular Test

1. **Create Test Class** (`src/test/java/com/modular/steps/MyModularTest.java`):

```java
public class MyModularTest extends TestConfigurationsLite {
    
    @Test(dataProvider = "ChromeBrowser", 
          dataProviderClass = TestConfigurationsLite.class)
    public void myTest(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("My Test Description");
        DriverScript driverScript = new DriverScript(testParameters);
        driverScript.driveTestExecution();
        tearDownTestRunner(testParameters, driverScript);
    }
    
    @Override
    public void setUp() {
        // Setup code
    }
    
    @Override
    public void executeTest() {
        // Test steps
        String userName = dataTable.getData("Test_Data", "UserName");
        // Use userName in test
    }
    
    @Override
    public void tearDown() {
        // Cleanup code
    }
}
```

2. **Add to TestNG XML** (`src/test/resources/TestNGHybrid.xml`):

```xml
<suite name="MySuite">
    <test name="MyTest">
        <classes>
            <class name="com.modular.steps.MyModularTest" />
        </classes>
    </test>
</suite>
```

3. **Run the Test**:

```bash
mvn clean test -PrunTestNGTests
```

### Best Practices

1. **Page Object Model**: Use POM for web elements
2. **Reusable Components**: Create reusable methods in component classes
3. **Data-Driven**: Use external data files for test data
4. **Error Handling**: Implement proper exception handling
5. **Logging**: Use framework reporting for test logs
6. **Screenshots**: Enable screenshots for failed steps
7. **Clean Code**: Follow Java coding conventions

### Common Issues and Solutions

#### Issue: Tests not finding step definitions

**Solution**: Ensure step definition package is included in `glue` parameter:
```java
@CucumberOptions(glue = { "com.cucumber.steps" })
```

#### Issue: WebDriver not initialized

**Solution**: Check `TestConfigurationID` in properties file matches execution mode.

#### Issue: Test data not loading

**Solution**: Verify test data file exists and `tc_id` matches test case ID in data file.

---

## 🚀 New Features & Enhancements

### 1. Modern WebDriver Implementation
- **Selenium 4.28.1**: Updated to latest Selenium 4.28.1 with JDK HTTP client support
- **NettyClient Compatibility Fix**: Stub implementation prevents NoClassDefFoundError with Selenium 4.28.1
- **JDK HTTP Client**: Configured to use JDK HTTP client instead of Netty for better compatibility
- **Enhanced Browser Support**: Chrome, Firefox, Edge, Safari with modern options
- **Mobile Emulation**: Improved Chrome mobile emulation capabilities
- **Headless Mode**: Modern headless execution with `--headless=new`
- **Performance Optimizations**: Dynamic timeout adjustments based on execution history

### 2. Docker Containerization
- **Multi-stage Docker Build**: Optimized image size with build and runtime stages
- **Selenium Grid Integration**: Complete Docker Compose setup with Selenium Grid
- **Allure Reporting**: Integrated Allure report server in Docker
- **Easy Management**: Docker scripts for simplified framework management

### 3. Performance Optimization
- **Smart Thread Pool Management**: Dynamic thread pool sizing based on system resources
- **Performance Monitoring**: Real-time execution time tracking and optimization
- **Adaptive Timeouts**: Dynamic timeout adjustments based on application performance
- **Parallel Execution**: Enhanced parallel test execution with performance metrics

### 4. AI/ML Integration
- **Smart Test Selection**: Intelligent test recommendation based on historical data
- **Failure Pattern Analysis**: Automatic detection of common failure patterns
- **Performance Analytics**: Test execution analytics and trend analysis
- **Predictive Maintenance**: Identify tests needing attention before they fail

### 5. Enhanced Security
- **Secure Credential Management**: AES/GCM encryption for sensitive data
- **KeyStore Integration**: Java KeyStore for secure key management
- **Environment Variable Support**: Fallback to environment variables for credentials
- **Audit Trail**: Comprehensive logging of credential access

### 6. GraphQL API Automation
- **Query Support**: Execute GraphQL queries to fetch data
- **Mutation Support**: Execute GraphQL mutations to modify data
- **Response Parsing**: Extract data using JSON paths with array indexing support
- **Error Handling**: Comprehensive error detection and validation
- **Variable Support**: Pass variables in queries/mutations from test data or JSON
- **File-based Queries**: Load GraphQL queries from external `.graphql` files
- **BDD Integration**: Full Cucumber BDD support with reusable step definitions
- **Flexible Configuration**: Support for full URLs and relative paths
- **Automatic Fallback**: GET request fallback when POST returns 405 for queries

### 7. Healenium Self-Healing Test Automation
- **Self-Healing Locators**: Automatically fixes broken locators at runtime using ML algorithms
- **Zero Code Changes**: Works transparently with existing test code
- **Runtime Fixes**: Intercepts NoSuchElementException and replaces with working locators
- **Detailed Reporting**: Provides reports showing which locators were fixed
- **CI/CD Stability**: Reduces test failures due to UI changes
- **Backend Integration**: Supports Healenium backend service for healing operations
- **Multiple Setup Options**: Build from source, Docker, or pre-built JAR
- **See**: [HEALENIUM_INTEGRATION_GUIDE.md](HEALENIUM_INTEGRATION_GUIDE.md) for detailed setup instructions

### 8. Selenium 4.28.1 Compatibility Enhancements
- **NettyClient Stub**: Prevents NoClassDefFoundError when ServiceLoader discovers NettyClient$Factory
- **Early HTTP Client Initialization**: Ensures JDK HTTP client is configured before WebDriver creation
- **System Property Configuration**: Automatic configuration via Maven Surefire plugin
- **Error Recovery**: Automatic retry mechanism for NettyClient-related errors
- **Transparent Operation**: No changes required to existing test code

## 📋 Requirements

### Prerequisites
- Java 17 (LTS) - Required
- Maven 3.8.4+ (3.9.6 included in framework)
- Docker & Docker Compose (for containerized execution)
- Chrome, Firefox, Edge browsers (for local execution)
- Healenium Backend (optional, for self-healing features) - Java 11+ required

### Docker Requirements
- Docker Engine 20.10+
- Docker Compose 2.0+
- 4GB+ RAM for containerized execution

## 🛠 Installation & Setup

### Traditional Setup
```bash
# Clone the repository
git clone <repository-url>
cd qualiframev3

# Build the project
mvn clean install

# Run tests
mvn test -PrunBDDTests
```

### Docker Setup
```bash
# Build and start the framework
./docker-scripts.sh build
./docker-scripts.sh start

# Run tests
./docker-scripts.sh run runBDDTests @WebDemo

# View reports
./docker-scripts.sh allure
```

## 🚀 Usage Examples

### 1. Healenium Self-Healing Automation

#### Enable Healenium

Edit `src/test/resources/properties/Global Settings.properties`:
```properties
# Enable Healenium
HealeniumEnabled=true

# Healenium Backend URL (default: http://localhost:7878)
HealeniumBackendUrl=http://localhost:7878
```

#### Start Healenium Backend

```bash
# Option 1: Build from source (Recommended)
git clone https://github.com/healenium/healenium-backend.git
cd healenium-backend
mvn clean install -DskipTests
mvn spring-boot:run

# Option 2: Use pre-built JAR
java -jar healenium-backend-*.jar
```

#### Usage in Tests

No code changes required! Healenium works transparently:

```java
// Your existing code works as-is
WebDriver driver = WebDriverFactory.getWebDriver(testParameters);
driver.findElement(By.id("login-button")).click();
// If the locator breaks, Healenium will automatically fix it
```

**See**: [HEALENIUM_INTEGRATION_GUIDE.md](HEALENIUM_INTEGRATION_GUIDE.md) for complete setup instructions.

### 2. GraphQL API Automation

#### Basic Query Execution
```gherkin
@graphql
Scenario Outline: Execute GraphQL query to fetch data
  Given Access GraphQL endpoint "GraphQLEndpoint" with "header2" for "<tc_id>"
  When Execute GraphQL query "<query>" with variables "<variables>"
  Then verify GraphQL request is success with status "<code>"
  And verify GraphQL response has no errors
  And verify GraphQL data path "<dataPath>" is "<expectedValue>"

  Examples:
    | tc_id         | url                    | headers | query                                    | variables | code | dataPath           | expectedValue |
    | GraphQLTest1  | GraphQLEndpoint        | header2 | query { country(code: \"US\") { name } } | NA        | 200  | country.name       | United States |
```

#### Mutation Execution
```gherkin
@graphql @graphql-mutation
Scenario Outline: Execute GraphQL mutation to modify data
  Given Access GraphQL endpoint "GraphQLEndpoint" with "header2" for "<tc_id>"
  When Execute GraphQL mutation "<mutation>" with variables "<variables>"
  Then verify GraphQL request is success with status "<code>"
  And verify GraphQL response has no errors
  And verify GraphQL data path "<dataPath>" exists

  Examples:
    | tc_id         | url                    | headers | mutation                                                                 | variables      | code | dataPath           |
    | GraphQLTest3  | GraphQLEndpoint        | header2 | mutation { createUser(name: \"Test User\") { id name } } | NA             | 200  | createUser.id       |
```

#### Query from File
```gherkin
@graphql
Scenario Outline: Execute GraphQL query from file
  Given Access GraphQL endpoint "GraphQLEndpoint" with "header2" for "<tc_id>"
  When Execute GraphQL query from file "<queryFile>"
  Then verify GraphQL request is success with status "<code>"
  And verify GraphQL response has no errors
  And verify GraphQL data path "<dataPath>" is "<expectedValue>"

  Examples:
    | tc_id         | url                    | headers | queryFile          | code | dataPath           | expectedValue |
    | GraphQLTest5  | GraphQLEndpoint        | header2 | GetCountryQuery.graphql | 200  | country.capital    | Washington D.C. |
```

#### Programmatic Usage
```java
// Initialize GraphQL utility
GraphQL graphQL = new GraphQL();

// Execute a query
Map<String, String> headers = new HashMap<>();
headers.put("Content-Type", "application/json");

ValidatableResponse response = graphQL.executeQuery(
    "https://api.example.com/graphql",
    "query { user(id: 1) { name email } }",
    null, // variables
    headers,
    200
);

// Extract data
String userName = (String) graphQL.extractData(response, "user.name");

// Verify no errors
boolean hasErrors = graphQL.hasErrors(response);

// Assert data
graphQL.assertGraphQLData(
    "https://api.example.com/graphql",
    response,
    "user.email",
    "user@example.com",
    GraphQL.COMPARISON.IS_EQUALS
);
```

### 3. Modern WebDriver Usage
```java
// Enhanced WebDriver with modern capabilities
WebDriver driver = WebDriverFactory.getWebDriver(testParameters);

// Optimized wait with performance-based timeout
WebDriverWait wait = PerformanceOptimizer.createOptimizedWait(driver);
```

### 3. Performance Optimization
```java
// Initialize performance optimizer
PerformanceOptimizer.initialize(4); // 4 threads

// Execute tests with performance monitoring
CompletableFuture<Void> future = PerformanceOptimizer.executeAsync(() -> {
    // Test execution code
}, "TestName");

// Get performance statistics
PerformanceOptimizer.PerformanceStats stats = PerformanceOptimizer.getPerformanceStats();
```

### 5. Smart Test Selection
```java
// Initialize smart test selector
SmartTestSelector.initialize();

// Get recommended tests
List<String> recommendedTests = SmartTestSelector.getRecommendedTests("chrome", "qa", 10);

// Record test execution
SmartTestSelector.TestExecutionRecord record = new SmartTestSelector.TestExecutionRecord();
record.setTestName("LoginTest");
record.setPassed(true);
record.setExecutionTime(5000);
SmartTestSelector.recordTestExecution(record);
```

### 6. Secure Credential Management
```java
// Initialize secure credential manager
SecureCredentialManager.initialize();

// Store credentials securely
SecureCredentialManager.storeCredential("db_password", "mysecretpassword");

// Retrieve credentials
String password = SecureCredentialManager.getCredential("db_password");
```

## 🐳 Docker Commands

### Basic Docker Operations
```bash
# Build the framework image
./docker-scripts.sh build

# Start Selenium Grid
./docker-scripts.sh start

# Run tests with specific profile
./docker-scripts.sh run runBDDTests @WebDemo

# Run tests with custom configuration
./docker-scripts.sh run-custom chrome true 4

# Start Allure report server
./docker-scripts.sh allure

# View logs
./docker-scripts.sh logs qualiframe-app

# Check status
./docker-scripts.sh status

# Stop all services
./docker-scripts.sh stop

# Clean up resources
./docker-scripts.sh cleanup
```

### Docker Compose Services
- **selenium-hub**: Selenium Grid Hub
- **chrome**: Chrome browser node
- **firefox**: Firefox browser node
- **qualiframe-app**: Main application container
- **allure**: Allure report server

## 📊 Performance Monitoring

### Performance Metrics
- **Execution Time**: Average test execution time
- **Success Rate**: Test success rate percentage
- **Active Threads**: Number of currently executing tests
- **Queue Size**: Number of tests waiting to execute
- **Resource Utilization**: CPU and memory usage

### Performance Optimization Features
- **Dynamic Thread Pool**: Automatically adjusts based on system resources
- **Adaptive Timeouts**: Timeouts adjust based on application performance
- **Load Balancing**: Intelligent test distribution across available resources
- **Resource Monitoring**: Real-time monitoring of system resources

## 🤖 AI/ML Features

### Smart Test Selection
- **Historical Analysis**: Uses test execution history for recommendations
- **Pattern Recognition**: Identifies test behavior patterns
- **Failure Prediction**: Predicts tests likely to fail
- **Performance Scoring**: Scores tests based on multiple factors

### Failure Pattern Analysis
- **Common Failures**: Identifies frequently occurring failure patterns
- **Impact Assessment**: Calculates impact score for each failure pattern
- **Browser-Specific Analysis**: Analyzes failures by browser
- **Environment Analysis**: Analyzes failures by environment

### Test Recommendations
- **Context-Aware**: Recommendations based on browser and environment
- **Performance-Based**: Prioritizes tests with good performance history
- **Risk Assessment**: Considers test stability and failure patterns
- **Maintenance Alerts**: Identifies tests needing attention

## 🔒 Security Features

### Credential Management
- **AES/GCM Encryption**: Military-grade encryption for sensitive data
- **Java KeyStore**: Secure key storage using Java KeyStore
- **Environment Variables**: Support for environment variable credentials
- **Audit Logging**: Comprehensive logging of credential access

### Security Best Practices
- **No Hardcoded Credentials**: All credentials are encrypted or externalized
- **Secure Defaults**: Framework defaults to secure configurations
- **Access Control**: Credential access is controlled and logged
- **Key Rotation**: Support for credential rotation and updates

## 📈 Reporting & Analytics

### Enhanced Reports
- **Extent Reports**: Rich HTML reporting with custom themes
- **Allure Reports**: Advanced reporting with trends and analytics
- **Performance Reports**: Detailed performance metrics and trends
- **Security Reports**: Credential access and security audit reports

### Analytics Features
- **Execution Trends**: Historical execution time trends
- **Failure Analysis**: Detailed failure pattern analysis
- **Performance Metrics**: Comprehensive performance statistics
- **Resource Utilization**: System resource usage analytics

## 🔧 Configuration

### GraphQL Configuration

#### Endpoint Configuration
Add your GraphQL endpoint to `/src/test/resources/properties/API Automation Endpoints.properties`:

```properties
# GraphQL Endpoint Configuration
# Use full URL for external APIs
GraphQLEndpoint=https://api.example.com/graphql

# Or use relative path (appended to BaseURL)
GraphQLEndpoint=/graphql
```

#### Test Data Setup for Variables
For mutations/queries with variables, add to your test data file:

```properties
# In your test data file (e.g., GraphQLTest4)
UserVariables={"id":"1","name":"Updated Name"}
```

#### GraphQL Query Files
Place your `.graphql` query files in:
```
src/test/resources/api/graphql/
```

Example query file (`GetCountryQuery.graphql`):
```graphql
query {
  country(code: "US") {
    name
    capital
    currency
  }
}
```

#### Running GraphQL Tests
```bash
# Run all GraphQL tests
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@graphql"

# Run only query tests (exclude mutations)
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@graphql and not @graphql-mutation"

# Run only mutation tests
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@graphql-mutation"
```

### Global Settings
```properties
# Performance Settings
PerformanceOptimization=true
ThreadPoolSize=4
AdaptiveTimeouts=true

# AI/ML Settings
SmartTestSelection=true
FailurePatternAnalysis=true
TestRecommendations=true

# Security Settings
SecureCredentials=true
CredentialEncryption=true
AuditLogging=true
```

### Docker Configuration
```yaml
# docker-compose.yml
services:
  qualiframe-app:
    environment:
      - PARALLEL_EXECUTION=true
      - THREAD_COUNT=4
      - SMART_SELECTION=true
      - SECURE_CREDENTIALS=true
```

## 🧪 Test Execution

### Traditional Execution
```bash
# Run BDD tests
mvn clean test -PrunBDDTests

# Run modular tests
mvn clean test -PrunTestNGTests

# Run with specific tags
mvn clean test -PrunBDDTests -Dcucumber.filter.tags="@WebDemo"
```

### Docker Execution
```bash
# Run tests in container
docker-compose run --rm qualiframe-app mvn clean test -PrunBDDTests

# Run with custom configuration
docker-compose run --rm qualiframe-app mvn clean test \
  -DTestConfigurationID=REMOTEchrome \
  -Dparallel=true \
  -DthreadCount=4
```

## 📝 Best Practices

### Healenium Usage
1. **Start with Healenium Disabled**: First ensure tests run correctly without Healenium
2. **Monitor Reports**: Regularly check Healenium reports to understand which locators break frequently
3. **Use Stable Locators**: Prefer IDs, data-testid attributes over fragile XPath selectors
4. **Review Fixed Locators**: Periodically review and update test code with new locators
5. **Backend Maintenance**: If using PostgreSQL, maintain database regularly

### GraphQL API Testing
1. **Endpoint Configuration**: Use full URLs for external APIs, relative paths for internal APIs
2. **Query Organization**: Store complex queries in `.graphql` files for reusability
3. **Variable Management**: Use test data files for variables to keep scenarios clean
4. **Error Handling**: Always verify no errors in GraphQL responses
5. **Data Extraction**: Use JSON paths with array indexing (e.g., `countries[0].name`)
6. **Tag Management**: Use `@graphql-mutation` tag to separate mutation tests
7. **Read-only APIs**: Exclude `@graphql-mutation` when testing read-only GraphQL APIs

### Performance Optimization
1. **Use Performance Optimizer**: Initialize and use the performance optimizer
2. **Monitor Metrics**: Regularly check performance statistics
3. **Adjust Thread Pool**: Configure thread pool size based on system resources
4. **Use Smart Selection**: Leverage AI/ML features for test selection

### Security
1. **Use Secure Credentials**: Store all sensitive data using SecureCredentialManager
2. **Environment Variables**: Use environment variables for CI/CD pipelines
3. **Regular Audits**: Monitor credential access logs
4. **Key Rotation**: Regularly rotate encryption keys

### Docker Usage
1. **Resource Limits**: Set appropriate resource limits for containers
2. **Volume Mounts**: Use volume mounts for persistent data
3. **Health Checks**: Monitor container health
4. **Cleanup**: Regularly clean up unused containers and images

## 🐛 Troubleshooting

### Common Issues

#### Selenium 4.28.1 NettyClient Issues

**Problem**: `NoClassDefFoundError: org/openqa/selenium/remote/http/netty/NettyClient$Factory`

**Solution**: The framework includes a stub NettyClient implementation to prevent this error. Ensure:
- System properties are set: `-Dwebdriver.http.factory=jdk-http-client`
- Maven Surefire plugin is configured correctly (already done in pom.xml)
- HTTP client is initialized early (handled automatically by framework)

**Verification**:
```bash
# Check system properties are set
mvn test -PrunBDDTests -Dcucumber.filter.tags="@Smoke" -X | grep "webdriver.http.factory"
```

#### Healenium Issues

**Problem**: Tests fail with connection errors to Healenium backend

**Solution**: 
1. Ensure Healenium backend is running: `curl http://localhost:7878/actuator/health`
2. Check `HealeniumEnabled=true` in Global Settings.properties
3. Verify `HealeniumBackendUrl` is correct
4. See [HEALENIUM_SETUP_ALTERNATIVE.md](HEALENIUM_SETUP_ALTERNATIVE.md) for alternative setup methods

**Problem**: Docker image authorization errors

**Solution**: Build from source instead of using Docker images:
```bash
git clone https://github.com/healenium/healenium-backend.git
cd healenium-backend
mvn clean install -DskipTests
mvn spring-boot:run
```

#### GraphQL Issues

**HTTP 405 Method Not Allowed**
- Verify the GraphQL endpoint URL is correct
- Ensure the endpoint accepts POST requests
- Check if the endpoint path is correct (e.g., `/graphql`, `/api/graphql`)
- The framework automatically tries GET for queries if POST returns 405

**Variables Not Found**
- Ensure variables key exists in test data file
- Check that variables are in JSON format: `{"key":"value"}`
- Verify test data is loaded for the test case ID

**Data Extraction Returns Null**
- Verify the JSON path is correct (e.g., `user.name`, `countries[0].name`)
- Check the GraphQL response structure matches expected format
- Use debug logging to see the full response

**Mutation Tests Failing**
- Ensure your GraphQL API supports mutations (not read-only)
- Verify mutation syntax matches your API schema
- Check that required variables are provided
- Use `@graphql and not @graphql-mutation` to skip mutation tests with read-only APIs

#### Healenium Backend Issues

**Problem**: Backend won't start or connection refused

**Solution**:
```bash
# Check Java version (requires Java 11+)
java -version

# Check port availability
lsof -i :7878  # Linux/Mac
netstat -ano | findstr :7878  # Windows

# Verify backend health
curl http://localhost:7878/actuator/health
```

#### Docker Issues
```bash
# Check Docker status
docker info

# Check container logs
docker-compose logs qualiframe-app

# Restart services
docker-compose restart
```

#### Performance Issues
```bash
# Check performance statistics
PerformanceOptimizer.getPerformanceStats()

# Adjust thread pool size
PerformanceOptimizer.initialize(2); // Reduce to 2 threads
```

#### Security Issues
```bash
# Check credential status
SecureCredentialManager.hasCredential("key")

# Clear credential cache
SecureCredentialManager.clearCache()
```

## 🤝 Contributing

### Development Setup
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new features
5. Submit a pull request

### Code Standards
- Follow Java coding conventions
- Add comprehensive documentation
- Include unit tests for new features
- Update README for new features

## 📄 License

This project is licensed under the Apache License 2.0 - see the LICENSE file for details.

## 🆘 Support

### Documentation
- [Framework Documentation](docs/)
- [API Reference](docs/api/)
- [Examples](docs/examples/)

### Community
- [Issues](https://github.com/qualitest/qualiframe-v3/issues)
- [Discussions](https://github.com/qualitest/qualiframe-v3/discussions)
- [Wiki](https://github.com/qualitest/qualiframe-v3/wiki)

### Enterprise Support
- Contact: support@qualitest.com
- Documentation: https://qualitest.com/docs
- Training: https://qualitest.com/training

---

**QualiFrameV3 Enhanced** - Enterprise-grade test automation framework with modern features, AI/ML integration, self-healing capabilities (Healenium), and enhanced security.

## 🆕 Latest Updates (2024)

### Recent Enhancements
- ✅ **Healenium Integration**: Self-healing test automation for automatic locator fixes
- ✅ **Selenium 4.28.1**: Updated to latest Selenium with JDK HTTP client support
- ✅ **NettyClient Compatibility**: Stub implementation prevents NoClassDefFoundError
- ✅ **GraphQL Enhancements**: Updated GraphQL features and improved error handling
- ✅ **MCP Configuration Guide**: Added guide for Model Context Protocol server setup
- ✅ **Alternative Setup Methods**: Added alternative Healenium setup guide for Docker issues

### Breaking Changes
- **Java Version**: Requires Java 17 (LTS) - Java 15+ no longer supported
- **Selenium HTTP Client**: Now uses JDK HTTP client by default instead of Netty

---
## Support and Documentation

### Additional Resources

- **Framework Documentation**: See `docs/` directory (if available)
- **Technical Analysis**: `TECHNICAL_ANALYSIS.md`
- **Implementation Guide**: `IMPLEMENTATION_GUIDE.md`
- **Framework Review**: `FRAMEWORK_REVIEW.md`
- **Healenium Integration**: `HEALENIUM_INTEGRATION_GUIDE.md` - Self-healing test automation setup
- **Healenium Alternative Setup**: `HEALENIUM_SETUP_ALTERNATIVE.md` - Alternative setup methods
- **MCP Configuration**: `MCP_CONFIGURATION_GUIDE.md` - Model Context Protocol server configuration

### Contact

For support and questions:
- **Email**: support@qualitest.com
- **Documentation**: https://qualitest.com/docs

---

## License

This project is licensed under the Apache License 2.0 - see the LICENSE file for details.