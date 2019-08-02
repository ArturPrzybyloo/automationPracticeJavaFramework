package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class LoginPage {

    WebDriver ldriver;

    public LoginPage (WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id="email")
    @CacheLookup
    WebElement UserName;

    @FindBy(id="passwd")
    @CacheLookup
    WebElement Password;

    @FindBy (id = "SubmitLogin")
    @CacheLookup
    WebElement SignButton;

    @FindBy (id = "email_create")
    @CacheLookup
    WebElement CreateAccInput;

    @FindBy (id = "SubmitCreate")
    @CacheLookup
    WebElement CreateAccBtn;



    public void inputUserName (String username)
    {
        UserName.sendKeys(username);
    }

    public void inputPassword (String password)
    {
        Password.sendKeys(password);
    }

    public void clickButton ()
    {
        SignButton.click();
    }

    public void registerEmail ()
    {
        CreateAccInput.click();
        Random randomGenerator = new Random ();
        int randomInt = randomGenerator.nextInt(1000);
        CreateAccInput.sendKeys(randomInt +"Test" + randomInt + "@yahoo.com");
    }

    public void clickCreateAccount ()
    {
        CreateAccBtn.click();
    }








}
