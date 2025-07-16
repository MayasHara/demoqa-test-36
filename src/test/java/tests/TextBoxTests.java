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
