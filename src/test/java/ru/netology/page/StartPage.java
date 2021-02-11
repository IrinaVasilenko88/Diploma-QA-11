package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StartPage {
    private SelenideElement heading = $$("h2").findBy(Condition.text("Путешествие дня"));
    private SelenideElement buyButton = $$("button").findBy(Condition.text("Купить"));
    private SelenideElement creditButton = $$("button").findBy(Condition.text("Купить в кредит"));

    public StartPage() {
        heading.shouldBe(Condition.visible);
    }

    public PaymentPage buy() {
        buyButton.click();
        return new PaymentPage();

    }

    public CreditPage buyInCredit() {
        creditButton.click();
        return new CreditPage();
    }
}
