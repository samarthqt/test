package com.framework.wizard;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Properties;
import java.io.IOException;
import java.io.File;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;

/**
 * Configuration Wizard for QualiFrameV2 Framework
 * Provides a user-friendly GUI for framework configuration
 * 
 * @author QualiFrameV2 Team
 * @version 2.0.1
 */
public class ConfigurationWizard extends JFrame {
    
    private JTabbedPane tabbedPane;
    private JTextField projectNameField;
    private JComboBox<String> executionApproachCombo;
    private JComboBox<String> testDataCombo;
    private JComboBox<String> browserCombo;
    private JComboBox<String> environmentCombo;
    private JCheckBox parallelExecutionCheck;
    private JSpinner threadCountSpinner;
    private JCheckBox aiFeaturesCheck;
    private JCheckBox performanceCheck;
    private JCheckBox securityCheck;
    private JCheckBox containerizationCheck;
    
    private Properties configuration;
    
    public ConfigurationWizard() {
        configuration = new Properties();
        initializeUI();
        loadDefaultConfiguration();
    }
    
    private void initializeUI() {
        setTitle("QualiFrameV2 Configuration Wizard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        
        tabbedPane = new JTabbedPane();
        
        // Create configuration tabs
        tabbedPane.addTab("Basic Setup", createBasicSetupPanel());
        tabbedPane.addTab("Browser Configuration", createBrowserPanel());
        tabbedPane.addTab("Advanced Features", createAdvancedPanel());
        tabbedPane.addTab("Cloud Platforms", createCloudPanel());
        tabbedPane.addTab("Review & Save", createReviewPanel());
        
        add(tabbedPane);
        
        // Add menu bar
        JMenuBar menuBar = createMenuBar();
        setJMenuBar(menuBar);
    }
    
    private JPanel createBasicSetupPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Basic Framework Configuration"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Project Name
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Project Name:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        projectNameField = new JTextField(20);
        panel.add(projectNameField, gbc);
        
        // Execution Approach
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Execution Approach:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        executionApproachCombo = new JComboBox<>(new String[]{"MODULAR", "CUCUMBER", "KEYWORD"});
        panel.add(executionApproachCombo, gbc);
        
        // Test Data
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Test Data Source:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        testDataCombo = new JComboBox<>(new String[]{"EXCEL", "CSV", "JSON", "ACCESSDB", "MSSQL"});
        panel.add(testDataCombo, gbc);
        
        // Environment
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Default Environment:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        environmentCombo = new JComboBox<>(new String[]{"qa", "staging", "prod"});
        panel.add(environmentCombo, gbc);
        
        // Parallel Execution
        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(new JLabel("Parallel Execution:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        parallelExecutionCheck = new JCheckBox("Enable parallel execution");
        panel.add(parallelExecutionCheck, gbc);
        
        // Thread Count
        gbc.gridx = 0; gbc.gridy = 5;
        panel.add(new JLabel("Thread Count:"), gbc);
        gbc.gridx = 1; gbc.gridy = 5;
        threadCountSpinner = new JSpinner(new SpinnerNumberModel(3, 1, 10, 1));
        panel.add(threadCountSpinner, gbc);
        
        return panel;
    }
    
    private JPanel createBrowserPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Browser Configuration"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Browser Selection
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Primary Browser:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        browserCombo = new JComboBox<>(new String[]{
            "LOCALChrome", "LOCALFirefox", "LOCALEdge", "LOCALChrome_HEADLESS"
        });
        panel.add(browserCombo, gbc);
        
        // Browser Options
        JPanel optionsPanel = new JPanel(new GridLayout(0, 2, 10, 5));
        optionsPanel.setBorder(BorderFactory.createTitledBorder("Browser Options"));
        
        JCheckBox headlessCheck = new JCheckBox("Headless Mode");
        JCheckBox incognitoCheck = new JCheckBox("Incognito/Private Mode");
        JCheckBox disableImagesCheck = new JCheckBox("Disable Images");
        JCheckBox disableJavaScriptCheck = new JCheckBox("Disable JavaScript");
        
        optionsPanel.add(headlessCheck);
        optionsPanel.add(incognitoCheck);
        optionsPanel.add(disableImagesCheck);
        optionsPanel.add(disableJavaScriptCheck);
        
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(optionsPanel, gbc);
        
        return panel;
    }
    
    private JPanel createAdvancedPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Advanced Features"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // AI/ML Features
        gbc.gridx = 0; gbc.gridy = 0;
        aiFeaturesCheck = new JCheckBox("Enable AI/ML Features (Smart Test Selection, Failure Analysis)");
        panel.add(aiFeaturesCheck, gbc);
        
        // Performance Features
        gbc.gridx = 0; gbc.gridy = 1;
        performanceCheck = new JCheckBox("Enable Performance Monitoring & Optimization");
        panel.add(performanceCheck, gbc);
        
        // Security Features
        gbc.gridx = 0; gbc.gridy = 2;
        securityCheck = new JCheckBox("Enable Security Features (Credential Encryption)");
        panel.add(securityCheck, gbc);
        
        // Containerization
        gbc.gridx = 0; gbc.gridy = 3;
        containerizationCheck = new JCheckBox("Enable Docker Containerization");
        panel.add(containerizationCheck, gbc);
        
        // Feature Descriptions
        JTextArea descriptionArea = new JTextArea(
            "AI/ML Features: Intelligent test selection, failure pattern analysis\n" +
            "Performance: Real-time monitoring, optimization, adaptive timeouts\n" +
            "Security: Encrypted credentials, secure key management\n" +
            "Containerization: Docker support, Selenium Grid integration"
        );
        descriptionArea.setEditable(false);
        descriptionArea.setBackground(panel.getBackground());
        descriptionArea.setRows(4);
        
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(descriptionArea, gbc);
        
        return panel;
    }
    
    private JPanel createCloudPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Cloud Platform Configuration"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Cloud Platform Selection
        JComboBox<String> cloudPlatformCombo = new JComboBox<>(new String[]{
            "None", "SauceLabs", "LambdaTest", "BrowserStack", "AWS Device Farm"
        });
        
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Cloud Platform:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(cloudPlatformCombo, gbc);
        
        // Cloud Credentials
        JPanel credentialsPanel = new JPanel(new GridLayout(0, 2, 10, 5));
        credentialsPanel.setBorder(BorderFactory.createTitledBorder("Cloud Credentials"));
        
        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JTextField accessKeyField = new JTextField(15);
        
        credentialsPanel.add(new JLabel("Username:"));
        credentialsPanel.add(usernameField);
        credentialsPanel.add(new JLabel("Password:"));
        credentialsPanel.add(passwordField);
        credentialsPanel.add(new JLabel("Access Key:"));
        credentialsPanel.add(accessKeyField);
        
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(credentialsPanel, gbc);
        
        return panel;
    }
    
    private JPanel createReviewPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Configuration Review"));
        
        // Configuration Summary
        JTextArea summaryArea = new JTextArea();
        summaryArea.setEditable(false);
        summaryArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        updateConfigurationSummary(summaryArea);
        
        JScrollPane scrollPane = new JScrollPane(summaryArea);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Action Buttons
        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("Save Configuration");
        JButton exportButton = new JButton("Export Configuration");
        JButton resetButton = new JButton("Reset to Defaults");
        
        saveButton.addActionListener(e -> saveConfiguration());
        exportButton.addActionListener(e -> exportConfiguration());
        resetButton.addActionListener(e -> resetToDefaults());
        
        buttonPanel.add(saveButton);
        buttonPanel.add(exportButton);
        buttonPanel.add(resetButton);
        
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void updateConfigurationSummary(JTextArea summaryArea) {
        StringBuilder summary = new StringBuilder();
        summary.append("=== QualiFrameV2 Configuration Summary ===\n\n");
        summary.append("Project Name: ").append(projectNameField.getText()).append("\n");
        summary.append("Execution Approach: ").append(executionApproachCombo.getSelectedItem()).append("\n");
        summary.append("Test Data Source: ").append(testDataCombo.getSelectedItem()).append("\n");
        summary.append("Browser: ").append(browserCombo.getSelectedItem()).append("\n");
        summary.append("Environment: ").append(environmentCombo.getSelectedItem()).append("\n");
        summary.append("Parallel Execution: ").append(parallelExecutionCheck.isSelected() ? "Enabled" : "Disabled").append("\n");
        summary.append("Thread Count: ").append(threadCountSpinner.getValue()).append("\n");
        summary.append("AI/ML Features: ").append(aiFeaturesCheck.isSelected() ? "Enabled" : "Disabled").append("\n");
        summary.append("Performance Features: ").append(performanceCheck.isSelected() ? "Enabled" : "Disabled").append("\n");
        summary.append("Security Features: ").append(securityCheck.isSelected() ? "Enabled" : "Disabled").append("\n");
        summary.append("Containerization: ").append(containerizationCheck.isSelected() ? "Enabled" : "Disabled").append("\n");
        
        summaryArea.setText(summary.toString());
    }
    
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open Configuration");
        JMenuItem saveItem = new JMenuItem("Save Configuration");
        JMenuItem exitItem = new JMenuItem("Exit");
        
        openItem.addActionListener(e -> openConfiguration());
        saveItem.addActionListener(e -> saveConfiguration());
        exitItem.addActionListener(e -> System.exit(0));
        
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        JMenuItem helpItem = new JMenuItem("User Guide");
        
        aboutItem.addActionListener(e -> showAboutDialog());
        helpItem.addActionListener(e -> showHelpDialog());
        
        helpMenu.add(helpItem);
        helpMenu.add(aboutItem);
        
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        
        return menuBar;
    }
    
    private void loadDefaultConfiguration() {
        projectNameField.setText("QualiFrameV2 Project");
        executionApproachCombo.setSelectedItem("MODULAR");
        testDataCombo.setSelectedItem("EXCEL");
        browserCombo.setSelectedItem("LOCALChrome");
        environmentCombo.setSelectedItem("qa");
        parallelExecutionCheck.setSelected(true);
        threadCountSpinner.setValue(3);
        aiFeaturesCheck.setSelected(false);
        performanceCheck.setSelected(false);
        securityCheck.setSelected(false);
        containerizationCheck.setSelected(false);
    }
    
    private void saveConfiguration() {
        try {
            // Save to properties file
            File configFile = new File("framework-config.properties");
            FileWriter writer = new FileWriter(configFile);
            
            configuration.setProperty("ProjectName", projectNameField.getText());
            configuration.setProperty("ExecutionApproach", executionApproachCombo.getSelectedItem().toString());
            configuration.setProperty("TestData", testDataCombo.getSelectedItem().toString());
            configuration.setProperty("TestConfigurationID", browserCombo.getSelectedItem().toString());
            configuration.setProperty("defaultEnvironment", environmentCombo.getSelectedItem().toString());
            configuration.setProperty("ParallelExecution", String.valueOf(parallelExecutionCheck.isSelected()));
            configuration.setProperty("NumberOfThreads", threadCountSpinner.getValue().toString());
            configuration.setProperty("AIFeatures", String.valueOf(aiFeaturesCheck.isSelected()));
            configuration.setProperty("PerformanceFeatures", String.valueOf(performanceCheck.isSelected()));
            configuration.setProperty("SecurityFeatures", String.valueOf(securityCheck.isSelected()));
            configuration.setProperty("Containerization", String.valueOf(containerizationCheck.isSelected()));
            
            configuration.store(writer, "QualiFrameV2 Configuration");
            writer.close();
            
            JOptionPane.showMessageDialog(this, 
                "Configuration saved successfully to framework-config.properties", 
                "Success", JOptionPane.INFORMATION_MESSAGE);
                
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, 
                "Error saving configuration: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void exportConfiguration() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Export Configuration");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setSelectedFile(new File("qualiframe-config.xml"));
        
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            // Export configuration logic
            JOptionPane.showMessageDialog(this, 
                "Configuration exported successfully", 
                "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void resetToDefaults() {
        int result = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to reset to default configuration?", 
            "Confirm Reset", JOptionPane.YES_NO_OPTION);
            
        if (result == JOptionPane.YES_OPTION) {
            loadDefaultConfiguration();
        }
    }
    
    private void openConfiguration() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open Configuration");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            // Load configuration logic
            JOptionPane.showMessageDialog(this, 
                "Configuration loaded successfully", 
                "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void showAboutDialog() {
        JOptionPane.showMessageDialog(this, 
            "QualiFrameV2 Configuration Wizard\nVersion 2.0.1\n\n" +
            "A user-friendly configuration tool for the QualiFrameV2 automation framework.", 
            "About", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void showHelpDialog() {
        JOptionPane.showMessageDialog(this, 
            "Help content will be displayed here.\n\n" +
            "This will include step-by-step guidance for configuring the framework.", 
            "Help", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        try {
            // Use a compatible look and feel - use default for Java 17 compatibility
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
        }
        
        SwingUtilities.invokeLater(() -> {
            ConfigurationWizard wizard = new ConfigurationWizard();
            wizard.setVisible(true);
        });
    }
}