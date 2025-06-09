package rimac.test.task.utils;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.InsertBarrera;
import rimac.test.interaction.Pause;
import rimac.test.interaction.PegadoJS;
import rimac.test.userinterfaces.constantes.BusquedaPolizaUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class BusquedaTask implements Task {

    private final String numeroPoliza;

    public BusquedaTask(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public static BusquedaTask busqueda(String numeroPoliza){
        return Instrumented.instanceOf(BusquedaTask.class).withProperties(numeroPoliza);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String numeroPolizaOficial= InsertBarrera.insert(numeroPoliza,4,4);

        actor.attemptsTo(
                WaitUntil.the(BusquedaPolizaUI.INPUT_NUMERO_POLIZA,isVisible()).forNoMoreThan(90).seconds(),
                PegadoJS.pegar(BusquedaPolizaUI.INPUT_NUMERO_POLIZA,numeroPolizaOficial),
                JavaScriptClick.on(BusquedaPolizaUI.BTN_BUSCAR_POLIZA),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(500).seconds(),
                Pause.withDuration(2)
        );


    }


}
