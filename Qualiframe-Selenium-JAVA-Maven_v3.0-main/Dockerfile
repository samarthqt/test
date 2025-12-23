# QualiFrameV2 Docker Container
# Multi-stage build for optimized image size

# Build stage
FROM maven:3.8.4-openjdk-15 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean compile test-compile -DskipTests

# Runtime stage
FROM openjdk:15-jre-slim

# Install necessary packages
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    unzip \
    curl \
    && rm -rf /var/lib/apt/lists/*

# Install Chrome
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list \
    && apt-get update \
    && apt-get install -y google-chrome-stable \
    && rm -rf /var/lib/apt/lists/*

# Install Firefox
RUN apt-get update && apt-get install -y firefox-esr \
    && rm -rf /var/lib/apt/lists/*

# Create app directory
WORKDIR /app

# Copy built artifacts from build stage
COPY --from=build /app/target ./target
COPY --from=build /app/src ./src
COPY --from=build /app/pom.xml .

# Create directories for reports and logs
RUN mkdir -p /app/Results /app/logs /app/downloads

# Set environment variables
ENV JAVA_OPTS="-Xmx2g -Xms1g"
ENV MAVEN_OPTS="-Xmx1g -Xms512m"
ENV DISPLAY=:99

# Create non-root user
RUN useradd -m -u 1000 testuser && chown -R testuser:testuser /app
USER testuser

# Expose ports for Selenium Grid (if needed)
EXPOSE 4444

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=5s --retries=3 \
    CMD curl -f http://localhost:4444/status || exit 1

# Default command
CMD ["mvn", "clean", "test", "-PrunBDDTests"] 