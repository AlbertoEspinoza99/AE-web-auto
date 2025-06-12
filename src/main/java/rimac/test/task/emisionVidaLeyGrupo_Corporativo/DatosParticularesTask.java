package rimac.test.task.emisionVidaLeyGrupo_Corporativo;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.PolizaVidaLeyGrupo.DatosParticularessUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class DatosParticularesTask implements Task {

    private final String tipoVigencia;
    private final String PrimaMinEmision;
    private final String PrimaMinEndoso;
    private final String SueldoAsegurable;
    private final String segmento;

    public DatosParticularesTask(String tipoVigencia, String primaMinEmision, String primaMinEndoso, String sueldoAsegurable, String segmento) {
        this.tipoVigencia = tipoVigencia;
        PrimaMinEmision = primaMinEmision;
        PrimaMinEndoso = primaMinEndoso;
        SueldoAsegurable = sueldoAsegurable;
        this.segmento = segmento;
    }

    public static DatosParticularesTask DT(String tipoVigencia, String primaMinEmision, String primaMinEndoso, String sueldoAsegurable,String segmento){
        return Instrumented.instanceOf(DatosParticularesTask.class).withProperties(tipoVigencia,primaMinEmision,primaMinEndoso,sueldoAsegurable,segmento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(DatosParticularessUI.BTN_DATO_PARTICULAR,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(DatosParticularessUI.BTN_DATO_PARTICULAR),
                WaitUntil.the(DatosParticularessUI.INPUT_TIPO_VIGENCIA,isVisible()).forNoMoreThan(90).seconds(),
                Enter.theValue(tipoVigencia).into(DatosParticularessUI.INPUT_TIPO_VIGENCIA),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(DatosParticularessUI.DINAMICO_TIPO_VIGENCIA,tipoVigencia),
                Pause.withDuration(1),
                //NUEVO
                WaitUntil.the(DatosParticularessUI.INPUT_SEGMENTO,isVisible()).forNoMoreThan(60).seconds(),
                Enter.theValue(segmento).into(DatosParticularessUI.INPUT_SEGMENTO),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(DatosParticularessUI.DINAMICO_SEGMENTO,segmento),

                WaitUntil.the(DatosParticularessUI.INPUT_PRIMA_MINIMA_EMISION,isVisible()).forNoMoreThan(60).seconds(),
                Enter.theValue(PrimaMinEmision).into(DatosParticularessUI.INPUT_PRIMA_MINIMA_EMISION),
                Pause.withDuration(1),
                WaitUntil.the(DatosParticularessUI.INPUT_PRIMA_MINIMA_ENDOS,isVisible()).forNoMoreThan(60).seconds(),
                Enter.theValue(PrimaMinEndoso).into(DatosParticularessUI.INPUT_PRIMA_MINIMA_ENDOS),
                Pause.withDuration(1),
                WaitUntil.the(DatosParticularessUI.INPUT_SUELDO_ASEGURABLE,isVisible()).forNoMoreThan(60).seconds(),
                Enter.theValue(SueldoAsegurable).into(DatosParticularessUI.INPUT_SUELDO_ASEGURABLE),
                Pause.withDuration(1),
                JavaScriptClick.on(DatosParticularessUI.BUTTON_GRABAR_DATOS_PARTICULARES),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(DatosParticularessUI.BTN_MENSAJE_CONFIRMACION,isVisible()).forNoMoreThan(60).seconds(),
                JavaScriptClick.on(DatosParticularessUI.BTN_MENSAJE_CONFIRMACION),
                Pause.withDuration(6)

        );
    }



}
