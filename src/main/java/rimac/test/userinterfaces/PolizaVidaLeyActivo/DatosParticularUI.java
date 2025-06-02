package rimac.test.userinterfaces.PolizaVidaLeyActivo;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosParticularUI {

    public static final Target BTN_DATO_PARTICULAR = Target.the("txt")
            .located(By.xpath("(//span[.='Datos Particulares'])[2]"));

    public static final Target INPUT_PRIMA_MINIMA_ENDOS = Target.the("txt")
            .located(By.xpath("//input[@name='primaendoso']"));


    public static final Target CHECKBOX_POLIZA_RANGO_ETAREO = Target.the("txt")
            .located(By.xpath("//input[@name='indrangoetareo']"));

    public static final Target BUTTON_GRABAR_DATOS_PARTICULARES = Target.the("txt")
            .located(By.xpath("//button[.='Grabar']"));


    public static final Target BTN_MENSAJE_CONFIRMACION = Target.the("txt")
            .located(By.xpath("//button[.='Aceptar']"));

}
