package rimac.test.questions.polizaVidaLeyCesante;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.PolizaVidaLeyCesante.EstadoTransferenciaOK;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class TransferenciaOK implements Question<Boolean> {

    private final Target elemento;
    private final String estado;

    public TransferenciaOK(Target elemento, String estado) {
        this.elemento = elemento;
        this.estado = estado;
    }

    public static TransferenciaOK validacion(Target elemento, String estado){
        return Instrumented.instanceOf(TransferenciaOK.class).withProperties(elemento,estado);
    }


    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(EstadoTransferenciaOK.BTN_SELECCION_POLIZA_ACTIVA,isVisible()).forNoMoreThan(20).seconds(),
                Click.on(EstadoTransferenciaOK.BTN_SELECCION_POLIZA_ACTIVA),
                Pause.withDuration(2),
                JavaScriptClick.on(EstadoTransferenciaOK.BTN_EDITAR),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(EstadoTransferenciaOK.BTN_HISTORIAL_MOVIMIENTOS,isVisible()).forNoMoreThan(90).seconds(),
                Click.on(EstadoTransferenciaOK.BTN_HISTORIAL_MOVIMIENTOS),
                WaitUntil.the(EstadoTransferenciaOK.LBL_TRANSFERENCIA_OK,isVisible()).forNoMoreThan(90).seconds()
                );

        String valor=elemento.resolveFor(actor).getText().trim();

        if (valor.equals(estado)){
            actor.attemptsTo(
                    WaitUntil.the(EstadoTransferenciaOK.BTN_SALIR_EDITAR,isVisible()).forNoMoreThan(90).seconds(),
                    JavaScriptClick.on(EstadoTransferenciaOK.BTN_SALIR_EDITAR)
            );

            return true;
        }else {
            return false;
        }


    }



}
