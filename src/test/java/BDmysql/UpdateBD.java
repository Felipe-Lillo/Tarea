package BDmysql;

import Utils.ReadProperties;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateBD {
    private static Conexion conexion;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //CONEXIÓN A LA BD
        conexion = new Conexion();
        Connection conn = conexion.getConexion();
        Statement st;
        //PASO PARA GENERAR LA CONSULTA
        st = conn.createStatement();
        try{
            String query = "UPDATE matriz SET " + ReadProperties.readFromConfig("BDpropiedades.properties").getProperty("campoUpdate") +"="
                    + ReadProperties.readFromConfig("BDpropiedades.properties").getProperty("datoUpdate") + "WHERE id = "
                    + ReadProperties.readFromConfig("BDpropiedades.properties").getProperty("idUpdate");
            st.executeUpdate(query);
            System.out.println("Se acaba de actualizar el " + ReadProperties.readFromConfig("BDpropiedades.properties").getProperty("campoUpdate") + " del id = "+ ReadProperties.readFromConfig("BDpropiedades.properties").getProperty("idUpdate"));

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
