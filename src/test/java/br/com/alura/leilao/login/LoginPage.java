package br.com.alura.leilao.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class LoginPage {

    private static WebDriver webDriver;
    private static OperaOptions options;
    private static final String URL_LOGIN = "http://localhost:8080/login";

    public LoginPage() {
        String operaBinary = "D:\\Programas Instalados\\Opera\\73.0.3856.345\\opera.exe";
        WebDriverManager.operadriver().setup();
        options = new OperaOptions();
        options.setBinary(operaBinary);
        webDriver = new OperaDriver(options);
        webDriver.get(URL_LOGIN);
    }

    public void fecharBrowser() {
        this.webDriver.quit();
    }

    public void preencherFormulario(String username, String password) {
        webDriver.findElement(By.id("username")).sendKeys(username);
        webDriver.findElement(By.id("password")).sendKeys(password);
    }

    public void logar() {
        webDriver.findElement(By.id("login-form")).submit();
    }

    public boolean isUrlPaginaDeLogin() {
        return webDriver.getCurrentUrl().equals(URL_LOGIN);
    }

    public boolean isUrlPaginaDeLoginComDadosInvalidos() {
        return webDriver.getCurrentUrl().equals(URL_LOGIN + "?error");
    }

    public String getNomeUsuarioLogado() {
        try {
            return webDriver.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void navegarParaPaginaDeLances() {
        this.webDriver.navigate().to("http://localhost:8080/leiloes/2");
    }

    public boolean contemTexto(String texto) {
        return webDriver.getCurrentUrl().contains(texto);
    }
}