/*
 *  © [2022] Qualitest. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.framework.components;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.security.NoSuchAlgorithmException;

/**
 * Secure Credential Manager for handling sensitive information
 * 
 * @author Qualitest
 */
public class SecureCredentialManager {
    
    private static final String KEYSTORE_FILE = "credentials.keystore";
    private static final String KEYSTORE_PASSWORD = "qualiframe_secure_2024";
    private static final String ALIAS_PREFIX = "cred_";
    private static final String ENCRYPTION_ALGORITHM = "AES/GCM/NoPadding";
    private static final int GCM_IV_LENGTH = 12;
    private static final int GCM_TAG_LENGTH = 128;
    
    private static KeyStore keyStore;
    private static SecretKey masterKey;
    private static final Map<String, String> credentialCache = new HashMap<>();
    
    /**
     * Initialize the secure credential manager
     */
    public static void initialize() {
        try {
            loadOrCreateKeyStore();
            generateMasterKey();
        } catch (Exception e) {
            throw new FrameworkException("Failed to initialize SecureCredentialManager", e.getMessage());
        }
    }
    
    /**
     * Store a credential securely
     */
    public static void storeCredential(String key, String value) {
        try {
            String encryptedValue = encryptValue(value);
            keyStore.setKeyEntry(ALIAS_PREFIX + key, masterKey, KEYSTORE_PASSWORD.toCharArray(), null);
            
            // Store encrypted value in properties file
            Properties props = new Properties();
            props.setProperty(key, encryptedValue);
            
            File propsFile = new File("secure_credentials.properties");
            try (FileOutputStream fos = new FileOutputStream(propsFile, true)) {
                props.store(fos, "Secure credentials - encrypted");
            }
            
            // Cache the credential
            credentialCache.put(key, value);
            
        } catch (Exception e) {
            throw new FrameworkException("Failed to store credential", e.getMessage());
        }
    }
    
    /**
     * Retrieve a credential securely
     */
    public static String getCredential(String key) {
        // Check cache first
        if (credentialCache.containsKey(key)) {
            return credentialCache.get(key);
        }
        
        try {
            Properties props = new Properties();
            File propsFile = new File("secure_credentials.properties");
            
            if (propsFile.exists()) {
                try (FileInputStream fis = new FileInputStream(propsFile)) {
                    props.load(fis);
                }
                
                String encryptedValue = props.getProperty(key);
                if (encryptedValue != null) {
                    String decryptedValue = decryptValue(encryptedValue);
                    credentialCache.put(key, decryptedValue);
                    return decryptedValue;
                }
            }
            
            // Fallback to environment variable
            String envValue = System.getenv("QUALIFRAME_" + key.toUpperCase());
            if (envValue != null) {
                credentialCache.put(key, envValue);
                return envValue;
            }
            
            return null;
            
        } catch (Exception e) {
            throw new FrameworkException("Failed to retrieve credential", e.getMessage());
        }
    }
    
    /**
     * Store credentials from properties file securely
     */
    public static void storeCredentialsFromProperties(Properties properties) {
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            if (isSensitiveKey(key) && value != null && !value.isEmpty()) {
                storeCredential(key, value);
            }
        }
    }
    
    /**
     * Check if a key contains sensitive information
     */
    private static boolean isSensitiveKey(String key) {
        String lowerKey = key.toLowerCase();
        return lowerKey.contains("password") || 
               lowerKey.contains("secret") || 
               lowerKey.contains("key") || 
               lowerKey.contains("token") || 
               lowerKey.contains("auth") ||
               lowerKey.contains("credential");
    }
    
    /**
     * Encrypt a value using AES/GCM
     */
    private static String encryptValue(String value) throws Exception {
        byte[] iv = generateIV();
        GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, masterKey, gcmSpec);
        
        byte[] encrypted = cipher.doFinal(value.getBytes(StandardCharsets.UTF_8));
        byte[] combined = new byte[iv.length + encrypted.length];
        System.arraycopy(iv, 0, combined, 0, iv.length);
        System.arraycopy(encrypted, 0, combined, iv.length, encrypted.length);
        
        return Base64.getEncoder().encodeToString(combined);
    }
    
    /**
     * Decrypt a value using AES/GCM
     */
    private static String decryptValue(String encryptedValue) throws Exception {
        byte[] combined = Base64.getDecoder().decode(encryptedValue);
        
        byte[] iv = new byte[GCM_IV_LENGTH];
        byte[] encrypted = new byte[combined.length - GCM_IV_LENGTH];
        
        System.arraycopy(combined, 0, iv, 0, GCM_IV_LENGTH);
        System.arraycopy(combined, GCM_IV_LENGTH, encrypted, 0, encrypted.length);
        
        GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, masterKey, gcmSpec);
        
        byte[] decrypted = cipher.doFinal(encrypted);
        return new String(decrypted, StandardCharsets.UTF_8);
    }
    
    /**
     * Generate a secure IV
     */
    private static byte[] generateIV() {
        byte[] iv = new byte[GCM_IV_LENGTH];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(iv);
        return iv;
    }
    
    /**
     * Load or create the keystore
     */
    private static void loadOrCreateKeyStore() throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        keyStore = KeyStore.getInstance("JCEKS");
        File keystoreFile = new File(KEYSTORE_FILE);
        
        if (keystoreFile.exists()) {
            try (FileInputStream fis = new FileInputStream(keystoreFile)) {
                keyStore.load(fis, KEYSTORE_PASSWORD.toCharArray());
            }
        } else {
            keyStore.load(null, KEYSTORE_PASSWORD.toCharArray());
            try (FileOutputStream fos = new FileOutputStream(keystoreFile)) {
                keyStore.store(fos, KEYSTORE_PASSWORD.toCharArray());
            }
        }
    }
    
    /**
     * Generate or load the master key
     */
    private static void generateMasterKey() throws Exception {
        String masterKeyAlias = "master_key";
        
        if (keyStore.containsAlias(masterKeyAlias)) {
            masterKey = (SecretKey) keyStore.getKey(masterKeyAlias, KEYSTORE_PASSWORD.toCharArray());
        } else {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            masterKey = keyGen.generateKey();
            
            keyStore.setKeyEntry(masterKeyAlias, masterKey, KEYSTORE_PASSWORD.toCharArray(), null);
            
            // Save keystore
            try (FileOutputStream fos = new FileOutputStream(KEYSTORE_FILE)) {
                keyStore.store(fos, KEYSTORE_PASSWORD.toCharArray());
            }
        }
    }
    
    /**
     * Clear credential cache
     */
    public static void clearCache() {
        credentialCache.clear();
    }
    
    /**
     * Get all stored credential keys
     */
    public static String[] getStoredCredentialKeys() {
        try {
            Properties props = new Properties();
            File propsFile = new File("secure_credentials.properties");
            
            if (propsFile.exists()) {
                try (FileInputStream fis = new FileInputStream(propsFile)) {
                    props.load(fis);
                }
                return props.stringPropertyNames().toArray(new String[0]);
            }
        } catch (IOException e) {
            // Ignore and return empty array
        }
        
        return new String[0];
    }
    
    /**
     * Remove a stored credential
     */
    public static void removeCredential(String key) {
        credentialCache.remove(key);
        
        try {
            Properties props = new Properties();
            File propsFile = new File("secure_credentials.properties");
            
            if (propsFile.exists()) {
                try (FileInputStream fis = new FileInputStream(propsFile)) {
                    props.load(fis);
                }
                
                props.remove(key);
                
                try (FileOutputStream fos = new FileOutputStream(propsFile)) {
                    props.store(fos, "Secure credentials - encrypted");
                }
            }
        } catch (IOException e) {
            throw new FrameworkException("Failed to remove credential", e.getMessage());
        }
    }
    
    /**
     * Check if a credential exists
     */
    public static boolean hasCredential(String key) {
        if (credentialCache.containsKey(key)) {
            return true;
        }
        
        try {
            Properties props = new Properties();
            File propsFile = new File("secure_credentials.properties");
            
            if (propsFile.exists()) {
                try (FileInputStream fis = new FileInputStream(propsFile)) {
                    props.load(fis);
                }
                return props.containsKey(key);
            }
        } catch (IOException e) {
            // Ignore and return false
        }
        
        return System.getenv("QUALIFRAME_" + key.toUpperCase()) != null;
    }
} 