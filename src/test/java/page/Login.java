package page;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    @FindBy(id="imUname")
    WebElement txtUsuario;

    @FindBy(id="imPwd")
    WebElement txtClave;

    @FindBy(xpath = "//*[@id=\"imLogin\"]/form/div[3]/input")
    WebElement btnIngresar;

    public Login(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    public void ingresarUsuario(String usuario, String clave) throws InterruptedException{

        txtUsuario.sendKeys(usuario);
        txtClave.click();
        txtClave.sendKeys(clave);
        btnIngresar.click();


    }
}
