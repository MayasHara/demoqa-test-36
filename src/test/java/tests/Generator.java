package tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static tests.TestData.uploadFile;

public class Generator {
    public static Faker faker = new Faker(new Locale("en"));

    public String firstName(){
        return faker.name().firstName();
    };
    public String lastName(){
        return faker.name().lastName();
    };
    public String userEmail(){
        return faker.internet().emailAddress();
    };
    public String gender(){
        return faker.options().option("Male", "Female", "Other");
    }
    public String userNumber(){
        return faker.phoneNumber().subscriberNumber(10);
    }
    public String day(){
        return String.format("%02d", faker.number().numberBetween(1, 30));
    }
    public String month(){
        return faker.options().option(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
    }
    public String year (){
        return String.valueOf(faker.number().numberBetween(1900, 2100));
    }
    public String subject (){
        return faker.options().option("Math", "Biology", "Chemistry", "Physics");
    }
    public String hobby (){
        return faker.options().option("Sports", "Reading", "Music");
    }
    public String pictureName (){
        return faker.options().option("picture.jpg");
    }
    public String currentAddress (){
        return faker.address().fullAddress();
    }
    public String getState() {
        return faker.options().option(TestBase.mapStateWithCity.keySet().toArray()).toString();
    }

    public String getCity(String state) {
        return faker.options().option(TestBase.mapStateWithCity.get(state));
    }
    public Date birthday(){
        return faker.date().birthday();
    }
    public String day(Date birthday){
        return new SimpleDateFormat("dd", Locale.ENGLISH).format(birthday);
    }
    public String month (Date birthday){
        return new SimpleDateFormat("MMMM", Locale.ENGLISH).format(birthday);
    }
    public String year (Date birthday){
        return new SimpleDateFormat("y",Locale.ENGLISH).format(birthday);
    }
    public String setPicture(){
        return uploadFile;
    }
}