package testClases;

import page.ValidacionOpciones;

public class ValidarPagina {
    ValidacionOpciones validacionOpciones;

    public void Rellenar(String texto,String fecha ,String Email)throws InterruptedException{
        validacionOpciones = new ValidacionOpciones();
        validacionOpciones.llenarCampos(texto,fecha,Email);

    }
}
