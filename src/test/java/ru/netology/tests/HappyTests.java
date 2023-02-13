package ru.netology.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.BaseSelenideTest;
import ru.netology.page.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataHelper.*;

public class HappyTests extends BaseSelenideTest {

    /*
          ОТКРЫТИЕ СРАНИЦЫ; ПЕРХОД НА ФОРМЫ ДЛЯ ЗАПАЛНЕНИЯ ДАННЫХ; ПЕРЕХОД С ФОРМЫ НА ФОРМУ

    №1.     Открытие страницы "Путишествие Дня"
         */
    @DisplayName("Открытие Начальной страницы")
    @Test
    @AllureId("1")
    @Feature("ОТКРЫТИЕ СТРАНИЦЫ; ПЕРЕХОД НА ФОРМЫ ДЛЯ ЗАПОЛНЕНИЯ ДАННЫХ; ПЕРЕХОД С ФОРМЫ НА ФОРМУ")
    @Epic("ОТКРЫТИЕ СТРАНИЦЫ")
    @Story("Открытие страницы \"Путишествие Дня\"")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проходит проверка открытия стартовой страницы")
    void shouldVoidStartPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        startPage.startPageHedar();
    }

    /*
№2.     Переход на форму оплаты по дебитовой карте
    */
    @DisplayName("Переход на форму оплаты по дебитовой карте")
    @Test
    @AllureId("2")
    @Feature("ОТКРЫТИЕ СТРАНИЦЫ; ПЕРЕХОД НА ФОРМЫ ДЛЯ ЗАПОЛНЕНИЯ ДАННЫХ; ПЕРЕХОД С ФОРМЫ НА ФОРМУ")
    @Epic("ПЕРЕХОД НА ФОРМЫ ДЛЯ ЗАПОЛНЕНИЯ ДАННЫХ")
    @Story("Переход на форму оплаты по дебитовой карте")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка на открытие формы для оплаты тура по дебитовой карте")
    void shouldVoidPaymentCardPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        paymentCardPage.paymentCardPageHeader();
    }

    /*
№3.     Переход на форму оплаты Тура в кредит
    */
    @DisplayName("Переход на форму оплаты Тура в кредит")
    @Test
    @AllureId("3")
    @Feature("ОТКРЫТИЕ СТРАНИЦЫ; ПЕРЕХОД НА ФОРМЫ ДЛЯ ЗАПОЛНЕНИЯ ДАННЫХ; ПЕРЕХОД С ФОРМЫ НА ФОРМУ")
    @Epic("ПЕРЕХОД НА ФОРМЫ ДЛЯ ЗАПОЛНЕНИЯ ДАННЫХ")
    @Story("Переход на форму оплаты Тура в кредит")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка на открытие формы для покупки тура в кредит по данным карты")
    void shouldVoidCreditCardPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        creditCardPage.creditCardPageHeader();

    }

    /*
№4.     Переход с формы оплаты по дебитовой карте на форму оплаты тура в кредит при нажатии кнопки "Купить в кредит"
    */
    @DisplayName("Переход с формы оплаты по дебитовой карте на форму оплаты тура в кредит при нажатии кнопки \"Купить в кредит\"")
    @Test
    @AllureId("4")
    @Feature("ОТКРЫТИЕ СТРАНИЦЫ; ПЕРЕХОД НА ФОРМЫ ДЛЯ ЗАПОЛНЕНИЯ ДАННЫХ; ПЕРЕХОД С ФОРМЫ НА ФОРМУ")
    @Epic("ПЕРЕХОД С ФОРМЫ НА ФОРМУ")
    @Story("Переход с формы оплаты по дебитовой карте на форму оплаты тура в кредит при нажатии кнопки \"Купить в кредит\"\n")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Провека переключения с формы оплаты по дебитовой карте на форму оплаты тура в кредит при нажатии кнопки \"Купить в кредит\"n")
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
    @DisplayName("Переход с формы покупки тура в кредит на форму оплаты по дебитовой карте при нажатии кнопки \"Купить\"")
    @Test
    @AllureId("5")
    @Feature("ОТКРЫТИЕ СТРАНИЦЫ; ПЕРЕХОД НА ФОРМЫ ДЛЯ ЗАПОЛНЕНИЯ ДАННЫХ; ПЕРЕХОД С ФОРМЫ НА ФОРМУ")
    @Epic("ПЕРЕХОД С ФОРМЫ НА ФОРМУ")
    @Story("Переход с формы покупки тура в кредит на форму оплаты по дебитовой карте при нажатии кнопки \"Купить\"")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка переключения с формы покупки тура в кредит на форму оплаты по дебитовой карте при нажатии кнопки \"Купить\"")
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
    @DisplayName("Форма: Дебит; Номер карты: Одобренный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("6")
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("ДЕБИТОВАЯ КАРТА")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
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
    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("7")
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("ДЕБИТОВАЯ КАРТА")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; Текущий год, Текущий  месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
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
    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через пробел, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("8")
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("ДЕБИТОВАЯ КАРТА")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
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

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через дефис, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("9")
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("ДЕБИТОВАЯ КАРТА")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
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
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("10")
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("КРЕДИТНАЯ КАРТА")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ данными")
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
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("11")
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("КРЕДИТНАЯ КАРТА")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; Текущий год, Текущий  месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ данными")
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
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через пробел, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("12")
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("КРЕДИТНАЯ КАРТА")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ даннымид")
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
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через дефис, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("13")
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("КРЕДИТНАЯ КАРТА")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ даннымид")
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
    @DisplayName("Форма: Дебит; Номер карты: Заблокированный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("14")
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("ДЕБИТОВАЯ КАРТА")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
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
    @DisplayName("Форма: Дебит; Номер карты: Заблокированный; Дата(год): Текущий; Дата(Месяц): Текущий; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("15")
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("ДЕБИТОВАЯ КАРТА")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; Текущий год, Текущий  месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
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
    @DisplayName("Форма: Дебит; Номер карты: Заблокированный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через пробел, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("16")
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("ДЕБИТОВАЯ КАРТА")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
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
    @DisplayName("Форма: Дебит; Номер карты: Заблокированный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через дефис, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("17")
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("ДЕБИТОВАЯ КАРТА")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
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
    @DisplayName("Форма: Кредит; Номер карты: Заблокированный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("18")
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("КРЕДИТНАЯ КАРТА")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ даннымид")
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
    @DisplayName("Форма: Кредит; Номер карты: Заблокированный; Дата(год): Текущий; Дата(Месяц): Текущий; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("19")
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("КРЕДИТНАЯ КАРТА")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; Текущий год, Текущий  месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ даннымид")
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
    @DisplayName("Форма: Кредит; Номер карты:  Заблокированный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через пробел, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("20")
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("КРЕДИТНАЯ КАРТА")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ даннымид")
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
    @DisplayName("Форма: Кредит; Номер карты:  Заблокированный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через дефис, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("21")
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("КРЕДИТНАЯ КАРТА")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ даннымид")
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

    @DisplayName("Форма: Дебит; Номер карты: Случайный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("22")
    @Feature("СЛУЧАЙНАЯ КАРТА")
    @Epic("ДЕБИТОВАЯ КАРТА")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Случайный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
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
    @DisplayName("Форма: Дебит; Номер карты: Случайный; Дата(год): Текущий; Дата(Месяц): Текущий; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("23")
    @Feature("СЛУЧАЙНАЯ КАРТА")
    @Epic("ДЕБИТОВАЯ КАРТА")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Случайный номер карты; Текущий год, Текущий  месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
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
        Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
    */
    @DisplayName("Форма: Дебит; Номер карты: Случайный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через пробел, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("24")
    @Feature("СЛУЧАЙНАЯ КАРТА")
    @Epic("ДЕБИТОВАЯ КАРТА")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Случайный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
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
    @DisplayName("Форма: Дебит; Номер карты: Случайный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через дефис, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("25")
    @Feature("СЛУЧАЙНАЯ КАРТА")
    @Epic("ДЕБИТОВАЯ КАРТА")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Случайный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
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
    @DisplayName("Форма: Кредит; Номер карты: Случайный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("26")
    @Feature("СЛУЧАЙНАЯ КАРТА")
    @Epic("КРЕДИТНАЯ КАРТА")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Случайный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ даннымид")
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
    @DisplayName("Форма: Кредит; Номер карты: Случайный; Дата(год): Текущий; Дата(Месяц): Текущий; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("27")
    @Feature("СЛУЧАЙНАЯ КАРТА")
    @Epic("КРЕДИТНАЯ КАРТА")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Случайный номер карты; Текущий год, Текущий  месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ даннымид")
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
    @DisplayName("Форма: Кредит; Номер карты: Случайный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через пробел, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("28")
    @Feature("СЛУЧАЙНАЯ КАРТА")
    @Epic("КРЕДИТНАЯ КАРТА")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Случайный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ даннымид")
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
    @DisplayName("Форма: Кредит; Номер карты: Случайный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через дефис, Верхний регистр; CVC: Валидный")
    @Test
    @AllureId("29")
    @Feature("СЛУЧАЙНАЯ КАРТА")
    @Epic("КРЕДИТНАЯ КАРТА")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Случайный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ даннымид")
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
