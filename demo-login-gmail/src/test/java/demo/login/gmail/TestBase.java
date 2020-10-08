package demo.login.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://accounts.google.com/ServiceLogin");
    }
//test comment
    protected void verifyUserSignedIn() {
        String text = driver.findElement(By.cssSelector("h1.x7WrMb")).getText();
        System.out.println(text);
        Assert.assertEquals(text, "Welcome, Olga Bi");
    }

    protected void goToAccountPage() {
        driver.findElement(By.cssSelector("#passwordNext")).click();
    }

    protected void enterPassword(String userPassword, String cssSelector) {
        driver.findElement(By.cssSelector(cssSelector)).click();
        driver.findElement(By.cssSelector("input[name='password']")).clear();
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(userPassword);
    }

    protected void goToPasswordPage() {
        driver.findElement(By.cssSelector("#identifierNext")).click();
    }

    protected void enterEmail(String userEmail) {
        driver.findElement(By.id("identifierId")).click();
        driver.findElement(By.id("identifierId")).clear();
        driver.findElement(By.id("identifierId")).sendKeys(userEmail);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        //if (!"".equals(verificationErrorString)) {
        //fail(verificationErrorString);
        //String verificationErrorString = verificationErrors.toString();
        }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}