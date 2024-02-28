package TesteMobile.Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageM extends Base{
    public HomePageM(WebDriver driver) {
        super(driver);
    }

    public By byBtnNegarAvaliacao = AppiumBy.xpath("//android.widget.TextView[@text=\"NÃO, OBRIGADO\"]");
    public void clickBtnNegarAvaliacao(){
        this.driver.findElement(byBtnNegarAvaliacao).click();
    }

    public By byBtnBuscarEndereco = AppiumBy.xpath("//android.widget.TextView[@text=\"Buscar por endereço de entrega\"]");
    public void clickBtnBuscarEndereco(){
        this.driver.findElement(byBtnBuscarEndereco).click();
    }

    public By byCampoBuscaEndereco = AppiumBy.xpath("android.widget.EditText");
    public void clickCampoBuscaEndereco(){
        this.driver.findElement(byCampoBuscaEndereco).click();
    }
    public void senKeysEndereco(){
        this.driver.findElement(byCampoBuscaEndereco).sendKeys("57010003");
    }

    public By byCampoEndereco = AppiumBy.xpath("//android.widget.TextView[@text=\"Avenida Siqueira Campos, Prado, Maceió - AL, 57010003, Brasil\"]");
    public void clickCampoEndereco(){
        this.driver.findElement(byCampoEndereco).click();
    }

    public By byBtnProximo = AppiumBy.xpath("//android.widget.TextView[@text=\"Próximo\"]");
    public void clickBtnProximo(){
        this.driver.findElement(byBtnProximo).click();
    }

    public By byMarcadorDestino = AppiumBy.xpath("(//android.widget.TextView[@text=\"\"])[1]");
    public void clickMarcadorDestino(){
        this.driver.findElement(byMarcadorDestino).click();
    }

    public By byBtnSalvarEndereco = AppiumBy.xpath("//android.widget.TextView[@text=\"Salvar Endereço\"]");
    public void clickBtnSalvarEndereco(){
        this.driver.findElement(byBtnSalvarEndereco).click();
    }

    public By byBtnOkMensagem = AppiumBy.xpath("android:id/button1");
    public void clickBtnOkMensagem(){
        this.driver.findElement(byBtnOkMensagem).click();
    }

    public By byCampoBuscaProduto = AppiumBy.xpath("android.widget.EditText");
    public void sendKeysProduto(){
        this.driver.findElement(byCampoBuscaProduto).sendKeys("Ramalhete com Dois Girassóis");
    }
    public void clickCampoBuscaProduto(){
        this.driver.findElement(byCampoBuscaProduto).click();
    }

    public By byCampoProdutoIcone = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Ramalhete com Dois Girassóis\"]/android.view.ViewGroup");
    public void clickCampoProdutoIcone(){
        this.driver.findElement(byCampoProdutoIcone).click();
    }
    public void clickCampoProdutoIcone2(){
        this.driver.findElement(byCampoProdutoIcone).click();
    }

}
