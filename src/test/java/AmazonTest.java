import Pages.*;
import net.bytebuddy.build.Plugin;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class AmazonTest extends TestBase
{
    @Test
    @Order(1)
    public void signIn()
    {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.openSignInWindow();
        homePage.setUsername("9452361808");
        homePage.setPassword("blackberryz3");
    }
    @Test
    @Order(2)
    public void search()
    {
        LoggedInHomePage page = PageFactory.initElements(driver, LoggedInHomePage.class);
        page.setSearchText("lg 1.5 ton air conditioner");
        page.submitSearch();
    }
    @Test
    @Order(3)
    public void openProduct()
    {
        SearchResultsPage page = PageFactory.initElements(driver, SearchResultsPage.class);
        page.openProductPage();
    }
    @Test
    @Order(4)
    public void addToCart()
    {

        ProductPage page = PageFactory.initElements(driver, ProductPage.class);
        page.switchToProductPage();
        page.addToCart();
        page.addToCart();
        page.openCart();
    }
    @Test
    @Order(5)
    public void checkOut()
    {
        CartPage page = PageFactory.initElements(driver, CartPage.class);
        page.checkOut();
    }
}
