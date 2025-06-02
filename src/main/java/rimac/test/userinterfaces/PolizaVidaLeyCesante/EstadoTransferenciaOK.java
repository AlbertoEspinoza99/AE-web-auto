package rimac.test.userinterfaces.PolizaVidaLeyCesante;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EstadoTransferenciaOK {

    public static final Target BTN_SELECCION_POLIZA_ACTIVA=Target.the("BTN_SELECCION_POLIZA_ACTIVA")
            .located(By.xpath("//tr[td/div[contains(text(),'Vida Ley Cesantes')] and td/div[contains(text(),'Activo')]]"));

    public static final Target BTN_EDITAR=Target.the("BTN_EDITAR")
            .located(By.xpath("//button[contains(text(),'Editar')]"));

    public static final Target BTN_HISTORIAL_MOVIMIENTOS=Target.the("BTN_HISTORIAL_MOVIMIENTOS")
            .located(By.xpath("(//span[contains(text(),'Historial Movimientos')])"));

    public static final Target LBL_TRANSFERENCIA_OK=Target.the("LBL_TRANSFERENCIA_OK")
            .located(By.xpath("//tr[td/div[contains(text(),'POLIZA NUEVA')] and td/div[contains(text(),'TRANSFERIDO OK')]]/td[9]/div"));

    public static final Target BTN_SALIR_EDITAR=Target.the("BTN_SALIR_EDITAR")
            .located(By.xpath("(//button[contains(text(),'Salir')])[4]"));


}
