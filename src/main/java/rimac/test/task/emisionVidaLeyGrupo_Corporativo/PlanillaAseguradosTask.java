package rimac.test.task.emisionVidaLeyGrupo_Corporativo;

import com.google.gson.JsonObject;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.json.JSONObject;
import rimac.test.interaction.ClickDinamico2Parametros;
import rimac.test.interaction.Pause;
import rimac.test.task.utils.ExcelEditorRemplazandoCelda;
import rimac.test.userinterfaces.PolizaVidaLeyGrupo.PlanillaDeAseguradosUI;
import rimac.test.utils.UtilApp;

import java.nio.file.Paths;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;
import static rimac.test.utils.UtilApp.escribirJson;

public class PlanillaAseguradosTask implements Task {


    private final String producto;
    private final String estadoPoliza;
    private final String numeroTramite;
    private final String tipoProducto;

    public PlanillaAseguradosTask(String producto, String estadoPoliza, String numeroTramite, String tipoProducto) {
        this.producto = producto;
        this.estadoPoliza = estadoPoliza;
        this.numeroTramite = numeroTramite;
        this.tipoProducto = tipoProducto;
    }

    public static PlanillaAseguradosTask asegurados(String producto, String estadoPoliza, String numeroTramite, String tipoProducto){
       return Instrumented.instanceOf(PlanillaAseguradosTask.class).withProperties(producto,estadoPoliza,numeroTramite,tipoProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                ClickDinamico2Parametros.clickDinamicos(PlanillaDeAseguradosUI.DINAMICO_SELECCION_POLIZA,producto,estadoPoliza),
                Pause.withDuration(2),
                JavaScriptClick.on(PlanillaDeAseguradosUI.BTN_EDITAR),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds(),
                WaitUntil.the(PlanillaDeAseguradosUI.BTN_ASEGURADO,isVisible()).forNoMoreThan(90).seconds(),
                Click.on(PlanillaDeAseguradosUI.BTN_ASEGURADO),
                WaitUntil.the(PlanillaDeAseguradosUI.DIV_CODIGO_SUCURSAL,isVisible()).forNoMoreThan(90).seconds()
        );

        String CodigoSucursal=PlanillaDeAseguradosUI.DIV_CODIGO_SUCURSAL.resolveFor(actor).getText();
        JSONObject obj=new JSONObject();
        obj.put("Cod_sucursal",CodigoSucursal);

        escribirJson(obj,"NumeroSucursal");
        String obtenerNumero= UtilApp.getJsonValue("src/test/resources/jsonData/NumeroSucursal.json","$['Cod_sucursal']");
        String rutaAbsolutarutaExcel= Paths.get("src/test/resources/archivos","VL DNI valido - VL.xlsx").toAbsolutePath().toString();

        try {
            ExcelEditorRemplazandoCelda.reemplazarSucursal(obtenerNumero,tipoProducto,rutaAbsolutarutaExcel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(
                WaitUntil.the(PlanillaDeAseguradosUI.BTN_MOVIMIENTOS,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(PlanillaDeAseguradosUI.BTN_MOVIMIENTOS),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds(),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds()
        );

        Target tramite01=PlanillaDeAseguradosUI.INPUT_NUMERO_TRAMITE;
        Target tramite02=PlanillaDeAseguradosUI.INPUT_NUMERO_TRAMITE_2;

         if (tramite02.resolveFor(actor).isCurrentlyEnabled() && tramite02.resolveFor(actor).isCurrentlyVisible()){
             actor.attemptsTo(
                     WaitUntil.the(PlanillaDeAseguradosUI.INPUT_NUMERO_TRAMITE_2,isVisible()).forNoMoreThan(90).seconds(),
                     Enter.theValue(numeroTramite).into(PlanillaDeAseguradosUI.INPUT_NUMERO_TRAMITE_2),
                     Pause.withDuration(2),
                     WaitUntil.the(PlanillaDeAseguradosUI.BTN_CONTINUAR_NUMERO_TRAMITE_2,isVisible()).forNoMoreThan(90).seconds(),
                     JavaScriptClick.on(PlanillaDeAseguradosUI.BTN_CONTINUAR_NUMERO_TRAMITE_2),
                     WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds(),
                     Pause.withDuration(4)

             );
         }else if (tramite01.resolveFor(actor).isCurrentlyVisible() && tramite01.resolveFor(actor).isCurrentlyEnabled()){
             actor.attemptsTo(

                     WaitUntil.the(PlanillaDeAseguradosUI.INPUT_NUMERO_TRAMITE,isVisible()).forNoMoreThan(90).seconds(),
                     Enter.theValue(numeroTramite).into(PlanillaDeAseguradosUI.INPUT_NUMERO_TRAMITE),
                     Pause.withDuration(2),
                     WaitUntil.the(PlanillaDeAseguradosUI.BTN_CONTINUAR_NUMERO_TRAMITE,isVisible()).forNoMoreThan(90).seconds(),
                     JavaScriptClick.on(PlanillaDeAseguradosUI.BTN_CONTINUAR_NUMERO_TRAMITE),
                     WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds(),
                     Pause.withDuration(4)
             );
         }

        String rutaAbsoluta= Paths.get("src/test/resources/archivos","VL DNI valido - VL.xlsx").toAbsolutePath().toString();

        actor.attemptsTo(
                Pause.withDuration(1)
        );

        PlanillaDeAseguradosUI.INPUT_ARCHIVO.resolveFor(actor).sendKeys(rutaAbsoluta);

        Target continuarArhivo01=PlanillaDeAseguradosUI.BTN_CONTINUAR_CARGA_DE_ARCHIVO;
        Target continuarArhivo02=PlanillaDeAseguradosUI.BTN_CONTINUAR_CARGA_DE_ARCHIVO_2;

        if (continuarArhivo01.resolveFor(actor).isCurrentlyEnabled() && continuarArhivo01.resolveFor(actor).isCurrentlyVisible()){
            actor.attemptsTo(
                    Pause.withDuration(2),
                    WaitUntil.the(PlanillaDeAseguradosUI.BTN_CONTINUAR_CARGA_DE_ARCHIVO,isVisible()).forNoMoreThan(90).seconds(),
                    JavaScriptClick.on(PlanillaDeAseguradosUI.BTN_CONTINUAR_CARGA_DE_ARCHIVO),
                    WaitUntil.the(PlanillaDeAseguradosUI.CARGANDO_ARCHIVO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                    WaitUntil.the(PlanillaDeAseguradosUI.BTN_CONFIRMACION_TRANSACCION, isVisible()).forNoMoreThan(400).seconds(),
                    JavaScriptClick.on(PlanillaDeAseguradosUI.BTN_CONFIRMACION_TRANSACCION),
                    WaitUntil.the(PlanillaDeAseguradosUI.BTN_SALIR_EDITAR,isVisible()).forNoMoreThan(90).seconds()

            );
        }else if (continuarArhivo02.resolveFor(actor).isCurrentlyVisible() && continuarArhivo02.resolveFor(actor).isCurrentlyEnabled()){

            actor.attemptsTo(
                    Pause.withDuration(2),
                    WaitUntil.the(PlanillaDeAseguradosUI.BTN_CONTINUAR_CARGA_DE_ARCHIVO_2,isVisible()).forNoMoreThan(90).seconds(),
                    JavaScriptClick.on(PlanillaDeAseguradosUI.BTN_CONTINUAR_CARGA_DE_ARCHIVO_2),
                    WaitUntil.the(PlanillaDeAseguradosUI.CARGANDO_ARCHIVO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                    WaitUntil.the(PlanillaDeAseguradosUI.BTN_CONFIRMACION_TRANSACCION, isVisible()).forNoMoreThan(400).seconds(),
                    JavaScriptClick.on(PlanillaDeAseguradosUI.BTN_CONFIRMACION_TRANSACCION),
                    WaitUntil.the(PlanillaDeAseguradosUI.BTN_SALIR_EDITAR,isVisible()).forNoMoreThan(90).seconds()

            );
        }



    }


}
