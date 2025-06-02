package rimac.test.userinterfaces.PolizaVidaLeyActivo;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ClienteUI {

    public static final Target BTN_AGREGAR_CLIENTE=Target.the("txt")
            .located(By.xpath("(//button[.='Agregar'])[1]"));

    public static final Target INPUT_TIPO_DOCUMENTO=Target.the("txt")
            .located(By.xpath("//input[@name='idptipodocumento']/parent::div/input[2]"));

    public static final String DINAMICO_TIPO_DOCUMENTO="//div[contains(text(),'{0}')]";


    public static final Target INPUT_NUMERO_DOCUMENTO=Target.the("txt")
            .located(By.xpath("(//input[@name='numerodoc'])[2]"));


    public static final Target BTN_BUSCAR_CLIENTE=Target.the("txt")
            .located(By.xpath("//button[.='Buscar Cliente']"));


    public static final Target BTN_RESULTADO_CLIENTE=Target.the("txt")
            .located(By.xpath("//tr[td/div[.='1'] and td/div[contains(text(),'RUC')]]"));

    public static final Target BTN_SELECCIONAR_CLIENTE=Target.the("txt")
            .located(By.xpath("//button[.='Seleccionar']"));

    public static final Target BTN_SELECCIONAR_CLIENTE_DOS=Target.the("txt")
            .located(By.xpath("(//button[.='Seleccionar'])[2]"));


    // vida ley cesante

    public static final Target BTN_AGREGAR_CLIENTE_DOS=Target.the("BTN_AGREGAR_CLIENTE_DOS")
            .located(By.xpath("(//button[.='Agregar'])[5]"));

    public static final Target BTN_RESULTADO_CLIENTE_DOS=Target.the("txt")
            .located(By.xpath("//tr[td/div[.='1'] and td/div[contains(text(),'DNI')]]"));




}
