package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
    private final SelenideElement monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select");
    private final ElementsCollection daySelect = $$(".react-datepicker__day");

    public void setDate(String day, String month, String year) {

        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        daySelect.findBy(text(day)).click();
    }
}
