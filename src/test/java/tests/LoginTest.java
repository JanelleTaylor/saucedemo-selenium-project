package tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private String psswd = "secret_sauce";
    private String pageURL;
    //LoginPage loginPage = new LoginPage(driver);

    @Test
    public void standardUserLogin(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword(psswd);
        loginPage.clickLogin();

        //Verifying you land on the inventory page
        pageURL = driver.getCurrentUrl();
        Assert.assertEquals(pageURL, "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void lockedOutUserLogin(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword(psswd);
        loginPage.clickLogin();

        //Verifying user is seeing desired error message
        String errorText = loginPage.getErrorMsg();
        Assert.assertEquals(errorText, "Epic sadface: Sorry, this user has been locked out.");
    }
    /*
    @Test
    public void problemUserLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("problem_user");
        loginPage.enterPassword(psswd);
        loginPage.clickLogin();
    }

    @Test
    public void performanceGlitchUserLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("performance_glitch_user");
        loginPage.enterPassword(psswd);
        loginPage.clickLogin();
    }

    @Test
    public void errorUserLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("error_user");
        loginPage.enterPassword(psswd);
        loginPage.clickLogin();
    }

    @Test
    public void visualUserLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("visual_user");
        loginPage.enterPassword(psswd);
        loginPage.clickLogin();
    }*/
}