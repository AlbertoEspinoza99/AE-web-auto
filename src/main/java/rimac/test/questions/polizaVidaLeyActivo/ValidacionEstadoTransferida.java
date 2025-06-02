package rimac.test.questions.polizaVidaLeyActivo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidacionEstadoTransferida implements Question<String> {

    private final Target target;

    public ValidacionEstadoTransferida(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {

        String valor=target.resolveFor(actor).getText().trim();

        return valor;
    }

    public static ValidacionEstadoTransferida VLtransferencia(Target target){
        return new ValidacionEstadoTransferida(target);
    }


}
