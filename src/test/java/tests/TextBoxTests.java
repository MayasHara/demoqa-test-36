package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Chmo");
        $("#userEmail").setValue("Chmo@mail.ru");
        $("#currentAddress").setValue("chmoshnaia");
        $("#permanentAddress").setValue("cmoshnii");
        $("#submit").click();

        $("#output").$("#name").shouldHave(text("Chmo"));
        $("#output #email").shouldHave(text("Chmo@mail.ru"));
        $("#output #currentAddress").shouldHave(text("chmoshnaia"));
        $("#output #permanentAddress").shouldHave(text("cmoshnii"));

    }
}
