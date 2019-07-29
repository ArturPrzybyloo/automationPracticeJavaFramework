package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.SignInPage;

import java.io.IOException;

public class TC_SignInTest_2 extends BaseClass {

    @Test
    public void signInTest() throws IOException {

        LoginPage lp = new LoginPage(driver);
        MainPage mp = new MainPage(driver);
        SignInPage sp = new SignInPage(driver);

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


        sp.setTitle();
        logger.info("Title selected");
        sp.enterFirstName(firstName);
        logger.info("Entered first name");
        sp.enterLastName(lastName);
        logger.info("Entered last name");
        sp.enterPassword(password);
        logger.info("Entered password");
        sp.chooseDayOfBirth();
        logger.info("Picked day of birth");
        sp.chooseMonthOfBirth();
        logger.info("Picked Month of birth");
        sp.chooseYearOfBirth();
        logger.info("Picked year of birth");
        sp.selectNewsletter();
        logger.info("Sign up for our newsletter selected");
        sp.selectSpecialOffers();
        logger.info("Special offers selected");
        sp.enterCompanyName("Januszopol");
        logger.info("Entered company name");
        sp.enterAdress("Polska 5");
        logger.info("Entered adress");
        sp.enterCity("Krakow");
        logger.info("Entered city");
        sp.chooseState();
        logger.info("Picked state");
        sp.enterZipCode("31555");
        logger.info("Entered zip code");
        sp.chooseCountry();
        logger.info("Picked country");
        sp.enterMobilePhone("6665554441");
        logger.info("Entered mobile phone number");
        sp.clickRegisterButton();
        logger.info("Clicked register button");

        if (driver.findElement(By.xpath("//*[@title='Log me out']"))!=null)
        {
            Assert.assertTrue(true);
            logger.info("Succesfully created account");
        }
        else
        {
            captureScreen(driver, "loginTest");
            Assert.assertTrue(false);
            logger.info("Test failed");
        }











    }


}
