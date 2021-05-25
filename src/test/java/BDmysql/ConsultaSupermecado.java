package BDmysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultaSupermecado {
    private static Conexion conexion;

    public List<String> obtenerSkus ()throws SQLException, ClassNotFoundException {
        conexion = new Conexion();
        Connection conn = conexion.getConexion();
        Statement st;
        ResultSet rs;
        ArrayList<String> productosBuscar = new ArrayList<>();
        try {
            st = conn.createStatement();
            st.setQueryTimeout(30);
            rs = st.executeQuery("select ID,SKU from sku Where Tienda = 5");
            while (rs.next()) {
                productosBuscar.add(rs.getString("SKU") + ";" + rs.getString("ID"));
            }
            st.close();
            conn.close();
            return productosBuscar;
        } catch (Exception e) {
            System.out.println("Fallo la consulta compaire");
            return null;
        }
    }

    public void insertarProductosBd(List<String> sku) throws SQLException, ClassNotFoundException {
        conexion = new Conexion();
        Connection conn = conexion.getConexion();
        Statement st;
        ResultSet rs;
        try{
        st = conn.createStatement();
        st.setQueryTimeout(30);
        ArrayList<String> consulta = new ArrayList<>();
        rs = st.executeQuery("Select SKU,Fecha FROM glowecoi_test.precio");
        while(rs.next()){
            consulta.add(rs.getString("SKU")+";"+rs.getString("Fecha"));
        }
        Date date = new Date();
        SimpleDateFormat formatoSimple = new SimpleDateFormat("yyyy-MM-DD");
        String fechaHoy = formatoSimple.format(date);
        String[] datos;
        String[] skuFecha;
        for(int i = 0; i< sku.size();i++){
            datos = sku.get(i).split(";");
            skuFecha = consulta.get(i).split(";");
            if(consulta.contains(datos[1]+";"+fechaHoy)){
                st.executeUpdate("UPDATE precio set Precio = "+datos[2]+" WHERE SKU="+datos[1]+ " AND Fecha='"+fechaHoy+"';");
            }
            else if(fechaHoy!=skuFecha[1]){
                st.executeUpdate("INSERT INTO precio(SKU,Precio,Ganador) VALUES ("+datos[1]+","+datos[2]+","+0+");");
            }
        }
        conn.close();
        st.close();
        rs.close();
        }catch (Exception e){
            System.out.println("Hubo un error al modificar la base de datos\n");
            e.printStackTrace();
        }

    }
}
