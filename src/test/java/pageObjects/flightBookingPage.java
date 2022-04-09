package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class flightBookingPage {
    WebDriver driver;
    @FindBy(tagName = "h2")
    private WebElement heading;

    @FindBy(xpath = "//*[@id=\"fadein\"]/div[2]/form/section/div/div/div[1]/div[1]/div[1]/h3")
    private WebElement title;

    @FindBy(xpath ="//*[@id=\"fadein\"]/div[2]/form/section/div/div/div[1]/div[1]/div[2]/div/div/div[1]/div/div/input")
    private WebElement firstName;
    @FindBy(xpath ="//*[@id=\"fadein\"]/div[2]/form/section/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div/input")
    private WebElement lastName;
    @FindBy(xpath ="//*[@id=\"fadein\"]/div[2]/form/section/div/div/div[1]/div[1]/div[2]/div/div/div[3]/div/div/input")
    private WebElement email;
    @FindBy(xpath = "//*[@id=\"fadein\"]/div[2]/form/section/div/div/div[1]/div[1]/div[2]/div/div/div[4]/div/div/input")
    private WebElement phone;
    @FindBy(xpath ="//*[@id=\"fadein\"]/div[2]/form/section/div/div/div[1]/div[1]/div[2]/div/div/div[5]/div/div/input")
    private WebElement address;
    @FindBy(xpath ="//*[@id=\"fadein\"]/div[2]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/input")
    private WebElement travFname;
    @FindBy(xpath ="//*[@id=\"fadein\"]/div[2]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/input")
    private WebElement travLname;

    @FindBy(xpath ="//*[@id=\"fadein\"]/div[2]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[1]/select")
    private WebElement travNation;

    @FindBy(xpath ="//*[@id=\"fadein\"]/div[2]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/select")
    private WebElement birthdMonth;
    @FindBy(xpath ="//*[@id=\"fadein\"]/div[2]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div[1]/input")
    private WebElement passport;
    @FindBy(xpath ="//*[@id=\"myTab\"]/div[2]/div/label/div/img")
    private WebElement payLater;


    @FindBy(xpath ="//*[@id=\"fadein\"]/div[2]/form/section/div/div/div[1]/div[4]/div/div/div/label")
    private WebElement termsCon;
    @FindBy(xpath ="//*[@id=\"booking\"]")
    private WebElement confrimBTN;

    public flightBookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterBookingDetails(String firstName, String lastName, String email, String phone, String address, String travFname, String travLname, String travNation, String passport){

        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email) ;
        this.phone.sendKeys(phone);
        this.address.sendKeys(address);
        this.travFname.sendKeys(travFname);
        this.travLname.sendKeys(travLname);
        this.travNation.sendKeys(travNation);
        Select selectObject = new Select(birthdMonth);
        selectObject.selectByIndex(1);
        this.passport.sendKeys(passport);
        termsCon.click();
        confrimBTN.click();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


    }



}
