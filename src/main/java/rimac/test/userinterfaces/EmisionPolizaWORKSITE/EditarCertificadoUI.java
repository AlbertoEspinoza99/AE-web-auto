package rimac.test.userinterfaces.EmisionPolizaWORKSITE;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EditarCertificadoUI {


    public static final String DINAMICO_SELECCION="//tr[td/div[contains(text(),'{0}')] and td/div[contains(text(),'{1}')]]";

    public static final  Target BTN_EDITAR=Target.the("BTN_EDITAR")
            .located(By.xpath("//button[contains(text(),'Editar')]"));

    public static final  Target BTN_CERTIFICADOS=Target.the("BTN_CERTIFICADOS")
            .located(By.xpath("//span[contains(text(),'Certificados')]"));

    public static final String DINAMICO_SELECCION_CERTIFICADO_01="(//tr[td/div[contains(text(),'1')] and td/div[contains(text(),'{0}')] and td/div[contains(text(),'Activo')]])[2]";

    public static final  Target BTN_EDITAR_CERTIFICADO=Target.the("BTN_EDITAR_CERTIFICADO")
            .located(By.xpath("(//button[contains(text(),'Editar')])[2]"));

    public static final  Target BTN_ENDOSOS=Target.the("BTN_ENDOSOS")
            .located(By.xpath("(//button[contains(text(),'Endosos')])[2]"));

    public static final String DINAMICO_TIPO_ENDOSO="//span[contains(text(),'{0}')]";














}
