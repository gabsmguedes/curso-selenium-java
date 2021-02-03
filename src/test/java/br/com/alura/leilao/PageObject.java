package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObject {

    protected WebDriver webDriver;

    public PageObject(WebDriver webDriver) {
        System.setProperty("webdriver.chrome.driver", "D:\\Projetos\\curso-selenium-java\\src\\test\\drivers\\chrome\\chromedriver.exe");
        this.webDriver = webDriver == null ? new ChromeDriver() : webDriver;
        this.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS).pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void fecharBrowser() {
        this.webDriver.quit();
    }

}
