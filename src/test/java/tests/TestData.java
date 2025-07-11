package tests;


import java.util.Date;

public class TestData {

    public static final String uploadFile = "picture.jpg";

    Generator generator = new Generator()
            ;
    String userName = generator.firstName();
    String lastName = generator.lastName();
    String userEmail = generator.userEmail();
    String gender = generator.gender();
    String userNumber = generator.userNumber();
    String address = generator.currentAddress();
    String subject = generator.subject();
    String hobbies = generator.hobby();
    Date birthday = generator.birthday();
    String day = generator.day(birthday);
    String month = generator.month(birthday);
    String year = generator.year(birthday);
    String state = generator.getState();
    String city = generator.getCity(state);
}
