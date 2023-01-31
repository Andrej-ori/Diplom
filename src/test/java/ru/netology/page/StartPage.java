package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class StartPage {
    private static final SelenideElement buyWithDebitCardButton = $(byText("Купить"));
    private static final SelenideElement buyWithCreditCardButton = $(byText("Купитьв кредит"));

    public PaymentCardPage playWithDebitCard() {
        buyWithDebitCardButton.click();
        return new PaymentCardPage();
    }

    public CreditCardPage playWithCreditCardButton() {
        buyWithCreditCardButton.click();
        return new CreditCardPage();
    }

}
