package page.BusquedaOferta;

import Utils.DriverContext;
import Utils.Validaciones;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Index {

    @FindBy(xpath = "//input[@class='jsx-87478634 desktopSearchBar']")
    WebElement barraBusqueda;

    @FindBy(xpath = "//*[@id=\"container\"]/div[1]/section/div[2]/div[4]/ul/li/section/div/div[4]/span/span")
    WebElement producto;

    public Index(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    public void ingresarProducto(String SKU) {
        Validaciones.validarObjeto(barraBusqueda, "barra de busqueda");
        try {
            barraBusqueda.sendKeys(SKU);
            barraBusqueda.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("No existe el producto");

        }


    }
}
