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

public class EmptyPasswordLoginTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod

    public void openLink(){

        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.qabrains.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void verifyEmptyPasswordShowsError(){



        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
        email.sendKeys("qa_testers@qabrains.com");

        WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Login']")));
        signIn.click();

        // Wait for error message
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[.='Password is a required field']")
        ));

        // ASSERT error message
        Assert.assertEquals(errorMsg.getText(), "Password is a required field",
                "Error message not displayed correctly when email is empty — BUG!");



    }
}
