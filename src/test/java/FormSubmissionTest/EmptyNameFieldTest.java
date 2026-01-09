package FormSubmissionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class EmptyNameFieldTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void openLink() {
        driver = new ChromeDriver();
        driver.get("https://practice.qabrains.com/form-submission");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
 @Test
    public void verifyEmptyNameShowsRequiredMessage() {


        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
        email.sendKeys("KolinWagen@gmail.com");

        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='contact']")));
        phone.sendKeys("09786543124");

        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='date']")));
        date.sendKeys("01/20/2026");

        // Upload file (absolute path)

        String data = "C:\\Users\\INTEL\\Downloads\\User.png";

        WebElement UploadFile = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='file']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", UploadFile);

        UploadFile.sendKeys(data);


        WebElement color = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='Red']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", color);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", color);

        WebElement food = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='Pizza']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", food);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", food);

        WebElement country = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='country']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", country);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", country);

        Select select = new Select(country);
        select.selectByVisibleText("Denmark");


        WebElement submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[.='Submit ']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);

     // Wait for error message
     WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
             By.xpath("//p[.='Name is a required field']")
     ));

     // ASSERT error message
     Assert.assertEquals(errorMsg.getText(), "Name is a required field",
             "Error message not displayed correctly when email is empty — BUG!");


    }






    }
