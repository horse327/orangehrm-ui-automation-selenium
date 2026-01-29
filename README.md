# OrangeHRM UI Automation (Selenium + TestNG)

## Overview
This repository contains a **UI automation testing framework** for the OrangeHRM application, built using **Selenium WebDriver** and **TestNG** with **Java**.

The framework follows **Page Object Model (POM)** principles and is designed to reflect **real-world QA automation practices**, focusing on readability, maintainability, and test stability.

It covers both **positive and negative test scenarios** for core OrangeHRM features.

---

## Tech Stack
- Java  
- Selenium WebDriver  
- TestNG  
- Maven  
- Page Object Model (POM)

---

## Project Structure
src/test/java
├── base # WebDriver setup, teardown, screenshots on failure
├── pages # Page Object classes (Login, Admin, PIM)
├── tests # Test scenarios (positive & negative)
└── utils # Configuration reader & helpers


---

## Test Scenarios Covered
### Login
- Valid login
- Invalid credentials
- Empty username/password validation

### Admin Module
- Search user by username

### PIM Module
- Add employee
- Delete employee

---

## How to Run
1. Clone the repository
2. Configure credentials in `config.properties`
3. Run tests using:
   - `testng.xml`, or  
   - Individual TestNG test classes

---

## Key Features
- Page Object Model (POM) implementation
- Explicit waits to reduce flaky tests
- Automatic screenshot capture on test failure
- Clean separation between test logic and page logic
- Maven-based dependency management

---

## Notes / Limitations
- Tests rely on OrangeHRM demo data and UI stability
- Delete employee test removes the first matching record (demo limitation)
- UI changes in OrangeHRM may require locator updates

---

## Author
**Azhar Munggaran**  
QA Engineer | UI & API Automation  
