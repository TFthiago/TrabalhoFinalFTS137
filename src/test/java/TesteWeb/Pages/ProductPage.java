package TesteWeb.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Base {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public By byProductName = By.cssSelector("h1 span");
    public String readProductName(){
        return driver.findElement(byProductName).getText();
    }

    public By byProductPrice = By.cssSelector("span.precoPor_prod");
    public String readProductPrice(){
        return driver.findElement(byProductPrice).getText();
    }

    public By byCampoCEP = By.cssSelector("span [name = \"ctl00$ContentSite$txtZip\"]");
    public void clickCampoCEP(){
        this.driver.findElement(byCampoCEP).click();
    }
    public void sendKeysCampoCEP(){
        this.driver.findElement(byCampoCEP).sendKeys("57010003");
    }

    public By byBtnConfirmaCEP = By.cssSelector("[class = \"btn_okcep jOpenShippingPopup\"]");
    public void clickBtnConfirmaCEP(){
        this.driver.findElement(byBtnConfirmaCEP).click();
    }

    public By byElementoCalendario = By.cssSelector("[class = \"jSelectedMonth\"]");

    public By byBtnSelecionaData = By.cssSelector("li input.jPeriodRadio");
    public void clickBtnSelecionaData(){
        this.driver.findElement(byBtnSelecionaData).click();
    }

    public By byBtnConfirmaData = By.cssSelector("div [class = \"btOk jConfirmShippingData\"]");
    public void clickBtnConfirmaData(){
        this.driver.findElement(byBtnConfirmaData).click();
    }

    public By byBtnComprar = By.cssSelector("div.bt_comprar");
    public void clickBtnComprar(){
        this.driver.findElement(byBtnComprar).click();
    }
}
