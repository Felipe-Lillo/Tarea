package page.QAnova;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubirArchivo {
    //Sitio donde se obtienen y se almacenan los xpath,id,etc.
    @FindBy(xpath = "//*[@id=\"imMnMnNode6\"]")
    WebElement btnCargaArchivos;
    @FindBy(id = "imObjectForm_1_2")
    WebElement btnSelecionarArchivos;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_submit\"]")
    WebElement btnEnviar;
    //Metodo que levante el sitio web donde vamos a trabajar
    public SubirArchivo() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void procesos(String ruta) throws InterruptedException {

        btnCargaArchivos.click();
        btnSelecionarArchivos.sendKeys(ruta);

        btnEnviar.click();
    }

}
