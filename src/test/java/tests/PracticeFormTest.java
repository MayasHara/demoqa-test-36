package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "2560x1440";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
    }

    @Test
    void fillFormTest() {
        //Открываем browser
        open("");
        //Удаляем рекламу и банеры
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        //Заполняем ФИО
        $("#firstName").setValue("QA");
        $("#lastName").setValue("GURU");
        //Заполняем e-mail
        $("#userEmail").setValue("QAGURU@rambler.com");
        //Заполняем пол
        $("label[for='gender-radio-1").click();
        //Заполняем телефон
        $("#userNumber").setValue("8888888888");
        //Заполняем дату рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day--001").click();
        //Заполняем объекты
        $("#subjectsInput").setValue("Eng");
        $$(".subjects-auto-complete__option").findBy(text("English")).click();
        $("#subjectsInput").setValue("Econ");
        $$(".subjects-auto-complete__option").findBy(text("Economics")).click();
        $("#subjectsInput").setValue("Comp");
        $$(".subjects-auto-complete__option").findBy(text("Computer Science")).click();
        //Заполняем хобби
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-3']").click();
        //Заполняем фото
        $("#uploadPicture").uploadFromClasspath("picture.jpg");
        //Заполняем адрес
        $("#currentAddress").setValue("Чита, Бабушкина, 58");
        //Заполняем штат и город
        $("#state").click();
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();
        //Отправляем данные
        $("#submit").click();
        //Проверка заполненных данных
        $(".table-responsive").shouldHave(text("QA GURU"));
        $(".table-responsive").shouldHave(text("QAGURU@rambler.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8888888888"));
        $(".table-responsive").shouldHave(text("01 May,1997"));
        $(".table-responsive").shouldHave(text("English, Economics, Computer Science"));
        $(".table-responsive").shouldHave(text("Sports, Music"));
        $(".table-responsive").shouldHave(text("picture.jpg"));
        $(".table-responsive").shouldHave(text("Чита, Бабушкина, 58"));
        $(".table-responsive").shouldHave(text("Rajasthan Jaipur"));
    }
}