package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import elements.ResultElements;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.HomeUtils;
import utils.QuizUtils;

public class ResultTest extends HomeUtils {

    static ResultElements resultElements = new ResultElements();
    static HomeUtils homeUtils = new HomeUtils();
    static QuizUtils quizUtils = new QuizUtils();

    @Test
    public void compararRespostaEnviadaComGabarito(){
        homeUtils.iniciarQuiz("Thai", "Easy");
        quizUtils.finalizarQuiz();

        ElementsCollection table = resultElements.table;
        for (SelenideElement row : table){
            SelenideElement correctAnswer = row.$("td:nth-child(2)");
            SelenideElement selectedAnswer = row.$("td:nth-child(3)");
            SelenideElement resultIcon = row.$("td:nth-child(4) > span");

            if (correctAnswer.getText().equals(selectedAnswer.getText())){
                Assert.assertEquals(correctAnswer.getText(), selectedAnswer.getText());
                Assert.assertEquals(resultIcon.getText(), "✔");
            } else {
                Assert.assertNotEquals(correctAnswer.getText(), selectedAnswer.getText());
                Assert.assertEquals(resultIcon.getText(), "✖");
            }
        }
    }

    @Test
    public void validarTotalDeAcertos(){
        homeUtils.iniciarQuiz("Thai", "Easy");
        quizUtils.finalizarQuiz();

        int totalAcertos = 0;

        ElementsCollection table = resultElements.table;
        for (SelenideElement row : table){
            SelenideElement resultIcon = row.$("td:nth-child(4) > span");
            if (resultIcon.getText().equals("✔")){
                totalAcertos++;
            }
        }
        int totalHitsInt = Integer.parseInt(resultElements.totalHits.getText());
        Assert.assertEquals(totalAcertos, totalHitsInt);
    }
}
