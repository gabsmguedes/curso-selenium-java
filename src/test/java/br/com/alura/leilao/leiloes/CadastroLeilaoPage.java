package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {

    private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
    private WebDriver webDriver;

    public CadastroLeilaoPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fechar() {
        this.webDriver.quit();
    }

    public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
        this.webDriver.findElement(By.id("nome")).sendKeys(nome);
        this.webDriver.findElement(By.id("valorInicial")).sendKeys(valorInicial);
        this.webDriver.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
        this.webDriver.findElement(By.id("button-submit")).submit();
        return new LeiloesPage(webDriver);
    }

    public boolean isPaginaAtual() {
        return this.webDriver.getCurrentUrl().equals(URL_CADASTRO_LEILAO);
    }

    public boolean isMensagensValidacoesVisiveis() {
        String pageSource = this.webDriver.getPageSource();
        return pageSource.contains("minimo 3 caracteres") && pageSource.contains("não deve estar em branco")
                && pageSource.contains("deve ser um valor maior de 0.1") && pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
    }
}
