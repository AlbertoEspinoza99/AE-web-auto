package rimac.test.userinterfaces.PolizaVidaLeyActivo;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RiesgoUI {

    public static final Target BTN_RIESGO = Target.the("txt")
            .located(By.xpath("(//span[.='Riesgos'])[1]"));


    public static final Target BTN_AGREGAR=Target.the("txt")
            .located(By.xpath("(//button[.='Agregar'])[2]"));


    public static final Target INPUT_TIPO_RIESGO =Target.the("txt")
            .located(By.xpath("//input[@name='idpnivelgruporiesgo']/parent::div/input[2]"));


    public static final String DINAMICO_TIPO_RIESGO = "(//div[.='Empleados'])";


    public static final Target INPUT_NUMERO_PASAJEROS =Target.the("txt")
            .located(By.xpath("//input[@name='totalasegurado']"));


    public static final Target INPUT_MONTO_PLANILLA_MENSUAL =Target.the("txt")
            .located(By.xpath("//input[@name='montoplanilla']"));


    public static final Target BTN_CALCULAR =Target.the("txt")
            .located(By.xpath("//button[.='Calcular']"));


    public static final Target BTN_GRABAR_RIESGO =Target.the("txt")
            .located(By.xpath("(//button[.='Grabar'])[2]"));















}
