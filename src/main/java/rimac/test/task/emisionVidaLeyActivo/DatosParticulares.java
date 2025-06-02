package rimac.test.task.emisionVidaLeyActivo;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.PolizaVidaLeyActivo.DatosParticularUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class DatosParticulares implements Task {

    String PrimaMinimaEndoso;

    public DatosParticulares(String primaMinimaEndoso) {
        PrimaMinimaEndoso = primaMinimaEndoso;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(DatosParticularUI.BTN_DATO_PARTICULAR,isVisible()).forNoMoreThan(20).seconds(),
                JavaScriptClick.on(DatosParticularUI.BTN_DATO_PARTICULAR),
                WaitUntil.the(DatosParticularUI.INPUT_PRIMA_MINIMA_ENDOS,isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(PrimaMinimaEndoso).into(DatosParticularUI.INPUT_PRIMA_MINIMA_ENDOS),
                Pause.withDuration(2),
                JavaScriptClick.on(DatosParticularUI.CHECKBOX_POLIZA_RANGO_ETAREO),
                Pause.withDuration(2),
                JavaScriptClick.on(DatosParticularUI.BUTTON_GRABAR_DATOS_PARTICULARES),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(DatosParticularUI.BTN_MENSAJE_CONFIRMACION,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(DatosParticularUI.BTN_MENSAJE_CONFIRMACION),
                Pause.withDuration(2)

                );

    }

    public static DatosParticulares RellenarDT(String PrimaMinimaEndoso){
        return Instrumented.instanceOf(DatosParticulares.class).withProperties(PrimaMinimaEndoso);
    }



}
