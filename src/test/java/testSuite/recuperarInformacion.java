package testSuite;

import Utils.Constants.Navegador;
import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.PdfQaNovaReports;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClases.*;

public class recuperarInformacion {
    String  url = ReadProperties.readFromConfig("Properties.properties").getProperty("url");
    String Usuario = ReadProperties.readFromConfig("Properties.properties").getProperty("usuario");
    String Clave = ReadProperties.readFromConfig("Properties.properties").getProperty("clave");

    @BeforeTest
    public void setUp(){
        DriverContext.setUp(Navegador.Chrome,url);
        PdfQaNovaReports.createPDF();

    }

    @AfterTest
    public void end(){
        DriverContext.closeDriver();
    }

    @Test
    public void ingresar() throws InterruptedException{
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(Usuario,Clave);
        PdfQaNovaReports.closePDF();
    }

    @Test
    public void nuevoUsuario() throws InterruptedException{
        IngresoNuevoUsuario ingreso = new IngresoNuevoUsuario();
        ingreso.NuevoUsuario();
        PdfQaNovaReports.closePDF();
    }

    @Test
    public void buscarColor() throws InterruptedException {
        validacionMensaje validar = new validacionMensaje();
        validar.entregarMensaje();
        PdfQaNovaReports.closePDF();
    }

    @Test
    public void rellenarCamposPage()throws InterruptedException{
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(Usuario,Clave);
        ValidarPagina validarPagina = new ValidarPagina();
        validarPagina.rellenar("Hola mundo","19/03/2021","git@github.com");
        PdfQaNovaReports.closePDF();
    }

    @Test
    public void extraerDatosTabla() throws InterruptedException {
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(Usuario,Clave);
        RecuperarTabla recuperar = new RecuperarTabla();
        recuperar.datosTabla();

    }

    @Test
    public void subirArchivo() throws InterruptedException{
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(Usuario,Clave);
        Archivo archivo = new Archivo();
        archivo.recuperarArchivo();
    }

    @Test
    public void descarArchivo() throws InterruptedException{
        Descargar descarga = new Descargar();
        descarga.Almacenar();
    }
    @Test
    public void seleccionarDia() throws InterruptedException{
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(Usuario,Clave);
        ValidarPagina validar = new ValidarPagina();
        validar.rellenarCalendario();

    }

    @Test
    public void enviarCorreo() throws InterruptedException{
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(Usuario,Clave);
        RecuperarTabla recuperar = new RecuperarTabla();
        recuperar.datosTabla();
        EnviarMail enviarMail = new EnviarMail();
        enviarMail.enviarMensange();
    }
}
