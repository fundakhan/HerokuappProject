package HerokuappTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddRemoveElements {

    public static void main(String[] args) {

        // to set the chrome driver
        WebDriverManager.chromedriver().setup();

        // opening the browser
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().window().maximize();

        WebElement addRemoveButton = driver.findElement(By.linkText("Add/Remove Elements"));
        addRemoveButton.click();

        int n =5; // number of element to be added

        // Add n(delete button) element
        for (int i = 0; i < n; i++) {
            WebElement addNElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
            addNElement.click();
        }


        // Assert that n number of elements exist on the page
        int expectedElementCount = driver.findElements(By.cssSelector("div#elements button.added-manually")).size();
        Assert.assertEquals(n,expectedElementCount);

        driver.quit();

    }
}
