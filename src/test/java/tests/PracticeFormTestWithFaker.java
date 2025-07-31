package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.GeneratorUtils;
import utils.TestBase;
import utils.TestData;

import static com.codeborne.selenide.logevents.SelenideLogger.step;


public class PracticeFormTestWithFaker  extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData data = new TestData();
    GeneratorUtils generator = new GeneratorUtils();

    @Test
    void successfulRegistrationTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем страницу",() -> {
            registrationPage.openPage();
        });
        step("Удаляем рекламу", () -> {
            registrationPage.removeAds();
        });
        step("Заполняем данные",() -> {
            registrationPage.setFirstName(data.userName)
                    .setLastName(data.lastName)
                    .setEmail(data.userEmailAddress)
                    .setGender(data.genderOfUser)
                    .setUserNumber(data.number)
                    .setDateOfBirth(data.day, data.month, data.year)
                    .setObjectInput(data.subjectOfUsers)
                    .setHobbiesWrapper(data.hobbies)
                    .setPicture(generator.pictureName())
                    .setAdress(data.address)
                    .selectStateAndCity(data.state, data.city);
        });
        step("Отправляем данные", () -> {
            registrationPage.sendData();
        });
        step("Проверка корректности заполненных данных", () -> {
            registrationPage.checkResult("Student Name", data.userName + " " + data.lastName)
                    .checkResult("Student Email", data.userEmailAddress)
                    .checkResult("Gender", data.genderOfUser)
                    .checkResult("Mobile", data.number)
                    .checkResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                    .checkResult("Subjects", data.subjectOfUsers)
                    .checkResult("Hobbies", data.hobbies)
                    .checkResult("Picture", generator.pictureName())
                    .checkResult("Address", data.address)
                    .checkResult("State and City", data.state + " " + data.city);
        });
    }
}