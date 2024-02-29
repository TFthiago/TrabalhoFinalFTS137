package TesteWeb.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends Base {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public By byPopupCookies = By.cssSelector("[class = \"adopt-c-bXGRNs\"]");

    public By byProductName1 = By.cssSelector("span[class = \"prodBasket_nome\"]");
    public String readProductName1(){
        return driver.findElement(byProductName1).getText();
    }

    public By byProductPrice1 = By.cssSelector("span[class = \"precoPor_basket\"");
    public String readProductPrice1(){
        return driver.findElement(byProductPrice1).getText();
    }

    public By byProductName2 = By.xpath("//*[@id=\"ContentSite_Basketcontrol1_idUpdatePanel\"]/div[2]/div[2]/ul[2]/li/div[2]/span[1]");
    public String readProductName2() {
        return driver.findElement(byProductName2).getText();
    }

    public By byProductPrice2 = By.xpath("//*[@id=\"ContentSite_Basketcontrol1_idUpdatePanel\"]/div[2]/div[2]/ul[2]/li/div[4]/span[2]");
    public String readProductPrice2(){
        return driver.findElement(byProductPrice2).getText();
    }

    public By byLogoTitle = By.cssSelector("a img[title = \"Giuliana Flores\"]");
    public void clickLogoTitle(){
        this.driver.findElement(byLogoTitle).click();
    }

    public By byValorTotalTitle = By.cssSelector("div[class = \"valores_basket valorTotal total-todos-destinatarios\"]");

    public By byValorTotalElement = By.xpath("//*[@id=\"ContentSite_Basketcontrol1_rptBasket_ulVlTotalOrder_1\"]/div[1]/span[1]");
    public String readValorTotalElement(){
        return driver.findElement(byValorTotalElement).getText();
    }

    public By byValorTotal = By.xpath("//*[@id=\"ContentSite_Basketcontrol1_rptBasket_ulVlTotalOrder_1\"]/div[1]/span[2]");
    public String readValorTotal(){
        return driver.findElement(byValorTotal).getText();
    }
}
