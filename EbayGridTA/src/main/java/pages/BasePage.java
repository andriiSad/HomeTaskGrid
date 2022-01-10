package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {
    WebDriver driver;
    public static final long DEFAULT_WAITING_TIME = 15;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }


    public void waitVisibilityOfElement(long timeToWaitInSeconds, WebElement element) {
        new WebDriverWait(driver, timeToWaitInSeconds).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementToDisappear(long timeToWaitInSeconds, WebElement element) {
        new WebDriverWait(driver, timeToWaitInSeconds).until(ExpectedConditions.invisibilityOf(element));
    }

    public int parseStringPriceToIntPrice(String stringPrice) {
        StringBuilder sb = new StringBuilder(stringPrice);
        sb.deleteCharAt(0);
        sb.setLength(sb.length() - 3);
        return Integer.parseInt(sb.toString());
    }

    public void switchDriverToNewTab(int tabIndex) {
        List<String> tabsWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsWindows.get(tabIndex));
    }

}
