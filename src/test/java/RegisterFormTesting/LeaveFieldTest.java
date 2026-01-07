package RegisterFormTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LeaveFieldTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void openLink(){
        driver = new ChromeDriver();
        driver.get("https://practice.qabrains.com/registration");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test

    public void VerifyClickSignupWithoutEnterData(){


        WebElement signup = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[.='Signup']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signup);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signup);

        WebElement errorMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[.='Name is a required field']")
                )
        );

        Assert.assertTrue(errorMsg.isDisplayed(),
                "Validation message is NOT displayed");

    }
}
