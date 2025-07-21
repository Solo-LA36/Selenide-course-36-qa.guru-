import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubEnterprisePageTest {
    @Test
    public void testGitHubEnterprisePage() {
        // Открыть главную страницу GitHub
        open("https://github.com");

        // Навести курсор на меню "Solutions"
        $(withTagAndText("button","Solutions")).hover();


        // Кликнуть на пункт "Enterprise" в выпадающем меню
        $(byTagAndText("a", "Enterprise")).click();


        // Проверить заголовок страницы
        $("h1#hero-section-brand-heading").shouldHave(Condition.exactText("The AI-powered developer platform"));
    }
}

