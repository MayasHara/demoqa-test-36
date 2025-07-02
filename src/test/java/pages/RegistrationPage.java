package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("label[for='gender-radio-1"),
            userNumber = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            objectInput = $("#subjectsInput"),
            objectOption = $(".subjects-auto-complete__option"),
            hobbiesWrapperSport = $("label[for='hobbies-checkbox-1']"),
            hobbiesWrapperMusic = $("label[for='hobbies-checkbox-3']"),
            uploadInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            selectState = $("#react-select-3-input"),
            cityInput = $("#city"),
            selectCity = $("#react-select-4-input"),
            submitData = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();


    public RegistrationPage openPage() {
        open("");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");


        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);


        return this;
    }


    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);


        return this;
    }

    public RegistrationPage setEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value){
        genderWrapper.click();

        return this;
    }

    public RegistrationPage setUserNumber(String value){
        userNumber.setValue(value);


        return this;
    }

    public RegistrationPage setDateOfBirth (String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate("01", "May","1997");


        return this;
    }


    public RegistrationPage setObjectInput (String Eng, String Econ, String Comp){
        objectInput.setValue("Eng");
        objectOption.click();
        objectInput.setValue("Econ");
        objectOption.click();
        objectInput.setValue("Comp");
        objectOption.click();

        return this;
    }

    public RegistrationPage setHobbiesWrapper (String Sport, String Music){
        hobbiesWrapperSport.click();
        hobbiesWrapperMusic.click();


        return this;
    }

    public RegistrationPage setPicture (String value){
        uploadInput.uploadFromClasspath("picture.jpg");

        return this;
    }

    public RegistrationPage setAdress (String value){
        addressInput.setValue("Чита, Бабушкина, 58");


        return this;
    }

    public RegistrationPage setState (String Rajasthan, String Jaipur){
        stateInput.click();
        selectState.setValue("Rajasthan").pressEnter();
        cityInput.click();
        selectCity.setValue("Jaipur").pressEnter();

        return this;
    }

    public RegistrationPage sendData (String value){
        submitData.click();

        return this;
    }


    public RegistrationPage checkResult(String key, String value){
        $(".table-responsive")
                .$(byText(key))
                .parent()
                .shouldHave(text(value));


        return this;
    }


}