package page;

import Utils.DriverContext;
import Utils.ReadProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ValidacionOpciones {

//---- FindBy ----
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_2\"]")
    WebElement cuaTexto;

    @FindBy(id = "imObjectForm_1_3")
    WebElement txtCorreo;

    @FindBy(id = "imObjectForm_1_4")
    WebElement txtComentario;

    @FindBy(id = "imObjectForm_1_5")
    WebElement dateFecha;

    @FindBy(id = "imObjectForm_1_6")
    WebElement txbOpciones;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_0\"]")
    WebElement checkBox1;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_1\"]")
    WebElement checkBox2;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_2\"]")
    WebElement checkBox3;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_0\"]")
    WebElement radioBtn1;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_1\"]")
    WebElement radioBtn2;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_2\"]")
    WebElement radioBtn3;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_submit\"]")
    WebElement btnIngresar;

//---- PageFactory ----
    public ValidacionOpciones(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }
    public void llenarCampos( String texto, String fecha ,String Email){

        cuaTexto.sendKeys(texto);
        txtCorreo.sendKeys(Email);
        txtComentario.sendKeys(texto);
        dateFecha.sendKeys(fecha);

        Select Lista = new Select(txbOpciones);
        switch (ReadProperties.readFromConfig("Properties.properties").getProperty("opcionLista")){
            case "1":
                Lista.selectByIndex(1);
                break;
            case "2":
                Lista.selectByIndex(2);
                break;
            case "3":
                Lista.selectByIndex(3);
                break;
            default:
                System.out.println("No existe la opcion ingresada");
        }

        if (ReadProperties.readFromConfig("Properties.properties").getProperty("Checkbox1").equals("true")){
            checkBox1.click();
        }
        if (ReadProperties.readFromConfig("Properties.properties").getProperty("Checkbox2").equals("true")){
            checkBox2.click();
        }
        if (ReadProperties.readFromConfig("Properties.properties").getProperty("Checkbox3").equals("true")){
            checkBox3.click();
        }
        switch (ReadProperties.readFromConfig("Properties.properties").getProperty("opcionButon")){
            case "1":
                radioBtn1.click();
                break;
            case "2":
                radioBtn2.click();
                break;
            case "3":
                radioBtn3.click();
                break;
            default:
                System.out.println("No Existe la opcion ingresada");
        }

        btnIngresar.click();










    }

}
