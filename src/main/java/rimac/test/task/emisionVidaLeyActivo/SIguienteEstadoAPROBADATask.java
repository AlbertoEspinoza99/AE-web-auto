package rimac.test.task.emisionVidaLeyActivo;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.ClickIfExist;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.PolizaVidaLeyActivo.SiguienteEstadoUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class SIguienteEstadoAPROBADATask implements Task {

    String NuevoEstado;

    public SIguienteEstadoAPROBADATask(String nuevoEstado) {
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
                Pause.withDuration(1),
                Enter.theValue(NuevoEstado).into(SiguienteEstadoUI.INPUT_ESTADO_NUEVO),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(SiguienteEstadoUI.DINAMICO_ESTADO_NUEVO,NuevoEstado),
                Pause.withDuration(2)
        );

        Target valorOriginal=SiguienteEstadoUI.BTN_GRABAR_SIGUIENTE_ESTADO_APROBADA;
        Target valorVidaCesante=SiguienteEstadoUI.BTN_GRABAR_SIGUIENTE_ESTADO_APROBADA_VIDA_LEY_CESANTE;

        if (valorOriginal.resolveFor(actor).isCurrentlyEnabled() && valorOriginal.resolveFor(actor).isCurrentlyVisible()){
            actor.attemptsTo(
                     WaitUntil.the(SiguienteEstadoUI.BTN_GRABAR_SIGUIENTE_ESTADO_APROBADA,isVisible()).forNoMoreThan(60).seconds(),
                      JavaScriptClick.on(SiguienteEstadoUI.BTN_GRABAR_SIGUIENTE_ESTADO_APROBADA)
            );
        }else if(valorVidaCesante.resolveFor(actor).isCurrentlyVisible() && valorVidaCesante.resolveFor(actor).isCurrentlyEnabled()){
            actor.attemptsTo(
                    WaitUntil.the(SiguienteEstadoUI.BTN_GRABAR_SIGUIENTE_ESTADO_APROBADA_VIDA_LEY_CESANTE,isVisible()).forNoMoreThan(60).seconds(),
                    JavaScriptClick.on(SiguienteEstadoUI.BTN_GRABAR_SIGUIENTE_ESTADO_APROBADA_VIDA_LEY_CESANTE),
                    WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds()
                    );
        }

        actor.attemptsTo(
                ClickIfExist.ifexist(SiguienteEstadoUI.BTN_NO_CONTRATO_REASEGURO),
                //WaitUntil.the(SiguienteEstadoUI.BTN_NO_CONTRATO_REASEGURO,isVisible()).forNoMoreThan(60).seconds(),
                //JavaScriptClick.on(SiguienteEstadoUI.BTN_NO_CONTRATO_REASEGURO),
                //WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds(),
                Pause.withDuration(2),
                WaitUntil.the(SiguienteEstadoUI.BTN_GRABADO_EXITOSO,isVisible()).forNoMoreThan(60).seconds(),
                JavaScriptClick.on(SiguienteEstadoUI.BTN_GRABADO_EXITOSO),
                WaitUntil.the(SiguienteEstadoUI.BTN_SIGUIENTE_ESTADO,isVisible()).forNoMoreThan(60).seconds(),
                Pause.withDuration(3)

        );

    }

    public static SIguienteEstadoAPROBADATask siguienteEstado(String NuevoEstado){
        return Instrumented.instanceOf(SIguienteEstadoAPROBADATask.class).withProperties(NuevoEstado);
    }



}
