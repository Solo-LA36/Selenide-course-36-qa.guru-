import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {
    @Test
    void dragAndDropWithActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        dragAndDropAndCheckResult($("#column-a"),$("#column-b"),"B","A");
    }

    protected void dragAndDropAndCheckResult(SelenideElement whatToDrag , SelenideElement dropTarget, String aMustHave, String bMustHave) {
        var columnA = whatToDrag;
        var columnB = dropTarget;

        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions
                .clickAndHold(columnA)
                .moveToElement(columnB)
                .release()
                .perform();

        // Проверка: текст в колонках должен поменяться местами
        columnA.shouldHave(text(aMustHave));
        columnB.shouldHave(text(bMustHave));
    }
}

