package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.io.IOException;

public class TC_SignInTest_2 extends BaseClass {

    @Test
    public void signInTest() throws IOException {

        LoginPage lp = new LoginPage(driver);
        MainPage mp = new MainPage(driver);

        mp.clickSignInButton();
        logger.info("Sign in button clicked");
        lp.registerEmail();
        logger.info("Random email inputed");
        lp.clickCreateAccount();
        logger.info("Create an account button clicked");

        if (driver.getTitle().equals("Login - My Store"))
        {
            Assert.assertTrue(true);
            logger.info("Succesfully get to account details page");
        }
        else
        {
            captureScreen(driver, "loginTest");
            Assert.assertTrue(false);
            logger.info("Test failed");
        }









    }


}
