package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;


public class StartPage {

//    селекторы для кнопок покупки тура
    private static final SelenideElement buyWithDebitCardButton = $(byText("Купить"));
    private static final SelenideElement buyWithCreditCardButton = $(byText("Купить в кредит"));

//   селектор для виджета "Путишествие дня"
    private static final SelenideElement hedar = $(withText("Путешествие дня"));

//   Проверка открытия страницы
    public void startPageHedar() {
        hedar.shouldBe(visible);
    }

//    Нажатие кнопок покупки
    public PaymentCardPage playWithDebitCardButton() {
        buyWithDebitCardButton.click();
        return new PaymentCardPage();
    }

    public CreditCardPage playWithCreditCardButton() {
        buyWithCreditCardButton.click();
        return new CreditCardPage();
    }

}
