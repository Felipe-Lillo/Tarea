package BDmysql;


import Utils.ReadProperties;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta {
    private static Conexion conexion;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //LLAMAMOS A LA CONEXIÓN
        conexion = new Conexion();
        Connection conn = conexion.getConexion();
        Statement st;
        ResultSet rs;
        try {
            //CREAMOS LA CONSULTA
            st = conn.createStatement();
            st.setQueryTimeout(30);
            rs = st.executeQuery("select * from matriz where "+ ReadProperties.readFromConfig("BDpropiedades.properties").getProperty("Filtro") + " = " + ReadProperties.readFromConfig("BDpropiedades.properties").getProperty("dato"));
            //COMO QUIERO QUE ME MUESTRE LA CONSULTA
            while (rs.next()){
                System.out.println("Id :" + rs.getString("id"));
                System.out.println("Campo texto: " + rs.getString("Campo_Texto"));
                System.out.println("Campo mail: " + rs.getString("Campo_Mail"));
                System.out.println("Campo area: " + rs.getString("Campo_area"));
                System.out.println("Campo Fecha: " + rs.getString("Campo_fecha"));
                System.out.println("Campo lista: " + rs.getString("Campo_lista"));
                System.out.println("Campo seleccion: " + rs.getString("Campo_seleccion"));
                System.out.println("Combo radio: " + rs.getString("Combo_radio_button"));
                System.out.println("-----------------------------");
        //FINALIZANDO EL PROCESO
        }conn.close();
        rs.close();
        System.out.println("Base de datos cerrada");
        st.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}
