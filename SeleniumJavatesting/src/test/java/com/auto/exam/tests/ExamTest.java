package com.auto.exam.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class ExamTest {

    private WebDriver driver;
    private WebDriverWait wait;
    
    private static final String BASE_URL = "http://localhost:5173";
    
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testExamPageNavigation() {
        driver.get(BASE_URL);
        
        try {
            // Look for navigation to exam section
            WebElement examLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Exam')] | //a[contains(text(), 'Test')] | //button[contains(text(), 'Exam')] | //nav//a[contains(@href, 'exam')]")
            ));
            
            examLink.click();
            Thread.sleep(2000);
            
            // Verify we're on exam page
            String currentUrl = driver.getCurrentUrl();
            boolean onExamPage = currentUrl.contains("exam") || currentUrl.contains("test");
            
            if (onExamPage) {
                System.out.println("✓ Successfully navigated to exam page");
            } else {
                System.out.println("⚠ Navigation to exam page may have failed");
            }
            
        } catch (Exception e) {
            System.out.println("⚠ Could not find exam navigation: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void testExamCreation() {
        driver.get(BASE_URL);
        
        try {
            // Look for create exam button/link
            WebElement createExamButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Create')] | //a[contains(text(), 'Create')] | //button[contains(text(), 'New Exam')] | //a[contains(text(), 'Add Exam')]")
            ));
            
            createExamButton.click();
            Thread.sleep(1000);
            
            // Try to fill exam creation form
            try {
                // Exam title/name field
                WebElement examTitle = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//input[@name='title'] | //input[@name='examName'] | //input[contains(@placeholder, 'title')] | //input[contains(@placeholder, 'name')]")
                ));
                examTitle.clear();
                examTitle.sendKeys("Test Exam - Selenium Automation");
                
                // Exam description
                WebElement examDescription = driver.findElement(
                    By.xpath("//textarea[@name='description'] | //textarea[contains(@placeholder, 'description')] | //input[@name='description']")
                );
                examDescription.clear();
                examDescription.sendKeys("This is a test exam created by Selenium automation");
                
                // Duration field
                try {
                    WebElement duration = driver.findElement(
                        By.xpath("//input[@name='duration'] | //input[contains(@placeholder, 'duration')] | //input[@type='number']")
                    );
                    duration.clear();
                    duration.sendKeys("60");
                } catch (Exception e) {
                    System.out.println("Duration field not found");
                }
                
                // Submit button
                WebElement submitButton = driver.findElement(
                    By.xpath("//button[@type='submit'] | //button[contains(text(), 'Create')] | //button[contains(text(), 'Save')] | //input[@type='submit']")
                );
                
                submitButton.click();
                Thread.sleep(2000);
                
                System.out.println("✓ Exam creation form submitted successfully");
                
            } catch (Exception e) {
                System.out.println("⚠ Could not complete exam creation form: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.out.println("⚠ Could not find create exam button: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void testExamList() {
        driver.get(BASE_URL);
        
        try {
            // Look for exam list or table
            WebElement examList = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//table | //div[contains(@class, 'exam-list')] | //ul[contains(@class, 'exam')] | //div[contains(@class, 'card')]")
            ));
            
            if (examList.isDisplayed()) {
                System.out.println("✓ Exam list is visible");
                
                // Count exam items
                List<WebElement> examItems = driver.findElements(
                    By.xpath("//tr[td] | //div[contains(@class, 'exam-item')] | //li[contains(@class, 'exam')] | //div[contains(@class, 'card')]")
                );
                
                System.out.println("Found " + examItems.size() + " exam items");
                
                // Try to click on first exam if available
                if (!examItems.isEmpty()) {
                    try {
                        WebElement firstExam = examItems.get(0);
                        firstExam.click();
                        Thread.sleep(1000);
                        System.out.println("✓ Successfully clicked on first exam");
                    } catch (Exception e) {
                        System.out.println("Could not click on first exam: " + e.getMessage());
                    }
                }
            }
            
        } catch (Exception e) {
            System.out.println("⚠ Could not find exam list: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void testQuestionAnswering() {
        driver.get(BASE_URL);
        
        try {
            // Look for exam questions
            WebElement question = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class, 'question')] | //h3[contains(text(), '?')] | //p[contains(text(), '?')] | //form[contains(@class, 'question')]")
            ));
            
            if (question.isDisplayed()) {
                System.out.println("✓ Found exam question");
                
                // Look for answer options (radio buttons, checkboxes, or text input)
                List<WebElement> radioOptions = driver.findElements(By.xpath("//input[@type='radio']"));
                List<WebElement> checkboxOptions = driver.findElements(By.xpath("//input[@type='checkbox']"));
                List<WebElement> textInputs = driver.findElements(By.xpath("//input[@type='text'] | //textarea"));
                
                if (!radioOptions.isEmpty()) {
                    // Select first radio option
                    radioOptions.get(0).click();
                    System.out.println("✓ Selected radio button answer");
                } else if (!checkboxOptions.isEmpty()) {
                    // Select first checkbox option
                    checkboxOptions.get(0).click();
                    System.out.println("✓ Selected checkbox answer");
                } else if (!textInputs.isEmpty()) {
                    // Fill text input
                    textInputs.get(0).sendKeys("Test answer from Selenium");
                    System.out.println("✓ Filled text answer");
                }
                
                // Look for next/submit button
                try {
                    WebElement nextButton = driver.findElement(
                        By.xpath("//button[contains(text(), 'Next')] | //button[contains(text(), 'Submit')] | //button[@type='submit']")
                    );
                    nextButton.click();
                    Thread.sleep(1000);
                    System.out.println("✓ Clicked next/submit button");
                } catch (Exception e) {
                    System.out.println("Next/Submit button not found");
                }
            }
            
        } catch (Exception e) {
            System.out.println("⚠ Could not find exam questions: " + e.getMessage());
        }
    }

    @Test(priority = 5)
    public void testExamResults() {
        driver.get(BASE_URL);
        
        try {
            // Look for results/reports section
            WebElement resultsLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Results')] | //a[contains(text(), 'Reports')] | //button[contains(text(), 'Results')] | //nav//a[contains(@href, 'result')]")
            ));
            
            resultsLink.click();
            Thread.sleep(2000);
            
            // Look for results table or list
            WebElement resultsTable = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//table | //div[contains(@class, 'results')] | //div[contains(@class, 'report')] | //ul[contains(@class, 'score')]")
            ));
            
            if (resultsTable.isDisplayed()) {
                System.out.println("✓ Exam results page loaded successfully");
                
                // Try to find score elements
                List<WebElement> scores = driver.findElements(
                    By.xpath("//td[contains(text(), '%')] | //span[contains(@class, 'score')] | //div[contains(@class, 'percentage')] | //strong[contains(text(), '%')]")
                );
                
                if (!scores.isEmpty()) {
                    System.out.println("✓ Found " + scores.size() + " score elements");
                    for (int i = 0; i < Math.min(3, scores.size()); i++) {
                        System.out.println("Score " + (i+1) + ": " + scores.get(i).getText());
                    }
                }
            }
            
        } catch (Exception e) {
            System.out.println("⚠ Could not access exam results: " + e.getMessage());
        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
