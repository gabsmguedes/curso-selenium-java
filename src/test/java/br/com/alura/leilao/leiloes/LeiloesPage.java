package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaOptions;

public class LeiloesPage {

    private static WebDriver webDriver;
    private static OperaOptions options;
    private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
    private static final String URL_LEILAO = "http://localhost:8080/leiloes";

    public LeiloesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fecharBrowser() {
        this.webDriver.quit();
    }

    public CadastroLeilaoPage carregarFormulario() {
        this.webDriver.navigate().to(URL_CADASTRO_LEILAO);
        return new CadastroLeilaoPage(webDriver);
    }

    public boolean isLeilaoCadastrado(String nome, String valor, String data) {
        WebElement linhaDaTabela = this.webDriver.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));

        return colunaNome.getText().equals(nome) && colunaDataAbertura.getText().equals(data) && colunaValorInicial.getText().equals(valor);
    }

    public boolean isPaginaAtual() {
        return this.webDriver.getCurrentUrl().equals(URL_LEILAO);
    }
}
