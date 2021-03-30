package testClases;

import page.DescargarDocumento;

public class Descargar {
    public void Almacenar() throws InterruptedException{
        DescargarDocumento documento = new DescargarDocumento();
        documento.descargarDocument();
    }
}
