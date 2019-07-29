package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.io.IOException;

public class TC_LoginTest_1 extends BaseClass {


    @Test
    public void loginTest() throws IOException {

        LoginPage lp = new LoginPage(driver);
        MainPage mp = new MainPage(driver);

        mp.clickSignInButton();
        logger.info("Sign in button clicked");
        lp.inputUserName(userID);
        logger.info("User name inputed");
        lp.inputPassword(password);
        logger.info("Password inputed");
        lp.clickButton();
        logger.info("User successfully signed in");


        if (driver.getTitle().equals("My account - My Store"))
        {
            Assert.assertTrue(true);
            logger.info("Test passed");
        }
        else
        {
            captureScreen(driver, "loginTest");
            Assert.assertTrue(false);
            logger.info("Test failed");
        }



    }



}
