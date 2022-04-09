package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class welcomepage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "(\"//span[contains(text(),'Hi, Demo Welcome Back')]\")")
    private WebElement heading;

    @FindBy(xpath = "//*[@id=\"fadein\"]/header/div[2]/div/div/div/div/div[2]/nav/ul/li[3]/a")
    private WebElement flights;


    public welcomepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //This Assertion to check if page is opened
    public boolean isPageOpened() {
        return heading.getText().toString().contains("Hi, Demo Welcome Back");

    }


    public void click() {
        flights.click();

    }
}





