package rimac.test.userinterfaces.preEmisionWorksite;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TitulasUI {

    public static final Target INPUT_DNI=Target.the("INPUT_DNI")
            .located(By.xpath("//input[@name='numerodoc']"));

    public static final Target BTN_BUSCAR_USUARIO=Target.the("BTN_BUSCAR_USUARIO")
            .located(By.xpath("//input[@name='numerodoc']/ancestor::div[5]/following::div[1]//button"));

    public static final Target INPUT_COD_EMPLEADO=Target.the("INPUT_COD_EMPLEADO")
            .located(By.xpath("//input[@name='nroempleado']"));






}
