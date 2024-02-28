package TesteMobile.Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageM extends Base {


    public LoginPageM(WebDriver driver) {
        super(driver);
    }

    public By byCampoEmail = AppiumBy.xpath("//android.widget.EditText[@text=\"   Digite seu e-mail ou CPF\"]");
    public void sendKeysEmail(){
        this.driver.findElement(byCampoEmail).sendKeys("tftester26@yopmail.com");
    }

    public By byCampoSenha = AppiumBy.xpath("//android.widget.EditText[@text=\"Digite sua senha\"]");
    public void sendKeysSenha(){
        this.driver.findElement(byCampoSenha).sendKeys("Tf121416@");
    }

    public By byBtnEntrar = AppiumBy.xpath("//android.widget.TextView[@text=\"Entrar\"]");
    public void clickBtnEntrar(){
        this.driver.findElement(byBtnEntrar).click();
    }

    public By byBtnNegarPermissao = AppiumBy.xpath("com.android.permissioncontroller:id/permission_deny_button");
    public void clickBtnNegarPermissao(){
        this.driver.findElement(byBtnNegarPermissao).click();
    }

}
