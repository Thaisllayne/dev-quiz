package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import elements.HomeElements;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.HomeUtils;

import static org.testng.Assert.assertEquals;

public class HomeTest extends HomeUtils {

    static HomeElements homeElements = new HomeElements();

    @Test
    public void iniciarOQuizEasy(){
        preencherCamposDaHome("Thais", "Easy");
        homeElements.buttonStart.should(Condition.enabled);
        homeElements.buttonStart.click();

        homeElements.inputName.shouldBe(Condition.disappear);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("https://3jvz3m.csb.app/quiz", currentUrl);
    }

    @Test
    public void iniciarOQuizHard(){
        preencherCamposDaHome("Thais", "Hard");
        homeElements.buttonStart.should(Condition.enabled);
        homeElements.buttonStart.click();

        homeElements.inputName.shouldBe(Condition.disappear);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("https://3jvz3m.csb.app/quiz", currentUrl);
    }

    @Test
    public void verificarTamanhoCampoNome_Sucesso(){
        String nomeInformado = "Thais";
        preencherCamposDaHome(nomeInformado);
        int maxTamanhoCampoInformado = 8;
        int totalCaracteresInformado = nomeInformado.length();

        Assert.assertTrue(totalCaracteresInformado <= maxTamanhoCampoInformado);
        homeElements.buttonStart.shouldBe(Condition.enabled);
    }

    @Test
    public void verificarTamanhoCampoNome_Erro(){
        String nomeInformado = "Thaisllayne";
        preencherCamposDaHome(nomeInformado);
        int maxTamanhoCampoInformado = 8;
        int totalCaracteresInformado = nomeInformado.length();

        Assert.assertFalse(totalCaracteresInformado <= maxTamanhoCampoInformado);
        homeElements.buttonStart.shouldBe(Condition.disabled);
    }


}
