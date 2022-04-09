package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class login {

    WebDriver driver;
    @FindBy(how = How.ID_OR_NAME,using ="email")
        WebElement email;
    @FindBy(how = How.ID_OR_NAME,using ="password")
   // @FindBy(how = How.XPATH,using = "//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input")
    WebElement password;

    @FindBy(how = How.XPATH,using = "//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button/span[1]")

    WebElement loginBTN;


    public login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }
    public void loginDetails(String emailTXT,String passwordTXT){
        email.click();
        email.sendKeys(emailTXT);
        password.click();
        password.sendKeys(passwordTXT);
        loginBTN.click();
    }



}
