package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class ProductPage
{
    public ProductPage(WebDriver driver)
    {
        this.driver = driver;
    }

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"add-to-cart-button\"]")
    WebElement addToCartButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")
    WebElement cartButton;

    public void switchToProductPage()
    {
        String mainTabHandle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();

        for(String h : allHandles)
        {
            if(!h.equals(mainTabHandle)) driver.switchTo().window(h);
        }
    }
    public void addToCart()
    {
        addToCartButton.click();
    }

    public void openCart()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
    }
}
