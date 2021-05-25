package page.BusquedaOferta;

import Utils.DriverContext;
import Utils.Validaciones;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductoBuscado {
    @FindBy(xpath = "//*[@id=\"container\"]/div[1]/section/div[2]/div[4]/ul/li/section/div/div[4]/span")
    WebElement txtPrecio;

    @FindBy(xpath = "//*[@id=\"container\"]/div[1]/section/div[2]/div[4]/ul/li/section/div/div[4]")
    WebElement precios;

    public ProductoBuscado(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    public String productoPrincipal() {
        try{
        Validaciones.validarObjeto(txtPrecio, "producto");
        while(txtPrecio.isEnabled()){
            String almacenPrecio = "";
            List<WebElement> cadenaPrecioTxt = txtPrecio.findElements(By.tagName("span"));
            List<WebElement> posiblesPrecios = precios.findElements(By.tagName("span"));
            int textoPrecio = cadenaPrecioTxt.size();
            int valores = posiblesPrecios.size()/2;
            String valorLimpio = "";
                if(valores == 1){
                    if(textoPrecio == 2){
                        almacenPrecio = cadenaPrecioTxt.get(0).getText();
                        for (int j=0;j< almacenPrecio.length();j++){
                            char caracter=almacenPrecio.charAt(j);
                            if(Character.isDigit(caracter))
                            {
                                valorLimpio += caracter;

                            }
                        };
                        return valorLimpio;
                    }
                }else if(valores == 2){
                    almacenPrecio = cadenaPrecioTxt.get(0).getText();
                    for (int j=0;j< almacenPrecio.length();j++){
                        char caracter=almacenPrecio.charAt(j);
                        if(Character.isDigit(caracter))
                        {
                            valorLimpio += caracter;
                        }
                    }
                    return valorLimpio;
                }
        }
            }catch (Exception e){
                System.out.println("El producto no se ha encontrado");
                return "0";
            }

        return "0";
    }
}
