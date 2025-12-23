@echo off
REM Cross-platform script runner for QualiFrameV2 (Windows Batch)
REM Works on Windows, macOS (with Wine), and Linux (with Wine)

setlocal enabledelayedexpansion

REM Detect the operating system
for /f "tokens=2 delims==" %%a in ('wmic os get name /value ^| find "="') do set "OS_NAME=%%a"

echo 🚀 QualiFrameV2 Cross-Platform Runner
echo =====================================
echo Detected OS: %OS_NAME%
echo.

REM Check if Java is available
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ❌ Java is not installed or not in PATH
    echo Please install Java 17 or higher and try again
    pause
    exit /b 1
)

for /f "tokens=3" %%i in ('java -version 2^>^&1 ^| findstr /i "version"') do set "JAVA_VERSION=%%i"
echo ✅ Java version: %JAVA_VERSION%
echo.

REM Check if Maven is available
mvn --version >nul 2>&1
if %errorlevel% neq 0 (
    echo ⚠️  Maven not found in PATH, checking for local installation...
    
    if exist ".\apache-maven-3.9.6\bin\mvn.cmd" (
        echo ✅ Using local Maven installation
        set "MAVEN_CMD=.\apache-maven-3.9.6\bin\mvn.cmd"
    ) else (
        echo ❌ Maven not found. Please install Maven or ensure local installation exists.
        pause
        exit /b 1
    )
) else (
    set "MAVEN_CMD=mvn"
    for /f "tokens=3" %%i in ('mvn --version ^| findstr /i "Apache Maven"') do echo ✅ Using system Maven: %%i
)
echo.

REM Compile the framework if needed
if not exist "target\test-classes" (
    echo 📦 Framework not compiled. Compiling now...
    %MAVEN_CMD% clean test-compile
    if %errorlevel% neq 0 (
        echo ❌ Compilation failed
        pause
        exit /b 1
    )
    echo ✅ Compilation successful
) else (
    echo ✅ Framework already compiled
)
echo.

REM Get command from arguments
set "COMMAND=%1"
if "%COMMAND%"=="" set "COMMAND=help"

echo Running command: %COMMAND%
echo.

REM Execute the command
if "%COMMAND%"=="optimize" (
    echo ⚡ Running Cross-Platform Framework Optimization...
    java -cp target\test-classes com.framework.optimization.FrameworkOptimizer
) else if "%COMMAND%"=="platform-info" (
    echo 🌍 Platform Information:
    java -cp target\test-classes com.framework.utils.PlatformUtils
) else if "%COMMAND%"=="dead-code" (
    echo 🧹 Dead Code Analysis...
    java -cp target\test-classes com.framework.utils.DeadCodeDetector "%CD%"
) else if "%COMMAND%"=="help" (
    call :show_help
) else (
    echo ❌ Unknown command: %COMMAND%
    call :show_help
)

echo.
echo ✅ Cross-platform execution completed
pause
exit /b 0

:show_help
echo Usage: run-cross-platform.bat ^<command^>
echo.
echo 🌍 Cross-Platform Commands:
echo   optimize       - Run framework optimization
echo   platform-info  - Show platform information
echo   dead-code      - Analyze and remove dead code
echo   help           - Show this help message
echo.
echo 🎯 Examples:
echo   run-cross-platform.bat optimize
echo   run-cross-platform.bat platform-info
echo   run-cross-platform.bat dead-code
echo.
echo 🔧 Platform Support:
echo   ✅ Windows (Native)
echo   ✅ macOS (with Wine)
echo   ✅ Linux (with Wine)
goto :eof