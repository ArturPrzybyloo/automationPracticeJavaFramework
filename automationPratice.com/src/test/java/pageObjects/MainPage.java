package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testCases.BaseClass;

public class MainPage {

    WebDriver ldriver;
    BaseClass bc = new BaseClass();

    public MainPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);





    }

    @FindBy(linkText="Sign in")
    @CacheLookup
    WebElement SignInButton;

    @FindBy(xpath = "//*[@title='Home']")
    @CacheLookup
    WebElement homeButton;

    @FindBy(xpath = "//*[@title='Blouse']//img")
    @CacheLookup
    WebElement productImage;

    @FindBy(xpath = "//*[@name='Submit']")
    @CacheLookup
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id='homefeatured']/li[2]/div/div[2]/div[2]/a[1]")
    @CacheLookup
    WebElement addToCartHoverBtn;

    @FindBy(xpath = "//*[@alt='Faded Short Sleeve T-shirts']")
    @CacheLookup
    WebElement productWindow;

    @FindBy(xpath = "//*[@title='Contact Us']")
    @CacheLookup
    WebElement contactUSButton;

    @FindBy(xpath = "//*[@title='Log me out']")
    @CacheLookup
    WebElement signOutButton;

    @FindBy(id = "search_query_top")
    @CacheLookup
    WebElement searchInput;






    public void clickSignInButton ()
    {


        SignInButton.click();

    }

    public void clickHomeButton ()
    {

        homeButton.click();
    }

    public void hoverOnProduct ()
    {
        Actions action = new Actions(ldriver);
        action.moveToElement(productWindow).build().perform();

    }

    public void clickProductImage ()
    {
        productImage.click();
    }

    public void clickAddtoCartButton ()
    {
        ldriver.switchTo().activeElement().submit();
        addToCartButton.click();
    }

    public void clickContactUsButton ()
    {
        contactUSButton.click();
    }

    public void clickSignOutButton ()
    {
        signOutButton.click();
    }

    public void verifySignInButton ()
    {
        if (SignInButton.isDisplayed())
        {
            Assert.assertTrue(true);
            bc.logger.info("Sign In button is displayed");
        }
        else
        {
            Assert.assertTrue(false);
            bc.logger.info("Test Failed");
        }
    }

    public void enterSearchText (String search)
    {
        searchInput.sendKeys(search);
        searchInput.sendKeys(Keys.RETURN);
    }





}

