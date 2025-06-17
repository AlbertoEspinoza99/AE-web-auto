package rimac.test.userinterfaces.EmisionPolizaWORKSITE;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ValidacionEstadoPolizaUI {

    public static final  Target BTN_ACTUALIZAR=Target.the("BTN_ACTUALIZAR")
            .located(By.xpath("((//span[contains(text(),'Mantenimiento Póliza')])[3]/ancestor::div[3]/div[2]/div/div[1]/div/div/div/div/div[1]/div[2]/div/div[3]/div/table/tbody/tr/td/table[1]/tbody)[1]/tr/td[11]//button"));


    public static final String LBL_ESTADO_POLIZA_DINAMICO="(//tr[td/div[contains(text(),'{0}')] and td/div[contains(text(),'{1}')]])[1]/td[7]/div";




}
