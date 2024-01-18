import org.openqa.selenium.By;
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

public class EyewearPage {

    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chrome_driver_path");

        driver = new ChromeDriver();
        driver.get("https://sakshi.mirrar.com/");
    }

    @Test(priority = 1)
    public void initalPage() {
        WebElement eyeWearElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-target='Eyewear-grid']")));
        eyeWearElement.click();
        String headingText = eyeWearElement.getText();
        System.out.println(headingText);
    }




    @Test(priority = 2)
    public void verifyEyewearGridElements() {
        // Locate the Eyewear-grid section by ID
        WebElement eyewearGridSection = driver.findElement(By.cssSelector("div#Eyewear-grid-items"));

        // Find all item elements within Eyewear-grid
        List<WebElement> eyewearItems = eyewearGridSection.findElements(By.className("item"));

        // Iterate through each item and print its name
        for (WebElement eyewearItem : eyewearItems) {
            String itemName = eyewearItem.getText();
            System.out.println("Eyewear Item: " + itemName);
        }
    }

    @Test(priority = 3)
    public void tryNowButton(){
        WebElement eyewaerElement = driver.findElement(By.xpath("//*[@id='rigel_glasses']/div[2]/div[1]/button"));

        eyewaerElement.click();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
