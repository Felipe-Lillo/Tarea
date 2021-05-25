package page.PruebasAprendizaje;

import Utils.ReadProperties;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;

public class ComparaImagenes {

    public boolean CompararImagenesLocales() {
        File imagen1 = new File(ReadProperties.readFromConfig("PruebasAprendizaje.properties").getProperty("rutaImagen1"));
        File imagen2 = new File(ReadProperties.readFromConfig("PruebasAprendizaje.properties").getProperty("rutaImagen2"));
        try{
            //Imagen1
            BufferedImage bufferedImageA = ImageIO.read(imagen1);
            DataBuffer dataBufferA = bufferedImageA.getData().getDataBuffer();
            int tamañoA = dataBufferA.getSize();
            //Imagen2
            BufferedImage bufferedImageB = ImageIO.read(imagen2);
            DataBuffer dataBufferB = bufferedImageB.getData().getDataBuffer();
            int tamañoB = dataBufferB.getSize();
            //Comparación
            if(tamañoA == tamañoB) {
                for(int i=0; i<tamañoA; i++) {
                    if(dataBufferA.getElem(i) != dataBufferB.getElem(i)) {
                        System.out.println("----> LAS IMAGENES NO SON IGUALES...");
                        return false;
                    }
                }
                System.out.println("\n----> LAS IMAGENES SON IGUALES :)");
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("Failed to compare image files ...");
            return  false;
        }
    }
}
