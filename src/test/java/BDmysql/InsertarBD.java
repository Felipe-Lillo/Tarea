package BDmysql;

import Utils.ReadProperties;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarBD {
    private static Conexion conexion;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //CONEXIÓN A LA BD
        conexion = new Conexion();
        Connection conn = conexion.getConexion();
        Statement st;
        //PASO PARA GENERAR LA CONSULTA
        st = conn.createStatement();
        //CREACION DE VARIABLES MODIFICABLES
        String Campo_texto = ReadProperties.readFromConfig("BDpropiedades.properties").getProperty("Campo_texto");
        String Campo_Mail = ReadProperties.readFromConfig("BDpropiedades.properties").getProperty("Campo_Mail");
        String Campo_area = ReadProperties.readFromConfig("BDpropiedades.properties").getProperty("Campo_area");
        String Campo_fecha = ReadProperties.readFromConfig("BDpropiedades.properties").getProperty("Campo_fecha");
        String Campo_lista = ReadProperties.readFromConfig("BDpropiedades.properties").getProperty("Campo_lista");
        String Campo_seleccion = ReadProperties.readFromConfig("BDpropiedades.properties").getProperty("Campo_seleccion");
        String Combo_radio_button = ReadProperties.readFromConfig("BDpropiedades.properties").getProperty("Combo_radio_button");
        //PROCESO QUE GENERA UN INSERT, O CREACION DE UNA NUEVA COLUMNA EN LA TABLA
        try{
            //PROCESO QUE SERA ENTREGADO EN LA BD
            String query = "INSERT INTO matriz (Campo_texto,Campo_Mail,Campo_area,Campo_fecha,Campo_lista,Campo_seleccion,Combo_radio_button) VALUES ("+Campo_texto+","+Campo_Mail+","+Campo_area+","+Campo_fecha+","+Campo_lista+","+Campo_seleccion+","+Combo_radio_button+")";
            st.executeUpdate(query);
            System.out.println("Un nuevo usuario ha sido ingresado");
            System.out.println(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }









    public static void modificar(){

    }

    /*public static void eliminar(){

    }*/

    /*public static void mostrarDatos() throws SQLException, ClassNotFoundException {
        //Cargamos la conexion
        conexion = new Conexion();
        Connection conn = conexion.getConexion();
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from matriz");
            while (rs.next()) {
                System.out.println("Id :" + rs.getString("id"));
                System.out.println("Campo texto :" + rs.getString("Campo_Texto"));
                System.out.println("Campo mail :" + rs.getString("Campo_Mail"));
                System.out.println("Campo area :" + rs.getString("Campo_area"));
                System.out.println("Campo Fecha :" + rs.getString("Campo_fecha"));
                System.out.println("Campo lista :" + rs.getString("Campo_lista"));
                System.out.println("Campo seleccion :" + rs.getString("Campo_seleccion"));
                System.out.println("Combo radio :" + rs.getString("Combo_radio_button"));
                System.out.println("-----------------------------");
            }
            conn.close();
            rs.close();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}