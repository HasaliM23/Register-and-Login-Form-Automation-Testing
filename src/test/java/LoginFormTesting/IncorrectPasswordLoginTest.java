package LoginFormTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class IncorrectPasswordLoginTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void openLink(){
        driver = new ChromeDriver();
        driver.get("https://practice.qabrains.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test

    public void verifyIncorrectPasswordShowsError(){

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
        email.sendKeys("qa_testers@qabrains.com");

        WebElement psw = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        psw.sendKeys("Password12");

        WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Login']")));
        signIn.click();

        // Wait for error message
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[.='Your password is invalid!']")
        ));

// ASSERT error message is displayed
        Assert.assertTrue(errorMsg.isDisplayed(),
                "Error message not shown for incorrect password — BUG!");






    }
}
