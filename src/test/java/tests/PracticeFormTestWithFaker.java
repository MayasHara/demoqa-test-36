package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.GeneratorUtils;
import utils.TestBase;
import utils.TestData;


public class PracticeFormTestWithFaker  extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData data = new TestData();
    GeneratorUtils generator = new GeneratorUtils();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeAds()
                .setFirstName(data.userName)
                .setLastName(data.lastName)
                .setEmail(data.userEmailAddress)
                .setGender(data.genderOfUser)
                .setUserNumber(data.number)
                .setDateOfBirth(data.day, data.month, data.year)
                .setObjectInput(data.subjectOfUsers)
                .setHobbiesWrapper(data.hobbies)
                .setPicture(generator.pictureName())
                .setAdress(data.address)
                .selectStateAndCity(data.state, data.city)
                .sendData();

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
    }
}