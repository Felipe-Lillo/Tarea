package testClases.ProductoSeleccionado;

import BDmysql.ConsultaSupermecado;
import page.BusquedaOferta.Index;
import page.BusquedaOferta.ProductoBuscado;

import java.sql.SQLException;
import java.util.List;

public class Producto {

    public void productoEscogido() throws SQLException, ClassNotFoundException {
        Index index = new Index();
        ProductoBuscado productoBuscado = new ProductoBuscado();
        ConsultaSupermecado skusBD = new ConsultaSupermecado();
        List<String> sku1 = skusBD.obtenerSkus();
        String[] valorBuscar;
        String dato = "";
        try{
            for(int i = 0; i< sku1.size(); i++){
                valorBuscar = sku1.get(i).split(";");
                index.ingresarProducto(valorBuscar[0]);
                dato = productoBuscado.productoPrincipal();
                sku1.remove(i);
                sku1.add(i,valorBuscar[0]+";"+valorBuscar[1]+";"+dato);
            }
            skusBD.insertarProductosBd(sku1);
        }catch (Exception e){
            System.out.println("Hubo un error en la obtención de datos al momento de unirlos con su ARRAY");
        }
    }
}
