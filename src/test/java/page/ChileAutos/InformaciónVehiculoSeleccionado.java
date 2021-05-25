package page.ChileAutos;

import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.RevisionDocumentosTmp;
import Utils.Validaciones;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class InformaciónVehiculoSeleccionado {
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/section[14]/div/h5")
    WebElement tituloComentario;

    @FindBy(xpath = "//*[@id=\"details\"]")
    WebElement detallesVehiculo;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/section[4]/div/div/div[1]/div")
    WebElement inputImgPrincipal;

    @FindBy(xpath = "/html/body/div[5]/div/div[1]/div[2]/div/div[1]/div[3]/div/div")
    WebElement listaImagenes;


    public InformaciónVehiculoSeleccionado(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }


    public void validarDespliegue(){
        Validaciones.validarObjeto(tituloComentario,"Titulo 'Comentarios'");
    }
    public void crearCarpetaImagenes() throws IOException {
        RevisionDocumentosTmp.limpiarCarpeta(ReadProperties.readFromConfig("Properties.properties").getProperty("nombreCarpeta"));
        String linkimagen ;
        List<WebElement> imagenes = listaImagenes.findElements(By.tagName("img"));
        int cantidadFotos = imagenes.size();
        File fichero = new File(ReadProperties.readFromConfig("Properties.properties").getProperty("rutaCapertaImagenes") +"\\"+ReadProperties.readFromConfig("Properties.properties").getProperty("nombreCarpeta"));
        fichero.mkdir();
        for(int i=0;i<cantidadFotos;i++){
        linkimagen =imagenes.get(i).getAttribute("src");
        BufferedImage bufferedImage = ImageIO.read(new URL(linkimagen));
        File outputfile = new File(fichero +"\\"+"imagen"+i+".png");
        ImageIO.write(bufferedImage, "png", outputfile);
        }
    }
    public void extraerInformacion() throws IOException {
        validarDespliegue();
        Validaciones.validarObjeto(inputImgPrincipal,"imagen principal");
        inputImgPrincipal.click();
        crearCarpetaImagenes();
        WebElement comentario = tituloComentario.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/section[14]/div/div/div/p"));
        System.out.println(tituloComentario.getText());
        System.out.println(comentario.getText() + "\n");
        List<WebElement> caracteristicas = detallesVehiculo.findElements(By.xpath("//*[@id=\"details\"]/div"));
        int cantidadDatos = caracteristicas.size();
        System.out.println("DESCRIPCIÓN");
        for(int x = 0; x<cantidadDatos;x++){
            System.out.println(caracteristicas.get(x).getText() + "\n");
        }
    }
}
