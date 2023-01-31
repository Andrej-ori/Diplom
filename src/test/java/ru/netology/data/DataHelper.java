package ru.netology.data;

import lombok.Value;
import com.github.javafaker.Faker;

import java.util.Locale;

import static ru.netology.data.CardNumberGenerator.*;
import static ru.netology.data.DateGenerator.*;
import static ru.netology.data.UserGenerator.*;
import static ru.netology.data.CVCGenerator.*;
public class DataHelper {
    private DataHelper() {}

    @Value
    public static class  CardInfo{
        private String number;
        private String year;
        private String month;
        private String user;
        private String cvc;
    }

    public static Faker faker = new Faker(new Locale("en"));

//    ВАЛИДНЫЕ ДАННЫЕ

//    Отправка валидных данных (Одобреный номер карты; валидный год, валидный месяц,
//    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    public static CardInfo getValidCardInfo() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDate().getYear(),
                getValidDate().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    Отправка валидных данных (Одобреный номер карты; валидный год, валидный месяц,
//    Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код
    public static CardInfo getValidCardInfoWithTwoWordsNameThroughSpace() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDate().getYear(),
                getValidDate().getMonth(),
                getValidNameInUppercaseSeparatedBySpace().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    Отправка валидных данных (Одобреный номер карты; валидный год, валидный месяц,
//    Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
    public static CardInfo getValidCardInfoWithTwoWordsNameThroughHyphen() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDate().getYear(),
                getValidDate().getMonth(),
                getValidNameInUppercaseSeparatedByHyphen().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    Отправка Валидных данных (Одобренный номер карты; текущий год, текущий месяц,
//    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    public static CardInfo getValidCardInfoCurrentDate() {
        return new CardInfo(ApprovedCardNumber(),
                getCurrentDate().getYear(),
                getCurrentDate().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    НЕ ВАЛИДНЫЕ ДАННЫЕ

//    ИМЯ ВЛАДЕЛЬЦА КАРТЫ

//    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
//    Не валидное имя владельца(Латиница Первая заглавная остальные строчные),
//    валидный CVC код
    public static CardInfo getInvalidCardInfoNameLowercase() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDate().getYear(),
                getValidDate().getMonth(),
                getInvalidNameInLowercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
//    Не валидное имя владельца(Кириллица), валидный CVC код

    public static CardInfo getInvalidCardInfoNameInCirillic() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDate().getYear(),
                getValidDate().getMonth(),
                getInvalidNameInCirillic().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
//    Не валидное имя владельца(Имя с цифрой), валидный CVC код
    public static CardInfo getInvCardInfoNameWithNamber() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDate().getYear(),
                getValidDate().getMonth(),
                getInvalidNameWithNambers().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
//    Не валидное имя владельца(Имя из спецсимволов), валидный CVC код
    public static CardInfo getInvCardInfoNameWithSymbol() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDate().getYear(),
                getValidDate().getMonth(),
                getInvalidNameWithSymbol().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
//    Не валидное имя владельца(Имя из иероглифов), валидный CVC код
    public static CardInfo getInvCardInfoNameInCN() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDate().getYear(),
                getValidDate().getMonth(),
                getInvalidNameInCN().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    ДАТА (ГОД)

//    Отправка НЕ валидных данных (Одобреный номер карты; год оканчания действия больше чем через 5 лет,
//    валидный месяц, Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    public static CardInfo getInvalidCardInfoDateWithExpirationMoreThatFiveYears() {
        return new CardInfo(ApprovedCardNumber(),
                getDateWithExpirationMoreThatFiveYears().getYear(),
                getDateWithExpirationMoreThatFiveYears().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    Отправка НЕ валидных данных (Одобреный номер карты; год действия карты истек,
//    валидный месяц, Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    public static CardInfo getInvCardInfoDateWithPreviousYears() {
        return new CardInfo(ApprovedCardNumber(),
                getDateWithPreviousYears().getYear(),
                getDateWithPreviousYears().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    Отправка НЕ валидных данных (Одобреный номер карты; Не валидное значение года (одна цифра),
//    текущий месяц, Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    public static CardInfo getInvalidCardInfoDateWithInvalidYearInfo() {
        return new CardInfo(ApprovedCardNumber(),
                getDateWithInvalidYearInfo().getYear(),
                getDateWithInvalidYearInfo().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    ДАТА (МЕСЯЦ)

//    Отправка НЕ валидных данных (Одобреный номер карты; текущий год,
//    месяц действия карты истек , Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    public static CardInfo getInvCardInfoDateWithPreviousMonths() {
        return new CardInfo(ApprovedCardNumber(),
                getDateWithPreviousMonths().getYear(),
                getDateWithPreviousMonths().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    Отправка НЕ валидных данных (Одобреный номер карты; текущий год, Не валидное значение месяца(13-99)
//    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    public static CardInfo getInvCardInfoDateWithInvalidMonthInfo() {
        return new CardInfo(ApprovedCardNumber(),
                getDateWithInvalidMonthInfo().getYear(),
                getDateWithInvalidMonthInfo().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    Отправка НЕ валидных данных (Одобреный номер карты; текущий год, Не валидное значение месяца(00)
//    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    public static CardInfo getInvalidCardInfoDateWithInvalidMonthInfo00() {
        return new CardInfo(ApprovedCardNumber(),
                getDateWithInvalidMonthInfo00().getYear(),
                getDateWithInvalidMonthInfo00().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    Отправка НЕ валидных данных (Одобреный номер карты; текущий год, Не валидное значение месяца(одна цифра),
//    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
        public static CardInfo getInvalidCardInfoDateWithInvalidMonthInfoOneNamber() {
            return new CardInfo(ApprovedCardNumber(),
                    getDateWithInvalidMonthInfoOneNamber().getYear(),
                    getDateWithInvalidMonthInfoOneNamber().getMonth(),
                    getValidNameInUppercase().getUserName(),
                    getValidCVCNumber().getCVCNumber());
        }

//        CVC КОД

//    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
//    Валидное имя владельца(Латиница Верхний регистр), НЕ валидный CVC код(две цифры)
    public static CardInfo getInvalidCardInfoCVCNumberWithTwoNumbers() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDate().getYear(),
                getValidDate().getMonth(),
                getValidNameInUppercase().getUserName(),
                getInvalidCVCNumberWithTwoNumbers().getCVCNumber());
    }

//    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
//    Валидное имя владельца(Латиница Верхний регистр), НЕ валидный CVC код(одна цифра)
    public static CardInfo getInvalidCardInfoCVCNumberWithSingleNumber() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDate().getYear(),
                getValidDate().getMonth(),
                getValidNameInUppercase().getUserName(),
                getInvalidCVVNumberWithSingleNumber().getCVCNumber());
    }

//    КАРТЫ

//    Отправка НЕ валидных данных (Заблокированный номер карты; валидный год, валидный месяц,
//    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    public static CardInfo getInvalidCardInfoDeclinedCardNumber() {
        return new CardInfo(DeclinedCardNumber(),
                getValidDate().getYear(),
                getValidDate().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    Отправка НЕ валидных данных (Случайный номер карты; валидный год, валидный месяц,
//    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    public static CardInfo getInvalidCardInfoInvalidCardNumber() {
        return new CardInfo(InvalidCardNumber(),
                getValidDate().getYear(),
                getValidDate().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    ПУСТЫЕ ПОЛЯ

//    Отправка формы с пустыми полями
    public static CardInfo getCardInfoWithEmptyData() {
        return new CardInfo("",
                "",
                "",
                "",
                "");
    }

//    Отправка НЕ валидных данных (пустая форма всесто номера карты; валидный год, валидный месяц,
//    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    public static CardInfo getCardInfoWithEmptyCardNumber() {
        return new CardInfo("",
                getValidDate().getYear(),
                getValidDate().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    Отправка НЕ валидных данных (Одобреный номер карты; Пустая форма в поле Год, валидный месяц,
//    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    public static CardInfo getCardInfoWithEmptyYear() {
        return new CardInfo(ApprovedCardNumber(),
                "",
                getValidDate().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }
//    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, Пустая форма в поле Месяц,
//    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    public static CardInfo getCardInfoWithEmptyMonth() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDate().getYear(),
                "",
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

//    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
//    Пустая форма в поле Владелец, валидный CVC код
    public static CardInfo getCardInfoWithEmptyUser() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDate().getYear(),
                getValidDate().getMonth(),
                "",
                getValidCVCNumber().getCVCNumber());
    }

//    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
//    Валидное имя владельца(Латиница Верхний регистр), Пустая форма в поле CVC код
    public static CardInfo getCardInfoWithEmptyCVC() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDate().getYear(),
                getValidDate().getMonth(),
                getValidNameInUppercase().getUserName(),
                "");
    }
}