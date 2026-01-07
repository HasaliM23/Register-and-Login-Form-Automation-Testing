package RegisterFormTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterFormTest {

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

    public void RegisterFormTesting(){

        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='name']")));
        name.sendKeys("David");

        WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='country']")));
        country.click();

        Select select = new Select(country);

        select.selectByVisibleText("Denmark");

        WebElement hideDR = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='country']")));
        hideDR.click();

        WebElement accType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='account']")));
        accType.click();

        Select selectacc = new Select(accType);

        selectacc.selectByVisibleText("Engineer");

        WebElement hidedrop = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='account']")));
        hidedrop.click();

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
        email.sendKeys("ronny22grenn@gmail.com");

        WebElement psw = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='password']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", psw);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", psw);
        psw.sendKeys("david90#$%");


        WebElement cpsw = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='confirm_password']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cpsw);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cpsw);
        cpsw.sendKeys("david90#$%");

        WebElement signup = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[.='Signup']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signup);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signup);










    }

}
