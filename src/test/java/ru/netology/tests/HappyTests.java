package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.*;
import ru.netology.page.*;

import static com.codeborne.selenide.Selenide.*;
import static ru.netology.data.DataHelper.*;

public class HappyTests {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("allure");
    }

        /*
          ОТКРЫТИЕ СРАНИЦЫ; ПЕРХОД НА ФОРМЫ ДЛЯ ЗАПАЛНЕНИЯ ДАННЫХ; ПЕРЕХОД С ФОРМЫ НА ФОРМУ

№1.     Открытие страницы "Путишествие Дня"
         */
    @Test
    void shouldVoidStartPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        startPage.startPageHedar();
    }
        /*
№2.     Переход на форму оплаты по дебитовой карте
        */
    @Test
    void shouldVoidPaymentCardPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        paymentCardPage.paymentCardPageHeader();
    }

        /*
№3.     Переход на форму оплаты Тура в кредит
        */
    @Test
    void shouldVoidCreditCardPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        creditCardPage.creditCardPageHeader();

    }

        /*
№4.     Переход с формы оплаты по дебитовой карте на форму оплаты тура в кредит при нажатии кнопки "Купить в кредит"
        */
    @Test
    void shouldVoidCreditCardPageAfterPaymentCardPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var creditCardPage = paymentCardPage.playWithCreditCardButton();
        creditCardPage.creditCardPageHeader();

    }

        /*
№5.     Переход с формы покупки тура в кредит на форму оплаты по дебитовой карте при нажатии кнопки "Купить"
        */
    @Test
    void shouldVoidPaymentCardPageAfterCreditCardPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var paymentCardPage = creditCardPage.playWithDebitCardButton();
        paymentCardPage.paymentCardPageHeader();
    }

      /*
                    ТЕСТЫ ДЛЯ ОДОБРЕННОЙ КАРТЫ

                 ФОРМА ДЛЯ ПОКУПКИПО ДЕБИТОВОЙ КАРТЕ

№6.    Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
       Одобреный номер карты; валидный год, валидный месяц,
       Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
       */
    @Test
    void shouldValidDebitCardApprovedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoApprovedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.successNotificationPaymentCardPage();

//       TODO Добавить проверку по базе данных

    }

        /*
№7.     Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
        Одобреный номер карты; Текущий год, Текущий  месяц,
        Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
         */
    @Test
    void shouldCurrentDateDebitCardApprovedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoCurrentDateApprovedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.successNotificationPaymentCardPage();

//       TODO Добавить проверку по базе данных

    }

       /*
№8.    Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
       Одобреный номер карты; валидный год, валидный месяц,
       Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код
       */
    @Test
    void shouldValidDebitCardInfoWithTwoWordsNameThroughSpaceApprovedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughSpaceApprovedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.successNotificationPaymentCardPage();

//       TODO Добавить проверку по базе данных

    }

       /*
№9.    Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
       Одобреный номер карты; валидный год, валидный месяц,
       Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
       */

    @Test
    void shouldValidDebitCardInfoWithTwoWordsNameThroughHyphenApprovedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughHyphenApprovedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);

//       TODO Добавить проверку по базе данных

    }

        /*
                    ФОРМА ДЛЯ ПОКУПКИ В КРЕДИТ

№10.   Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
       Одобреный номер карты; валидный год, валидный месяц,
       Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
       */
    @Test
    void shouldValidCreditCardApprovedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoApprovedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.successNotificationCreditCardPage();

//       TODO Добавить проверку по базе данных

    }
       /*
№11.   Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
       Одобреный номер карты; Текущий год, Текущий  месяц,
       Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
       */
    @Test
    void shouldCurrentDateCreditCardApprovedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoCurrentDateApprovedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.successNotificationCreditCardPage();
//       TODO Добавить проверку по базе данных

    }

       /*
№12.   Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
       Одобреный номер карты; валидный год, валидный месяц,
       Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код
       */
    @Test
    void shouldValidCreditCardInfoWithTwoWordsNameThroughSpaceApprovedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughSpaceApprovedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.successNotificationCreditCardPage();

//       TODO Добавить проверку по базе данных

    }

        /*
№13.   Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
       Одобреный номер карты; валидный год, валидный месяц,
       Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
        */
    @Test
    void shouldValidCreditCardInfoWithTwoWordsNameThroughHyphenApprovedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughHyphenApprovedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.successNotificationCreditCardPage();

//       TODO Добавить проверку по базе данных

    }
        /*
                      ТЕСТЫ ДЛЯ ЗАБЛОКИРОВАННОЙ КАРТЫ

                    ФОРМА ДЛЯ ОПЛАТЫ ПО ДЕБИТОВОЙ КАРТЕ

№14.   Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
       Заблокированный номер карты; валидный год, валидный месяц,
       Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
       */
    @Test
    void shouldValidDebitCardDeclinedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoDeclinedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.failNotificationPaymentCardPage();

//       TODO Добавить проверку по базе данных

    }

        /*
№15.    Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
        Заблокированный номер карты; Текущий год, Текущий  месяц,
        Валидное имя владельца(Латиница Верхний регистр), валидный CVC код

        */
    @Test
    void shouldCurrentDateDebitCardDeclinedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoCurrentDateDeclinedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.failNotificationPaymentCardPage();

//       TODO Добавить проверку по базе данных

    }
        /*
№16.    Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
        Заблокированный номер карты; валидный год, валидный месяц,
        Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код
        */
    @Test
    void shouldValidDebitCardInfoWithTwoWordsNameThroughSpaceDeclinedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughSpaceDeclinedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.failNotificationPaymentCardPage();


//       TODO Добавить проверку по базе данных

    }

       /*
№17.   Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
       Заблокированный номер карты; валидный год, валидный месяц,
       Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
        */
    @Test
    void shouldValidDebitCardInfoWithTwoWordsNameThroughHyphenDeclinedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughHyphenDeclinedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.failNotificationPaymentCardPage();

//       TODO Добавить проверку по базе данных

    }

           /*

                        ФОРМА ДЛЯ ПОКУПКИ В КРЕДИТ

№18.       Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
           Заблокированный номер карты; валидный год, валидный месяц,
           Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
           */
    @Test
    void shouldValidCreditCardDeclinedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoDeclinedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.failNotificationCreditCardPage();

//       TODO Добавить проверку по базе данных

    }

           /*
№19.       Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
           Заблокированный номер карты; Текущий год, Текущий  месяц,
           Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
           */
    @Test
     void shouldCurrentDateCreditCardDeclinedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoCurrentDateDeclinedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.failNotificationCreditCardPage();

//       TODO Добавить проверку по базе данных

    }

           /*
№20.       Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
           Заблокированный номер карты; валидный год, валидный месяц,
           Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код
           */
    @Test
    void shouldValidCreditCardInfoWithTwoWordsNameThroughSpaceDeclinedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughSpaceDeclinedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.failNotificationCreditCardPage();

//       TODO Добавить проверку по базе данных

    }

          /*
№21.      Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
          Заблокированный номер карты; валидный год, валидный месяц,
          Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
          */
    @Test
    void shouldValidCreditCardInfoWithTwoWordsNameThroughHyphenDeclinedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughHyphenDeclinedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.failNotificationCreditCardPage();

//       TODO Добавить проверку по базе данных

    }

        /*
                      ТЕСТЫ ДЛЯ СЛУЧАЙНОЙ КАРТЫ

                    ФОРМА ДЛЯ ОПЛАТЫ ПО ДЕБИТОВОЙ КАРТЕ

№22.   Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
       Случайный номер карты; валидный год, валидный месяц,
       Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
       */

    @Test
    void shouldValidDebitCardRandomCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoRandomCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.failNotificationPaymentCardPage();

//       TODO Добавить проверку по базе данных

    }


    /*
№23.    Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
        Случайный номер карты; Текущий год, Текущий  месяц,
        Валидное имя владельца(Латиница Верхний регистр), валидный CVC код

    */
    @Test
    void shouldCurrentDateDebitCardRandomCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoCurrentDateRandomCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.failNotificationPaymentCardPage();

//       TODO Добавить проверку по базе данных

    }
    /*
№24.    Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
        Случайный номер карты; валидный год, валидный месяц,
        Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код
    */
    @Test
    void shouldValidDebitCardInfoWithTwoWordsNameThroughSpaceRandomCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughSpaceRandomCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.failNotificationPaymentCardPage();


//       TODO Добавить проверку по базе данных

    }

        /*
№25.    Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
        Случайный номер карты; валидный год, валидный месяц,
        Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
        */
    @Test
    void shouldValidDebitCardInfoWithTwoWordsNameThroughHyphenRandomCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughHyphenRandomCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.failNotificationPaymentCardPage();

//       TODO Добавить проверку по базе данных

    }

        /*

                 ФОРМА ДЛЯ ПОКУПКИ В КРЕДИТ

№26.    Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
        Случайный номер карты; валидный год, валидный месяц,
        Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
        */
    @Test
    void shouldValidCreditCardRandomCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoRandomCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.failNotificationCreditCardPage();

//       TODO Добавить проверку по базе данных

    }

        /*
№27.    Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
        Случайный номер карты; Текущий год, Текущий  месяц,
        Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
        */
    @Test
    void shouldCurrentDateCreditCardRandomCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoCurrentDateRandomCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.failNotificationCreditCardPage();

//       TODO Добавить проверку по базе данных

    }

        /*
№28.    Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
        Случайный номер карты; валидный год, валидный месяц,
        Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код
        */
    @Test
    void shouldValidCreditCardInfoWithTwoWordsNameThroughSpaceRandomCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughSpaceRandomCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.failNotificationCreditCardPage();

//       TODO Добавить проверку по базе данных

    }

        /*
№29.    Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
        Случайный номер карты; валидный год, валидный месяц,
        Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
        */
    @Test
    void shouldValidCreditCardInfoWithTwoWordsNameThroughHyphenRandomCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughHyphenRandomCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.failNotificationCreditCardPage();

//       TODO Добавить проверку по базе данных

    }

}
