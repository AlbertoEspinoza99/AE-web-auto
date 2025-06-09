package rimac.test.userinterfaces.PolizaVidaLeyGrupo;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RenovacionVigenciaUI {


    public static final String DINAMICO_SELECCION_POLIZA="//tr[td/div[contains(text(),'{0}')] and td/div[contains(text(),'{1}')]]";

    public static final Target BTN_RENOVAR_VIGENCIA=Target.the("BTN_RENOVAR_VIGENCIA")
            .located(By.xpath("//button[contains(text(),'Renovar Vigencia')]"));

    public static final Target BTN_CONFIRMAR_RENOVACION=Target.the("BTN_CONFIRMAR_RENOVACION")
            .located(By.xpath("//button[contains(text(),'Sí')]"));


    public static final Target INPUT_TIPO_VIGENCIA=Target.the("INPUT_TIPO_VIGENCIA")
            .located(By.xpath("//input[@name='idptipovigencia']/parent::div/input[2]"));

    public static final String DINAMICO_TIPO_VIGENCIA="//div[contains(text(),'{0}')]";


    public static final Target BTN_CONTINUAR_RENOVACION=Target.the("BTN_CONTINUAR_RENOVACION")
            .located(By.xpath("//button[contains(text(),'Continuar')]"));


    public static final Target BTN_ACEPTAR_RENOVACION=Target.the("BTN_ACEPTAR_RENOVACION")
            .located(By.xpath("//button[contains(text(),'Aceptar')]"));


















}
