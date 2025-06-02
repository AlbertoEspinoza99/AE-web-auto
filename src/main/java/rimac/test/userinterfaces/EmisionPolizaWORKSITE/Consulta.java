package rimac.test.userinterfaces.EmisionPolizaWORKSITE;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Consulta {

    public static final Target INPUT_SOLICITUD=Target.the("")
            .located(By.xpath("//input[@name='idptipoformato']/parent::div/input[2]"));

    public static final String DINAMICO_SOLICITUD="(//div[.='{0}'])[3]";

    public static final Target INPUT_NUMERO_DE_SERVICIO=Target.the("INPUT_NUMERO_DE_SERVICIO")
            .located(By.xpath("//input[@name='nrosolicitud']"));

    public static final Target INPUT_FECHA_SOLICITUD=Target.the("INPUT_FECHA_SOLICITUD")
            .located(By.xpath("//input[@name='fecini']"));


    public static final Target INPUT_HASTA=Target.the("INPUT_HASTA")
            .located(By.xpath("//input[@name='fecfin']"));


    public static final Target BTN_BUSCAR_POLIZA=Target.the("BTN_BUSCAR_POLIZA")
            .located(By.xpath("//button[contains(text(),'Buscar')]"));


}
