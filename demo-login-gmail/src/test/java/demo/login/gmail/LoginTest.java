package demo.login.gmail;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class LoginTest extends TestBase{

    @Test
    public void login() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 15);

        enterEmail("ratamahata.test@gmail.com");
        Thread.sleep(2000);

        goToPasswordPage();
        Thread.sleep(2000);

        enterPassword("L8tmein!", "input[name='password']");
        Thread.sleep(2000);

        goToAccountPage();
        verifyUserSignedIn();
    }

}
