package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class invoicePage {


    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"fadein\"]/section/div/div/div/div/div[2]/div[1]/h3")
    private WebElement invoiceTitle;
    @FindBy(xpath = "//*[@id=\"fadein\"]/section/div/div/div/div/div[2]/div[1]/h3/span/strong")
    private WebElement reservationNo;


    public invoicePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isInvoicePageOpened() {
        return invoiceTitle.getText().toString().contains("Booking Invoice");
    }
    public boolean isreservationCompleted() {
        return reservationNo.getText().toString().contains("InvoiceReservation Number");
    }



}
