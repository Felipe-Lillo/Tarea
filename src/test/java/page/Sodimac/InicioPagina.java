package page.Sodimac;

import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Validaciones;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InicioPagina {
    @FindBy(xpath = "//*[@id=\"header-med-search-bar-SearchBar-79247401-c89a-4b16-9d3c-f91206c21c2c-desktop\"]/input")
    WebElement barraBusqueda;
    public InicioPagina(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }
    public void primeraPestaña(){
        Validaciones.validarObjeto(barraBusqueda,"barra de busqueda");
        barraBusqueda.sendKeys(ReadProperties.readFromConfig("Properties.properties").getProperty("producto"));
        barraBusqueda.sendKeys(Keys.ENTER);

    }
}
