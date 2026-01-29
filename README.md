# OrangeHRM UI Automation (Selenium + TestNG)

## Overview
This project is a UI automation framework for testing core functionalities of the OrangeHRM application using Selenium WebDriver and TestNG.

It is designed following Page Object Model (POM) principles and real-world QA automation best practices.

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)

## Project Structure
src/test/java
├── base # WebDriver setup & teardown
├── pages # Page Object classes
├── tests # Test scenarios
├── utils # Config & helpers

## Test Scenarios Covered
- Login (positive & negative)
- Admin: search user
- PIM: add employee
- PIM: delete employee

## How to Run
1. Clone the repository
2. Configure credentials in `config.properties`
3. Run tests using:
   - `testng.xml`
   - or individual TestNG classes

## Notes
- Screenshots are captured automatically on test failure
- Explicit waits are used to reduce flakiness
- Tests are written with maintainability in mind
