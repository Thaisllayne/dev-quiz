package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import elements.QuizElements;
import org.testng.annotations.Test;
import utils.HomeUtils;
import utils.QuizUtils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class QuizTest extends QuizUtils{

    static QuizElements quizElements = new QuizElements();
    static HomeUtils homeUtils = new HomeUtils();

    @Test
    public void responderQuiz(){
        homeUtils.iniciarQuiz("thasdas", "Easy");

        responderTodasAsQuestoes();
        responderQuestao(); //última questão - não vai cair na validação das demais

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("https://3jvz3m.csb.app/result", currentUrl);
    }

    @Test
    public void validarNenhumaOpcaoSelecionada(){
        iniciarQuiz("thais", "Hard");
        quizElements.buttonNext.shouldBe(Condition.disabled);

        assertTrue(quizElements.buttonNext.is(Condition.disabled));
    }
}
