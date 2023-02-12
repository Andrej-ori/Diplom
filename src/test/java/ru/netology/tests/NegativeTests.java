package ru.netology.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.BaseSelenideTest;
import ru.netology.page.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataHelper.*;

public class NegativeTests extends BaseSelenideTest {

    /*
        ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ

        ДЕБИТОВАЯ КАРТА

№1.     Отправка формы покупки по дебитовой карте со всеми пустыми полями
    */
    @DisplayName("Форма: Дебит; Номер карты: Пусто; Дата(год):  Пусто; Дата(Месяц): Пусто; Имя: Пусто; CVC: Пусто")
    @Test
    @Epic("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Feature("ДЕБИТОВАЯ КАРТА")
    @Story("Отправка формы покупки по дебитовой карте со всеми незаполненными полями")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы со всеми пустыми полями")
    void shouldPaymentCardPagedInfoWithEmptyData() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getCardInfoWithEmptyData();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.fillAllField();
    }

    /*
№2.             Отправка НЕ валидных данных (пустая форма всесто номера карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код

     */
    @DisplayName("Форма: Дебит; Номер карты: Пусто; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Epic("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Feature("ДЕБИТОВАЯ КАРТА")
    @Story("Отправка формы покупки по дебитовой карте с пустым полем Номера карты")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем Номера карты")
    void shouldPaymentCardPageWithEmptyCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getCardInfoWithEmptyCardNumber();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.fillCardNumberRequest();
    }

    /*
№3.    Отправка НЕ валидных данных (Одобреный номер карты; Пустая форма в поле Год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
     */
    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Пусто; Дата(Месяц): Валидный; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Epic("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Feature("ДЕБИТОВАЯ КАРТА")
    @Story("Отправка формы покупки по дебитовой карте с пустым полем Год")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем Год")
    void shouldPaymentCardPageWithEmptyYear() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getCardInfoWithEmptyYear();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.fillRequest();
    }

    /*
№4.     Отправка НЕ валидных данных (Одобреный номер карты; валидный год, Пустая форма в поле Месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
     */
    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Пусто; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Epic("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Feature("ДЕБИТОВАЯ КАРТА")
    @Story("Отправка формы покупки по дебитовой карте с пустым полем Месяц")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем Месяц")
    void shouldPaymentCardPageWithEmptyMonth() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getCardInfoWithEmptyMonth();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.fillRequest();
    }

    /*
№5.         Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Пустая форма в поле Владелец, валидный CVC код
     */
    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Пусто; CVC: Валидный")
    @Test
    @Epic("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Feature("ДЕБИТОВАЯ КАРТА")
    @Story("Отправка формы покупки по дебитовой карте с пустым полем Владелец")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем Владелец")
    void shouldPaymentCardPageWithEmptyUser() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getCardInfoWithEmptyUser();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.fillRequest();
    }

    /*
№6              Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), Пустая форма в поле CVC код
     */
    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница Верхний регистр; CVC: Пусто")
    @Test
    @Epic("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Feature("ДЕБИТОВАЯ КАРТА")
    @Story("Отправка формы покупки по дебитовой карте с пустым полем CVC")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем CVC")
    void shouldPaymentCardPageWithEmptyCVC() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getCardInfoWithEmptyUser();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.fillCVCRequest();
    }

    /*
            КРЕДИТНАЯ КАРТА

№7.     Отправка формы покупки в кредит со всеми  пустыми полями

     */
    @DisplayName("Форма: Кредит; Номер карты: Пусто; Дата(год): Пусто; Дата(Месяц): Пусто; Имя: Пусто; CVC: Пусто")
    @Test
    @Epic("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Feature("КРЕДИТНАЯ КАРТА")
    @Story("Отправка формы покупке в кредит со всеми незаполненными полями")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы со всеми пустыми полями")
    void shouldCreditCardPagedInfoWithEmptyData() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getCardInfoWithEmptyData();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.fillAllField();
    }


    /*
№8.             Отправка НЕ валидных данных (пустая форма всесто номера карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код

     */
    @DisplayName("Форма: Кредит; Номер карты: Пусто; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Epic("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Feature("КРЕДИТНАЯ КАРТА")
    @Story("Отправка формы покупке в кредит с пустым полем Номера карты")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем Номера карты")
    void shouldCreditCardPageWithEmptyCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getCardInfoWithEmptyCardNumber();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.fillCardNumberRequest();
    }

    /*
№9.    Отправка НЕ валидных данных (Одобреный номер карты; Пустая форма в поле Год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
     */
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Пусто; Дата(Месяц): Валидный; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Epic("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Feature("КРЕДИТНАЯ КАРТА")
    @Story("Отправка формы покупке в кредит с пустым полем Год")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем Год")
    void shouldCreditCardPageWithEmptyYear() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getCardInfoWithEmptyYear();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.fillRequest();
    }

    /*
№10.     Отправка НЕ валидных данных (Одобреный номер карты; валидный год, Пустая форма в поле Месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
     */
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Пусто; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Epic("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Feature("КРЕДИТНАЯ КАРТА")
    @Story("Отправка формы покупке в кредит с пустым полем Месяц")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем Месяц")
    void shouldCreditCardPageWithEmptyMonth() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getCardInfoWithEmptyMonth();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.fillRequest();
    }

    /*
№11.         Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Пустая форма в поле Владелец, валидный CVC код
     */
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Пусто; CVC: Валидный")
    @Test
    @Epic("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Feature("КРЕДИТНАЯ КАРТА")
    @Story("Отправка формы покупке в кредит с пустым полем Владелец")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем Владелец")
    void shouldCreditCardPageWithEmptyUser() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getCardInfoWithEmptyUser();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.fillRequest();
    }

    /*
№12              Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), Пустая форма в поле CVC код
     */
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница Верхний регистр; CVC: Пусто")
    @Test
    @Epic("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Feature("КРЕДИТНАЯ КАРТА")
    @Story("Отправка формы покупке в кредит с пустым полем CVC")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем CVC")
    void shouldCreditCardPageWithEmptyCVC() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getCardInfoWithEmptyUser();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.fillCVCRequest();
    }

    /*
                ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ МЕСЯЦ НЕ ВАЛИДНЫМИ ДАННЫМИ

        ЗАПОЛНЕНИЕ ПОЛЯ МЕСЯЦ ЗНАЧЕНИЯМИ ВЫХОДЯЩИМИ ЗА ГРАНИЦЫ ВАЛИДНЫХ ЗНАЧЕНИЙ (00; 13-19)

        ДЕБИТОВАЯ КАРТА
     */

    @DisplayName("Форма: Дебит; Номер карты: Пусто; Дата(год):  Пусто; Дата(Месяц): Пусто; Имя: Пусто; CVC: Пусто")
    @Test
    @Epic("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Feature("ДЕБИТОВАЯ КАРТА")
    @Story("Отправка формы покупки по дебитовой карте со всеми незаполненными полями")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы со всеми пустыми полями")
    void shouldPaymentCardPagedInfoWithEmptyData() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getCardInfoWithEmptyData();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.fillAllField();
    }

}
