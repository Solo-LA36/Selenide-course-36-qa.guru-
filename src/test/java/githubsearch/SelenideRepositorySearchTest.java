package githubsearch;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearchTest {



        @Test
        void shouldFindJUnite5() {

        //открыть главную страницу github.com
        open("https://github.com");


        // ввести в поле поиска selenide и и нажать enter
            actions().sendKeys("s").perform();
        $("#query-builder-test").setValue("selenide").pressEnter();


        // кликнуть на первый репозиторий из списка найденных
            $$("[data-testid=results-list]").first().$("a").click();

        //перейти в раздел Wiki проекта selenide в github (Таб)
            $("#wiki-tab").click();

        // проверка наличия текста SoftAssertions
            $(byText("Show 3 more pages…")).click();
            $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
            $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();


        //открытие страницы SoftAssertions
            $("#wiki-pages-box").$(byText("SoftAssertions")).click();



        // проверить, что внутри есть пример кода для JUnit5
            $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class:"));
            $("#repo-content-pjax-container").shouldHave(text("jUnit5"));

        }
}