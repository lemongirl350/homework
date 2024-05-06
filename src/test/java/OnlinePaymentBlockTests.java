import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OnlinePaymentBlockTests {
        private WebDriver driver;

        @BeforeEach
        public void setup() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://www.mts.by/");
        }

        @AfterEach
        public void close() {
            driver.quit();
        }

        @Test
        public void testTextEmptyFields() {
            //Принимаем куки
            WebElement buttonCookie = driver.findElement(By.xpath("//button[@id='cookie-agree']"));
            buttonCookie.click();

            //Услуги связи
            WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='connection-phone']"));
            Assertions.assertEquals("Номер телефона", phoneNumber.getAttribute("placeholder"));

            WebElement sum = driver.findElement(By.xpath("//*[@id='connection-sum']"));
            Assertions.assertEquals("Сумма", sum.getAttribute("placeholder"));

            WebElement email = driver.findElement(By.xpath("//*[@id='connection-email']"));
            Assertions.assertEquals("E-mail для отправки чека", email.getAttribute("placeholder"));

            //Домашний интернет
            WebElement internetPhone = driver.findElement(By.xpath("//*[@id='internet-phone']"));
            Assertions.assertEquals("Номер абонента", internetPhone.getAttribute("placeholder"));

            WebElement internetSum = driver.findElement(By.xpath("//*[@id='internet-sum']"));
            Assertions.assertEquals("Сумма", internetSum.getAttribute("placeholder"));

            WebElement internetEmail = driver.findElement(By.xpath("//*[@id='internet-email']"));
            Assertions.assertEquals("E-mail для отправки чека", internetEmail.getAttribute("placeholder"));

            //Задолженность
            WebElement accountNumber = driver.findElement(By.xpath("//*[@id='score-arrears']"));
            Assertions.assertEquals("Номер счета на 2073", accountNumber.getAttribute("placeholder"));

            WebElement debtSum = driver.findElement(By.xpath("//*[@id='arrears-sum']"));
            Assertions.assertEquals("Сумма", debtSum.getAttribute("placeholder"));

            WebElement debtEmail = driver.findElement(By.xpath("//*[@id='arrears-email']"));
            Assertions.assertEquals("E-mail для отправки чека", debtEmail.getAttribute("placeholder"));

            //Рассрочка
            WebElement accountInstallment = driver.findElement(By.xpath("//*[@id='score-instalment']"));
            Assertions.assertEquals("Номер счета на 44", accountInstallment.getAttribute("placeholder"));

            WebElement installmentSum = driver.findElement(By.xpath("//*[@id='instalment-sum']"));
            Assertions.assertEquals("Сумма", installmentSum.getAttribute("placeholder"));

            WebElement installmentEmail = driver.findElement(By.xpath("//*[@id='instalment-email']"));
            Assertions.assertEquals("E-mail для отправки чека", installmentEmail.getAttribute("placeholder"));
        }

        @Test
        public void testPaymentInfo() {
            //Принимаем куки
            WebElement buttonCookie = driver.findElement(By.xpath("//button[@id='cookie-agree']"));
            buttonCookie.click();

            //Значения для ввода
            String phone = "297777777";
            String amount = "134";

            //Заполнение полей
            WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='connection-phone']"));
            phoneNumber.sendKeys(phone);
            WebElement sum = driver.findElement(By.xpath("//*[@id='connection-sum']"));
            sum.sendKeys(amount);
            WebElement continueButton = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
            continueButton.click();

            //Переключение на фрейм
            WebElement framePayment = driver.findElement(By.xpath("/html/body/div[8]/div/iframe"));
            driver.switchTo().frame(framePayment);

            //Проверка корректности суммы
            WebElement sumText = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div/span[1]"));
            String sumAttribute = sumText.getAttribute("textContent");
            Assertions.assertTrue(sumAttribute.contains(amount));

            WebElement buttonText = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button"));
            String buttonAttribute = buttonText.getAttribute("textContent");
            Assertions.assertTrue(buttonAttribute.contains(amount));

            //Проверка номера телефона
            WebElement payDescription = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/span"));
            String payAttribute = payDescription.getAttribute("textContent");
            Assertions.assertTrue(payAttribute.contains(phone));

            //Проверка надписей в незаполненных полях
            WebElement cardNumber = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label"));
            Assertions.assertEquals("Номер карты", cardNumber.getAttribute("textContent"));

            WebElement duration = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label"));
            Assertions.assertEquals("Срок действия", duration.getAttribute("textContent"));

            WebElement cvc = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label"));
            Assertions.assertEquals("CVC", cvc.getAttribute("textContent"));

            WebElement holderName = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label"));
            Assertions.assertEquals("Имя держателя (как на карте)", holderName.getAttribute("textContent"));

            //Проверка наличия иконок платежных систем, как минимум двух
            List<WebElement> paymentLogos = driver.findElements(By.xpath("//img[contains(@class, 'ng-tns-c60-0 ng')]"));
            Assertions.assertTrue(paymentLogos.size() >= 2);

    }
}
