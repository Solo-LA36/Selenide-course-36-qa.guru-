package githubsearch;


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
        $("#wiki-body").shouldHave(text("3. Using JUnit5 extend test class:"));
        $(".markdown-body").shouldHave(text("ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));

    }
}