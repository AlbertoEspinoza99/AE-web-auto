package rimac.test.userinterfaces.PolizaVidaLeyGrupo;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ValidacionEstadoMovimientoRenovacionUI {


    public static final String DINAMICO_REGISTRO_MOVIMIENTO="//tr[td/div[contains(text(),'{0}')] and td/div[contains(text(),'{1}')]]/td[9]/div";

    public static final Target BTN_SALIR_EDITAR=Target.the("BTN_SALIR_EDITAR")
            .located(By.xpath("(//button[contains(text(),'Salir')])[1]"));


}
