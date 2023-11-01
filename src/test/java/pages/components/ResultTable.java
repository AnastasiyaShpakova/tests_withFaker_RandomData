package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultTable {


    SelenideElement titleTable = $("#example-modal-sizes-title-lg"),
            tableField = $(".table-responsive");


    public void checkTitleMessage(String message) {
        titleTable.shouldHave(text(message));
    }

    public void checkResultTable(String value) {
        tableField.shouldHave(text(value));
    }

    public void checkHiddenTable() {
        titleTable.should(hidden);
    }

}
