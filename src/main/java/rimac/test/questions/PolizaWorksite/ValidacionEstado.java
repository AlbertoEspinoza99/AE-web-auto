package rimac.test.questions.PolizaWorksite;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.EmisionPolizaWORKSITE.ValidacionEstadoPolizaUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionEstado implements Question<Boolean> {


    private final String producto;
    private final String estadoFinal;


    public ValidacionEstado(String producto, String estadoFinal) {
        this.producto = producto;
        this.estadoFinal = estadoFinal;
    }

    public static ValidacionEstado validacion(String producto, String estadoFinal){
       return Instrumented.instanceOf(ValidacionEstado.class).withProperties(producto,estadoFinal);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(ValidacionEstadoPolizaUI.BTN_ACTUALIZAR,isVisible()).forNoMoreThan(90).seconds(),
                Pause.withDuration(10),
                JavaScriptClick.on(ValidacionEstadoPolizaUI.BTN_ACTUALIZAR)
        );

        Target valor=Target.the("EstadoPoliza").locatedBy(ValidacionEstadoPolizaUI.LBL_ESTADO_POLIZA_DINAMICO).of(producto,estadoFinal);
        String estado=valor.resolveFor(actor).getText().trim();

        if (valor.resolveFor(actor).isCurrentlyEnabled() && valor.resolveFor(actor).isCurrentlyVisible()){

            if (estado.equals(estadoFinal)){
                return true;
            }else {
                return false;
            }

        }else {
            return false;
        }
    }



}
