package rimac.test.task.emisionVidaLeyActivo;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.json.JSONObject;
import rimac.test.interaction.NombreyNumeroAleatorio;
import rimac.test.interaction.Pause;
import rimac.test.task.utils.ExcelEditorRemplazandoCelda;
import rimac.test.userinterfaces.PolizaVidaLeyActivo.EmisionUI;
import rimac.test.userinterfaces.PolizaVidaLeyActivo.ValidacionFinalUI;
import rimac.test.utils.UtilApp;


import java.nio.file.Paths;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.PolizaVidaLeyActivo.ValidacionFinalUI.BTN_CONTINUAR_ESTADO_INACTIVO;
import static rimac.test.userinterfaces.PolizaVidaLeyActivo.ValidacionFinalUI.CARGANDO_ARCHIVO;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;
import static rimac.test.utils.UtilApp.escribirJson;

public class AgregarSucursalTask implements Task {

    private final String numeroTramite;
    private final String tipoProducto;

    public AgregarSucursalTask(String numeroTramite, String tipoProducto) {
        this.numeroTramite = numeroTramite;
        this.tipoProducto = tipoProducto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(EmisionUI.BTN_SELECCION_RESULTADO,isVisible()).forNoMoreThan(20).seconds(),
                Click.on(EmisionUI.BTN_SELECCION_RESULTADO),
                JavaScriptClick.on(EmisionUI.BTN_EDITAR),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(3),
                WaitUntil.the(EmisionUI.BTN_SUCURSALES,isVisible()).forNoMoreThan(20).seconds(),
                Click.on(EmisionUI.BTN_SUCURSALES),
                WaitUntil.the(EmisionUI.BTN_AGREGAR_SUCURSAL,isVisible()).forNoMoreThan(20).seconds(),
                JavaScriptClick.on(EmisionUI.BTN_AGREGAR_SUCURSAL),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds()
                );

        Serenity.setSessionVariable("nombresaleatorios").to(NombreyNumeroAleatorio.aleatorio());
        String valorRecuperado=Serenity.sessionVariableCalled("nombresaleatorios");

        actor.attemptsTo(
                WaitUntil.the(EmisionUI.BTN_NUEVA_SUCURSAL,isVisible()).forNoMoreThan(50).seconds(),
                JavaScriptClick.on(EmisionUI.BTN_NUEVA_SUCURSAL),
                WaitUntil.the(EmisionUI.INPUT_NOMBRE_SUCURSAL,isVisible()).forNoMoreThan(50).seconds(),
                Enter.theValue(valorRecuperado).into(EmisionUI.INPUT_NOMBRE_SUCURSAL),
                Pause.withDuration(2),
                JavaScriptClick.on(EmisionUI.BTN_GRABAR_SUCURSAL),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                JavaScriptClick.on(EmisionUI.BTN_ACEPTAR),
                Pause.withDuration(1),
                JavaScriptClick.on(EmisionUI.BTN_SALIR_CREACION_SUCURSAL),
                Pause.withDuration(1),
                WaitUntil.the(EmisionUI.INPUT_SUCURSAL,isVisible()).forNoMoreThan(50).seconds(),
                Enter.theValue(valorRecuperado).into(EmisionUI.INPUT_SUCURSAL),
                JavaScriptClick.on(EmisionUI.BTN_BUSCAR),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(EmisionUI.BTN_SELECCION_SUCURSALES,isVisible()).forNoMoreThan(20).seconds(),
                DoubleClick.on(EmisionUI.BTN_SELECCION_SUCURSALES),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(2)
                );


        actor.attemptsTo(
                WaitUntil.the(EmisionUI.BTN_SALIR_RIESGOS,isVisible()).forNoMoreThan(20).seconds(),
                Pause.withDuration(2),
                Click.on(EmisionUI.BTN_SELECCION_DE_RIESGO),
                Pause.withDuration(2),
                JavaScriptClick.on(EmisionUI.BTN_GRABAR_SELECCION_DE_RIESGO),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(2),
                WaitUntil.the(EmisionUI.DIV_CODIGO_SUCURSAL,isVisible()).forNoMoreThan(60).seconds(),
                Pause.withDuration(2)
                );

         String CodigoSucursal=EmisionUI.DIV_CODIGO_SUCURSAL.resolveFor(actor).getText();
        JSONObject data=new JSONObject();
        data.put("Cod_sucursal",CodigoSucursal);

        escribirJson(data,"NumeroSucursal");
        String sucursal = UtilApp.getJsonValue("src/test/resources/jsonData/NumeroSucursal.json","$['Cod_sucursal']");
        String rutaAbsolutarutaExcel= Paths.get("src/test/resources/archivos","VL DNI valido - VL.xlsx").toAbsolutePath().toString();

        try {
            ExcelEditorRemplazandoCelda.reemplazarSucursal(sucursal,tipoProducto,rutaAbsolutarutaExcel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        actor.attemptsTo(
                WaitUntil.the(EmisionUI.BTN_MOVIMIENTOS,isVisible()).forNoMoreThan(20).seconds(),
                JavaScriptClick.on(EmisionUI.BTN_MOVIMIENTOS),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(3),
                WaitUntil.the(EmisionUI.INPUT_NUMERO_TRAMITE,isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(numeroTramite).into(EmisionUI.INPUT_NUMERO_TRAMITE),
                Pause.withDuration(1),
                JavaScriptClick.on(EmisionUI.BTN_CONTINUAR),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(4)

        );

               String rutaAbsoluta= Paths.get("src/test/resources/archivos","VL DNI valido - VL.xlsx").toAbsolutePath().toString();


                        actor.attemptsTo(
                                Pause.withDuration(1)
                        );

                // Enviar el archivo directamente con sendKeys
                        EmisionUI.INPUT_ARCHIVO_2.resolveFor(actor).sendKeys(rutaAbsoluta);


                actor.attemptsTo(
                        Pause.withDuration(1),
                        Pause.withDuration(2),
                        JavaScriptClick.on(ValidacionFinalUI.BTN_CONTINUAR_UNO),
                        WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                        WaitUntil.the(CARGANDO_ARCHIVO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                        // INICIO paso que han cambiado en sas proyecto
                        WaitUntil.the(BTN_CONTINUAR_ESTADO_INACTIVO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds(),
                        Pause.withDuration(1),
                        WaitUntil.the(BTN_CONTINUAR_ESTADO_INACTIVO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds(),
                        Pause.withDuration(2),
                        Click.on(ValidacionFinalUI.INPUT_ESTADO),
                        Pause.withDuration(1),
                        WaitUntil.the(BTN_CONTINUAR_ESTADO_INACTIVO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds(),
                        Pause.withDuration(3),
                        WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                        Click.on(ValidacionFinalUI.INPUT_ESTADO),
                        WaitUntil.the(ValidacionFinalUI.BTN_CONTINUAR, isVisible()).forNoMoreThan(30).seconds(),
                        JavaScriptClick.on(ValidacionFinalUI.BTN_CONTINUAR),
                        // FIN paso que han cambiado en sas proyecto
                        WaitUntil.the(ValidacionFinalUI.BTN_OK_CONFIRMACION_TRANSFERENCIA,isVisible()).forNoMoreThan(50).seconds(),
                        JavaScriptClick.on(ValidacionFinalUI.BTN_OK_CONFIRMACION_TRANSFERENCIA),
                        Pause.withDuration(6),
                        WaitUntil.the(ValidacionFinalUI.DIV_VALIDACION_ESTADO,isVisible()).forNoMoreThan(20).seconds()

                );

    }

    public static AgregarSucursalTask Sucursal(String numeroTramite, String tipoProducto){
        return Instrumented.instanceOf(AgregarSucursalTask.class).withProperties(numeroTramite,tipoProducto);
    }



}
