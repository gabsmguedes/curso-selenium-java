package br.com.alura.leilao.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class LoginTest {

    private static WebDriver webDriver;
    private static OperaOptions options;
    private static final String URL_LOGIN = "http://localhost:8080/login";
    @BeforeAll
    public static void beforeAll() {
        String operaBinary = "D:\\Programas Instalados\\Opera\\73.0.3856.345\\opera.exe";
        WebDriverManager.operadriver().setup();
        options = new OperaOptions();
        options.setBinary(operaBinary);
    }

    @BeforeEach
    public void beforeEach() {
        webDriver = new OperaDriver(options);
        webDriver.get(URL_LOGIN);
    }

    @AfterEach
    public void afterEach() {
        webDriver.quit();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
        webDriver.findElement(By.id("username")).sendKeys("fulano");
        webDriver.findElement(By.id("password")).sendKeys("pass");
        webDriver.findElement(By.id("login-form")).submit();

        Assert.assertFalse(webDriver.getCurrentUrl().equals("URL_LOGIN"));
        Assert.assertEquals("fulano", webDriver.findElement(By.id("usuario-logado")).getText());
    }

    @Test
    public void naoDeveriaEfetuarLoginComDadosValidos() {
        webDriver.findElement(By.id("username")).sendKeys("invalido");
        webDriver.findElement(By.id("password")).sendKeys("passinvalida");
        webDriver.findElement(By.id("login-form")).submit();

        Assert.assertTrue(webDriver.getCurrentUrl().equals(URL_LOGIN + "?error"));
        Assert.assertTrue(webDriver.getPageSource().contains("Usuário e senha inválidos."));
        Assert.assertThrows(NoSuchElementException.class, () -> webDriver.findElement(By.id("usuario-logado")).getText());
    }
}
