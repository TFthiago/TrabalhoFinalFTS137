package TesteWeb.Steps;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimpleScriptTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public String url = "https://www.giulianaflores.com.br";

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofMillis(15000));
        System.setProperty("webdriver.chrome.driver", "Driver/Chrome/chromedriver.exe");
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void scriptSimplesWebTest(){
        //Acessar URL
        driver.get(url);

        //Consultar por "Orquídea Mine Rara Rosa"
        driver.findElement(By.cssSelector(".form_busca")).click();
        driver.findElement(By.cssSelector(".form_busca")).sendKeys("Orquídea Mine Rara Rosa");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".autocomplete_completionListElement")));
        driver.findElement(By.cssSelector(".autocomplete_completionListElement")).click();

        //Primeira validação
        assertEquals("ORQUÍDEA MINE RARA ROSA", driver.findElement(By.cssSelector("h1 span")).getText());
        assertEquals("R$ 182,90", driver.findElement(By.cssSelector("span.precoPor_prod")).getText());

        //Acrescentar ao carrinho de compras
        driver.findElement(By.cssSelector("span [name = \"ctl00$ContentSite$txtZip\"]")).click();
        driver.findElement(By.cssSelector("span [name = \"ctl00$ContentSite$txtZip\"]")).sendKeys("57010003");
        driver.findElement(By.cssSelector("[class = \"btn_okcep jOpenShippingPopup\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class = \"data_dia jCalendarDate\"]")));
        driver.findElement(By.cssSelector("div [class = \"btOk jConfirmShippingData\"]")).click();
        driver.findElement(By.cssSelector("div.bt_comprar")).click();

        //Segunda validação
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class = \"adopt-c-bXGRNs\"]")));
        assertEquals("Orquídea Mine Rara Rosa", driver.findElement(By.cssSelector("div [class = \"prodBasket_nome\"]")).getText());
        assertEquals("R$ 182,90", driver.findElement(By.cssSelector("div [class = \"precoPor_basket\"]")).getText());
    }
}