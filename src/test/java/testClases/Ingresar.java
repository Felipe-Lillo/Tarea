package testClases;

import page.Login;

public class Ingresar {

    Login login;
    public void inicio(String usuario, String clave) throws InterruptedException{
        login = new Login();
        login.ingresarUsuario(usuario,clave);

    }
}
