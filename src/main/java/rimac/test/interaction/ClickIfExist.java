package rimac.test.interaction;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class ClickIfExist implements Task {

    private final Target element;

    public ClickIfExist(Target element) {
        this.element = element;
    }

    public static ClickIfExist ifexist(Target element){
        return Instrumented.instanceOf(ClickIfExist.class).withProperties(element);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Target variable01=element;
        Target espera=PATH_CARGANDO;

        if (variable01.resolveFor(actor).isCurrentlyVisible() && variable01.resolveFor(actor).isCurrentlyEnabled()){
            actor.attemptsTo(
                    WaitUntil.the(element,isVisible()).forNoMoreThan(90).seconds(),
                    JavaScriptClick.on(variable01)
            );
            if (espera.resolveFor(actor).isCurrentlyEnabled() && espera.resolveFor(actor).isCurrentlyEnabled()){
                actor.attemptsTo(
                        WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds()
                );
            }else {
                actor.attemptsTo(
                        Pause.withDuration(1)
                );
            }
        }else{
            actor.attemptsTo(
                    Pause.withDuration(1)
            );
        }



    }



}
