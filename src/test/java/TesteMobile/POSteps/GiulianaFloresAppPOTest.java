package TesteMobile.POSteps;

import TesteMobile.Pages.*;
import TesteWeb.Pages.CartPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GiulianaFloresAppPOTest {

    public AndroidDriver driver;
    public WebDriverWait wait;
    public FirstPageM firstPageM;
    public LoginPageM loginPageM;
    public HomePageM homePageM;
    public ProductPageM productPageM;
    public CartPageM cartPageM;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:deviceName", "emulator-5554")
                .amend("appium:automationName", "uiautomator2")
                .amend("appium:appPackage", "br.com.giulianaflores.android")
                .amend("appium:appActivity", "br.com.giulianaflores.android.MainActivity")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);



        URL privateUrl = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(privateUrl, options);
        wait = new WebDriverWait(driver, Duration.ofMillis(20000));

        firstPageM = new FirstPageM(driver);
        loginPageM = new LoginPageM(driver);
        homePageM = new HomePageM(driver);
        productPageM = new ProductPageM(driver);
        cartPageM = new CartPageM(driver);

    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void AppiumPOTest() {

    wait.until(ExpectedConditions.elementToBeClickable(firstPageM.byBtnFecharMensagem));

    firstPageM.clickBtnFecharMensagem();
    firstPageM.clickBtnPularAnuncio();
    firstPageM.clickBtnEntrarAplicativo();

    wait.until(ExpectedConditions.elementToBeClickable(loginPageM.byCampoEmail));

    loginPageM.sendKeysEmail();
    loginPageM.sendKeysSenha();
    loginPageM.clickBtnEntrar();
    loginPageM.clickBtnNegarPermissao();

    wait.until(ExpectedConditions.visibilityOfElementLocated(homePageM.byBtnNegarAvaliacao));

    homePageM.clickBtnNegarAvaliacao();

    wait.until(ExpectedConditions.elementToBeClickable(homePageM.byBtnBuscarEndereco));

    homePageM.clickBtnBuscarEndereco();
    homePageM.clickCampoBuscaEndereco();
    homePageM.senKeysEndereco();

    wait.until(ExpectedConditions.visibilityOfElementLocated(homePageM.byCampoEndereco));

    homePageM.clickCampoEndereco();
    homePageM.clickBtnProximo();

    wait.until(ExpectedConditions.visibilityOfElementLocated(homePageM.byMarcadorDestino));

    homePageM.clickMarcadorDestino();
    homePageM.clickBtnSalvarEndereco();

    wait.until(ExpectedConditions.visibilityOfElementLocated(homePageM.byBtnOkMensagem));

    homePageM.clickBtnOkMensagem();
    homePageM.sendKeysProduto();
    homePageM.clickCampoBuscaProduto();
    homePageM.clickCampoProdutoIcone();
    homePageM.clickCampoProdutoIcone();

    wait.until(ExpectedConditions.visibilityOfElementLocated(productPageM.byInfoNomeProduto));

    productPageM.readInfoNomeProduto();
    productPageM.readInfoPrecoProduto();
    productPageM.clickBtnContinuar();
    productPageM.clickBtnContinuar2();

    cartPageM.readInfoNomeProduto2();
    cartPageM.readInfoPrecoProduto2();

    }
}
