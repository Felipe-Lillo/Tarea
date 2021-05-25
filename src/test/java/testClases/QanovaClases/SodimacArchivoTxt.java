package testClases.QanovaClases;
import page.Sodimac.*;
import java.io.IOException;

public class SodimacArchivoTxt {
    public void sodimacArchivo() throws IOException {
        InicioPagina inicioPagina = new InicioPagina();
        inicioPagina.primeraPestaña();
        BuscarProductoSodimac buscarProductoSodimac = new BuscarProductoSodimac();
        buscarProductoSodimac.procesoBusquedaProducto();
    }
}
