package com.framework.resources;

import com.framework.features.FeatureToggle;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;

/**
 * Resource Manager for QualiFrameV2 Framework
 * Monitors system resources and optimizes framework performance
 * 
 * @author QualiFrameV2 Team
 * @version 2.0.1
 */
public class ResourceManager {
    
    private static final Logger logger = Logger.getLogger(ResourceManager.class.getName());
    private static ResourceManager instance;
    
    private static final int MIN_MEMORY_MB = 512;
    private static final int MIN_CPU_CORES = 2;
    private static final int MAX_MEMORY_USAGE_PERCENT = 80;
    private static final int MAX_CPU_USAGE_PERCENT = 80;
    
    private MemoryMXBean memoryBean;
    private ThreadMXBean threadBean;
    private ScheduledExecutorService monitorExecutor;
    private boolean monitoring = false;
    
    private ResourceStats currentStats;
    private ResourceStats peakStats;
    
    private ResourceManager() {
        memoryBean = ManagementFactory.getMemoryMXBean();
        threadBean = ManagementFactory.getThreadMXBean();
        currentStats = new ResourceStats();
        peakStats = new ResourceStats();
    }
    
    public static ResourceManager getInstance() {
        if (instance == null) {
            instance = new ResourceManager();
        }
        return instance;
    }
    
    /**
     * Check if system has minimum required resources
     * 
     * @return true if minimum resources available, false otherwise
     */
    public boolean hasMinimumResources() {
        long maxMemory = memoryBean.getHeapMemoryUsage().getMax() / (1024 * 1024); // MB
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        
        boolean hasMemory = maxMemory >= MIN_MEMORY_MB;
        boolean hasCPU = availableProcessors >= MIN_CPU_CORES;
        
        logger.info("Resource check - Memory: " + maxMemory + "MB (Required: " + MIN_MEMORY_MB + "MB), " +
                   "CPU Cores: " + availableProcessors + " (Required: " + MIN_CPU_CORES + ")");
        
        return hasMemory && hasCPU;
    }
    
    /**
     * Get current resource statistics
     * 
     * @return Current resource statistics
     */
    public ResourceStats getCurrentStats() {
        updateCurrentStats();
        return new ResourceStats(currentStats);
    }
    
    /**
     * Get peak resource statistics
     * 
     * @return Peak resource statistics
     */
    public ResourceStats getPeakStats() {
        return new ResourceStats(peakStats);
    }
    
    /**
     * Update current resource statistics
     */
    private void updateCurrentStats() {
        // Memory statistics
        long usedMemory = memoryBean.getHeapMemoryUsage().getUsed();
        long maxMemory = memoryBean.getHeapMemoryUsage().getMax();
        long freeMemory = maxMemory - usedMemory;
        
        currentStats.setUsedMemoryMB(usedMemory / (1024 * 1024));
        currentStats.setMaxMemoryMB(maxMemory / (1024 * 1024));
        currentStats.setFreeMemoryMB(freeMemory / (1024 * 1024));
        currentStats.setMemoryUsagePercent((double) usedMemory / maxMemory * 100);
        
        // Thread statistics
        int threadCount = threadBean.getThreadCount();
        int peakThreadCount = threadBean.getPeakThreadCount();
        int daemonThreadCount = threadBean.getDaemonThreadCount();
        
        currentStats.setThreadCount(threadCount);
        currentStats.setPeakThreadCount(peakThreadCount);
        currentStats.setDaemonThreadCount(daemonThreadCount);
        
        // CPU statistics
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        currentStats.setAvailableProcessors(availableProcessors);
        
        // Update peak stats
        updatePeakStats();
    }
    
    /**
     * Update peak resource statistics
     */
    private void updatePeakStats() {
        if (currentStats.getUsedMemoryMB() > peakStats.getUsedMemoryMB()) {
            peakStats.setUsedMemoryMB(currentStats.getUsedMemoryMB());
        }
        
        if (currentStats.getThreadCount() > peakStats.getThreadCount()) {
            peakStats.setThreadCount(currentStats.getThreadCount());
        }
        
        if (currentStats.getMemoryUsagePercent() > peakStats.getMemoryUsagePercent()) {
            peakStats.setMemoryUsagePercent(currentStats.getMemoryUsagePercent());
        }
    }
    
    /**
     * Start resource monitoring
     */
    public void startMonitoring() {
        if (monitoring) {
            logger.warning("Resource monitoring already started");
            return;
        }
        
        monitorExecutor = Executors.newSingleThreadScheduledExecutor();
        monitorExecutor.scheduleAtFixedRate(this::monitorResources, 0, 5, TimeUnit.SECONDS);
        monitoring = true;
        
        logger.info("Resource monitoring started");
    }
    
    /**
     * Stop resource monitoring
     */
    public void stopMonitoring() {
        if (!monitoring) {
            logger.warning("Resource monitoring not started");
            return;
        }
        
        if (monitorExecutor != null) {
            monitorExecutor.shutdown();
            try {
                if (!monitorExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                    monitorExecutor.shutdownNow();
                }
            } catch (InterruptedException e) {
                monitorExecutor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
        
        monitoring = false;
        logger.info("Resource monitoring stopped");
    }
    
    /**
     * Monitor resources and take action if needed
     */
    private void monitorResources() {
        try {
            updateCurrentStats();
            
            // Check memory usage
            if (currentStats.getMemoryUsagePercent() > MAX_MEMORY_USAGE_PERCENT) {
                handleHighMemoryUsage();
            }
            
            // Check thread count
            if (currentStats.getThreadCount() > currentStats.getAvailableProcessors() * 2) {
                handleHighThreadCount();
            }
            
            // Log resource status
            logger.fine("Resource status - Memory: " + 
                       String.format("%.1f", currentStats.getMemoryUsagePercent()) + "%, " +
                       "Threads: " + currentStats.getThreadCount());
            
        } catch (Exception e) {
            logger.warning("Error monitoring resources: " + e.getMessage());
        }
    }
    
    /**
     * Handle high memory usage
     */
    private void handleHighMemoryUsage() {
        logger.warning("High memory usage detected: " + 
                      String.format("%.1f", currentStats.getMemoryUsagePercent()) + "%");
        
        // Suggest garbage collection
        System.gc();
        
        // Disable non-critical features if memory usage is very high
        if (currentStats.getMemoryUsagePercent() > 90) {
            logger.warning("Critical memory usage - disabling non-critical features");
            disableNonCriticalFeatures();
        }
    }
    
    /**
     * Handle high thread count
     */
    private void handleHighThreadCount() {
        logger.warning("High thread count detected: " + currentStats.getThreadCount());
        
        // Suggest thread optimization
        optimizeThreadUsage();
    }
    
    /**
     * Disable non-critical features to conserve memory
     */
    private void disableNonCriticalFeatures() {
        FeatureToggle featureToggle = FeatureToggle.getInstance();
        
        // Disable features that consume significant memory
        featureToggle.disableFeature("ai.ml.features");
        featureToggle.disableFeature("advanced.analytics");
        featureToggle.disableFeature("performance.monitoring");
        
        logger.info("Non-critical features disabled to conserve memory");
    }
    
    /**
     * Optimize thread usage
     */
    private void optimizeThreadUsage() {
        // This would implement thread optimization strategies
        logger.info("Thread optimization suggested");
    }
    
    /**
     * Optimize framework for available resources
     */
    public void optimizeForResources() {
        if (!hasMinimumResources()) {
            logger.warning("System does not meet minimum resource requirements");
            
            // Enable basic mode
            FeatureToggle featureToggle = FeatureToggle.getInstance();
            featureToggle.enableFeaturesByPriority(FeatureToggle.FeaturePriority.CRITICAL);
            featureToggle.disableFeaturesByPriority(FeatureToggle.FeaturePriority.LOW);
            
            logger.info("Framework optimized for limited resources - basic mode enabled");
        } else {
            logger.info("System meets resource requirements - all features available");
        }
    }
    
    /**
     * Get resource recommendations
     * 
     * @return Resource recommendations string
     */
    public String getResourceRecommendations() {
        StringBuilder recommendations = new StringBuilder();
        recommendations.append("=== Resource Recommendations ===\n\n");
        
        // Memory recommendations
        if (currentStats.getMemoryUsagePercent() > 80) {
            recommendations.append("⚠️  Memory Usage High (").append(String.format("%.1f", currentStats.getMemoryUsagePercent())).append("%)\n");
            recommendations.append("   • Consider increasing heap memory\n");
            recommendations.append("   • Disable non-critical features\n");
            recommendations.append("   • Monitor for memory leaks\n\n");
        }
        
        // Thread recommendations
        if (currentStats.getThreadCount() > currentStats.getAvailableProcessors() * 2) {
            recommendations.append("⚠️  Thread Count High (").append(currentStats.getThreadCount()).append(")\n");
            recommendations.append("   • Reduce parallel execution threads\n");
            recommendations.append("   • Optimize thread pool usage\n");
            recommendations.append("   • Monitor thread lifecycle\n\n");
        }
        
        // General recommendations
        recommendations.append("📊 Current Resource Status:\n");
        recommendations.append("   • Memory: ").append(String.format("%.1f", currentStats.getMemoryUsagePercent())).append("% used\n");
        recommendations.append("   • Threads: ").append(currentStats.getThreadCount()).append(" active\n");
        recommendations.append("   • CPU Cores: ").append(currentStats.getAvailableProcessors()).append(" available\n");
        
        return recommendations.toString();
    }
    
    /**
     * Check if monitoring is active
     * 
     * @return true if monitoring is active, false otherwise
     */
    public boolean isMonitoring() {
        return monitoring;
    }
    
    /**
     * Resource statistics class
     */
    public static class ResourceStats {
        private long usedMemoryMB;
        private long maxMemoryMB;
        private long freeMemoryMB;
        private double memoryUsagePercent;
        private int threadCount;
        private int peakThreadCount;
        private int daemonThreadCount;
        private int availableProcessors;
        
        public ResourceStats() {}
        
        public ResourceStats(ResourceStats other) {
            this.usedMemoryMB = other.usedMemoryMB;
            this.maxMemoryMB = other.maxMemoryMB;
            this.freeMemoryMB = other.freeMemoryMB;
            this.memoryUsagePercent = other.memoryUsagePercent;
            this.threadCount = other.threadCount;
            this.peakThreadCount = other.peakThreadCount;
            this.daemonThreadCount = other.daemonThreadCount;
            this.availableProcessors = other.availableProcessors;
        }
        
        // Getters and setters
        public long getUsedMemoryMB() { return usedMemoryMB; }
        public void setUsedMemoryMB(long usedMemoryMB) { this.usedMemoryMB = usedMemoryMB; }
        
        public long getMaxMemoryMB() { return maxMemoryMB; }
        public void setMaxMemoryMB(long maxMemoryMB) { this.maxMemoryMB = maxMemoryMB; }
        
        public long getFreeMemoryMB() { return freeMemoryMB; }
        public void setFreeMemoryMB(long freeMemoryMB) { this.freeMemoryMB = freeMemoryMB; }
        
        public double getMemoryUsagePercent() { return memoryUsagePercent; }
        public void setMemoryUsagePercent(double memoryUsagePercent) { this.memoryUsagePercent = memoryUsagePercent; }
        
        public int getThreadCount() { return threadCount; }
        public void setThreadCount(int threadCount) { this.threadCount = threadCount; }
        
        public int getPeakThreadCount() { return peakThreadCount; }
        public void setPeakThreadCount(int peakThreadCount) { this.peakThreadCount = peakThreadCount; }
        
        public int getDaemonThreadCount() { return daemonThreadCount; }
        public void setDaemonThreadCount(int daemonThreadCount) { this.daemonThreadCount = daemonThreadCount; }
        
        public int getAvailableProcessors() { return availableProcessors; }
        public void setAvailableProcessors(int availableProcessors) { this.availableProcessors = availableProcessors; }
        
        @Override
        public String toString() {
            return String.format("ResourceStats{Memory: %.1f%% (%d/%d MB), Threads: %d/%d, CPU: %d}",
                memoryUsagePercent, usedMemoryMB, maxMemoryMB, threadCount, availableProcessors, availableProcessors);
        }
    }
}