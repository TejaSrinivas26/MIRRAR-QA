import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class tabElements {
    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chrome_driver_path");

        driver = new ChromeDriver();
        driver.get("https://sakshi.mirrar.com/");
    }
    @Test(priority = 1)
    public void tabElement(){
        WebElement tabHeader = driver.findElement(By.id("tabs-header"));

        List<WebElement> tabElements = tabHeader.findElements(By.className("tab"));

        for(WebElement tabElement : tabElements){
            // Check if the tab element is clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(tabElement));

            // Perform the click action
            tabElement.click();
        }
    }

    @Test(priority = 2)
    public void performSearch() {
        WebElement searchBox = driver.findElement(By.id("searchBar"));
        searchBox.sendKeys("set");

        // Press Enter after typing the search query
        searchBox.sendKeys(Keys.ENTER);

        // Wait for the search results to load (adjust the condition based on your application)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Sets-grid")));

        // Find and count the number of elements with class "content" and "grid"
        List<WebElement> gridElements = driver.findElements(By.cssSelector(".content.grid"));

        int numberOfGridElements = gridElements.size();

        System.out.println("Number of grid elements: " + numberOfGridElements);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
