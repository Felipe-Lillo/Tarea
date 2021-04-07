package BDmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static final String driver = "com.mysql.jdbc.Driver";
    static final String nombreBD = "qanovapractica";
    static final String url = "jdbc:mysql://localhost:3306/qanovapractica";

    static final String username = "root";
    static final String pass = "secret";

    Connection conexion = null;
    //Constructor
    public Conexion() throws ClassNotFoundException, SQLException {
        try{
            //obtener el driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectando a la base de datos...");

            //obtener el conector
            conexion = DriverManager.getConnection(url,username,pass);
            if (conexion != null){
                System.out.println("Conexión exitosa a la BD: "+ nombreBD);
            }
        }catch (ClassNotFoundException e){
            System.out.println("Clase no encontrada : " + e.getMessage());
        }catch (SQLException e){
            System.out.println("Ha ocurrido una SQLException : " + e.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }
}
