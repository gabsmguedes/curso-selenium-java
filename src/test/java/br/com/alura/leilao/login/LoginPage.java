package br.com.alura.leilao.login;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends PageObject {

    private static final String URL_LOGIN = "http://localhost:8080/login";

    public LoginPage() {
        super(null);
        webDriver.get(URL_LOGIN);
    }

    public void preencherFormulario(String username, String password) {
        webDriver.findElement(By.id("username")).sendKeys(username);
        webDriver.findElement(By.id("password")).sendKeys(password);
    }

    public LeiloesPage logar() {
        webDriver.findElement(By.id("login-form")).submit();
        return new LeiloesPage(webDriver);
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
