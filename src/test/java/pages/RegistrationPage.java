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
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            objectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            cityWrapper = $("#stateCity-wrapper"),
            submitData = $("#submit"),
            date = $("#dateOfBirthInput");

    CalendarComponent calendarComponent = new CalendarComponent();
    Result formResult = new Result();


    public RegistrationPage openPage() {
        open("");

        return this;
    }

    public RegistrationPage remove (){

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
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value){
        userNumber.setValue(value);


        return this;
    }

    public RegistrationPage setDateOfBirth (String day, String month, String year) {

        date.click();
        calendarComponent.setDate(day, month, year);


        return this;
    }


    public RegistrationPage setObjectInput (String value){
        objectInput.setValue(value);
        objectInput.pressEnter();


        return this;
    }

    public RegistrationPage setHobbiesWrapper (String value){

        hobbiesWrapper.$(byText(value)).click();


        return this;
    }

    public RegistrationPage setPicture (String resources){
        uploadInput.uploadFromClasspath(resources);

        return this;
    }

    public RegistrationPage setAdress (String value){
        addressInput.setValue(value);


        return this;
    }

    public RegistrationPage setState (String value){
        stateInput.click();
        cityWrapper.$(byText(value)).click();


        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        cityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage sendData (String value){
        submitData.click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        formResult.result(key, value);

        return this;
    }

}