import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
    private WebDriver wd;
    @Before
    public void setUp()
    {
        wd = new FirefoxDriver();
        String url = "https://www.wp.pl/";
        String userName = "userName";
        String userPass = "UserPass";
    }

    @Test
    public void LoginNegative()
    {
        wd.get(url);
        wd.findElement(By.partialLinkText("Poczta")).click();

        WebElement loginName = wd.findElement(By.name("login_username"));
        loginName.clear();
        loginName.sendKeys(userName);

        WebElement loginPass = wd.findElement(By.id("password"));
        loginPass.clear();
        loginPass.sendKeys(userPass);

        wd.findElement(By.xpath("//input[@value='Zaloguj się']")).click();
    }

    @After
    public void tearDown()
    {
        if(wd != null) {
            wd.close();
        }
    }
}
