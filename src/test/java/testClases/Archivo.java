package testClases;

import Utils.ReadProperties;
import page.SubirArchivo;

public class Archivo {
    public void RecuperarArchivo()throws InterruptedException{
        String file = ReadProperties.readFromConfig("Properties.properties").getProperty("ruta");
        SubirArchivo subirArchivo = new SubirArchivo();
        subirArchivo.Procesos(file);
    }
}
