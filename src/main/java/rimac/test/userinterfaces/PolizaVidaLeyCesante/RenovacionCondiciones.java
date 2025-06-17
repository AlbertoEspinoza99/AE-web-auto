package rimac.test.userinterfaces.PolizaVidaLeyCesante;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RenovacionCondiciones {


    public static final String DINAMICO_SELECCION_PRODUCTO="//tr[td/div[contains(text(),'{0}')] and td/div[contains(text(),'{1}')]]";

   public static final Target BTN_RENOVAR_CONDICIONES=Target.the("BTN_RENOVAR_CONDICIONES")
           .located(By.xpath("//button[contains(text(),'Renovar Condiciones')]"));


   public static final Target BTN_CONFIRMAR_RENOVACION=Target.the("BTN_ASEGURAR_RENOVACION")
           .located(By.xpath("//span[contains(text(),'Renovación')]/ancestor::div[5]/div[2]/div[2]//button[contains(text(),'Sí')]"));


    public static final Target BTN_CONFIRMAR_ADVERTENCIA=Target.the("BTN_CONFIRMAR_ADVERTENCIA")
            .located(By.xpath("//span[contains(text(),'Advertencia')]/ancestor::div[5]/div[2]/div[2]//button[contains(text(),'Sí')]"));

    public static final Target BTN_DOCUMENTOS=Target.the("BTN_DOCUMENTOS")
            .located(By.xpath("(//span[contains(text(),'Documentos')])[2]"));

    public static final Target BTN_SIGUIENTE_ESTADO=Target.the("BTN_SIGUIENTE_ESTADO")
            .located(By.xpath("//button[.='Siguiente Estado']"));


    public static final Target BTN_DATOS_PARTICULARES=Target.the("BTN_DOCUMENTOS")
            .located(By.xpath("(//span[contains(text(),'Datos Particulares')])[2]"));


    public static final Target LBL_COTIZACION=Target.the("LBL_COTIZACION")
            .located(By.xpath("//input[@name='numacuerdo']"));


















}
