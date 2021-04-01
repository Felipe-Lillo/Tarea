package testClases;

import page.Tarea;

public class validacionMensaje {
    /**
     * Creación del constructor donde llamaremos a la clase Java Tarea/recuperarMensaje
     */
    public void entregarMensaje() throws InterruptedException {
        Tarea tarea = new Tarea();
        tarea.recuperarMensaje();

    }
}
