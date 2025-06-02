package rimac.test.userinterfaces.PolizaVidaLeyCesante;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class continuidadUI {

    public static final Target BTN_CONTINUIDAD=Target.the("BTN_CONTINUIDAD")
            .located(By.xpath("//span[contains(text(),'Continuidad')]"));


    public static final Target INPUT_FECHA_CESE=Target.the("INPUT_FECHA_POLIZA")
            .located(By.xpath("//input[@name='feccesepoliza']"));

  //nuevo

    public static final Target BTN_FECHA=Target.the("BTN_FECHA")
            .located(By.xpath("//input[@name='feccesepoliza']/following::img[1]"));

    public static final Target BTN_SELECCION_FECHA_ACTUAL=Target.the("BTN_SELECCION_FECHA_ACTUAL")
            .located(By.xpath("//td[@class='x-date-active x-date-today x-date-selected']//span"));





    public static final Target INPUT_FECHA_FIN_VIGENCIA=Target.the("INPUT_FECHA_FIN_VIGENCIA")
            .located(By.xpath("(//input[@name='fecfinvig'])[1]"));

    public static final Target BTN_AGREGAR=Target.the("BTN_AGREGAR")
            .located(By.xpath("(//button[contains(text(),'Agregar')])[6]"));


    public static final Target INPUT_TIPO_DOCUMENTO=Target.the("INPUT_TIPO_DOCUMENTO")
            .located(By.xpath("(//input[@name='idptipodocumento'])[2]/parent::div/input[2]"));

    public static final String DINAMICO_TIPO_DOCUMENTO="(//div[contains(text(),'{0}')])[2]";

    public static final Target INPUT_NUMERO_DOCUMENTO=Target.the("INPUT_NUMERO_DOCUMENTO")
            .located(By.xpath("(//input[@name='numerodoc'])[3]"));

    public static final Target BTN_BUSCAR_CLIENTE=Target.the("BTN_BUSCAR_CLIENTE")
            .located(By.xpath("(//button[.='Buscar Cliente'])[2]"));

    public static final Target BTN_SELECCION_RESULTADO=Target.the("BTN_SELECCION_RESULTADO")
            .located(By.xpath("(//tr[td/div[.='1'] and td/div[contains(text(),'RUC')]])"));

    public static final Target BTN_SELECCIONAR=Target.the("BTN_SELECCIONAR")
            .located(By.xpath("(//button[.='Seleccionar'])[3]"));

    public static final Target BTN_VALIDAR=Target.the("BTN_VALIDAR")
            .located(By.xpath("(//button[.='Validar'])"));

    public static final Target BTN_ACEPTAR_NO_CONTINUIDAD=Target.the("BTN_ACEPTAR_NO_CONTINUIDAD")
            .located(By.xpath("(//button[.='Aceptar'])"));


    public static final Target INPUT_ULTIMA_REMUNERACION=Target.the("INPUT_ULTIMA_REMUNERACION")
            .located(By.xpath("//input[@name='txtultima_remuneracion']"));

    public static final Target BTN_GRABAR_DATOS_PARTICULARES=Target.the("BTN_GRABAR_DATOS_PARTICULARES")
            .located(By.xpath("(//button[.='Grabar'])[2]"));















}
