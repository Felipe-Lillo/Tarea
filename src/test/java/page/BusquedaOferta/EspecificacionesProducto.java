package page.BusquedaOferta;

import Utils.DriverContext;
import org.openqa.selenium.support.PageFactory;

public class EspecificacionesProducto {
    public EspecificacionesProducto(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }
}
