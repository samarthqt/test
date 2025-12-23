package org.openqa.selenium.remote.http.netty;

import org.openqa.selenium.remote.http.ClientConfig;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.remote.http.HttpRequest;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.remote.http.WebSocket;

/**
 * Stub NettyClient class to prevent NoClassDefFoundError
 * This class exists solely to allow ServiceLoader to load NettyClient$Factory
 * without throwing an error. The actual implementation is not used because
 * we configure Selenium to use JDK HTTP client via system property.
 */
public class NettyClient implements HttpClient {
    
    /**
     * Stub factory class that ServiceLoader can discover and load
     * This prevents NoClassDefFoundError when ServiceLoader tries to load NettyClient$Factory
     */
    public static class Factory implements HttpClient.Factory {
        @Override
        public HttpClient createClient(ClientConfig config) {
            // This should never be called because we use JDK HTTP client
            // But if it is, throw an exception to indicate Netty is not available
            throw new UnsupportedOperationException(
                "Netty HTTP client is not available. Please use JDK HTTP client by setting " +
                "system property: -Dwebdriver.http.factory=jdk-http-client"
            );
        }
    }
    
    // Stub implementation - should never be called
    @Override
    public HttpResponse execute(HttpRequest req) {
        throw new UnsupportedOperationException("NettyClient stub - should not be called");
    }
    
    @Override
    public WebSocket openSocket(HttpRequest req, WebSocket.Listener listener) {
        throw new UnsupportedOperationException("NettyClient stub - should not be called");
    }
    
    @Override
    public void close() {
        // No-op
    }
}

