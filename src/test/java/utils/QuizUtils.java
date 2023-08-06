package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import elements.QuizElements;
import org.testng.Assert;

import java.time.Duration;

public class QuizUtils extends HomeUtils {

    public static QuizElements quizElements = new QuizElements();

    public void responderQuestao(){
        ElementsCollection answers = quizElements.answers;
        for(SelenideElement answer: answers){
            answer.click();
        }

        quizElements.buttonNext.shouldBe(Condition.enabled, Duration.ofSeconds(5));
        quizElements.buttonNext.click();
    }

    public void validarAposResponderQuestao(String lastQuestionDescription){
        String getCurrentQuestionDescription = quizElements.questionDescription.getText();

        ElementsCollection questionsAnswered = quizElements.questionsAnswered;
        int currentQuestion = Integer.parseInt(quizElements.currentQuestion.getText());

        int lastQuestionAnswered = 1;
        for(SelenideElement question : questionsAnswered){
            lastQuestionAnswered = Integer.parseInt(question.getText());
        }

        Assert.assertNotEquals(lastQuestionDescription, getCurrentQuestionDescription);
        Assert.assertEquals(currentQuestion, lastQuestionAnswered);
    }

    public void responderTodasAsQuestoes(){
        for (int questionNumber = 1; questionNumber < 10; questionNumber++){
            String getLastQuestionDescription = quizElements.questionDescription.getText();
            responderQuestao();
            validarAposResponderQuestao(getLastQuestionDescription);
        }
    }
    public void finalizarQuiz(){
        responderQuestao();
    }



}
