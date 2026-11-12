package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    //Locators
    private By pageTitleHeader = By.className("title");
    private By menuBtn = By.id("react-burger-menu-btn");
    private By logoutBtn = By.id("logout_sidebar_link");

    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void getPageTitle(String pageTitle){
        driver.findElement(pageTitleHeader).getText();
    }

    public void clickMenu(){
        driver.findElement(menuBtn).click();
    }
    public void clickLogout(){
        driver.findElement(logoutBtn).click();
    }
}
