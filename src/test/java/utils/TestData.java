package utils;


import java.util.Date;

import static utils.GeneratorUtils.*;

public class TestData {

    public static final String uploadFile = "picture.jpg";

    public String userName = firstName();
    public String lastName = lastUserName();
    public String userEmailAddress = userEmail();
    public String genderOfUser = gender();
    public String number = userNumber();
    public String address = currentAddress();
    public String subjectOfUsers = subject();
    public String hobbies = hobby();
    public Date birthday = userBirthday();
    public String day = dayOfBirthday(birthday);
    public String month = monthOfBirthday(birthday);
    public String year = yearOfBirthDay(birthday);
    public String state = getState();
    public String city = getCity(state);
}
