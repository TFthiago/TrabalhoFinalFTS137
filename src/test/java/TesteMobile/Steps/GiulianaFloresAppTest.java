package TesteMobile.Steps;

import io.appium.java_client.AppiumBy;
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

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GiulianaFloresAppTest {
    public AndroidDriver driver;
    public WebDriverWait wait;

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

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void AppiumTest() {

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView")));

        var btnFecharMensagem = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView"));
        btnFecharMensagem.click();
        var btnPularAnuncio = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Pular\"]"));
        btnPularAnuncio.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/button2")));

        var btnNegarAtualizacao = driver.findElement(AppiumBy.id("android:id/button2"));
        btnNegarAtualizacao.click();
        var btnEntrarAplicativo = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Entrar\"]"));
        btnEntrarAplicativo.click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text=\"   Digite seu e-mail ou CPF\"]")));

        var campoEmail = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"   Digite seu e-mail ou CPF\"]"));
        campoEmail.sendKeys("tftester26@yopmail.com");
        var campoSenha = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Digite sua senha\"]"));
        campoSenha.sendKeys("Tf121416@");
        var btnEntrar = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Entrar\"]"));
        btnEntrar.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button")));
        var btnNegarPermissao = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button"));
        btnNegarPermissao.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"NÃO, OBRIGADO\"]")));

        var btnNegarAvaliacao = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"NÃO, OBRIGADO\"]"));
        btnNegarAvaliacao.click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"Buscar por endereço de entrega\"]")));

        var btnBuscarEndereco = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Buscar por endereço de entrega\"]"));
        btnBuscarEndereco.click();
        var campoBuscaEndereco = driver.findElement(AppiumBy.className("android.widget.EditText"));
        campoBuscaEndereco.click();
        //campoBuscaEndereco.sendKeys("57010003");
        var campoBuscaEndereco2 = driver.findElement(AppiumBy.className("android.widget.EditText"));
        campoBuscaEndereco2.sendKeys("57010003");

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Avenida Siqueira Campos, Prado, Maceió - AL, 57010003, Brasil\"]")));

        var campoEndereco = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Avenida Siqueira Campos, Prado, Maceió - AL, 57010003, Brasil\"]"));
        campoEndereco.click();
        var btnProximo = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Próximo\"]"));
        btnProximo.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.TextView[@text=\"\"])[1]")));

        var marcadorDestino = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text=\"\"])[1]"));
        marcadorDestino.click();
        var btnSalvarEndereco = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Salvar Endereço\"]"));
        btnSalvarEndereco.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/button1")));

        var btnOkMensagem = driver.findElement(AppiumBy.id("android:id/button1"));
        btnOkMensagem.click();
        var campoBuscaProduto = driver.findElement(AppiumBy.className("android.widget.EditText"));
        campoBuscaProduto.sendKeys("Ramalhete com Dois Girassóis");
        campoBuscaProduto.click();
        var campoProdutoIcone = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Ramalhete com Dois Girassóis\"]/android.view.ViewGroup"));
        campoProdutoIcone.click();
        campoProdutoIcone.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.TextView[@text=\"Ramalhete com Dois Girassóis\"])[2]")));

        var infoNomeProduto = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text=\"Ramalhete com Dois Girassóis\"])[2]"));
        assertEquals("Ramalhete com Dois Girassóis",infoNomeProduto.getText());

        var infoPrecoProduto = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" R$ 42,90\"]"));
        assertEquals(" R$ 42,90",infoPrecoProduto.getText());

        var btnContinuar = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"CONTINUAR\"]"));
        btnContinuar.click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"27\"]")));

        var btnContinuar2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"CONTINUAR\"]"));
        btnContinuar2.click();

        var infoNomeProduto2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Ramalhete com Dois Girassóis\"]"));
        assertEquals("Ramalhete com Dois Girassóis",infoNomeProduto2.getText());

        var infoPrecoProduto2 = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text=\"R$ 42,90\"])[1]"));
        assertEquals("R$ 42,90",infoPrecoProduto2.getText());
    }
}
