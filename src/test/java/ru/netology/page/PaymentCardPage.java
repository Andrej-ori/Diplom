package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentCardPage extends StartPage {

//      селектор для виджета "Оплата по карте"
    public final SelenideElement head = $(byText("Оплата по карте"));

//      селекторы для кнопок покупки тура
    private static final SelenideElement buyWithDebitCardButton = $(byText("Купить"));
    private static final SelenideElement buyWithCreditCardButton = $(byText("Купить в кредит"));

//      селекторы для полей ввода данных
    private final ElementsCollection fields = $$(".input__control");
    private final SelenideElement fieldCardNumber = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement fieldMonth = $("[placeholder='08']");
    private final SelenideElement fieldYear = $("[placeholder='22']");
    private final SelenideElement fieldUserName = fields.get(3);
    private final SelenideElement fieldCVC = $("[placeholder='999']");

//    селектор для кнопки Продолжить
    private final SelenideElement buttonContinue = $(byText("Продолжить"));

//    селекторы для всплывающих окон
    private final SelenideElement successNotification = $(byText("Операция одобрена Банком."));
    private final SelenideElement failNotification = $(byText("Ошибка! Банк отказал в проведении операции."));

//    селекторы для сообщений об ошибках ввода
    private final SelenideElement errorFormatMessage = $(byText("Неверный формат"));
    private final SelenideElement errorTermMessage = $(byText("Неверно указан срок действия карты"));
    private final SelenideElement cardExpiredMessage = $(byText("Истёк срок действия карты"));
    private final SelenideElement fieldFillRequiredMessage = $(byText("Поле обязательно для заполнения"));

//    Проверка перехода на форму оплаты по дебетовой карте
    public void paymentCardPageHeader() {
        head.shouldBe(visible);
    }

//    Нажатие кнопоки "Купить в кредит"
    public CreditCardPage playWithCreditCardButton() {
        buyWithCreditCardButton.click();
        return new CreditCardPage();
    }

//    Общая форма для отправки данных
    public void fillTheForm(DataHelper.CardInfo cardInformation) {
        fieldCardNumber.setValue(cardInformation.getNumber());
        fieldMonth.setValue(cardInformation.getMonth());
        fieldYear.setValue(cardInformation.getYear());
        fieldUserName.setValue(cardInformation.getUser());
        fieldCVC.setValue(cardInformation.getCvc());
        buttonContinue.click();
    }

//    Проверка видимости всплывающего окна "Операция одобрена Банком."
    public void successNotificationPaymentCardPage() {
        successNotification.shouldBe(visible, Duration.ofSeconds(15));
    }

//    Проверка видимости всплывающего окна "Ошибка! Банк отказал в проведении операции."
    public void failNotificationPaymentCardPage() {
        failNotification.shouldBe(visible, Duration.ofSeconds(15));

    }


    public void  errorFormatMessageCardPage() {
        errorFormatMessage.shouldBe(visible);
    }
}