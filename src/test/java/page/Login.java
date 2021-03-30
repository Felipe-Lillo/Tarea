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
        txtClave.sendKeys(clave);
        //PdfQaNovaReports.addWebReportImage("Ingresando_la página", "Se ingresa a la pagina Web con la Dirección http://www.qanovagroup.com/piloto/index.php y se entregan lo datos  necesarios (usuario y contrasena validos)", EstadoPrueba.PASSED, false);
        btnIngresar.click();
        Thread.sleep(2000);
        //PdfQaNovaReports.addWebReportImage("Pestaña Carga de información", "Se muestra satisfactoriamente el ingreso a la página", EstadoPrueba.PASSED, false);


    }
}
