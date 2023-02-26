package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataBaseHelper;

import static ru.netology.data.API.getCreditStatus;
import static ru.netology.data.API.getPaymentStatus;
import static ru.netology.data.CardNumberGenerator.getApprovedCardStatus;
import static ru.netology.data.CardNumberGenerator.getDeclinedCardStatus;
import static ru.netology.data.DataHelper.getValidCardInfoApprovedCardNumber;
import static ru.netology.data.DataHelper.getValidCardInfoDeclinedCardNumber;

public class APITest {

    @BeforeAll
    static void setUpAfterAll() {
        DataBaseHelper.setDown();
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true).savePageSource(true));
    }

    @BeforeEach
    public void setUp() {
        DataBaseHelper.setDown();
    }

    @AfterAll
    static void tearDownAfterAll() {
        SelenideLogger.removeListener("allure");
    }

    @DisplayName("API тест для одобренной карты для формы оплаты по дедитовой карте")
    @Test
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    void shouldGetStatusForApprovedCardNumberWithValidPaymentPage() {
        var validApprovedCard = getValidCardInfoApprovedCardNumber();
        var status = getPaymentStatus(validApprovedCard);
        Assertions.assertEquals(getApprovedCardStatus(), status.getStatus());
    }

    @DisplayName("API тест для одобренной карты для формы покупки тура в кредит")
    @Test
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    void shouldGetStatusForApprovedCardNumberWithValidCreditPage() {
        var validApprovedCard = getValidCardInfoApprovedCardNumber();
        var status = getCreditStatus(validApprovedCard);
        Assertions.assertEquals(getApprovedCardStatus(), status.getStatus());
    }

    @DisplayName("API тест для заблокированной карты для формы оплаты по дедитовой карте")
    @Test
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    void shouldGetStatusForDeclinedCardNumberWithValidPaymentPage() {
        var validDeclinedCard = getValidCardInfoDeclinedCardNumber();
        var status = getPaymentStatus(validDeclinedCard);
        Assertions.assertEquals(getDeclinedCardStatus(), status.getStatus());
    }

    @DisplayName("API тест для заблокированной карты для формы покупки тура в кредит")
    @Test
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    void shouldGetStatusForDaclinedCardNumberWithValidCreditPage() {
        var validDeclinedCard = getValidCardInfoDeclinedCardNumber();
        var status = getCreditStatus(validDeclinedCard);
        Assertions.assertEquals(getDeclinedCardStatus(), status.getStatus());
    }
}
