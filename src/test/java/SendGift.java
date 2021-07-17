import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SendGift {

    public static void EnterSum(WebDriver driver) {

        driver.findElement(By.cssSelector("input[placeholder=\"הכנס סכום\"]")).sendKeys("200");
        driver.findElement(By.cssSelector("button[gtm=\"בחירה\"")).click();
    }
}
