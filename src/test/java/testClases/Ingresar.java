package testClases;

import Utils.DriverContext;
import org.openqa.selenium.JavascriptExecutor;
import page.Login;

/**
 * Creación del constructor donde llamaremos a la clase Java Login/ingresarUsuario
 */
public class Ingresar {

    Login login;

    public void inicio(String usuario, String clave) throws InterruptedException {
        login = new Login();
        login.ingresarUsuario(usuario, clave);

    }
    public void highlightElement()throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) DriverContext.getDriver();
        js.executeScript("document.getElementById(\"email\").setAttribute('style','background: red');");
        js.executeScript("document.getElementById(\"passContainer\").setAttribute('style','background: yellow')");
        Thread.sleep(2000);
        //passContainer
    }
}
