package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;
import java.util.Locale;

public class UserGenerator {
    private UserGenerator(){
    }

    public static Faker fakerEn = new Faker(new Locale("en"));
    public static Faker fakerRu = new Faker(new Locale("ru"));
    public static Faker fakerCN = new Faker(new Locale("zh_CN"));

//    Имя на Латинице верхний регистр
    public static User getValidNameInUppercase() {
        return new User(fakerEn.name().fullName().toUpperCase());
    }

//    Имя на Латинице через пробел в верхнем регистре
    public static User getValidNameInUppercaseSeparatedBySpace() {
        return new User(fakerEn.name().lastName().toUpperCase() + " " + fakerEn.name().fullName().toUpperCase());
    }

//    Имя на Латинице через дефис Верхний регистр
    public static User getValidNameInUppercaseSeparatedByHyphen() {
        return new User(fakerEn.name().lastName().toUpperCase() + "-" + fakerEn.name().fullName().toUpperCase());
    }

//    Имя на Латинице, Первая заглавная остальные строчные
    public static User getInvalidNameInLowercase() {
        return new User(fakerEn.name().fullName());
    }

//    Имя на кирилице
    public static User getInvalidNameInCirillic() {
        return new User(fakerRu.name().fullName());
    }


//    Имя с цифрой
    public static User getInvalidNameWithNambers() {
        return new User(fakerEn.name().fullName() + fakerEn.numerify("#"));
    }

//    Имя из спецсимволов
    public static User getInvalidNameWithSymbol() {
        return new User(fakerEn.regexify("._%=+-!@][&^()*#;:{8}"));
    }


//    Имя из иероглифов
    public static User getInvalidNameInCN() {
        return new User(fakerCN.name().fullName());
    }


    @Value
    public static class User {
        private String userName;
    }
}
