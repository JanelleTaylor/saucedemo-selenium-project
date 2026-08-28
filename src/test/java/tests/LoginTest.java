package tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private String psswd = "secret_sauce";
    private String pageTitle = "Products";
    private String loginErrorMsg = "Epic sadface: Sorry, this user has been locked out.";

    @Test
    public void standardUserLogin(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword(psswd);
        loginPage.clickLogin();

        //Verifying you land on the inventory page
        Assert.assertEquals(pageTitle, "Products");
    }

    @Test
    public void lockedOutUserLogin(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword(psswd);
        loginPage.clickLogin();

       Assert.assertEquals(loginErrorMsg, loginPage.getErrorMsg());
    }

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
    }
}