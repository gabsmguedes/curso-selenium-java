package br.com.alura.leilao.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class LoginTest {

    static WebDriver webDriver;

    @Test
    public void logarComDadosValidos() {
        String operaBinary = "D:\\Programas Instalados\\Opera\\73.0.3856.345\\opera.exe";
        WebDriverManager.operadriver().setup();
        OperaOptions options = new OperaOptions();
        options.setBinary(operaBinary);
        webDriver = new OperaDriver(options);

        webDriver.get("http://localhost:8080/login");
        webDriver.findElement(By.id("username")).sendKeys("fulano");
        webDriver.findElement(By.id("password")).sendKeys("pass");
        webDriver.findElement(By.id("login-form")).submit();

        Assert.assertFalse(webDriver.getCurrentUrl().equals("http://localhost:8080/login"));
        Assert.assertEquals("fulano", webDriver.findElement(By.id("usuario-logado")).getText());
        webDriver.quit();
    }

}
