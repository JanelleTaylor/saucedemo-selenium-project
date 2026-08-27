package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    //Locators
    private By pageTitleHeader = By.className("title");


    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void getPageTitle(String pageTitle){
        driver.findElement(pageTitleHeader).getText();
    }


}
