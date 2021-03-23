package page;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Tarea {

    @FindBy(xpath = "//*[@id=\"imLoginPage\"]/div[3]/div")
    WebElement msmError;

    @FindBy(xpath = "//*[@id=\"imLogin\"]/form/div[3]/input")
    WebElement btnIngresar;


    public Tarea() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void RecuperarMensaje() throws InterruptedException {

        btnIngresar.click();
        msmError.getCssValue("Color");
        System.out.println(msmError.getCssValue("color"));
        msmError.getText();
        System.out.println(msmError.getText());
        Assert.assertEquals(msmError.getText(),"Nombre y/o password incorrecto");


    }
}