package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class searchFlights {

    WebDriver driver;

    @FindBy(tagName = "h2")
    private WebElement heading;

    @FindBy(xpath = "//*[@id=\"autocomplete\"]")
    private WebElement fliyingFrom;

    @FindBy(xpath = "//*[@id=\"autocomplete2\"]")
    private WebElement fliyingTo;

    @FindBy(xpath = "//*[@id=\"onereturn\"]/div[2]/div/div[1]/div/div/span")
    private WebElement calender;

    @FindBy(xpath = "//*[@id=\"flights-search\"]/span[1]")
    private WebElement search;
    @FindBy(xpath = "<div class=\"autocomplete-location\">Sydney, Australia</div>")
    private WebElement fromOption;
    @FindBy(xpath = "//*[@id=\"onereturn\"]/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div[1]/strong")
    private WebElement toOption;
    @FindBy(xpath = "//*[@id=\"fadein\"]/div[3]/div[1]/table")
    private WebElement datePicker;



    public searchFlights(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterFromDetails(String from) {
        fliyingFrom.sendKeys("SYD");
        fliyingFrom.click();
        fromOption.click();
    }

    public void enterToDetails(String to) {
        fliyingFrom.sendKeys("SIN");
        fliyingFrom.click();
        toOption.click();


    }

    public void selectCalender()  throws Exception {


        String dateTime = "30/04/2022 2:00 PM";
        this.driver = driver;

        driver.manage().window().maximize();

        calender.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //button to open calendar

        datePicker.click();
        Date d = new Date(1);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
        String date = formatter.format(d);
        String splitter[] = date.split("-");
        String month_year = splitter[1];
        String day = splitter[0];
        System.out.println(month_year);
        System.out.println(day);

        selectDate(month_year,day);

    }


    public void selectDate(String month_year, String select_day) throws InterruptedException
    {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[1]"));

        for (int i=0; i<elements.size();i++)
        {
            System.out.println(elements.get(i).getText());

//Selecting the month
            if(elements.get(i).getText().equals(month_year))
            {

                List<WebElement> days = driver.findElements(By.xpath("//div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']/div[2]/table/tbody/tr/td/a"));

                for (WebElement d:days)
                {
                    System.out.println(d.getText());
                    if(d.getText().equals(select_day))
                    {
                        d.click();
                        Thread.sleep(10000);
                        return;
                    }
                }

            }
            driver.findElement(By.xpath("//div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']/div[2]/div/a/span")).click();
            selectDate(month_year,select_day);

        }
            }

            public void clickSearch(){

                search.click();
                driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

    }

    }




