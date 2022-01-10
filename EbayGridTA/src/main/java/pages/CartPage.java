package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    @FindBy(xpath = "//div[@class = 'table']//span/span/span")
    private List<WebElement> listOfItemsInCart;

    @FindBy(xpath = "//button[@data-test-id = 'cart-remove-item']")
    private List<WebElement> removeButtons;

    @FindBy(xpath = "//div[@class = 'empty-cart']")
    private WebElement divOfEmptyCart;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getItemsQuantityInString() {
        return listOfItemsInCart.get(0).getText();
    }

    public void removeAllItemsFromCart() {
        for (WebElement button : removeButtons) {
            button.click();
            waitElementToDisappear(DEFAULT_WAITING_TIME, button);
        }
    }

    public void waitForEmptyCartIsVisible() {
        waitVisibilityOfElement(DEFAULT_WAITING_TIME, divOfEmptyCart);
    }

    public boolean cartIsEmpty() {
        return divOfEmptyCart.isDisplayed();
    }

}
