package page;

import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.RevisionDocumentosTmp;
import Utils.Validaciones;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Sodimac {
    @FindBy(xpath = "//*[@id=\"header-med-search-bar-SearchBar-79247401-c89a-4b16-9d3c-f91206c21c2c-desktop\"]/input")
    WebElement barraBusqueda;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]")
    WebElement bodyTabla;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div[1]/div/div[6]/div/div[1]/div/div")
    WebElement bodyTablaStrella;

    public Sodimac(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }


    public void procesoBusquedaProducto() throws InterruptedException, IOException {
        barraBusqueda.sendKeys(ReadProperties.readFromConfig("Properties.properties").getProperty("producto"));
        barraBusqueda.sendKeys(Keys.ENTER);

        //Llamado al metodo de elimiar archivo existente
        RevisionDocumentosTmp.eliminarArchivoExistente(ReadProperties.readFromConfig("Properties.properties").getProperty("NombreArchivoCreado"));
        Validaciones.validarObjeto(bodyTabla, "despliegue tabla");

        /*Creación de listas donde se almacenaran los datos obtenidos de la pagina, en este caso
        de cada uno de los productos*/
        List<WebElement> productos = bodyTabla.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div"));
        List<WebElement> marcas = bodyTabla.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div/div/div[3]"));
        List<WebElement> nombreProducto = bodyTabla.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div/div/div[4]"));
        List<WebElement> estrellas= bodyTablaStrella.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div/div/div[6]/div/div[1]/div/div/i"));
        List<WebElement> nCalificaciones = bodyTabla.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div/div/div[6]/div/div[1]/span"));
        List<WebElement> precio = bodyTabla.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div/div/div[6]/div/div[3]"));;
        List<WebElement> despacho = bodyTabla.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div/div/div[6]/div/div[4]/div[1]"));
        List<WebElement> retiro = bodyTabla.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div/div/div[6]/div/div[4]/div[2]"));

        //variables contables necesarias para medir la cantidad de datos que hay en pantalla
        int cantidadProductos = productos.size();

        //variables para el conteo de estrellas de calificacion de la página
        int cantidadEstrellas = estrellas.size();
        List<Double> arreglo = new ArrayList<>();
        double cant = 0;

        //variable que almacenara todos los datos obtenidos cada vez que el FOR haga sus recorridos
        String caracteristicas = "";

        //Creación del Txt en la carpeta TMP
        FileWriter fichero = new FileWriter(ReadProperties.readFromConfig("Properties.properties").getProperty("rutaCarpetaTxt") + "\\"
                + ReadProperties.readFromConfig("Properties.properties").getProperty("NombreArchivoCreado"));

        //Llamando al metodo PrintWritter, encargo de la escritura de, en este caso, el txt
        PrintWriter pw = null;

        //comienzo de script desarrollo
        try{
            /*For que recorre todos los productos en panta, sirve para saber cuantos hay y como guia
            para los datos que se solicitan */
            for (int i = 0; i<cantidadProductos ; i++) {
                /*Este for se encarga de obtener las estrellas de la pagina, dando valor a cada una de ellas
                y almacenandolas dentro de un arreglo de Doubles*/
                for (int x = i; x < cantidadEstrellas; x++) {
                    String datosWeb = estrellas.get(x).getAttribute("class");
                    if ((x % 5)== 0 && x != 0) {
                        arreglo.add(cant);
                        cant = 0;
                    }
                    switch (datosWeb) {
                        case "jsx-3921358990 icon cs-icon-star-filled":
                            cant++;
                            break;
                        case "jsx-3921358990 icon cs-icon-star-half_filled":
                            cant = cant + 0.5;
                            break;
                        default:
                            break;
                    }
                }
                //Almacenamiento y control de vista que se entregaran al documento
                caracteristicas = "Marca: " +marcas.get(i).getText() + "\n"
                + "Nombre producto: " + nombreProducto.get(i).getText() + "\n"
                + "Calificación: " + arreglo.get(i) + " " + nCalificaciones.get(i).getText() +"\n"
                + "Precio: " + precio.get(i).getText() + "\n"
                + despacho.get(i).getText() + "\n"
                + retiro.get(i).getText() + "\n"
                + "*************************";
                if (caracteristicas != null){
                    //Inicio y desarrollo de escritura
                    pw =new PrintWriter(fichero);
                    pw.println(caracteristicas + "\n");
                }
            }
            //Confirmacion y cierre de servicios
            System.out.println("Archivo creado correctamente");
            pw.close();
            fichero.close();
        //Casos de error
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(null != fichero){
                    fichero.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
