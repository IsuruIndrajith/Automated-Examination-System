# 🧪 Selenium Java Testing for Automated Examination System

This module provides comprehensive end-to-end testing for the Automated Examination System using **Selenium WebDriver**, **Java**, and **TestNG**.

---

## 📋 Overview

The testing suite covers critical functionalities such as:
- User authentication
- Exam management
- Question answering
- Results verification

The tests simulate real user interactions and validate the system’s behavior under various scenarios.

---

## 🛠 Technology Stack

- **Java**: 21
- **Selenium WebDriver**: 4.29.0
- **TestNG**: 7.10.2
- **WebDriverManager**: 5.9.2
- **Maven**: Build and dependency management

---

## 📁 Project Structure

```

SeleniumJavatesting/
├── src/
│   ├── main/java/
│   │   └── org/example/
│   │       └── Main.java
│   └── test/
│       ├── java/com/auto/exam/tests/
│       │   ├── SampleTest.java
│       │   ├── LoginTest.java
│       │   └── ExamTest.java
│       └── resources/
│           └── testng.xml
├── pom.xml
└── README.md

````

---

## 🧪 Test Classes

### 1. `SampleTest.java`
**Purpose**: Basic setup and browser connectivity check  
- Validates WebDriver setup  
- Opens base URL  
- Basic page interaction  

### 2. `LoginTest.java`
**Purpose**: Authentication validation  
- `testLoginPageLoads()`  
- `testValidLogin()`  
- `testInvalidLogin()`  
Includes dynamic locators and error verification.

### 3. `ExamTest.java`
**Purpose**: Exam functionality end-to-end  
- `testExamPageNavigation()`  
- `testExamCreation()`  
- `testExamList()`  
- `testQuestionAnswering()`  
- `testExamResults()`  

---

## ⚙️ Configuration

### Application Settings
- **Base URL**: `http://localhost:5173`
- **Browser**: Chrome (managed by WebDriverManager)
- **Timeout**: 10s
- **Window Size**: Maximized

### Maven Dependencies

```xml
<dependencies>
  <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.29.0</version>
  </dependency>
  <dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.10.2</version>
  </dependency>
  <dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.9.2</version>
  </dependency>
</dependencies>
````

---

## 🚀 Running Tests

### Prerequisites

* Java 21+
* Maven installed and set in `PATH`
* Chrome browser installed
* Local app running at `http://localhost:5173`

### Run Commands

**All Tests:**

```bash
mvn test
```

**Specific Class:**

```bash
mvn test -Dtest=LoginTest
```

**TestNG Suite File:**

```bash
mvn test -DsuiteXmlFile=src/test/resources/testng.xml
```

**Specific Browser (if extended):**

```bash
mvn test -Dbrowser=chrome
```

---

## 🔧 Key Features

* Smart locators & cross-browser support
* Explicit waits & error timeout handling
* End-to-end coverage of major workflows
* Easy to extend with new test cases
* Clean separation of test classes

---

## 📊 Test Coverage

### Areas Covered

* ✅ Login & Logout
* ✅ Exam Creation
* ✅ Question Answering
* ✅ Navigation & Routing
* ✅ Result Validation
* ✅ Form Validation & Errors

### Test Types

* Unit Testing
* Integration Testing
* End-to-End Testing
* UI Element Testing

---

## 🐛 Troubleshooting

### Common Issues

**Element Not Found**

* Check port: is the app running at `localhost:5173`?
* Confirm updated selectors
* Increase timeouts if needed

**WebDriver Issues**

* Ensure browser version is compatible
* Use latest `WebDriverManager` version

**Test Failures**

* Review error logs
* Check app state and data consistency

### Debug Mode

```bash
mvn test -Dselenium.debug=true -Dwebdriver.chrome.verboseLogging=true
```

---

## 📈 Test Output Sample

```
✓ Login page loaded successfully
✓ Successfully navigated to exam page
✓ Exam creation form submitted successfully
⚠ Could not find exam navigation: TimeoutException
✓ Found 5 exam items
```

---

## 🔄 CI/CD Integration

**GitHub Actions Example:**

```yaml
- name: Run Selenium Tests
  run: mvn test -DsuiteXmlFile=src/test/resources/testng.xml
```

---

## 📝 Best Practices

1. Keep tests modular and isolated
2. Use Page Object Model (future extension)
3. Externalize test data if needed
4. Avoid hardcoded waits — use smart waits
5. Test one feature per method

---

## 🤝 Contributing

* Follow naming standards
* Include comments for test logic
* Extend `testng.xml` for new tests
* Ensure your tests run independently
* Don’t break existing test flow 😉

---

## 📞 Support

If you face issues:

* Check the troubleshooting section above
* Ensure app and server are running
* Verify dependencies are installed
* Inspect console logs for failure traces

---

**This testing suite ensures the reliability and functionality of the Automated Examination System through automated, maintainable test scenarios.**

