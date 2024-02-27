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


public class MobileAppiumLocalHostTest {
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
    public void sampleTest() {

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView")));

        var el1 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView"));
        el1.click();
        var el2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Pular\"]"));
        el2.click();
        var el3 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Entrar\"]"));
        el3.click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text=\"   Digite seu e-mail ou CPF\"]")));

        var el4 = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"   Digite seu e-mail ou CPF\"]"));
        el4.sendKeys("tftester26@yopmail.com");
        var el5 = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Digite sua senha\"]"));
        el5.sendKeys("Tf121416@");
        var el6 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Entrar\"]"));
        el6.click();
        var el7 = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button"));
        el7.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"NÃO, OBRIGADO\"]")));

        var el8 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"NÃO, OBRIGADO\"]"));
        el8.click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"Buscar por endereço de entrega\"]")));

        var el9 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Buscar por endereço de entrega\"]"));
        el9.click();
        var el10 = driver.findElement(AppiumBy.className("android.widget.EditText"));
        el10.click();
        var el100 = driver.findElement(AppiumBy.className("android.widget.EditText"));
        el100.sendKeys("57010003");

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Avenida Siqueira Campos, Prado, Maceió - AL, 57010003, Brasil\"]")));

        var el11 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Avenida Siqueira Campos, Prado, Maceió - AL, 57010003, Brasil\"]"));
        el11.click();
        var el12 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Próximo\"]"));
        el12.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.TextView[@text=\"\"])[1]")));

        var el13 = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text=\"\"])[1]"));
        el13.click();
        var el14 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Salvar Endereço\"]"));
        el14.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/button1")));

        var el15 = driver.findElement(AppiumBy.id("android:id/button1"));
        el15.click();
        var el16 = driver.findElement(AppiumBy.className("android.widget.EditText"));
        el16.sendKeys("Ramalhete com Dois Girassóis");
        el16.click();
        var el17 = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Ramalhete com Dois Girassóis\"]/android.view.ViewGroup"));
        el17.click();
        el17.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.TextView[@text=\"Ramalhete com Dois Girassóis\"])[2]")));

        var el18 = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text=\"Ramalhete com Dois Girassóis\"])[2]"));
        el18.click();
        var el19 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" R$ 42,90\"]"));
        el19.click();
        var el20 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"CONTINUAR\"]"));
        el20.click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"27\"]")));

        var el21 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"27\"]"));
        el21.click();
        var el22 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"CONTINUAR\"]"));
        el22.click();
        var el23 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Ramalhete com Dois Girassóis\"]"));
        el23.click();
        var el24 = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text=\"R$ 42,90\"])[1]"));
        el24.click();
    }
}
