package testSuite;

import Utils.DriverContext;
import Utils.Espera;
import Utils.Navegador;
import Utils.ReadProperties;
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
    }

    @AfterTest
    public void end(){
        DriverContext.closeDriver();
    }

    @Test
    public void Ingresar() throws InterruptedException{
        Ingresar ingresar = new Ingresar();
        ingresar.inicio("nvivas","qanova");
    }

    @Test
    public void BuscarColor() throws InterruptedException {
        validacionMensaje validar = new validacionMensaje();
        validar.EntregarMensaje();
    }

    @Test
    public void RellenarCamposPage()throws InterruptedException{
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(Usuario,Clave);
        Espera.esperar("//*[@id=\"imObjectForm_1_2\"]");
        ValidarPagina validarPagina = new ValidarPagina();
        validarPagina.Rellenar("Hola mundo","19/03/2021","git@github.com");
    }

    @Test
    public void ExtraerDatosTabla() throws InterruptedException {
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(Usuario,Clave);

        Espera.esperar("//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]");
        RecuperarTabla recuperar = new RecuperarTabla();
        recuperar.DatosTabla();

    }
    @Test
    public void SubirArchivo () throws InterruptedException{
        Ingresar ingresar = new Ingresar();
        ingresar.inicio(Usuario,Clave);
        Espera.esperar("//*[@id=\"imMnMnNode6\"]");
        Archivo archivo = new Archivo();
        archivo.RecuperarArchivo();
    }


}
