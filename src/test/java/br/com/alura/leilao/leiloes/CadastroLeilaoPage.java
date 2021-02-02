package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {

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
}
