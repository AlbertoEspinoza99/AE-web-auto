package rimac.test.userinterfaces.PolizaVidaLeyGrupo;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosParticularessUI {

    public static final Target BTN_DATO_PARTICULAR = Target.the("txt")
            .located(By.xpath("(//span[.='Datos Particulares'])[2]"));

    public static final Target INPUT_TIPO_VIGENCIA = Target.the("INPUT_TIPO_VIGENCIA")
            .located(By.xpath("//input[@name='idptipovigencia']/parent::div/input[2]"));


    public static final String DINAMICO_TIPO_VIGENCIA ="//div[contains(text(),'{0}')]";

    public static final Target INPUT_PRIMA_MINIMA_EMISION = Target.the("INPUT_PRIMA_MINIMA_EMISION")
            .located(By.xpath("//input[@name='primaminima']"));


    public static final Target INPUT_PRIMA_MINIMA_ENDOS = Target.the("INPUT_PRIMA_MINIMA_ENDOS")
            .located(By.xpath("//input[@name='primaendoso']"));

    public static final Target INPUT_SUELDO_ASEGURABLE = Target.the("INPUT_SUELDO_ASEGURABLE")
            .located(By.xpath("//input[@name='mtosueldoase']"));


    public static final Target BUTTON_GRABAR_DATOS_PARTICULARES = Target.the("BUTTON_GRABAR_DATOS_PARTICULARES")
            .located(By.xpath("//button[.='Grabar']"));


    public static final Target BTN_MENSAJE_CONFIRMACION = Target.the("BTN_MENSAJE_CONFIRMACION")
            .located(By.xpath("//button[.='Aceptar']"));



}
