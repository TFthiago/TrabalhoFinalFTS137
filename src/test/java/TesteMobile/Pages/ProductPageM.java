package TesteMobile.Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPageM extends Base{
    public ProductPageM(WebDriver driver) {
        super(driver);
    }

    public By byInfoNomeProduto = AppiumBy.xpath("(//android.widget.TextView[@text=\"Ramalhete com Dois Girassóis\"])[2]");
    public String readInfoNomeProduto(){
        return driver.findElement(byInfoNomeProduto).getText();
    }

    public By byInfoPrecoProduto = AppiumBy.xpath("//android.widget.TextView[@text=\" R$ 42,90\"]");
    public String readInfoPrecoProduto(){
        return driver.findElement(byInfoPrecoProduto).getText();
    }

    public By byBtnContinuar = AppiumBy.xpath("//android.widget.TextView[@text=\"CONTINUAR\"]");
    public void clickBtnContinuar(){
        this.driver.findElement(byBtnContinuar).click();
    }

    public By byMarcadorData = AppiumBy.xpath("//android.widget.TextView[@text=\"28\"]");
    public void clickMarcadorData(){
        this.driver.findElement(byMarcadorData).click();
    }

    public By byBtnContinuar2 = AppiumBy.xpath("//android.widget.TextView[@text=\"CONTINUAR\"]");
    public void clickBtnContinuar2(){
        this.driver.findElement(byBtnContinuar2).click();
    }
}
