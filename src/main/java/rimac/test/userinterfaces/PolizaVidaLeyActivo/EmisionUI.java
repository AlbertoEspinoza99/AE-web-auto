package rimac.test.userinterfaces.PolizaVidaLeyActivo;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EmisionUI {


    public static final Target BTN_MANTENIMIENTO_POLIZA=Target.the("BTN_MANTENIMIENTO_POLIZA")
            .located(By.xpath("//span[.='Mantenimiento Póliza']"));

    public static final Target INPUT_NUMERO_POLIZA=Target.the("INPUT_NUMERO_POLIZA")
            .located(By.xpath("(//input[@name='numero'])"));


    public static final Target BTN_BUSCAR_NUMERO_POLIZA=Target.the("BTN_BUSCAR_NUMERO_POLIZA")
            .located(By.xpath("(//button[.='Buscar'])"));

    public static final Target BTN_SELECCION_RESULTADO=Target.the("BTN_SELECCION_RESULTADO")
            .located(By.xpath("(//tr[td/div[contains(text(),'Generado')] and td/div[contains(text(),'1')]])"));

    public static final Target BTN_EDITAR=Target.the("BTN_EDITAR")
            .located(By.xpath("(//button[.='Editar'])"));

    public static final Target BTN_SUCURSALES=Target.the("BTN_SUCURSALES")
            .located(By.xpath("(//span[.='Sucursales'])[2]"));

    public static final Target BTN_AGREGAR_SUCURSAL=Target.the("BTN_AGREGAR_SUCURSAL")
            .located(By.xpath("(//button[.='Agregar'])"));



    // nuevos
    public static final Target BTN_SELECCION_DE_RIESGO=Target.the("BTN_SELECCION_DE_RIESGO")
            .located(By.xpath("(//tr[td/div[.='1'] and td/div[.='Empleados']])[2]"));

    public static final Target BTN_GRABAR_SELECCION_DE_RIESGO=Target.the("BTN_GRABAR_SELECCION_DE_RIESGO")
            .located(By.xpath("//button[.='Grabar']"));

    //
    public static final Target BTN_SALIR_RIESGOS=Target.the("BTN_SALIR_RIESGOS")
            .located(By.xpath("(//button[.='Salir'])[3]"));

    public static final Target BTN_SALIR_DATOS_GENERALES=Target.the("BTN_SALIR_DATOS_GENERALES")
            .located(By.xpath("(//button[.='Salir'])[1]"));


    public static final Target BTN_MOVIMIENTOS=Target.the("BTN_MOVIMIENTOS")
            .located(By.xpath("(//button[.='Movimientos'])"));


    public static final Target INPUT_NUMERO_TRAMITE=Target.the("INPUT_NUMERO_TRAMITE")
            .located(By.xpath("(//input[@name='nrotramite'])[2]"));

    public static final Target BTN_CONTINUAR=Target.the("BTN_CONTINUAR")
            .located(By.xpath("(//button[.='Continuar'])"));


    public static final Target INPUT_ARCHIVO_2=Target.the("INPUT_ARCHIVO")
            .located(By.xpath("//input[@name='vcfile']/parent::div/input[2]"));

    public static final Target DIV_CODIGO_SUCURSAL=Target.the("DIV_CODIGO_SUCURSAL")
            .located(By.xpath("//div[.='Cod Sucursal']/ancestor::div[4]/div[2]//tr/td[2]/div"));



    // nueva sucursal

    public static final Target BTN_NUEVA_SUCURSAL=Target.the("BTN_NUEVA_SUCURSAL")
            .located(By.xpath("//button[contains(text(),'Nueva Sucursal')]"));


    public static final Target INPUT_NOMBRE_SUCURSAL=Target.the("INPUT_NOMBRE_SUCURSAL")
            .located(By.xpath("//input[@name='dsclugar']"));


    public static final Target BTN_GRABAR_SUCURSAL=Target.the("BTN_GRABAR_SUCURSAL")
            .located(By.xpath("//button[contains(text(),'Grabar Sucursal')]"));

    public static final Target BTN_ACEPTAR=Target.the("BTN_ACEPTAR")
            .located(By.xpath("//button[contains(text(),'Aceptar')]"));

    public static final Target BTN_SALIR_CREACION_SUCURSAL=Target.the("BTN_SALIR_CREACION_SUCURSAL")
            .located(By.xpath("(//button[contains(text(),'Salir')])[3]"));

    public static final Target INPUT_SUCURSAL=Target.the("INPUT_SUCURSAL")
            .located(By.xpath("//input[@name='dscsucursal']"));

    public static final Target BTN_BUSCAR=Target.the("BTN_BUSCAR")
            .located(By.xpath("(//button[contains(text(),'Buscar')])[2]"));

    public static final Target BTN_SELECCION_SUCURSALES=Target.the("BTN_SELECCION_SUCURSALES")
            .located(By.xpath("(//tr[td/div[contains(text(),'ACTIVO')]])[1]"));





















}
