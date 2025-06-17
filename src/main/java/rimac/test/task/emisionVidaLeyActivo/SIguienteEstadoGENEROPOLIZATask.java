package rimac.test.task.emisionVidaLeyActivo;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.json.JSONObject;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.Pause;
import rimac.test.questions.ObtenerValorPorAtributo;
import rimac.test.userinterfaces.PolizaVidaLeyActivo.SiguienteEstadoUI;
import rimac.test.utils.UtilApp;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.PolizaVidaLeyActivo.SiguienteEstadoUI.INPUT_NUMERO_POLIZA_VALIDACION;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;
import static rimac.test.utils.UtilApp.escribirJson;

public class SIguienteEstadoGENEROPOLIZATask implements Task {

    String NuevoEstado;

    public SIguienteEstadoGENEROPOLIZATask(String nuevoEstado) {
        NuevoEstado = nuevoEstado;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(SiguienteEstadoUI.BTN_SIGUIENTE_ESTADO,isVisible()).forNoMoreThan(60).seconds(),
                Pause.withDuration(1),
                JavaScriptClick.on(SiguienteEstadoUI.BTN_SIGUIENTE_ESTADO),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds(),
                WaitUntil.the(SiguienteEstadoUI.INPUT_ESTADO_NUEVO,isVisible()).forNoMoreThan(60).seconds(),
                Enter.theValue(NuevoEstado).into(SiguienteEstadoUI.INPUT_ESTADO_NUEVO),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(SiguienteEstadoUI.DINAMICO_ESTADO_NUEVO,NuevoEstado),
                Pause.withDuration(2)
        );

        Target btnGrabarActual=SiguienteEstadoUI.BTN_GRABAR_SIGUIENTE_ESTADO_APROBADA;
        Target btnGrabarLeyCesante=SiguienteEstadoUI.BTN_GRABAR_SIGUIENTE_ESTADO_APROBADA_VIDA_LEY_CESANTE;

        if (btnGrabarActual.resolveFor(actor).isCurrentlyEnabled() && btnGrabarActual.resolveFor(actor).isCurrentlyVisible()){
            actor.attemptsTo(
                     JavaScriptClick.on(SiguienteEstadoUI.BTN_GRABAR_SIGUIENTE_ESTADO_APROBADA),
                     WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds()
            );
        } else if (btnGrabarLeyCesante.resolveFor(actor).isCurrentlyEnabled() && btnGrabarLeyCesante.resolveFor(actor).isCurrentlyVisible()) {
            actor.attemptsTo(
                    JavaScriptClick.on(SiguienteEstadoUI.BTN_GRABAR_SIGUIENTE_ESTADO_APROBADA_VIDA_LEY_CESANTE),
                    WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds()
                    );
        }


        actor.attemptsTo(
                WaitUntil.the(SiguienteEstadoUI.BTN_CONFIRMAR_VISUALIZACION_DE_POLIZA,isVisible()).forNoMoreThan(60).seconds(),
                Pause.withDuration(2),
                JavaScriptClick.on(SiguienteEstadoUI.BTN_CONFIRMAR_VISUALIZACION_DE_POLIZA)
        );

        Target input_poliza_original=SiguienteEstadoUI.INPUT_NUMERO_POLIZA;
        Target input_poliza_ley_Cesante=SiguienteEstadoUI.INPUT_NUMERO_POLIZA_LEY_CESANTE;

        if (input_poliza_original.resolveFor(actor).isCurrentlyVisible() && input_poliza_original.resolveFor(actor).isCurrentlyEnabled()){

            actor.attemptsTo(
                    WaitUntil.the(SiguienteEstadoUI.INPUT_NUMERO_POLIZA,isVisible()).forNoMoreThan(60).seconds(),
                    Pause.withDuration(3)
            );
            String poliza=actor.asksFor(ObtenerValorPorAtributo.del(SiguienteEstadoUI.INPUT_NUMERO_POLIZA, "value"));

            String NumeroPoliza =poliza;
            JSONObject datos = new JSONObject();
            datos.put("NumeroPoliza", NumeroPoliza);

            escribirJson(datos, "PolizaVidaLeyActivo");

        }else if (input_poliza_ley_Cesante.resolveFor(actor).isCurrentlyVisible() && input_poliza_ley_Cesante.resolveFor(actor).isCurrentlyEnabled()){
            actor.attemptsTo(
                    WaitUntil.the(SiguienteEstadoUI.INPUT_NUMERO_POLIZA_LEY_CESANTE,isVisible()).forNoMoreThan(60).seconds(),
                    Pause.withDuration(3)
            );

            String poliza=actor.asksFor(ObtenerValorPorAtributo.del(SiguienteEstadoUI.INPUT_NUMERO_POLIZA_LEY_CESANTE, "value"));

            String NumeroPoliza =poliza;
            JSONObject datos = new JSONObject();
            datos.put("NumeroPoliza", NumeroPoliza);

            escribirJson(datos, "PolizaVidaLeyActivo");
        }




                        Target buscar_original=SiguienteEstadoUI.BTN_BUSCAR_VALIDACION;
                        Target buscar_ley_cesante=SiguienteEstadoUI.BTN_BUSCAR_VALIDACION_LEY_CESANTE;

                        if (buscar_original.resolveFor(actor).isCurrentlyEnabled() && buscar_original.resolveFor(actor).isCurrentlyVisible()){
                            actor.attemptsTo(
                                    Pause.withDuration(1),
                                    JavaScriptClick.on(SiguienteEstadoUI.BTN_BUSCAR_VALIDACION),
                                    WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds(),
                                    Pause.withDuration(1)
                            );
                        }else if(buscar_ley_cesante.resolveFor(actor).isCurrentlyEnabled() && buscar_ley_cesante.resolveFor(actor).isCurrentlyVisible()){
                            actor.attemptsTo(
                                    Pause.withDuration(1),
                                    JavaScriptClick.on(SiguienteEstadoUI.BTN_BUSCAR_VALIDACION_LEY_CESANTE),
                                    WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds(),
                                    Pause.withDuration(1)
                            );
                        }




    }

    public static SIguienteEstadoGENEROPOLIZATask siguienteEstado(String NuevoEstado){
        return Instrumented.instanceOf(SIguienteEstadoGENEROPOLIZATask.class).withProperties(NuevoEstado);
    }



}
