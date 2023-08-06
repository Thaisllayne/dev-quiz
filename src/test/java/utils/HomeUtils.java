package utils;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import elements.HomeElements;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class HomeUtils {
    public static HomeElements homeElements = new HomeElements();
    @BeforeMethod
    public void setUpAll(){
        Configuration.browser = "Firefox";
        Configuration.holdBrowserOpen = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
        abrirPaginaHome();
    }

    public void abrirPaginaHome(){
        open("https://3jvz3m.csb.app/");
        assertEquals(Selenide.title(), "DevQuiz");
    }

    public void preencherCamposDaHome(String nome){
        homeElements.inputName.sendKeys(nome);
    }

    public void preencherCamposDaHome(String nome, String dificuldade){
        homeElements.inputName.shouldBe(Condition.visible, Duration.ofSeconds(30));
        homeElements.inputName.sendKeys(nome);
        SelenideElement botaoDificuldade = (dificuldade.equals("Easy")) ? homeElements.buttonEasy : homeElements.buttonHard;
        botaoDificuldade.click();

        homeElements.buttonStart.should(Condition.enabled, Duration.ofSeconds(5));
        homeElements.buttonStart.click();
    }

    public void validarAposPreenchimentoDosCampos(){
        homeElements.inputName.shouldBe(Condition.disappear);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("https://3jvz3m.csb.app/quiz", currentUrl);
    }

    public void iniciarQuiz(String nome, String dificuldade)
    {
        preencherCamposDaHome(nome, dificuldade);
        validarAposPreenchimentoDosCampos();
    }

    @AfterMethod
    public void finalizarCadaTeste(){
        closeWebDriver();
    }
}
