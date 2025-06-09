package rimac.test.interaction;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickDinamico2Parametros implements Task {

    private final String localizador;
    private final String ValoDinamico;
    private final String ValoDinamico2;

    public ClickDinamico2Parametros(String localizador, String valoDinamico, String valoDinamico2) {
        this.localizador = localizador;
        ValoDinamico = valoDinamico;
        ValoDinamico2 = valoDinamico2;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Target valor=Target.the("valorDinamico").locatedBy(localizador).of(ValoDinamico,ValoDinamico2);

        if (valor.resolveFor(actor).isCurrentlyVisible() && valor.resolveFor(actor).isCurrentlyEnabled()){
            actor.attemptsTo(
                    WaitUntil.the(valor,isVisible()).forNoMoreThan(180).seconds(),
                    Click.on(valor)
            );
        }else {
            Pause.withDuration(5);
        }

    }

    public static ClickDinamico2Parametros clickDinamicos(String localizador, String ValoDinamico,String ValoDinamico2){
        return Instrumented.instanceOf(ClickDinamico2Parametros.class).withProperties(localizador,ValoDinamico,ValoDinamico2);
    }



}