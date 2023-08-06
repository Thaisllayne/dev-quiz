package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class QuizElements {

    public SelenideElement questionDescription = $("#root > div > main > h2");
    public ElementsCollection answers = $$("#root > div > main > ul li > label > input[type=radio]");
    public SelenideElement buttonNext = $("#root > div > button");
    public ElementsCollection questionsAnswered = $$("#root > div > div > div.questions-container span.active.question");
    public SelenideElement currentQuestion = $("#root > div > div > div.questions-container span.active.last");
}
