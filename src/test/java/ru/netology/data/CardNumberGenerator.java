package ru.netology.data;

import com.sun.xml.bind.v2.TODO;

import static ru.netology.data.DataHelper.faker;

public class CardNumberGenerator {
    private CardNumberGenerator() {
    }

//    номер одобренной карты

//    TODO: написать код для обращения к базе данных чтоб номер карты брать из базы
//          например:
//          нужен номер одобренной карты = идем в базу, смотрим одобреную карту и берем ее номер
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
}
