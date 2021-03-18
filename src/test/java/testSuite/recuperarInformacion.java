package testSuite;

import Utils.DriverContext;
import Utils.Navegador;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClases.Ingresar;
import testClases.validacionMensaje;

public class recuperarInformacion {
    String  url = "http://www.qanovagroup.com/piloto/index.php";

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
}
