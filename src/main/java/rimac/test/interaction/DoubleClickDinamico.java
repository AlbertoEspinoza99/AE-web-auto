package rimac.test.interaction;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DoubleClickDinamico implements Task {

    private final String localizador;
    private final String ValoDinamico;

    public DoubleClickDinamico(String localizador, String valoDinamico) {
        this.localizador = localizador;
        ValoDinamico = valoDinamico;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Target valor=Target.the("valorDinamico").locatedBy(localizador).of(ValoDinamico);

        if (valor.resolveFor(actor).isCurrentlyVisible() && valor.resolveFor(actor).isCurrentlyEnabled()){
            actor.attemptsTo(
                    WaitUntil.the(valor,isVisible()).forNoMoreThan(60).seconds(),
                    DoubleClick.on(valor)
            );
        }else {
            Pause.withDuration(5);
        }
    }

    public static DoubleClickDinamico clickDinamicos(String localizador, String ValoDinamico){
        return Instrumented.instanceOf(DoubleClickDinamico.class).withProperties(localizador,ValoDinamico);
    }



}