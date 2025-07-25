package utils;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;

public class TestBase {

    GeneratorUtils data = new GeneratorUtils();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
        Configuration.browserSize = "2560x1440";
        Configuration.pageLoadStrategy = "eager";
    }
    public static final String uploadFile = "MyPhoto.jpg";

    public static final String[] SUBJECT_OPTIONS = {
            "Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
            "Computer Science", "Economics", "Social Studies", "History",
            "Civics", "Commerce", "Hindi", "Biology"
    };

    public static final String[] HOBBY_OPTIONS = {
            "Reading", "Sports", "Music"
    };

    public static final Map<String, String[]> mapStateWithCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );

    String state = data.getState();
    String city = data.getCity(state);
}
