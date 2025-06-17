package rimac.test.userinterfaces.EmisionPolizaWORKSITE;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EndosoMedioDeCobroUI {


    public static final Target LBL_NUMERO_POLIZA=Target.the("LBL_NUMERO_POLIZA")
            .located(By.xpath("(//input[@name='poliza'])[3]"));


    public static final Target BTN_SELECCION_RESPONSABLE_PAGO=Target.the("BTN_SELECCION_RESPONSABLE_PAGO")
            .located(By.xpath("//span[contains(text(),'Responsables de Pago del Certificado')]/ancestor::div[2]/div[2]/div[2]/div/div[1]/div[2]//tr[td/div[contains(text(),'1')] and td/div[contains(text(),'Activo')]]"));

    public static final Target BTN_EDITAR_RESPONSABLE_PAGO=Target.the("BTN_EDITAR_RESPONSABLE_PAGO")
            .located(By.xpath("//span[contains(text(),'Responsables de Pago del Certificado')]/ancestor::div[5]/div[1]//button[contains(text(),'Editar')]"));


    public static final Target INPUT_FORMA_DE_COBRO=Target.the("INPUT_FORMA_DE_COBRO")
            .located(By.xpath("//input[@name='idptipcobro']/parent::div/input[2]"));

    public static final String DINAMICO_FORMA_DE_PAGO="//div[contains(text(),'{0}')]";


    public static final Target BTN_GRABAR_MOVIMIENTO=Target.the("BTN_GRABAR_MOVIMIENTO")
            .located(By.xpath("//span[contains(text(),'Mantenimiento de Responsable de Pago')]/ancestor::div[5]/div[2]//button[contains(text(),'Grabar')]"));


    public static final Target BTN_CONFIRMAR_MOVIMIENTO=Target.the("BTN_CONFIRMAR_MOVIMIENTO")
            .located(By.xpath("//span[contains(text(),'Confirmar')]/ancestor::div[5]/div[2]//button[contains(text(),'Sí')]"));


    public static final Target BTN_GRABADO_EXITOSO=Target.the("BTN_GRABADO_EXITOSO")
            .located(By.xpath("//span[contains(text(),'Mensaje')]/ancestor::div[5]/div[2]//button[contains(text(),'Aceptar')]"));

    public static final Target BTN_SALIR_MANTENIMIENTO_REPONSABLE_PAGO=Target.the("BTN_SALIR_MANTENIMIENTO_REPONSABLE_PAGO")
            .located(By.xpath("//span[contains(text(),'Mantenimiento de Responsable de Pago')]/ancestor::div[5]/div[2]//b[contains(text(),'Salir')]/parent::button"));

    public static final Target BTN_SALIR_ENDOSO_DATOS_GENERALES=Target.the("BTN_SALIR_ENDOSO_DATOS_GENERALES")
            .located(By.xpath("(//span[contains(text(),'Datos Generales')])[4]/ancestor::div[5]/div[2]//button[contains(text(),'Salir')]"));

    public static final Target BTN_SALIR_ENDOSO_DATOS_GENERALES_VERSION02=Target.the("BTN_SALIR_ENDOSO_DATOS_GENERALES")
            .located(By.xpath("(//span[contains(text(),'Datos Generales')])[5]/ancestor::div[5]/div[2]//button[contains(text(),'Salir')]"));


    public static final Target BTN_SALIR_EDITAR_CERTIFICADOS=Target.the("BTN_SALIR_EDITAR_CERTIFICADOS")
            .located(By.xpath("(//button[contains(text(),'Salir')])[2]"));


    public static final Target BTN_SALIR_EDITAR_POLIZA=Target.the("BTN_SALIR_EDITAR_POLIZA")
            .located(By.xpath("(//button[contains(text(),'Salir')])[1]"));


    public static final  Target BTN_ACTUALIZAR=Target.the("BTN_ACTUALIZAR")
            .located(By.xpath("((//span[contains(text(),'Mantenimiento Póliza')])[3]/ancestor::div[3]/div[2]/div/div[1]/div/div/div/div/div[1]/div[2]/div/div[3]/div/table/tbody/tr/td/table[1]/tbody)[1]/tr/td[11]//button"));



}
