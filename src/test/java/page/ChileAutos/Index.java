package page.ChileAutos;

import Utils.DriverContext;
import Utils.Validaciones;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Index {
    @FindBy(xpath = "//*[@id=\"search-form-container\"]/div/div[1]/a")
    WebElement btnBuscar;

    public Index(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }
    public void validarDespliegue(){
        Validaciones.validarObjeto(btnBuscar,"boton buscar");
    }

    public void clickearBotonBusqueda() throws InterruptedException {
        validarDespliegue();
        Thread.sleep(2000);
        btnBuscar.click();
    }

}
