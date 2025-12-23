package com.framework.learning;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Feature Access Manager for QualiFrameV2 Framework
 * Controls access to framework features based on user level
 * 
 * @author QualiFrameV2 Team
 * @version 2.0.1
 */
public class FeatureAccessManager {
    
    private static final Logger logger = Logger.getLogger(FeatureAccessManager.class.getName());
    private static FeatureAccessManager instance;
    
    public enum UserLevel {
        BEGINNER(1), INTERMEDIATE(2), ADVANCED(3), EXPERT(4);
        
        private final int level;
        
        UserLevel(int level) {
            this.level = level;
        }
        
        public int getLevel() {
            return level;
        }
    }
    
    private Map<String, UserLevel> featureLevels;
    private UserLevel currentUserLevel = UserLevel.BEGINNER;
    private Map<String, Boolean> unlockedFeatures;
    
    private FeatureAccessManager() {
        initializeFeatureLevels();
        unlockedFeatures = new HashMap<>();
    }
    
    public static FeatureAccessManager getInstance() {
        if (instance == null) {
            instance = new FeatureAccessManager();
        }
        return instance;
    }
    
    /**
     * Initialize feature access levels
     */
    private void initializeFeatureLevels() {
        featureLevels = new HashMap<>();
        
        // Beginner level features
        featureLevels.put("basic.webdriver", UserLevel.BEGINNER);
        featureLevels.put("page.objects", UserLevel.BEGINNER);
        featureLevels.put("simple.testing", UserLevel.BEGINNER);
        featureLevels.put("basic.reporting", UserLevel.BEGINNER);
        
        // Intermediate level features
        featureLevels.put("data.driven", UserLevel.INTERMEDIATE);
        featureLevels.put("parallel.execution", UserLevel.INTERMEDIATE);
        featureLevels.put("cucumber.bdd", UserLevel.INTERMEDIATE);
        featureLevels.put("test.ng", UserLevel.INTERMEDIATE);
        featureLevels.put("excel.integration", UserLevel.INTERMEDIATE);
        
        // Advanced level features
        featureLevels.put("ai.ml.features", UserLevel.ADVANCED);
        featureLevels.put("performance.optimization", UserLevel.ADVANCED);
        featureLevels.put("cloud.testing", UserLevel.ADVANCED);
        featureLevels.put("mobile.testing", UserLevel.ADVANCED);
        featureLevels.put("api.testing", UserLevel.ADVANCED);
        
        // Expert level features
        featureLevels.put("security.testing", UserLevel.EXPERT);
        featureLevels.put("containerization", UserLevel.EXPERT);
        featureLevels.put("advanced.analytics", UserLevel.EXPERT);
        featureLevels.put("custom.extensions", UserLevel.EXPERT);
        featureLevels.put("framework.modification", UserLevel.EXPERT);
        
        logger.info("Feature access levels initialized with " + featureLevels.size() + " features");
    }
    
    /**
     * Check if user can access a specific feature
     * 
     * @param feature The feature name to check
     * @param userLevel The user's level
     * @return true if access is allowed, false otherwise
     */
    public boolean canAccessFeature(String feature, UserLevel userLevel) {
        UserLevel requiredLevel = featureLevels.get(feature);
        
        if (requiredLevel == null) {
            logger.warning("Feature not found: " + feature);
            return false;
        }
        
        boolean hasAccess = userLevel.getLevel() >= requiredLevel.getLevel();
        
        if (hasAccess) {
            logger.info("Access granted to feature: " + feature + " for user level: " + userLevel);
        } else {
            logger.info("Access denied to feature: " + feature + " for user level: " + userLevel + 
                ". Required level: " + requiredLevel);
        }
        
        return hasAccess;
    }
    
    /**
     * Check if current user can access a feature
     * 
     * @param feature The feature name to check
     * @return true if access is allowed, false otherwise
     */
    public boolean canAccessFeature(String feature) {
        return canAccessFeature(feature, currentUserLevel);
    }
    
    /**
     * Set current user level
     * 
     * @param userLevel The user level to set
     */
    public void setCurrentUserLevel(UserLevel userLevel) {
        this.currentUserLevel = userLevel;
        logger.info("Current user level set to: " + userLevel);
        
        // Update unlocked features
        updateUnlockedFeatures();
    }
    
    /**
     * Get current user level
     * 
     * @return Current user level
     */
    public UserLevel getCurrentUserLevel() {
        return currentUserLevel;
    }
    
    /**
     * Update unlocked features based on current user level
     */
    private void updateUnlockedFeatures() {
        unlockedFeatures.clear();
        
        for (Map.Entry<String, UserLevel> entry : featureLevels.entrySet()) {
            String feature = entry.getKey();
            UserLevel requiredLevel = entry.getValue();
            
            boolean unlocked = currentUserLevel.getLevel() >= requiredLevel.getLevel();
            unlockedFeatures.put(feature, unlocked);
        }
        
        logger.info("Updated unlocked features for user level: " + currentUserLevel);
    }
    
    /**
     * Get all features accessible to current user level
     * 
     * @return Map of feature names to access status
     */
    public Map<String, Boolean> getAccessibleFeatures() {
        return new HashMap<>(unlockedFeatures);
    }
    
    /**
     * Get features that can be unlocked by upgrading user level
     * 
     * @return Map of feature names to required user level
     */
    public Map<String, UserLevel> getLockedFeatures() {
        Map<String, UserLevel> lockedFeatures = new HashMap<>();
        
        for (Map.Entry<String, UserLevel> entry : featureLevels.entrySet()) {
            String feature = entry.getKey();
            UserLevel requiredLevel = entry.getValue();
            
            if (currentUserLevel.getLevel() < requiredLevel.getLevel()) {
                lockedFeatures.put(feature, requiredLevel);
            }
        }
        
        return lockedFeatures;
    }
    
    /**
     * Get features available at a specific user level
     * 
     * @param userLevel The user level to check
     * @return Array of feature names available at that level
     */
    public String[] getFeaturesAtLevel(UserLevel userLevel) {
        return featureLevels.entrySet().stream()
            .filter(entry -> entry.getValue() == userLevel)
            .map(Map.Entry::getKey)
            .toArray(String[]::new);
    }
    
    /**
     * Get feature description and requirements
     * 
     * @param feature The feature name
     * @return Feature information string
     */
    public String getFeatureInfo(String feature) {
        UserLevel requiredLevel = featureLevels.get(feature);
        
        if (requiredLevel == null) {
            return "Feature not found: " + feature;
        }
        
        boolean currentlyAccessible = canAccessFeature(feature);
        String status = currentlyAccessible ? "UNLOCKED" : "LOCKED";
        
        StringBuilder info = new StringBuilder();
        info.append("Feature: ").append(feature).append("\n");
        info.append("Status: ").append(status).append("\n");
        info.append("Required Level: ").append(requiredLevel).append("\n");
        info.append("Current Level: ").append(currentUserLevel).append("\n");
        
        if (!currentlyAccessible) {
            info.append("Upgrade Required: ").append(requiredLevel.getLevel() - currentUserLevel.getLevel()).append(" level(s)");
        }
        
        return info.toString();
    }
    
    /**
     * Get upgrade path for a specific feature
     * 
     * @param feature The feature name
     * @return Upgrade path information
     */
    public String getUpgradePath(String feature) {
        UserLevel requiredLevel = featureLevels.get(feature);
        
        if (requiredLevel == null) {
            return "Feature not found: " + feature;
        }
        
        if (canAccessFeature(feature)) {
            return "Feature is already accessible at your current level: " + currentUserLevel;
        }
        
        int levelsNeeded = requiredLevel.getLevel() - currentUserLevel.getLevel();
        
        StringBuilder path = new StringBuilder();
        path.append("To unlock '").append(feature).append("', you need to upgrade ").append(levelsNeeded).append(" level(s).\n\n");
        path.append("Current Level: ").append(currentUserLevel).append("\n");
        path.append("Required Level: ").append(requiredLevel).append("\n\n");
        
        path.append("Upgrade Path:\n");
        UserLevel current = currentUserLevel;
        for (int i = 0; i < levelsNeeded; i++) {
            UserLevel next = getNextLevel(current);
            path.append("  ").append(current).append(" → ").append(next).append("\n");
            current = next;
        }
        
        return path.toString();
    }
    
    /**
     * Get next user level
     * 
     * @param currentLevel Current user level
     * @return Next user level or null if already at maximum
     */
    private UserLevel getNextLevel(UserLevel currentLevel) {
        UserLevel[] levels = UserLevel.values();
        for (int i = 0; i < levels.length - 1; i++) {
            if (levels[i] == currentLevel) {
                return levels[i + 1];
            }
        }
        return null;
    }
    
    /**
     * Check if user can upgrade to next level
     * 
     * @return true if upgrade is possible, false otherwise
     */
    public boolean canUpgrade() {
        return currentUserLevel != UserLevel.EXPERT;
    }
    
    /**
     * Upgrade user to next level
     * 
     * @return true if upgrade successful, false otherwise
     */
    public boolean upgradeUserLevel() {
        if (!canUpgrade()) {
            logger.warning("User is already at maximum level: " + currentUserLevel);
            return false;
        }
        
        UserLevel nextLevel = getNextLevel(currentUserLevel);
        if (nextLevel != null) {
            setCurrentUserLevel(nextLevel);
            logger.info("User upgraded from " + currentUserLevel + " to " + nextLevel);
            return true;
        }
        
        return false;
    }
    
    /**
     * Get feature access summary
     * 
     * @return Summary of feature access
     */
    public String getFeatureAccessSummary() {
        Map<String, Boolean> accessible = getAccessibleFeatures();
        Map<String, UserLevel> locked = getLockedFeatures();
        
        int totalFeatures = featureLevels.size();
        int unlockedCount = (int) accessible.values().stream().filter(Boolean::booleanValue).count();
        int lockedCount = locked.size();
        
        StringBuilder summary = new StringBuilder();
        summary.append("=== Feature Access Summary ===\n");
        summary.append("Current User Level: ").append(currentUserLevel).append("\n");
        summary.append("Total Features: ").append(totalFeatures).append("\n");
        summary.append("Unlocked Features: ").append(unlockedCount).append("\n");
        summary.append("Locked Features: ").append(lockedCount).append("\n");
        summary.append("Access Percentage: ").append(String.format("%.1f", (double) unlockedCount / totalFeatures * 100)).append("%\n\n");
        
        if (lockedCount > 0) {
            summary.append("Locked Features:\n");
            for (Map.Entry<String, UserLevel> entry : locked.entrySet()) {
                summary.append("  • ").append(entry.getKey()).append(" (Level ").append(entry.getValue()).append(")\n");
            }
        }
        
        return summary.toString();
    }
    
    /**
     * Reset user level to beginner
     */
    public void resetToBeginner() {
        setCurrentUserLevel(UserLevel.BEGINNER);
        logger.info("User level reset to BEGINNER");
    }
}