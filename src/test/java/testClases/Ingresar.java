package testClases;

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
}
