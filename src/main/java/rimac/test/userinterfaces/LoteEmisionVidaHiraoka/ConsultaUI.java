package rimac.test.userinterfaces.LoteEmisionVidaHiraoka;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConsultaUI {


    public static final Target INPUT_CANAL_NEGOCIO=Target.the("INPUT_CANAL_NEGOCIO")
            .located(By.xpath("//input[@name='idetipoentidad']/parent::div/input[2]"));


    public static final String DINAMICO_CANAL_NEGOCIO="//div[contains(text(),'{0}')]";


    public static final Target INPUT_CARGA_DESDE=Target.the("INPUT_CARGA_DESDE")
            .located(By.xpath("//input[@name='fecinicio']"));


    public static final Target INPUT_CARGA_HASTA=Target.the("INPUT_CARGA_DESDE")
            .located(By.xpath("//input[@name='fecfin']"));


    public static final Target INPUT_PRODUCTO=Target.the("INPUT_PRODUCTO")
            .located(By.xpath("//input[@name='ideprod']/parent::div/input[2]"));


    public static final String DINAMICO_PRODUCTO="//div[contains(text(),'{0}')]";


    public static final Target BTN_BUSCAR=Target.the("BTN_BUSCAR")
            .located(By.xpath("//button[contains(text(),'Buscar')]"));
























}
