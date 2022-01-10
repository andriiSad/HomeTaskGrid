package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//ul[@class = 'srp-results srp-list clearfix']/li//h3")
    private List<WebElement> listOfItems;
    @FindBy(xpath = "//li[@class = 'lvprice prc']/span")
    private List<WebElement> listOfItemsPricesWebElements;
    @FindBy(xpath = "//li[@class = 'fake-tabs__item btn']//a[@_sp = 'p2351460.m44506.l8609']")
    private WebElement buyItNowButton;
    @FindBy(xpath = "//h3[@class = 's-item__title']")
    private List<WebElement> listOfNamesWebElement;

    private List<Integer> listOfItemsPricesIntegers;
    private List<String> listOfNamesString;

    private List<Boolean> conformityListOfPrices;
    private List<Boolean> conformityListOfNames;

    public List<Boolean> getConformityListOfNames(String expectedString) {
        setConformityListOfNames(expectedString);
        return conformityListOfNames;
    }

    public void setConformityListOfNames(String expectedString) {
        conformityListOfNames = new ArrayList<>();
        getListOfNamesString();
        listOfNamesString =
                listOfNamesString
                        .stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());
        for (String name : listOfNamesString) {
            conformityListOfNames.add(name.contains(expectedString.toUpperCase()));
        }
    }

    public List<String> getListOfNamesString() {
        setListOfNamesString();
        return listOfNamesString;
    }

    public void setListOfNamesString() {
        listOfNamesString = new ArrayList<>();
        for (WebElement webElement : listOfNamesWebElement) {
            listOfNamesString.add(webElement.getText());
            System.out.println(webElement.getText());
        }
    }


    public List<Integer> getListOfItemsPricesIntegers() {
        setListOfItemsPricesIntegers();
        return listOfItemsPricesIntegers;
    }

    public List<Boolean> getConformityListOfPrices(int minPrice, int maxPrice) {
        setConformityListOfPrices(minPrice, maxPrice);
        return conformityListOfPrices;
    }

    public SearchResultsPage setConformityListOfPrices(int minPrice, int maxPrice) {
        conformityListOfPrices = new ArrayList<>();
        for (int price : getListOfItemsPricesIntegers()) {
            conformityListOfPrices.add(price >= minPrice && price <= maxPrice);
        }
        return this;
    }

    public void setListOfItemsPricesIntegers() {
        listOfItemsPricesIntegers = new ArrayList<>();
        for (WebElement webElement : listOfItemsPricesWebElements) {
            listOfItemsPricesIntegers.add(parseStringPriceToIntPrice(webElement.getText()));
        }
    }

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void listOfItemsIsVisible() {
        listOfItems.get(0).isDisplayed();

    }

    public void listOfItemsPricesIsVisible() {
        listOfItemsPricesWebElements.get(0).isDisplayed();

    }

    public void clickOnFirstItem() {
        listOfItems.get(0).click();
    }

    public void clickOnBuyItNowButton() {
        buyItNowButton.click();
    }


}
