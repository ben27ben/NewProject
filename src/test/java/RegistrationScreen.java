import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationScreen {

    public static void Registration(WebDriver driver) {
        //driver.findElement(By.xpath("seperator-link")).click();
        driver.findElement(By.xpath("//*[@id=\"ember882\"]/div/div[1]/div/div/div[3]/div[1]/span")).click();
        List<WebElement> findDropDown = driver.findElements(By.className("ember-text-field"));
        (findDropDown.get(0)).sendKeys("Ben");
        findDropDown.get(1).sendKeys("benben123@dadu.com");
        findDropDown.get(2).sendKeys("Bb12345678");
        findDropDown.get(3).sendKeys("Bb12345678");
        WebElement elementToClick = driver.findElement(By.xpath("//*[@id=\"ember2061\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementToClick);
        //driver.findElement(By.className("label")).click();
    }
    }



