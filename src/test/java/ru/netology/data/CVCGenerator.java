package ru.netology.data;

import static ru.netology.data.DataHelper.faker;
import lombok.Value;

public class CVCGenerator {

    private CVCGenerator(){}

    @Value
    public static class CVCNumber {
        private String CVCNumber;
    }

    // получение кода из 3х цифр
    public static CVCNumber getValidCVCNumber() {
        return new CVCNumber(faker.numerify("###"));
    }

//  Получение кода из 2х цифр
    public static CVCNumber getInvalidCVCNumberWithTwoNumbers() {
        return new CVCNumber(faker.numerify("##"));
    }

//  Получение кода из 1 цифры
    public static CVCNumber  getInvalidCVVNumberWithSingleNumber() {
        return new CVCNumber(faker.numerify("#"));
    }
}