# Alternative Healenium Setup Guide

## Issue: Docker Image Authorization Error

If you're encountering "You are not authorized to view this page" when trying to pull Healenium Docker images, this guide provides alternative setup methods.

## Solution 1: Build from Source (Recommended)

This is the most reliable method and doesn't require Docker Hub access.

### Prerequisites
- Java 11 or higher
- Maven 3.6+

### Steps

1. **Clone the Healenium Backend Repository**:
```bash
git clone https://github.com/healenium/healenium-backend.git
cd healenium-backend
```

2. **Build the Project**:
```bash
mvn clean install -DskipTests
```

3. **Run the Backend Service**:
```bash
# Option A: Using Maven Spring Boot plugin
mvn spring-boot:run

# Option B: Using the JAR file
java -jar target/healenium-backend-*.jar
```

4. **Verify Backend is Running**:
```bash
curl http://localhost:7878/actuator/health
```

You should see a response indicating the service is healthy.

## Solution 2: Download Pre-built JAR

If you prefer not to build from source:

1. **Visit Healenium Releases**:
   - Go to: https://github.com/healenium/healenium-backend/releases
   - Download the latest `healenium-backend-*.jar` file

2. **Run the JAR**:
```bash
java -jar healenium-backend-*.jar
```

## Solution 3: Use Docker Compose (If Images Available)

If Docker images become available or you have access:

1. **Create docker-compose.yml**:
```yaml
version: '3.8'

services:
  healenium-backend:
    build:
      context: .
      dockerfile: Dockerfile
    ports:
      - "7878:7878"
    environment:
      - SPRING_DATASOURCE_URL=jdbc:h2:mem:healenium
      - SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.h2.Driver
      - SPRING_DATASOURCE_USERNAME=sa
      - SPRING_DATASOURCE_PASSWORD=
    volumes:
      - ./logs:/app/logs

  # Optional: PostgreSQL for production
  postgres:
    image: postgres:13
    environment:
      - POSTGRES_DB=healenium
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=postgres
    ports:
      - "5432:5432"
    volumes:
      - postgres-data:/var/lib/postgresql/data

volumes:
  postgres-data:
```

2. **Build and Run**:
```bash
docker-compose up -d
```

## Solution 4: Run Without Backend (Limited Functionality)

Healenium can work in a limited mode without the backend, but self-healing features will be disabled. This is not recommended for production use.

## Configuration After Setup

Once the backend is running, update your framework configuration:

### 1. Update Global Settings.properties:
```properties
HealeniumEnabled=true
HealeniumBackendUrl=http://localhost:7878
```

### 2. Update healenium.properties:
```properties
hlm.server.url=http://localhost:7878
heal-enabled=true
recovery-tries=1
score-cap=0.6
```

## Troubleshooting

### Issue: Backend won't start

**Check Java Version**:
```bash
java -version
# Should be Java 11 or higher
```

**Check Port Availability**:
```bash
# On Linux/Mac
lsof -i :7878

# On Windows
netstat -ano | findstr :7878
```

### Issue: Connection refused

**Verify Backend is Running**:
```bash
curl http://localhost:7878/actuator/health
```

**Check Backend Logs**:
```bash
# If running from source
tail -f logs/application.log

# If using JAR
# Check console output
```

### Issue: Database Connection Errors

**For H2 (Default)**:
- H2 is embedded, no configuration needed
- Data is stored in memory (lost on restart)

**For PostgreSQL**:
- Ensure PostgreSQL is running
- Check connection string in application.properties
- Verify database exists: `psql -l | grep healenium`

## Running Backend as a Service

### Linux (systemd)

Create `/etc/systemd/system/healenium-backend.service`:

```ini
[Unit]
Description=Healenium Backend Service
After=network.target

[Service]
Type=simple
User=your-user
WorkingDirectory=/path/to/healenium-backend
ExecStart=/usr/bin/java -jar /path/to/healenium-backend.jar
Restart=always
RestartSec=10

[Install]
WantedBy=multi-user.target
```

Enable and start:
```bash
sudo systemctl enable healenium-backend
sudo systemctl start healenium-backend
sudo systemctl status healenium-backend
```

### Windows (Service)

Use NSSM (Non-Sucking Service Manager) or similar tool to run as Windows service.

### macOS (LaunchAgent)

Create `~/Library/LaunchAgents/com.healenium.backend.plist`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
<dict>
    <key>Label</key>
    <string>com.healenium.backend</string>
    <key>ProgramArguments</key>
    <array>
        <string>/usr/bin/java</string>
        <string>-jar</string>
        <string>/path/to/healenium-backend.jar</string>
    </array>
    <key>RunAtLoad</key>
    <true/>
    <key>KeepAlive</key>
    <true/>
</dict>
</plist>
```

Load the service:
```bash
launchctl load ~/Library/LaunchAgents/com.healenium.backend.plist
```

## Verification

After setup, verify everything works:

1. **Check Backend Health**:
```bash
curl http://localhost:7878/actuator/health
```

2. **Run a Test**:
```bash
# Enable Healenium in properties
# Run a simple test that uses WebDriver
# Check logs for Healenium activity
```

3. **Check Reports**:
Visit: http://localhost:7878/report

## Additional Resources

- **Healenium Backend GitHub**: https://github.com/healenium/healenium-backend
- **Healenium Documentation**: https://healenium.io/docs
- **Issues/Support**: https://github.com/healenium/healenium-backend/issues

## Summary

If Docker images are not accessible:
1. ✅ **Build from source** (most reliable)
2. ✅ **Download pre-built JAR** (quickest)
3. ✅ **Use docker-compose with build** (if you have source)

The backend will work the same way regardless of how you run it!

