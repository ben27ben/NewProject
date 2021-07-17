import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InfoScreen{


        public static void purchasefirststep(WebDriver driver){

           // driver.findElement(By.xpath("//*[@id=\"ember1829\"]")).click();
            driver.findElement(By.className("ember-text-field")).click();
            driver.findElement(By.xpath("//*[@id=\"ember1833\"]")).sendKeys("דודו");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1500)");
            driver.findElement(By.xpath("//*[@id=\"ember1900\"]/div/div[1]")).click();
            driver.findElement(By.cssSelector("#ember1940")).click();
            driver.findElement(By.xpath("//*[@id=\"ember1840\"]/textarea")).clear();
            driver.findElement(By.xpath("//*[@id=\"ember1840\"]/textarea")).sendKeys(Constants.enterBlessings);
            driver.findElement(By.cssSelector("input[type=file")).sendKeys(Constants.picPath);
            driver.findElement(By.cssSelector("button[gtm=המשך]")).click();

    }
    public static void sendSms (WebDriver driver){
        driver.findElement( By.cssSelector( Constants.sendSmsLocator ) ).click();
    }
    static void sendPhoneNumbers (WebDriver driver) {

        List<WebElement> elements = driver.findElements( By.xpath( Constants.phoneFieldsLocator ) );
        elements.get( 0 ).sendKeys( "0524104510" );

        driver.findElement(By.xpath(Constants.senderNamelocator)).sendKeys(Constants.senderName);
        driver.findElement(By.cssSelector(Constants.senderphonenumlocator)).sendKeys(Constants.senderphonenum);
        Assert.assertEquals(Constants.senderName, "בן");
        System.out.println(Constants.senderName);
        Assert.assertEquals(Constants.recieverName, "שמעון");
        System.out.println(Constants.recieverName );
        driver.findElement( By.xpath( Constants.continuetocheckout ) ).click();
    }
}
