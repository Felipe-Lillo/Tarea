package testClases;

import page.QAnova.DescargarDocumento;
/**
 * Creación del constructor donde llamaremos a la clase Java DescargarDocumento/descargarDocument
 */
public class Descargar {
    public void Almacenar() throws InterruptedException {
        DescargarDocumento documento = new DescargarDocumento();
        documento.descargarDocument();
    }
}
