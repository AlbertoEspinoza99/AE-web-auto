package rimac.test.userinterfaces.EmisionPolizaWORKSITE;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ActivarPolizaUI {

    public static final  Target BTN_ACTUALIZAR=Target.the("BTN_ACTUALIZAR")
            .located(By.xpath("((//span[contains(text(),'Mantenimiento Póliza')])[3]/ancestor::div[3]/div[2]/div/div[1]/div/div/div/div/div[1]/div[2]/div/div[3]/div/table/tbody/tr/td/table[1]/tbody)[1]/tr/td[11]//button"));

    public static final String DINAMICO_SELECCION="//tr[td/div[contains(text(),'{0}')] and td/div[contains(text(),'{1}')]]";


    public static final  Target BTN_EDITAR_ACTIVAR=Target.the("BTN_EDITAR_ACTIVAR")
            .located(By.xpath("//button[contains(text(),'Editar')]"));


    public static final Target BTN_ACTIVAR=Target.the("BTN_ACTIVAR")
            .located(By.xpath("//button[contains(text(),'Activar')]"));


    public static final Target BTN_CONFIRMAR_ACTIVACION_POLIZA=Target.the("BTN_CONFIRMAR_ACTIVACION_POLIZA")
            .located(By.xpath("//span[contains(text(),'Confirmar')]/ancestor::div[5]/div[2]//button[contains(text(),'Sí')]"));


    public static final Target BTN_ACTIVACION_EXITOSA=Target.the("BTN_ACTIVACION_EXITOSA")
            .located(By.xpath("//span[contains(text(),'Mensaje')]/ancestor::div[5]/div[2]//button[contains(text(),'Aceptar')]"));


    public static final Target BTN_SALIR_EDITAR_POLIZA=Target.the("")
            .located(By.xpath("(//button[contains(text(),'Salir')])[1]"));


    public static final Target LBL_ESTADO_POLIZA=Target.the("LBL_ESTADO_POLIZA")
            .located(By.xpath("(//input[@name='stsacuerdo'])[2]/parent::div/input[2]"));



}
