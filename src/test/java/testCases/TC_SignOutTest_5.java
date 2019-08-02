package testCases;

import org.testng.annotations.Test;
import pageObjects.MainPage;

import java.io.IOException;

public class TC_SignOutTest_5 extends BaseClass {


    @Test
    public void SignOutTest () throws IOException
    {
        TC_LoginTest_1 login = new TC_LoginTest_1();
        MainPage mp = new MainPage(driver);

        login.loginTest();
        mp.clickSignOutButton();
        logger.info("Clicked sign out button");
        mp.verifySignInButton();
        logger.info("Test passed");





    }


}
