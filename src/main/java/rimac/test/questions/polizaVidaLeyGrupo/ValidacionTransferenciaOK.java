package rimac.test.questions.polizaVidaLeyGrupo;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.userinterfaces.PolizaVidaLeyGrupo.ValidacionEstadoMovimientoRenovacionUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionTransferenciaOK implements Question<Boolean> {

    private final String estadoTransferencia;
    private final String TipoMovimiento;

    public ValidacionTransferenciaOK(String estadoTransferencia, String tipoMovimiento) {
        this.estadoTransferencia = estadoTransferencia;
        TipoMovimiento = tipoMovimiento;
    }

    public static ValidacionTransferenciaOK valida(String estadoTransferencia, String tipoMovimiento){
        return Instrumented.instanceOf(ValidacionTransferenciaOK.class).withProperties(estadoTransferencia,tipoMovimiento);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        Target valorDinamico=Target.the("RegistroMovimiento").locatedBy(ValidacionEstadoMovimientoRenovacionUI.DINAMICO_REGISTRO_MOVIMIENTO).of(estadoTransferencia,TipoMovimiento);

        if (valorDinamico.resolveFor(actor).isCurrentlyVisible() && valorDinamico.resolveFor(actor).isCurrentlyEnabled()){

            String valor=valorDinamico.resolveFor(actor).getText().trim();

            if (valor.equals(estadoTransferencia)){

                actor.attemptsTo(
                        WaitUntil.the(ValidacionEstadoMovimientoRenovacionUI.BTN_SALIR_EDITAR,isVisible()).forNoMoreThan(50).seconds(),
                        JavaScriptClick.on(ValidacionEstadoMovimientoRenovacionUI.BTN_SALIR_EDITAR)
                );

                return true;
            }else {
                return false;
            }

        }else {
            return false;
        }

    }



}
