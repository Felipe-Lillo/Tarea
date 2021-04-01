package page;

import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Tarea {
    //Almacenamiento de xpath,id,etc
    @FindBy(id = "imUname")
    WebElement txtUsuario;

    @FindBy(id = "imPwd")
    WebElement txtClave;

    @FindBy(xpath = "//*[@id=\"imLoginPage\"]/div[3]/div")
    WebElement msmError;

    @FindBy(xpath = "//*[@id=\"imLogin\"]/form/div[3]/input")
    WebElement btnIngresar;

    //Metodo que levante el sitio web donde vamos a trabajar
    public Tarea() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    //Metodo que en este caso recupera el nombre y color del mensaje de error
    public void recuperarMensaje() throws InterruptedException {
        txtUsuario.sendKeys(ReadProperties.readFromConfig("Properties.properties").getProperty("usuario"));
        txtClave.sendKeys(ReadProperties.readFromConfig("Properties.properties").getProperty("clave"));
        PdfQaNovaReports.addWebReportImage("Relleno de campos con datos erróneos", "Se ingresan datos erroneos en los campos de texto [Usuario] y [Clave], luego se presiona el boton [Ingresa Demo]", EstadoPrueba.PASSED, false);
        btnIngresar.click();

        PdfQaNovaReports.addWebReportImage("Mensaje de error", "Se ingresan las credenciales con datos erróneos y se muestra el mensaje de error Nombre y/o password incorrecto en un recuadro de color rojo", EstadoPrueba.PASSED, false);
        msmError.getCssValue("Color");
        System.out.println(msmError.getCssValue("color"));
        msmError.getText();
        System.out.println(msmError.getText());
        Assert.assertEquals(msmError.getText(), "Nombre y/o password incorrecto");


    }
}