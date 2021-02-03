package br.com.alura.leilao;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class HelloWorldSelenium {

    static WebDriver webDriver;

    @Test
    public void hello() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Projetos\\curso-selenium-java\\src\\test\\drivers\\chrome\\chromedriver.exe");
        webDriver = new ChromeDriver();

//        String operaBinary = "D:\\Programas Instalados\\Opera\\74.0.3911.75\\opera.exe";
//        WebDriverManager.operadriver().setup();
//        OperaOptions options = new OperaOptions();
//        options.setBinary(operaBinary);
//        webDriver = new OperaDriver(options);

        webDriver.get("http://localhost:8080/leiloes");
        Thread.sleep(5000);
        webDriver.quit();
    }
}
