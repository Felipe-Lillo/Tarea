package page;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wikipedia {
    @FindBy(xpath = "//*[@id=\"mw-content-text\"]/div[1]/p[1]")
    WebElement txtPrarrafo;

    public Wikipedia(){
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void ExtraerTexto() throws InterruptedException{
        System.out.println(txtPrarrafo.getText());

    }

}
