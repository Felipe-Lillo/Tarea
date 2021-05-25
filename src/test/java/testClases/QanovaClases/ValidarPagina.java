package testClases.QanovaClases;

import page.QAnova.ValidacionOpciones;

public class ValidarPagina {

    /**
     * Creación del constructor donde llamaremos a la clase Java ValidacionOpciones/llenarCampos
     */
    public void rellenar(String texto, String fecha, String Email) throws InterruptedException {
        ValidacionOpciones validar = new ValidacionOpciones();
        validar.llenarCampos(texto, fecha, Email);
    }
    /**
     * Creación del constructor donde llamaremos a la clase Java ValidacionOpciones/calendario
     */
    public void rellenarCalendario() throws InterruptedException {
        ValidacionOpciones validar = new ValidacionOpciones();
        validar.calendario();
    }

}
