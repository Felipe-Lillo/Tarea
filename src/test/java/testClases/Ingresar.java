package testClases;

import Utils.DriverContext;
import Utils.ReadProperties;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.openqa.selenium.JavascriptExecutor;
import page.QAnova.Login;
import page.QAnova.ValidacionOpciones;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Creación del constructor donde llamaremos a la clase Java Login/ingresarUsuario
 */
public class Ingresar {
    String usuario,clave;
    Login login;
    ValidacionOpciones validacionOpciones;

    public void inicio(String usuario,String clave) throws InterruptedException {
        login = new Login();
        login.ingresar(usuario,clave);

    }

    public void highlightElement()throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) DriverContext.getDriver();
        js.executeScript("document.getElementById(\"email\").setAttribute('style','background: red');");
        js.executeScript("document.getElementById(\"passContainer\").setAttribute('style','background: yellow')");
        Thread.sleep(2000);
        //passContainer
    }

    public void iniciarPila() throws IOException{
        String datos="";
        String comparacion;
        BufferedReader br = new BufferedReader(new FileReader("C:/Users/Felipe Lillo/IdeaProjects/Practica/src/test/java/Json/usuarios.json"));
        while((comparacion = br.readLine()) != null){
            datos = datos+comparacion+"\n";
        }
        br.close();
        JsonObject jsonObject = new Gson().fromJson(datos,JsonObject.class);
        JsonArray jsonUsuarios = jsonObject.getAsJsonArray("usuario");
        String url = ReadProperties.readFromConfig("Properties.properties").getProperty("url");
        JsonObject jsonArreglo;
        Login index = new Login();
        /*List<Usuario> empleados = gson.fromJson(datos, tipoListaEmpleados);
        MensajeErrorSesion mensajeErrorSesion = new MensajeErrorSesion();*/

        for(int i=0;i<jsonUsuarios.size();i++){
            index.validarDeslpiegue();
            jsonArreglo = (JsonObject) jsonUsuarios.get(i);
            usuario = jsonArreglo.get("nombre").getAsString();
            clave = jsonArreglo.get("clave").getAsString();
            index.ingresar(usuario,clave);
            DriverContext.getDriver().navigate().to(url);
            /*index.ingresarUsuario(empleados.get(i).nombre,empleados.get(i).clave);
            mensajeErrorSesion.recuperarMensaje();
            DriverContext.getDriver().navigate().back();
            if(empleados == null){
                break;
            }*/
        }


    }
}
