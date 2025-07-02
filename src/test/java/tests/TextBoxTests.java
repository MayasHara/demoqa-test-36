package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

  TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/text-box";
    }

//    @Test
//    void fillFormTest() {
//        open("");
//        $("#userName").setValue("QA");
//        $("#userEmail").setValue("QA@mail.ru");
//        $("#currentAddress").setValue("Пушкина");
//        $("#permanentAddress").setValue("Russia");
//        $("#submit").click();
//
//        $("#output").$("#name").shouldHave(text("QA"));
//        $("#output #email").shouldHave(text("QA@mail.ru"));
//        $("#output #currentAddress").shouldHave(text("Пушкина"));
//        $("#output #permanentAddress").shouldHave(text("Russia"));
//
//    }


    @Test
    void textBoxWithPageObjectTest(){
        textBoxPage.openPage()
                .setFirstName("QA")
                .setEmail("QA@mail.ru")
                .setAddress("Пушкина")
                .setPermanentAddress("Russia")
                .sendData("Send");

        textBoxPage.checkResult("QA")
                .checkResult("QA@mail.ru")
                .checkResult("Пушкина")
                .checkResult("Russia");
    }
}
