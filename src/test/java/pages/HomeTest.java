package pages;

import com.codeborne.selenide.Condition;
import elements.HomeElements;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.HomeUtils;

import java.time.Duration;

public class HomeTest extends HomeUtils {

    static HomeElements homeElements = new HomeElements();

    @Test
    public void iniciarOQuizEasy(){
        preencherCamposDaHome("Thais", "Easy");
        validarAposPreenchimentoDosCampos();
    }

    @Test
    public void iniciarOQuizHard(){
        preencherCamposDaHome("Thais", "Hard");
        validarAposPreenchimentoDosCampos();
    }

    @Test
    public void verificarTamanhoCampoNome_Sucesso(){
        String nomeInformado = "Thais";
        preencherCamposDaHome(nomeInformado);
        int maxTamanhoCampoInformado = 8;
        int totalCaracteresInformado = nomeInformado.length();

        Assert.assertTrue(totalCaracteresInformado <= maxTamanhoCampoInformado);
        homeElements.buttonStart.shouldBe(Condition.enabled, Duration.ofSeconds(5));
    }

    @Test
    public void verificarTamanhoCampoNome_Erro(){
        String nomeInformado = "Thaisllayne";
        preencherCamposDaHome(nomeInformado);
        int maxTamanhoCampoInformado = 8;
        int totalCaracteresInformado = nomeInformado.length();

        Assert.assertFalse(totalCaracteresInformado <= maxTamanhoCampoInformado);
        homeElements.buttonStart.shouldBe(Condition.disabled, Duration.ofSeconds(5));
    }

    @Test
    public void verificarNomeInformadoNoCampoUser(){
        String nomeInformado = "Thais";
        preencherCamposDaHome(nomeInformado);
        String nomeExibidoNoUser = homeElements.userName.getText();

        Assert.assertEquals(nomeInformado, nomeExibidoNoUser);
    }
}
