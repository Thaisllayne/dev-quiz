package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomeElements {
    public SelenideElement inputName = $("#root > div > main > div.block.username > input");
    public SelenideElement buttonEasy = $("#root > div > main > div.block.dificulty > div > button:nth-child(1)");
    public SelenideElement buttonHard = $("#root > div > main > div.block.dificulty > div > button:nth-child(2)");

    public SelenideElement buttonStart = $("#root > div > main > button");
}
