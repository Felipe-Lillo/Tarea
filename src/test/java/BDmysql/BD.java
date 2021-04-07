package BDmysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BD {
    private static Scanner teclado = new Scanner(System.in);
    private static String id = "";
    private static String CampoTexto = "";
    private static int opcion;
    private static Conexion conexion;

    public static void insertar() throws SQLException, ClassNotFoundException {
        conexion = new Conexion();
        Connection conn = conexion.getConexion();
        Statement st;
    }

    public static void modificar(){

    }

    public static void eliminar(){

    }

    public static void mostrarDatos() throws SQLException, ClassNotFoundException {
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
    }
}