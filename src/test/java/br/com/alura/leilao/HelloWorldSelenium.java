package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class HelloWorldSelenium {

    @Test
    public void hello() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "D:/Projetos/curso-selenium-java/drivers/chrome/chromedriver.exe");
//        WebDriver googleChrome = new ChromeDriver();
//        googleChrome.navigate().to("localhost:8080/leiloes");

        System.setProperty("webdriver.opera.driver", "D:/Projetos/curso-selenium-java/drivers/opera/operadriver.exe");
        WebDriver opera = new OperaDriver();

        Thread.sleep(5000);
//        googleChrome.quit();
        opera.navigate().to("localhost:8080/leiloes");
        opera.quit();
    }
}
