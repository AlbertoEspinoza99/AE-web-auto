package rimac.test.userinterfaces.PolizaVidaLeyActivo;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosGeneralesUI {


    public static final Target INPUT_ROL=Target.the("txt")
            .located(By.xpath("//input[@name='iderolcanal']/parent::div/input[2]"));

    public static final String DINAMICO_ROL="//div[.='{0}']";

    public static final Target INPUT_CANAL=Target.the("txt")
            .located(By.xpath("//input[@name='idecanal']/parent::div/input[2]"));


    public static final String DINAMICO_CANAL="//div[.='{0}']";


    public static final Target INPUT_GRUPO=Target.the("txt")
            .located(By.xpath("//input[@name='idegrupoprod']/parent::div/input[2]"));


    public static final String DINAMICO_GRUPO="//div[.='{0}']";

    public static final Target INPUT_PRODUCTO=Target.the("txt")
            .located(By.xpath("//input[@name='ideprod']/parent::div/input[2]"));


    public static final String DINAMICO_PRODUCTO="//div[.='{0}']";

    public static final Target INPUT_MONEDA=Target.the("txt")
            .located(By.xpath("//input[@name='idpmoneda']/parent::div/input[2]"));

    public static final String DINAMICO_MONEDA="//div[.='{0}']";




}
