package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    //Locators
    private By usernameTextBox = By.id("user-name");
    private By passwordTextBox = By.id("password");
    private By errorMsgText = By.cssSelector(".error-message-container h3");
    private String errorText;
    private By loginBtn = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameTextBox).clear();
        driver.findElement(usernameTextBox).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordTextBox).clear();
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public String getErrorMsg(){
        if(errorMsgText != null){
            errorText = driver.findElement(errorMsgText).getText();
        }
        return errorText;
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
}
