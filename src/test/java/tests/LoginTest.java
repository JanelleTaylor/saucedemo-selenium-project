package tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private String psswd = "secret_sauce";
    private String pageURL;
    private String errorText;
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
        errorText = loginPage.getErrorMsg();
        Assert.assertEquals(errorText, "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void invalidUserLogin(){
        LoginPage loginPage = new LoginPage(driver);

        //No credentials, hitting login button and verifying error message
        loginPage.clickLogin();
        errorText = loginPage.getErrorMsg();
        Assert.assertEquals(errorText,"Epic sadface: Username is required");

        //Username only, hitting login button and verifying error message
        loginPage.enterUsername("standard_user");
        loginPage.clickLogin();
        errorText = loginPage.getErrorMsg();
        Assert.assertEquals(errorText,"Epic sadface: Password is required");

        //Invalid credentials and username
        loginPage.enterUsername("admin");
        loginPage.enterPassword("password");
        loginPage.clickLogin();
        errorText = loginPage.getErrorMsg();
        Assert.assertEquals(errorText,"Epic sadface: Username and password do not match any user in this service");
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