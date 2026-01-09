package FormSubmissionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class EmptyCredentialswithSubmitTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod

    public void openLink(){

        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.qabrains.com/form-submission");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void verifyEmptyCredentialsShowError(){

        WebElement submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[.='Submit ']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",submit);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",submit);


    }
}
