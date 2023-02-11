package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.*;
import ru.netology.page.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataHelper.*;

public class NegativeTests {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true).savePageSource(true));
    }

    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("allure");
    }

        /*
            ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ

№1.     Отправка формы покупки по дебитовой карте с пустыми полями
        */
    @Test
    void shouldDebitCardInfoWithEmptyData() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getCardInfoWithEmptyData();
        paymentCardPage.fillTheForm(validCardInfo);
//        paymentCardPage.
    }
}
