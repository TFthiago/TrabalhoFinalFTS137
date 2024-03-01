package TesteWeb.CucumberStepsPO;

import TesteWeb.Pages.CartPage;
import TesteWeb.Pages.HomePage;
import TesteWeb.Pages.ProductPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CucumberPOWebTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public ProductPage productPage;
    public CartPage cartPage;
    public String url = "https://www.giulianaflores.com.br";

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofMillis(15000));
        System.setProperty("webdriver.chrome.driver", "Driver/Chrome/chromedriver.exe");

        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("o usuario tenha acessado a pagina inicial do site Giuliana Flores")
    public void o_usuario_tenha_acessado_a_pagina_inicial_do_site_giuliana_flores() {
        driver.get(url);
    }
    @When("ele pesquisa por {string}")
    public void ele_pesquisa_por(String orquidea) {
        homePage.clickCampoDeBusca();
        homePage.sendKeysCampoDeBusca(orquidea);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.byElementoListaAutomatica));
        homePage.clickElementoListaAutomatica();

        assertEquals("ORQUÍDEA MINE RARA ROSA",
                productPage.readProductName());
        assertEquals("R$ 182,90",
                productPage.readProductPrice());

    }
    @And("adiciona o produto ao carrinho")
    public void adiciona_o_produto_ao_carrinho() {
        productPage.clickCampoCEP();
        productPage.sendKeysCampoCEP();
        productPage.clickBtnConfirmaCEP();

        wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.bySelecionaProximoMes));
        productPage.clickSelecionaProximoMes();

        wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.byBtnSelecionaData));
        productPage.clickBtnSelecionaData();
        productPage.clickBtnConfirmaData();
        wait.until(ExpectedConditions.elementToBeClickable(productPage.byBtnComprar));
        productPage.clickBtnComprar();

        wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage.byProductName1));
        assertEquals("Orquídea Mine Rara Rosa",
                cartPage.readProductName1());
        assertEquals("R$ 182,90",
                cartPage.readProductPrice1());

    }
    @And("depois por {string}")
    public void e_depois_por(String margarida) {
        cartPage.clickLogoTitle();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.byCampoDeBusca));

        homePage.clickCampoDeBusca();
        homePage.sendKeysCampoDeBusca(margarida);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.byElementoListaAutomatica));
        homePage.clickElementoListaAutomatica();

        assertEquals("BUQUÊ MAGNIFICAS MARGARIDAS AMARELAS",
                productPage.readProductName());
        assertEquals("R$ 69,90",
                productPage.readProductPrice());

    }
    @And("realiza o mesmo processo")
    public void realiza_o_mesmo_processo() {
        productPage.clickBtnConfirmaCEP();

        wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.bySelecionaProximoMes));
        productPage.clickSelecionaProximoMes();

        wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.byBtnSelecionaData));
        productPage.clickBtnSelecionaData();
        productPage.clickBtnConfirmaData();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.byBtnComprar));
        productPage.clickBtnComprar();

        wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage.byPopupCookies));
        assertEquals("Buquê Magnificas Margaridas Amarelas",
                cartPage.readProductName2());
        assertEquals("R$ 69,90",
                cartPage.readProductPrice2());

    }
    @Then("ele consegue adicionar ambos os itens ao carrinho de forma separada")
    public void ele_consegue_adicionar_ambos_os_itens_ao_carrinho_de_forma_separada() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage.byValorTotalTitle));
        assertEquals("VALOR TOTAL DA COMPRA:",
                cartPage.readValorTotalElement());
        assertEquals("R$ 353,54",
                cartPage.readValorTotal());

        assertEquals("Orquídea Mine Rara Rosa",
                cartPage.readProductName1());
        assertEquals("R$ 182,90",
                cartPage.readProductPrice1());

        assertEquals("Buquê Magnificas Margaridas Amarelas",
                cartPage.readProductName2());
        assertEquals("R$ 69,90",
                cartPage.readProductPrice2());
    }
}
