package rimac.test.task.emisionPolizaWorksite;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.EmisionPolizaWORKSITE.EndosoMedioDeCobroUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class EndosoMedioCobroTask implements Task {

    private final String formaDePago;

    public EndosoMedioCobroTask(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public static EndosoMedioCobroTask endoso(String formaDePago){
        return Instrumented.instanceOf(EndosoMedioCobroTask.class).withProperties(formaDePago);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(EndosoMedioDeCobroUI.LBL_NUMERO_POLIZA,isVisible()).forNoMoreThan(90).seconds(),
                WaitUntil.the(EndosoMedioDeCobroUI.BTN_SELECCION_RESPONSABLE_PAGO,isVisible()).forNoMoreThan(90).seconds(),
                Pause.withDuration(2),
                Click.on(EndosoMedioDeCobroUI.BTN_SELECCION_RESPONSABLE_PAGO),
                WaitUntil.the(EndosoMedioDeCobroUI.BTN_EDITAR_RESPONSABLE_PAGO,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(EndosoMedioDeCobroUI.BTN_EDITAR_RESPONSABLE_PAGO),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(EndosoMedioDeCobroUI.INPUT_FORMA_DE_COBRO,isVisible()).forNoMoreThan(90).seconds(),
                Enter.theValue(formaDePago).into(EndosoMedioDeCobroUI.INPUT_FORMA_DE_COBRO),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(EndosoMedioDeCobroUI.DINAMICO_FORMA_DE_PAGO,formaDePago),
                WaitUntil.the(EndosoMedioDeCobroUI.BTN_GRABAR_MOVIMIENTO,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(EndosoMedioDeCobroUI.BTN_GRABAR_MOVIMIENTO),
                WaitUntil.the(EndosoMedioDeCobroUI.BTN_CONFIRMAR_MOVIMIENTO,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(EndosoMedioDeCobroUI.BTN_CONFIRMAR_MOVIMIENTO),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(EndosoMedioDeCobroUI.BTN_GRABADO_EXITOSO,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(EndosoMedioDeCobroUI.BTN_GRABADO_EXITOSO),
                WaitUntil.the(EndosoMedioDeCobroUI.BTN_SALIR_MANTENIMIENTO_REPONSABLE_PAGO,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(EndosoMedioDeCobroUI.BTN_SALIR_MANTENIMIENTO_REPONSABLE_PAGO)
        );


        Target btn_salir_endosoDatoGeneral01=EndosoMedioDeCobroUI.BTN_SALIR_ENDOSO_DATOS_GENERALES;
        Target btn_salir_endosoDatoGeneral02=EndosoMedioDeCobroUI.BTN_SALIR_ENDOSO_DATOS_GENERALES_VERSION02;

        if (btn_salir_endosoDatoGeneral01.resolveFor(actor).isCurrentlyVisible() && btn_salir_endosoDatoGeneral01.resolveFor(actor).isCurrentlyEnabled()){
            actor.attemptsTo(
                      WaitUntil.the(EndosoMedioDeCobroUI.BTN_SALIR_ENDOSO_DATOS_GENERALES,isVisible()).forNoMoreThan(90).seconds(),
                      JavaScriptClick.on(EndosoMedioDeCobroUI.BTN_SALIR_ENDOSO_DATOS_GENERALES)
            );
        }else if (btn_salir_endosoDatoGeneral02.resolveFor(actor).isCurrentlyVisible() && btn_salir_endosoDatoGeneral02.resolveFor(actor).isCurrentlyEnabled()){
            actor.attemptsTo(
                    WaitUntil.the(EndosoMedioDeCobroUI.BTN_SALIR_ENDOSO_DATOS_GENERALES_VERSION02,isVisible()).forNoMoreThan(90).seconds(),
                    JavaScriptClick.on(EndosoMedioDeCobroUI.BTN_SALIR_ENDOSO_DATOS_GENERALES_VERSION02)
            );
        }


        actor.attemptsTo(
                WaitUntil.the(EndosoMedioDeCobroUI.BTN_SALIR_EDITAR_CERTIFICADOS,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(EndosoMedioDeCobroUI.BTN_SALIR_EDITAR_CERTIFICADOS),
                WaitUntil.the(EndosoMedioDeCobroUI.BTN_SALIR_EDITAR_POLIZA,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(EndosoMedioDeCobroUI.BTN_SALIR_EDITAR_POLIZA),
                WaitUntil.the(EndosoMedioDeCobroUI.BTN_ACTUALIZAR,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(EndosoMedioDeCobroUI.BTN_ACTUALIZAR)
        );
    }



}
