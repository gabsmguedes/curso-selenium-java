package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private LoginPage paginaDeLogin;

    @BeforeEach
    public void beforeEach() {
        paginaDeLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach() {
        this.paginaDeLogin.fecharBrowser();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
        paginaDeLogin.preencherFormulario("fulano", "pass");
        paginaDeLogin.logar();

        Assert.assertFalse(paginaDeLogin.isUrlPaginaDeLogin());
        Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
    }

    @Test
    public void naoDeveriaEfetuarLoginComDadosValidos() {
        paginaDeLogin.preencherFormulario("invalido", "passinvalida");
        paginaDeLogin.logar();

        Assert.assertTrue(paginaDeLogin.isUrlPaginaDeLoginComDadosInvalidos());
        Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
        Assert.assertFalse(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
        paginaDeLogin.navegarParaPaginaDeLances();
        Assert.assertTrue(paginaDeLogin.isUrlPaginaDeLogin());
        Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
    }
}
