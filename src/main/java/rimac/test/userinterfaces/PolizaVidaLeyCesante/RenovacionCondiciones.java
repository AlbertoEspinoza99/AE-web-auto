package rimac.test.userinterfaces.PolizaVidaLeyCesante;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RenovacionCondiciones {


    public static final String DINAMICO_SELECCION_PRODUCTO="//tr[td/div[contains(text(),'{0}')] and td/div[contains(text(),'{1}}')]]";

   public static final Target BTN_RENOVAR_CONDICIONES=Target.the("BTN_RENOVAR_CONDICIONES")
           .located(By.xpath("//button[contains(text(),'Renovar Condiciones')]"));


   public static final Target BTN_ASEGURAR_RENOVACION=Target.the("BTN_ASEGURAR_RENOVACION")
           .located(By.xpath("//span[contains(text(),'Renovación')]/ancestor::div[5]/div[2]/div[2]//button[contains(text(),'Sí')]"));












}
