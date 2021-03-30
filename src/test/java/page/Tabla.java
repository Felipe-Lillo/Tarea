package page;

import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Validaciones;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Tabla {
    @FindBy(xpath = "//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]")
    WebElement btnMatriz;

    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_filter_field\"]")
    WebElement ctxtFiltro;

    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_filter_button\"]")
    WebElement btnFiltrar;

    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table")
    WebElement body;


    public Tabla(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    public String recuperarDatosTabla() throws InterruptedException {
        Validaciones.validarObjeto(btnMatriz,"Boton matriz");
        btnMatriz.click();
        Thread.sleep(2000);
        ctxtFiltro.sendKeys(ReadProperties.readFromConfig("Properties.properties").getProperty("nombreLista"));
        btnFiltrar.click();


        //Formula definitivamente facil --
        for (int i = 1; i <= 1; i++) {
            System.out.println(body.getText());
        }

        //Formula extendida --

        System.out.println("\n*********************************************");
        List<WebElement> Filas = body.findElements(By.tagName("tr"));
        int cantFilas = Filas.size();
        String id = "", texto = "", email = "", area="",fecha = "", lista = "", seleccion = "",radio = "";
        String mensaje = "";
        for (int i = 1; i< cantFilas; i++){
            List<WebElement> columnas = Filas.get(i).findElements(By.tagName("td"));
            id = id + columnas.get(0).getText() + "; ";
            texto = texto + columnas.get(1).getText() + "; ";
            email = email + columnas.get(2).getText() + "; ";
            area = area + columnas.get(3).getText() + "; ";
            fecha = fecha + columnas.get(4).getText() + "; ";
            lista = lista + columnas.get(5).getText() + "; ";
            seleccion = seleccion + columnas.get(6).getText() + "; ";
            radio = radio + columnas.get(7).getText() + ";";
            System.out.println(id+" "+texto+" "+email+" "+area+" "+fecha+" "+lista+" "+seleccion+" "+radio+"\n");
            String lineas = id+" "+texto+" "+email+" "+area+" "+fecha+" "+lista+" "+seleccion+" "+radio;
            lineas = lineas.replace(';',' ');
            mensaje = id + texto + email + area + fecha + lista + seleccion + radio;

        }
        System.out.println("ID" +"\n"+ id);
        System.out.println("TEXTO"+"\n"+ texto);
        System.out.println("EMAIL"+"\n"+ email);
        System.out.println("AREA"+"\n"+ area);
        System.out.println("FECHA"+"\n"+ fecha);
        System.out.println("LISTA"+"\n"+ lista);
        System.out.println("SELECCION"+"\n"+ seleccion);
        System.out.println("RADIO"+"\n"+ radio);
        System.out.println("*********************************************");

        return mensaje;

    }


        //List<WebElement> Row = Body.findElements(By.xpath("//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody"));
        //List<List<WebElement>> ElementosTabla = new List<List<WebElement>>();
        //for( int i = 0;).

}


