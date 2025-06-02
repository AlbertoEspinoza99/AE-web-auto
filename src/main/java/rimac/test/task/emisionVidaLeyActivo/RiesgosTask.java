package rimac.test.task.emisionVidaLeyActivo;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.PolizaVidaLeyActivo.RiesgoUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class RiesgosTask implements Task {

    String TipoRiesgo;
    String numeroAsegurado;
    String MontoPlanillaMensual;

    public RiesgosTask(String tipoRiesgo, String numeroAsegurado, String montoPlanillaMensual) {
        TipoRiesgo = tipoRiesgo;
        this.numeroAsegurado = numeroAsegurado;
        MontoPlanillaMensual = montoPlanillaMensual;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
         actor.attemptsTo(
                 WaitUntil.the(RiesgoUI.BTN_RIESGO,isVisible()).forNoMoreThan(60).seconds(),
                 JavaScriptClick.on(RiesgoUI.BTN_RIESGO),
                 WaitUntil.the(RiesgoUI.BTN_AGREGAR,isVisible()).forNoMoreThan(60).seconds(),
                 Pause.withDuration(2),
                 JavaScriptClick.on(RiesgoUI.BTN_AGREGAR),
                 WaitUntil.the(RiesgoUI.INPUT_TIPO_RIESGO,isVisible()).forNoMoreThan(60).seconds(),
                 Pause.withDuration(2),
                 Enter.theValue(TipoRiesgo).into(RiesgoUI.INPUT_TIPO_RIESGO),
                 Pause.withDuration(2),
                 ClickDinamico.clickDinamicos(RiesgoUI.DINAMICO_TIPO_RIESGO,TipoRiesgo),
                 WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                 WaitUntil.the(RiesgoUI.INPUT_NUMERO_PASAJEROS,isVisible()).forNoMoreThan(60).seconds(),
                 Enter.theValue(numeroAsegurado).into(RiesgoUI.INPUT_NUMERO_PASAJEROS),
                 Pause.withDuration(1),
                 WaitUntil.the(RiesgoUI.INPUT_MONTO_PLANILLA_MENSUAL,isVisible()).forNoMoreThan(60).seconds(),
                 Enter.theValue(MontoPlanillaMensual).into(RiesgoUI.INPUT_MONTO_PLANILLA_MENSUAL),
                 Pause.withDuration(1),
                 JavaScriptClick.on(RiesgoUI.BTN_CALCULAR),
                 WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                 Pause.withDuration(2),
                 WaitUntil.the(RiesgoUI.BTN_GRABAR_RIESGO,isVisible()).forNoMoreThan(60).seconds(),
                 JavaScriptClick.on(RiesgoUI.BTN_GRABAR_RIESGO),
                 WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                 WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                 Pause.withDuration(2)
                 );

    }

    public static RiesgosTask riesgos(String TipoRiesgo,String numeroAsegurado,String MontoPlanillaMensual){
        return Instrumented.instanceOf(RiesgosTask.class).withProperties(TipoRiesgo,numeroAsegurado,MontoPlanillaMensual);

    }



}
