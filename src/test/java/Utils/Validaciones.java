package Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Validaciones {

    public static void validarObjeto(WebElement elemento, String descripcionElemento) {
        WebDriverWait espera = new WebDriverWait(DriverContext.getDriver(), Integer.valueOf(ReadProperties.readFromConfig("Properties.properties").getProperty("TiempoEspera")));
        String identificador;
        try {
            espera.until(ExpectedConditions.visibilityOf(elemento));
            identificador = elemento.getAttribute("xpath");
            if (identificador == null) {
                identificador = elemento.getAttribute("id");
            }
            System.out.println("Se despliega correctamente el elemento \"" + descripcionElemento + "\", identificador: " + identificador);
        } catch (Exception e) {
            System.out.println("No se despliega el elemento \"" + descripcionElemento + "\"");
        }
    }
}
