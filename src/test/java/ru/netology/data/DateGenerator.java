package ru.netology.data;

import lombok.Value;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static ru.netology.data.DataHelper.faker;

public class DateGenerator {
    private DateGenerator() {}

    @Value
    public static class Date{
        private String year;
        private String month;

    }

    private static final LocalDate actualDate = LocalDate.now();
    static DateTimeFormatter monthTimeFormatter = DateTimeFormatter.ofPattern("MM");
    static DateTimeFormatter yearTimeFormatter = DateTimeFormatter.ofPattern("yy");

    // Получение текущей даты (год и месяц)
    public static Date getCurrentDate() {
        return new Date(actualDate.format(yearTimeFormatter), actualDate.format(monthTimeFormatter));
    }
    /*
    Получение валидной даты (с текущей даты до +5 лет с текущей даты.
    Если год будет увеличен на 5 лет, то значение месяца не будет превышать текущее значение
    Если год останется прежним, то значение месяца будет не меньше текущего
    */
    public static Date getValidDate() {
        int numberOfYeatsAdded = faker.number().numberBetween(0, 5);
        Month month = Month.of(faker.number().numberBetween(1, 12));
        if (numberOfYeatsAdded == 5) {
            month = actualDate.minusMonths(faker.number()
                    .numberBetween(0, actualDate.getMonth().getValue() - 1)).getMonth();
        } else {
            if (numberOfYeatsAdded == 0) {
                month = actualDate.plusMonths(faker.number()
                        .numberBetween(1, 12 - actualDate.getMonth().getValue())).getMonth();
            }
        }
        LocalDate newDate = LocalDate.of(actualDate.plusYears(numberOfYeatsAdded).getYear(),
                    month, actualDate.getDayOfMonth());
        return new Date(newDate.format(yearTimeFormatter), newDate.format(monthTimeFormatter));
    }

    //Получение значение года на +5 лет
    public static Date getDateWithExpirationMoreThatFiveYears() {
        int numberOfYearsAdded = faker.number().numberBetween(6, 99 - Integer.valueOf(actualDate.format(yearTimeFormatter)));
        return new Date(actualDate.plusYears(numberOfYearsAdded).format(yearTimeFormatter), actualDate.format(monthTimeFormatter));
    }

    //Получение прошлых лет
    public static Date getDateWithPreviousYears() {
        int numberYearsDeducted = faker.number().numberBetween(1, Integer.valueOf(actualDate.format(yearTimeFormatter)));
        return new Date(actualDate.minusYears(numberYearsDeducted).format(yearTimeFormatter), actualDate.format(monthTimeFormatter));
    }

    // получение прошлых месяцев
    public static Date getDateWithPreviousMonths() {
        String month = actualDate.format(monthTimeFormatter);
        String year;
        if (month.equals("01")) {
            month = "12";
            year = actualDate.minusYears(1).format(yearTimeFormatter);
        }else {
            int numberMonthDeducted = faker.number().numberBetween(1, actualDate.getMonth().getValue() - 1);
            month = actualDate.withMonth(numberMonthDeducted).format(monthTimeFormatter);
            year = actualDate.format(yearTimeFormatter);
        }
        return new Date(year, month);
    }

    //Получение не валидных заначений для месяца (13-99)
    public static Date getDateWithInvalidMonthInfo() {
        int number = faker.number().numberBetween(13, 99);
        String month = String.valueOf(number);
        return new Date(actualDate.format(yearTimeFormatter), month);
    }

//    Получение не валидных значений для месяца (00)
    public static Date getDateWithInvalidMonthInfo00() {
        String month = "00";
        return new Date(actualDate.format(yearTimeFormatter), month);
    }

//    получение не валидных значений для месяца(одна цифра)
    public static Date getDateWithInvalidMonthInfoOneNamber() {
        int number = faker.number().numberBetween(0, 9);
        String month = String.valueOf(number);
        return new Date(actualDate.format(yearTimeFormatter), month);
    }

    //Получение не валидных значений для года (0-9 (одна цифра))
    public static Date getDateWithInvalidYearInfo() {
        int number = faker.number().numberBetween(0, 9);
        String year = String.valueOf(number);
        return new Date(year, actualDate.format(monthTimeFormatter));
    }
}
