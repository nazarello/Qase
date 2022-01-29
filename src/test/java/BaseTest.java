import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
String email, password;

    @BeforeMethod
    public void setUp() {
        //Configuration.headless = true;
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url")); //https://app.qase.io/;
        email = System.getenv().getOrDefault("QASE_EMAIL", PropertyReader.getProperty("qase.email"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
        Configuration.browser = "chrome";
        //   Configuration.clickViaJs = true;
        Configuration.savePageSource = false;
        Configuration.timeout = 10000;

//        ChromeOptions chromeOptions = new ChromeOptions();
//        // chromeOptions.addArguments("headless");
//        Configuration.browserCapabilities = chromeOptions;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getWebDriver().quit();

       /* WebDriver driver = new ChromeDriver();
        setWebDriver(driver);*/
    }
}
