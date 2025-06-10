package rimac.test.userinterfaces.PolizaVidaLeyGrupo;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PlanillaDeAseguradosUI {


    public static final Target BTN_ASEGURADO=Target.the("BTN_ASEGURADO")
            .located(By.xpath("(//span[.='Sucursales'])[2]"));

    public static final Target DIV_CODIGO_SUCURSAL=Target.the("DIV_CODIGO_SUCURSAL")
            .located(By.xpath("//div[.='Cod Sucursal']/ancestor::div[4]/div[2]//tr/td[2]/div"));


    public static final String DINAMICO_SELECCION_POLIZA="//tr[td/div[contains(text(),'{0}')] and td/div[contains(text(),'{1}')]]";


    public static final Target BTN_EDITAR=Target.the("BTN_EDITAR")
            .located(By.xpath("//button[contains(text(),'Editar')]"));

    public static final Target BTN_MOVIMIENTOS=Target.the("BTN_MOVIMIENTOS")
            .located(By.xpath("//button[contains(text(),'Movimientos')]"));


    public static final Target INPUT_NUMERO_TRAMITE=Target.the("INPUT_NUMERO_TRAMITE")
            .located(By.xpath("(//input[@name='nrotramite'])[3]"));

    public static final Target BTN_CONTINUAR_NUMERO_TRAMITE=Target.the("BTN_CONTINUAR")
            .located(By.xpath("(//button[.='Continuar'])[2]"));



    public static final Target INPUT_ARCHIVO=Target.the("INPUT_ARCHIVO_3")
            .located(By.xpath("//input[@name='vcfile']"));


    public static final Target BTN_CONTINUAR_CARGA_DE_ARCHIVO=Target.the("BTN_CONTINUAR_UNO")
            .located(By.xpath("(//button[.='Continuar'])[3]"));

    public static final Target CARGANDO_ARCHIVO=Target.the("CARGANDO_ARCHIVO")
            .located(By.xpath("//div[@class='x-progress-text']"));


    public static final Target BTN_CONFIRMACION_TRANSACCION=Target.the("BTN_CONFIRMACION_TRANSACCION")
            .located(By.xpath("//span[contains(text(),'Confirmación')]/ancestor::div[5]/div[2]//button[.='Aceptar']"));


    public static final Target BTN_SALIR_EDITAR=Target.the("BTN_SALIR_EDITAR")
            .located(By.xpath("//span[contains(text(),'Historial Movimientos')]"));


    // otros

    public static final Target INPUT_NUMERO_TRAMITE_2=Target.the("INPUT_NUMERO_TRAMITE_2")
            .located(By.xpath("(//input[@name='nrotramite'])[2]"));

    public static final Target BTN_CONTINUAR_NUMERO_TRAMITE_2=Target.the("BTN_CONTINUAR")
            .located(By.xpath("(//button[.='Continuar'])"));

    public static final Target BTN_CONTINUAR_CARGA_DE_ARCHIVO_2=Target.the("BTN_CONTINUAR_DOS")
            .located(By.xpath("(//button[.='Continuar'])[2]"));



    // RENOVACION


    public static final Target INPUT_TIPO_MOVIMIENTO=Target.the("INPUT_TIPO_MOVIMIENTO")
            .located(By.xpath("(//input[@name='idptipomov']/parent::div/input[2])[1]"));

    public static final String DINAMICO_TIPO_MOVIMIENTO="//div[contains(text(),'{0}')]";





}
