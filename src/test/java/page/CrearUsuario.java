package page;

import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import Utils.Validaciones;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrearUsuario {
    @FindBy ( xpath = "//*[@id=\"dynObj_02\"]/p/a")
    WebElement linkAqui;
    @FindBy(xpath = "//*[@id=\"imRegUname\"]")
    WebElement txtNombreUsuario;
    @FindBy(xpath = "//*[@id=\"imRegPwd\"]")
    WebElement txtClaveUsuario;
    @FindBy(xpath = "//*[@id=\"imRepeatPwd\"]")
    WebElement txtRepiteClave;
    @FindBy(xpath = "//*[@id=\"imRealname\"]")
    WebElement txtNombreCompleto;
    @FindBy(xpath = "//*[@id=\"imEmail\"]")
    WebElement txtMailUsuario;
    @FindBy(xpath = "//*[@id=\"imRegister_submit\"]")
    WebElement btnRegistrarse;
    @FindBy(xpath = "//*[@id=\"imLoginPage\"]/div[4]/div")
    WebElement ctxtRegistroCompletado;

    public CrearUsuario(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    public void ingresarNuevoUsuario() throws InterruptedException{
        Validaciones.validarObjeto(linkAqui,"link presione AQUI");
        PdfQaNovaReports.addWebReportImage("Pestaña principal", "Pestaña principal donde se encuentra el link para rediriguir a la pestaña de creación de cuenta", EstadoPrueba.PASSED,false);
        linkAqui.click();
        Validaciones.validarObjeto(txtNombreUsuario,"Campo de texto Nombre de usuario");
        txtNombreUsuario.sendKeys(ReadProperties.readFromConfig("Properties.properties").getProperty("NombreUsuario"));
        txtClaveUsuario.sendKeys(ReadProperties.readFromConfig("Properties.properties").getProperty("ClaveUsuario"));
        txtRepiteClave.sendKeys(ReadProperties.readFromConfig("Properties.properties").getProperty("ClaveUsuario"));
        txtMailUsuario.sendKeys(ReadProperties.readFromConfig("Properties.properties").getProperty("MailUsuario"));
        txtNombreCompleto.sendKeys(ReadProperties.readFromConfig("Properties.properties").getProperty("NombreCompleto"));
        PdfQaNovaReports.addWebReportImage("Ingreso de datos", "Ingreso de los datos de creacion de un nuevo usuario",EstadoPrueba.PASSED,false);
        btnRegistrarse.click();
        PdfQaNovaReports.addWebReportImage("PA001", "visualización del recuadro 'Registro completado con exito.'",EstadoPrueba.PASSED,false);
        btnRegistrarse.getCssValue("color");
        System.out.println(btnRegistrarse.getText());
    }



}
