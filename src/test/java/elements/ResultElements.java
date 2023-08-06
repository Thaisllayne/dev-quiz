package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultElements {

    public ElementsCollection table = $$("#root > div > main > table > tbody tr");
    public SelenideElement totalHits = $("#root > div > main > table > tfoot > tr > td:nth-child(4)");
}
