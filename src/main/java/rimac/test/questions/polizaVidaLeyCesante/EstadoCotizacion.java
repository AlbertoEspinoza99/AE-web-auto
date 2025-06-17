package rimac.test.questions.polizaVidaLeyCesante;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.utils.UtilApp;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EstadoCotizacion implements Question<Boolean> {

    private final String estado;

    public EstadoCotizacion(String estado) {
        this.estado = estado;
    }

    public static EstadoCotizacion validacion(String estado){
        return Instrumented.instanceOf(EstadoCotizacion.class).withProperties(estado);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String nroPoliza = UtilApp.getJsonValue("src/test/resources/jsonData/PolizaVidaLeyActivo.json","$['NumeroPoliza']");
        String cotizacion= Serenity.sessionVariableCalled("numeroCotizacionDeRenovacion");
        Target valor=Target.the("valorEstado").locatedBy("//tr[td/div[contains(text(),'{0}')] and td/div[contains(text(),'{1}')] and td/div[contains(text(),'{2}')]]/td[11]/div").of(cotizacion,nroPoliza,estado);
        String valorExtraido=valor.resolveFor(actor).getText().trim();

        actor.attemptsTo(
                WaitUntil.the(valor,isVisible()).forNoMoreThan(90).seconds()
        );

        if (valorExtraido.equals(estado)){
            return true;
        }else {
            return false;
        }

    }



}
