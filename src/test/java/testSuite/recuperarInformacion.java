package testSuite;

import Utils.Constants.Navegador;
import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.PdfQaNovaReports;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClases.*;

import java.io.IOException;

public class recuperarInformacion {
    /**
     * Llamado a variables dependientes de las properties
     */
    String url = ReadProperties.readFromConfig("Properties.properties").getProperty("url");
    String usuario = ReadProperties.readFromConfig("Properties.properties").getProperty("usuario");
    String clave = ReadProperties.readFromConfig("Properties.properties").getProperty("clave");

    /**
     * Interfaz donde se indica de donde o adonde iniciaran las pruebas
     */
    @BeforeTest
    public void setUp() {
        DriverContext.setUp(Navegador.Chrome, url);
        //PdfQaNovaReports.createPDF();

    }

    /**
     * Interfaz donde cierra el programa, para que no siga abierto el browser
     */
    @AfterTest
    public void end() {
        DriverContext.closeDriver();
    }

    /**
     * Test que corre el ingresar el usuario en el login
     *
     * @throws InterruptedException
     */
    @Test
    public void ingresar() throws InterruptedException {
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(usuario,clave);
        PdfQaNovaReports.closePDF();
    }

    /**
     * Test que corre el ingreso de un nuevo usuario en el sistema
     *
     * @throws InterruptedException
     */
    @Test
    public void nuevoUsuario() throws InterruptedException {
        IngresoNuevoUsuario ingreso = new IngresoNuevoUsuario();
        ingreso.NuevoUsuario();
        PdfQaNovaReports.closePDF();
    }

    /**
     * Test que ejecuta la funcion de buscar el color y mensaje de error al ingresar mal algun usuario
     *
     * @throws InterruptedException
     */
    @Test
    public void buscarColor() throws InterruptedException {
        validacionMensaje validar = new validacionMensaje();
        validar.entregarMensaje(usuario,clave);
        PdfQaNovaReports.closePDF();
    }

    /**
     * Test que ejecuta el relleno de informacion en diferentes campos, estraido desde la java class ValidacionOpciones
     *
     * @throws InterruptedException
     */
    @Test
    public void rellenarCamposPage() throws InterruptedException {
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(usuario,clave);
        ValidarPagina validarPagina = new ValidarPagina();
        validarPagina.rellenar("Hola mundo", "19/03/2021", "git@github.com");
        PdfQaNovaReports.closePDF();
    }

    /**
     * Metodo que ejecuta la extraccion de datos de una tabla
     *
     * @throws InterruptedException
     */
    @Test
    public void extraerDatosTabla() throws InterruptedException {
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(usuario,clave);
        RecuperarTabla recuperar = new RecuperarTabla();
        recuperar.datosTabla();
    }

    /**
     * Test que sube algun archivo a la web mediante opciones necesarias
     *
     * @throws InterruptedException
     */
    @Test
    public void subirArchivo() throws InterruptedException {
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(usuario, clave);
        Archivo archivo = new Archivo();
        archivo.recuperarArchivo();
    }

    /**
     * Test que corre el la java class DescargarDocumento
     *
     * @throws InterruptedException
     */
    @Test
    public void descarArchivo() throws InterruptedException {
        Descargar descarga = new Descargar();
        descarga.Almacenar();
    }

    /**
     * Test que elige y devuelve el dia desde un calendario desplegable
     *
     * @throws InterruptedException
     */
    @Test
    public void seleccionarDia() throws InterruptedException {
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(usuario, clave);
        ValidarPagina validar = new ValidarPagina();
        validar.rellenarCalendario();

    }

    /**
     * Test que core el envio de los mails
     *
     * @throws InterruptedException
     */
    @Test
    public void enviarCorreo() throws InterruptedException {
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(usuario, clave);
        RecuperarTabla recuperar = new RecuperarTabla();
        recuperar.datosTabla();
        EnviarMail enviarMail = new EnviarMail();
        enviarMail.enviarMensange();
    }

    /**
     * Test remarcar o resaltar campos
     * @throws InterruptedException
     */
    @Test
    public void resaltarCampos() throws InterruptedException{
        Ingresar ingresar = new Ingresar();
        ingresar.highlightElement();
    }

    /**
     * Prueba que crea y escribe los datos obtenidos en la pgina web de sodimac
     * @throws InterruptedException
     * @throws IOException
     */
    @Test
    public void sodimacPrueba() throws InterruptedException, IOException {
        SodimacArchivoTxt sodimacArchivoTxt = new SodimacArchivoTxt();
        sodimacArchivoTxt.sodimacArchivo();
    }

    @Test
    public void jsonPrueba() throws IOException, InterruptedException {
        Ingresar ingresar = new Ingresar();
        ingresar.iniciarPila();
        PdfQaNovaReports.closePDF();
    }
}
