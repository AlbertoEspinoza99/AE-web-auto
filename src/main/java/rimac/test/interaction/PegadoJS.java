package rimac.test.interaction;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PegadoJS implements Task {

    private final Target target;
    private final String valor;

    public PegadoJS(Target target, String valor) {
        this.target = target;
        this.valor = valor;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        WebElement elemento=target.resolveFor(actor);
        JavascriptExecutor js= (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();

        js.executeScript("arguments[0].value = arguments[1];", elemento, valor);

        // Si hay un evento onchange, puedes forzarlo
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", elemento);


    }

    public static PegadoJS pegar(Target target,String valor){
        return Instrumented.instanceOf(PegadoJS.class).withProperties(target,valor);
    }

}