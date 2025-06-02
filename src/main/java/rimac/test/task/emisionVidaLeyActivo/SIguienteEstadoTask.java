package rimac.test.task.emisionVidaLeyActivo;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.PolizaVidaLeyActivo.SiguienteEstadoUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class SIguienteEstadoTask implements Task {

    String NuevoEstado;

    public SIguienteEstadoTask(String nuevoEstado) {
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
                Pause.withDuration(2),
                Click.on(SiguienteEstadoUI.BTN_GRABAR_SIGUIENTE_ESTADO),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds(),
                WaitUntil.the(SiguienteEstadoUI.BTN_GRABADO_EXITOSO,isVisible()).forNoMoreThan(60).seconds(),
                JavaScriptClick.on(SiguienteEstadoUI.BTN_GRABADO_EXITOSO),
                WaitUntil.the(SiguienteEstadoUI.BTN_SIGUIENTE_ESTADO,isVisible()).forNoMoreThan(60).seconds(),
                Pause.withDuration(3)
                );

    }

    public static SIguienteEstadoTask siguienteEstado(String NuevoEstado){
        return Instrumented.instanceOf(SIguienteEstadoTask.class).withProperties(NuevoEstado);
    }



}
