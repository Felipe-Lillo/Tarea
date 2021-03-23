package page;

import Utils.DriverContext;
import Utils.Espera;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubirArchivo {

    @FindBy(xpath = "//*[@id=\"imMnMnNode6\"]")
    WebElement btnCargaArchivos;
    @FindBy(id = "imObjectForm_1_2")
    WebElement btnSelecionarArchivos;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_submit\"]")
    WebElement btnEnviar;

    public SubirArchivo() {
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    public void Procesos(String ruta)throws InterruptedException{

        btnCargaArchivos.click();
        btnSelecionarArchivos.sendKeys(ruta);
        Espera.esperar("//*[@id=\"imObjectForm_1_submit\"]");
        btnEnviar.click();
    }

}
