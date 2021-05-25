package testClases.QanovaClases;

import page.QAnova.Login;
import page.QAnova.MensajeErrorSesion;

public class validacionMensaje {
    /**
     * Creación del constructor donde llamaremos a la clase Java Tarea/recuperarMensaje
     */
    public void entregarMensaje(String usuario,String clave) throws InterruptedException {
        Login login = new Login();
        login.ingresar(usuario, clave);
        MensajeErrorSesion tarea = new MensajeErrorSesion();
        tarea.recuperarMensaje();

    }
}
