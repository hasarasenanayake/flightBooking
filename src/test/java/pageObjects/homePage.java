package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class homePage  {
   // properties prop;


    WebDriver driver;
    @FindBy(how = How.XPATH,using ="//*[@id=\"Main\"]/section[1]/div/div/div[1]/h4/strong")
    WebElement heading;

    //@FindBy(how = How.XPATH,using = "//*[@id=\"Main\"]/section[1]/div/div/div[2]/div/div/div[2]/h3/strong")
    @FindBy(how = How.XPATH,using = "//*[@id=\"Main\"]/section[1]/div/div/div[2]/div/div")
    WebElement customerFEBox;

    @FindBy(how = How.XPATH,using = "//*[@id=\"Main\"]/section[1]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/a/small")
    WebElement customerFELink;


    public homePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCustomerLink() {
        // highLighterMethod(driver,search);
        customerFELink.click();

    }


    public void navigateToHomePage() {
        driver.get("https://phptravels.com/demo/");

    }
//
//    public boolean isPageOpened(){
//        //Assertion
//        return heading.getText().toString().contains("Service NSW makes it easier to find government information and services");
//    }
}
