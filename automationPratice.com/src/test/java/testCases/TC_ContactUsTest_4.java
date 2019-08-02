package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ContactPage;
import pageObjects.MainPage;

import java.io.IOException;

public class TC_ContactUsTest_4 extends BaseClass {

    @Test
    public void contactUs () throws IOException
    {
        MainPage mp = new MainPage(driver);
        TC_LoginTest_1 login = new TC_LoginTest_1();
        ContactPage cp = new ContactPage(driver);

        login.loginTest();
        mp.clickContactUsButton();
        logger.info("Clicked on Contact us button");
        cp.chooseSubject();
        logger.info("Subject of mesasge was picked");
        cp.attachFile();
        logger.info("Attached txt file");
        cp.enterMessage(message);
        logger.info("Entered test message");
        cp.clickSend();
        logger.info("Clicked send button");
        cp.verifySucessMessage();
        logger.info("Succesfully sent message");



    }


}
