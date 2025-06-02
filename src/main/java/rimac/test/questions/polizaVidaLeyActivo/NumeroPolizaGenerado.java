package rimac.test.questions.polizaVidaLeyActivo;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import rimac.test.utils.UtilApp;


public class NumeroPolizaGenerado implements Question<Boolean> {

    private final String target;
    private final String estado;

    public NumeroPolizaGenerado(String target, String estado) {
        this.target = target;
        this.estado = estado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String nroPoliza = UtilApp.getJsonValue("src/test/resources/jsonData/PolizaVidaLeyActivo.json","$['NumeroPoliza']");
        String resultado = nroPoliza.substring(nroPoliza.indexOf("|") + 1);
        Target valor=Target.the("valorCambiado").locatedBy("//tr[td/div[contains(text(),'{0}')] and td/div[contains(text(),'{1}')]]/td[11]/div").of(resultado,estado);
        String valorEstado=valor.resolveFor(actor).getText();

        if (valorEstado.equals(estado)){
            return true;
        }else{
            return false;
        }

    }

    public static NumeroPolizaGenerado validacion(String target,String estado){
        return Instrumented.instanceOf(NumeroPolizaGenerado.class).withProperties(target,estado);
    }



}
