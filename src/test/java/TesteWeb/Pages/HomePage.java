package TesteWeb.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Base {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String byProduto(String Produto){
        return Produto;
    }
    public By byCampoDeBusca = By.cssSelector(".form_busca");
    public void clickCampoDeBusca(){
        this.driver.findElement(byCampoDeBusca).click();
    }
    public void sendKeysCampoDeBusca(String Flor){
        this.driver.findElement(byCampoDeBusca).sendKeys(byProduto(Flor));
    }
    public By byElementoListaAutomatica = By.cssSelector(".autocomplete_completionListElement");
    public void clickElementoListaAutomatica(){
        this.driver.findElement(byElementoListaAutomatica).click();
    }

}
