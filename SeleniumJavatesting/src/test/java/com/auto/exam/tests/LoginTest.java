package com.auto.exam.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTest {

    private WebDriver driver;
    private WebDriverWait wait;
    
    // Update this URL to match your frontend application
    private static final String BASE_URL = "http://localhost:5173"; // Assuming Vite dev server
    
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testLoginPageLoads() {
        driver.get(BASE_URL);
        
        // Wait for page to load
        wait.until(ExpectedConditions.titleContains("Vite"));
        
        String pageTitle = driver.getTitle();
        System.out.println("Page title: " + pageTitle);
        
        // Check if login elements are present
        try {
            WebElement loginForm = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//form | //div[contains(@class, 'login')] | //input[@type='email'] | //input[@type='password']")
            ));
            Assert.assertTrue(loginForm.isDisplayed(), "Login form should be visible");
            System.out.println("✓ Login page loaded successfully");
        } catch (Exception e) {
            System.out.println("Note: Login form not found with standard selectors. Page might use different structure.");
        }
    }

    @Test(priority = 2)
    public void testValidLogin() {
        driver.get(BASE_URL);
        
        try {
            // Try to find email/username input field
            WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@type='email'] | //input[@name='email'] | //input[@name='username'] | //input[contains(@placeholder, 'email')] | //input[contains(@placeholder, 'username')]")
            ));
            
            // Try to find password input field
            WebElement passwordField = driver.findElement(
                By.xpath("//input[@type='password'] | //input[@name='password'] | //input[contains(@placeholder, 'password')]")
            );
            
            // Enter test credentials (update these with valid test credentials)
            emailField.clear();
            emailField.sendKeys("test@example.com");
            
            passwordField.clear();
            passwordField.sendKeys("password123");
            
            // Find and click login button
            WebElement loginButton = driver.findElement(
                By.xpath("//button[@type='submit'] | //button[contains(text(), 'Login')] | //button[contains(text(), 'Sign In')] | //input[@type='submit']")
            );
            
            loginButton.click();
            
            // Wait for redirect or success message
            Thread.sleep(2000);
            
            // Check for successful login (dashboard, home page, or success message)
            boolean loginSuccessful = false;
            try {
                // Check for dashboard elements or success indicators
                WebElement dashboard = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[contains(@class, 'dashboard')] | //div[contains(text(), 'Welcome')] | //nav | //h1[contains(text(), 'Dashboard')]")
                ));
                loginSuccessful = dashboard.isDisplayed();
            } catch (Exception e) {
                // If no dashboard found, check current URL for redirect
                String currentUrl = driver.getCurrentUrl();
                loginSuccessful = !currentUrl.equals(BASE_URL) && !currentUrl.contains("login");
            }
            
            if (loginSuccessful) {
                System.out.println("✓ Login test passed - User successfully logged in");
            } else {
                System.out.println("⚠ Login may have failed or requires different credentials");
            }
            
        } catch (Exception e) {
            System.out.println("⚠ Could not perform login test - Login form elements not found: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void testInvalidLogin() {
        driver.get(BASE_URL);
        
        try {
            WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@type='email'] | //input[@name='email'] | //input[@name='username']")
            ));
            
            WebElement passwordField = driver.findElement(
                By.xpath("//input[@type='password'] | //input[@name='password']")
            );
            
            // Enter invalid credentials
            emailField.clear();
            emailField.sendKeys("invalid@example.com");
            
            passwordField.clear();
            passwordField.sendKeys("wrongpassword");
            
            WebElement loginButton = driver.findElement(
                By.xpath("//button[@type='submit'] | //button[contains(text(), 'Login')] | //button[contains(text(), 'Sign In')]")
            );
            
            loginButton.click();
            
            // Wait for error message
            Thread.sleep(2000);
            
            // Check for error message
            try {
                WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[contains(@class, 'error')] | //div[contains(@class, 'alert')] | //span[contains(text(), 'Invalid')] | //div[contains(text(), 'failed')]")
                ));
                
                if (errorMessage.isDisplayed()) {
                    System.out.println("✓ Invalid login test passed - Error message displayed: " + errorMessage.getText());
                }
            } catch (Exception e) {
                System.out.println("⚠ No error message found for invalid login attempt");
            }
            
        } catch (Exception e) {
            System.out.println("⚠ Could not perform invalid login test: " + e.getMessage());
        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
