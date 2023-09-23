package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage
{
    public CartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    WebDriver driver;
    @FindBy(how = How.XPATH, using = "//*[@id=\"sc-buy-box-ptc-button\"]/span/input")
    WebElement checkoutButton;

    public void checkOut()
    {
        checkoutButton.click();
    }
}
