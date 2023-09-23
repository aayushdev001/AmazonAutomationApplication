package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoggedInHomePage
{
    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"twotabsearchtextbox\"]")
    WebElement searchBox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"nav-search-submit-button\"]")
    WebElement searchSubmitButton;

    public void setSearchText(String searchText)
    {
        searchBox.sendKeys(searchText);
    }

    public void submitSearch()
    {
        searchSubmitButton.click();
    }
}
