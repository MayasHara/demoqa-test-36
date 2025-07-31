package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static utils.TestData.uploadFile;

public class GeneratorUtils {
    public static Faker faker = new Faker(new Locale("en"));

    public static String firstName(){
        return faker.name().firstName();
    };
    public static String lastUserName(){
        return faker.name().lastName();
    };
    public static String userEmail(){
        return faker.internet().emailAddress();
    };
    public static String gender(){
        return faker.options().option("Male", "Female", "Other");
    }
    public static String userNumber(){
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String subject (){
        return faker.options().option("Math", "Biology", "Chemistry", "Physics");
    }
    public static String hobby (){
        return faker.options().option("Sports", "Reading", "Music");
    }
    public static String pictureName (){
        return faker.options().option("picture.jpg");
    }
    public static String currentAddress (){
        return faker.address().fullAddress();
    }
    public static String getState() {
        return faker.options().option(TestBase.mapStateWithCity.keySet().toArray()).toString();
    }

    public static String getCity(String state) {
        return faker.options().option(TestBase.mapStateWithCity.get(state));
    }
    public static Date userBirthday(){
        return faker.date().birthday(1, 28);
    }
    public static String dayOfBirthday(Date birthday){
        return new SimpleDateFormat("dd", Locale.ENGLISH).format(birthday);
    }
    public static String monthOfBirthday (Date birthday){
        return new SimpleDateFormat("MMMM", Locale.ENGLISH).format(birthday);
    }
    public static String yearOfBirthDay (Date birthday){
        return new SimpleDateFormat("y",Locale.ENGLISH).format(birthday);
    }
    public static String setPicture(){
        return uploadFile;
    }
}