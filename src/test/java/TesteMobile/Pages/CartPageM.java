package TesteMobile.Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPageM extends Base{
    public CartPageM(WebDriver driver) {
        super(driver);
    }

    public By byInfoNomeProduto2 = AppiumBy.xpath("//android.widget.TextView[@text=\"Ramalhete com Dois Girassóis\"]");
    public String readInfoNomeProduto2(){
        return driver.findElement(byInfoNomeProduto2).getText();
    }

    public By byInfoPrecoProduto2 = AppiumBy.xpath("(//android.widget.TextView[@text=\"R$ 42,90\"])[1]");
    public String readInfoPrecoProduto2(){
        return driver.findElement(byInfoPrecoProduto2).getText();
    }
}
