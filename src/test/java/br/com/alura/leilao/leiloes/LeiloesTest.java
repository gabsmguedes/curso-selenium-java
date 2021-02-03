package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeiloesTest {

    private LeiloesPage paginaDeLeiloes;
    private CadastroLeilaoPage paginaDeCadastroLeilao;

    @BeforeEach()
    public void beforeEach() {
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormulario("fulano", "pass");
        this.paginaDeLeiloes = paginaDeLogin.logar();
        this.paginaDeCadastroLeilao = paginaDeLeiloes.carregarFormulario();
    }

    @AfterEach
    public void afterEach() {
        this.paginaDeLeiloes.fecharBrowser();
    }

    @Test
    public void deveriaCadastrarNovoLeilao() {
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormulario("fulano", "pass");
        this.paginaDeLeiloes = paginaDeLogin.logar();
        CadastroLeilaoPage paginaDeCadastroLeilao = paginaDeLeiloes.carregarFormulario();

        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilão do dia " + hoje;
        String valor = "500.00";
        this.paginaDeLeiloes = paginaDeCadastroLeilao.cadastrarLeilao(nome, valor, hoje);
        Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
    }

    @Test
    public void deveriaValidarCadastroDeLeilao() {
        this.paginaDeLeiloes = paginaDeCadastroLeilao.cadastrarLeilao("", "", "");
        Assert.assertFalse(this.paginaDeCadastroLeilao.isPaginaAtual());
        Assert.assertTrue(this.paginaDeLeiloes.isPaginaAtual());
        Assert.assertTrue(this.paginaDeCadastroLeilao.isMensagensValidacoesVisiveis());
    }
}
