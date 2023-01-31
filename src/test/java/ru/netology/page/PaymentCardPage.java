package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class PaymentCardPage extends StartPage {

//      селектор для виджета "Оплата по карте"
      private final SelenideElement head = $(byText("Оплата по карте"));

//      селекторы для полей ввода данных
      private final SelenideElement fieldCardNamber = $("[placeholder='0000 0000 0000 0000']");
      private final SelenideElement fieldMonth = $("[placeholder='08']");
      private final SelenideElement fieldYear = $("[placeholder='22']");
      private final SelenideElement fieldUser = $$("[class='.input__control']").get(3);
      private final SelenideElement fieldCVC = $("[placeholder='999']");

//    селектор для кнопки Продолжить
      private final SelenideElement buttonContinue = $(byText("Продолжить"));

//    селекторы для всплывающих окон
      private final SelenideElement successNotification = $(byText("Операция одобрена Банком."));
      private final SelenideElement failNotification = $(byText("Ошибка! Банк отказал в проведении операции."));

//    селекторы для сообщений об ошибках ввода
      private final SelenideElement wrongFormatMessage = $(byText("Неверный формат"));
      private final SelenideElement wrongTermMessage = $(byText("Неверно указан срок действия карты"));
      private final SelenideElement cardExpiredMessage = $(byText("Истёк срок действия карты"));
      private final SelenideElement fieldFillRequiredMessage = $(byText("Поле обязательно для заполнения"));



}
