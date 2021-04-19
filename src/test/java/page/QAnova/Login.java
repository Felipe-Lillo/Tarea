package page.QAnova;

import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import Utils.Validaciones;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    //Sitio donde se obtienen y se almacenan los xpath,id,etc.
    @FindBy(id = "imUname")
    WebElement txtUsuario;

    @FindBy(id = "imPwd")
    WebElement txtClave;

    @FindBy(xpath = "//*[@id=\"imLogin\"]/form/div[3]/input")
    WebElement btnIngresar;
    //Metodo que levante el sitio web donde vamos a trabajar
    public Login() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void validarDeslpiegue(){
        Validaciones.validarObjeto(btnIngresar,"boton ingresar");
    }
    /**
     * Metodo para ingresar al login de la pagina
     * @param usuario
     * @param clave
     * @throws InterruptedException
     */
    public void ingresar(String usuario, String clave){
        txtUsuario.sendKeys(usuario);
        txtClave.sendKeys(clave);
        PdfQaNovaReports.addWebReportImage("Ingreso de credenciales","Se entregan las credenciales de los uaurios",EstadoPrueba.PASSED,false);
        btnIngresar.click();
        PdfQaNovaReports.addWebReportImage("Ingreso de usuario exitoso","Se logra ingresar correctamente al usuario", EstadoPrueba.PASSED,false);
    }
}
