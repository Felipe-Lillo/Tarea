package testClases;

import page.ValidacionOpciones;

public class ValidarPagina {


    public void rellenar(String texto, String fecha , String Email)throws InterruptedException{
        ValidacionOpciones validar = new ValidacionOpciones();
        validar.llenarCampos(texto,fecha,Email);
    }

    public void rellenarCalendario() throws InterruptedException{
        ValidacionOpciones validar = new ValidacionOpciones();
        validar.calendario();
    }

}
