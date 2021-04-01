package testClases;

import page.CrearUsuario;

public class IngresoNuevoUsuario {
    /**
     * Creación del constructor donde llamaremos a la clase Java CrearUsuario/ingresarNuevoUsuario
     */
    public void NuevoUsuario() throws InterruptedException {
        CrearUsuario creacionUsario = new CrearUsuario();
        creacionUsario.ingresarNuevoUsuario();
    }


}
