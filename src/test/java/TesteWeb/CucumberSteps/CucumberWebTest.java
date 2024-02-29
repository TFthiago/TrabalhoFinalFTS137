package TesteWeb.CucumberSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CucumberWebTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public String url = "https://www.giulianaflores.com.br";

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofMillis(15000));
        System.setProperty("webdriver.chrome.driver", "Driver/Chrome/chromedriver.exe");
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
        driver.findElement(By.cssSelector(".form_busca")).click();
        driver.findElement(By.cssSelector(".form_busca")).sendKeys(orquidea);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".autocomplete_completionListElement")));
        driver.findElement(By.cssSelector(".autocomplete_completionListElement")).click();

        assertEquals("ORQUÍDEA MINE RARA ROSA", driver.findElement(By.cssSelector("h1 span")).getText());
        assertEquals("R$ 182,90", driver.findElement(By.cssSelector("span.precoPor_prod")).getText());

    }
    @And("adiciona o produto ao carrinho")
    public void adiciona_o_produto_ao_carrinho() {
        driver.findElement(By.cssSelector("span [name = \"ctl00$ContentSite$txtZip\"]")).click();
        driver.findElement(By.cssSelector("span [name = \"ctl00$ContentSite$txtZip\"]")).sendKeys("57010003");
        driver.findElement(By.cssSelector("[class = \"btn_okcep jOpenShippingPopup\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div [class = 'bt_Month jNextMonth']")));
        driver.findElement(By.cssSelector("div [class = 'bt_Month jNextMonth']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li input.jPeriodRadio")));
        driver.findElement(By.cssSelector("li input.jPeriodRadio")).click();
        driver.findElement(By.cssSelector("div [class = \"btOk jConfirmShippingData\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bt_comprar")));
        driver.findElement(By.cssSelector("div.bt_comprar")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class = \"adopt-c-bXGRNs\"]")));
        assertEquals("Orquídea Mine Rara Rosa", driver.findElement(By.cssSelector("span[class = \"prodBasket_nome\"]")).getText());
        assertEquals("R$ 182,90", driver.findElement(By.cssSelector("span[class = \"precoPor_basket\"]")).getText());

    }
    @And("depois por {string}")
    public void e_depois_por(String margarida) {
        driver.findElement(By.cssSelector("a img[title = \"Giuliana Flores\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form_busca")));

        driver.findElement(By.cssSelector(".form_busca")).click();
        driver.findElement(By.cssSelector(".form_busca")).sendKeys(margarida);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".autocomplete_completionListElement")));
        driver.findElement(By.cssSelector(".autocomplete_completionListElement")).click();

        assertEquals("BUQUÊ MAGNIFICAS MARGARIDAS AMARELAS", driver.findElement(By.cssSelector("h1 span")).getText());
        assertEquals("R$ 69,90", driver.findElement(By.cssSelector("span.precoPor_prod")).getText());

    }
    @And("realiza o mesmo processo")
    public void realiza_o_mesmo_processo() {
        driver.findElement(By.cssSelector("[class = \"btn_okcep jOpenShippingPopup\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div [class = 'bt_Month jNextMonth']")));

        driver.findElement(By.cssSelector("div [class = 'bt_Month jNextMonth']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li input.jPeriodRadio")));
        driver.findElement(By.cssSelector("li input.jPeriodRadio")).click();
        driver.findElement(By.cssSelector("div [class = \"btOk jConfirmShippingData\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bt_comprar")));
        driver.findElement(By.cssSelector("div.bt_comprar")).click();

        //Como os elementos correspondentes aos preços e nomes são identicos, ao realizar o teste com 2 produtos tive que optar pelo xpath
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class = \"adopt-c-bXGRNs\"]")));
        assertEquals("Buquê Magnificas Margaridas Amarelas",driver.findElement(By.xpath("//*[@id=\"ContentSite_Basketcontrol1_idUpdatePanel\"]/div[2]/div[2]/ul[2]/li/div[2]/span[1]")).getText());
        assertEquals("R$ 69,90", driver.findElement(By.xpath("//*[@id=\"ContentSite_Basketcontrol1_idUpdatePanel\"]/div[2]/div[2]/ul[2]/li/div[4]/span[2]")).getText());

    }
    @Then("ele consegue adicionar ambos os itens ao carrinho de forma separada")
    public void ele_consegue_adicionar_ambos_os_itens_ao_carrinho_de_forma_separada() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class = \"valores_basket valorTotal total-todos-destinatarios\"]")));

        assertEquals("VALOR TOTAL DA COMPRA:",
                driver.findElement(By.xpath("//*[@id=\"ContentSite_Basketcontrol1_rptBasket_ulVlTotalOrder_1\"]/div[1]/span[1]")).getText());
        assertEquals("R$ 353,54",
                driver.findElement(By.xpath("//*[@id=\"ContentSite_Basketcontrol1_rptBasket_ulVlTotalOrder_1\"]/div[1]/span[2]")).getText());
    }

}
