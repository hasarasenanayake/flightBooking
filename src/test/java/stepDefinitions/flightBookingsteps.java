package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pageObjects.welcomepage;
import pageObjects.login;
import pageObjects.searchFlights;
import pageObjects.flightResult;
import pageObjects.flightBookingPage;
import pageObjects.invoicePage;
import pageObjects.homePage;

import static org.junit.Assert.assertTrue;


public class flightBookingsteps {

    WebDriver driver;
    welcomepage welcomepage;
    login login;
    searchFlights searchFlights;
    flightResult flightResult;
    flightBookingPage flightBookingPage;
    invoicePage invoicePage;
    homePage homePage;

    String driverPath= "chromedriver";


    @Before
    public void startUp() {
        System.setProperty("config/chromedriver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Given("^User is  on the home page$")
    public void userIsOnTheHomePage() {
        try {

            homePage = new homePage(driver);
            homePage.navigateToHomePage();
        }catch (Exception e) {

            e.printStackTrace();
        }

    }

    @When("^user selects and click customer account widget$")
    public void userSelectsAndClickCustomerAccountWidget() {

        try {
            homePage = new homePage(driver);
            homePage.clickCustomerLink();
            //Check if page is opened

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^User navigates to the appropriate page$")
    public void userNavigatesToTheAppropriatePage() {

       welcomepage= new welcomepage(driver);
       assertTrue (String.valueOf(welcomepage.isPageOpened()),true);
    }

    @When("^enter credentials and click Login button$")
    public void enterCredentialsAndClickLoginButton(DataTable credentials) {

        login= new login(driver);
//        String myWindowHandle = driver.getWindowHandle();
//        driver.switchTo().window(myWindowHandle );
        int paramCount  = credentials.asMaps(String.class, String.class).size();

        String[] Qparam = new String[paramCount+1];
        String[] QValue = new String[paramCount+1];

        int i =0;

        for (Map<String, String> data : credentials.asMaps(String.class,String.class)) {
            Qparam[i] = data.get("Parameter");
            QValue[i] = data.get("Value");
            login.loginDetails(Qparam[i], QValue[i]);
            i++;
        }
    }

    @And("^Search a flight by providing \"([^\"]*)\" and \"([^\"]*)\" and date$")
    public void searchAFlightByProvidingAndAndDate(String from, String to) throws Throwable {
        searchFlights= new searchFlights(driver);
        searchFlights.enterFromDetails(from);
        searchFlights.enterToDetails(to);
        searchFlights.selectCalender();


    }

    @Then("^click search to see the flight list$")
    public void clickSearchToSeeTheFlightList() {
        searchFlights= new searchFlights(driver);
        searchFlights.clickSearch();
    }

    @Then("^select the first available flight from the list$")
    public void selectTheFirstAvailableFlightFromTheList() {
        flightResult= new flightResult(driver);
        flightResult.isPageOpened();
        flightResult.selectElementFromTheList();
    }

    @Then("^Enter booking details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\" and click confrim$")
    public void enterBookingDetailsAndClickConfrim(String firstName, String lastName, String email, String phone, String address, String travFname, String travLname, String travNation, String passport) throws Throwable {
       flightBookingPage = new flightBookingPage(driver);
       flightBookingPage.enterBookingDetails( firstName, lastName, email, phone, address, travFname, travLname, travNation, passport);
        }

    @Then("^User should be able to see the confirmation page$")
    public void userShouldBeAbleToSeeTheConfirmationPage() {

        invoicePage= new invoicePage(driver);
        invoicePage.isInvoicePageOpened();
        invoicePage.isreservationCompleted();
    }
}
