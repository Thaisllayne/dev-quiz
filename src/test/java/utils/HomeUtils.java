package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import elements.HomeElements;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class HomeUtils {
    static HomeElements homeElements = new HomeElements();
    @BeforeMethod
    public void setUpAll(){
        Configuration.browser = "Firefox";
        // Configuration.holdBrowserOpen = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
        abrirPaginaHome();
    }

    public void abrirPaginaHome(){
        open("https://3jvz3m.csb.app/");
        assertEquals(Selenide.title(), "DevQuiz");
    }



    public void preencherCamposDaHome(String nome, String dificuldade){
        homeElements.inputName.shouldBe(Condition.visible);
        homeElements.inputName.sendKeys(nome);
        SelenideElement botaoDificuldade = (dificuldade.equals("Easy")) ? homeElements.buttonEasy : homeElements.buttonHard;
        botaoDificuldade.click();
    }

    public void preencherCamposDaHome(String nome){
        homeElements.inputName.sendKeys(nome);
    }

    @AfterMethod
    public void finalizarCadaTeste(){
        closeWebDriver();
    }
}
