import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class OnlinePaymentBlockTests {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        // Закрытие браузера после каждого теста
        driver.quit();
    }

    @Test
    public void testBlockTitle() {
        // Открываем страницу сайта
        driver.get("https://www.mts.by/");

        // Находим элемент с названием блока
        WebElement blockTitle = driver.findElement(By.xpath("//h2[text()='Онлайн пополнение без комиссии']"));

        // Проверяем, что название блока соответствует ожидаемому
        Assertions.assertEquals("Онлайн пополнение без комиссии", blockTitle.getText());
    }

    @Test
    public void testPaymentLogos() {
        // Открываем страницу сайта
        driver.get("https://www.mts.by/");

        // Находим элементы с логотипами платёжных систем
        List<WebElement> paymentLogos = driver.findElements(By.xpath("//img[@alt='Логотип платежной системы']"));

        // Проверяем, что найдено как минимум 2 логотипа
        Assertions.assertTrue(paymentLogos.size() >= 2);
    }

    @Test
    public void testServiceDetailsLink() {
        // Открываем страницу сайта
        driver.get("https://www.mts.by/");

        // Находим ссылку "Подробнее о сервисе"
        WebElement serviceDetailsLink = driver.findElement(By.linkText("Подробнее о сервисе"));

        // Кликаем на ссылку
        serviceDetailsLink.click();

        // Проверяем, что открылась ожидаемая страница
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.mts.by/pay/online-payment/"));
    }

    @Test
    public void testContinueButton() {
        // Открываем страницу сайта
        driver.get("https://www.mts.by/");

        // Находим поле ввода номера телефона
        WebElement phoneInput = driver.findElement(By.id("phone"));

        // Вводим тестовый номер телефона
        phoneInput.sendKeys("297777777");

        // Находим кнопку "Продолжить"
        WebElement continueButton = driver.findElement(By.xpath("//button[text()='Продолжить']"));

        // Кликаем на кнопку
        continueButton.click();

        // Проверяем, что открылась ожидаемая страница
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.mts.by/pay/online-payment/services/"));
    }
}
