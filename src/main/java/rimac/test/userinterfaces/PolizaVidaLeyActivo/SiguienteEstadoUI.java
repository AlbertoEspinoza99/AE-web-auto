package rimac.test.userinterfaces.PolizaVidaLeyActivo;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SiguienteEstadoUI {


    public static final Target BTN_SIGUIENTE_ESTADO=Target.the("BTN_SIGUIENTE_ESTADO")
            .located(By.xpath("//button[.='Siguiente Estado']"));

    public static final Target INPUT_ESTADO_NUEVO=Target.the("INPUT_ESTADO_NUEVO")
            .located(By.xpath("(//input[@name='ideestadooperacion'])[2]/parent::div/input[2]"));

    public static final String DINAMICO_ESTADO_NUEVO="//div[contains(text(),'{0}')]";

    public static final Target INPUT_ENVIAR_A =Target.the("INPUT_ENVIAR_A")
            .located(By.xpath("//input[@name='correoadic']"));

    public static final Target INPUT_MOTIVO=Target.the("INPUT_MOTIVO")
            .located(By.xpath("//textarea[@name='dscmotivo']"));


    public static final Target BTN_GRABAR_SIGUIENTE_ESTADO=Target.the("BTN_GRABAR_SIGUIENTE_ESTADO")
            .located(By.xpath("(//button[.='Grabar'])[3]"));

    public static final Target BTN_GRABAR_SIGUIENTE_ESTADO_APROBADA=Target.the("BTN_GRABAR_SIGUIENTE_ESTADO_APROBADA")
            .located(By.xpath("(//button[.='Grabar'])[4]"));

    public static final Target BTN_GRABADO_EXITOSO =Target.the("BTN_GRABADO_EXITOSO")
            .located(By.xpath("(//button[.='Aceptar'])"));

    public static final Target BTN_NO_CONTRATO_REASEGURO =Target.the("BTN_NO_CONTRATO_REASEGURO")
            .located(By.xpath("//button[.='No']"));

    public static final Target BTN_CONFIRMAR_VISUALIZACION_DE_POLIZA =Target.the("BTN_CONFIRMAR_VISUALIZACION_DE_POLIZA")
            .located(By.xpath("(//button[.='Sí'])"));

    public static final Target INPUT_NUMERO_POLIZA =Target.the("INPUT_NUMERO_POLIZA")
            .located(By.xpath("//input[@name='numero']"));


    public static final Target INPUT_NUMERO_POLIZA_VALIDACION=Target.the("INPUT_NUMERO_POLIZA_VALIDACION")
            .located(By.xpath("//input[@name='numero']"));


    public static final Target BTN_BUSCAR_VALIDACION=Target.the("BTN_BUSCAR_VALIDACION")
            .located(By.xpath("//button[.='Buscar']"));


    // vida ley cesante

    public static final Target BTN_GRABAR_SIGUIENTE_ESTADO_APROBADA_VIDA_LEY_CESANTE=Target.the("BTN_GRABAR_SIGUIENTE_ESTADO_APROBADA_VIDA_LEY_CESANTE")
            .located(By.xpath("(//button[.='Grabar'])[3]"));




}
