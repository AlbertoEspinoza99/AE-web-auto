package rimac.test.userinterfaces.preEmisionWorksite;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosSolicitudUI {


    public static final Target INPUT_SOLICITUD=Target.the("INPUT_SOLICITUD")
            .located(By.xpath("//input[@name='idptipoformato']/parent::div/input[2]"));

    public static final String DINAMICO_SOLICITUD="//div[.='{0}']";

    public static final Target INPUT_NUMERO_SOLICITUD=Target.the("INPUT_NUMERO_SOLICITUD")
            .located(By.xpath("//input[@name='nrosolicitud']"));


    public static final Target INPUT_LOTE=Target.the("INPUT_LOTE")
            .located(By.xpath("//input[@name='lote']"));


    public static final Target INPUT_NUMERO_REGITRO=Target.the("INPUT_NUMERO_REGITRO")
            .located(By.xpath("//input[@name='folio']"));

    public static final Target INPUT_FECHA_FIRMA=Target.the("INPUT_FECHA_FIRMA")
            .located(By.xpath("//input[@name='fecfirma']"));

    public static final Target INPUT_RAZON_SOCIAL=Target.the("INPUT_RAZON_SOCIAL")
            .located(By.xpath("//input[@name='numerodocvia']"));

    public static final Target INPUT_DEPENDENCIA=Target.the("INPUT_DEPENDENCIA")
            .located(By.xpath("//input[@name='idelugar']/parent::div/input[2]"));


    public static final String DINAMICO_DEPENDENCIA="(//div[contains(text(),'{0}')])[3]";

    public static final Target INPUT_MES_PRODUCCION=Target.the("INPUT_MES_PRODUCCION")
            .located(By.xpath("//input[@name='mesproduccion']/parent::div/input[2]"));

    public static final String DINAMICO_MES_PRODUCCION="//div[contains(text(),'{0}')]";




















}
