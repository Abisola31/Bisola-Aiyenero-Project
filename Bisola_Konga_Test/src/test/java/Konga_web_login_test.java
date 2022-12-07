import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Konga_web_login_test {

    //Import Selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {

        //Locate where the driver is
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");

        //Open Chrome Browser//
        driver = new ChromeDriver();
        //1. Open Konga Url (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        //Wait globally for full loading
        //2. Maximize Browser
        driver.manage().window().maximize();
        Thread.sleep(4000);

        //Test 1. Verify PageTitle is correct
        String ExpectedPageTitle = "Buy Phones, Fashion, Electronics";
        String ActualPageTitle = driver.getTitle();
        if (ActualPageTitle.contains(ExpectedPageTitle))
            //Pass
            System.out.println("Correct Title");
        else
            //Fail
            System.out.println("Wrong Title");
        Thread.sleep(5000);
    }


    @Test(priority = 0)
    public void InvalidEmail() throws InterruptedException{

        //Test 2. Verify that User cannot login with invalid email

        //3. Click on Login button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        //4.Input email
        driver.findElement(By.id("username")).sendKeys("Bisbee@com");
        //5. Input Password
        driver.findElement(By.id("password")).sendKeys("Password123");
        //6. Click on the Login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
        // Clear data
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
        Thread.sleep(5000);

    }

    @Test(priority = 1)
    public void InvalidMobilenumber() throws InterruptedException{

        //Test 3. Verify that User cannot login with invalid mobile number

        //4.Input mobile number
        driver.findElement(By.id("username")).sendKeys("0185737174");
        //5. Input Password
        driver.findElement(By.id("password")).sendKeys("Password123");
        //6. Click on the Login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
        // Clear data
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
        Thread.sleep(5000);

    }

    @Test (priority = 2)
            public void InvalidPassword () throws InterruptedException {
        //Test 4. Verify that User cannot login with invalid password

        //4.Input email
        driver.findElement(By.id("username")).sendKeys("Bisbee@mailinator.com");
        //5. Input Password
        driver.findElement(By.id("password")).sendKeys("word3");
        //6. Click on the Login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
        // Clear data
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
        Thread.sleep(5000);

    }
        @Test (priority = 3)
        public void Blankfield () throws InterruptedException {
            //Test 5. Verify that User cannot login with at least one blank field

            //4.Input email
            driver.findElement(By.id("username")).sendKeys("Bisbee@mailinator.com");
            //5. Input Password
            driver.findElement(By.id("password")).sendKeys("");
            //6. Click on the Login button
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(5000);
            // Clear data
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("password")).clear();
            Thread.sleep(5000);
        }
            @Test (priority = 4)
            public void PositiveEmaillogin () throws InterruptedException {
                //Test 6. Verify that User can login with valid email and password
                //4.Input email
                driver.findElement(By.id("username")).sendKeys("Bisbee@mailinator.com");
                //5. Input Password
                driver.findElement(By.id("password")).sendKeys("Password123");
                //6. Click on the Login button
                driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
                Thread.sleep(5000);


            }


                @Test (priority = 5)
                public void logoutsuccessfully() throws InterruptedException {

            //Test 8. Verify that when user logout,user is directed to the home page
                    // Click my account
                    WebElement ele= driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span"));
                    Actions act= new Actions(driver);
                    act.moveToElement(ele).perform();
                    Thread.sleep(5000);

            //7. Logout
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
                    String expectedCurrentUrl = "https://www.konga.com/";
                    String actualCurrenturl = driver.getCurrentUrl();
                    if (actualCurrenturl.contains(expectedCurrentUrl))
                        //Pass
                        System.out.println("Correct webpage");
                    else
                        //Fail
                        System.out.println("Wrong webpage");
                    Thread.sleep(5000);
                }


    @AfterTest
    public void closeBrowser(){
        //Quit the browser
        driver.quit();

    }



}
