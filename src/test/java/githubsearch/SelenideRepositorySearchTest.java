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

            sleep(10000);


        // перейти на страницу selenide


        //перейти в раздел Wiki проекта selenide в github (Таб)


        // проверка наличия текста SoftAssertions


        //открытие страницы SoftAssertions


        // проверить, что внутри есть пример кода для JUnit5



        }
}