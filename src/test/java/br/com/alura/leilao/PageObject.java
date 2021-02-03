package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

    protected WebDriver webDriver;

    public PageObject(WebDriver webDriver) {
        System.setProperty("webdriver.chrome.driver", "D:\\Projetos\\curso-selenium-java\\src\\test\\drivers\\chrome\\chromedriver.exe");
        this.webDriver = webDriver == null ? new ChromeDriver() : webDriver;
    }

    public void fecharBrowser() {
        this.webDriver.quit();
    }

}
