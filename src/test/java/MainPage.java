import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainPage {


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static class BuyMeSanityTest {

        public static WebDriver driver;


        private static ExtentReports extent;


        private static ExtentTest test;



        @BeforeClass
        public static void runBeforeClass() throws Exception {

            String report = System.getProperty("user.dir");
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(report + "\\extent.html");
            // attach report
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            // name your test and add description
            test = extent.createTest("BuyMeTest", "BuyMe Test");

            // log results
            test.log(Status.INFO, "@Start_BuyMeTest");

            try {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\ben10\\Downloads\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                test.log(Status.PASS, "Driver established successfully");
            } catch (Exception e) {
                e.printStackTrace();
                test.log(Status.FAIL, "Driver connection failed! " + e.getMessage());
                throw new Exception("Driver failed");
            }
            driver.manage().window().maximize(); //maximize window.
            driver.get("http://buyme.co.il");

//            String type = getData("browserType");
//            if (type.equals("Chrome")) {
//                System.setProperty("webdriver.chrome.driver", "C:\\Users\\ben10\\Downloads\\chromedriver.exe");
//                driver = new ChromeDriver();
//            } else if (type.equals("FireFox")) {
//                System.setProperty("webdriver.gecko.driver", "C:\\Users\\ben10\\Downloads\\geckodriver.exe");
//                driver = new FirefoxDriver();
//            }
        }


        @Test
        public void a1_HomeScreenTests() throws IOException, InterruptedException {
            HomeScreen.SelectCategorys(driver);
            test.pass("test_a1", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\ben10\\Downloads\\"  + new Random())).build());
        }


        @Test // Registration Screen/Login Tests
        public void a5_RegistrationScreenTests() throws Exception {
            RegistrationScreen.Registration(driver);
            test.pass("test_a5", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\ben10\\Downloads\\" + new Random())).build());
        }


        @Test
        public void a2_ChooseGift() throws IOException {

            ChooseA_Gift.ChooseAgift(driver);
            test.pass("test_a2", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\ben10\\Downloads\\" + new Random())).build());
        }

        @Test
        public void a3_SendGift() throws IOException {
            SendGift.EnterSum(driver);
            test.pass("test_a3", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\ben10\\Downloads\\" + new Random())).build());
        }

        @Test
        public void a4_purchaseGift() throws IOException {
            InfoScreen.purchasefirststep(driver);
            InfoScreen.sendSms(driver);
            InfoScreen.sendPhoneNumbers(driver);

            test.pass("test_a4", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\ben10\\Downloads\\" + new Random())).build());
        }


            @AfterClass
            public static void after() {
            test.log(Status.INFO, "@After test " + "After test method");
            //driver.quit();
            extent.flush();
            }

        private static String getData(String keyName) throws Exception {
            ClassLoader classLoader = MainPage.class.getClassLoader();
            String xmlFilePath = String.valueOf(new File(classLoader.getResource("data.xml").getFile()));
            File fXmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            return doc.getElementsByTagName(keyName).item(0).getTextContent();
        }


            private static String takeScreenShot(String ImagesPath) {   // definition of screenshot fnc
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("C:\\Users\\ben10\\Downloads\\File1.png");
            try {
                FileUtils.copyFile(screenShotFile, destinationFile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return ImagesPath+".png";
        }
        }

    }



