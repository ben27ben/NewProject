import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChooseA_Gift {

    public static void ChooseAgift(WebDriver driver) {


        Assert.assertEquals( Constants.HomeScreenUrl, driver.getCurrentUrl());
        System.out.println( "This is the new Current URL " + driver.getCurrentUrl() );
        System.out.println( "The older URL was " + Constants.HomeScreenUrl );

        List<WebElement> elements = driver.findElements(By.className(Constants.selectBusinessLocator ));
        elements.get(1).click();

    }

}
