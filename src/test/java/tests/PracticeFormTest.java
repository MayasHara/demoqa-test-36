package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;



public class PracticeFormTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "2560x1440";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
    }

    @Test
    void successfulRegistrationTest() {
        registrationPage
                .openPage()
                .remove()
                .setFirstName("QA")
                .setLastName("GURU")
                .setEmail("QAGURU@rambler.com")
                .setGender("Male")
                .setUserNumber("8888888888")
                .setDateOfBirth("22", "May", "1997")
                .setObjectInput("Eng")
                .setHobbiesWrapper("Sports")
                .setPicture("picture.jpg")
                .setAdress("Чита, Бабушкина, 58")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .sendData("Submit");

        registrationPage.checkResult("Student Name", "QA" + " " + "GURU")
                .checkResult("Student Email","QAGURU@rambler.com")
                .checkResult("Gender","Male")
                .checkResult("Mobile","8888888888")
                .checkResult("Date of Birth","22 May,1997")
                .checkResult("Subjects","English")
                .checkResult("Hobbies", "Sports")
                .checkResult("Address","Чита, Бабушкина, 58")
                .checkResult("State and City","Rajasthan Jaipur");


    }
    @Test
    void negativeRegistrationTest(){
        registrationPage
                .openPage()
                .setFirstName("")
                .setLastName("GURU")
                .setEmail("QAGURU@rambler.com")
                .setGender("Male")
                .setUserNumber("888888888")
                .setDateOfBirth("22", "May", "1997")
                .setObjectInput("English")
                .setHobbiesWrapper("Sports")
                .setPicture("picture.jpg")
                .setAdress("Чита, Бабушкина, 58")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .sendData("Submit");

        sleep(5000);
    }

    @Test
    void minimalTest(){
        registrationPage
                .openPage()
                .setFirstName("QA")
                .setLastName("GURU")
                .setGender("Male")
                .setUserNumber("8888888888")
                .setDateOfBirth("22", "May", "1997")
                .sendData("Submit");

        registrationPage.checkResult("Student Name", "QA" + " " + "GURU")
                .checkResult("Gender","Male")
                .checkResult("Mobile","8888888888")
                .checkResult("Date of Birth","22 May,1997");
    }
}