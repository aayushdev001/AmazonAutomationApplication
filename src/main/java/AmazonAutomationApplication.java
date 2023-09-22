import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class AmazonAutomationApplication
{
    public static void main(String[] args)
    {
        System.setProperty("webdrive.chrome.driver", "H:\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        openWebsite(driver, "https://amazon.in");
        driver.manage().window().maximize();
        signIn(driver, "9452361808", "blackberryz3");
        searchProductAndAddToCart(driver, "air condition");
        checkout(driver);
    }
    public static void openWebsite(WebDriver driver, String url)
    {
        driver.get(url);
    }
    public static void signIn(WebDriver driver, String id, String password)
    {
        Actions builder = new Actions(driver);
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        builder.moveToElement(signIn).build().perform();
        driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(id);
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
    }
    public static void searchProductAndAddToCart(WebDriver driver, String product)
    {
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(product);
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
        driver.findElement(By.linkText("Carrier 1 Ton 3 Star AI Flexicool Inverter Split AC (Copper, Convertible 4-in-1 Cooling,Dual Filtration with HD & PM 2.5 Filter, Auto Cleanser, 2023 Model,ESTER Exi - CAI12ER3R33F0,White)")).click();

        String mainTabHandle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();
        for(String handle : allHandles)
        {
            if (!handle.equals(mainTabHandle))
                driver.switchTo().window(handle);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)");
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
        addToCartButton.click();
    }
    public static void checkout(WebDriver driver)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input")).click();
    }
}
