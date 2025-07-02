package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private SelenideElement firstName = $("#userName"),
            eMail = $("#userEmail"),
            address = $("#currentAddress"),
            permanentAdress = $("#permanentAddress"),
            submitData = $("#submit");


    public TextBoxPage openPage() {
        open("");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        return this;
    }


    public TextBoxPage setFirstName(String value) {
        firstName.setValue(value);

        return this;
    }


    public TextBoxPage setEmail(String value) {
        eMail.setValue(value);

        return this;
    }

    public TextBoxPage setAddress(String value) {
        address.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAdress.setValue(value);

        return this;
    }

    public TextBoxPage sendData (String value){
        submitData.click();

        return this;
    }

    public TextBoxPage checkResult (String value){
        $("#output").shouldHave(text(value));
        $("#output").shouldHave(text(value));
        $("#output").shouldHave(text(value));
        $("#output").shouldHave(text(value));

        return this;
    }
}

