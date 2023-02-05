package ru.netology.data;

import static ru.netology.data.DataHelper.faker;

public class CardNumberGenerator {
    private CardNumberGenerator() {}

//    номер одобренной карты
    public static String ApprovedCardNumber() {
        return "4444 4444 4444 4441";
    }

//    номер заблокированной карты
    public static String DeclinedCardNumber() {
        return "4444 4444 4444 4442";
    }

//    номер случайной карты
    public static String InvalidCardNumber() {
        return faker.numerify("#### #### #### ####");
    }

//    Номер карты с 12 цифрами
    public static String InvalidFormatCardNumber() {
        return "#### #### ####";
    }
}