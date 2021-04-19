package page.QAnova;

import Utils.DriverContext;
import Utils.Validaciones;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MensajeErrorSesion {
    //Almacenamiento de xpath,id,etc
    @FindBy(xpath = "//*[@id=\"imLoginPage\"]/div[3]/div")
    WebElement msmError;

    //Metodo que levante el sitio web donde vamos a trabajar
    public MensajeErrorSesion() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    //Metodo que en este caso recupera el nombre y color del mensaje de error
    public void recuperarMensaje(){
        try{
            Validaciones.validarObjeto(msmError,"Cuadro de texto del mensaje de error");
            System.out.println(msmError.getCssValue("color"));
            msmError.getText();
            System.out.println(msmError.getText());
            Assert.assertEquals(msmError.getText(), "Nombre y/o password incorrecto");
        }catch (Exception e) {
            System.out.println("Elemento web no encontrado");
        }
    }
}