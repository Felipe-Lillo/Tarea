package testClases;

import Utils.ReadProperties;
import page.SubirArchivo;

public class Archivo {
    public void recuperarArchivo()throws InterruptedException{
        String file = ReadProperties.readFromConfig("Properties.properties").getProperty("ruta");
        SubirArchivo subirArchivo = new SubirArchivo();
        subirArchivo.procesos(file);
    }
}
