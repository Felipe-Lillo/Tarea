package page;

import Utils.DriverContext;
import Utils.ReadProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class DescargarDocumento {
    @FindBy (xpath = "//*[@id=\"content\"]/div/a[3]")
    WebElement btnDescargar;

    public DescargarDocumento(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    public void descargarDocument() throws InterruptedException{

        //REVISAR SI EL ARCHIVO YA ESTA Y ELIMINARLO
        File archivo = new File(ReadProperties.readFromConfig("Properties.properties").getProperty("ruta2"));
        String[] RevisarArchivo = archivo.list();
        for(int j = 0;j < RevisarArchivo.length; j++){
            if(RevisarArchivo[j].equals("some-file.txt")){
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
            for(int i =0; i < nombresArchivos.length;i++){
                if (nombresArchivos[i].equals(ReadProperties.readFromConfig("Properties.properties").getProperty("NombreArchivo"))){
                    System.out.println("Descarga encontrada");
                    System.out.println("El nombre del archivo es: " + ReadProperties.readFromConfig("Properties.properties").getProperty("NombreArchivo"));
                    validar = false;
                }
            }
        }

        //System.out.println(Carpeta.getAbsolutePath());
        //System.out.println(Carpeta.exists());



    }

}
