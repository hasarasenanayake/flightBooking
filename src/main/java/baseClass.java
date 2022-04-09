import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseClass {
    public static WebDriver driver;
    public static Properties prop;
    public static WebDriver getDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", "config/chromedriver");
        driver = new ChromeDriver();
        FileInputStream fis = new FileInputStream("src/test/resources/properties");
        prop = new Properties();
        prop.load(fis);
        driver.get(prop.getProperty("baseUrl"));
        //driver.get("https://book.spicejet.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return driver;

    }
}
