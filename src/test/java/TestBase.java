import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase
{
    public static WebDriver driver;

    @BeforeAll
    public static void initialize()
    {
        System.setProperty("webdriver.chrome.driver", "H:\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://amazon.in");
    }

//    @AfterAll
//    public static void quit()
//    {
//        driver.quit();
//    }
}
