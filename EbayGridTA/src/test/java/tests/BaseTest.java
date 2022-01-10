package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.*;
import utils.CapabilityFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private CapabilityFactory capabilityFactory = new CapabilityFactory();
    public static final long DEFAULT_WAITING_TIME = 15;

    private static final String EBAY_URL = "https://www.ebay.com/";

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://192.168.1.229:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        getDriver().manage().window().maximize();
        getDriver().get(EBAY_URL);
        getDriver().manage().timeouts().implicitlyWait(DEFAULT_WAITING_TIME, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @AfterClass
    void terminate() {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(getDriver());
    }

    public CartPage getCartPage() {
        return new CartPage(getDriver());
    }

    public ItemPage getItemPage() {
        return new ItemPage(getDriver());
    }

    public AdvancedSearchPage getAdvancedSearchPage() {
        return new AdvancedSearchPage(getDriver());
    }

    public SneakersPage getSneakersPage() {
        return new SneakersPage(getDriver());
    }

}
