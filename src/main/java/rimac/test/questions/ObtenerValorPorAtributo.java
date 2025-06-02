package rimac.test.questions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ObtenerValorPorAtributo implements Question<String> {

    private final Target target;
    private final String atributo;

    public ObtenerValorPorAtributo(Target target, String atributo) {
        this.target = target;
        this.atributo = atributo;
    }

    public static ObtenerValorPorAtributo del(Target target, String atributo) {
        return Instrumented.instanceOf(ObtenerValorPorAtributo.class).withProperties(target, atributo);
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isVisible())
                        .forNoMoreThan(5)
                        .seconds()
        );

        WebElement elemento = target.resolveFor(actor);
        return elemento.getAttribute(atributo);
    }
}
