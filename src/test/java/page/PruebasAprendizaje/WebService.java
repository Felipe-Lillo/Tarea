package page.PruebasAprendizaje;

import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import Utils.Validaciones;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebService {
    @FindBy(xpath = "//*[@id=\"searchboxinput\"]")
    WebElement buscador;
    public WebService(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }
    public void consumirAPis() throws IOException, InterruptedException {
        StringBuilder resultado = new StringBuilder();
        URL url = new URL("https://farmanet.minsal.cl/maps/index.php/ws/getLocalesTurnos");
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        rd.close();
        JsonArray jsonObject = new Gson().fromJson(resultado.toString(),JsonArray.class);
        String lat="";
        String ing="";

        for(int i=0;i<jsonObject.size();i++){
            JsonElement datos = jsonObject.get(i);
            lat= datos.getAsJsonObject().get("local_lat").getAsString();
            ing=datos.getAsJsonObject().get("local_lng").getAsString();
            String ubicaciones=lat+","+ing;
            Validaciones.validarObjeto(buscador,"buscador");
            buscador.sendKeys(ubicaciones);
            buscador.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            PdfQaNovaReports.addWebReportImage("Ubicacion de la farmcia "+ arregloMayuscula(datos.getAsJsonObject().get("local_nombre").getAsString()),"se muestra en pantalla la direccion "+arregloMayuscula(datos.getAsJsonObject().get("local_direccion").getAsString())+", "+arregloMayuscula(datos.getAsJsonObject().get("comuna_nombre").getAsString()), EstadoPrueba.PASSED,false);
            Thread.sleep(2000);
            buscador.clear();
        }
    }
    public String arregloMayuscula(String datos){
        String palabra = datos.toLowerCase();
        char [] caracteres=palabra.toCharArray();
        String palabraFinal = "";

        for (int x=0;x<caracteres.length;x++){
            int ascii=caracteres[x];
            if (x==0){
                palabraFinal+= String.valueOf(caracteres[0]).toUpperCase();
            }
            else if(ascii==32){
                x++;
                palabraFinal+=" ";
                if(x<caracteres.length){
                    palabraFinal+= String.valueOf(caracteres[x]).toUpperCase();
                }
            }
            else{
                palabraFinal+=String.valueOf(caracteres[x]);
            }
        }
        return palabraFinal;
    }

}

