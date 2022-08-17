import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    @Test
     public void check(){



        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver() ;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://next.privat24.ua/mobile");


        By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
        By amount = By.xpath("//input[@data-qa-node='amount']");

        By numberCard = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By expDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By submitBtn = By.xpath("//button[@data-qa-node='submit']");
        By name = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        By surname = By.xpath("//input[@data-qa-node='lastNamedebitSource']");


        driver.findElement(phoneNumber).sendKeys("677013326");
        driver.findElement(amount).sendKeys(Keys.CONTROL+"A");
        driver.findElement(amount).sendKeys("55");
        driver.findElement(numberCard).sendKeys("4552331448138217");
        driver.findElement(expDate).sendKeys("1129");
        driver.findElement(cvv).sendKeys("112");
        driver.findElement(name).sendKeys("Vadym");
        driver.findElement(surname).sendKeys("Potorzhynkyi");
        driver.findElement(submitBtn).submit();




        By recipient = By.xpath("//span[@data-qa-node='nameB']");
        By card = By.xpath("//td[@data-qa-node='card']");
        By details = By.xpath("//*[contains(@data-qa-node,'details')]");
        By category = By.xpath("//div[@data-qa-node='category']");
        By amountUAH = By.xpath("//div[@data-qa-node='amount']");


       Assertions.assertEquals("Kyivstar Ukraine", driver.findElement(recipient).getText());
       Assertions.assertEquals("4552 **** **** 8217", driver.findElement(card).getText());
       Assertions.assertEquals("Поповнення телефону. На номер +380677013326", driver.findElement(details).getText());
       Assertions.assertEquals("55 UAH", driver.findElement(amountUAH).getText());
       Assertions.assertEquals("Поповнення мобільного", driver.findElement(category).getText());



    }
}
