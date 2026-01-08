package FormSubmissionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormSubmitwithValidDataTest {

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

    public void verify_thatForm_Submit_With_valid_Data() {

        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='name']")));
        name.sendKeys("Kolin");

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
        email.sendKeys("KolinWagen@gmail.com");

        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='contact']")));
        phone.sendKeys("90-894-789-23");

        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='date']")));
        date.sendKeys("20/01/2026");






    }

}
