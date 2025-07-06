package githubsearch;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearchTest {


    @Test
    void shouldFindJUnite5() {

        //открыть главную страницу github.com
        open("https://github.com/");
        $("title").click();


        // ввести в поле поиска selenide и нажать enter
        //открыть страницу selenide в github
        //перейти в раздел Wiki проекта selenide в github
        //убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        // открыть страницу SoftAssertions, проверить, что внутри есть пример кода для JUnit5


    }
}
