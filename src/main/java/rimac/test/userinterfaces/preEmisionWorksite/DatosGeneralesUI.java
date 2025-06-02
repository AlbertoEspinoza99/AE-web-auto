package rimac.test.userinterfaces.preEmisionWorksite;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosGeneralesUI {

    public static final Target INPUT_CANAL=Target.the("INPUT_CANAL")
            .located(By.xpath("//input[@name='idecanal']/parent::div/input[2]"));

    public static final String DINAMICO_CANAL="//div[contains(text(),'{0}')]";

    public static final Target INPUT_VENDEDOR=Target.the("INPUT_VENDEDOR")
            .located(By.xpath("//input[@name='idevendedor']/parent::div/input[2]"));

    public static final String DINAMICO_VENDEDOR="//div[contains(text(),'{0}')]";







}
