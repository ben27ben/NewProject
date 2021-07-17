//import freemarker.template.utility.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeScreen {

   public static void SelectCategorys(WebDriver driver ) throws InterruptedException {
       JavascriptExecutor js = (JavascriptExecutor) driver;
       Thread.sleep(2000);
       js.executeScript("window.scrollBy(0,2000)");
       List<WebElement> findDropDown = driver.findElements(By.className("chosen-single"));
       findDropDown.get(0).click();
       List<WebElement> findSum = driver.findElements(By.className("active-result"));
       findSum.get(3).click();
       findDropDown.get(1).click();
       List<WebElement> findRegion = driver.findElements(By.className("active-result"));
       findRegion.get(1).click();
       findDropDown.get(2).click();
       List<WebElement> findCategory = driver.findElements(By.className("active-result"));
       findCategory.get(2).click();
       //driver.findElement(By.xpath("//*[@id=\"ember1650\"]")).click();
       driver.findElement(By.id("ember1038")).click();
   }

    }






