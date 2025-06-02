package rimac.test.userinterfaces.preEmisionWorksite;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductosUI {


    public static final String CHECKBOX_SELECCION_PRODUCTO="(//div[contains(text(),'{0}')])[1]/parent::td/parent::tr/td[2]/div/div";

    public static final String BTN_SELECCION_PRODUCTO="(//div[contains(text(),'{0}')])[1]/parent::td/parent::tr";

    public static final Target INPUT_PLAN=Target.the("INPUT_PLAN")
            .located(By.xpath("//input[@name='ext-comp-1150']"));

    public static final String DINAMICO_PLAN="//div[contains(text(),'{0}')]";

    public static final Target INPUT_TIPO_PLAN=Target.the("INPUT_TIPO_PLAN")
            .locatedBy("//input[@name='ext-comp-1151']");

    public static final String DINAMICO_TIPO_PLAN="//div[.='{0}']";

    public static final Target INPUT_FRACCIONAMIENTO=Target.the("INPUT_FRACCIONAMIENTO")
            .located(By.xpath("//input[@name='ext-comp-1152']"));

    public static final String DINAMICO_FRACCIONAMIENTO="//div[contains(text(),'{0}')]";

    public static final Target BTN_GRABAR_PRODUCTO=Target.the("BTN_GRABAR")
            .located(By.xpath("(//button[.='Grabar'])[1]"));

    public static final Target BTN_CONFIRMAR_PRODUCTOS=Target.the("BTN_CONFIRMAR_PRODUCTOS")
            .located(By.xpath("//button[contains(text(),'Confirmar Productos')]"));




}
