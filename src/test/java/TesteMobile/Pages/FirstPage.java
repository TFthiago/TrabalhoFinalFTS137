package TesteMobile.Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class FirstPage extends Base {

    public FirstPage(WebDriver driver) {
        super(driver);
    }

    public By byBtnFecharMensagem = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView");
    public void clickBtnFecharMensagem(){
        this.driver.findElement(byBtnFecharMensagem).click();
    }

    public By byBtnPularAnuncio = AppiumBy.xpath("//android.widget.TextView[@text=\"Pular\"]");
    public void clickBtnPularAnuncio(){
        this.driver.findElement(byBtnPularAnuncio).click();
    }

    public By byBtnEntrarAplicativo = AppiumBy.xpath("//android.widget.TextView[@text=\"Entrar\"]");
    public void clickBtnEntrarAplicativo(){
        this.driver.findElement(byBtnEntrarAplicativo);
    }

}
