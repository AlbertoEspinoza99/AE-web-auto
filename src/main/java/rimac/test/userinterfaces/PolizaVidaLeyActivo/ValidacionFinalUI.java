package rimac.test.userinterfaces.PolizaVidaLeyActivo;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ValidacionFinalUI {


    public static final Target BTN_CONTINUAR_UNO=Target.the("BTN_CONTINUAR_UNO")
            .located(By.xpath("(//button[.='Continuar'])[2]"));

    public static final Target CARGANDO_AL_SUBIR_ARCHIVO=Target.the("CARGANDO_AL_SUBIR_ARCHIVO")
            .located(By.xpath("//span[.='Cargando....']"));

    public static final Target INPUT_ESTADO=Target.the("INPUT_ESTADO")
            .located(By.xpath("//input[@name='estadoproc']"));


    public static final Target BTN_CONTINUAR=Target.the("BTN_CONTINUAR")
            .located(By.xpath("(//table[@class='x-btn x-btn-text-icon']//button[.='Continuar'])"));

    public static final Target BTN_OK_CONFIRMACION_TRANSFERENCIA=Target.the("BTN_OK_CONFIRMACION_TRANSFERENCIA")
            .located(By.xpath("//span[contains(text(),'Confirmación')]/ancestor::div[5]/div[2]//button[.='Aceptar']"));


    public static final Target DIV_VALIDACION_ESTADO=Target.the("DIV_VALIDACION_ESTADO")
            .located(By.xpath("(//tr[td/div[contains(text(),'POLIZA NUEVA')] and td/div[contains(text(),'TRANSFERIDO OK')]])[1]/td[9]/div"));


    public static final Target CARGANDO_ARCHIVO=Target.the("CARGANDO_ARCHIVO")
            .located(By.xpath("//div[@class='x-progress-text']"));


    public static final Target BTN_CONTINUAR_ESTADO_INACTIVO=Target.the("BTN_CONTINUAR_ESTADO_INACTIVO")
            .located(By.xpath("//table[@class='x-btn x-btn-text-icon x-item-disabled']//button[.='Continuar']"));





}
