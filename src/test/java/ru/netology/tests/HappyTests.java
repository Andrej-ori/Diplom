package ru.netology.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.*;
import ru.netology.page.*;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataHelper.*;
import static ru.netology.data.SQLHelper.getPaymentStatus;

public class HappyTests {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("allure");
    }

//   №1.Открытие страницы "Путишествие Дня"
    @Test
    void shouldVoidStartPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
    }

//   №2. Переход на форму оплаты по дебитовой карте
    @Test
    void shouldVoidPaymentCardPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        paymentCardPage.paymentCardPageHeader();
    }

//    №3. Переход на форму оплаты Тура в кредит
    @Test
    void shouldVoidCreditCardPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        creditCardPage.creditCardPageHeader();

    }

//    №4. Переход с формы оплаты по дебитовой карте на форму оплаты тура в кредит при нажатии кнопки "Купить в кредит"
    @Test
    void shouldVoidCreditCardPageAfterPaymentCardPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var creditCardPage = paymentCardPage.playWithCreditCardButton();
        creditCardPage.creditCardPageHeader();

    }

//    №5. Переход с формы покупки тура в кредит на форму оплаты по дебитовой карте при нажатии кнопки "Купить"
    @Test
    void shouldVoidPaymentCardPageAfterCreditCardPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var paymentCardPage = creditCardPage.playWithDebitCardButton();
        paymentCardPage.paymentCardPageHeader();
    }

//   №6. Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
//    Одобреный номер карты; валидный год, валидный месяц,
//    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    @Test
    void shouldValidDebitCardApproved() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfo();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.successNotificationCardPage();

        assertEquals("Approved", getPaymentStatus());
    }

}
