package page;

import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import Utils.Validaciones;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class ValidacionOpciones {
    //Sitio donde se obtienen y se almacenan los xpath,id,etc.
    //---- FindBy ----
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_2\"]")
    WebElement cuaTexto;

    @FindBy(id = "imObjectForm_1_3")
    WebElement txtCorreo;

    @FindBy(id = "imObjectForm_1_4")
    WebElement txtComentario;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_5\"]")

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

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_5_icon\"]")
    WebElement btnCalendario;

    @FindBy(xpath = "//*[@id=\"imDPcal\"]/table/tbody")
    WebElement bodyCalendario;


    //---- PageFactory ----
   //Metodo que levante el sitio web donde vamos a trabajar
    public ValidacionOpciones() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }
    //Metodo que sirve para llenar los campos de textos de la página, yas sea, campos input de texto, fechas y diferentes botones
    public void llenarCampos(String texto, String fecha, String Email) {
        PdfQaNovaReports.addWebReportImage("CPA0040", "Despliege de la pestaña ensu totalidad con los campos de textos necesario y botones activos", EstadoPrueba.PASSED, false);
        cuaTexto.sendKeys(texto);
        txtCorreo.sendKeys(Email);
        txtComentario.sendKeys(texto);
        dateFecha.sendKeys(fecha);

        Select Lista = new Select(txbOpciones);
        switch (ReadProperties.readFromConfig("Properties.properties").getProperty("opcionLista")) {
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

        if (ReadProperties.readFromConfig("Properties.properties").getProperty("Checkbox1").equals("true")) {
            checkBox1.click();
        }
        if (ReadProperties.readFromConfig("Properties.properties").getProperty("Checkbox2").equals("true")) {
            checkBox2.click();
        }
        if (ReadProperties.readFromConfig("Properties.properties").getProperty("Checkbox3").equals("true")) {
            checkBox3.click();
        }

        switch (ReadProperties.readFromConfig("Properties.properties").getProperty("opcionButon")) {
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
        PdfQaNovaReports.addWebReportImage("CPA0050", "Ingreso total de todos los campos de la Pestaña", EstadoPrueba.PASSED, false);
        btnIngresar.click();
    }

    /**
     * Metodo parecido al de la tala el cual recorre el reecuadro del calendario y devuelve una fecha que este dentro del mes
     * @throws InterruptedException
     */
    public void calendario() throws InterruptedException {
        Validaciones.validarObjeto(btnCalendario, "Boton para desplegar calendario");
        btnCalendario.click();

        Validaciones.validarObjeto(bodyCalendario, "Cuerpo del calendario");
        List<WebElement> Filas = bodyCalendario.findElements(By.tagName("td"));
        int cantFilas = Filas.size();
        for (int x = 1; x < cantFilas; x++) {
            String dia = Filas.get(x).getText();
            if (dia.equalsIgnoreCase(ReadProperties.readFromConfig("Properties.properties").getProperty("Dia"))) {
                Filas.get(x).click();
                break;
            }
        }


        /*
        String lunes = "" , martes = "" , miercoles = "", jueves = "", viernes = "", sabado = "", domingo = "";
        {

            lunes = lunes + Columnas.get(0).getText() + "\n - ";
            martes = martes + Columnas.get(1).getText() + "\n - ";
            miercoles = miercoles + Columnas.get(2).getText() + "\n - ";
            jueves = jueves + Columnas.get(3).getText() + "\n - ";
            viernes = viernes + Columnas.get(4).getText() + "\n - ";
            sabado = sabado + Columnas.get(5).getText() + "\n - ";
            domingo = domingo + Columnas.get(6).getText() + "\n";
        }
        //System.out.println("Lunes" + lunes + "Martes" + );
        System.out.print("Lunes -  Martes - Miercoles - Jueves - Viernes - Sabado - Domingo");
        System.out.println(lunes + martes + miercoles + jueves + viernes + sabado + domingo );
        System.out.print("*********************************************");
        */
    }

}
