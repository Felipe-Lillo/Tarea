package page;

import Utils.DriverContext;
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

    /**
     * Metodo para ingresar al login de la pagina
     * @param usuario
     * @param clave
     * @throws InterruptedException
     */
    public void ingresarUsuario(String usuario, String clave) throws InterruptedException {

        txtUsuario.sendKeys(usuario);
        txtClave.sendKeys(clave);
        //PdfQaNovaReports.addWebReportImage("Ingresando_la página", "Se ingresa a la pagina Web con la Dirección http://www.qanovagroup.com/piloto/index.php y se entregan lo datos  necesarios (usuario y contrasena validos)", EstadoPrueba.PASSED, false);
        btnIngresar.click();
        Thread.sleep(2000);
        //PdfQaNovaReports.addWebReportImage("Pestaña Carga de información", "Se muestra satisfactoriamente el ingreso a la página", EstadoPrueba.PASSED, false);


    }
}
