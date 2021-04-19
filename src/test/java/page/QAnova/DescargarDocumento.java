package page.QAnova;

import Utils.DriverContext;
import Utils.ReadProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class DescargarDocumento {
    //Sitio donde se obtienen y se almacenan los xpath,id,etc.
    @FindBy(xpath = "//*[@id=\"content\"]/div/a[3]")
    WebElement btnDescargar;

    //Metodo que levante el sitio web donde vamos a trabajar
    public DescargarDocumento() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    /**
     * Metodo que busca el xpath de un link y almacena la descarga y en una carpeta donde nosotros escogemos, sin embargo hay que ajustar el DriverManager
     * @throws InterruptedException
     */
    public void descargarDocument() throws InterruptedException {

        //REVISAR SI EL ARCHIVO YA ESTA Y ELIMINARLO
        File archivo = new File(ReadProperties.readFromConfig("Properties.properties").getProperty("ruta2"));
        String[] RevisarArchivo = archivo.list();
        for (int j = 0; j < RevisarArchivo.length; j++) {
            if (RevisarArchivo[j].equals("some-file.txt")) {
                File archivos = new File(ReadProperties.readFromConfig("Properties.properties").getProperty("ruta2") + "\\some-file.txt");
                archivos.delete();
            }
        }


        //Thread.sleep(3000);
        btnDescargar.click();
        boolean validar = true;
        while (validar){
            File Carpeta = new File(ReadProperties.readFromConfig("Properties.properties").getProperty("ruta2"));
            String[] nombresArchivos = Carpeta.list();
            for(int i = 0; i < nombresArchivos.length; i++){
                if (nombresArchivos[i].equals(ReadProperties.readFromConfig("Properties.properties").getProperty("NombreArchivo"))){
                    System.out.println("Descarga encontrada");
                    System.out.println("El nombre del archivo es: " + ReadProperties.readFromConfig("Properties.properties").getProperty("NombreArchivo"));
                    validar = false;
                }
            }
        }
    }

}
