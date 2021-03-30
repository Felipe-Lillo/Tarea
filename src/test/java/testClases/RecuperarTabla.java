package testClases;

import Utils.ReadProperties;
import page.Tabla;

public class RecuperarTabla {
    public void datosTabla()throws InterruptedException{
        String Datos = ReadProperties.readFromConfig("Properties.properties").getProperty("nombreLista");
        Tabla matrizDatos = new Tabla();
        matrizDatos.recuperarDatosTabla();
    }
}
