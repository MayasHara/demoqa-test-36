package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.sleep;
import static tests.TestData.*;


public class PracticeFormTestWithFaker  extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData data = new TestData();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeAds()
                .setFirstName(data.userName)
                .setLastName(data.lastName)
                .setEmail(data.userEmail)
                .setGender(data.gender)
                .setUserNumber(data.userNumber)
                .setDateOfBirth(data.day, data.month, data.year)
                .setObjectInput(data.subject)
                .setHobbiesWrapper(data.hobbies)
                .setPicture(data.generator.pictureName())
                .setAdress(data.address)
                .selectStateAndCity(data.state, data.city)
                .sendData();

        registrationPage.checkResult("Student Name", data.userName + " " + data.lastName)
                .checkResult("Student Email", data.userEmail)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.userNumber)
                .checkResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                .checkResult("Subjects", data.subject)
                .checkResult("Hobbies", data.hobbies)
                .checkResult("Picture", data.generator.pictureName())
                .checkResult("Address", data.address)
                .checkResult("State and City", data.state + " " + data.city);
    }
}