package page.ChileAutos;

import Utils.DriverContext;
import Utils.Validaciones;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Vehiculos {
    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div")
    WebElement bodyTable;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div[1]/div[3]/div[2]/div/div/div/a/div[2]/div[2]/span")
    WebElement fotos;



    public Vehiculos(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }
    public void validarDespliegue(){
        Validaciones.validarObjeto(bodyTable,"boton buscar");
    }
    public void datosVehiculos() throws InterruptedException {
        validarDespliegue();
        //System.out.println("Cantidad fotos: "+ fotos.getText());
        List<WebElement> autos = bodyTable.findElements(By.xpath("/html/body/div[2]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div/div"));
        List<WebElement> multimedia = fotos.findElements(By.tagName("span"));
        int tipoMultimedia = multimedia.size();
        for(int x = 0; x<tipoMultimedia ; x++){
            if(x==0){
                System.out.println("Imagenes: " + multimedia.get(x).getText());
            }
            else{
                System.out.println("Videos: " + multimedia.get(x).getText());
            }
        }
        autos.get(0).click();
    }

}
