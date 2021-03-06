package testClases.QanovaClases;

import Utils.ReadProperties;
import page.QAnova.SubirArchivo;

/**
 * Creación del constructor donde llamaremos a la clase Java SubirArchivo/procesos
 */
public class Archivo {
    public void recuperarArchivo() throws InterruptedException {
        String file = ReadProperties.readFromConfig("Properties.properties").getProperty("ruta");
        SubirArchivo subirArchivo = new SubirArchivo();
        subirArchivo.procesos(file);
    }
}
