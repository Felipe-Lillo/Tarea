package page.ChileAutos;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerificaciónCaptcha {
    @FindBy(xpath = "//*[@id=\"1e505deed3832c02c96ca5abe70df9ab\"]/div/div[2]/div[1]/div[3]")
    WebElement captcha;

    public VerificaciónCaptcha(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    public void saltarcapcha(){
        captcha.click();
    }
}
