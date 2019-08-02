package testCases;

import org.testng.annotations.Test;
import pageObjects.MainPage;
import pageObjects.SearchPage;

public class TC_SearchTest_6 extends BaseClass {

    @Test
    public void SearchTest ()
    {
        MainPage mp = new MainPage(driver);
        SearchPage sp = new SearchPage(driver);
        TC_LoginTest_1 login = new TC_LoginTest_1();

        login.loginTest();
        mp.enterSearchText(search);
        logger.info("Entered searched keyword");
        sp.verifySearchResult();


    }


}
