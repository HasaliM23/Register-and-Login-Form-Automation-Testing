package RegisterFormTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PasswordFieldMaskTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void openLink() {
        driver = new ChromeDriver();
        driver.get("https://practice.qabrains.com/registration");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void VerifyPasswordFieldIsMasked() {

        WebElement passwordField = wait.until(
                d -> d.findElement(By.id("password"))
        );

        // Check the input type
        String typeAttribute = passwordField.getAttribute("type");

        // Assert it is "password" (masked)
        Assert.assertEquals(typeAttribute, "password",
                "Password field is not masked!");
    }
}
