# SauceDemo Selenium Project

An automation repository of SauceLabs Swag Labs, https://www.saucedemo.com/, e-commerce website. This project monstrates demonstrates modern QA engineering best practices, reliable locator strategies and maintainable framework design patterns.

## Key Framework Features

## Tech Stack & Dependencies
* **Language:** Java(v 26.0.2.1)
* **Automation Engine:** Selenium WebDriver (v4.47.0)
* **Test Runner:** TestNG
* **IDE:** IntelliJ IDEA

## Automated Test Scenarios Covered

### 1. Authentication()
* **Happy Path Login:** Verifies successful login route using 'standard_user/secrete_sauce' to the inventory page.
* **Error Validation (Locked Out User):** Asserts a specific error banner when trying to login with a blocked account.
* **Invalid Login:** Verifies form field error states when invalid/empty credentials are inputted.
* **Logout:** Confirms that logging out destroys the session and prevents the browser back-button re-entry.