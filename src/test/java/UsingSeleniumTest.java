import org.testng.annotations.Test;
import org.testng.junit.IJUnitTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


import static org.testng.AssertJUnit.assertEquals;

public class UsingSeleniumTest {
    WebDriver driver = new ChromeDriver();

    @Test(description = "step1, sendkeys and click button")
    public void sendkeysClick() {

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        assertEquals("Web form", title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

    }

    @Test(description = "step2, assert and std out result",dependsOnMethods = "sendkeysClick")
    public void assertStdout(){
        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        assertEquals("Received!", value);
        System.out.println("----------------------------------------------------");
        System.out.println("result: " + value);
        System.out.println("----------------------------------------------------");

        driver.quit();
    }

}