package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class flightResult {

    WebDriver driver;
    @FindBy(how = How.XPATH, using = "//*[@id=\"data\"]/ul/li[1]/div/form/div/div[1]/div[1]/div[1]")
    WebElement listElement;
    @FindBy(tagName = "")
    private WebElement heading;
    @FindBy(how = How.XPATH, using = "//*[@id=\"data\"]/ul/li[1]/div/form/div/div[2]/div/button")
    WebElement bookBTN;


    public flightResult(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //This Assertion to check if page is opened
    public boolean isPageOpened() {
        return heading.getText().toString().contains("Flight Stops");

    }

    public void selectElementFromTheList() {
        listElement.click();
        bookBTN.click();

    }

    public boolean isInvoicePageOpened() {
        return heading.getText().toString().contains("Booking Invoice");

    }
}


