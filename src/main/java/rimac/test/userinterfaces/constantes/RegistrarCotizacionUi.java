package rimac.test.userinterfaces.constantes;

import net.serenitybdd.screenplay.targets.Target;

public class RegistrarCotizacionUi {

    //---------------Datos generales----------------//
    public static final Target CMB_ROL = Target.the("input tipo de roles")
            .locatedBy("//input[@name=\"iderolcanal\"]//following-sibling::input");
    public static final Target LBL_CANAL = Target.the("label canal")
            .locatedBy("//label[text()='Canal:' and @class='x-form-item-label']");
    public static final Target PATH_SELECT_PLAN = Target.the("select plan")
            .locatedBy("//label[text()='Canal:']//following::div//div//input[@type='text' and @size='24' and @autocomplete='off']");
    public static final Target PATH_LOADING = Target.the("loading")
            .locatedBy("//div[@class='ext-el-mask']");
    public static final Target LBL_CANAL_SEGUROSDIRECTOS = Target.the("Label canal seguros directos")
            .locatedBy("//div[contains(@class, 'x-combo-list-item') and normalize-space(text())='SEGUROS DIRECTOS']\n");

    public static final Target BTN_EXP_IMG = Target.the("boton img")
            .locatedBy("//img[@class='x-form-trigger x-form-arrow-trigger']");
    public static final Target PATH_INP_FOCUS = Target.the("path input focus")
            .locatedBy("//input[@class='x-form-text x-form-field x-form-focus']");
    public static final Target TXT_CANAL = Target.the("input canal")
            .locatedBy("(//input[@name=\"idecanal\"]//following-sibling::input)[1]");
    public static final Target TXT_CANAL2 = Target.the("input canal")
            .locatedBy("//input[@name=\"idecanal\"]//following-sibling::input[@class=\"x-form-text x-form-field x-form-focus\"]");
    public static final Target TXT_CANAL_SEL = Target.the("input canal")
            .locatedBy("//div[@id='ext-gen944']//div[@class='x-combo-list-item x-combo-selected']");
    public static final Target TXT_PLAN = Target.the("Campo del Plan")
            .locatedBy("//input[@class=\"x-form-text x-form-field x-form-focus\"]");





    public static final Target BTN_GENERAR_DATOS_PARTICULARES = Target.the("boton para generar datos")
            .locatedBy("//button[@type='button' and text()='Generar Datos Particulares']");


    //---------------Ingresar datos----------------//
    public static final Target TXT_PLACA = Target.the("input para nro de rodaje")
            .locatedBy("//input[@type='text' and @name='txtplaca_de_rodaje']");
    public static final Target TXT_MOTOR = Target.the("input para motor")
            .locatedBy("//input[@type='text' and @name='txtnumero_de_motor']");
    public static final Target TXT_SERIE = Target.the("input para nro de serie")
            .locatedBy("//input[@type='text' and @name='txtnumero_de_serie']");
    public static final Target DIV_LIST = Target.the("lista")
            .locatedBy("(//div[@class='x-combo-list-inner'])[1]");
    public static final Target TXT_MODELO = Target.the("input para modelo")
            .locatedBy("//input[@name=\"selmodelodevehiculo\"]//following-sibling::input");
    public static final Target OPT_MODELO = Target.the("input para modelo")
            .locatedBy("//div[contains(@class,\"x-combo-list-item\") and text()='YARIS|TOYOTA|AUTO|AUTOMOVIL']");
    public static final Target TXT_TIMON = Target.the("input de timon cambiado")
            .locatedBy("//input[@name=\"selweb_timon_cambiado\"]//following-sibling::input");
    public static final Target TXT_NUM_MONTO = Target.the("input para valor asegurado")
            .locatedBy("//input[@type='text' and @name='txtsuma_asegurada']");
    public static final Target TXT_ANIO = Target.the("input para anio")
            .locatedBy("//input[@type='text' and @name='txtweb_anos_de_fabricacion']");
    public static final Target TXT_ASIENTOS = Target.the("input para numero de asientos")
            .locatedBy("//input[@type='text' and @name='txtnro_pasajeros']");
    public static final Target TXT_MODALIDAD = Target.the("input para modalidad")
            .locatedBy("//input[@name=\"selweb_modalidad_de_aseguramiento\"]//following-sibling::input");
    public static final Target TXT_USO = Target.the("input para uso de vehiculo")
            .locatedBy("//input[@name=\"selusos_de_vehiculos\"]//following-sibling::input");
    public static final Target TXT_GAS = Target.the("input de vehiculo a gas")
            .locatedBy("//input[@name=\"selcombustible_gas\"]//following-sibling::input");
    public static final Target TXT_PROCEDENCIA = Target.the("input de procedencia externa")
            .locatedBy("//input[@name=\"selprocedenciaexterna\"]//following-sibling::input");
    public static final Target TXT_INSPECCION = Target.the("input de inspeccion")
            .locatedBy("//input[@name=\"selrequiereinspeccion\"]//following-sibling::input");

    //---------------Planes----------------//
    public static final Target BTN_CALCULAR_PLANES = Target.the("boton para calcular planes")
            .locatedBy("//button[@type='button' and text()='Calcular Planes']");
    public static final Target BTN_CALCULAR = Target.the("boton para calcular datos particulares")
            .locatedBy("//button[text()='Calcular']");
    public static final Target PATH_CARGANDO = Target.the("spinning")
            .locatedBy("//div[contains(@class, 'x-mask-loading')]");
    public static final Target BTN_SELECCION_PLAN = Target.the("boton para seleccionar plan")
            .locatedBy("//div[@align='center' and text()='Seleccionar']");


    //---------------Fraccionamiento----------------//
    public static final Target BTN_PEST_FRACCIONAMIENTO = Target.the("tab pestaña de fraccionamiento")
            .locatedBy("//span[@class='x-tab-strip-text ' and text()='Fraccionamiento']");
    public static final Target TXT_FRACCIONAMIENTO = Target.the("input de fraccionamiento")
            .locatedBy("//input[@name=\"ideplanfinanciamiento\"]//following-sibling::input");
    public static final Target BTN_GENERAR_FRACCIONAMIENTO = Target.the("boton generar fraccionamiento")
            .locatedBy("//button[@type='button' and text()='Generar']");


    //---------------Cliente----------------//
    public static final Target BTN_INGRESAR_CLIENTE = Target.the("boton ingresar cliente")
            .locatedBy("//button[@type='button' and text()='Ingresar Cliente']");
    public static final Target BTN_AGREGAR_NEW = Target.the("boton agregar")
            .locatedBy("//button[@class=' x-btn-text tb-user-add' and text()='Agregar']");
    public static final Target TXT_DNI = Target.the("input para dni")
            .locatedBy("//input[@type='text' and @name='numerodoc']");
    public static final Target BTN_RESTORE = Target.the("boton restore")
            .locatedBy("//button[@type='button' and contains(@class,' x-btn-text tb-restore')]");
    public static final Target BTN_GRABAR = Target.the("boton para grabar")
            .locatedBy("//button[@type='button'  and text()='Grabar']");
    public static final Target BTN_GENERAR_COTIZACION = Target.the("boton para generar cotizacion")
            .locatedBy("//button[@type='button' and text()='Generar Cotización']");
    public static final Target BTN_SI = Target.the("boton para generar cotizacion")
            .locatedBy("//button[@type='button' and @class=' x-btn-text' and text()='Sí']");

    //Este boton se debe eliminar cuando se solucione el error del modal ERROR INTERNO al generar la cotización
    public static final Target BTN_CERRAR_ERROR = Target.the("boton para cerrar el error")
            .locatedBy("//button[@type='button' and text()='Cerrar']");


    //---------------Validacion Mantenimiento cotizacion----------------//
    public static final Target STR_COTIZACION = Target.the("texto de cotizacion")
            .locatedBy("//input[@type='text' and @name='nrocotizacion']");
    public static final Target STR_COTIZACION_SEGUNDO = Target.the("texto de cotizacion")
            .locatedBy("(//input[@type='text' and @name='nrocotizacion'])[2]");
    public static final Target STR_BRUTA = Target.the("texto prima bruta")
            .locatedBy("//input[@type='text' and @name='primabruta']");
    public static final Target STR_NETA = Target.the("texto prima neta")
            .locatedBy("// input[@type='text' and @name='primaneta']");
    public static final Target STR_POLIZA = Target.the("texto polza")
            .locatedBy("//input[@type='text' and @name='poliza']");




}
