package com.framework.learning;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.List;
import java.util.Arrays;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;

/**
 * Interactive Tutorial System for QualiFrameV2 Framework
 * Provides step-by-step guidance for framework usage
 * 
 * @author QualiFrameV2 Team
 * @version 2.0.1
 */
public class FrameworkTutorial extends JFrame {
    
    private List<TutorialStep> steps;
    private int currentStep = 0;
    
    private JLabel stepTitleLabel;
    private JTextArea stepDescriptionArea;
    private JTextArea codeExampleArea;
    private JButton previousButton;
    private JButton nextButton;
    private JButton finishButton;
    private JProgressBar progressBar;
    private JLabel stepCounterLabel;
    
    public FrameworkTutorial() {
        initializeTutorialSteps();
        initializeUI();
        showCurrentStep();
    }
    
    private void initializeTutorialSteps() {
        steps = Arrays.asList(
            new TutorialStep(
                "Welcome to QualiFrameV2",
                "Welcome to the QualiFrameV2 automation framework! This tutorial will guide you through " +
                "the essential concepts and help you get started with automation testing.\n\n" +
                "The framework supports multiple approaches:\n" +
                "• MODULAR: Java-based test classes\n" +
                "• CUCUMBER: BDD approach with Gherkin syntax\n" +
                "• KEYWORD: Excel-based keyword-driven testing",
                "// No code example for welcome step",
                "welcome"
            ),
            new TutorialStep(
                "Framework Setup",
                "Let's start by setting up your QualiFrameV2 environment. You'll need:\n\n" +
                "1. Java 17 or higher\n" +
                "2. Maven 3.8.4+\n" +
                "3. Chrome/Firefox/Edge browsers\n" +
                "4. IDE (Eclipse or IntelliJ)\n\n" +
                "The framework will automatically download required drivers.",
                "// Clone the repository\n" +
                "git clone <repository-url>\n" +
                "cd qualiframev2\n\n" +
                "// Build the project\n" +
                "mvn clean install\n\n" +
                "// Run your first test\n" +
                "mvn test -PrunBDDTests",
                "setup"
            ),
            new TutorialStep(
                "Configuration",
                "Configure your framework using the Configuration Wizard or properties files.\n\n" +
                "Key configuration options:\n" +
                "• Execution Approach (MODULAR/CUCUMBER/KEYWORD)\n" +
                "• Browser Configuration\n" +
                "• Test Data Source\n" +
                "• Environment Settings\n" +
                "• Parallel Execution",
                "// Global Settings.properties\n" +
                "ExecutionApproach=MODULAR\n" +
                "TestConfigurationID=LOCALChrome\n" +
                "TestData=EXCEL\n" +
                "defaultEnvironment=qa\n" +
                "ParallelExecution=true\n" +
                "NumberOfThreads=3",
                "configuration"
            ),
            new TutorialStep(
                "First Test",
                "Create your first test using the MODULAR approach. This is the simplest way to get started.\n\n" +
                "Key concepts:\n" +
                "• Extend BaseTest class\n" +
                "• Use @Test annotation\n" +
                "• Implement test logic\n" +
                "• Use WebDriver for browser interaction",
                "public class MyFirstTest extends BaseTest {\n" +
                "    @Test\n" +
                "    public void testLogin() {\n" +
                "        // Launch application\n" +
                "        driver.get(\"https://example.com\");\n" +
                "        \n" +
                "        // Find and interact with elements\n" +
                "        WebElement username = driver.findElement(By.id(\"username\"));\n" +
                "        username.sendKeys(\"testuser\");\n" +
                "        \n" +
                "        // Verify results\n" +
                "        Assert.assertTrue(driver.getTitle().contains(\"Dashboard\"));\n" +
                "    }\n" +
                "}",
                "first-test"
            ),
            new TutorialStep(
                "Page Object Model",
                "Learn the Page Object Model (POM) design pattern for better test maintainability.\n\n" +
                "Benefits:\n" +
                "• Reusable page elements\n" +
                "• Centralized element locators\n" +
                "• Easy maintenance\n" +
                "• Better test readability",
                "public class LoginPage {\n" +
                "    private WebDriver driver;\n" +
                "    \n" +
                "    // Element locators\n" +
                "    @FindBy(id = \"username\")\n" +
                "    private WebElement usernameField;\n" +
                "    \n" +
                "    @FindBy(id = \"password\")\n" +
                "    private WebElement passwordField;\n" +
                "    \n" +
                "    @FindBy(id = \"loginButton\")\n" +
                "    private WebElement loginButton;\n" +
                "    \n" +
                "    // Constructor\n" +
                "    public LoginPage(WebDriver driver) {\n" +
                "        this.driver = driver;\n" +
                "        PageFactory.initElements(driver, this);\n" +
                "    }\n" +
                "    \n" +
                "    // Page methods\n" +
                "    public void login(String username, String password) {\n" +
                "        usernameField.sendKeys(username);\n" +
                "        passwordField.sendKeys(password);\n" +
                "        loginButton.click();\n" +
                "    }\n" +
                "}",
                "pom"
            ),
            new TutorialStep(
                "Data-Driven Testing",
                "Implement data-driven testing using Excel, CSV, or database sources.\n\n" +
                "Approaches:\n" +
                "• @DataProvider annotation\n" +
                "• Excel data reading\n" +
                "• CSV data parsing\n" +
                "• Database queries",
                "public class DataDrivenTest extends BaseTest {\n" +
                "    @DataProvider(name = \"loginData\")\n" +
                "    public Object[][] getLoginData() {\n" +
                "        return new Object[][] {\n" +
                "            {\"user1\", \"pass1\", true},\n" +
                "            {\"user2\", \"pass2\", false},\n" +
                "            {\"admin\", \"admin123\", true}\n" +
                "        };\n" +
                "    }\n" +
                "    \n" +
                "    @Test(dataProvider = \"loginData\")\n" +
                "    public void testLogin(String username, String password, boolean expectedResult) {\n" +
                "        // Test implementation\n" +
                "        LoginPage loginPage = new LoginPage(driver);\n" +
                "        loginPage.login(username, password);\n" +
                "        \n" +
                "        if (expectedResult) {\n" +
                "            Assert.assertTrue(driver.getTitle().contains(\"Dashboard\"));\n" +
                "        } else {\n" +
                "            Assert.assertTrue(driver.getTitle().contains(\"Login\"));\n" +
                "        }\n" +
                "    }\n" +
                "}",
                "data-driven"
            ),
            new TutorialStep(
                "Cucumber BDD",
                "Use Cucumber for Behavior-Driven Development (BDD) testing.\n\n" +
                "Components:\n" +
                "• Feature files (.feature)\n" +
                "• Step definitions\n" +
                "• Test runner\n" +
                "• Hooks for setup/teardown",
                "// Feature file: Login.feature\n" +
                "Feature: User Login\n" +
                "  Scenario: Successful Login\n" +
                "    Given I am on the login page\n" +
                "    When I enter valid credentials\n" +
                "    And I click the login button\n" +
                "    Then I should see the dashboard\n\n" +
                "// Step definitions\n" +
                "@Given(\"I am on the login page\")\n" +
                "public void iAmOnTheLoginPage() {\n" +
                "    driver.get(\"https://example.com/login\");\n" +
                "}\n\n" +
                "@When(\"I enter valid credentials\")\n" +
                "public void iEnterValidCredentials() {\n" +
                "    // Implementation\n" +
                "}\n\n" +
                "@Then(\"I should see the dashboard\")\n" +
                "public void iShouldSeeTheDashboard() {\n" +
                "    Assert.assertTrue(driver.getTitle().contains(\"Dashboard\"));\n" +
                "}",
                "cucumber"
            ),
            new TutorialStep(
                "Parallel Execution",
                "Enable parallel test execution for faster test runs.\n\n" +
                "Configuration:\n" +
                "• Thread count setting\n" +
                "• Test grouping\n" +
                "• Resource management\n" +
                "• Result aggregation",
                "// TestNG XML configuration\n" +
                "<suite name=\"Parallel Suite\" parallel=\"methods\" thread-count=\"4\">\n" +
                "    <test name=\"Test Suite\">\n" +
                "        <classes>\n" +
                "            <class name=\"com.tests.LoginTest\" />\n" +
                "            <class name=\"com.tests.SearchTest\" />\n" +
                "        </classes>\n" +
                "    </test>\n" +
                "</suite>\n\n" +
                "// Or use Maven profiles\n" +
                "mvn test -PrunTestNGTests -DthreadCount=4",
                "parallel"
            ),
            new TutorialStep(
                "Reporting",
                "Generate comprehensive test reports using multiple reporting options.\n\n" +
                "Available Reports:\n" +
                "• Extent Reports (HTML)\n" +
                "• Allure Reports\n" +
                "• TestNG Reports\n" +
                "• Custom Reports",
                "// Extent Reports configuration\n" +
                "ExtentReports extent = new ExtentReports();\n" +
                "ExtentTest test = extent.createTest(\"Login Test\");\n" +
                "\n" +
                "try {\n" +
                "    // Test steps\n" +
                "    test.log(Status.PASS, \"Login successful\");\n" +
                "} catch (Exception e) {\n" +
                "    test.log(Status.FAIL, \"Login failed: \" + e.getMessage());\n" +
                "} finally {\n" +
                "    extent.flush();\n" +
                "}\n\n" +
                "// Allure Reports\n" +
                "mvn allure:serve",
                "reporting"
            ),
            new TutorialStep(
                "Advanced Features",
                "Explore advanced framework features for enterprise testing.\n\n" +
                "Features:\n" +
                "• AI/ML-powered test selection\n" +
                "• Performance monitoring\n" +
                "• Security testing\n" +
                "• Containerization support",
                "// AI/ML Features\n" +
                "SmartTestSelector.initialize();\n" +
                "List<String> recommendedTests = SmartTestSelector.getRecommendedTests(\"chrome\", \"qa\", 10);\n\n" +
                "// Performance Optimization\n" +
                "PerformanceOptimizer.initialize(4);\n" +
                "WebDriverWait wait = PerformanceOptimizer.createOptimizedWait(driver);\n\n" +
                "// Security Features\n" +
                "SecureCredentialManager.initialize();\n" +
                "String password = SecureCredentialManager.getCredential(\"db_password\");\n\n" +
                "// Docker Support\n" +
                "./docker-scripts.sh run runBDDTests @WebDemo",
                "advanced"
            ),
            new TutorialStep(
                "Congratulations!",
                "You've completed the QualiFrameV2 tutorial! You now have a solid understanding of:\n\n" +
                "✅ Framework setup and configuration\n" +
                "✅ Creating and running tests\n" +
                "✅ Page Object Model implementation\n" +
                "✅ Data-driven testing approaches\n" +
                "✅ Cucumber BDD testing\n" +
                "✅ Parallel execution\n" +
                "✅ Reporting and analytics\n" +
                "✅ Advanced framework features\n\n" +
                "Next steps:\n" +
                "• Practice with sample tests\n" +
                "• Explore advanced features\n" +
                "• Join the community\n" +
                "• Contribute to the framework",
                "// You're ready to start testing!\n" +
                "// Check out the examples folder for sample tests\n" +
                "// Visit the documentation for detailed guides\n" +
                "// Join our community for support and updates",
                "completion"
            )
        );
    }
    
    private void initializeUI() {
        setTitle("QualiFrameV2 Tutorial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        
        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Header panel
        JPanel headerPanel = createHeaderPanel();
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        // Content panel
        JPanel contentPanel = createContentPanel();
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        // Navigation panel
        JPanel navigationPanel = createNavigationPanel();
        mainPanel.add(navigationPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Tutorial Progress"));
        
        // Progress bar
        progressBar = new JProgressBar(0, steps.size() - 1);
        progressBar.setStringPainted(true);
        progressBar.setValue(0);
        
        // Step counter
        stepCounterLabel = new JLabel("Step 1 of " + steps.size());
        stepCounterLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        panel.add(progressBar, BorderLayout.CENTER);
        panel.add(stepCounterLabel, BorderLayout.EAST);
        
        return panel;
    }
    
    private JPanel createContentPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Step title
        stepTitleLabel = new JLabel("Welcome to QualiFrameV2");
        stepTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        stepTitleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(stepTitleLabel, BorderLayout.NORTH);
        
        // Step description
        stepDescriptionArea = new JTextArea();
        stepDescriptionArea.setEditable(false);
        stepDescriptionArea.setLineWrap(true);
        stepDescriptionArea.setWrapStyleWord(true);
        stepDescriptionArea.setFont(new Font("Arial", Font.PLAIN, 12));
        stepDescriptionArea.setBorder(BorderFactory.createTitledBorder("Description"));
        
        JScrollPane descriptionScrollPane = new JScrollPane(stepDescriptionArea);
        descriptionScrollPane.setPreferredSize(new Dimension(0, 200));
        panel.add(descriptionScrollPane, BorderLayout.CENTER);
        
        // Code example
        codeExampleArea = new JTextArea();
        codeExampleArea.setEditable(false);
        codeExampleArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
        codeExampleArea.setBorder(BorderFactory.createTitledBorder("Code Example"));
        
        JScrollPane codeScrollPane = new JScrollPane(codeExampleArea);
        codeScrollPane.setPreferredSize(new Dimension(0, 200));
        panel.add(codeScrollPane, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createNavigationPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Navigation"));
        
        // Previous button
        previousButton = new JButton("Previous");
        previousButton.addActionListener(e -> showPreviousStep());
        
        // Next button
        nextButton = new JButton("Next");
        nextButton.addActionListener(e -> showNextStep());
        
        // Finish button
        finishButton = new JButton("Finish Tutorial");
        finishButton.addActionListener(e -> finishTutorial());
        finishButton.setVisible(false);
        
        panel.add(previousButton);
        panel.add(nextButton);
        panel.add(finishButton);
        
        return panel;
    }
    
    private void showCurrentStep() {
        if (currentStep >= 0 && currentStep < steps.size()) {
            TutorialStep step = steps.get(currentStep);
            
            stepTitleLabel.setText(step.getTitle());
            stepDescriptionArea.setText(step.getDescription());
            codeExampleArea.setText(step.getCodeExample());
            
            // Update progress
            progressBar.setValue(currentStep);
            stepCounterLabel.setText("Step " + (currentStep + 1) + " of " + steps.size());
            
            // Update button states
            previousButton.setEnabled(currentStep > 0);
            nextButton.setEnabled(currentStep < steps.size() - 1);
            finishButton.setVisible(currentStep == steps.size() - 1);
        }
    }
    
    private void showPreviousStep() {
        if (currentStep > 0) {
            currentStep--;
            showCurrentStep();
        }
    }
    
    private void showNextStep() {
        if (currentStep < steps.size() - 1) {
            currentStep++;
            showCurrentStep();
        }
    }
    
    private void finishTutorial() {
        int result = JOptionPane.showConfirmDialog(this,
            "Congratulations! You've completed the QualiFrameV2 tutorial.\n\n" +
            "Would you like to start practicing with sample tests?",
            "Tutorial Complete",
            JOptionPane.YES_NO_OPTION);
            
        if (result == JOptionPane.YES_OPTION) {
            // Open sample tests or documentation
            JOptionPane.showMessageDialog(this,
                "Great! Check out the 'examples' folder in your project for sample tests.\n\n" +
                "You can also visit the documentation for more detailed guides.",
                "Next Steps",
                JOptionPane.INFORMATION_MESSAGE);
        }
        
        dispose();
    }
    
    public static void main(String[] args) {
        try {
            // Use a compatible look and feel - use default for Java 17 compatibility
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
        }
        
        SwingUtilities.invokeLater(() -> {
            FrameworkTutorial tutorial = new FrameworkTutorial();
            tutorial.setVisible(true);
        });
    }
    
    /**
     * Tutorial step class
     */
    private static class TutorialStep {
        private String title;
        private String description;
        private String codeExample;
        private String category;
        
        public TutorialStep(String title, String description, String codeExample, String category) {
            this.title = title;
            this.description = description;
            this.codeExample = codeExample;
            this.category = category;
        }
        
        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public String getCodeExample() { return codeExample; }
        public String getCategory() { return category; }
    }
}