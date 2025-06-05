package rimac.test.userinterfaces.constantes;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BusquedaPolizaUI {


    public static final Target INPUT_NUMERO_POLIZA=Target.the("INPUT_NUMERO_POLIZA")
            .located(By.xpath("//input[@name='numero']"));

    public static final Target BTN_BUSCAR_POLIZA=Target.the("BTN_BUSCAR_POLIZA")
            .located(By.xpath("//button[contains(text(),'Buscar')]"));



}
