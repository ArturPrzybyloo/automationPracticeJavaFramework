package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SignInPage {

    WebDriver ldriver;

    public SignInPage (WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id = "id_gender1")
    @CacheLookup
    WebElement RadioButtonMr;

    @FindBy(id = "id_gender2")
    @CacheLookup
    WebElement RadioButtonMrs;

    @FindBy(id = "customer_firstname")
    @CacheLookup
    WebElement FirstNameInput;

    @FindBy(id = "customer_lastname")
    @CacheLookup
    WebElement LastNameInput;

    @FindBy(id = "passwd")
    @CacheLookup
    WebElement PasswordInput;

    @FindBy(id = "days")
    @CacheLookup
    WebElement DateOfBirthDays;

    @FindBy(id = "months")
    @CacheLookup
    WebElement DateOfBirthMonths;

    @FindBy(id = "years")
    @CacheLookup
    WebElement DateOfBirthYears;

    @FindBy(id = "newsletter")
    @CacheLookup
    WebElement NewsletterCheckbox;

    @FindBy(id = "optin")
    @CacheLookup
    WebElement SpecialOfferCheckbox;

    @FindBy(id = "firstname")
    @CacheLookup
    WebElement AdressFirstName;

    @FindBy(id = "lastname")
    @CacheLookup
    WebElement AdressLastName;

    @FindBy(id = "company")
    @CacheLookup
    WebElement CompanyName;

    @FindBy(id = "address1")
    @CacheLookup
    WebElement AdressInput;

    @FindBy(id = "city")
    @CacheLookup
    WebElement CityInput;

    @FindBy(id = "id_state")
    @CacheLookup
    WebElement StateDropdown;

    @FindBy(id = "postcode")
    @CacheLookup
    WebElement ZipCodeInput;

    @FindBy(id = "id_country")
    @CacheLookup
    WebElement CountryDropdown;

    @FindBy(id = "phone_mobile")
    @CacheLookup
    WebElement MobilePhoneInput;

    @FindBy(id = "submitAccount")
    @CacheLookup
    WebElement RegisterButton;

    public void setTitle ()
    {
        RadioButtonMr.click();
    }

    public void enterFirstName (String firstname)
    {
        FirstNameInput.sendKeys(firstname);
    }

    public void enterLastName (String lastname)
    {
        LastNameInput.sendKeys(lastname);
    }

    public void enterPassword (String password)
    {
        PasswordInput.sendKeys(password);
    }

    public void chooseDayOfBirth ()
    {
        Select dayOfBirth = new Select(DateOfBirthDays);
        dayOfBirth.selectByValue("15");
    }

    public void chooseMonthOfBirth ()
    {
        Select monthOfBirth = new Select(DateOfBirthMonths);
        monthOfBirth.selectByValue("11");
    }

    public void chooseYearOfBirth ()
    {
        Select yearofBirth = new Select(DateOfBirthYears);
        yearofBirth.selectByValue("1992");
    }

    public void selectNewsletter()
    {
        NewsletterCheckbox.click();
    }

    public void selectSpecialOffers()
    {
        SpecialOfferCheckbox.click();
    }

    public void enterCompanyName (String company)
    {
        CompanyName.sendKeys(company);
    }

    public void enterAdress (String adress)
    {
        AdressInput.sendKeys(adress);
    }

    public void enterCity (String city)
    {
        CityInput.sendKeys(city);
    }

    public void chooseState ()
    {
        Select state = new Select(StateDropdown);
        state.selectByVisibleText("New York");
    }

    public void enterZipCode (String zip)
    {
        ZipCodeInput.sendKeys(zip);
    }

    public void chooseCountry ()
    {
        Select country = new Select(CountryDropdown);
        country.selectByVisibleText("United States");
    }

    public void enterMobilePhone (String phone)
    {
        MobilePhoneInput.sendKeys(phone);
    }

    public void clickRegisterButton ()
    {
        RegisterButton.click();
    }




}
