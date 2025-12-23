# Cross-platform script runner for QualiFrameV2 (PowerShell)
# Works on Windows, macOS (with PowerShell Core), and Linux (with PowerShell Core)

param(
    [string]$Command = "help"
)

# Function to detect operating system
function Get-OperatingSystem {
    if ($IsWindows -or $env:OS -eq "Windows_NT") {
        return "Windows"
    } elseif ($IsMacOS) {
        return "macOS"
    } elseif ($IsLinux) {
        return "Linux"
    } else {
        return "Unknown"
    }
}

# Function to get appropriate command
function Get-PlatformCommand {
    param([string]$BaseCommand)
    
    $os = Get-OperatingSystem
    if ($os -eq "Windows") {
        return "$BaseCommand.exe"
    }
    return $BaseCommand
}

# Function to get file separator
function Get-FileSeparator {
    $os = Get-OperatingSystem
    if ($os -eq "Windows") {
        return "\"
    }
    return "/"
}

# Function to get path separator
function Get-PathSeparator {
    $os = Get-OperatingSystem
    if ($os -eq "Windows") {
        return ";"
    }
    return ":"
}

# Function to check Java
function Test-Java {
    try {
        $javaVersion = java -version 2>&1 | Select-String "version" | Select-Object -First 1
        if ($LASTEXITCODE -eq 0) {
            Write-Host "✅ Java version: $javaVersion" -ForegroundColor Green
            return $true
        }
    } catch {
        Write-Host "❌ Java is not installed or not in PATH" -ForegroundColor Red
        Write-Host "Please install Java 17 or higher and try again" -ForegroundColor Yellow
        return $false
    }
    return $false
}

# Function to check Maven
function Test-Maven {
    $mavenCmd = Get-PlatformCommand "mvn"
    
    try {
        $mavenVersion = & $mavenCmd --version 2>&1 | Select-String "Apache Maven" | Select-Object -First 1
        if ($LASTEXITCODE -eq 0) {
            Write-Host "✅ Using system Maven: $mavenVersion" -ForegroundColor Green
            return $mavenCmd
        }
    } catch {
        Write-Host "⚠️  Maven not found in PATH, checking for local installation..." -ForegroundColor Yellow
        
        if (Test-Path ".\apache-maven-3.9.6\bin\mvn.cmd") {
            Write-Host "✅ Using local Maven installation" -ForegroundColor Green
            return ".\apache-maven-3.9.6\bin\mvn.cmd"
        } else {
            Write-Host "❌ Maven not found. Please install Maven or ensure local installation exists." -ForegroundColor Red
            return $null
        }
    }
    return $null
}

# Function to compile framework
function Compile-Framework {
    param([string]$MavenCmd)
    
    if (-not (Test-Path "target\test-classes")) {
        Write-Host "📦 Framework not compiled. Compiling now..." -ForegroundColor Yellow
        & $MavenCmd clean test-compile
        if ($LASTEXITCODE -ne 0) {
            Write-Host "❌ Compilation failed" -ForegroundColor Red
            exit 1
        }
        Write-Host "✅ Compilation successful" -ForegroundColor Green
    } else {
        Write-Host "✅ Framework already compiled" -ForegroundColor Green
    }
}

# Function to show platform information
function Show-PlatformInfo {
    Write-Host "🌍 Platform Information:" -ForegroundColor Cyan
    Write-Host "  OS: $(Get-OperatingSystem)" -ForegroundColor White
    Write-Host "  PowerShell Version: $($PSVersionTable.PSVersion)" -ForegroundColor White
    Write-Host "  Java: $(java -version 2>&1 | Select-String 'version' | Select-Object -First 1)" -ForegroundColor White
    Write-Host "  File Separator: $(Get-FileSeparator)" -ForegroundColor White
    Write-Host "  Path Separator: $(Get-PathSeparator)" -ForegroundColor White
    Write-Host ""
}

# Function to show help
function Show-Help {
    Write-Host "Usage: .\run-cross-platform.ps1 [-Command] <command>" -ForegroundColor Cyan
    Write-Host ""
    Write-Host "🌍 Cross-Platform Commands:" -ForegroundColor Yellow
    Write-Host "  optimize       - Run framework optimization" -ForegroundColor White
    Write-Host "  platform-info  - Show platform information" -ForegroundColor White
    Write-Host "  dead-code      - Analyze and remove dead code" -ForegroundColor White
    Write-Host "  help           - Show this help message" -ForegroundColor White
    Write-Host ""
    Write-Host "🎯 Examples:" -ForegroundColor Yellow
    Write-Host "  .\run-cross-platform.ps1 -Command optimize" -ForegroundColor White
    Write-Host "  .\run-cross-platform.ps1 -Command platform-info" -ForegroundColor White
    Write-Host "  .\run-cross-platform.ps1 -Command dead-code" -ForegroundColor White
    Write-Host ""
    Write-Host "🔧 Platform Support:" -ForegroundColor Yellow
    Write-Host "  ✅ Windows (Native)" -ForegroundColor Green
    Write-Host "  ✅ macOS (PowerShell Core)" -ForegroundColor Green
    Write-Host "  ✅ Linux (PowerShell Core)" -ForegroundColor Green
}

# Main execution
Write-Host "🚀 QualiFrameV2 Cross-Platform Runner" -ForegroundColor Magenta
Write-Host "====================================" -ForegroundColor Magenta
Write-Host "Detected OS: $(Get-OperatingSystem)" -ForegroundColor White
Write-Host ""

# Check prerequisites
if (-not (Test-Java)) {
    exit 1
}

$mavenCmd = Test-Maven
if (-not $mavenCmd) {
    exit 1
}

Write-Host ""

# Show platform info
Show-PlatformInfo

# Compile if needed
Compile-Framework $mavenCmd
Write-Host ""

# Execute the command
Write-Host "Running command: $Command" -ForegroundColor Cyan
Write-Host ""

switch ($Command.ToLower()) {
    "optimize" {
        Write-Host "⚡ Running Cross-Platform Framework Optimization..." -ForegroundColor Yellow
        java -cp "target\test-classes" com.framework.optimization.FrameworkOptimizer
    }
    "platform-info" {
        Write-Host "🌍 Platform Information:" -ForegroundColor Cyan
        java -cp "target\test-classes" com.framework.utils.PlatformUtils
    }
    "dead-code" {
        Write-Host "🧹 Dead Code Analysis..." -ForegroundColor Yellow
        java -cp "target\test-classes" com.framework.utils.DeadCodeDetector (Get-Location)
    }
    "help" {
        Show-Help
    }
    default {
        Write-Host "❌ Unknown command: $Command" -ForegroundColor Red
        Show-Help
    }
}

Write-Host ""
Write-Host "✅ Cross-platform execution completed" -ForegroundColor Green